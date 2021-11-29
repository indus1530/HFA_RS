package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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

        bi.k0045.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0045);
        }));

        bi.k0049.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvk00410);
        }));

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
            startActivity(new Intent(this, SectionK5Activity.class));
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

        json.put("k0041", bi.k0041a.isChecked() ? "1"
                : bi.k0041b.isChecked() ? "2"
                : bi.k0041c.isChecked() ? "3"
                : "-1");

        json.put("k0042", bi.k0042a.isChecked() ? "1"
                : bi.k0042b.isChecked() ? "2"
                : "-1");

        json.put("k0043", bi.k0043a.isChecked() ? "1"
                : bi.k0043b.isChecked() ? "2"
                : bi.k0043c.isChecked() ? "3"
                : "-1");

        json.put("k0044", bi.k0044a.isChecked() ? "1"
                : bi.k0044b.isChecked() ? "2"
                : bi.k0044c.isChecked() ? "3"
                : "-1");

        json.put("k0045", bi.k0045a.isChecked() ? "1"
                : bi.k0045b.isChecked() ? "2"
                : bi.k0045c.isChecked() ? "3"
                : "-1");

        json.put("k0046a", bi.k0046a.isChecked() ? "1" : "-1");
        json.put("k0046b", bi.k0046b.isChecked() ? "2" : "-1");

        json.put("k0047a", bi.k0047a.getText().toString().trim().isEmpty() ? "-1" : bi.k0047a.getText().toString());
        json.put("k0047b", bi.k0047b.getText().toString().trim().isEmpty() ? "-1" : bi.k0047b.getText().toString());
        json.put("k0047c", bi.k0047c.getText().toString().trim().isEmpty() ? "-1" : bi.k0047c.getText().toString());
        json.put("k0047d", bi.k0047d.getText().toString().trim().isEmpty() ? "-1" : bi.k0047d.getText().toString());
        json.put("k0047e", bi.k0047e.getText().toString().trim().isEmpty() ? "-1" : bi.k0047e.getText().toString());
        json.put("k0047f", bi.k0047f.getText().toString().trim().isEmpty() ? "-1" : bi.k0047f.getText().toString());
        json.put("k0047g", bi.k0047g.getText().toString().trim().isEmpty() ? "-1" : bi.k0047g.getText().toString());

        json.put("k0048", bi.k0048.getText().toString().trim().isEmpty() ? "-1" : bi.k0048.getText().toString());

        json.put("k0049", bi.k0049a.isChecked() ? "1"
                : bi.k0049b.isChecked() ? "2"
                : "-1");

        json.put("k00410", bi.k00410a.isChecked() ? "1"
                : bi.k00410b.isChecked() ? "2"
                : bi.k00410c.isChecked() ? "3"
                : bi.k00410d.isChecked() ? "4"
                : bi.k00410e.isChecked() ? "5"
                : "-1");

        json.put("k00411", bi.k00411.getText().toString().trim().isEmpty() ? "-1" : bi.k00411.getText().toString());


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
