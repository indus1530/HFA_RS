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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE1Binding;

public class SectionE1Activity extends AppCompatActivity {

    ActivitySectionE1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0101.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0101b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece101);
            }
        }));


        bi.e0104a.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.ll04c04e);
        }));


        /*bi.e0104b.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.ll04c04e);
        }));*/

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

        json.put("EDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("ETime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("e0101", bi.e0101a.isChecked() ? "1"
                : bi.e0101b.isChecked() ? "2"
                : "-1");

        json.put("e0102a", bi.e0102aa.isChecked() ? "1"
                : bi.e0102ab.isChecked() ? "2"
                : "-1");

        json.put("e0102b", bi.e0102ba.isChecked() ? "1"
                : bi.e0102bb.isChecked() ? "2"
                : "-1");

        json.put("e0102c", bi.e0102ca.isChecked() ? "1"
                : bi.e0102cb.isChecked() ? "2"
                : "-1");

        json.put("e0102d", bi.e0102da.isChecked() ? "1"
                : bi.e0102db.isChecked() ? "2"
                : "-1");

        json.put("e0102e", bi.e0102ea.isChecked() ? "1"
                : bi.e0102eb.isChecked() ? "2"
                : "-1");

        json.put("e0102f", bi.e0102fa.isChecked() ? "1"
                : bi.e0102fb.isChecked() ? "2"
                : "-1");

        json.put("e0102g", bi.e0102ga.isChecked() ? "1"
                : bi.e0102gb.isChecked() ? "2"
                : "-1");

        json.put("e0102h", bi.e0102ha.isChecked() ? "1"
                : bi.e0102hb.isChecked() ? "2"
                : "-1");

        json.put("e0102i", bi.e0102ia.isChecked() ? "1"
                : bi.e0102ib.isChecked() ? "2"
                : "-1");

        json.put("e0102j", bi.e0102ja.isChecked() ? "1"
                : bi.e0102jb.isChecked() ? "2"
                : "-1");

        json.put("e0103a", bi.e0103aa.isChecked() ? "1"
                : bi.e0103ab.isChecked() ? "2"
                : bi.e0103ac.isChecked() ? "3"
                : "-1");

        json.put("e0103b", bi.e0103ba.isChecked() ? "1"
                : bi.e0103bb.isChecked() ? "2"
                : bi.e0103bc.isChecked() ? "3"
                : "-1");

        json.put("e0104a", bi.e0104aa.isChecked() ? "1"
                : bi.e0104ab.isChecked() ? "2"
                : "-1");

        json.put("e0104b", bi.e0104ba.isChecked() ? "1"
                : bi.e0104bb.isChecked() ? "2"
                : "-1");

        json.put("e0104c", bi.e0104c.getText().toString().trim().isEmpty() ? "-1" : bi.e0104c.getText().toString());

        json.put("e0104d", bi.e0104d.getText().toString().trim().isEmpty() ? "-1" : bi.e0104d.getText().toString());

        json.put("e0104e", bi.e0104ea.isChecked() ? "1"
                : bi.e0104ex.isChecked() ? "2"
                : "-1");
        json.put("e0104exx", bi.e0104exx.getText().toString().trim().isEmpty() ? "-1" : bi.e0104exx.getText().toString());

        MainApp.fc.setsE(String.valueOf(json));

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
            startActivity(new Intent(this, SectionE2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "E");
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
