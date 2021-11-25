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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE7Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE7Activity extends AppCompatActivity {

    ActivitySectionE7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e7);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.e0705a0ayx, bi.e0705a0fyx);
        editTextImplementation(bi.e0705b0ayx, bi.e0705b0fyx);
        editTextImplementation(bi.e0705c0ayx, bi.e0705c0fyx);
        editTextImplementation(bi.e0705d0ayx, bi.e0705d0fyx);
        editTextImplementation(bi.e0705e0ayx, bi.e0705e0fyx);
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

        bi.e0701.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0701b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece701);
            }
        }));


        bi.e0704d.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.lle0704d);
        }));


        bi.e0705a0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0705a0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0705a0f);
            }
        }));

        bi.e0705b0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0705b0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0705b0f);
            }
        }));

        bi.e0705c0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0705c0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0705c0f);
            }
        }));

        bi.e0705d0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0705d0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0705d0f);
            }
        }));

        bi.e0705e0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0705e0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0705e0f);
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

        json.put("e0701", bi.e0701a.isChecked() ? "1"
                : bi.e0701b.isChecked() ? "2"
                : "-1");

        json.put("e0702a", bi.e0702aa.isChecked() ? "1"
                : bi.e0702ab.isChecked() ? "2"
                : "-1");

        json.put("e0702b", bi.e0702ba.isChecked() ? "1"
                : bi.e0702bb.isChecked() ? "2"
                : "-1");

        json.put("e0702c", bi.e0702ca.isChecked() ? "1"
                : bi.e0702cb.isChecked() ? "2"
                : "-1");

        json.put("e0702d", bi.e0702da.isChecked() ? "1"
                : bi.e0702db.isChecked() ? "2"
                : "-1");

        json.put("e0702e", bi.e0702ea.isChecked() ? "1"
                : bi.e0702eb.isChecked() ? "2"
                : "-1");

        json.put("e0702f", bi.e0702fa.isChecked() ? "1"
                : bi.e0702fb.isChecked() ? "2"
                : "-1");

        json.put("e0702g", bi.e0702ga.isChecked() ? "1"
                : bi.e0702gb.isChecked() ? "2"
                : "-1");

        json.put("e0702h", bi.e0702ha.isChecked() ? "1"
                : bi.e0702hb.isChecked() ? "2"
                : "-1");

        json.put("e0702i", bi.e0702ia.isChecked() ? "1"
                : bi.e0702ib.isChecked() ? "2"
                : "-1");

        json.put("e0702j", bi.e0702ja.isChecked() ? "1"
                : bi.e0702jb.isChecked() ? "2"
                : "-1");

        json.put("e0702k", bi.e0702ka.isChecked() ? "1"
                : bi.e0702kb.isChecked() ? "2"
                : "-1");

        json.put("e0702l", bi.e0702la.isChecked() ? "1"
                : bi.e0702lb.isChecked() ? "2"
                : "-1");

        json.put("e0703a", bi.e0703aa.isChecked() ? "1"
                : bi.e0703ab.isChecked() ? "2"
                : bi.e0703ac.isChecked() ? "3"
                : "-1");

        json.put("e0703b", bi.e0703ba.isChecked() ? "1"
                : bi.e0703bb.isChecked() ? "2"
                : bi.e0703bc.isChecked() ? "3"
                : "-1");

        json.put("e0703c", bi.e0703ca.isChecked() ? "1"
                : bi.e0703cb.isChecked() ? "2"
                : bi.e0703cc.isChecked() ? "3"
                : "-1");

        json.put("e0703d", bi.e0703da.isChecked() ? "1"
                : bi.e0703db.isChecked() ? "2"
                : bi.e0703dc.isChecked() ? "3"
                : "-1");

        json.put("e0704a", bi.e0704aa.isChecked() ? "1"
                : bi.e0704ab.isChecked() ? "2"
                : "-1");

        json.put("e0704b", bi.e0704ba.isChecked() ? "1"
                : bi.e0704bb.isChecked() ? "2"
                : "-1");

        json.put("e0704c", bi.e0704ca.isChecked() ? "1"
                : bi.e0704cb.isChecked() ? "2"
                : "-1");

        json.put("e0704d", bi.e0704da.isChecked() ? "1"
                : bi.e0704db.isChecked() ? "2"
                : "-1");

        json.put("e0704e", bi.e0704e.getText().toString());

        json.put("e0704f", bi.e0704f.getText().toString().trim().isEmpty() ? "-1" : bi.e0704f.getText().toString());

        json.put("e0704g", bi.e0704ga.isChecked() ? "1"
                : bi.e0704gx.isChecked() ? "96"
                : "-1");
        json.put("e0704gxx", bi.e0704gxx.getText().toString().trim().isEmpty() ? "-1" : bi.e0704gxx.getText().toString());


        json.put("e0705a0a", bi.e0705a0ay.isChecked() ? "1"
                : bi.e0705a0an.isChecked() ? "2"
                : "-1");
        json.put("e0705a0ayx", bi.e0705a0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705a0ayx.getText().toString());


        json.put("e0705a0f", bi.e0705a0fy.isChecked() ? "1"
                : bi.e0705a0fn.isChecked() ? "2"
                : "-1");
        json.put("e0705a0fyx", bi.e0705a0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705a0fyx.getText().toString());


        json.put("e0705b0a", bi.e0705b0ay.isChecked() ? "1"
                : bi.e0705b0an.isChecked() ? "2"
                : "-1");
        json.put("e0705b0ayx", bi.e0705b0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705b0ayx.getText().toString());


        json.put("e0705b0f", bi.e0705b0fy.isChecked() ? "1"
                : bi.e0705b0fn.isChecked() ? "2"
                : "-1");
        json.put("e0705b0fyx", bi.e0705b0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705b0fyx.getText().toString());


        json.put("e0705c0a", bi.e0705c0ay.isChecked() ? "1"
                : bi.e0705c0an.isChecked() ? "2"
                : "-1");
        json.put("e0705c0ayx", bi.e0705c0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705c0ayx.getText().toString());


        json.put("e0705c0f", bi.e0705c0fy.isChecked() ? "1"
                : bi.e0705c0fn.isChecked() ? "2"
                : "-1");
        json.put("e0705c0fyx", bi.e0705c0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705c0fyx.getText().toString());


        json.put("e0705d0a", bi.e0705d0ay.isChecked() ? "1"
                : bi.e0705d0an.isChecked() ? "2"
                : "-1");
        json.put("e0705d0ayx", bi.e0705d0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705d0ayx.getText().toString());


        json.put("e0705d0f", bi.e0705d0fy.isChecked() ? "1"
                : bi.e0705d0fn.isChecked() ? "2"
                : "-1");
        json.put("e0705d0fyx", bi.e0705d0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705d0fyx.getText().toString());


        json.put("e0705e0a", bi.e0705e0ay.isChecked() ? "1"
                : bi.e0705e0an.isChecked() ? "2"
                : "-1");
        json.put("e0705e0ayx", bi.e0705e0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705e0ayx.getText().toString());


        json.put("e0705e0f", bi.e0705e0fy.isChecked() ? "1"
                : bi.e0705e0fn.isChecked() ? "2"
                : "-1");
        json.put("e0705e0fyx", bi.e0705e0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.e0705e0fyx.getText().toString());

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
            startActivity(new Intent(this, SectionE8Activity.class));
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


    public void showTooltip(@NotNull View view) {
        if (view.getId() != View.NO_ID) {
            String package_name = getApplicationContext().getPackageName();
            String infoid = view.getResources().getResourceName(view.getId()).replace(package_name + ":id/q_", "");
            int stringRes = this.getResources().getIdentifier(infoid + "_info", "string", getApplicationContext().getPackageName());
            //String infoText = (String) getResources().getText(stringRes);
            if (stringRes != 0) {
                String infoText = (String) getResources().getText(stringRes);

                new AlertDialog.Builder(this)
                        .setTitle("Info: " + infoid.toUpperCase())
                        .setMessage(infoText)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            } else {
                Toast.makeText(this, "No information available on this question.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No ID Associated with this question.", Toast.LENGTH_SHORT).show();

        }
    }


}
