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


    public void btnContinue(View v) {
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

        json.put("k701", bi.k701a.isChecked() ? "1"
                : bi.k701b.isChecked() ? "2"
                : bi.k701c.isChecked() ? "3"
                : "-1");

        json.put("k702", bi.k702a.isChecked() ? "1"
                : bi.k702b.isChecked() ? "2"
                : bi.k702c.isChecked() ? "3"
                : "-1");

        json.put("k703", bi.k703a.isChecked() ? "1"
                : bi.k703b.isChecked() ? "2"
                : bi.k703c.isChecked() ? "3"
                : "-1");

        json.put("k704", bi.k704a.isChecked() ? "1"
                : bi.k704b.isChecked() ? "2"
                : bi.k704c.isChecked() ? "3"
                : "-1");

        json.put("k705", bi.k705a.isChecked() ? "1"
                : bi.k705b.isChecked() ? "2"
                : bi.k705c.isChecked() ? "3"
                : "-1");

        json.put("k706", bi.k706a.isChecked() ? "1"
                : bi.k706b.isChecked() ? "2"
                : bi.k706c.isChecked() ? "3"
                : "-1");

        json.put("k707", bi.k707a.isChecked() ? "1"
                : bi.k707b.isChecked() ? "2"
                : bi.k707c.isChecked() ? "3"
                : "-1");

        json.put("k708", bi.k708a.isChecked() ? "1"
                : bi.k708b.isChecked() ? "2"
                : bi.k708c.isChecked() ? "3"
                : "-1");

        json.put("k709", bi.k709a.isChecked() ? "1"
                : bi.k709b.isChecked() ? "2"
                : bi.k709c.isChecked() ? "3"
                : "-1");

        json.put("k710", bi.k710a.isChecked() ? "1"
                : bi.k710b.isChecked() ? "2"
                : bi.k710c.isChecked() ? "3"
                : "-1");

        json.put("k711", bi.k711a.isChecked() ? "1"
                : bi.k711b.isChecked() ? "2"
                : bi.k711c.isChecked() ? "3"
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


    public void btnEnd(View v) {
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
