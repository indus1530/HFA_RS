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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionD8Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionD8Activity extends AppCompatActivity {

    ActivitySectionD8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d8);
        bi.setCallback(this);

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SD, fc.getsD());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d0801a0a", bi.d0801a0ay.isChecked() ? "1"
                : bi.d0801a0an.isChecked() ? "2"
                : "-1");
        json.put("d0801a0fq", bi.d0801a0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801a0fq.getText().toString());


        json.put("d0801b0a", bi.d0801b0ay.isChecked() ? "1"
                : bi.d0801b0an.isChecked() ? "2"
                : "-1");
        json.put("d0801b0fq", bi.d0801b0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801b0fq.getText().toString());


        json.put("d0801c0a", bi.d0801c0ay.isChecked() ? "1"
                : bi.d0801c0an.isChecked() ? "2"
                : "-1");
        json.put("d0801c0fq", bi.d0801c0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801c0fq.getText().toString());


        json.put("d0801d0a", bi.d0801d0ay.isChecked() ? "1"
                : bi.d0801d0an.isChecked() ? "2"
                : "-1");
        json.put("d0801d0fq", bi.d0801d0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801d0fq.getText().toString());


        json.put("d0801e0a", bi.d0801e0ay.isChecked() ? "1"
                : bi.d0801e0an.isChecked() ? "2"
                : "-1");
        json.put("d0801e0fq", bi.d0801e0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801e0fq.getText().toString());


        json.put("d0801f0a", bi.d0801f0ay.isChecked() ? "1"
                : bi.d0801f0an.isChecked() ? "2"
                : "-1");
        json.put("d0801f0fq", bi.d0801f0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801f0fq.getText().toString());


        json.put("d0801g0a", bi.d0801g0ay.isChecked() ? "1"
                : bi.d0801g0an.isChecked() ? "2"
                : "-1");
        json.put("d0801g0fq", bi.d0801g0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801g0fq.getText().toString());


        json.put("d0801h0a", bi.d0801h0ay.isChecked() ? "1"
                : bi.d0801h0an.isChecked() ? "2"
                : "-1");
        json.put("d0801h0fq", bi.d0801h0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801h0fq.getText().toString());


        json.put("d0801i0a", bi.d0801i0ay.isChecked() ? "1"
                : bi.d0801i0an.isChecked() ? "2"
                : "-1");
        json.put("d0801i0fq", bi.d0801i0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801i0fq.getText().toString());


        json.put("d0801j0a", bi.d0801j0ay.isChecked() ? "1"
                : bi.d0801j0an.isChecked() ? "2"
                : "-1");
        json.put("d0801j0fq", bi.d0801j0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801j0fq.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsD()), json);

            fc.setsD(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "D");
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
