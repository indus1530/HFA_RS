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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH31Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionH31Activity extends AppCompatActivity {

    ActivitySectionH31Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h31);
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
            startActivity(new Intent(this, SectionH32Activity.class));
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

        json.put("h0301a0a", bi.h0301a0ay.isChecked() ? "1"
                : bi.h0301a0an.isChecked() ? "2"
                : "-1");

        json.put("h0301a0b", bi.h0301a0by.isChecked() ? "1"
                : bi.h0301a0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301a0c", bi.h0301a0cy.isChecked() ? "1"
                : bi.h0301a0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301b0a", bi.h0301b0ay.isChecked() ? "1"
                : bi.h0301b0an.isChecked() ? "2"
                : "-1");

        json.put("h0301b0b", bi.h0301b0by.isChecked() ? "1"
                : bi.h0301b0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301b0c", bi.h0301b0cy.isChecked() ? "1"
                : bi.h0301b0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301c0a", bi.h0301c0ay.isChecked() ? "1"
                : bi.h0301c0an.isChecked() ? "2"
                : "-1");

        json.put("h0301c0b", bi.h0301c0by.isChecked() ? "1"
                : bi.h0301c0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301c0c", bi.h0301c0cy.isChecked() ? "1"
                : bi.h0301c0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301d0a", bi.h0301d0ay.isChecked() ? "1"
                : bi.h0301d0an.isChecked() ? "2"
                : "-1");

        json.put("h0301d0b", bi.h0301d0by.isChecked() ? "1"
                : bi.h0301d0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301d0c", bi.h0301d0cy.isChecked() ? "1"
                : bi.h0301d0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301e0a", bi.h0301e0ay.isChecked() ? "1"
                : bi.h0301e0an.isChecked() ? "2"
                : "-1");

        json.put("h0301e0b", bi.h0301e0by.isChecked() ? "1"
                : bi.h0301e0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301e0c", bi.h0301e0cy.isChecked() ? "1"
                : bi.h0301e0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301f0a", bi.h0301f0ay.isChecked() ? "1"
                : bi.h0301f0an.isChecked() ? "2"
                : "-1");

        json.put("h0301f0b", bi.h0301f0by.isChecked() ? "1"
                : bi.h0301f0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301f0c", bi.h0301f0cy.isChecked() ? "1"
                : bi.h0301f0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301g0a", bi.h0301g0ay.isChecked() ? "1"
                : bi.h0301g0an.isChecked() ? "2"
                : "-1");

        json.put("h0301g0b", bi.h0301g0by.isChecked() ? "1"
                : bi.h0301g0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301g0c", bi.h0301g0cy.isChecked() ? "1"
                : bi.h0301g0cn.isChecked() ? "2"
                : "-1");

        json.put("h03011h0a", bi.h03011h0ay.isChecked() ? "1"
                : bi.h03011h0an.isChecked() ? "2"
                : "-1");

        json.put("h03011h0b", bi.h03011h0by.isChecked() ? "1"
                : bi.h03011h0bn.isChecked() ? "2"
                : "-1");

        json.put("h03011h0c", bi.h03011h0cy.isChecked() ? "1"
                : bi.h03011h0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301i0a", bi.h0301i0ay.isChecked() ? "1"
                : bi.h0301i0an.isChecked() ? "2"
                : "-1");

        json.put("h0301i0b", bi.h0301i0by.isChecked() ? "1"
                : bi.h0301i0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301i0c", bi.h0301i0cy.isChecked() ? "1"
                : bi.h0301i0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301j0a", bi.h0301j0ay.isChecked() ? "1"
                : bi.h0301j0an.isChecked() ? "2"
                : "-1");

        json.put("h0301j0b", bi.h0301j0by.isChecked() ? "1"
                : bi.h0301j0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301j0c", bi.h0301j0cy.isChecked() ? "1"
                : bi.h0301j0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301k0a", bi.h0301k0ay.isChecked() ? "1"
                : bi.h0301k0an.isChecked() ? "2"
                : "-1");

        json.put("h0301k0b", bi.h0301k0by.isChecked() ? "1"
                : bi.h0301k0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301k0c", bi.h0301k0cy.isChecked() ? "1"
                : bi.h0301k0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301l0a", bi.h0301l0ay.isChecked() ? "1"
                : bi.h0301l0an.isChecked() ? "2"
                : "-1");

        json.put("h0301l0b", bi.h0301l0by.isChecked() ? "1"
                : bi.h0301l0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301l0c", bi.h0301l0cy.isChecked() ? "1"
                : bi.h0301l0cn.isChecked() ? "2"
                : "-1");

        json.put("h0301m0a", bi.h0301m0ay.isChecked() ? "1"
                : bi.h0301m0an.isChecked() ? "2"
                : "-1");

        json.put("h0301m0b", bi.h0301m0by.isChecked() ? "1"
                : bi.h0301m0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301m0c", bi.h0301m0cy.isChecked() ? "1"
                : bi.h0301m0cn.isChecked() ? "2"
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
