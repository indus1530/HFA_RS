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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG425Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG425Activity extends AppCompatActivity {

    ActivitySectionG425Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g425);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040410so);
            }
        }));

        bi.g040420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040420so);
            }
        }));

        bi.g040430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040430so);
            }
        }));

        bi.g040440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040440so);
            }
        }));

        bi.g040450s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040450sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040450so);
            }
        }));

        bi.g040460s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040460sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040460so);
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


        json.put("g040410a", bi.g040410ay.isChecked() ? "1"
                : bi.g040410an.isChecked() ? "2"
                : "-1");

        json.put("g040410s", bi.g040410sy.isChecked() ? "1"
                : bi.g040410sn.isChecked() ? "2"
                : "-1");

        json.put("g040410sd", bi.g040410sd.getText().toString().trim().length() > 0 ? bi.g040410sd.getText().toString() : "-1");
        json.put("g040410sm", bi.g040410sm.getText().toString().trim().length() > 0 ? bi.g040410sm.getText().toString() : "-1");


        json.put("g040420a", bi.g040420ay.isChecked() ? "1"
                : bi.g040420an.isChecked() ? "2"
                : "-1");

        json.put("g040420s", bi.g040420sy.isChecked() ? "1"
                : bi.g040420sn.isChecked() ? "2"
                : "-1");

        json.put("g040420sd", bi.g040420sd.getText().toString().trim().length() > 0 ? bi.g040420sd.getText().toString() : "-1");
        json.put("g040420sm", bi.g040420sm.getText().toString().trim().length() > 0 ? bi.g040420sm.getText().toString() : "-1");


        json.put("g040430a", bi.g040430ay.isChecked() ? "1"
                : bi.g040430an.isChecked() ? "2"
                : "-1");

        json.put("g040430s", bi.g040430sy.isChecked() ? "1"
                : bi.g040430sn.isChecked() ? "2"
                : "-1");

        json.put("g040430sd", bi.g040430sd.getText().toString().trim().length() > 0 ? bi.g040430sd.getText().toString() : "-1");
        json.put("g040430sm", bi.g040430sm.getText().toString().trim().length() > 0 ? bi.g040430sm.getText().toString() : "-1");


        json.put("g040440a", bi.g040440ay.isChecked() ? "1"
                : bi.g040440an.isChecked() ? "2"
                : "-1");

        json.put("g040440s", bi.g040440sy.isChecked() ? "1"
                : bi.g040440sn.isChecked() ? "2"
                : "-1");

        json.put("g040440sd", bi.g040440sd.getText().toString().trim().length() > 0 ? bi.g040440sd.getText().toString() : "-1");
        json.put("g040440sm", bi.g040440sm.getText().toString().trim().length() > 0 ? bi.g040440sm.getText().toString() : "-1");


        json.put("g040450a", bi.g040450ay.isChecked() ? "1"
                : bi.g040450an.isChecked() ? "2"
                : "-1");

        json.put("g040450s", bi.g040450sy.isChecked() ? "1"
                : bi.g040450sn.isChecked() ? "2"
                : "-1");

        json.put("g040450sd", bi.g040450sd.getText().toString().trim().length() > 0 ? bi.g040450sd.getText().toString() : "-1");
        json.put("g040450sm", bi.g040450sm.getText().toString().trim().length() > 0 ? bi.g040450sm.getText().toString() : "-1");


        json.put("g040460a", bi.g040460ay.isChecked() ? "1"
                : bi.g040460an.isChecked() ? "2"
                : "-1");

        json.put("g040460s", bi.g040460sy.isChecked() ? "1"
                : bi.g040460sn.isChecked() ? "2"
                : "-1");

        json.put("g040460sd", bi.g040460sd.getText().toString().trim().length() > 0 ? bi.g040460sd.getText().toString() : "-1");
        json.put("g040460sm", bi.g040460sm.getText().toString().trim().length() > 0 ? bi.g040460sm.getText().toString() : "-1");


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


    public void BtnContinue(View v) {
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


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
