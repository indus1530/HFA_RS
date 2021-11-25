package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

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
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH32Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionH32Activity extends AppCompatActivity {

    ActivitySectionH32Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h32);
        bi.setCallback(this);

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
            startActivity(new Intent(this, SectionH33Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, MainApp.fc.getsH());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();


        json.put("h0301n0a", bi.h0301n0ay.isChecked() ? "1"
                : bi.h0301n0an.isChecked() ? "2"
                : "-1");

        json.put("h0301n0b", bi.h0301n0by.isChecked() ? "1"
                : bi.h0301n0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301n0c", bi.h0301n0cy.isChecked() ? "1"
                : bi.h0301n0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301o0a", bi.h0301o0ay.isChecked() ? "1"
                : bi.h0301o0an.isChecked() ? "2"
                : "-1");

        json.put("h0301o0b", bi.h0301o0by.isChecked() ? "1"
                : bi.h0301o0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301o0c", bi.h0301o0cy.isChecked() ? "1"
                : bi.h0301o0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301p0a", bi.h0301p0ay.isChecked() ? "1"
                : bi.h0301p0an.isChecked() ? "2"
                : "-1");

        json.put("h0301p0b", bi.h0301p0by.isChecked() ? "1"
                : bi.h0301p0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301p0c", bi.h0301p0cy.isChecked() ? "1"
                : bi.h0301p0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301q0a", bi.h0301q0ay.isChecked() ? "1"
                : bi.h0301q0an.isChecked() ? "2"
                : "-1");

        json.put("h0301q0b", bi.h0301q0by.isChecked() ? "1"
                : bi.h0301q0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301q0c", bi.h0301q0cy.isChecked() ? "1"
                : bi.h0301q0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301r0a", bi.h0301r0ay.isChecked() ? "1"
                : bi.h0301r0an.isChecked() ? "2"
                : "-1");

        json.put("h0301r0b", bi.h0301r0by.isChecked() ? "1"
                : bi.h0301r0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301r0c", bi.h0301r0cy.isChecked() ? "1"
                : bi.h0301r0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301s0a", bi.h0301s0ay.isChecked() ? "1"
                : bi.h0301s0an.isChecked() ? "2"
                : "-1");

        json.put("h0301s0b", bi.h0301s0by.isChecked() ? "1"
                : bi.h0301s0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301s0c", bi.h0301s0cy.isChecked() ? "1"
                : bi.h0301s0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301t0a", bi.h0301t0ay.isChecked() ? "1"
                : bi.h0301t0an.isChecked() ? "2"
                : "-1");

        json.put("h0301t0b", bi.h0301t0by.isChecked() ? "1"
                : bi.h0301t0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301t0c", bi.h0301t0cy.isChecked() ? "1"
                : bi.h0301t0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301u0a", bi.h0301u0ay.isChecked() ? "1"
                : bi.h0301u0an.isChecked() ? "2"
                : "-1");

        json.put("h0301u0b", bi.h0301u0by.isChecked() ? "1"
                : bi.h0301u0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301u0c", bi.h0301u0cy.isChecked() ? "1"
                : bi.h0301u0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301v0a", bi.h0301v0ay.isChecked() ? "1"
                : bi.h0301v0an.isChecked() ? "2"
                : "-1");

        json.put("h0301v0b", bi.h0301v0by.isChecked() ? "1"
                : bi.h0301v0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301v0c", bi.h0301v0cy.isChecked() ? "1"
                : bi.h0301v0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301w0a", bi.h0301w0ay.isChecked() ? "1"
                : bi.h0301w0an.isChecked() ? "2"
                : "-1");

        json.put("h0301w0b", bi.h0301w0by.isChecked() ? "1"
                : bi.h0301w0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301w0c", bi.h0301w0cy.isChecked() ? "1"
                : bi.h0301w0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301x0a", bi.h0301x0ay.isChecked() ? "1"
                : bi.h0301x0an.isChecked() ? "2"
                : "-1");

        json.put("h0301x0b", bi.h0301x0by.isChecked() ? "1"
                : bi.h0301x0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301x0c", bi.h0301x0cy.isChecked() ? "1"
                : bi.h0301x0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301y0a", bi.h0301y0ay.isChecked() ? "1"
                : bi.h0301y0an.isChecked() ? "2"
                : "-1");

        json.put("h0301y0b", bi.h0301y0by.isChecked() ? "1"
                : bi.h0301y0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301y0c", bi.h0301y0cy.isChecked() ? "1"
                : bi.h0301y0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301z0a", bi.h0301z0ay.isChecked() ? "1"
                : bi.h0301z0an.isChecked() ? "2"
                : "-1");

        json.put("h0301z0b", bi.h0301z0by.isChecked() ? "1"
                : bi.h0301z0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301z0c", bi.h0301z0cy.isChecked() ? "1"
                : bi.h0301z0cn.isChecked() ? "2"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsH()), json);

            fc.setsH(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "H");
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
