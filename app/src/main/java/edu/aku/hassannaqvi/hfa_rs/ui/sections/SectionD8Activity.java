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

        json.put("d0801a", bi.d0801aa.isChecked() ? "1"
                : bi.d0801ab.isChecked() ? "2"
                : "-1");
        json.put("d0801b", bi.d0801b.getText().toString().trim().isEmpty() ? "-1" : bi.d0801b.getText().toString());

        json.put("d0802a", bi.d0802aa.isChecked() ? "1"
                : bi.d0802ab.isChecked() ? "2"
                : "-1");
        json.put("d0802b", bi.d0802b.getText().toString().trim().isEmpty() ? "-1" : bi.d0802b.getText().toString());

        json.put("d0803a", bi.d0803aa.isChecked() ? "1"
                : bi.d0803ab.isChecked() ? "2"
                : "-1");
        json.put("d0803b", bi.d0803b.getText().toString().trim().isEmpty() ? "-1" : bi.d0803b.getText().toString());

        json.put("d0804a", bi.d0804aa.isChecked() ? "1"
                : bi.d0804ab.isChecked() ? "2"
                : "-1");
        json.put("d0804b", bi.d0804b.getText().toString().trim().isEmpty() ? "-1" : bi.d0804b.getText().toString());

        json.put("d0805a", bi.d0805aa.isChecked() ? "1"
                : bi.d0805ab.isChecked() ? "2"
                : "-1");
        json.put("d0805b", bi.d0805b.getText().toString().trim().isEmpty() ? "-1" : bi.d0805b.getText().toString());

        json.put("d0806a", bi.d0806aa.isChecked() ? "1"
                : bi.d0806ab.isChecked() ? "2"
                : "-1");
        json.put("d0806b", bi.d0806b.getText().toString().trim().isEmpty() ? "-1" : bi.d0806b.getText().toString());

        json.put("d0807a", bi.d0807aa.isChecked() ? "1"
                : bi.d0807ab.isChecked() ? "2"
                : "-1");
        json.put("d0807b", bi.d0807b.getText().toString().trim().isEmpty() ? "-1" : bi.d0807b.getText().toString());

        json.put("d0808a", bi.d0808aa.isChecked() ? "1"
                : bi.d0808ab.isChecked() ? "2"
                : "-1");
        json.put("d0808b", bi.d0808b.getText().toString().trim().isEmpty() ? "-1" : bi.d0808b.getText().toString());

        json.put("d0809a", bi.d0809aa.isChecked() ? "1"
                : bi.d0809ab.isChecked() ? "2"
                : "-1");
        json.put("d0809b", bi.d0809b.getText().toString().trim().isEmpty() ? "-1" : bi.d0809b.getText().toString());

        json.put("d0810a", bi.d0810aa.isChecked() ? "1"
                : bi.d0810ab.isChecked() ? "2"
                : "-1");
        json.put("d0810b", bi.d0810b.getText().toString().trim().isEmpty() ? "-1" : bi.d0810b.getText().toString());

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
            startActivity(new Intent(this, SectionMainActivity.class));
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
