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

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE2Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE2Activity extends AppCompatActivity {

    ActivitySectionE2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0201.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.ll0204d);
        }));


        bi.e0204a.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.ll04b04d);
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0201", bi.e0201a.isChecked() ? "1"
                : bi.e0201b.isChecked() ? "2"
                : "-1");

        json.put("e0202a", bi.e0202aa.isChecked() ? "1"
                : bi.e0202ab.isChecked() ? "2"
                : "-1");

        json.put("e0202b", bi.e0202ba.isChecked() ? "1"
                : bi.e0202bb.isChecked() ? "2"
                : "-1");

        json.put("e0202c", bi.e0202ca.isChecked() ? "1"
                : bi.e0202cb.isChecked() ? "2"
                : "-1");

        json.put("e0202d", bi.e0202da.isChecked() ? "1"
                : bi.e0202db.isChecked() ? "2"
                : "-1");

        json.put("e0202e", bi.e0202ea.isChecked() ? "1"
                : bi.e0202eb.isChecked() ? "2"
                : "-1");

        json.put("e0202f", bi.e0202fa.isChecked() ? "1"
                : bi.e0202fb.isChecked() ? "2"
                : "-1");

        json.put("e0203a", bi.e0203aa.isChecked() ? "1"
                : bi.e0203ab.isChecked() ? "2"
                : bi.e0203ac.isChecked() ? "3"
                : "-1");

        json.put("e0203b", bi.e0203ba.isChecked() ? "1"
                : bi.e0203bb.isChecked() ? "2"
                : bi.e0203bc.isChecked() ? "3"
                : "-1");

        json.put("e0204a", bi.e0204aa.isChecked() ? "1"
                : bi.e0204ab.isChecked() ? "2"
                : "-1");

        json.put("e0204b", bi.e0204b.getText().toString().trim().isEmpty() ? "-1" : bi.e0204b.getText().toString());

        json.put("e0204c", bi.e0204c.getText().toString().trim().isEmpty() ? "-1" : bi.e0204c.getText().toString());

        json.put("e0204d", bi.e0204da.isChecked() ? "1"
                : bi.e0204dx.isChecked() ? "96"
                : "-1");
        json.put("e0204dxx", bi.e0204dxx.getText().toString().trim().isEmpty() ? "-1" : bi.e0204dxx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsE()), json);

            fc.setsE(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, SectionE31Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "E");
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
