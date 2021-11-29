package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionF3Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionF3Activity extends AppCompatActivity {

    ActivitySectionF3Binding bi;
    boolean imFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f3);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.f0301aaa0ayx, bi.f0301aaa0fyx);
        editTextImplementation(bi.f0302aaa0ayx, bi.f0302aaa0fyx);
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

        bi.f0301.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSecf301);
        });

        bi.f0301aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVf0301aaa0f);
        });

        bi.f0302.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSecf302);
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

        json.put("f0301", bi.f0301a.isChecked() ? "1"
                : bi.f0301b.isChecked() ? "2"
                : "-1");


        json.put("f0301aaa0a", bi.f0301aaa0ay.isChecked() ? "1"
                : bi.f0301aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0301aaa0ayx", bi.f0301aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0301aaa0ayx.getText().toString());

        json.put("f0301aaa0f", bi.f0301aaa0fy.isChecked() ? "1"
                : bi.f0301aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0301aaa0fyx", bi.f0301aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0301aaa0fyx.getText().toString());

        json.put("f0302", bi.f0302a.isChecked() ? "1"
                : bi.f0302b.isChecked() ? "2"
                : "-1");


        json.put("f0302aaa0a", bi.f0302aaa0ay.isChecked() ? "1"
                : bi.f0302aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0302aaa0ayx", bi.f0302aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0302aaa0ayx.getText().toString());

        json.put("f0302aaa0f", bi.f0302aaa0fy.isChecked() ? "1"
                : bi.f0302aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0302aaa0fyx", bi.f0302aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0302aaa0fyx.getText().toString());

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


    public void btnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionF4Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "F");
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
