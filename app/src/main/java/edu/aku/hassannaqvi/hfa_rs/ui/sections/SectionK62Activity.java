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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK62Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionK62Activity extends AppCompatActivity {

    ActivitySectionK62Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k62);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();

    }


    private void setupSkips() {

        bi.k0060101.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060102);
        }));

        bi.k0060111.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060112);
        }));

        bi.k0060121.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060122);
        }));

        bi.k0060131.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060132);
        }));

        bi.k0060141.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060142);
        }));

        bi.k0060151.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060152);
        }));

        bi.k0060161.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060162);
        }));

        bi.k0060171.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060172);
        }));

        bi.k0060181.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060182);
        }));

        bi.k0060191.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0060192);
        }));

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.k0060101q, bi.k0060102q);
        editTextImplementation(bi.k0060111q, bi.k0060112q);
        editTextImplementation(bi.k0060121q, bi.k0060122q);
        editTextImplementation(bi.k0060131q, bi.k0060132q);
        editTextImplementation(bi.k0060141q, bi.k0060142q);
        editTextImplementation(bi.k0060151q, bi.k0060152q);
        editTextImplementation(bi.k0060161q, bi.k0060162q);
        editTextImplementation(bi.k0060171q, bi.k0060172q);
        editTextImplementation(bi.k0060181q, bi.k0060182q);
        editTextImplementation(bi.k0060191q, bi.k0060192q);
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
            startActivity(new Intent(this, SectionK63Activity.class));
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


        json.put("k0060101", bi.k0060101a.isChecked() ? "1"
                : bi.k0060101b.isChecked() ? "2"
                : bi.k0060101c.isChecked() ? "3"
                : "-1");
        json.put("k0060101q", bi.k0060101q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060101q.getText().toString());

        json.put("k0060102", bi.k0060102a.isChecked() ? "1"
                : bi.k0060102b.isChecked() ? "2"
                : "-1");
        json.put("k0060102q", bi.k0060102q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060102q.getText().toString());


        json.put("k0060111", bi.k0060111a.isChecked() ? "1"
                : bi.k0060111b.isChecked() ? "2"
                : bi.k0060111c.isChecked() ? "3"
                : "-1");
        json.put("k0060111q", bi.k0060111q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060111q.getText().toString());

        json.put("k0060112", bi.k0060112a.isChecked() ? "1"
                : bi.k0060112b.isChecked() ? "2"
                : "-1");
        json.put("k0060112q", bi.k0060112q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060112q.getText().toString());


        json.put("k0060121", bi.k0060121a.isChecked() ? "1"
                : bi.k0060121b.isChecked() ? "2"
                : bi.k0060121c.isChecked() ? "3"
                : "-1");
        json.put("k0060121q", bi.k0060121q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060121q.getText().toString());

        json.put("k0060122", bi.k0060122a.isChecked() ? "1"
                : bi.k0060122b.isChecked() ? "2"
                : "-1");
        json.put("k0060122q", bi.k0060122q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060122q.getText().toString());


        json.put("k0060131", bi.k0060131a.isChecked() ? "1"
                : bi.k0060131b.isChecked() ? "2"
                : bi.k0060131c.isChecked() ? "3"
                : "-1");
        json.put("k0060131q", bi.k0060131q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060131q.getText().toString());

        json.put("k0060132", bi.k0060132a.isChecked() ? "1"
                : bi.k0060132b.isChecked() ? "2"
                : "-1");
        json.put("k0060132q", bi.k0060132q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060132q.getText().toString());


        json.put("k0060141", bi.k0060141a.isChecked() ? "1"
                : bi.k0060141b.isChecked() ? "2"
                : bi.k0060141c.isChecked() ? "3"
                : "-1");
        json.put("k0060141q", bi.k0060141q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060141q.getText().toString());

        json.put("k0060142", bi.k0060142a.isChecked() ? "1"
                : bi.k0060142b.isChecked() ? "2"
                : "-1");
        json.put("k0060142q", bi.k0060142q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060142q.getText().toString());


        json.put("k0060151", bi.k0060151a.isChecked() ? "1"
                : bi.k0060151b.isChecked() ? "2"
                : bi.k0060151c.isChecked() ? "3"
                : "-1");
        json.put("k0060151q", bi.k0060151q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060151q.getText().toString());

        json.put("k0060152", bi.k0060152a.isChecked() ? "1"
                : bi.k0060152b.isChecked() ? "2"
                : "-1");
        json.put("k0060152q", bi.k0060152q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060152q.getText().toString());


        json.put("k0060161", bi.k0060161a.isChecked() ? "1"
                : bi.k0060161b.isChecked() ? "2"
                : bi.k0060161c.isChecked() ? "3"
                : "-1");
        json.put("k0060161q", bi.k0060161q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060161q.getText().toString());

        json.put("k0060162", bi.k0060162a.isChecked() ? "1"
                : bi.k0060162b.isChecked() ? "2"
                : "-1");
        json.put("k0060162q", bi.k0060162q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060162q.getText().toString());


        json.put("k0060171", bi.k0060171a.isChecked() ? "1"
                : bi.k0060171b.isChecked() ? "2"
                : bi.k0060171c.isChecked() ? "3"
                : "-1");
        json.put("k0060171q", bi.k0060171q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060171q.getText().toString());

        json.put("k0060172", bi.k0060172a.isChecked() ? "1"
                : bi.k0060172b.isChecked() ? "2"
                : "-1");
        json.put("k0060172q", bi.k0060172q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060172q.getText().toString());


        json.put("k0060181", bi.k0060181a.isChecked() ? "1"
                : bi.k0060181b.isChecked() ? "2"
                : bi.k0060181c.isChecked() ? "3"
                : "-1");
        json.put("k0060181q", bi.k0060181q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060181q.getText().toString());

        json.put("k0060182", bi.k0060182a.isChecked() ? "1"
                : bi.k0060182b.isChecked() ? "2"
                : "-1");
        json.put("k0060182q", bi.k0060182q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060182q.getText().toString());


        json.put("k0060191", bi.k0060191a.isChecked() ? "1"
                : bi.k0060191b.isChecked() ? "2"
                : bi.k0060191c.isChecked() ? "3"
                : "-1");
        json.put("k0060191q", bi.k0060191q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060191q.getText().toString());

        json.put("k0060192", bi.k0060192a.isChecked() ? "1"
                : bi.k0060192b.isChecked() ? "2"
                : "-1");
        json.put("k0060192q", bi.k0060192q.getText().toString().trim().isEmpty() ? "-1" : bi.k0060192q.getText().toString());


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
