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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG413Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG413Activity extends AppCompatActivity {

    ActivitySectionG413Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g413);
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


        json.put("g424a", bi.g424aa.isChecked() ? "1"
                : bi.g424ab.isChecked() ? "2"
                : "-1");

        json.put("g424b", bi.g424ba.isChecked() ? "1"
                : bi.g424bb.isChecked() ? "2"
                : "-1");

        json.put("g424cd", bi.g424cd.getText().toString().trim().length() > 0 ? bi.g424cd.getText().toString() : "-1");
        json.put("g424cm", bi.g424cm.getText().toString().trim().length() > 0 ? bi.g424cm.getText().toString() : "-1");


        json.put("g425a", bi.g425aa.isChecked() ? "1"
                : bi.g425ab.isChecked() ? "2"
                : "-1");

        json.put("g425b", bi.g425ba.isChecked() ? "1"
                : bi.g425bb.isChecked() ? "2"
                : "-1");

        json.put("g425cd", bi.g425cd.getText().toString().trim().length() > 0 ? bi.g425cd.getText().toString() : "-1");
        json.put("g425cm", bi.g425cm.getText().toString().trim().length() > 0 ? bi.g425cm.getText().toString() : "-1");


        json.put("g426a", bi.g426aa.isChecked() ? "1"
                : bi.g426ab.isChecked() ? "2"
                : "-1");

        json.put("g426b", bi.g426ba.isChecked() ? "1"
                : bi.g426bb.isChecked() ? "2"
                : "-1");

        json.put("g426cd", bi.g426cd.getText().toString().trim().length() > 0 ? bi.g426cd.getText().toString() : "-1");
        json.put("g426cm", bi.g426cm.getText().toString().trim().length() > 0 ? bi.g426cm.getText().toString() : "-1");


        json.put("g427a", bi.g427aa.isChecked() ? "1"
                : bi.g427ab.isChecked() ? "2"
                : "-1");

        json.put("g427b", bi.g427ba.isChecked() ? "1"
                : bi.g427bb.isChecked() ? "2"
                : "-1");

        json.put("g427cd", bi.g427cd.getText().toString().trim().isEmpty() ? "-1" : bi.g427cd.getText().toString());
        json.put("g427cm", bi.g427cm.getText().toString().trim().isEmpty() ? "-1" : bi.g427cm.getText().toString());


        json.put("g429a", bi.g429aa.isChecked() ? "1"
                : bi.g429ab.isChecked() ? "2"
                : "-1");

        json.put("g429b", bi.g429ba.isChecked() ? "1"
                : bi.g429bb.isChecked() ? "2"
                : "-1");

        json.put("g429cd", bi.g429cd.getText().toString().trim().length() > 0 ? bi.g429cd.getText().toString() : "-1");
        json.put("g429cm", bi.g429cm.getText().toString().trim().length() > 0 ? bi.g429cm.getText().toString() : "-1");


        json.put("g430a", bi.g430aa.isChecked() ? "1"
                : bi.g430ab.isChecked() ? "2"
                : "-1");

        json.put("g430b", bi.g430ba.isChecked() ? "1"
                : bi.g430bb.isChecked() ? "2"
                : "-1");

        json.put("g430cd", bi.g430cd.getText().toString().trim().length() > 0 ? bi.g430cd.getText().toString() : "-1");
        json.put("g430cm", bi.g430cm.getText().toString().trim().length() > 0 ? bi.g430cm.getText().toString() : "-1");


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
            startActivity(new Intent(this, SectionG414Activity.class));
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
