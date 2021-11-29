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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH33Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionH33Activity extends AppCompatActivity {

    ActivitySectionH33Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h33);
        bi.setCallback(this);

    }


    public void btnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionH17Activity.class));
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


        json.put("h0301aa0a", bi.h0301aa0ay.isChecked() ? "1"
                : bi.h0301aa0an.isChecked() ? "2"
                : "-1");

        json.put("h0301aa0b", bi.h0301aa0by.isChecked() ? "1"
                : bi.h0301aa0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301aa0c", bi.h0301aa0cy.isChecked() ? "1"
                : bi.h0301aa0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301ab0a", bi.h0301ab0ay.isChecked() ? "1"
                : bi.h0301ab0an.isChecked() ? "2"
                : "-1");

        json.put("h0301ab0b", bi.h0301ab0by.isChecked() ? "1"
                : bi.h0301ab0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301ab0c", bi.h0301ab0cy.isChecked() ? "1"
                : bi.h0301ab0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301ac0a", bi.h0301ac0ay.isChecked() ? "1"
                : bi.h0301ac0an.isChecked() ? "2"
                : "-1");

        json.put("h0301ac0b", bi.h0301ac0by.isChecked() ? "1"
                : bi.h0301ac0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301ac0c", bi.h0301ac0cy.isChecked() ? "1"
                : bi.h0301ac0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301ad0a", bi.h0301ad0ay.isChecked() ? "1"
                : bi.h0301ad0an.isChecked() ? "2"
                : "-1");

        json.put("h0301ad0b", bi.h0301ad0by.isChecked() ? "1"
                : bi.h0301ad0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301ad0c", bi.h0301ad0cy.isChecked() ? "1"
                : bi.h0301ad0cn.isChecked() ? "2"
                : "-1");


        json.put("h0301ae0a", bi.h0301ae0ay.isChecked() ? "1"
                : bi.h0301ae0an.isChecked() ? "2"
                : "-1");

        json.put("h0301ae0b", bi.h0301ae0by.isChecked() ? "1"
                : bi.h0301ae0bn.isChecked() ? "2"
                : "-1");

        json.put("h0301ae0c", bi.h0301ae0cy.isChecked() ? "1"
                : bi.h0301ae0cn.isChecked() ? "2"
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


    public void btnEnd(View v) {
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
