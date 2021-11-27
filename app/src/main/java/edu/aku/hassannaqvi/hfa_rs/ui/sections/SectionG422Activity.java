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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG422Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG422Activity extends AppCompatActivity {

    ActivitySectionG422Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g422);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040310s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040310sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040310so);
            }
        }));

        bi.g040320s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040320sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040320so);
            }
        }));

        bi.g040330s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040330sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040330so);
            }
        }));

        bi.g040340s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040340sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040340so);
            }
        }));

        bi.g040350s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040350sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040350so);
            }
        }));

        bi.g040360s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040360sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040360so);
            }
        }));

        bi.g040370s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040370sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040370so);
            }
        }));

        bi.g040380s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040380sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040380so);
            }
        }));

        bi.g040390s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040390sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040390so);
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


        json.put("g040310a", bi.g040310ay.isChecked() ? "1"
                : bi.g040310an.isChecked() ? "2"
                : "-1");

        json.put("g040310s", bi.g040310sy.isChecked() ? "1"
                : bi.g040310sn.isChecked() ? "2"
                : "-1");

        json.put("g040310sd", bi.g040310sd.getText().toString().trim().length() > 0 ? bi.g040310sd.getText().toString() : "-1");
        json.put("g040310sm", bi.g040310sm.getText().toString().trim().length() > 0 ? bi.g040310sm.getText().toString() : "-1");


        json.put("g040320a", bi.g040320ay.isChecked() ? "1"
                : bi.g040320an.isChecked() ? "2"
                : "-1");

        json.put("g040320s", bi.g040320sy.isChecked() ? "1"
                : bi.g040320sn.isChecked() ? "2"
                : "-1");

        json.put("g040320sd", bi.g040320sd.getText().toString().trim().length() > 0 ? bi.g040320sd.getText().toString() : "-1");
        json.put("g040320sm", bi.g040320sm.getText().toString().trim().length() > 0 ? bi.g040320sm.getText().toString() : "-1");


        json.put("g040330a", bi.g040330ay.isChecked() ? "1"
                : bi.g040330an.isChecked() ? "2"
                : "-1");

        json.put("g040330s", bi.g040330sy.isChecked() ? "1"
                : bi.g040330sn.isChecked() ? "2"
                : "-1");

        json.put("g040330sd", bi.g040330sd.getText().toString().trim().length() > 0 ? bi.g040330sd.getText().toString() : "-1");
        json.put("g040330sm", bi.g040330sm.getText().toString().trim().length() > 0 ? bi.g040330sm.getText().toString() : "-1");


        json.put("g040340a", bi.g040340ay.isChecked() ? "1"
                : bi.g040340an.isChecked() ? "2"
                : "-1");

        json.put("g040340s", bi.g040340sy.isChecked() ? "1"
                : bi.g040340sn.isChecked() ? "2"
                : "-1");

        json.put("g040340sd", bi.g040340sd.getText().toString().trim().length() > 0 ? bi.g040340sd.getText().toString() : "-1");
        json.put("g040340sm", bi.g040340sm.getText().toString().trim().length() > 0 ? bi.g040340sm.getText().toString() : "-1");


        json.put("g040350a", bi.g040350ay.isChecked() ? "1"
                : bi.g040350an.isChecked() ? "2"
                : "-1");

        json.put("g040350s", bi.g040350sy.isChecked() ? "1"
                : bi.g040350sn.isChecked() ? "2"
                : "-1");

        json.put("g040350sd", bi.g040350sd.getText().toString().trim().length() > 0 ? bi.g040350sd.getText().toString() : "-1");
        json.put("g040350sm", bi.g040350sm.getText().toString().trim().length() > 0 ? bi.g040350sm.getText().toString() : "-1");


        json.put("g040360a", bi.g040360ay.isChecked() ? "1"
                : bi.g040360an.isChecked() ? "2"
                : "-1");

        json.put("g040360s", bi.g040360sy.isChecked() ? "1"
                : bi.g040360sn.isChecked() ? "2"
                : "-1");

        json.put("g040360sd", bi.g040360sd.getText().toString().trim().length() > 0 ? bi.g040360sd.getText().toString() : "-1");
        json.put("g040360sm", bi.g040360sm.getText().toString().trim().length() > 0 ? bi.g040360sm.getText().toString() : "-1");


        json.put("g040370a", bi.g040370ay.isChecked() ? "1"
                : bi.g040370an.isChecked() ? "2"
                : "-1");

        json.put("g040370s", bi.g040370sy.isChecked() ? "1"
                : bi.g040370sn.isChecked() ? "2"
                : "-1");

        json.put("g040370sd", bi.g040370sd.getText().toString().trim().length() > 0 ? bi.g040370sd.getText().toString() : "-1");
        json.put("g040370sm", bi.g040370sm.getText().toString().trim().length() > 0 ? bi.g040370sm.getText().toString() : "-1");


        json.put("g040380a", bi.g040380ay.isChecked() ? "1"
                : bi.g040380an.isChecked() ? "2"
                : "-1");

        json.put("g040380s", bi.g040380sy.isChecked() ? "1"
                : bi.g040380sn.isChecked() ? "2"
                : "-1");

        json.put("g040380sd", bi.g040380sd.getText().toString().trim().length() > 0 ? bi.g040380sd.getText().toString() : "-1");
        json.put("g040380sm", bi.g040380sm.getText().toString().trim().length() > 0 ? bi.g040380sm.getText().toString() : "-1");


        json.put("g040390a", bi.g040390ay.isChecked() ? "1"
                : bi.g040390an.isChecked() ? "2"
                : "-1");

        json.put("g040390s", bi.g040390sy.isChecked() ? "1"
                : bi.g040390sn.isChecked() ? "2"
                : "-1");

        json.put("g040390sd", bi.g040390sd.getText().toString().trim().length() > 0 ? bi.g040390sd.getText().toString() : "-1");
        json.put("g040390sm", bi.g040390sm.getText().toString().trim().length() > 0 ? bi.g040390sm.getText().toString() : "-1");


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
            startActivity(new Intent(this, SectionG423Activity.class));
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
