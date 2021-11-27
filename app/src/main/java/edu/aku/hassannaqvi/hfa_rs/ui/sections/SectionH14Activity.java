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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH14Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionH14Activity extends AppCompatActivity {

    ActivitySectionH14Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h14);
        bi.setCallback(this);
        setupTextWatchers();

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.h1401aa, bi.h1401ab);
        editTextImplementation(bi.h1401ba, bi.h1401bb);
        editTextImplementation(bi.h1401ca, bi.h1401cb);
        editTextImplementation(bi.h1401da, bi.h1401db);
        editTextImplementation(bi.h1401ea, bi.h1401eb);
    }


    public void editTextImplementation(EditTextPicker edit01, EditTextPicker edit02) {

        edit01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(edit01.getText()))
                    return;
                edit02.setMaxvalue(Integer.parseInt(edit01.getText().toString().trim()));
            }
        });

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
            startActivity(new Intent(this, SectionH151Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, MainApp.fc.getsH());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h1401aa", bi.h1401aa.getText().toString().trim().isEmpty() ? "-1" : bi.h1401aa.getText().toString());
        json.put("h1401ab", bi.h1401ab.getText().toString().trim().isEmpty() ? "-1" : bi.h1401ab.getText().toString());

        json.put("h1401ba", bi.h1401ba.getText().toString().trim().isEmpty() ? "-1" : bi.h1401ba.getText().toString());
        json.put("h1401bb", bi.h1401bb.getText().toString().trim().isEmpty() ? "-1" : bi.h1401bb.getText().toString());

        json.put("h1401ca", bi.h1401ca.getText().toString().trim().isEmpty() ? "-1" : bi.h1401ca.getText().toString());
        json.put("h1401cb", bi.h1401cb.getText().toString().trim().isEmpty() ? "-1" : bi.h1401cb.getText().toString());

        json.put("h1401da", bi.h1401da.getText().toString().trim().isEmpty() ? "-1" : bi.h1401da.getText().toString());
        json.put("h1401db", bi.h1401db.getText().toString().trim().isEmpty() ? "-1" : bi.h1401db.getText().toString());

        json.put("h1401ea", bi.h1401ea.getText().toString().trim().isEmpty() ? "-1" : bi.h1401ea.getText().toString());
        json.put("h1401eb", bi.h1401eb.getText().toString().trim().isEmpty() ? "-1" : bi.h1401eb.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsH()), json);

            fc.setsH(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH14);
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "H");
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
