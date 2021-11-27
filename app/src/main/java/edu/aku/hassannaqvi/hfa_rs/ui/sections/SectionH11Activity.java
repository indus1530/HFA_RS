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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH11Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionH11Activity extends AppCompatActivity {

    ActivitySectionH11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h11);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.h1102.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSech1101);
        }));

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
            startActivity(new Intent(this, SectionH12Activity.class));
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

        json.put("h1101", bi.h1101a.isChecked() ? "1"
                : bi.h1101b.isChecked() ? "2"
                : "-1");

        json.put("h1102", bi.h1102a.isChecked() ? "1"
                : bi.h1102b.isChecked() ? "2"
                : "-1");

        json.put("h1103", bi.h1103a.isChecked() ? "1"
                : bi.h1103b.isChecked() ? "2"
                : bi.h1103c.isChecked() ? "3"
                : bi.h1103d.isChecked() ? "4"
                : bi.h1103e.isChecked() ? "5"
                : bi.h1103f.isChecked() ? "6"
                : "-1");

        json.put("h1104", bi.h1104a.isChecked() ? "1"
                : bi.h1104b.isChecked() ? "2"
                : bi.h1104c.isChecked() ? "3"
                : bi.h1104d.isChecked() ? "4"
                : bi.h1104e.isChecked() ? "5"
                : bi.h1104f.isChecked() ? "6"
                : "-1");

        json.put("h1105", bi.h1105a.isChecked() ? "1"
                : bi.h1105b.isChecked() ? "2"
                : "-1");

        json.put("h1106", bi.h1106a.isChecked() ? "1"
                : bi.h1106b.isChecked() ? "2"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsH()), json);

            fc.setsH(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH11);
    }


    public void BtnEnd(View v) {
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
