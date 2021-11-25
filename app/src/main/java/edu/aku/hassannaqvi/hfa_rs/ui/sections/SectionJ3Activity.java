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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ3Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ3Activity extends AppCompatActivity {

    ActivitySectionJ3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j3);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0301a);
        radioGroup(bi.j0301b);
        radioGroup(bi.j0301c);
        radioGroup(bi.j0301d);
        radioGroup(bi.j0301e);
        radioGroup(bi.j0301f);
        radioGroup(bi.j0301g);
        radioGroup(bi.j0301h);
        radioGroup(bi.j0301i);
        radioGroup(bi.j0301j);
        radioGroup(bi.j0301k);
        radioGroup(bi.j0301l);
        radioGroup(bi.j0301m);
        radioGroup(bi.j0301n);
        radioGroup(bi.j0301o);
        radioGroup(bi.j0301p);
        radioGroup(bi.j0301q);
        radioGroup(bi.j0301r);
        radioGroup(bi.j0301s);
        radioGroup(bi.j0301t);
        radioGroup(bi.j0301u);
        radioGroup(bi.j0301v);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0301ab.isChecked() || bi.j0301bb.isChecked() || bi.j0301cb.isChecked()
                    || bi.j0301db.isChecked() || bi.j0301eb.isChecked() || bi.j0301fb.isChecked()
                    || bi.j0301gb.isChecked() || bi.j0301hb.isChecked() || bi.j0301ib.isChecked()
                    || bi.j0301jb.isChecked() || bi.j0301kb.isChecked() || bi.j0301lb.isChecked()
                    || bi.j0301mb.isChecked() || bi.j0301nb.isChecked() || bi.j0301ob.isChecked()
                    || bi.j0301pb.isChecked() || bi.j0301qb.isChecked() || bi.j0301rb.isChecked()
                    || bi.j0301sb.isChecked() || bi.j0301tb.isChecked() || bi.j0301ub.isChecked()
                    || bi.j0301vb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0301w);
                bi.fldGrpCVj0301w.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0301w);
                bi.fldGrpCVj0301w.setVisibility(View.GONE);
            }
        }));
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            Intent intent;

            if (MainApp.fc.getA10().equals("2") && !MainApp.fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ8Activity.class);
            } else {
                intent = new Intent(this, SectionJ4Activity.class);
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

        json.put("j0300a", bi.j0300a.getText().toString().trim().length() > 0 ? bi.j0300a.getText().toString() : "-1");
        json.put("j0300b", bi.j0300b.getText().toString().trim().length() > 0 ? bi.j0300b.getText().toString() : "-1");

        json.put("j0300c", bi.j0300ca.isChecked() ? "1"
                : bi.j0300cb.isChecked() ? "2"
                : "-1");

        json.put("j0301a", bi.j0301aa.isChecked() ? "1"
                : bi.j0301ab.isChecked() ? "2"
                : "-1");

        json.put("j0301b", bi.j0301ba.isChecked() ? "1"
                : bi.j0301bb.isChecked() ? "2"
                : "-1");

        json.put("j0301c", bi.j0301ca.isChecked() ? "1"
                : bi.j0301cb.isChecked() ? "2"
                : "-1");

        json.put("j0301d", bi.j0301da.isChecked() ? "1"
                : bi.j0301db.isChecked() ? "2"
                : "-1");

        json.put("j0301e", bi.j0301ea.isChecked() ? "1"
                : bi.j0301eb.isChecked() ? "2"
                : "-1");

        json.put("j0301f", bi.j0301fa.isChecked() ? "1"
                : bi.j0301fb.isChecked() ? "2"
                : "-1");

        json.put("j0301g", bi.j0301ga.isChecked() ? "1"
                : bi.j0301gb.isChecked() ? "2"
                : "-1");

        json.put("j0301h", bi.j0301ha.isChecked() ? "1"
                : bi.j0301hb.isChecked() ? "2"
                : "-1");

        json.put("j0301i", bi.j0301ia.isChecked() ? "1"
                : bi.j0301ib.isChecked() ? "2"
                : "-1");

        json.put("j0301j", bi.j0301ja.isChecked() ? "1"
                : bi.j0301jb.isChecked() ? "2"
                : "-1");

        json.put("j0301k", bi.j0301ka.isChecked() ? "1"
                : bi.j0301kb.isChecked() ? "2"
                : "-1");

        json.put("j0301l", bi.j0301la.isChecked() ? "1"
                : bi.j0301lb.isChecked() ? "2"
                : "-1");

        json.put("j0301m", bi.j0301ma.isChecked() ? "1"
                : bi.j0301mb.isChecked() ? "2"
                : "-1");

        json.put("j0301n", bi.j0301na.isChecked() ? "1"
                : bi.j0301nb.isChecked() ? "2"
                : "-1");

        json.put("j0301o", bi.j0301oa.isChecked() ? "1"
                : bi.j0301ob.isChecked() ? "2"
                : "-1");

        json.put("j0301p", bi.j0301pa.isChecked() ? "1"
                : bi.j0301pb.isChecked() ? "2"
                : "-1");

        json.put("j0301q", bi.j0301qa.isChecked() ? "1"
                : bi.j0301qb.isChecked() ? "2"
                : "-1");

        json.put("j0301r", bi.j0301ra.isChecked() ? "1"
                : bi.j0301rb.isChecked() ? "2"
                : "-1");

        json.put("j0301s", bi.j0301sa.isChecked() ? "1"
                : bi.j0301sb.isChecked() ? "2"
                : "-1");

        json.put("j0301t", bi.j0301ta.isChecked() ? "1"
                : bi.j0301tb.isChecked() ? "2"
                : "-1");

        json.put("j0301u", bi.j0301ua.isChecked() ? "1"
                : bi.j0301ub.isChecked() ? "2"
                : "-1");

        json.put("j0301v", bi.j0301va.isChecked() ? "1"
                : bi.j0301vb.isChecked() ? "2"
                : "-1");

        json.put("j0301wa", bi.j0301wa.isChecked() ? "1" : "-1");
        json.put("j0301wb", bi.j0301wb.isChecked() ? "2" : "-1");
        json.put("j0301wc", bi.j0301wc.isChecked() ? "3" : "-1");
        json.put("j0301wd", bi.j0301wd.isChecked() ? "4" : "-1");
        json.put("j0301we", bi.j0301we.isChecked() ? "5" : "-1");
        json.put("j0301wf", bi.j0301wf.isChecked() ? "6" : "-1");
        json.put("j0301wx", bi.j0301wx.isChecked() ? "96" : "-1");
        json.put("j0301wxx", bi.j0301wxx.getText().toString().trim().length() > 0 ? bi.j0301wxx.getText().toString() : "-1");

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
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionj3);
    }


    public void BtnEnd() {
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
