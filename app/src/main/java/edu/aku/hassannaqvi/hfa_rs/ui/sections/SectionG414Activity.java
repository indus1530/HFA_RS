package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG414Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG414Activity extends AppCompatActivity {

    ActivitySectionG414Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g414);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0401300s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401300sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401300so);
            }
        }));

        bi.g0401310s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401310sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401310so);
            }
        }));

        bi.g0401320s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401320sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401320so);
            }
        }));

        bi.g0401330s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401330sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401330so);
            }
        }));

        bi.g0401340s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401340sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401340so);
            }
        }));

        bi.g0401350s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401350sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401350so);
            }
        }));

        bi.g0401360s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401360sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401360so);
            }
        }));

        bi.g0401370s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401370sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401370so);
            }
        }));

        bi.g0401380s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401380sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401380so);
            }
        }));

        bi.g0401390s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401390sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401390so);
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


        json.put("g0401300a", bi.g0401300ay.isChecked() ? "1"
                : bi.g0401300an.isChecked() ? "2"
                : "-1");

        json.put("g0401300s", bi.g0401300sy.isChecked() ? "1"
                : bi.g0401300sn.isChecked() ? "2"
                : "-1");

        json.put("g0401300sd", bi.g0401300sd.getText().toString().trim().length() > 0 ? bi.g0401300sd.getText().toString() : "-1");
        json.put("g0401300sm", bi.g0401300sm.getText().toString().trim().length() > 0 ? bi.g0401300sm.getText().toString() : "-1");


        json.put("g0401310a", bi.g0401310ay.isChecked() ? "1"
                : bi.g0401310an.isChecked() ? "2"
                : "-1");

        json.put("g0401310s", bi.g0401310sy.isChecked() ? "1"
                : bi.g0401310sn.isChecked() ? "2"
                : "-1");

        json.put("g0401310sd", bi.g0401310sd.getText().toString().trim().length() > 0 ? bi.g0401310sd.getText().toString() : "-1");
        json.put("g0401310sm", bi.g0401310sm.getText().toString().trim().length() > 0 ? bi.g0401310sm.getText().toString() : "-1");


        json.put("g0401320a", bi.g0401320ay.isChecked() ? "1"
                : bi.g0401320an.isChecked() ? "2"
                : "-1");

        json.put("g0401320s", bi.g0401320sy.isChecked() ? "1"
                : bi.g0401320sn.isChecked() ? "2"
                : "-1");

        json.put("g0401320sd", bi.g0401320sd.getText().toString().trim().length() > 0 ? bi.g0401320sd.getText().toString() : "-1");
        json.put("g0401320sm", bi.g0401320sm.getText().toString().trim().length() > 0 ? bi.g0401320sm.getText().toString() : "-1");


        json.put("g0401330a", bi.g0401330ay.isChecked() ? "1"
                : bi.g0401330an.isChecked() ? "2"
                : "-1");

        json.put("g0401330s", bi.g0401330sy.isChecked() ? "1"
                : bi.g0401330sn.isChecked() ? "2"
                : "-1");

        json.put("g0401330sd", bi.g0401330sd.getText().toString().trim().length() > 0 ? bi.g0401330sd.getText().toString() : "-1");
        json.put("g0401330sm", bi.g0401330sm.getText().toString().trim().length() > 0 ? bi.g0401330sm.getText().toString() : "-1");


        json.put("g0401340a", bi.g0401340ay.isChecked() ? "1"
                : bi.g0401340an.isChecked() ? "2"
                : "-1");

        json.put("g0401340s", bi.g0401340sy.isChecked() ? "1"
                : bi.g0401340sn.isChecked() ? "2"
                : "-1");

        json.put("g0401340sd", bi.g0401340sd.getText().toString().trim().length() > 0 ? bi.g0401340sd.getText().toString() : "-1");
        json.put("g0401340sm", bi.g0401340sm.getText().toString().trim().length() > 0 ? bi.g0401340sm.getText().toString() : "-1");


        json.put("g0401350a", bi.g0401350ay.isChecked() ? "1"
                : bi.g0401350an.isChecked() ? "2"
                : "-1");

        json.put("g0401350s", bi.g0401350sy.isChecked() ? "1"
                : bi.g0401350sn.isChecked() ? "2"
                : "-1");

        json.put("g0401350sd", bi.g0401350sd.getText().toString().trim().length() > 0 ? bi.g0401350sd.getText().toString() : "-1");
        json.put("g0401350sm", bi.g0401350sm.getText().toString().trim().length() > 0 ? bi.g0401350sm.getText().toString() : "-1");


        json.put("g0401360a", bi.g0401360ay.isChecked() ? "1"
                : bi.g0401360an.isChecked() ? "2"
                : "-1");

        json.put("g0401360s", bi.g0401360sy.isChecked() ? "1"
                : bi.g0401360sn.isChecked() ? "2"
                : "-1");

        json.put("g0401360sd", bi.g0401360sd.getText().toString().trim().length() > 0 ? bi.g0401360sd.getText().toString() : "-1");
        json.put("g0401360sm", bi.g0401360sm.getText().toString().trim().length() > 0 ? bi.g0401360sm.getText().toString() : "-1");


        json.put("g0401370a", bi.g0401370ay.isChecked() ? "1"
                : bi.g0401370an.isChecked() ? "2"
                : "-1");

        json.put("g0401370s", bi.g0401370sy.isChecked() ? "1"
                : bi.g0401370sn.isChecked() ? "2"
                : "-1");

        json.put("g0401370sd", bi.g0401370sd.getText().toString().trim().length() > 0 ? bi.g0401370sd.getText().toString() : "-1");
        json.put("g0401370sm", bi.g0401370sm.getText().toString().trim().length() > 0 ? bi.g0401370sm.getText().toString() : "-1");


        json.put("g0401380a", bi.g0401380ay.isChecked() ? "1"
                : bi.g0401380an.isChecked() ? "2"
                : "-1");

        json.put("g0401380s", bi.g0401380sy.isChecked() ? "1"
                : bi.g0401380sn.isChecked() ? "2"
                : "-1");

        json.put("g0401380sd", bi.g0401380sd.getText().toString().trim().length() > 0 ? bi.g0401380sd.getText().toString() : "-1");
        json.put("g0401380sm", bi.g0401380sm.getText().toString().trim().length() > 0 ? bi.g0401380sm.getText().toString() : "-1");


        json.put("g0401390a", bi.g0401390ay.isChecked() ? "1"
                : bi.g0401390an.isChecked() ? "2"
                : "-1");

        json.put("g0401390s", bi.g0401390sy.isChecked() ? "1"
                : bi.g0401390sn.isChecked() ? "2"
                : "-1");

        json.put("g0401390sd", bi.g0401390sd.getText().toString().trim().length() > 0 ? bi.g0401390sd.getText().toString() : "-1");
        json.put("g0401390sm", bi.g0401390sm.getText().toString().trim().length() > 0 ? bi.g0401390sm.getText().toString() : "-1");


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
            startActivity(new Intent(this, SectionG415Activity.class));
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
