package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG412Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG412Activity extends AppCompatActivity {

    ActivitySectionG412Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g412);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0401120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401120so);
            }
        }));

        bi.g0401130s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401130sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401130so);
            }
        }));

        bi.g0401140s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401140sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401140so);
            }
        }));

        bi.g0401150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401150so);
            }
        }));

        bi.g0401160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401160so);
            }
        }));

        bi.g0401170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401170so);
            }
        }));

        bi.g0401180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401180so);
            }
        }));

        bi.g0401190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401190so);
            }
        }));

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


        json.put("g0401120a", bi.g0401120ay.isChecked() ? "1"
                : bi.g0401120an.isChecked() ? "2"
                : "-1");

        json.put("g0401120s", bi.g0401120sy.isChecked() ? "1"
                : bi.g0401120sn.isChecked() ? "2"
                : "-1");

        json.put("g0401120sd", bi.g0401120sd.getText().toString().trim().length() > 0 ? bi.g0401120sd.getText().toString() : "-1");
        json.put("g0401120sm", bi.g0401120sm.getText().toString().trim().length() > 0 ? bi.g0401120sm.getText().toString() : "-1");


        json.put("g0401130a", bi.g0401130ay.isChecked() ? "1"
                : bi.g0401130an.isChecked() ? "2"
                : "-1");

        json.put("g0401130s", bi.g0401130sy.isChecked() ? "1"
                : bi.g0401130sn.isChecked() ? "2"
                : "-1");

        json.put("g0401130sd", bi.g0401130sd.getText().toString().trim().length() > 0 ? bi.g0401130sd.getText().toString() : "-1");
        json.put("g0401130sm", bi.g0401130sm.getText().toString().trim().length() > 0 ? bi.g0401130sm.getText().toString() : "-1");


        json.put("g0401140a", bi.g0401140ay.isChecked() ? "1"
                : bi.g0401140an.isChecked() ? "2"
                : "-1");

        json.put("g0401140s", bi.g0401140sy.isChecked() ? "1"
                : bi.g0401140sn.isChecked() ? "2"
                : "-1");

        json.put("g0401140sd", bi.g0401140sd.getText().toString().trim().length() > 0 ? bi.g0401140sd.getText().toString() : "-1");
        json.put("g0401140sm", bi.g0401140sm.getText().toString().trim().length() > 0 ? bi.g0401140sm.getText().toString() : "-1");


        json.put("g0401150a", bi.g0401150ay.isChecked() ? "1"
                : bi.g0401150an.isChecked() ? "2"
                : "-1");

        json.put("g0401150s", bi.g0401150sy.isChecked() ? "1"
                : bi.g0401150sn.isChecked() ? "2"
                : "-1");

        json.put("g0401150sd", bi.g0401150sd.getText().toString().trim().length() > 0 ? bi.g0401150sd.getText().toString() : "-1");
        json.put("g0401150sm", bi.g0401150sm.getText().toString().trim().length() > 0 ? bi.g0401150sm.getText().toString() : "-1");


        json.put("g0401160a", bi.g0401160ay.isChecked() ? "1"
                : bi.g0401160an.isChecked() ? "2"
                : "-1");

        json.put("g0401160s", bi.g0401160sy.isChecked() ? "1"
                : bi.g0401160sn.isChecked() ? "2"
                : "-1");

        json.put("g0401160sd", bi.g0401160sd.getText().toString().trim().length() > 0 ? bi.g0401160sd.getText().toString() : "-1");
        json.put("g0401160sm", bi.g0401160sm.getText().toString().trim().length() > 0 ? bi.g0401160sm.getText().toString() : "-1");


        json.put("g0401170a", bi.g0401170ay.isChecked() ? "1"
                : bi.g0401170an.isChecked() ? "2"
                : "-1");

        json.put("g0401170s", bi.g0401170sy.isChecked() ? "1"
                : bi.g0401170sn.isChecked() ? "2"
                : "-1");

        json.put("g0401170sd", bi.g0401170sd.getText().toString().trim().length() > 0 ? bi.g0401170sd.getText().toString() : "-1");
        json.put("g0401170sm", bi.g0401170sm.getText().toString().trim().length() > 0 ? bi.g0401170sm.getText().toString() : "-1");


        json.put("g0401180a", bi.g0401180ay.isChecked() ? "1"
                : bi.g0401180an.isChecked() ? "2"
                : "-1");

        json.put("g0401180s", bi.g0401180sy.isChecked() ? "1"
                : bi.g0401180sn.isChecked() ? "2"
                : "-1");

        json.put("g0401180sd", bi.g0401180sd.getText().toString().trim().length() > 0 ? bi.g0401180sd.getText().toString() : "-1");
        json.put("g0401180sm", bi.g0401180sm.getText().toString().trim().length() > 0 ? bi.g0401180sm.getText().toString() : "-1");


        json.put("g0401190a", bi.g0401190ay.isChecked() ? "1"
                : bi.g0401190an.isChecked() ? "2"
                : "-1");

        json.put("g0401190s", bi.g0401190sy.isChecked() ? "1"
                : bi.g0401190sn.isChecked() ? "2"
                : "-1");

        json.put("g0401190sd", bi.g0401190sd.getText().toString().trim().length() > 0 ? bi.g0401190sd.getText().toString() : "-1");
        json.put("g0401190sm", bi.g0401190sm.getText().toString().trim().length() > 0 ? bi.g0401190sm.getText().toString() : "-1");


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


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionG413Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
