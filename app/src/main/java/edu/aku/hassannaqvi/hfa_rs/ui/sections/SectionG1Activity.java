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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG1Binding;

public class SectionG1Activity extends AppCompatActivity {

    ActivitySectionG1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.g0111.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVg01112);
        }));

        bi.g01113.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVg01114);
        }));

        /*bi.g0108a.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.g0108aa.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108b);
                Clear.clearAllFields(bi.fldGrpCVg0108c);
                bi.fldGrpCVg0108b.setVisibility(View.GONE);
                bi.fldGrpCVg0108c.setVisibility(View.GONE);
            } else if (i == bi.g0108ab.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108b);
                Clear.clearAllFields(bi.fldGrpCVg0108c);
                bi.fldGrpCVg0108b.setVisibility(View.GONE);
                bi.fldGrpCVg0108c.setVisibility(View.GONE);
            }

        }));

        bi.g0108b.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.g0108ba.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108a);
                Clear.clearAllFields(bi.fldGrpCVg0108c);
                bi.fldGrpCVg0108a.setVisibility(View.GONE);
                bi.fldGrpCVg0108c.setVisibility(View.GONE);
            } else if (i == bi.g0108bb.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108a);
                Clear.clearAllFields(bi.fldGrpCVg0108c);
                bi.fldGrpCVg0108a.setVisibility(View.GONE);
                bi.fldGrpCVg0108c.setVisibility(View.GONE);
            }
        }));

        bi.g0108c.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.g0108ca.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108a);
                Clear.clearAllFields(bi.fldGrpCVg0108b);
                bi.fldGrpCVg0108a.setVisibility(View.GONE);
                bi.fldGrpCVg0108b.setVisibility(View.GONE);
            } else if (i == bi.g0108cb.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0108a);
                Clear.clearAllFields(bi.fldGrpCVg0108b);
                bi.fldGrpCVg0108a.setVisibility(View.GONE);
                bi.fldGrpCVg0108b.setVisibility(View.GONE);
            }
        }));*/
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

        json.put("GDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("GTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("g0101", bi.g0101a.isChecked() ? "1"
                : bi.g0101b.isChecked() ? "2"
                : bi.g0101c.isChecked() ? "3"
                : bi.g0101d.isChecked() ? "4"
                : bi.g0101e.isChecked() ? "5"
                : bi.g0101f.isChecked() ? "6"
                : bi.g0101x.isChecked() ? "96"
                : "-1");
        json.put("g0101xx", bi.g0101xx.getText().toString().trim().isEmpty() ? "-1" : bi.g0101xx.getText().toString());


        json.put("g0102", bi.g0102a.isChecked() ? "1"
                : bi.g0102b.isChecked() ? "2"
                : "-1");

        json.put("g0103", bi.g0103a.isChecked() ? "1"
                : bi.g0103b.isChecked() ? "98"
                : bi.g0103x.isChecked() ? "96"
                : "-1");
        json.put("g0103xx", bi.g0103xx.getText().toString().trim().isEmpty() ? "-1" : bi.g0103xx.getText().toString());

        json.put("g0104", bi.g0104a.isChecked() ? "1"
                : bi.g0104b.isChecked() ? "2"
                : bi.g0104c.isChecked() ? "3"
                : bi.g0104d.isChecked() ? "4"
                : bi.g0104e.isChecked() ? "5"
                : bi.g0104f.isChecked() ? "6"
                : bi.g0104g.isChecked() ? "7"
                : "-1");

        json.put("g0105ax", bi.g0105ax.getText().toString().trim().isEmpty() ? "-1" : bi.g0105ax.getText().toString());
        json.put("g0105bx", bi.g0105bx.getText().toString().trim().isEmpty() ? "-1" : bi.g0105bx.getText().toString());

        json.put("g0106", bi.g0106a.isChecked() ? "1"
                : bi.g0106b.isChecked() ? "2"
                : bi.g0106c.isChecked() ? "3"
                : bi.g0106d.isChecked() ? "4"
                : bi.g0106x.isChecked() ? "96"
                : "-1");
        json.put("g0106xx", bi.g0106xx.getText().toString().trim().isEmpty() ? "-1" : bi.g0106xx.getText().toString());

        json.put("g0107", bi.g0107a.isChecked() ? "1"
                : bi.g0107b.isChecked() ? "2"
                : bi.g0107c.isChecked() ? "3"
                : bi.g0107x.isChecked() ? "96"
                : "-1");
        json.put("g0107xx", bi.g0107xx.getText().toString().trim().isEmpty() ? "-1" : bi.g0107xx.getText().toString());


        /*json.put("g0108a", bi.g0108aa.isChecked() ? "1"
                : bi.g0108ab.isChecked() ? "2"
                : "-1");

        json.put("g0108b", bi.g0108ba.isChecked() ? "1"
                : bi.g0108bb.isChecked() ? "2"
                : "-1");

        json.put("g0108c", bi.g0108ca.isChecked() ? "1"
                : bi.g0108cb.isChecked() ? "2"
                : "-1");*/


        json.put("g0109", bi.g0109a.isChecked() ? "1"
                : bi.g0109b.isChecked() ? "2"
                : bi.g0109c.isChecked() ? "3"
                : bi.g0109d.isChecked() ? "4"
                : "-1");

        json.put("g0110ax", bi.g0110ax.getText().toString().trim().isEmpty() ? "-1" : bi.g0110ax.getText().toString());
        json.put("g0110bx", bi.g0110bx.getText().toString().trim().isEmpty() ? "-1" : bi.g0110bx.getText().toString());

        json.put("g0111", bi.g0111a.isChecked() ? "1"
                : bi.g0111b.isChecked() ? "2"
                : "-1");

        json.put("g01112", bi.g01112a.isChecked() ? "1"
                : bi.g01112b.isChecked() ? "2"
                : bi.g01112x.isChecked() ? "96"
                : "-1");
        json.put("g01112xx", bi.g01112xx.getText().toString().trim().isEmpty() ? "-1" : bi.g01112xx.getText().toString());

        json.put("g01113", bi.g01113a.isChecked() ? "1"
                : bi.g01113b.isChecked() ? "2"
                : "-1");

        json.put("g01114", bi.g01114a.isChecked() ? "1"
                : bi.g01114b.isChecked() ? "2"
                : bi.g01114c.isChecked() ? "3"
                : "-1");

        json.put("g01115", bi.g01115a.isChecked() ? "1"
                : bi.g01115b.isChecked() ? "2"
                : bi.g01115c.isChecked() ? "3"
                : "-1");

        json.put("g01116", bi.g01116a.isChecked() ? "1"
                : bi.g01116b.isChecked() ? "2"
                : "-1");

        json.put("g01117", bi.g01117a.isChecked() ? "1"
                : bi.g01117b.isChecked() ? "2"
                : bi.g01117c.isChecked() ? "3"
                : bi.g01117d.isChecked() ? "4"
                : bi.g01117e.isChecked() ? "5"
                : "-1");

        MainApp.fc.setsG(String.valueOf(json));

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
            startActivity(new Intent(this, SectionG2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd(View v) {
        openSectionMainActivity(this, "G");
    }

}
