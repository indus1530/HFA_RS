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

        /*bi.k00611.setOnCheckedChangeListener(((radioGroup, i) -> {
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
        }));*/

    }


    private void setupTextWatchers() {
        /*editTextImplementation(bi.k00611q, bi.k00612q);
        editTextImplementation(bi.k00621q, bi.k00622q);
        editTextImplementation(bi.k00631q, bi.k00632q);
        editTextImplementation(bi.k00641q, bi.k00642q);
        editTextImplementation(bi.k00651q, bi.k00652q);
        editTextImplementation(bi.k00661q, bi.k00662q);
        editTextImplementation(bi.k00671q, bi.k00672q);
        editTextImplementation(bi.k00681q, bi.k00682q);
        editTextImplementation(bi.k00691q, bi.k00692q);*/
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

        json.put("k601", bi.k601a.isChecked() ? "1"
                : bi.k601b.isChecked() ? "2"
                : bi.k601c.isChecked() ? "3"
                : bi.k601d.isChecked() ? "4"
                : bi.k601e.isChecked() ? "5"
                : "-1");

        json.put("k601dx", bi.k601dx.getText().toString());
        json.put("k601ex", bi.k601ex.getText().toString());
        json.put("k602", bi.k602a.isChecked() ? "1"
                : bi.k602b.isChecked() ? "2"
                : bi.k602c.isChecked() ? "3"
                : bi.k602d.isChecked() ? "4"
                : bi.k602e.isChecked() ? "5"
                : "-1");

        json.put("k602dx", bi.k602dx.getText().toString());
        json.put("k602ex", bi.k602ex.getText().toString());
        json.put("k603", bi.k603a.isChecked() ? "1"
                : bi.k603b.isChecked() ? "2"
                : bi.k603c.isChecked() ? "3"
                : bi.k603d.isChecked() ? "4"
                : bi.k603e.isChecked() ? "5"
                : "-1");

        json.put("k603dx", bi.k603dx.getText().toString());
        json.put("k603ex", bi.k603ex.getText().toString());
        json.put("k604", bi.k604a.isChecked() ? "1"
                : bi.k604b.isChecked() ? "2"
                : bi.k604c.isChecked() ? "3"
                : bi.k604d.isChecked() ? "4"
                : bi.k604e.isChecked() ? "5"
                : "-1");

        json.put("k604dx", bi.k604dx.getText().toString());
        json.put("k604ex", bi.k604ex.getText().toString());
        json.put("k605", bi.k605a.isChecked() ? "1"
                : bi.k605b.isChecked() ? "2"
                : bi.k605c.isChecked() ? "3"
                : bi.k605d.isChecked() ? "4"
                : bi.k605e.isChecked() ? "5"
                : "-1");

        json.put("k605dx", bi.k605dx.getText().toString());
        json.put("k605ex", bi.k605ex.getText().toString());
        json.put("k606", bi.k606a.isChecked() ? "1"
                : bi.k606b.isChecked() ? "2"
                : bi.k606c.isChecked() ? "3"
                : bi.k606d.isChecked() ? "4"
                : bi.k606e.isChecked() ? "5"
                : "-1");

        json.put("k606dx", bi.k606dx.getText().toString());
        json.put("k606ex", bi.k606ex.getText().toString());
        json.put("k607", bi.k607a.isChecked() ? "1"
                : bi.k607b.isChecked() ? "2"
                : bi.k607c.isChecked() ? "3"
                : bi.k607d.isChecked() ? "4"
                : bi.k607e.isChecked() ? "5"
                : "-1");

        json.put("k607dx", bi.k607dx.getText().toString());
        json.put("k607ex", bi.k607ex.getText().toString());
        json.put("k608", bi.k608a.isChecked() ? "1"
                : bi.k608b.isChecked() ? "2"
                : bi.k608c.isChecked() ? "3"
                : bi.k608d.isChecked() ? "4"
                : bi.k608e.isChecked() ? "5"
                : "-1");

        json.put("k608dx", bi.k608dx.getText().toString());
        json.put("k608ex", bi.k608ex.getText().toString());
        json.put("k609", bi.k609a.isChecked() ? "1"
                : bi.k609b.isChecked() ? "2"
                : bi.k609c.isChecked() ? "3"
                : bi.k609d.isChecked() ? "4"
                : bi.k609e.isChecked() ? "5"
                : "-1");

        json.put("k609dx", bi.k609dx.getText().toString());
        json.put("k609ex", bi.k609ex.getText().toString());
        json.put("k610", bi.k610a.isChecked() ? "1"
                : bi.k610b.isChecked() ? "2"
                : bi.k610c.isChecked() ? "3"
                : bi.k610d.isChecked() ? "4"
                : bi.k610e.isChecked() ? "5"
                : "-1");

        json.put("k610dx", bi.k610dx.getText().toString());
        json.put("k610ex", bi.k610ex.getText().toString());
        json.put("k611", bi.k611a.isChecked() ? "1"
                : bi.k611b.isChecked() ? "2"
                : bi.k611c.isChecked() ? "3"
                : bi.k611d.isChecked() ? "4"
                : bi.k611e.isChecked() ? "5"
                : "-1");

        json.put("k611dx", bi.k611dx.getText().toString());
        json.put("k611ex", bi.k611ex.getText().toString());
        json.put("k612", bi.k612a.isChecked() ? "1"
                : bi.k612b.isChecked() ? "2"
                : bi.k612c.isChecked() ? "3"
                : bi.k612d.isChecked() ? "4"
                : bi.k612e.isChecked() ? "5"
                : "-1");

        json.put("k612dx", bi.k612dx.getText().toString());
        json.put("k612ex", bi.k612ex.getText().toString());
        json.put("k613", bi.k613a.isChecked() ? "1"
                : bi.k613b.isChecked() ? "2"
                : bi.k613c.isChecked() ? "3"
                : bi.k613d.isChecked() ? "4"
                : bi.k613e.isChecked() ? "5"
                : "-1");

        json.put("k613dx", bi.k613dx.getText().toString());
        json.put("k613ex", bi.k613ex.getText().toString());
        json.put("k614", bi.k614a.isChecked() ? "1"
                : bi.k614b.isChecked() ? "2"
                : bi.k614c.isChecked() ? "3"
                : bi.k614d.isChecked() ? "4"
                : bi.k614e.isChecked() ? "5"
                : "-1");

        json.put("k614dx", bi.k614dx.getText().toString());
        json.put("k614ex", bi.k614ex.getText().toString());



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
