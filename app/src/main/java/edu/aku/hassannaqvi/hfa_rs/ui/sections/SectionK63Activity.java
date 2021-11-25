package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK63Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionK63Activity extends AppCompatActivity {

    ActivitySectionK63Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k63);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();

    }


    private void setupSkips() {

        bi.k0060201.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060202);
        }));

        bi.k0060211.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060212);
        }));

        bi.k0060221.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060222);
        }));

        bi.k0060231.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060232);
        }));

        bi.k0060241.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060242);
        }));

        bi.k0060251.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060252);
        }));

        bi.k0060261.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060262);
        }));

        bi.k0060271.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060272);
        }));

        bi.k0060281.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060282);
        }));

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.k0060201q, bi.k0060202q);
        editTextImplementation(bi.k0060211q, bi.k0060212q);
        editTextImplementation(bi.k0060221q, bi.k0060222q);
        editTextImplementation(bi.k0060231q, bi.k0060232q);
        editTextImplementation(bi.k0060241q, bi.k0060242q);
        editTextImplementation(bi.k0060251q, bi.k0060252q);
        editTextImplementation(bi.k0060261q, bi.k0060262q);
        editTextImplementation(bi.k0060271q, bi.k0060272q);
        editTextImplementation(bi.k0060281q, bi.k0060282q);
    }


    public void editTextImplementation(EditTextPicker edit01, EditTextPicker edit02) {

        edit01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit01.getText()))
                    return;
                edit02.setMaxvalue(Integer.parseInt(edit01.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

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
            startActivity(new Intent(this, SectionK7Activity.class));
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


        json.put("k0060201", bi.k0060201a.isChecked() ? "1"
                : bi.k0060201b.isChecked() ? "2"
                : bi.k0060201c.isChecked() ? "3"
                : "-1");
        json.put("k0060201q", bi.k0060201q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060201q.getText().toString());

        json.put("k0060202", bi.k0060202a.isChecked() ? "1"
                : bi.k0060202b.isChecked() ? "2"
                : "-1");
        json.put("k0060202q", bi.k0060202q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060202q.getText().toString());


        json.put("k0060211", bi.k0060211a.isChecked() ? "1"
                : bi.k0060211b.isChecked() ? "2"
                : bi.k0060211c.isChecked() ? "3"
                : "-1");
        json.put("k0060211q", bi.k0060211q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060211q.getText().toString());

        json.put("k0060212", bi.k0060212a.isChecked() ? "1"
                : bi.k0060212b.isChecked() ? "2"
                : "-1");
        json.put("k0060212q", bi.k0060212q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060212q.getText().toString());


        json.put("k0060221", bi.k0060221a.isChecked() ? "1"
                : bi.k0060221b.isChecked() ? "2"
                : bi.k0060221c.isChecked() ? "3"
                : "-1");
        json.put("k0060221q", bi.k0060221q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060221q.getText().toString());

        json.put("k0060222", bi.k0060222a.isChecked() ? "1"
                : bi.k0060222b.isChecked() ? "2"
                : "-1");
        json.put("k0060222q", bi.k0060222q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060222q.getText().toString());


        json.put("k0060231", bi.k0060231a.isChecked() ? "1"
                : bi.k0060231b.isChecked() ? "2"
                : bi.k0060231c.isChecked() ? "3"
                : "-1");
        json.put("k0060231q", bi.k0060231q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060231q.getText().toString());

        json.put("k0060232", bi.k0060232a.isChecked() ? "1"
                : bi.k0060232b.isChecked() ? "2"
                : "-1");
        json.put("k0060232q", bi.k0060232q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060232q.getText().toString());


        json.put("k0060241", bi.k0060241a.isChecked() ? "1"
                : bi.k0060241b.isChecked() ? "2"
                : bi.k0060241c.isChecked() ? "3"
                : "-1");
        json.put("k0060241q", bi.k0060241q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060241q.getText().toString());

        json.put("k0060242", bi.k0060242a.isChecked() ? "1"
                : bi.k0060242b.isChecked() ? "2"
                : "-1");
        json.put("k0060242q", bi.k0060242q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060242q.getText().toString());


        json.put("k0060251", bi.k0060251a.isChecked() ? "1"
                : bi.k0060251b.isChecked() ? "2"
                : bi.k0060251c.isChecked() ? "3"
                : "-1");
        json.put("k0060251q", bi.k0060251q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060251q.getText().toString());

        json.put("k0060252", bi.k0060252a.isChecked() ? "1"
                : bi.k0060252b.isChecked() ? "2"
                : "-1");
        json.put("k0060252q", bi.k0060252q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060252q.getText().toString());


        json.put("k0060261", bi.k0060261a.isChecked() ? "1"
                : bi.k0060261b.isChecked() ? "2"
                : bi.k0060261c.isChecked() ? "3"
                : "-1");
        json.put("k0060261q", bi.k0060261q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060261q.getText().toString());

        json.put("k0060262", bi.k0060262a.isChecked() ? "1"
                : bi.k0060262b.isChecked() ? "2"
                : "-1");
        json.put("k0060262q", bi.k0060262q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060262q.getText().toString());


        json.put("k0060271", bi.k0060271a.isChecked() ? "1"
                : bi.k0060271b.isChecked() ? "2"
                : bi.k0060271c.isChecked() ? "3"
                : "-1");
        json.put("k0060271q", bi.k0060271q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060271q.getText().toString());

        json.put("k0060272", bi.k0060272a.isChecked() ? "1"
                : bi.k0060272b.isChecked() ? "2"
                : "-1");
        json.put("k0060272q", bi.k0060272q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060272q.getText().toString());


        json.put("k0060281", bi.k0060281a.isChecked() ? "1"
                : bi.k0060281b.isChecked() ? "2"
                : bi.k0060281c.isChecked() ? "3"
                : "-1");
        json.put("k0060281q", bi.k0060281q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060281q.getText().toString());

        json.put("k0060282", bi.k0060282a.isChecked() ? "1"
                : bi.k0060282b.isChecked() ? "2"
                : "-1");
        json.put("k0060282q", bi.k0060282q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060282q.getText().toString());


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


    public void BtnEnd() {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
