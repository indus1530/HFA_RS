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

import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.PatientsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionI3Binding;


public class SectionI3Activity extends AppCompatActivity {

    ActivitySectionI3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i3);
        bi.setCallback(this);

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
            startActivity(new Intent(this, SectionI4Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesPSCColumn(PatientsContract.PatientsTable.COLUMN_SI3, psc.getsI3());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("i0301a", bi.i0301aa.isChecked() ? "1"
                : bi.i0301ab.isChecked() ? "2"
                : "-1");

        json.put("i0301b", bi.i0301ba.isChecked() ? "1"
                : bi.i0301bb.isChecked() ? "2"
                : "-1");

        json.put("i0301c", bi.i0301ca.isChecked() ? "1"
                : bi.i0301cb.isChecked() ? "2"
                : "-1");

        json.put("i0301d", bi.i0301da.isChecked() ? "1"
                : bi.i0301db.isChecked() ? "2"
                : "-1");

        json.put("i0301e", bi.i0301ea.isChecked() ? "1"
                : bi.i0301eb.isChecked() ? "2"
                : "-1");

        json.put("i0301f", bi.i0301fa.isChecked() ? "1"
                : bi.i0301fb.isChecked() ? "2"
                : "-1");

        json.put("i0301g", bi.i0301ga.isChecked() ? "1"
                : bi.i0301gb.isChecked() ? "2"
                : "-1");

        json.put("i0301h", bi.i0301ha.isChecked() ? "1"
                : bi.i0301hb.isChecked() ? "2"
                : "-1");

        json.put("i0301i", bi.i0301ia.isChecked() ? "1"
                : bi.i0301ib.isChecked() ? "2"
                : "-1");

        json.put("i0301j", bi.i0301ja.isChecked() ? "1"
                : bi.i0301jb.isChecked() ? "2"
                : "-1");

        json.put("i0301k", bi.i0301ka.isChecked() ? "1"
                : bi.i0301kb.isChecked() ? "2"
                : "-1");

        psc.setsI3(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd(View v) {
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
