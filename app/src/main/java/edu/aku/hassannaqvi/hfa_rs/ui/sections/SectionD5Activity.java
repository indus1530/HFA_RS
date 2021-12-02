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
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionD5Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionD5Activity extends AppCompatActivity {

    ActivitySectionD5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d5);
        bi.setCallback(this);
        setupTextWatchers();

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.d0502a0ayx, bi.d0502a0fyx);
        editTextImplementation(bi.d0502b0ayx, bi.d0502b0fyx);
        editTextImplementation(bi.d0502c0ayx, bi.d0502c0fyx);
        editTextImplementation(bi.d0502d0ayx, bi.d0502d0fyx);
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

        json.put("d0501", bi.d0501a.isChecked() ? "1"
                : bi.d0501b.isChecked() ? "2"
                : bi.d0501c.isChecked() ? "3"
                : "-1");

        json.put("d05011", bi.d05011a.isChecked() ? "1"
                : bi.d05011b.isChecked() ? "2"
                : "-1");

        json.put("d05012", bi.d05012a.isChecked() ? "1"
                : bi.d05012b.isChecked() ? "2"
                : bi.d05012c.isChecked() ? "3"
                : bi.d0501296.isChecked() ? "96"
                : "-1");
        json.put("d0501296x", bi.d0501296x.getText().toString().trim().isEmpty() ? "-1" : bi.d0501296x.getText().toString());

        json.put("d0502a0a", bi.d0502a0ay.isChecked() ? "1"
                : bi.d0502a0an.isChecked() ? "2"
                : "-1");
        json.put("d0502a0ayx", bi.d0502a0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502a0ayx.getText().toString());

        json.put("d0502a0f", bi.d0502a0fy.isChecked() ? "1"
                : bi.d0502a0fn.isChecked() ? "2"
                : "-1");
        json.put("d0502a0fyx", bi.d0502a0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502a0fyx.getText().toString());

        json.put("d0502b0a", bi.d0502b0ay.isChecked() ? "1"
                : bi.d0502b0an.isChecked() ? "2"
                : "-1");
        json.put("d0502b0ayx", bi.d0502b0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502b0ayx.getText().toString());

        json.put("d0502b0f", bi.d0502b0fy.isChecked() ? "1"
                : bi.d0502b0fn.isChecked() ? "2"
                : "-1");
        json.put("d0502b0fyx", bi.d0502b0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502b0fyx.getText().toString());

        json.put("d0502c0a", bi.d0502c0ay.isChecked() ? "1"
                : bi.d0502c0an.isChecked() ? "2"
                : "-1");
        json.put("d0502c0ayx", bi.d0502c0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502c0ayx.getText().toString());

        json.put("d0502c0f", bi.d0502c0fy.isChecked() ? "1"
                : bi.d0502c0fn.isChecked() ? "2"
                : "-1");
        json.put("d0502c0fyx", bi.d0502c0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502c0fyx.getText().toString());

        json.put("d0502d0a", bi.d0502d0ay.isChecked() ? "1"
                : bi.d0502d0an.isChecked() ? "2"
                : "-1");
        json.put("d0502d0ayx", bi.d0502d0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502d0ayx.getText().toString());

        json.put("d0502d0f", bi.d0502d0fy.isChecked() ? "1"
                : bi.d0502d0fn.isChecked() ? "2"
                : "-1");
        json.put("d0502d0fyx", bi.d0502d0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.d0502d0fyx.getText().toString());


        json.put("d0503a", bi.d0503aa.isChecked() ? "1"
                : bi.d0503ab.isChecked() ? "2"
                : "-1");

        json.put("d0503b", bi.d0503ba.isChecked() ? "1"
                : bi.d0503bb.isChecked() ? "2"
                : "-1");

        json.put("d0503c", bi.d0503ca.isChecked() ? "1"
                : bi.d0503cb.isChecked() ? "2"
                : "-1");

        json.put("d0503d", bi.d0503da.isChecked() ? "1"
                : bi.d0503db.isChecked() ? "2"
                : "-1");

        json.put("d0503e", bi.d0503ea.isChecked() ? "1"
                : bi.d0503eb.isChecked() ? "2"
                : "-1");

        json.put("d0503f", bi.d0503fa.isChecked() ? "1"
                : bi.d0503fb.isChecked() ? "2"
                : "-1");

        json.put("d0503g", bi.d0503ga.isChecked() ? "1"
                : bi.d0503gb.isChecked() ? "2"
                : "-1");

        json.put("d0503h", bi.d0503ha.isChecked() ? "1"
                : bi.d0503hb.isChecked() ? "2"
                : "-1");

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


    public void btnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionD6Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "D");
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
