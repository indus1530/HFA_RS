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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionD7Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionD7Activity extends AppCompatActivity {

    ActivitySectionD7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d7);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        if (MainApp.fc.getA10().equals("1")) {
            bi.lld0704.setVisibility(View.VISIBLE);
        }

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

        json.put("d0701", bi.d0701a.isChecked() ? "1"
                : bi.d0701b.isChecked() ? "2"
                : bi.d0701c.isChecked() ? "3"
                : bi.d0701x.isChecked() ? "96"
                : "-1");
        json.put("d0701xx", bi.d0701xx.getText().toString().trim().isEmpty() ? "-1" : bi.d0701xx.getText().toString());

        json.put("d0702", bi.d0702a.isChecked() ? "1"
                : bi.d0702b.isChecked() ? "2"
                : bi.d0702c.isChecked() ? "3"
                : bi.d0702d.isChecked() ? "4"
                : bi.d0702e.isChecked() ? "5"
                : bi.d0702x.isChecked() ? "96"
                : "-1");
        json.put("d0702xx", bi.d0702xx.getText().toString().trim().isEmpty() ? "-1" : bi.d0702xx.getText().toString());

        json.put("d0703", bi.d0703a.isChecked() ? "1"
                : bi.d0703b.isChecked() ? "2"
                : bi.d0703c.isChecked() ? "3"
                : bi.d0703x.isChecked() ? "98"
                : "-1");

        json.put("d0704a", bi.d0704aa.isChecked() ? "1"
                : bi.d0704ab.isChecked() ? "2"
                : "-1");

        json.put("d0704b", bi.d0704ba.isChecked() ? "1"
                : bi.d0704bb.isChecked() ? "2"
                : "-1");

        json.put("d0704c", bi.d0704ca.isChecked() ? "1"
                : bi.d0704cb.isChecked() ? "2"
                : "-1");

        json.put("d0704d", bi.d0704da.isChecked() ? "1"
                : bi.d0704db.isChecked() ? "2"
                : "-1");

        json.put("d0704e", bi.d0704ea.isChecked() ? "1"
                : bi.d0704eb.isChecked() ? "2"
                : "-1");

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


    public void btnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionD8Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
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
