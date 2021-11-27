package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH16Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;

public class SectionH16Activity extends AppCompatActivity {

    ActivitySectionH16Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h16);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        bi.h1601.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1601a.getId() || i == bi.h1601b.getId()) {
                Clear.clearAllFields(bi.fldGrpSech1601);
                Clear.clearAllFields(bi.fldGrpCVh1605);
            }
        }));

    }


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
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

        json.put("h1601", bi.h1601a.isChecked() ? "1"
                : bi.h1601b.isChecked() ? "2"
                : "-1");

        json.put("h1602", bi.h1602a.isChecked() ? "1"
                : bi.h1602b.isChecked() ? "2"
                : bi.h1602c.isChecked() ? "3"
                : bi.h1602x.isChecked() ? "96"
                : "-1");
        json.put("h1602xx", bi.h1602xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1602xx.getText().toString());

        json.put("h1603", bi.h1603a.isChecked() ? "1"
                : bi.h1603b.isChecked() ? "2"
                : bi.h1603c.isChecked() ? "3"
                : bi.h1603x.isChecked() ? "96"
                : "-1");
        json.put("h1603xx", bi.h1603xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1603xx.getText().toString());

        json.put("h1604", bi.h1604a.isChecked() ? "1"
                : bi.h1604b.isChecked() ? "2"
                : "-1");

        json.put("h1605", bi.h1605a.isChecked() ? "1"
                : bi.h1605b.isChecked() ? "2"
                : bi.h1605c.isChecked() ? "3"
                : bi.h1605d.isChecked() ? "4"
                : bi.h1605e.isChecked() ? "5"
                : bi.h1605x.isChecked() ? "96"
                : "-1");
        json.put("h1605xx", bi.h1605xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1605xx.getText().toString());

        MainApp.fc.setsH(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH16);
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
