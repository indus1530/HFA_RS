package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ5Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ5Activity extends AppCompatActivity {

    ActivitySectionJ5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j5);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0501a);
        radioGroup(bi.j0501b);
        radioGroup(bi.j0501c);
        radioGroup(bi.j0501d);
        radioGroup(bi.j0501e);
        radioGroup(bi.j0501f);
        radioGroup(bi.j0501g);
        radioGroup(bi.j0501h);
        radioGroup(bi.j0501i);
        radioGroup(bi.j0501j);
        radioGroup(bi.j0501k);
        radioGroup(bi.j0501l);
        radioGroup(bi.j0501m);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0501ab.isChecked() || bi.j0501bb.isChecked() || bi.j0501cb.isChecked()
                    || bi.j0501db.isChecked() || bi.j0501eb.isChecked() || bi.j0501fb.isChecked()
                    || bi.j0501gb.isChecked() || bi.j0501hb.isChecked() || bi.j0501ib.isChecked()
                    || bi.j0501jb.isChecked() || bi.j0501kb.isChecked() || bi.j0501lb.isChecked()
                    || bi.j0501mb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0501n);
                bi.fldGrpCVj0501n.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0501n);
                bi.fldGrpCVj0501n.setVisibility(View.GONE);
            }
        }));
    }


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            Intent intent;

            if (MainApp.fc.getA10().equals("2") && !MainApp.fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ8Activity.class);
            } else {
                intent = new Intent(this, SectionJ6Activity.class);
            }
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0500a", bi.j0500a.getText().toString().trim().length() > 0 ? bi.j0500a.getText().toString() : "-1");
        json.put("j0500b", bi.j0500b.getText().toString().trim().length() > 0 ? bi.j0500b.getText().toString() : "-1");

        json.put("j0500c", bi.j0500ca.isChecked() ? "1"
                : bi.j0500cb.isChecked() ? "2"
                : "-1");

        json.put("j0501a", bi.j0501aa.isChecked() ? "1"
                : bi.j0501ab.isChecked() ? "2"
                : "-1");

        json.put("j0501b", bi.j0501ba.isChecked() ? "1"
                : bi.j0501bb.isChecked() ? "2"
                : "-1");

        json.put("j0501c", bi.j0501ca.isChecked() ? "1"
                : bi.j0501cb.isChecked() ? "2"
                : "-1");

        json.put("j0501d", bi.j0501da.isChecked() ? "1"
                : bi.j0501db.isChecked() ? "2"
                : "-1");

        json.put("j0501e", bi.j0501ea.isChecked() ? "1"
                : bi.j0501eb.isChecked() ? "2"
                : "-1");

        json.put("j0501f", bi.j0501fa.isChecked() ? "1"
                : bi.j0501fb.isChecked() ? "2"
                : "-1");

        json.put("j0501g", bi.j0501ga.isChecked() ? "1"
                : bi.j0501gb.isChecked() ? "2"
                : "-1");

        json.put("j0501h", bi.j0501ha.isChecked() ? "1"
                : bi.j0501hb.isChecked() ? "2"
                : "-1");

        json.put("j0501i", bi.j0501ia.isChecked() ? "1"
                : bi.j0501ib.isChecked() ? "2"
                : "-1");

        json.put("j0501j", bi.j0501ja.isChecked() ? "1"
                : bi.j0501jb.isChecked() ? "2"
                : "-1");

        json.put("j0501k", bi.j0501ka.isChecked() ? "1"
                : bi.j0501kb.isChecked() ? "2"
                : "-1");

        json.put("j0501l", bi.j0501la.isChecked() ? "1"
                : bi.j0501lb.isChecked() ? "2"
                : "-1");

        json.put("j0501m", bi.j0501ma.isChecked() ? "1"
                : bi.j0501mb.isChecked() ? "2"
                : "-1");

        json.put("j0501na", bi.j0501na.isChecked() ? "1" : "-1");
        json.put("j0501nb", bi.j0501nb.isChecked() ? "2" : "-1");
        json.put("j0501nc", bi.j0501nc.isChecked() ? "3" : "-1");
        json.put("j0501nd", bi.j0501nd.isChecked() ? "4" : "-1");
        json.put("j0501ne", bi.j0501ne.isChecked() ? "5" : "-1");
        json.put("j0501nf", bi.j0501nf.isChecked() ? "6" : "-1");
        json.put("j0501nx", bi.j0501nx.isChecked() ? "96" : "-1");
        json.put("j0501nxx", bi.j0501nxx.getText().toString().trim().length() > 0 ? bi.j0501nxx.getText().toString() : "-1");

        if (fc.getsJ() != null) {

            try {
                JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsJ()), json);

                fc.setsJ(String.valueOf(json_merge));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            json.put("JDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
            json.put("JTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
            fc.setsJ(String.valueOf(json));
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ5);
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "J");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


    public void showTooltip(@NotNull View view) {
        if (view.getId() != View.NO_ID) {
            String package_name = getApplicationContext().getPackageName();
            String infoid = view.getResources().getResourceName(view.getId()).replace(package_name + ":id/q_", "");
            int stringRes = this.getResources().getIdentifier(infoid + "_info", "string", getApplicationContext().getPackageName());
            if (stringRes != 0) {
                String infoText = (String) getResources().getText(stringRes);

                new AlertDialog.Builder(this)
                        .setTitle("Info: " + infoid.toUpperCase())
                        .setMessage(infoText)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            } else {
                Toast.makeText(this, "No information available on this question.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No ID Associated with this question.", Toast.LENGTH_SHORT).show();

        }
    }
}
