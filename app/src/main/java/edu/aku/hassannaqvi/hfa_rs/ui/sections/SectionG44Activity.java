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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG44Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG44Activity extends AppCompatActivity {
    ActivitySectionG44Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g44);
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

        json.put("g4401a", bi.g4401aa.isChecked() ? "1"
                : bi.g4401ab.isChecked() ? "2"
                : "-1");

        json.put("g4401b", bi.g4401ba.isChecked() ? "1"
                : bi.g4401bb.isChecked() ? "2"
                : "-1");

        json.put("g4401cd", bi.g4401cd.getText().toString().trim().length() > 0 ? bi.g4401cd.getText().toString() : "-1");
        json.put("g4401cm", bi.g4401cm.getText().toString().trim().length() > 0 ? bi.g4401cm.getText().toString() : "-1");


        json.put("g4402a", bi.g4402aa.isChecked() ? "1"
                : bi.g4402ab.isChecked() ? "2"
                : "-1");

        json.put("g4402b", bi.g4402ba.isChecked() ? "1"
                : bi.g4402bb.isChecked() ? "2"
                : "-1");

        json.put("g4402cd", bi.g4402cd.getText().toString().trim().length() > 0 ? bi.g4402cd.getText().toString() : "-1");
        json.put("g4402cm", bi.g4402cm.getText().toString().trim().length() > 0 ? bi.g4402cm.getText().toString() : "-1");


        json.put("g4403a", bi.g4403aa.isChecked() ? "1"
                : bi.g4403ab.isChecked() ? "2"
                : "-1");

        json.put("g4403b", bi.g4403ba.isChecked() ? "1"
                : bi.g4403bb.isChecked() ? "2"
                : "-1");

        json.put("g4403cd", bi.g4403cd.getText().toString().trim().length() > 0 ? bi.g4403cd.getText().toString() : "-1");
        json.put("g4403cm", bi.g4403cm.getText().toString().trim().length() > 0 ? bi.g4403cm.getText().toString() : "-1");


        json.put("g4404a", bi.g4404aa.isChecked() ? "1"
                : bi.g4404ab.isChecked() ? "2"
                : "-1");

        json.put("g4404b", bi.g4404ba.isChecked() ? "1"
                : bi.g4404bb.isChecked() ? "2"
                : "-1");

        json.put("g4404cd", bi.g4404cd.getText().toString().trim().length() > 0 ? bi.g4404cd.getText().toString() : "-1");
        json.put("g4404cm", bi.g4404cm.getText().toString().trim().length() > 0 ? bi.g4404cm.getText().toString() : "-1");


        json.put("g4405a", bi.g4405aa.isChecked() ? "1"
                : bi.g4405ab.isChecked() ? "2"
                : "-1");

        json.put("g4405b", bi.g4405ba.isChecked() ? "1"
                : bi.g4405bb.isChecked() ? "2"
                : "-1");

        json.put("g4405cd", bi.g4405cd.getText().toString().trim().length() > 0 ? bi.g4405cd.getText().toString() : "-1");
        json.put("g4405cm", bi.g4405cm.getText().toString().trim().length() > 0 ? bi.g4405cm.getText().toString() : "-1");


        json.put("g4406a", bi.g4406aa.isChecked() ? "1"
                : bi.g4406ab.isChecked() ? "2"
                : "-1");

        json.put("g4406b", bi.g4406ba.isChecked() ? "1"
                : bi.g4406bb.isChecked() ? "2"
                : "-1");

        json.put("g4406cd", bi.g4406cd.getText().toString().trim().length() > 0 ? bi.g4406cd.getText().toString() : "-1");
        json.put("g4406cm", bi.g4406cm.getText().toString().trim().length() > 0 ? bi.g4406cm.getText().toString() : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsG()), json);
            fc.setsG(String.valueOf(json_merge));
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
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
