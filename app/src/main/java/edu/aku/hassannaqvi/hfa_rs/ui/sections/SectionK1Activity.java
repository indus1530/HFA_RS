package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK1Binding;

public class SectionK1Activity extends AppCompatActivity {

    ActivitySectionK1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.k101.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVk102);
            Clear.clearAllFields(bi.fldGrpCVk103);
            Clear.clearAllFields(bi.fldGrpCVk104);
            bi.fldGrpCVk102.setVisibility(View.GONE);
            bi.fldGrpCVk103.setVisibility(View.GONE);
            bi.fldGrpCVk104.setVisibility(View.GONE);
            if (i == bi.k101a.getId()) {
                bi.fldGrpCVk102.setVisibility(View.VISIBLE);
                bi.fldGrpCVk103.setVisibility(View.VISIBLE);
            } else {
                bi.fldGrpCVk104.setVisibility(View.VISIBLE);
            }
        }));

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
            //startActivity(new Intent(this, bi.k0001b.isChecked() ? SectionK7Activity.class : SectionK2Activity.class));
            startActivity(new Intent(this, SectionK2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "K");
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

        json.put("KDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("KTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("k101", bi.k101a.isChecked() ? "1"
                : bi.k101b.isChecked() ? "2"
                : "-1");

        json.put("k102", bi.k102a.isChecked() ? "1"
                : bi.k102b.isChecked() ? "2"
                : "-1");

        json.put("k1031", bi.k1031a.isChecked() ? "1"
                : bi.k1031b.isChecked() ? "2"
                : "-1");
        json.put("k1031ax", bi.k1031ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1031ax.getText().toString());

        json.put("k1032", bi.k1032a.isChecked() ? "1"
                : bi.k1032b.isChecked() ? "2"
                : "-1");
        json.put("k1032ax", bi.k1032ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1032ax.getText().toString());

        json.put("k1033", bi.k1033a.isChecked() ? "1"
                : bi.k1033b.isChecked() ? "2"
                : "-1");
        json.put("k1033ax", bi.k1033ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1033ax.getText().toString());

        json.put("k1034", bi.k1034a.isChecked() ? "1"
                : bi.k1034b.isChecked() ? "2"
                : "-1");
        json.put("k1034ax", bi.k1034ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1034ax.getText().toString());

        json.put("k1035", bi.k1035a.isChecked() ? "1"
                : bi.k1035b.isChecked() ? "2"
                : "-1");
        json.put("k1035ax", bi.k1035ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1035ax.getText().toString());

        json.put("k1036", bi.k1036a.isChecked() ? "1"
                : bi.k1036b.isChecked() ? "2"
                : "-1");
        json.put("k1036ax", bi.k1036ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1036ax.getText().toString());

        json.put("k1037", bi.k1037a.isChecked() ? "1"
                : bi.k1037b.isChecked() ? "2"
                : "-1");
        json.put("k1037ax", bi.k1037ax.getText().toString().trim().isEmpty() ? "-1" : bi.k1037ax.getText().toString());

        json.put("k10396", bi.k10396a.isChecked() ? "1"
                : bi.k10396b.isChecked() ? "2"
                : "-1");
        json.put("k10396ax", bi.k10396ax.getText().toString().trim().isEmpty() ? "-1" : bi.k10396ax.getText().toString());
        json.put("k10396x", bi.k10396x.getText().toString().trim().isEmpty() ? "-1" : bi.k10396x.getText().toString());

        json.put("k104", bi.k104a.isChecked() ? "1"
                : bi.k104b.isChecked() ? "2"
                : bi.k104c.isChecked() ? "3"
                : bi.k10497.isChecked() ? "97"
                : bi.k10496.isChecked() ? "96"
                : "-1");
        json.put("k10496x", bi.k10496x.getText().toString().trim().isEmpty() ? "-1" : bi.k10496x.getText().toString());

        json.put("k105", bi.k105a.isChecked() ? "1"
                : bi.k105b.isChecked() ? "2"
                : bi.k105c.isChecked() ? "3"
                : "-1");

        json.put("k106", bi.k106a.isChecked() ? "1"
                : bi.k106b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setsK(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
