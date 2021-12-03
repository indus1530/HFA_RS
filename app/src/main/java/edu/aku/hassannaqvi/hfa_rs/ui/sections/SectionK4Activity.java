package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK4Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK4Activity extends AppCompatActivity {

    ActivitySectionK4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k4);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

       /* bi.k0045.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0045);
        }));

        bi.k0049.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvk00410);
        }));*/

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
            startActivity(new Intent(this, SectionK6AActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k401", bi.k40101.isChecked() ? "1"
                : bi.k40102.isChecked() ? "2"
                : bi.k40103.isChecked() ? "3"
                : bi.k40104.isChecked() ? "4"
                : bi.k40105.isChecked() ? "5"
                : bi.k40106.isChecked() ? "6"
                : bi.k40107.isChecked() ? "7"
                : bi.k40197.isChecked() ? "97"
                : "-1");

        json.put("k402", bi.k40201.isChecked() ? "1"
                : bi.k40202.isChecked() ? "2"
                : "-1");

        json.put("k403", bi.k40301.isChecked() ? "1"
                : bi.k40302.isChecked() ? "2"
                : bi.k40303.isChecked() ? "3"
                : "-1");

        json.put("k404", bi.k40401.isChecked() ? "1"
                : bi.k40402.isChecked() ? "2"
                : "-1");

        json.put("k405", bi.k40501.isChecked() ? "1"
                : bi.k40502.isChecked() ? "2"
                : bi.k40503.isChecked() ? "3"
                : bi.k40504.isChecked() ? "4"
                : bi.k40505.isChecked() ? "5"
                : "-1");

        json.put("k406", bi.k406.getText().toString());

        json.put("k407", bi.k40701.isChecked() ? "1"
                : bi.k40702.isChecked() ? "2"
                : "-1");

        json.put("k408", bi.k40801.isChecked() ? "1"
                : bi.k40802.isChecked() ? "2"
                : bi.k40803.isChecked() ? "3"
                : "-1");

        json.put("k409", bi.k40901.isChecked() ? "1"
                : bi.k40902.isChecked() ? "2"
                : bi.k40903.isChecked() ? "3"
                : bi.k40904.isChecked() ? "4"
                : bi.k40997.isChecked() ? "97"
                : "-1");

        json.put("k410", bi.k41001.isChecked() ? "1"
                : bi.k41002.isChecked() ? "2"
                : bi.k41003.isChecked() ? "3"
                : "-1");

        json.put("k41101", bi.k41101.isChecked() ? "1" : "-1");

        json.put("k41102", bi.k41102.isChecked() ? "2" : "-1");

        json.put("k41103", bi.k41103.isChecked() ? "3" : "-1");

        json.put("k41201", bi.k41201.getText().toString());

        json.put("k41202", bi.k41202.getText().toString());

        json.put("k41203", bi.k41203.getText().toString());

        json.put("k41204", bi.k41204.getText().toString());

        json.put("k41205", bi.k41205.getText().toString());

        json.put("k41206", bi.k41206.getText().toString());

        json.put("k41207", bi.k41207.getText().toString());

        json.put("k41301", bi.k41301.getText().toString());

        json.put("k41302", bi.k41302.getText().toString());

        json.put("k41303", bi.k41303.getText().toString());

        json.put("k41401", bi.k41401.isChecked() ? "1" : "-1");

        json.put("k41402", bi.k41402.isChecked() ? "2" : "-1");

        json.put("k41403", bi.k41403.isChecked() ? "3" : "-1");

        json.put("k41404", bi.k41404.isChecked() ? "4" : "-1");

        json.put("k41405", bi.k41405.isChecked() ? "5" : "-1");

        json.put("k41406", bi.k41406.isChecked() ? "6" : "-1");

        json.put("k41407", bi.k41407.isChecked() ? "7" : "-1");

        json.put("k41408", bi.k41408.isChecked() ? "8" : "-1");

        json.put("k41409", bi.k41409.isChecked() ? "9" : "-1");

        json.put("k415", bi.k41501.isChecked() ? "1"
                : bi.k41502.isChecked() ? "2"
                : "-1");

        json.put("k416", bi.k41601.isChecked() ? "1"
                : bi.k41602.isChecked() ? "2"
                : bi.k41603.isChecked() ? "3"
                : bi.k41604.isChecked() ? "4"
                : "-1");

        json.put("k417", bi.k41701.isChecked() ? "1"
                : bi.k41702.isChecked() ? "2"
                : bi.k41703.isChecked() ? "3"
                : bi.k41704.isChecked() ? "4"
                : bi.k41705.isChecked() ? "5"
                : bi.k41706.isChecked() ? "6"
                : bi.k41796.isChecked() ? "96"
                : "-1");

        json.put("k41796x", bi.k41796x.getText().toString());
        json.put("k418", bi.k41801.isChecked() ? "1"
                : bi.k41802.isChecked() ? "2"
                : "-1");

        json.put("k41901", bi.k41901.isChecked() ? "1" : "-1");

        json.put("k41902", bi.k41902.isChecked() ? "2" : "-1");

        json.put("k41903", bi.k41903.isChecked() ? "3" : "-1");

        json.put("k41904", bi.k41904.isChecked() ? "4" : "-1");

        json.put("k41905", bi.k41905.isChecked() ? "5" : "-1");

        json.put("k41906", bi.k41906.isChecked() ? "6" : "-1");

        json.put("k41907", bi.k41907.isChecked() ? "7" : "-1");


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
