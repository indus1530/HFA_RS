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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ2Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ2Activity extends AppCompatActivity {

    ActivitySectionJ2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j2);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0201a);
        radioGroup(bi.j0201b);
        radioGroup(bi.j0201c);
        radioGroup(bi.j0201d);
        radioGroup(bi.j0201e);
        radioGroup(bi.j0201f);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0201ab.isChecked() || bi.j0201bb.isChecked() || bi.j0201cb.isChecked()
                    || bi.j0201db.isChecked() || bi.j0201eb.isChecked() || bi.j0201fb.isChecked()) {
                Clear.clearAllFields(bi.cvj0201g);
                bi.cvj0201g.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.cvj0201g);
                bi.cvj0201g.setVisibility(View.GONE);
            }
        }));
    }


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            Intent intent;

            if (MainApp.fc.getA10().equals("2") && MainApp.fc.getDistrictType().equals("1") && MainApp.fc.getDistrictType().equals("2")) {
                intent = new Intent(this, SectionJ8Activity.class);
            } else {
                intent = new Intent(this, SectionJ3Activity.class);
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

        json.put("j0200a", bi.j0200a.getText().toString().trim().length() > 0 ? bi.j0200a.getText().toString() : "-1");
        json.put("j0200b", bi.j0200b.getText().toString().trim().length() > 0 ? bi.j0200b.getText().toString() : "-1");

        json.put("j0200c", bi.j0200ca.isChecked() ? "1"
                : bi.j0200cb.isChecked() ? "2"
                : "-1");

        json.put("j0201a", bi.j0201aa.isChecked() ? "1"
                : bi.j0201ab.isChecked() ? "2"
                : "-1");

        json.put("j0201b", bi.j0201ba.isChecked() ? "1"
                : bi.j0201bb.isChecked() ? "2"
                : "-1");

        json.put("j0201c", bi.j0201ca.isChecked() ? "1"
                : bi.j0201cb.isChecked() ? "2"
                : "-1");

        json.put("j0201d", bi.j0201da.isChecked() ? "1"
                : bi.j0201db.isChecked() ? "2"
                : "-1");

        json.put("j0201e", bi.j0201ea.isChecked() ? "1"
                : bi.j0201eb.isChecked() ? "2"
                : "-1");

        json.put("j0201f", bi.j0201fa.isChecked() ? "1"
                : bi.j0201fb.isChecked() ? "2"
                : "-1");

        json.put("j0201ga", bi.j0201ga.isChecked() ? "1" : "-1");
        json.put("j0201gb", bi.j0201gb.isChecked() ? "2" : "-1");
        json.put("j0201gc", bi.j0201gc.isChecked() ? "3" : "-1");
        json.put("j0201gd", bi.j0201gd.isChecked() ? "4" : "-1");
        json.put("j0201ge", bi.j0201ge.isChecked() ? "5" : "-1");
        json.put("j0201gf", bi.j0201gf.isChecked() ? "6" : "-1");
        json.put("j0201gx", bi.j0201gx.isChecked() ? "96" : "-1");
        json.put("j0201gxx", bi.j0201gxx.getText().toString().trim().length() > 0 ? bi.j0201gxx.getText().toString() : "-1");

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
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
