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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG411Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG411Activity extends AppCompatActivity {

    ActivitySectionG411Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g411);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {
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


        json.put("g401a", bi.g401aa.isChecked() ? "1"
                : bi.g401ab.isChecked() ? "2"
                : "-1");

        json.put("g401b", bi.g401ba.isChecked() ? "1"
                : bi.g401bb.isChecked() ? "2"
                : "-1");

        json.put("g401cd", bi.g401cd.getText().toString().trim().length() > 0 ? bi.g401cd.getText().toString() : "-1");
        json.put("g401cm", bi.g401cm.getText().toString().trim().length() > 0 ? bi.g401cm.getText().toString() : "-1");


        json.put("g402a", bi.g402aa.isChecked() ? "1"
                : bi.g402ab.isChecked() ? "2"
                : "-1");

        json.put("g402b", bi.g402ba.isChecked() ? "1"
                : bi.g402bb.isChecked() ? "2"
                : "-1");

        json.put("g402cd", bi.g402cd.getText().toString().trim().length() > 0 ? bi.g402cd.getText().toString() : "-1");
        json.put("g402cm", bi.g402cm.getText().toString().trim().length() > 0 ? bi.g402cm.getText().toString() : "-1");


        json.put("g04013", bi.g04013a.isChecked() ? "1"
                : bi.g04013b.isChecked() ? "2"
                : "-1");


        json.put("g403a", bi.g403aa.isChecked() ? "1"
                : bi.g403ab.isChecked() ? "2"
                : "-1");

        json.put("g403b", bi.g403ba.isChecked() ? "1"
                : bi.g403bb.isChecked() ? "2"
                : "-1");

        json.put("g403cd", bi.g403cd.getText().toString().trim().length() > 0 ? bi.g403cd.getText().toString() : "-1");
        json.put("g403cm", bi.g403cm.getText().toString().trim().length() > 0 ? bi.g403cm.getText().toString() : "-1");


        json.put("g404a", bi.g404aa.isChecked() ? "1"
                : bi.g404ab.isChecked() ? "2"
                : "-1");

        json.put("g404b", bi.g404ba.isChecked() ? "1"
                : bi.g404bb.isChecked() ? "2"
                : "-1");

        json.put("g404cd", bi.g404cd.getText().toString().trim().length() > 0 ? bi.g404cd.getText().toString() : "-1");
        json.put("g404cm", bi.g404cm.getText().toString().trim().length() > 0 ? bi.g404cm.getText().toString() : "-1");


        json.put("g405a", bi.g405aa.isChecked() ? "1"
                : bi.g405ab.isChecked() ? "2"
                : "-1");

        json.put("g405b", bi.g405ba.isChecked() ? "1"
                : bi.g405bb.isChecked() ? "2"
                : "-1");

        json.put("g405cd", bi.g405cd.getText().toString().trim().length() > 0 ? bi.g405cd.getText().toString() : "-1");
        json.put("g405cm", bi.g405cm.getText().toString().trim().length() > 0 ? bi.g405cm.getText().toString() : "-1");


        json.put("g406a", bi.g406aa.isChecked() ? "1"
                : bi.g406ab.isChecked() ? "2"
                : "-1");

        json.put("g406b", bi.g406ba.isChecked() ? "1"
                : bi.g406bb.isChecked() ? "2"
                : "-1");

        json.put("g406cd", bi.g406cd.getText().toString().trim().length() > 0 ? bi.g406cd.getText().toString() : "-1");
        json.put("g406cm", bi.g406cm.getText().toString().trim().length() > 0 ? bi.g406cm.getText().toString() : "-1");


        json.put("g407a", bi.g407aa.isChecked() ? "1"
                : bi.g407ab.isChecked() ? "2"
                : "-1");

        json.put("g407b", bi.g407ba.isChecked() ? "1"
                : bi.g407bb.isChecked() ? "2"
                : "-1");

        json.put("g407cd", bi.g407cd.getText().toString().trim().length() > 0 ? bi.g407cd.getText().toString() : "-1");
        json.put("g407cm", bi.g407cm.getText().toString().trim().length() > 0 ? bi.g407cm.getText().toString() : "-1");


        json.put("g408a", bi.g408aa.isChecked() ? "1"
                : bi.g408ab.isChecked() ? "2"
                : "-1");

        json.put("g408b", bi.g408ba.isChecked() ? "1"
                : bi.g408bb.isChecked() ? "2"
                : "-1");

        json.put("g408cd", bi.g408cd.getText().toString().trim().length() > 0 ? bi.g408cd.getText().toString() : "-1");
        json.put("g408cm", bi.g408cm.getText().toString().trim().length() > 0 ? bi.g408cm.getText().toString() : "-1");


        json.put("g409a", bi.g409aa.isChecked() ? "1"
                : bi.g409ab.isChecked() ? "2"
                : "-1");

        json.put("g409b", bi.g409ba.isChecked() ? "1"
                : bi.g409bb.isChecked() ? "2"
                : "-1");

        json.put("g409cd", bi.g409cd.getText().toString().trim().length() > 0 ? bi.g409cd.getText().toString() : "-1");
        json.put("g409cm", bi.g409cm.getText().toString().trim().length() > 0 ? bi.g409cm.getText().toString() : "-1");


        json.put("g410a", bi.g410aa.isChecked() ? "1"
                : bi.g410ab.isChecked() ? "2"
                : "-1");

        json.put("g410b", bi.g410ba.isChecked() ? "1"
                : bi.g410bb.isChecked() ? "2"
                : "-1");

        json.put("g410cd", bi.g410cd.getText().toString().trim().length() > 0 ? bi.g410cd.getText().toString() : "-1");
        json.put("g410cm", bi.g410cm.getText().toString().trim().length() > 0 ? bi.g410cm.getText().toString() : "-1");


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
            startActivity(new Intent(this, SectionG412Activity.class));
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
