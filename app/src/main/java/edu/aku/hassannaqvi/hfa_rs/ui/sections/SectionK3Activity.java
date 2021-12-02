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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK3Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK3Activity extends AppCompatActivity {

    ActivitySectionK3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k3);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        /*bi.k0031.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0031);
        }));


        bi.k0035.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(bi.k0035.getText()))
                    return;
                bi.k0036.setMaxvalue(Integer.parseInt(bi.k0035.getText().toString()));
                bi.k0037d.setMaxvalue(Integer.parseInt(bi.k0035.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });*/

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
            startActivity(new Intent(this, SectionK4Activity.class));
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

        json.put("k301", bi.k30101.isChecked() ? "1"
                : bi.k30102.isChecked() ? "2"
                : bi.k30103.isChecked() ? "3"
                : "-1");

        json.put("k302", bi.k30201.isChecked() ? "1"
                : bi.k30202.isChecked() ? "2"
                : bi.k30203.isChecked() ? "3"
                : "-1");

        json.put("k303", bi.k30301.isChecked() ? "1"
                : bi.k30302.isChecked() ? "2"
                : "-1");

        json.put("k304", bi.k30401.isChecked() ? "1"
                : bi.k30402.isChecked() ? "2"
                : "-1");

        json.put("k305", bi.k305.getText().toString());

        json.put("k306", bi.k306.getText().toString());

        json.put("k307", bi.k30701.isChecked() ? "1"
                : bi.k30702.isChecked() ? "2"
                : bi.k30703.isChecked() ? "3"
                : bi.k30704.isChecked() ? "4"
                : "-1");

        json.put("k30704x", bi.k30704x.getText().toString());
        json.put("k308", bi.k30801.isChecked() ? "1"
                : bi.k30802.isChecked() ? "2"
                : bi.k30803.isChecked() ? "3"
                : bi.k30804.isChecked() ? "4"
                : "-1");

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
