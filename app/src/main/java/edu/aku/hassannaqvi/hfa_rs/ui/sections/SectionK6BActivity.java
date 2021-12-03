package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK6bBinding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionK6BActivity extends AppCompatActivity {
    ActivitySectionK6bBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k6b);
        bi.setCallback(this);
        setupTextWatchers();

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.k615d, bi.k615e);
        editTextImplementation(bi.k616d, bi.k616e);
        editTextImplementation(bi.k617d, bi.k617e);
        editTextImplementation(bi.k618d, bi.k618e);
        editTextImplementation(bi.k619d, bi.k619e);
        editTextImplementation(bi.k620d, bi.k620e);
        editTextImplementation(bi.k621d, bi.k621e);
        editTextImplementation(bi.k622d, bi.k622e);
        editTextImplementation(bi.k623d, bi.k623e);
        editTextImplementation(bi.k624d, bi.k624e);
        editTextImplementation(bi.k625d, bi.k625e);
        editTextImplementation(bi.k626d, bi.k626e);
        editTextImplementation(bi.k627d, bi.k627e);
        editTextImplementation(bi.k628d, bi.k628e);
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


    public void btnContinue(View v) {
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


        //K615
        json.put("k615", bi.k615a.isChecked() ? "1"
                : bi.k615b.isChecked() ? "2"
                : bi.k615c.isChecked() ? "3"
                : "-1");

        json.put("k615d", bi.k615d.getText().toString().trim().isEmpty() ? "-1" : bi.k615d.getText().toString());
        json.put("k615e", bi.k615e.getText().toString().trim().isEmpty() ? "-1" : bi.k615e.getText().toString());


        //K616
        json.put("k616", bi.k616a.isChecked() ? "1"
                : bi.k616b.isChecked() ? "2"
                : bi.k616c.isChecked() ? "3"
                : "-1");

        json.put("k616d", bi.k616d.getText().toString().trim().isEmpty() ? "-1" : bi.k616d.getText().toString());
        json.put("k616e", bi.k616e.getText().toString().trim().isEmpty() ? "-1" : bi.k616e.getText().toString());


        //K617
        json.put("k617", bi.k617a.isChecked() ? "1"
                : bi.k617b.isChecked() ? "2"
                : bi.k617c.isChecked() ? "3"
                : "-1");

        json.put("k617d", bi.k617d.getText().toString().trim().isEmpty() ? "-1" : bi.k617d.getText().toString());
        json.put("k617e", bi.k617e.getText().toString().trim().isEmpty() ? "-1" : bi.k617e.getText().toString());


        //K618
        json.put("k618", bi.k618a.isChecked() ? "1"
                : bi.k618b.isChecked() ? "2"
                : bi.k618c.isChecked() ? "3"
                : "-1");

        json.put("k618d", bi.k618d.getText().toString().trim().isEmpty() ? "-1" : bi.k618d.getText().toString());
        json.put("k618e", bi.k618e.getText().toString().trim().isEmpty() ? "-1" : bi.k618e.getText().toString());


        //K619
        json.put("k619", bi.k619a.isChecked() ? "1"
                : bi.k619b.isChecked() ? "2"
                : bi.k619c.isChecked() ? "3"
                : "-1");

        json.put("k619d", bi.k619d.getText().toString().trim().isEmpty() ? "-1" : bi.k619d.getText().toString());
        json.put("k619e", bi.k619e.getText().toString().trim().isEmpty() ? "-1" : bi.k619e.getText().toString());


        //K620
        json.put("k620", bi.k620a.isChecked() ? "1"
                : bi.k620b.isChecked() ? "2"
                : bi.k620c.isChecked() ? "3"
                : "-1");

        json.put("k620d", bi.k620d.getText().toString().trim().isEmpty() ? "-1" : bi.k620d.getText().toString());
        json.put("k620e", bi.k620e.getText().toString().trim().isEmpty() ? "-1" : bi.k620e.getText().toString());


        //K621
        json.put("k621", bi.k621a.isChecked() ? "1"
                : bi.k621b.isChecked() ? "2"
                : bi.k621c.isChecked() ? "3"
                : "-1");

        json.put("k621d", bi.k621d.getText().toString().trim().isEmpty() ? "-1" : bi.k621d.getText().toString());
        json.put("k621e", bi.k621e.getText().toString().trim().isEmpty() ? "-1" : bi.k621e.getText().toString());


        //K622
        json.put("k622", bi.k622a.isChecked() ? "1"
                : bi.k622b.isChecked() ? "2"
                : bi.k622c.isChecked() ? "3"
                : "-1");

        json.put("k622d", bi.k622d.getText().toString().trim().isEmpty() ? "-1" : bi.k622d.getText().toString());
        json.put("k622e", bi.k622e.getText().toString().trim().isEmpty() ? "-1" : bi.k622e.getText().toString());


        //K623
        json.put("k623", bi.k623a.isChecked() ? "1"
                : bi.k623b.isChecked() ? "2"
                : bi.k623c.isChecked() ? "3"
                : "-1");

        json.put("k623d", bi.k623d.getText().toString().trim().isEmpty() ? "-1" : bi.k623d.getText().toString());
        json.put("k623e", bi.k623e.getText().toString().trim().isEmpty() ? "-1" : bi.k623e.getText().toString());


        //K624
        json.put("k624", bi.k624a.isChecked() ? "1"
                : bi.k624b.isChecked() ? "2"
                : bi.k624c.isChecked() ? "3"
                : "-1");

        json.put("k624d", bi.k624d.getText().toString().trim().isEmpty() ? "-1" : bi.k624d.getText().toString());
        json.put("k624e", bi.k624e.getText().toString().trim().isEmpty() ? "-1" : bi.k624e.getText().toString());


        //K625
        json.put("k625", bi.k625a.isChecked() ? "1"
                : bi.k625b.isChecked() ? "2"
                : bi.k625c.isChecked() ? "3"
                : "-1");

        json.put("k625d", bi.k625d.getText().toString().trim().isEmpty() ? "-1" : bi.k625d.getText().toString());
        json.put("k625e", bi.k625e.getText().toString().trim().isEmpty() ? "-1" : bi.k625e.getText().toString());


        //K626
        json.put("k626", bi.k626a.isChecked() ? "1"
                : bi.k626b.isChecked() ? "2"
                : bi.k626c.isChecked() ? "3"
                : "-1");

        json.put("k626d", bi.k626d.getText().toString().trim().isEmpty() ? "-1" : bi.k626d.getText().toString());
        json.put("k626e", bi.k626e.getText().toString().trim().isEmpty() ? "-1" : bi.k626e.getText().toString());


        //K627
        json.put("k627", bi.k627a.isChecked() ? "1"
                : bi.k627b.isChecked() ? "2"
                : bi.k627c.isChecked() ? "3"
                : "-1");

        json.put("k627d", bi.k627d.getText().toString().trim().isEmpty() ? "-1" : bi.k627d.getText().toString());
        json.put("k627e", bi.k627e.getText().toString().trim().isEmpty() ? "-1" : bi.k627e.getText().toString());


        //K628
        json.put("k628", bi.k628a.isChecked() ? "1"
                : bi.k628b.isChecked() ? "2"
                : bi.k628c.isChecked() ? "3"
                : "-1");

        json.put("k628d", bi.k628d.getText().toString().trim().isEmpty() ? "-1" : bi.k628d.getText().toString());
        json.put("k628e", bi.k628e.getText().toString().trim().isEmpty() ? "-1" : bi.k628e.getText().toString());


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
