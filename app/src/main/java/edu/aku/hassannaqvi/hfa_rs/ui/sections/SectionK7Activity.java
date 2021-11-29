package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK7Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK7Activity extends AppCompatActivity {

    ActivitySectionK7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k7);
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
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k0071", bi.k0071a.isChecked() ? "1"
                : bi.k0071b.isChecked() ? "2"
                : bi.k0071c.isChecked() ? "3"
                : "-1");

        json.put("k0072", bi.k0072a.isChecked() ? "1"
                : bi.k0072b.isChecked() ? "2"
                : bi.k0072c.isChecked() ? "3"
                : "-1");

        json.put("k0073", bi.k0073a.isChecked() ? "1"
                : bi.k0073b.isChecked() ? "2"
                : bi.k0073c.isChecked() ? "3"
                : "-1");

        json.put("k0074", bi.k0074a.isChecked() ? "1"
                : bi.k0074b.isChecked() ? "2"
                : bi.k0074c.isChecked() ? "3"
                : "-1");

        json.put("k0075", bi.k0075a.isChecked() ? "1"
                : bi.k0075b.isChecked() ? "2"
                : bi.k0075c.isChecked() ? "3"
                : "-1");

        json.put("k0076", bi.k0076a.isChecked() ? "1"
                : bi.k0076b.isChecked() ? "2"
                : bi.k0076c.isChecked() ? "3"
                : "-1");

        json.put("k0077", bi.k0077a.isChecked() ? "1"
                : bi.k0077b.isChecked() ? "2"
                : bi.k0077c.isChecked() ? "3"
                : "-1");

        json.put("k0078", bi.k0078a.isChecked() ? "1"
                : bi.k0078b.isChecked() ? "2"
                : bi.k0078c.isChecked() ? "3"
                : "-1");

        json.put("k0079", bi.k0079a.isChecked() ? "1"
                : bi.k0079b.isChecked() ? "2"
                : bi.k0079c.isChecked() ? "3"
                : "-1");

        json.put("k007010", bi.k007010a.isChecked() ? "1"
                : bi.k007010b.isChecked() ? "2"
                : bi.k007010c.isChecked() ? "3"
                : "-1");

        json.put("k007011", bi.k007011a.isChecked() ? "1"
                : bi.k007011b.isChecked() ? "2"
                : bi.k007011c.isChecked() ? "3"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "K");
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
