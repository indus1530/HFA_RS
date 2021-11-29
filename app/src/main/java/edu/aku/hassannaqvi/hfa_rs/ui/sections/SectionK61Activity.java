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
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK61Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK61Activity extends AppCompatActivity {

    ActivitySectionK61Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k61);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();

    }


    private void setupSkips() {

        bi.k00611.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00612);
        }));


        bi.k00621.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00622);
        }));


        bi.k00631.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00632);
        }));


        bi.k00641.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00642);
        }));


        bi.k00651.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00652);
        }));


        bi.k00661.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00662);
        }));


        bi.k00671.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00672);
        }));


        bi.k00681.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00682);
        }));


        bi.k00691.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk00692);
        }));

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.k00611q, bi.k00612q);
        editTextImplementation(bi.k00621q, bi.k00622q);
        editTextImplementation(bi.k00631q, bi.k00632q);
        editTextImplementation(bi.k00641q, bi.k00642q);
        editTextImplementation(bi.k00651q, bi.k00652q);
        editTextImplementation(bi.k00661q, bi.k00662q);
        editTextImplementation(bi.k00671q, bi.k00672q);
        editTextImplementation(bi.k00681q, bi.k00682q);
        editTextImplementation(bi.k00691q, bi.k00692q);
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


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionK62Activity.class));
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

        json.put("k00611", bi.k00611a.isChecked() ? "1"
                : bi.k00611b.isChecked() ? "2"
                : bi.k00611c.isChecked() ? "3"
                : "-1");
        json.put("k00611q", bi.k00611q.getText().toString().trim().isEmpty() ? "-1" : bi.k00611q.getText().toString());

        json.put("k00612", bi.k00612a.isChecked() ? "1"
                : bi.k00612b.isChecked() ? "2"
                : "-1");
        json.put("k00612q", bi.k00612q.getText().toString().trim().isEmpty() ? "-1" : bi.k00612q.getText().toString());


        json.put("k00621", bi.k00621a.isChecked() ? "1"
                : bi.k00621b.isChecked() ? "2"
                : bi.k00621c.isChecked() ? "3"
                : "-1");
        json.put("k00621q", bi.k00621q.getText().toString().trim().isEmpty() ? "-1" : bi.k00621q.getText().toString());

        json.put("k00622", bi.k00622a.isChecked() ? "1"
                : bi.k00622b.isChecked() ? "2"
                : "-1");
        json.put("k00622q", bi.k00622q.getText().toString().trim().isEmpty() ? "-1" : bi.k00622q.getText().toString());


        json.put("k00631", bi.k00631a.isChecked() ? "1"
                : bi.k00631b.isChecked() ? "2"
                : bi.k00631c.isChecked() ? "3"
                : "-1");
        json.put("k00631q", bi.k00631q.getText().toString().trim().isEmpty() ? "-1" : bi.k00631q.getText().toString());

        json.put("k00632", bi.k00632a.isChecked() ? "1"
                : bi.k00632b.isChecked() ? "2"
                : "-1");
        json.put("k00632q", bi.k00632q.getText().toString().trim().isEmpty() ? "-1" : bi.k00632q.getText().toString());


        json.put("k00641", bi.k00641a.isChecked() ? "1"
                : bi.k00641b.isChecked() ? "2"
                : bi.k00641c.isChecked() ? "3"
                : "-1");
        json.put("k00641q", bi.k00641q.getText().toString().trim().isEmpty() ? "-1" : bi.k00641q.getText().toString());

        json.put("k00642", bi.k00642a.isChecked() ? "1"
                : bi.k00642b.isChecked() ? "2"
                : "-1");
        json.put("k00642q", bi.k00642q.getText().toString().trim().isEmpty() ? "-1" : bi.k00642q.getText().toString());


        json.put("k00651", bi.k00651a.isChecked() ? "1"
                : bi.k00651b.isChecked() ? "2"
                : bi.k00651c.isChecked() ? "3"
                : "-1");
        json.put("k00651q", bi.k00651q.getText().toString().trim().isEmpty() ? "-1" : bi.k00651q.getText().toString());

        json.put("k00652", bi.k00652a.isChecked() ? "1"
                : bi.k00652b.isChecked() ? "2"
                : "-1");
        json.put("k00652q", bi.k00652q.getText().toString().trim().isEmpty() ? "-1" : bi.k00652q.getText().toString());


        json.put("k00661", bi.k00661a.isChecked() ? "1"
                : bi.k00661b.isChecked() ? "2"
                : bi.k00661c.isChecked() ? "3"
                : "-1");
        json.put("k00661q", bi.k00661q.getText().toString().trim().isEmpty() ? "-1" : bi.k00661q.getText().toString());

        json.put("k00662", bi.k00662a.isChecked() ? "1"
                : bi.k00662b.isChecked() ? "2"
                : "-1");
        json.put("k00662q", bi.k00662q.getText().toString().trim().isEmpty() ? "-1" : bi.k00662q.getText().toString());


        json.put("k00671", bi.k00671a.isChecked() ? "1"
                : bi.k00671b.isChecked() ? "2"
                : bi.k00671c.isChecked() ? "3"
                : "-1");
        json.put("k00671q", bi.k00671q.getText().toString().trim().isEmpty() ? "-1" : bi.k00671q.getText().toString());

        json.put("k00672", bi.k00672a.isChecked() ? "1"
                : bi.k00672b.isChecked() ? "2"
                : "-1");
        json.put("k00672q", bi.k00672q.getText().toString().trim().isEmpty() ? "-1" : bi.k00672q.getText().toString());


        json.put("k00681", bi.k00681a.isChecked() ? "1"
                : bi.k00681b.isChecked() ? "2"
                : bi.k00681c.isChecked() ? "3"
                : "-1");
        json.put("k00681q", bi.k00681q.getText().toString().trim().isEmpty() ? "-1" : bi.k00681q.getText().toString());

        json.put("k00682", bi.k00682a.isChecked() ? "1"
                : bi.k00682b.isChecked() ? "2"
                : "-1");
        json.put("k00682q", bi.k00682q.getText().toString().trim().isEmpty() ? "-1" : bi.k00682q.getText().toString());


        json.put("k00691", bi.k00691a.isChecked() ? "1"
                : bi.k00691b.isChecked() ? "2"
                : bi.k00691c.isChecked() ? "3"
                : "-1");
        json.put("k00691q", bi.k00691q.getText().toString().trim().isEmpty() ? "-1" : bi.k00691q.getText().toString());

        json.put("k00692", bi.k00692a.isChecked() ? "1"
                : bi.k00692b.isChecked() ? "2"
                : "-1");
        json.put("k00692q", bi.k00692q.getText().toString().trim().isEmpty() ? "-1" : bi.k00692q.getText().toString());


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


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
