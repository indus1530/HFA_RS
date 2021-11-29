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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE31Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE31Activity extends AppCompatActivity {

    ActivitySectionE31Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e31);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0301.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0301b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece301);
            }
        }));

        bi.e0305c.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.ll305c);
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

        json.put("e0301", bi.e0301a.isChecked() ? "1"
                : bi.e0301b.isChecked() ? "2"
                : "-1");

        json.put("e0302a", bi.e0302aa.isChecked() ? "1"
                : bi.e0302ab.isChecked() ? "2"
                : "-1");

        json.put("e0302b", bi.e0302ba.isChecked() ? "1"
                : bi.e0302bb.isChecked() ? "2"
                : "-1");

        json.put("e0302c", bi.e0302ca.isChecked() ? "1"
                : bi.e0302cb.isChecked() ? "2"
                : "-1");

        json.put("e0302d", bi.e0302da.isChecked() ? "1"
                : bi.e0302db.isChecked() ? "2"
                : "-1");

        json.put("e0302e", bi.e0302ea.isChecked() ? "1"
                : bi.e0302eb.isChecked() ? "2"
                : "-1");

        json.put("e0303a", bi.e0303aa.isChecked() ? "1"
                : bi.e0303ab.isChecked() ? "2"
                : "-1");

        json.put("e0303b", bi.e0303ba.isChecked() ? "1"
                : bi.e0303bb.isChecked() ? "2"
                : "-1");

        json.put("e0303c", bi.e0303ca.isChecked() ? "1"
                : bi.e0303cb.isChecked() ? "2"
                : "-1");

        json.put("e0303d", bi.e0303da.isChecked() ? "1"
                : bi.e0303db.isChecked() ? "2"
                : "-1");

        json.put("e0303e", bi.e0303ea.isChecked() ? "1"
                : bi.e0303eb.isChecked() ? "2"
                : "-1");

        json.put("e0303f", bi.e0303fa.isChecked() ? "1"
                : bi.e0303fb.isChecked() ? "2"
                : "-1");

        json.put("e0303g", bi.e0303ga.isChecked() ? "1"
                : bi.e0303gb.isChecked() ? "2"
                : "-1");

        json.put("e0303h", bi.e0303ha.isChecked() ? "1"
                : bi.e0303hb.isChecked() ? "2"
                : "-1");

        json.put("e0303i", bi.e0303ia.isChecked() ? "1"
                : bi.e0303ib.isChecked() ? "2"
                : "-1");

        json.put("e0303j", bi.e0303ja.isChecked() ? "1"
                : bi.e0303jb.isChecked() ? "2"
                : "-1");

        json.put("e0303k", bi.e0303ka.isChecked() ? "1"
                : bi.e0303kb.isChecked() ? "2"
                : "-1");

        json.put("e0303l", bi.e0303la.isChecked() ? "1"
                : bi.e0303lb.isChecked() ? "2"
                : "-1");

        json.put("e0303m", bi.e0303ma.isChecked() ? "1"
                : bi.e0303mb.isChecked() ? "2"
                : "-1");

        json.put("e0303n", bi.e0303na.isChecked() ? "1"
                : bi.e0303nb.isChecked() ? "2"
                : "-1");

        json.put("e0304a", bi.e0304aa.isChecked() ? "1"
                : bi.e0304ab.isChecked() ? "2"
                : bi.e0304ac.isChecked() ? "3"
                : "-1");

        json.put("e0304b", bi.e0304ba.isChecked() ? "1"
                : bi.e0304bb.isChecked() ? "2"
                : bi.e0304bc.isChecked() ? "3"
                : "-1");

        json.put("e0304c", bi.e0304ca.isChecked() ? "1"
                : bi.e0304cb.isChecked() ? "2"
                : bi.e0304cc.isChecked() ? "3"
                : "-1");

        json.put("e0304d", bi.e0304da.isChecked() ? "1"
                : bi.e0304db.isChecked() ? "2"
                : bi.e0304dc.isChecked() ? "3"
                : "-1");

        json.put("e0305a", bi.e0305aa.isChecked() ? "1"
                : bi.e0305ab.isChecked() ? "2"
                : bi.e0305ac.isChecked() ? "3"
                : "-1");

        json.put("e0305b", bi.e0305ba.isChecked() ? "1"
                : bi.e0305bb.isChecked() ? "2"
                : bi.e0305bc.isChecked() ? "3"
                : "-1");

        json.put("e0305c", bi.e0305ca.isChecked() ? "1"
                : bi.e0305cb.isChecked() ? "2"
                : bi.e0305cc.isChecked() ? "3"
                : "-1");

        json.put("e0305d", bi.e0305d.getText().toString().trim().isEmpty() ? "-1" : bi.e0305d.getText().toString());

        json.put("e0305e", bi.e0305ea.isChecked() ? "1"
                : bi.e0305ex.isChecked() ? "96"
                : "-1");
        json.put("e0305exx", bi.e0305exx.getText().toString().trim().isEmpty() ? "-1" : bi.e0305exx.getText().toString());

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


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, bi.e0301b.isChecked() ? SectionE41Activity.class : SectionE32Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "E");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
