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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG423Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG423Activity extends AppCompatActivity {

    ActivitySectionG423Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g423);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0403100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403100so);
            }
        }));

        bi.g0403110s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403110sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403110so);
            }
        }));

        bi.g0403120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403120so);
            }
        }));

        bi.g0403130s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403130sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403130so);
            }
        }));

        bi.g0403140s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403140sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403140so);
            }
        }));

        bi.g0403150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403150so);
            }
        }));

        bi.g0403160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403160so);
            }
        }));

        bi.g0403170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403170so);
            }
        }));

        bi.g0403180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403180so);
            }
        }));

        bi.g0403190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403190so);
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


        json.put("g0403100a", bi.g0403100ay.isChecked() ? "1"
                : bi.g0403100an.isChecked() ? "2"
                : "-1");

        json.put("g0403100s", bi.g0403100sy.isChecked() ? "1"
                : bi.g0403100sn.isChecked() ? "2"
                : "-1");

        json.put("g0403100sd", bi.g0403100sd.getText().toString().trim().length() > 0 ? bi.g0403100sd.getText().toString() : "-1");
        json.put("g0403100sm", bi.g0403100sm.getText().toString().trim().length() > 0 ? bi.g0403100sm.getText().toString() : "-1");


        json.put("g0403110a", bi.g0403110ay.isChecked() ? "1"
                : bi.g0403110an.isChecked() ? "2"
                : "-1");

        json.put("g0403110s", bi.g0403110sy.isChecked() ? "1"
                : bi.g0403110sn.isChecked() ? "2"
                : "-1");

        json.put("g0403110sd", bi.g0403110sd.getText().toString().trim().length() > 0 ? bi.g0403110sd.getText().toString() : "-1");
        json.put("g0403110sm", bi.g0403110sm.getText().toString().trim().length() > 0 ? bi.g0403110sm.getText().toString() : "-1");


        json.put("g0403120a", bi.g0403120ay.isChecked() ? "1"
                : bi.g0403120an.isChecked() ? "2"
                : "-1");

        json.put("g0403120s", bi.g0403120sy.isChecked() ? "1"
                : bi.g0403120sn.isChecked() ? "2"
                : "-1");

        json.put("g0403120sd", bi.g0403120sd.getText().toString().trim().length() > 0 ? bi.g0403120sd.getText().toString() : "-1");
        json.put("g0403120sm", bi.g0403120sm.getText().toString().trim().length() > 0 ? bi.g0403120sm.getText().toString() : "-1");


        json.put("g0403130a", bi.g0403130ay.isChecked() ? "1"
                : bi.g0403130an.isChecked() ? "2"
                : "-1");

        json.put("g0403130s", bi.g0403130sy.isChecked() ? "1"
                : bi.g0403130sn.isChecked() ? "2"
                : "-1");

        json.put("g0403130sd", bi.g0403130sd.getText().toString().trim().length() > 0 ? bi.g0403130sd.getText().toString() : "-1");
        json.put("g0403130sm", bi.g0403130sm.getText().toString().trim().length() > 0 ? bi.g0403130sm.getText().toString() : "-1");


        json.put("g0403140a", bi.g0403140ay.isChecked() ? "1"
                : bi.g0403140an.isChecked() ? "2"
                : "-1");

        json.put("g0403140s", bi.g0403140sy.isChecked() ? "1"
                : bi.g0403140sn.isChecked() ? "2"
                : "-1");

        json.put("g0403140sd", bi.g0403140sd.getText().toString().trim().length() > 0 ? bi.g0403140sd.getText().toString() : "-1");
        json.put("g0403140sm", bi.g0403140sm.getText().toString().trim().length() > 0 ? bi.g0403140sm.getText().toString() : "-1");


        json.put("g0403150a", bi.g0403150ay.isChecked() ? "1"
                : bi.g0403150an.isChecked() ? "2"
                : "-1");

        json.put("g0403150s", bi.g0403150sy.isChecked() ? "1"
                : bi.g0403150sn.isChecked() ? "2"
                : "-1");

        json.put("g0403150sd", bi.g0403150sd.getText().toString().trim().length() > 0 ? bi.g0403150sd.getText().toString() : "-1");
        json.put("g0403150sm", bi.g0403150sm.getText().toString().trim().length() > 0 ? bi.g0403150sm.getText().toString() : "-1");


        json.put("g0403160a", bi.g0403160ay.isChecked() ? "1"
                : bi.g0403160an.isChecked() ? "2"
                : "-1");

        json.put("g0403160s", bi.g0403160sy.isChecked() ? "1"
                : bi.g0403160sn.isChecked() ? "2"
                : "-1");

        json.put("g0403160sd", bi.g0403160sd.getText().toString().trim().length() > 0 ? bi.g0403160sd.getText().toString() : "-1");
        json.put("g0403160sm", bi.g0403160sm.getText().toString().trim().length() > 0 ? bi.g0403160sm.getText().toString() : "-1");


        json.put("g0403170a", bi.g0403170ay.isChecked() ? "1"
                : bi.g0403170an.isChecked() ? "2"
                : "-1");

        json.put("g0403170s", bi.g0403170sy.isChecked() ? "1"
                : bi.g0403170sn.isChecked() ? "2"
                : "-1");

        json.put("g0403170sd", bi.g0403170sd.getText().toString().trim().length() > 0 ? bi.g0403170sd.getText().toString() : "-1");
        json.put("g0403170sm", bi.g0403170sm.getText().toString().trim().length() > 0 ? bi.g0403170sm.getText().toString() : "-1");


        json.put("g0403180a", bi.g0403180ay.isChecked() ? "1"
                : bi.g0403180an.isChecked() ? "2"
                : "-1");

        json.put("g0403180s", bi.g0403180sy.isChecked() ? "1"
                : bi.g0403180sn.isChecked() ? "2"
                : "-1");

        json.put("g0403180sd", bi.g0403180sd.getText().toString().trim().length() > 0 ? bi.g0403180sd.getText().toString() : "-1");
        json.put("g0403180sm", bi.g0403180sm.getText().toString().trim().length() > 0 ? bi.g0403180sm.getText().toString() : "-1");


        json.put("g0403190a", bi.g0403190ay.isChecked() ? "1"
                : bi.g0403190an.isChecked() ? "2"
                : "-1");

        json.put("g0403190s", bi.g0403190sy.isChecked() ? "1"
                : bi.g0403190sn.isChecked() ? "2"
                : "-1");

        json.put("g0403190sd", bi.g0403190sd.getText().toString().trim().length() > 0 ? bi.g0403190sd.getText().toString() : "-1");
        json.put("g0403190sm", bi.g0403190sm.getText().toString().trim().length() > 0 ? bi.g0403190sm.getText().toString() : "-1");


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


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionG424Activity.class));
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
