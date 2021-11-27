package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionF4Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionF4Activity extends AppCompatActivity {

    ActivitySectionF4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f4);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.f0401aaa0ayx, bi.f0401aaa0fyx);
        editTextImplementation(bi.f0401aab0ayx, bi.f0401aab0fyx);
        editTextImplementation(bi.f0401aac0ayx, bi.f0401aac0fyx);
        editTextImplementation(bi.f0402aaa0ayx, bi.f0402aaa0fyx);
        editTextImplementation(bi.f0403aaa0ayx, bi.f0403aaa0fyx);
        editTextImplementation(bi.f0404aaa0ayx, bi.f0404aaa0fyx);
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


    private void setupSkips() {

        bi.f0401.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0401b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf401);
            }
        });

        bi.f0401aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0401aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0401aaa0f);
            }
        });

        bi.f0401aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0401aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0401aab0f);
            }
        });

        bi.f0401aac0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0401aac0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0401aac0f);
            }
        });

        bi.f0402.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0402b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf402);
            }
        });

        bi.f0402aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0402aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0402aaa0f);
            }
        });

        bi.f0403.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0403b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf403);
            }
        });

        bi.f0403aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0403aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0403aaa0f);
            }
        });

        bi.f0404.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0404b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf404);
            }
        });

        bi.f0404aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0404aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0404aaa0f);
            }
        });

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SF, fc.getsF());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("f0401", bi.f0401a.isChecked() ? "1"
                : bi.f0401b.isChecked() ? "2"
                : "-1");

        json.put("f0401aaa0a", bi.f0401aaa0ay.isChecked() ? "1"
                : bi.f0401aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0401aaa0ayx", bi.f0401aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aaa0ayx.getText().toString());

        json.put("f0401aaa0f", bi.f0401aaa0fy.isChecked() ? "1"
                : bi.f0401aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0401aaa0fyx", bi.f0401aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aaa0fyx.getText().toString());

        json.put("f0401aab0a", bi.f0401aab0ay.isChecked() ? "1"
                : bi.f0401aab0an.isChecked() ? "2"
                : "-1");
        json.put("f0401aab0ayx", bi.f0401aab0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aab0ayx.getText().toString());

        json.put("f0401aab0f", bi.f0401aab0fy.isChecked() ? "1"
                : bi.f0401aab0fn.isChecked() ? "2"
                : "-1");
        json.put("f0401aab0fyx", bi.f0401aab0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aab0fyx.getText().toString());

        json.put("f0401aac0a", bi.f0401aac0ay.isChecked() ? "1"
                : bi.f0401aac0an.isChecked() ? "2"
                : "-1");
        json.put("f0401aac0ayx", bi.f0401aac0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aac0ayx.getText().toString());

        json.put("f0401aac0f", bi.f0401aac0fy.isChecked() ? "1"
                : bi.f0401aac0fn.isChecked() ? "2"
                : "-1");
        json.put("f0401aac0fyx", bi.f0401aac0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0401aac0fyx.getText().toString());

        json.put("f0402", bi.f0402a.isChecked() ? "1"
                : bi.f0402b.isChecked() ? "2"
                : "-1");

        json.put("f0402aaa0a", bi.f0402aaa0ay.isChecked() ? "1"
                : bi.f0402aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0402aaa0ayx", bi.f0402aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0402aaa0ayx.getText().toString());

        json.put("f0402aaa0f", bi.f0402aaa0fy.isChecked() ? "1"
                : bi.f0402aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0402aaa0fyx", bi.f0402aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0402aaa0fyx.getText().toString());

        json.put("f0403", bi.f0403a.isChecked() ? "1"
                : bi.f0403b.isChecked() ? "2"
                : "-1");

        json.put("f0403aaa0a", bi.f0403aaa0ay.isChecked() ? "1"
                : bi.f0403aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0403aaa0ayx", bi.f0403aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0403aaa0ayx.getText().toString());

        json.put("f0403aaa0f", bi.f0403aaa0fy.isChecked() ? "1"
                : bi.f0403aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0403aaa0fyx", bi.f0403aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0403aaa0fyx.getText().toString());

        json.put("f0404", bi.f0404a.isChecked() ? "1"
                : bi.f0404b.isChecked() ? "2"
                : "-1");

        json.put("f0404aaa0a", bi.f0404aaa0ay.isChecked() ? "1"
                : bi.f0404aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0404aaa0ayx", bi.f0404aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0404aaa0ayx.getText().toString());

        json.put("f0404aaa0f", bi.f0404aaa0fy.isChecked() ? "1"
                : bi.f0404aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0404aaa0fyx", bi.f0404aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0404aaa0fyx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsF()), json);

            MainApp.fc.setsF(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionF5Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "F");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
