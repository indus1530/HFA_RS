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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG41aBinding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG41AActivity extends AppCompatActivity {
    ActivitySectionG41aBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g41a);
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
        json.put("g411a", bi.g411aa.isChecked() ? "1"
                : bi.g411ab.isChecked() ? "2"
                : "-1");

        json.put("g411b", bi.g411ba.isChecked() ? "1"
                : bi.g411bb.isChecked() ? "2"
                : "-1");

        json.put("g411cd", bi.g411cd.getText().toString().trim().length() > 0 ? bi.g411cd.getText().toString() : "-1");
        json.put("g411cm", bi.g411cm.getText().toString().trim().length() > 0 ? bi.g411cm.getText().toString() : "-1");


        json.put("g412a", bi.g412aa.isChecked() ? "1"
                : bi.g412ab.isChecked() ? "2"
                : "-1");

        json.put("g412b", bi.g412ba.isChecked() ? "1"
                : bi.g412bb.isChecked() ? "2"
                : "-1");

        json.put("g412cd", bi.g412cd.getText().toString().trim().length() > 0 ? bi.g412cd.getText().toString() : "-1");
        json.put("g412cm", bi.g412cm.getText().toString().trim().length() > 0 ? bi.g412cm.getText().toString() : "-1");


        json.put("g413a", bi.g413aa.isChecked() ? "1"
                : bi.g413ab.isChecked() ? "2"
                : "-1");

        json.put("g413b", bi.g413ba.isChecked() ? "1"
                : bi.g413bb.isChecked() ? "2"
                : "-1");

        json.put("g413cd", bi.g413cd.getText().toString().trim().length() > 0 ? bi.g413cd.getText().toString() : "-1");
        json.put("g413cm", bi.g413cm.getText().toString().trim().length() > 0 ? bi.g413cm.getText().toString() : "-1");


        json.put("g414a", bi.g414aa.isChecked() ? "1"
                : bi.g414ab.isChecked() ? "2"
                : "-1");

        json.put("g414b", bi.g414ba.isChecked() ? "1"
                : bi.g414bb.isChecked() ? "2"
                : "-1");

        json.put("g414cd", bi.g414cd.getText().toString().trim().length() > 0 ? bi.g414cd.getText().toString() : "-1");
        json.put("g414cm", bi.g414cm.getText().toString().trim().length() > 0 ? bi.g414cm.getText().toString() : "-1");


        json.put("g415a", bi.g415aa.isChecked() ? "1"
                : bi.g415ab.isChecked() ? "2"
                : "-1");

        json.put("g415b", bi.g415ba.isChecked() ? "1"
                : bi.g415bb.isChecked() ? "2"
                : "-1");

        json.put("g415cd", bi.g415cd.getText().toString().trim().length() > 0 ? bi.g415cd.getText().toString() : "-1");
        json.put("g415cm", bi.g415cm.getText().toString().trim().length() > 0 ? bi.g415cm.getText().toString() : "-1");


        json.put("g416a", bi.g416aa.isChecked() ? "1"
                : bi.g416ab.isChecked() ? "2"
                : "-1");

        json.put("g416b", bi.g416ba.isChecked() ? "1"
                : bi.g416bb.isChecked() ? "2"
                : "-1");

        json.put("g416cd", bi.g416cd.getText().toString().trim().length() > 0 ? bi.g416cd.getText().toString() : "-1");
        json.put("g416cm", bi.g416cm.getText().toString().trim().length() > 0 ? bi.g416cm.getText().toString() : "-1");


        json.put("g417a", bi.g417aa.isChecked() ? "1"
                : bi.g417ab.isChecked() ? "2"
                : "-1");

        json.put("g417b", bi.g417ba.isChecked() ? "1"
                : bi.g417bb.isChecked() ? "2"
                : "-1");

        json.put("g417cd", bi.g417cd.getText().toString().trim().isEmpty() ? "-1" : bi.g417cd.getText().toString());
        json.put("g417cm", bi.g417cm.getText().toString().trim().isEmpty() ? "-1" : bi.g417cm.getText().toString());


        json.put("g419a", bi.g419aa.isChecked() ? "1"
                : bi.g419ab.isChecked() ? "2"
                : "-1");

        json.put("g419b", bi.g419ba.isChecked() ? "1"
                : bi.g419bb.isChecked() ? "2"
                : "-1");

        json.put("g419cd", bi.g419cd.getText().toString().trim().length() > 0 ? bi.g419cd.getText().toString() : "-1");
        json.put("g419cm", bi.g419cm.getText().toString().trim().length() > 0 ? bi.g419cm.getText().toString() : "-1");


        json.put("g420a", bi.g420aa.isChecked() ? "1"
                : bi.g420ab.isChecked() ? "2"
                : "-1");

        json.put("g420b", bi.g420ba.isChecked() ? "1"
                : bi.g420bb.isChecked() ? "2"
                : "-1");

        json.put("g420cd", bi.g420cd.getText().toString().trim().length() > 0 ? bi.g420cd.getText().toString() : "-1");
        json.put("g420cm", bi.g420cm.getText().toString().trim().length() > 0 ? bi.g420cm.getText().toString() : "-1");


        json.put("g421a", bi.g421aa.isChecked() ? "1"
                : bi.g421ab.isChecked() ? "2"
                : "-1");

        json.put("g421b", bi.g421ba.isChecked() ? "1"
                : bi.g421bb.isChecked() ? "2"
                : "-1");

        json.put("g421cd", bi.g421cd.getText().toString().trim().length() > 0 ? bi.g421cd.getText().toString() : "-1");
        json.put("g421cm", bi.g421cm.getText().toString().trim().length() > 0 ? bi.g421cm.getText().toString() : "-1");


        json.put("g422a", bi.g422aa.isChecked() ? "1"
                : bi.g422ab.isChecked() ? "2"
                : "-1");

        json.put("g422b", bi.g422ba.isChecked() ? "1"
                : bi.g422bb.isChecked() ? "2"
                : "-1");

        json.put("g422cd", bi.g422cd.getText().toString().trim().length() > 0 ? bi.g422cd.getText().toString() : "-1");
        json.put("g422cm", bi.g422cm.getText().toString().trim().length() > 0 ? bi.g422cm.getText().toString() : "-1");


        json.put("g423a", bi.g423aa.isChecked() ? "1"
                : bi.g423ab.isChecked() ? "2"
                : "-1");

        json.put("g423b", bi.g423ba.isChecked() ? "1"
                : bi.g423bb.isChecked() ? "2"
                : "-1");

        json.put("g423cd", bi.g423cd.getText().toString().trim().length() > 0 ? bi.g423cd.getText().toString() : "-1");
        json.put("g423cm", bi.g423cm.getText().toString().trim().length() > 0 ? bi.g423cm.getText().toString() : "-1");


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
