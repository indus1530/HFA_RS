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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionD6Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionD6Activity extends AppCompatActivity {

    ActivitySectionD6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d6);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.d0602.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.lld0602);
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SD, fc.getsD());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d0601a", bi.d0601aa.isChecked() ? "1"
                : bi.d0601ab.isChecked() ? "2"
                : "-1");

        json.put("d0601b", bi.d0601ba.isChecked() ? "1"
                : bi.d0601bb.isChecked() ? "2"
                : "-1");

        json.put("d0601c", bi.d0601ca.isChecked() ? "1"
                : bi.d0601cb.isChecked() ? "2"
                : "-1");

        json.put("d0601d", bi.d0601da.isChecked() ? "1"
                : bi.d0601db.isChecked() ? "2"
                : "-1");

        json.put("d0602", bi.d0602a.isChecked() ? "1"
                : bi.d0602b.isChecked() ? "2"
                : "-1");

        json.put("d0603", bi.d0603a.isChecked() ? "1"
                : bi.d0603b.isChecked() ? "2"
                : "-1");

        json.put("d0604", bi.d0604a.isChecked() ? "1"
                : bi.d0604b.isChecked() ? "2"
                : "-1");

        json.put("d0605a", bi.d0605a.isChecked() ? "1" : "-1");
        json.put("d0605b", bi.d0605b.isChecked() ? "2" : "-1");
        json.put("d0605c", bi.d0605c.isChecked() ? "3" : "-1");
        json.put("d0605d", bi.d0605d.isChecked() ? "4" : "-1");
        json.put("d0605e", bi.d0605e.isChecked() ? "5" : "-1");
        json.put("d0605f", bi.d0605f.isChecked() ? "6" : "-1");
        json.put("d0605g", bi.d0605g.isChecked() ? "7" : "-1");
        json.put("d0605h", bi.d0605h.isChecked() ? "8" : "-1");
        json.put("d0605i", bi.d0605i.isChecked() ? "9" : "-1");


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsD()), json);

            fc.setsD(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionD7Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "D");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
