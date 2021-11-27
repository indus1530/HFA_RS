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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionF6Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionF6Activity extends AppCompatActivity {

    ActivitySectionF6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f6);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.f0604aaa0ayx, bi.f0604aaa0fyx);
        editTextImplementation(bi.f0604aab0ayx, bi.f0604aab0fyx);
        editTextImplementation(bi.f0604aac0ayx, bi.f0604aac0fyx);
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

        bi.f0604.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0604b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf604);
            }
        });

        bi.f0604aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0604aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0604aaa0f);
            }
        });

        bi.f0604aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0604aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0604aab0f);
            }
        });

        bi.f0604aac0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0604aac0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0604aac0f);
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

        json.put("f0601", bi.f0601a.isChecked() ? "1"
                : bi.f0601b.isChecked() ? "2"
                : "-1");

        json.put("f0602", bi.f0602a.isChecked() ? "1"
                : bi.f0602b.isChecked() ? "2"
                : "-1");

        json.put("f0603", bi.f0603a.isChecked() ? "1"
                : bi.f0603b.isChecked() ? "2"
                : "-1");

        json.put("f0604", bi.f0604a.isChecked() ? "1"
                : bi.f0604b.isChecked() ? "2"
                : "-1");


        json.put("f0604aaa0a", bi.f0604aaa0ay.isChecked() ? "1"
                : bi.f0604aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0604aaa0ayx", bi.f0604aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aaa0ayx.getText().toString());

        json.put("f0604aaa0f", bi.f0604aaa0fy.isChecked() ? "1"
                : bi.f0604aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0604aaa0fyx", bi.f0604aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aaa0fyx.getText().toString());


        json.put("f0604aab0a", bi.f0604aab0ay.isChecked() ? "1"
                : bi.f0604aab0an.isChecked() ? "2"
                : "-1");
        json.put("f0604aab0ayx", bi.f0604aab0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aab0ayx.getText().toString());

        json.put("f0604aab0f", bi.f0604aab0fy.isChecked() ? "1"
                : bi.f0604aab0fn.isChecked() ? "2"
                : "-1");
        json.put("f0604aab0fyx", bi.f0604aab0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aab0fyx.getText().toString());


        json.put("f0604aac0a", bi.f0604aac0ay.isChecked() ? "1"
                : bi.f0604aac0an.isChecked() ? "2"
                : "-1");
        json.put("f0604aac0ayx", bi.f0604aac0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aac0ayx.getText().toString());

        json.put("f0604aac0f", bi.f0604aac0fy.isChecked() ? "1"
                : bi.f0604aac0fn.isChecked() ? "2"
                : "-1");
        json.put("f0604aac0fyx", bi.f0604aac0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0604aac0fyx.getText().toString());


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
            startActivity(new Intent(this, SectionF7Activity.class));
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
