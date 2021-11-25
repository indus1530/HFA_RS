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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE5Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE5Activity extends AppCompatActivity {

    ActivitySectionE5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e5);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0501.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0501b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece501);
            }
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0501", bi.e0501a.isChecked() ? "1"
                : bi.e0501b.isChecked() ? "2"
                : "-1");

        json.put("e0502a", bi.e0502aa.isChecked() ? "1"
                : bi.e0502ab.isChecked() ? "2"
                : "-1");

        json.put("e0502b", bi.e0502ba.isChecked() ? "1"
                : bi.e0502bb.isChecked() ? "2"
                : "-1");

        json.put("e0502c", bi.e0502ca.isChecked() ? "1"
                : bi.e0502cb.isChecked() ? "2"
                : "-1");

        json.put("e0502d", bi.e0502da.isChecked() ? "1"
                : bi.e0502db.isChecked() ? "2"
                : "-1");

        json.put("e0502e", bi.e0502ea.isChecked() ? "1"
                : bi.e0502eb.isChecked() ? "2"
                : "-1");

        json.put("e0502f", bi.e0502fa.isChecked() ? "1"
                : bi.e0502fb.isChecked() ? "2"
                : "-1");

        json.put("e0502g", bi.e0502ga.isChecked() ? "1"
                : bi.e0502gb.isChecked() ? "2"
                : "-1");

        json.put("e0502h", bi.e0502ha.isChecked() ? "1"
                : bi.e0502hb.isChecked() ? "2"
                : "-1");

        json.put("e0502i", bi.e0502ia.isChecked() ? "1"
                : bi.e0502ib.isChecked() ? "2"
                : "-1");

        json.put("e0503", bi.e0503a.isChecked() ? "1"
                : bi.e0503b.isChecked() ? "2"
                : bi.e0503c.isChecked() ? "3"
                : "-1");

        json.put("e0504", bi.e0504a.isChecked() ? "1"
                : bi.e0504b.isChecked() ? "2"
                : "-1");

        json.put("e0505", bi.e0505a.isChecked() ? "1"
                : bi.e0505b.isChecked() ? "2"
                : bi.e0505c.isChecked() ? "3"
                : "-1");

        json.put("e0506", bi.e0506a.isChecked() ? "1"
                : bi.e0506b.isChecked() ? "2"
                : "-1");

        json.put("e0507", bi.e0507a.isChecked() ? "1"
                : bi.e0507b.isChecked() ? "2"
                : "-1");

        json.put("e0508", bi.e0508a.isChecked() ? "1"
                : bi.e0508b.isChecked() ? "2"
                : "-1");

        json.put("e0509", bi.e0509a.isChecked() ? "1"
                : bi.e0509b.isChecked() ? "2"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsE()), json);

            fc.setsE(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionE6Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "E");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
