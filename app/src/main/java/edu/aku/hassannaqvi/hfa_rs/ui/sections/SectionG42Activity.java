package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG42Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG42Activity extends AppCompatActivity {
    ActivitySectionG42Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g42);
        bi.setCallback(this);
    }



    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("g4201a", bi.g4201aa.isChecked() ? "1"
                : bi.g4201ab.isChecked() ? "2"
                : "-1");

        json.put("g4201b", bi.g4201ba.isChecked() ? "1"
                : bi.g4201bb.isChecked() ? "2"
                : "-1");

        json.put("g4201cd", bi.g4201cd.getText().toString().trim().length() > 0 ? bi.g4201cd.getText().toString() : "-1");
        json.put("g4201cm", bi.g4201cm.getText().toString().trim().length() > 0 ? bi.g4201cm.getText().toString() : "-1");


        json.put("g4202a", bi.g4202aa.isChecked() ? "1"
                : bi.g4202ab.isChecked() ? "2"
                : "-1");

        json.put("g4202b", bi.g4202ba.isChecked() ? "1"
                : bi.g4202bb.isChecked() ? "2"
                : "-1");

        json.put("g4202cd", bi.g4202cd.getText().toString().trim().length() > 0 ? bi.g4202cd.getText().toString() : "-1");
        json.put("g4202cm", bi.g4202cm.getText().toString().trim().length() > 0 ? bi.g4202cm.getText().toString() : "-1");


        json.put("g4203a", bi.g4203aa.isChecked() ? "1"
                : bi.g4203ab.isChecked() ? "2"
                : "-1");

        json.put("g4203b", bi.g4203ba.isChecked() ? "1"
                : bi.g4203bb.isChecked() ? "2"
                : "-1");

        json.put("g4203cd", bi.g4203cd.getText().toString().trim().length() > 0 ? bi.g4203cd.getText().toString() : "-1");
        json.put("g4203cm", bi.g4203cm.getText().toString().trim().length() > 0 ? bi.g4203cm.getText().toString() : "-1");


        json.put("g4204a", bi.g4204aa.isChecked() ? "1"
                : bi.g4204ab.isChecked() ? "2"
                : "-1");

        json.put("g4204b", bi.g4204ba.isChecked() ? "1"
                : bi.g4204bb.isChecked() ? "2"
                : "-1");

        json.put("g4204cd", bi.g4204cd.getText().toString().trim().length() > 0 ? bi.g4204cd.getText().toString() : "-1");
        json.put("g4204cm", bi.g4204cm.getText().toString().trim().length() > 0 ? bi.g4204cm.getText().toString() : "-1");


        json.put("g4205a", bi.g4205aa.isChecked() ? "1"
                : bi.g4205ab.isChecked() ? "2"
                : "-1");

        json.put("g4205b", bi.g4205ba.isChecked() ? "1"
                : bi.g4205bb.isChecked() ? "2"
                : "-1");

        json.put("g4205cd", bi.g4205cd.getText().toString().trim().length() > 0 ? bi.g4205cd.getText().toString() : "-1");
        json.put("g4205cm", bi.g4205cm.getText().toString().trim().length() > 0 ? bi.g4205cm.getText().toString() : "-1");


        json.put("g4206a", bi.g4206aa.isChecked() ? "1"
                : bi.g4206ab.isChecked() ? "2"
                : "-1");

        json.put("g4206b", bi.g4206ba.isChecked() ? "1"
                : bi.g4206bb.isChecked() ? "2"
                : "-1");

        json.put("g4206cd", bi.g4206cd.getText().toString().trim().length() > 0 ? bi.g4206cd.getText().toString() : "-1");
        json.put("g4206cm", bi.g4206cm.getText().toString().trim().length() > 0 ? bi.g4206cm.getText().toString() : "-1");


        json.put("g4207a", bi.g4207aa.isChecked() ? "1"
                : bi.g4207ab.isChecked() ? "2"
                : "-1");

        json.put("g4207b", bi.g4207ba.isChecked() ? "1"
                : bi.g4207bb.isChecked() ? "2"
                : "-1");

        json.put("g4207cd", bi.g4207cd.getText().toString().trim().isEmpty() ? "-1" : bi.g4207cd.getText().toString());
        json.put("g4207cm", bi.g4207cm.getText().toString().trim().isEmpty() ? "-1" : bi.g4207cm.getText().toString());


        json.put("g4208a", bi.g4208aa.isChecked() ? "1"
                : bi.g4208ab.isChecked() ? "2"
                : "-1");

        json.put("g4208b", bi.g4208ba.isChecked() ? "1"
                : bi.g4208bb.isChecked() ? "2"
                : "-1");

        json.put("g4208cd", bi.g4208cd.getText().toString().trim().length() > 0 ? bi.g4208cd.getText().toString() : "-1");
        json.put("g4208cm", bi.g4208cm.getText().toString().trim().length() > 0 ? bi.g4208cm.getText().toString() : "-1");


        json.put("g4209a", bi.g4209aa.isChecked() ? "1"
                : bi.g4209ab.isChecked() ? "2"
                : "-1");

        json.put("g4209b", bi.g4209ba.isChecked() ? "1"
                : bi.g4209bb.isChecked() ? "2"
                : "-1");

        json.put("g4209cd", bi.g4209cd.getText().toString().trim().length() > 0 ? bi.g4209cd.getText().toString() : "-1");
        json.put("g4209cm", bi.g4209cm.getText().toString().trim().length() > 0 ? bi.g4209cm.getText().toString() : "-1");


        json.put("g4210a", bi.g4210aa.isChecked() ? "1"
                : bi.g4210ab.isChecked() ? "2"
                : "-1");

        json.put("g4210b", bi.g4210ba.isChecked() ? "1"
                : bi.g4210bb.isChecked() ? "2"
                : "-1");

        json.put("g4210cd", bi.g4210cd.getText().toString().trim().length() > 0 ? bi.g4210cd.getText().toString() : "-1");
        json.put("g4210cm", bi.g4210cm.getText().toString().trim().length() > 0 ? bi.g4210cm.getText().toString() : "-1");


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsG()), json);

            MainApp.fc.setsG(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionG43Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
