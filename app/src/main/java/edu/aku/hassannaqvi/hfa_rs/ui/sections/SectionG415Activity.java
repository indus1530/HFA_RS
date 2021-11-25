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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG415Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG415Activity extends AppCompatActivity {

    ActivitySectionG415Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g415);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0401400s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401400sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401400so);
            }
        }));

        bi.g0401410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401410so);
            }
        }));

        bi.g0401420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401420so);
            }
        }));

        bi.g0401430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401430so);
            }
        }));

        bi.g0401440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401440so);
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


        json.put("g0401400a", bi.g0401400ay.isChecked() ? "1"
                : bi.g0401400an.isChecked() ? "2"
                : "-1");

        json.put("g0401400s", bi.g0401400sy.isChecked() ? "1"
                : bi.g0401400sn.isChecked() ? "2"
                : "-1");

        json.put("g0401400sd", bi.g0401400sd.getText().toString().trim().length() > 0 ? bi.g0401400sd.getText().toString() : "-1");
        json.put("g0401400sm", bi.g0401400sm.getText().toString().trim().length() > 0 ? bi.g0401400sm.getText().toString() : "-1");


        json.put("g0401410a", bi.g0401410ay.isChecked() ? "1"
                : bi.g0401410an.isChecked() ? "2"
                : "-1");

        json.put("g0401410s", bi.g0401410sy.isChecked() ? "1"
                : bi.g0401410sn.isChecked() ? "2"
                : "-1");

        json.put("g0401410sd", bi.g0401410sd.getText().toString().trim().length() > 0 ? bi.g0401410sd.getText().toString() : "-1");
        json.put("g0401410sm", bi.g0401410sm.getText().toString().trim().length() > 0 ? bi.g0401410sm.getText().toString() : "-1");


        json.put("g0401420a", bi.g0401420ay.isChecked() ? "1"
                : bi.g0401420an.isChecked() ? "2"
                : "-1");

        json.put("g0401420s", bi.g0401420sy.isChecked() ? "1"
                : bi.g0401420sn.isChecked() ? "2"
                : "-1");

        json.put("g0401420sd", bi.g0401420sd.getText().toString().trim().length() > 0 ? bi.g0401420sd.getText().toString() : "-1");
        json.put("g0401420sm", bi.g0401420sm.getText().toString().trim().length() > 0 ? bi.g0401420sm.getText().toString() : "-1");


        json.put("g0401430a", bi.g0401430ay.isChecked() ? "1"
                : bi.g0401430an.isChecked() ? "2"
                : "-1");

        json.put("g0401430s", bi.g0401430sy.isChecked() ? "1"
                : bi.g0401430sn.isChecked() ? "2"
                : "-1");

        json.put("g0401430sd", bi.g0401430sd.getText().toString().trim().length() > 0 ? bi.g0401430sd.getText().toString() : "-1");
        json.put("g0401430sm", bi.g0401430sm.getText().toString().trim().length() > 0 ? bi.g0401430sm.getText().toString() : "-1");


        json.put("g0401440a", bi.g0401440ay.isChecked() ? "1"
                : bi.g0401440an.isChecked() ? "2"
                : "-1");

        json.put("g0401440s", bi.g0401440sy.isChecked() ? "1"
                : bi.g0401440sn.isChecked() ? "2"
                : "-1");

        json.put("g0401440sd", bi.g0401440sd.getText().toString().trim().length() > 0 ? bi.g0401440sd.getText().toString() : "-1");
        json.put("g0401440sm", bi.g0401440sm.getText().toString().trim().length() > 0 ? bi.g0401440sm.getText().toString() : "-1");


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


    public void BtnContinue() {
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


    public void BtnEnd() {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
