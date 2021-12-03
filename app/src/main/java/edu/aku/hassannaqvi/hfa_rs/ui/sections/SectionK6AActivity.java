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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK6aBinding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK6AActivity extends AppCompatActivity {
    ActivitySectionK6aBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k6a);
        bi.setCallback(this);
        setupTextWatchers();

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.k601d, bi.k601e);
        editTextImplementation(bi.k602d, bi.k602e);
        editTextImplementation(bi.k603d, bi.k603e);
        editTextImplementation(bi.k604d, bi.k604e);
        editTextImplementation(bi.k605d, bi.k605e);
        editTextImplementation(bi.k606d, bi.k606e);
        editTextImplementation(bi.k607d, bi.k607e);
        editTextImplementation(bi.k608d, bi.k608e);
        editTextImplementation(bi.k609d, bi.k609e);
        editTextImplementation(bi.k610d, bi.k610e);
        editTextImplementation(bi.k611d, bi.k611e);
        editTextImplementation(bi.k612d, bi.k612e);
        editTextImplementation(bi.k613d, bi.k613e);
        editTextImplementation(bi.k614d, bi.k614e);
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


        //K601
        json.put("k601", bi.k601a.isChecked() ? "1"
                : bi.k601b.isChecked() ? "2"
                : bi.k601c.isChecked() ? "3"
                : "-1");

        json.put("k601d", bi.k601d.getText().toString().trim().isEmpty() ? "-1" : bi.k601d.getText().toString());
        json.put("k601e", bi.k601e.getText().toString().trim().isEmpty() ? "-1" : bi.k601e.getText().toString());


        //K602
        json.put("k602", bi.k602a.isChecked() ? "1"
                : bi.k602b.isChecked() ? "2"
                : bi.k602c.isChecked() ? "3"
                : "-1");

        json.put("k602d", bi.k602d.getText().toString().trim().isEmpty() ? "-1" : bi.k602d.getText().toString());
        json.put("k602e", bi.k602e.getText().toString().trim().isEmpty() ? "-1" : bi.k602e.getText().toString());


        //K603
        json.put("k603", bi.k603a.isChecked() ? "1"
                : bi.k603b.isChecked() ? "2"
                : bi.k603c.isChecked() ? "3"
                : "-1");

        json.put("k603d", bi.k603d.getText().toString().trim().isEmpty() ? "-1" : bi.k603d.getText().toString());
        json.put("k603e", bi.k603e.getText().toString().trim().isEmpty() ? "-1" : bi.k603e.getText().toString());


        //K601
        json.put("k604", bi.k604a.isChecked() ? "1"
                : bi.k604b.isChecked() ? "2"
                : bi.k604c.isChecked() ? "3"
                : "-1");

        json.put("k604d", bi.k604d.getText().toString().trim().isEmpty() ? "-1" : bi.k604d.getText().toString());
        json.put("k604e", bi.k604e.getText().toString().trim().isEmpty() ? "-1" : bi.k604e.getText().toString());


        //K601
        json.put("k605", bi.k605a.isChecked() ? "1"
                : bi.k605b.isChecked() ? "2"
                : bi.k605c.isChecked() ? "3"
                : "-1");

        json.put("k605d", bi.k605d.getText().toString().trim().isEmpty() ? "-1" : bi.k605d.getText().toString());
        json.put("k605e", bi.k605e.getText().toString().trim().isEmpty() ? "-1" : bi.k605e.getText().toString());


        //K606
        json.put("k606", bi.k606a.isChecked() ? "1"
                : bi.k606b.isChecked() ? "2"
                : bi.k606c.isChecked() ? "3"
                : "-1");

        json.put("k606d", bi.k606d.getText().toString().trim().isEmpty() ? "-1" : bi.k606d.getText().toString());
        json.put("k606e", bi.k606e.getText().toString().trim().isEmpty() ? "-1" : bi.k606e.getText().toString());


        //K607
        json.put("k607", bi.k607a.isChecked() ? "1"
                : bi.k607b.isChecked() ? "2"
                : bi.k607c.isChecked() ? "3"
                : "-1");

        json.put("k607d", bi.k607d.getText().toString().trim().isEmpty() ? "-1" : bi.k607d.getText().toString());
        json.put("k607e", bi.k607e.getText().toString().trim().isEmpty() ? "-1" : bi.k607e.getText().toString());


        //K608
        json.put("k608", bi.k608a.isChecked() ? "1"
                : bi.k608b.isChecked() ? "2"
                : bi.k608c.isChecked() ? "3"
                : "-1");

        json.put("k608d", bi.k608d.getText().toString().trim().isEmpty() ? "-1" : bi.k608d.getText().toString());
        json.put("k608e", bi.k608e.getText().toString().trim().isEmpty() ? "-1" : bi.k608e.getText().toString());


        //K609
        json.put("k609", bi.k609a.isChecked() ? "1"
                : bi.k609b.isChecked() ? "2"
                : bi.k609c.isChecked() ? "3"
                : "-1");

        json.put("k609d", bi.k609d.getText().toString().trim().isEmpty() ? "-1" : bi.k609d.getText().toString());
        json.put("k609e", bi.k609e.getText().toString().trim().isEmpty() ? "-1" : bi.k609e.getText().toString());


        //K610
        json.put("k610", bi.k610a.isChecked() ? "1"
                : bi.k610b.isChecked() ? "2"
                : bi.k610c.isChecked() ? "3"
                : "-1");

        json.put("k610d", bi.k610d.getText().toString().trim().isEmpty() ? "-1" : bi.k610d.getText().toString());
        json.put("k610e", bi.k610e.getText().toString().trim().isEmpty() ? "-1" : bi.k610e.getText().toString());


        //K611
        json.put("k611", bi.k611a.isChecked() ? "1"
                : bi.k611b.isChecked() ? "2"
                : bi.k611c.isChecked() ? "3"
                : "-1");

        json.put("k611d", bi.k611d.getText().toString().trim().isEmpty() ? "-1" : bi.k611d.getText().toString());
        json.put("k611e", bi.k611e.getText().toString().trim().isEmpty() ? "-1" : bi.k611e.getText().toString());


        //K612
        json.put("k612", bi.k612a.isChecked() ? "1"
                : bi.k612b.isChecked() ? "2"
                : bi.k612c.isChecked() ? "3"
                : "-1");

        json.put("k612d", bi.k612d.getText().toString().trim().isEmpty() ? "-1" : bi.k612d.getText().toString());
        json.put("k612e", bi.k612e.getText().toString().trim().isEmpty() ? "-1" : bi.k612e.getText().toString());


        //K613
        json.put("k613", bi.k613a.isChecked() ? "1"
                : bi.k613b.isChecked() ? "2"
                : bi.k613c.isChecked() ? "3"
                : "-1");

        json.put("k613d", bi.k613d.getText().toString().trim().isEmpty() ? "-1" : bi.k613d.getText().toString());
        json.put("k613e", bi.k613e.getText().toString().trim().isEmpty() ? "-1" : bi.k613e.getText().toString());


        //K614
        json.put("k614", bi.k614a.isChecked() ? "1"
                : bi.k614b.isChecked() ? "2"
                : bi.k614c.isChecked() ? "3"
                : "-1");

        json.put("k614d", bi.k614d.getText().toString().trim().isEmpty() ? "-1" : bi.k614d.getText().toString());
        json.put("k614e", bi.k614e.getText().toString().trim().isEmpty() ? "-1" : bi.k614e.getText().toString());


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
