package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.psc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivityI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.PatientsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionI2Binding;


public class SectionI2Activity extends AppCompatActivity {

    ActivitySectionI2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i2);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        //i0201je
        bi.i0201je.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                Clear.clearAllFields(bi.i0201jcheck, false);
                bi.i0201jcheck.setTag("-1");
            } else {
                Clear.clearAllFields(bi.i0201jcheck, true);
                bi.i0201jcheck.setTag("0");
            }
        });

        bi.i0201o.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.i0201ob.getId()) {
                Clear.clearAllFields(bi.fldGrpCVi0201p);
            }
        }));

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionI4Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesPSCColumn(PatientsContract.PatientsTable.COLUMN_SI2, psc.getsI2());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("i0201a", bi.i0201aa.isChecked() ? "1"
                : bi.i0201ab.isChecked() ? "2"
                : "-1");

        json.put("i0201b", bi.i0201ba.isChecked() ? "1"
                : bi.i0201bb.isChecked() ? "2"
                : "-1");

        json.put("i0201c", bi.i0201ca.isChecked() ? "1"
                : bi.i0201cb.isChecked() ? "2"
                : "-1");

        json.put("i0201d", bi.i0201da.isChecked() ? "1"
                : bi.i0201db.isChecked() ? "2"
                : "-1");

        json.put("i0201e", bi.i0201ea.isChecked() ? "1"
                : bi.i0201eb.isChecked() ? "2"
                : "-1");

        json.put("i0201f", bi.i0201fa.isChecked() ? "1"
                : bi.i0201fb.isChecked() ? "2"
                : "-1");

        json.put("i0201g", bi.i0201ga.isChecked() ? "1"
                : bi.i0201gb.isChecked() ? "2"
                : "-1");

        json.put("i0201h", bi.i0201ha.isChecked() ? "1"
                : bi.i0201hb.isChecked() ? "2"
                : "-1");

        json.put("i0201i", bi.i0201ia.isChecked() ? "1"
                : bi.i0201ib.isChecked() ? "2"
                : bi.i0201ic.isChecked() ? "3"
                : "-1");

        json.put("i0201ja", bi.i0201ja.isChecked() ? "1" : "-1");
        json.put("i0201jb", bi.i0201jb.isChecked() ? "2" : "-1");
        json.put("i0201jc", bi.i0201jc.isChecked() ? "3" : "-1");
        json.put("i0201jd", bi.i0201jd.isChecked() ? "4" : "-1");
        json.put("i0201je", bi.i0201je.isChecked() ? "5" : "-1");

        json.put("i0201k", bi.i0201ka.isChecked() ? "1"
                : bi.i0201kb.isChecked() ? "2"
                : bi.i0201kc.isChecked() ? "3"
                : "-1");

        json.put("i0201la", bi.i0201la.isChecked() ? "1" : "-1");
        json.put("i0201lb", bi.i0201lb.isChecked() ? "2" : "-1");
        json.put("i0201lc", bi.i0201lc.isChecked() ? "3" : "-1");

        json.put("i0201m", bi.i0201ma.isChecked() ? "1"
                : bi.i0201mb.isChecked() ? "2"
                : "-1");

        json.put("i0201n", bi.i0201na.isChecked() ? "1"
                : bi.i0201nb.isChecked() ? "2"
                : "-1");

        json.put("i0201o", bi.i0201oa.isChecked() ? "1"
                : bi.i0201ob.isChecked() ? "2"
                : "-1");

        json.put("i0201pa", bi.i0201pa.isChecked() ? "1" : "-1");
        json.put("i0201pb", bi.i0201pb.isChecked() ? "2" : "-1");
        json.put("i0201pc", bi.i0201pc.isChecked() ? "3" : "-1");
        json.put("i0201pd", bi.i0201pd.isChecked() ? "4" : "-1");
        json.put("i0201pe", bi.i0201pe.isChecked() ? "5" : "-1");
        json.put("i0201pf", bi.i0201pf.isChecked() ? "6" : "-1");

        json.put("i0201q", bi.i0201qa.isChecked() ? "1"
                : bi.i0201qb.isChecked() ? "2"
                : "-1");

        psc.setsI2(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        openSectionMainActivityI(this);
        /*openEndActivity(this, true);*/
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
            //String infoText = (String) getResources().getText(stringRes);
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
