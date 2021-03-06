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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionD4Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionD4Activity extends AppCompatActivity {

    ActivitySectionD4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d4);
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

        json.put("d0401", bi.d0401a.isChecked() ? "1"
                : bi.d0401b.isChecked() ? "2"
                : bi.d0401c.isChecked() ? "3"
                : bi.d0401d.isChecked() ? "4"
                : bi.d0401e.isChecked() ? "5"
                : bi.d0401f.isChecked() ? "6"
                : "-1");

        json.put("d0402", bi.d0402a.isChecked() ? "1"
                : bi.d0402b.isChecked() ? "2"
                : bi.d0402c.isChecked() ? "3"
                : bi.d0402d.isChecked() ? "4"
                : bi.d0402e.isChecked() ? "5"
                : bi.d0402f.isChecked() ? "6"
                : "-1");

        json.put("d0403", bi.d0403a.isChecked() ? "1"
                : bi.d0403b.isChecked() ? "2"
                : bi.d0403c.isChecked() ? "3"
                : "-1");

        json.put("d0404", bi.d0404a.isChecked() ? "1"
                : bi.d0404b.isChecked() ? "2"
                : bi.d0404c.isChecked() ? "3"
                : bi.d0404d.isChecked() ? "4"
                : "-1");

        json.put("d0405", bi.d0405a.isChecked() ? "1"
                : bi.d0405b.isChecked() ? "2"
                : "-1");

        json.put("d0406", bi.d0406a.isChecked() ? "1"
                : bi.d0406b.isChecked() ? "2"
                : "-1");

        json.put("d0407", bi.d0407a.isChecked() ? "1"
                : bi.d0407b.isChecked() ? "2"
                : "-1");

        json.put("d0408", bi.d0408a.isChecked() ? "1"
                : bi.d0408b.isChecked() ? "2"
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
            startActivity(new Intent(this, SectionD5Activity.class));
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
