package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE8Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE8Activity extends AppCompatActivity {

    ActivitySectionE8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e8);
        bi.setCallback(this);
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

        json.put("e0801", bi.e0801a.isChecked() ? "1"
                : bi.e0801b.isChecked() ? "2"
                : "-1");

        json.put("e0802", bi.e0802a.isChecked() ? "1"
                : bi.e0802b.isChecked() ? "2"
                : "-1");

        json.put("e0803", bi.e0803a.isChecked() ? "1"
                : bi.e0803b.isChecked() ? "2"
                : "-1");

        json.put("e0804", bi.e0804a.isChecked() ? "1"
                : bi.e0804b.isChecked() ? "2"
                : "-1");

        json.put("e0805", bi.e0805a.isChecked() ? "1"
                : bi.e0805b.isChecked() ? "2"
                : "-1");

        json.put("e0806", bi.e0806a.isChecked() ? "1"
                : bi.e0806b.isChecked() ? "2"
                : "-1");

        json.put("e0807", bi.e0807a.isChecked() ? "1"
                : bi.e0807b.isChecked() ? "2"
                : "-1");

        json.put("e0808", bi.e0808a.isChecked() ? "1"
                : bi.e0808b.isChecked() ? "2"
                : "-1");

        json.put("e0809", bi.e0809a.isChecked() ? "1"
                : bi.e0809b.isChecked() ? "2"
                : "-1");

        json.put("e0810", bi.e0810a.isChecked() ? "1"
                : bi.e0810b.isChecked() ? "2"
                : "-1");

        json.put("e0811", bi.e0811a.isChecked() ? "1"
                : bi.e0811b.isChecked() ? "2"
                : "-1");

        json.put("e0812", bi.e0812a.isChecked() ? "1"
                : bi.e0812b.isChecked() ? "2"
                : "-1");

        json.put("e0813", bi.e0813a.isChecked() ? "1"
                : bi.e0813b.isChecked() ? "2"
                : "-1");

        json.put("e0814", bi.e0814a.isChecked() ? "1"
                : bi.e0814b.isChecked() ? "2"
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


    public void btnContinue(View v) {
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


    public void btnEnd(View v) {
        openSectionMainActivity(this, "E");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
