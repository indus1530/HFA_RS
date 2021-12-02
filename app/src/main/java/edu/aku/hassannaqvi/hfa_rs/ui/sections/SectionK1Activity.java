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

       /* bi.k0001.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0001);
        }));*/

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

        json.put("k101", bi.k10101.isChecked() ? "1"
                : bi.k10102.isChecked() ? "2"
                : "-1");

        json.put("k101a", bi.k101a01.isChecked() ? "1"
                : bi.k101a02.isChecked() ? "2"
                : "-1");

        json.put("k101ba", bi.k101ba01.isChecked() ? "1"
                : bi.k101ba02.isChecked() ? "2"
                : "-1");

        json.put("k101ba03", bi.k101ba03.getText().toString());

        json.put("k101bb", bi.k101bb01.isChecked() ? "1"
                : bi.k101bb02.isChecked() ? "2"
                : "-1");

        json.put("k101bb03", bi.k101bb03.getText().toString());

        json.put("k101bc", bi.k101bc01.isChecked() ? "1"
                : bi.k101bc02.isChecked() ? "2"
                : "-1");

        json.put("k101bc03", bi.k101bc03.getText().toString());

        json.put("k101bd", bi.k101bd01.isChecked() ? "1"
                : bi.k101bd02.isChecked() ? "2"
                : "-1");

        json.put("k101bd03", bi.k101bd03.getText().toString());

        json.put("k101be", bi.k101be01.isChecked() ? "1"
                : bi.k101be02.isChecked() ? "2"
                : "-1");

        json.put("k101be03", bi.k101be03.getText().toString());

        json.put("k101bf", bi.k101bf01.isChecked() ? "1"
                : bi.k101bf02.isChecked() ? "2"
                : "-1");

        json.put("k101bf03", bi.k101bf03.getText().toString());

        json.put("k101bg", bi.k101bg01.isChecked() ? "1"
                : bi.k101bg02.isChecked() ? "2"
                : "-1");

        json.put("k101bg03", bi.k101bg03.getText().toString());

        json.put("k101b96", bi.k101b9601.isChecked() ? "1"
                : bi.k101b9602.isChecked() ? "2"
                : bi.k101b9603.isChecked() ? "96"
                : "-1");

        json.put("k101b9603x", bi.k101b9603x.getText().toString());
        json.put("k101b9604", bi.k101b9604.getText().toString());

        json.put("k102", bi.k10201.isChecked() ? "1"
                : bi.k10202.isChecked() ? "2"
                : bi.k10203.isChecked() ? "3"
                : bi.k10204.isChecked() ? "4"
                : bi.k10296.isChecked() ? "96"
                : "-1");

        json.put("k10296x", bi.k10296x.getText().toString());
        json.put("k103", bi.k10301.isChecked() ? "1"
                : bi.k10302.isChecked() ? "2"
                : bi.k10303.isChecked() ? "3"
                : "-1");

        json.put("k104", bi.k10401.isChecked() ? "1"
                : bi.k10402.isChecked() ? "2"
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
