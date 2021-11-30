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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG41bBinding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG41BActivity extends AppCompatActivity {
    ActivitySectionG41bBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g41b);
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

        json.put("g427cd", bi.g427cd.getText().toString().trim().length() > 0 ? bi.g427cd.getText().toString() : "-1");
        json.put("g427cm", bi.g427cm.getText().toString().trim().length() > 0 ? bi.g427cm.getText().toString() : "-1");


        json.put("g428a", bi.g428aa.isChecked() ? "1"
                : bi.g428ab.isChecked() ? "2"
                : "-1");

        json.put("g428b", bi.g428ba.isChecked() ? "1"
                : bi.g428bb.isChecked() ? "2"
                : "-1");

        json.put("g428cd", bi.g428cd.getText().toString().trim().length() > 0 ? bi.g428cd.getText().toString() : "-1");
        json.put("g428cm", bi.g428cm.getText().toString().trim().length() > 0 ? bi.g428cm.getText().toString() : "-1");


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


        json.put("g431a", bi.g431aa.isChecked() ? "1"
                : bi.g431ab.isChecked() ? "2"
                : "-1");

        json.put("g431b", bi.g431ba.isChecked() ? "1"
                : bi.g431bb.isChecked() ? "2"
                : "-1");

        json.put("g431cd", bi.g431cd.getText().toString().trim().length() > 0 ? bi.g431cd.getText().toString() : "-1");
        json.put("g431cm", bi.g431cm.getText().toString().trim().length() > 0 ? bi.g431cm.getText().toString() : "-1");


        json.put("g432a", bi.g432aa.isChecked() ? "1"
                : bi.g432ab.isChecked() ? "2"
                : "-1");

        json.put("g432b", bi.g432ba.isChecked() ? "1"
                : bi.g432bb.isChecked() ? "2"
                : "-1");

        json.put("g432cd", bi.g432cd.getText().toString().trim().length() > 0 ? bi.g432cd.getText().toString() : "-1");
        json.put("g432cm", bi.g432cm.getText().toString().trim().length() > 0 ? bi.g432cm.getText().toString() : "-1");


        json.put("g433a", bi.g433aa.isChecked() ? "1"
                : bi.g433ab.isChecked() ? "2"
                : "-1");

        json.put("g433b", bi.g433ba.isChecked() ? "1"
                : bi.g433bb.isChecked() ? "2"
                : "-1");

        json.put("g433cd", bi.g433cd.getText().toString().trim().length() > 0 ? bi.g433cd.getText().toString() : "-1");
        json.put("g433cm", bi.g433cm.getText().toString().trim().length() > 0 ? bi.g433cm.getText().toString() : "-1");


        json.put("g434a", bi.g434aa.isChecked() ? "1"
                : bi.g434ab.isChecked() ? "2"
                : "-1");

        json.put("g434b", bi.g434ba.isChecked() ? "1"
                : bi.g434bb.isChecked() ? "2"
                : "-1");

        json.put("g434cd", bi.g434cd.getText().toString().trim().length() > 0 ? bi.g434cd.getText().toString() : "-1");
        json.put("g434cm", bi.g434cm.getText().toString().trim().length() > 0 ? bi.g434cm.getText().toString() : "-1");


        json.put("g435a", bi.g435aa.isChecked() ? "1"
                : bi.g435ab.isChecked() ? "2"
                : "-1");

        json.put("g435b", bi.g435ba.isChecked() ? "1"
                : bi.g435bb.isChecked() ? "2"
                : "-1");

        json.put("g435cd", bi.g435cd.getText().toString().trim().length() > 0 ? bi.g435cd.getText().toString() : "-1");
        json.put("g435cm", bi.g435cm.getText().toString().trim().length() > 0 ? bi.g435cm.getText().toString() : "-1");


        json.put("g436a", bi.g436aa.isChecked() ? "1"
                : bi.g436ab.isChecked() ? "2"
                : "-1");

        json.put("g436b", bi.g436ba.isChecked() ? "1"
                : bi.g436bb.isChecked() ? "2"
                : "-1");

        json.put("g436cd", bi.g436cd.getText().toString().trim().length() > 0 ? bi.g436cd.getText().toString() : "-1");
        json.put("g436cm", bi.g436cm.getText().toString().trim().length() > 0 ? bi.g436cm.getText().toString() : "-1");


        json.put("g437a", bi.g437aa.isChecked() ? "1"
                : bi.g437ab.isChecked() ? "2"
                : "-1");

        json.put("g437b", bi.g437ba.isChecked() ? "1"
                : bi.g437bb.isChecked() ? "2"
                : "-1");

        json.put("g437cd", bi.g437cd.getText().toString().trim().isEmpty() ? "-1" : bi.g437cd.getText().toString());
        json.put("g437cm", bi.g437cm.getText().toString().trim().isEmpty() ? "-1" : bi.g437cm.getText().toString());


        json.put("g438a", bi.g438aa.isChecked() ? "1"
                : bi.g438ab.isChecked() ? "2"
                : "-1");

        json.put("g438b", bi.g438ba.isChecked() ? "1"
                : bi.g438bb.isChecked() ? "2"
                : "-1");

        json.put("g438cd", bi.g438cd.getText().toString().trim().length() > 0 ? bi.g438cd.getText().toString() : "-1");
        json.put("g438cm", bi.g438cm.getText().toString().trim().length() > 0 ? bi.g438cm.getText().toString() : "-1");


        json.put("g439a", bi.g439aa.isChecked() ? "1"
                : bi.g439ab.isChecked() ? "2"
                : "-1");

        json.put("g439b", bi.g439ba.isChecked() ? "1"
                : bi.g439bb.isChecked() ? "2"
                : "-1");

        json.put("g439cd", bi.g439cd.getText().toString().trim().length() > 0 ? bi.g439cd.getText().toString() : "-1");
        json.put("g439cm", bi.g439cm.getText().toString().trim().length() > 0 ? bi.g439cm.getText().toString() : "-1");


        json.put("g440a", bi.g440aa.isChecked() ? "1"
                : bi.g440ab.isChecked() ? "2"
                : "-1");

        json.put("g440b", bi.g440ba.isChecked() ? "1"
                : bi.g440bb.isChecked() ? "2"
                : "-1");

        json.put("g440cd", bi.g440cd.getText().toString().trim().length() > 0 ? bi.g440cd.getText().toString() : "-1");
        json.put("g440cm", bi.g440cm.getText().toString().trim().length() > 0 ? bi.g440cm.getText().toString() : "-1");


        json.put("g441a", bi.g441aa.isChecked() ? "1"
                : bi.g441ab.isChecked() ? "2"
                : "-1");

        json.put("g441b", bi.g441ba.isChecked() ? "1"
                : bi.g441bb.isChecked() ? "2"
                : "-1");

        json.put("g441cd", bi.g441cd.getText().toString().trim().length() > 0 ? bi.g441cd.getText().toString() : "-1");
        json.put("g441cm", bi.g441cm.getText().toString().trim().length() > 0 ? bi.g441cm.getText().toString() : "-1");


        json.put("g442a", bi.g442aa.isChecked() ? "1"
                : bi.g442ab.isChecked() ? "2"
                : "-1");

        json.put("g442b", bi.g442ba.isChecked() ? "1"
                : bi.g442bb.isChecked() ? "2"
                : "-1");

        json.put("g442cd", bi.g442cd.getText().toString().trim().length() > 0 ? bi.g442cd.getText().toString() : "-1");
        json.put("g442cm", bi.g442cm.getText().toString().trim().length() > 0 ? bi.g442cm.getText().toString() : "-1");


        json.put("g443a", bi.g443aa.isChecked() ? "1"
                : bi.g443ab.isChecked() ? "2"
                : "-1");

        json.put("g443b", bi.g443ba.isChecked() ? "1"
                : bi.g443bb.isChecked() ? "2"
                : "-1");

        json.put("g443cd", bi.g443cd.getText().toString().trim().length() > 0 ? bi.g443cd.getText().toString() : "-1");
        json.put("g443cm", bi.g443cm.getText().toString().trim().length() > 0 ? bi.g443cm.getText().toString() : "-1");


        json.put("g444a", bi.g444aa.isChecked() ? "1"
                : bi.g444ab.isChecked() ? "2"
                : "-1");

        json.put("g444b", bi.g444ba.isChecked() ? "1"
                : bi.g444bb.isChecked() ? "2"
                : "-1");

        json.put("g444cd", bi.g444cd.getText().toString().trim().length() > 0 ? bi.g444cd.getText().toString() : "-1");
        json.put("g444cm", bi.g444cm.getText().toString().trim().length() > 0 ? bi.g444cm.getText().toString() : "-1");

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
            startActivity(new Intent(this, SectionG421Activity.class));
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
