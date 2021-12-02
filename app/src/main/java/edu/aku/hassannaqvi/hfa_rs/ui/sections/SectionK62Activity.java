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

        /*bi.k0060101.setOnCheckedChangeListener(((radioGroup, i) -> {
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
*/
    }


    private void setupTextWatchers() {
        /*editTextImplementation(bi.k0060101q, bi.k0060102q);
        editTextImplementation(bi.k0060111q, bi.k0060112q);
        editTextImplementation(bi.k0060121q, bi.k0060122q);
        editTextImplementation(bi.k0060131q, bi.k0060132q);
        editTextImplementation(bi.k0060141q, bi.k0060142q);
        editTextImplementation(bi.k0060151q, bi.k0060152q);
        editTextImplementation(bi.k0060161q, bi.k0060162q);
        editTextImplementation(bi.k0060171q, bi.k0060172q);
        editTextImplementation(bi.k0060181q, bi.k0060182q);
        editTextImplementation(bi.k0060191q, bi.k0060192q);*/
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


        json.put("k615", bi.k615a.isChecked() ? "1"
                : bi.k615b.isChecked() ? "2"
                : bi.k615c.isChecked() ? "3"
                : bi.k615d.isChecked() ? "4"
                : bi.k615e.isChecked() ? "5"
                : "-1");

        json.put("k615dx", bi.k615dx.getText().toString());
        json.put("k615ex", bi.k615ex.getText().toString());
        json.put("k616", bi.k616a.isChecked() ? "1"
                : bi.k616b.isChecked() ? "2"
                : bi.k616c.isChecked() ? "3"
                : bi.k616d.isChecked() ? "4"
                : bi.k616e.isChecked() ? "5"
                : "-1");

        json.put("k616dx", bi.k616dx.getText().toString());
        json.put("k616ex", bi.k616ex.getText().toString());
        json.put("k617", bi.k617a.isChecked() ? "1"
                : bi.k617b.isChecked() ? "2"
                : bi.k617c.isChecked() ? "3"
                : bi.k617d.isChecked() ? "4"
                : bi.k617e.isChecked() ? "5"
                : "-1");

        json.put("k617dx", bi.k617dx.getText().toString());
        json.put("k617ex", bi.k617ex.getText().toString());
        json.put("k618", bi.k618a.isChecked() ? "1"
                : bi.k618b.isChecked() ? "2"
                : bi.k618c.isChecked() ? "3"
                : bi.k618d.isChecked() ? "4"
                : bi.k618e.isChecked() ? "5"
                : "-1");

        json.put("k618dx", bi.k618dx.getText().toString());
        json.put("k618ex", bi.k618ex.getText().toString());
        json.put("k619", bi.k619a.isChecked() ? "1"
                : bi.k619b.isChecked() ? "2"
                : bi.k619c.isChecked() ? "3"
                : bi.k619d.isChecked() ? "4"
                : bi.k619e.isChecked() ? "5"
                : "-1");

        json.put("k619dx", bi.k619dx.getText().toString());
        json.put("k619ex", bi.k619ex.getText().toString());
        json.put("k620", bi.k620a.isChecked() ? "1"
                : bi.k620b.isChecked() ? "2"
                : bi.k620c.isChecked() ? "3"
                : bi.k620d.isChecked() ? "4"
                : bi.k620e.isChecked() ? "5"
                : "-1");

        json.put("k620dx", bi.k620dx.getText().toString());
        json.put("k620ex", bi.k620ex.getText().toString());
        json.put("k621", bi.k621a.isChecked() ? "1"
                : bi.k621b.isChecked() ? "2"
                : bi.k621c.isChecked() ? "3"
                : bi.k621d.isChecked() ? "4"
                : bi.k621e.isChecked() ? "5"
                : "-1");

        json.put("k621dx", bi.k621dx.getText().toString());
        json.put("k621ex", bi.k621ex.getText().toString());
        json.put("k622", bi.k622a.isChecked() ? "1"
                : bi.k622b.isChecked() ? "2"
                : bi.k622c.isChecked() ? "3"
                : bi.k622d.isChecked() ? "4"
                : bi.k622e.isChecked() ? "5"
                : "-1");

        json.put("k622dx", bi.k622dx.getText().toString());
        json.put("k622ex", bi.k622ex.getText().toString());
        json.put("k623", bi.k623a.isChecked() ? "1"
                : bi.k623b.isChecked() ? "2"
                : bi.k623c.isChecked() ? "3"
                : bi.k623d.isChecked() ? "4"
                : bi.k623e.isChecked() ? "5"
                : "-1");

        json.put("k623dx", bi.k623dx.getText().toString());
        json.put("k623ex", bi.k623ex.getText().toString());
        json.put("k624", bi.k624a.isChecked() ? "1"
                : bi.k624b.isChecked() ? "2"
                : bi.k624c.isChecked() ? "3"
                : bi.k624d.isChecked() ? "4"
                : bi.k624e.isChecked() ? "5"
                : "-1");

        json.put("k624dx", bi.k624dx.getText().toString());
        json.put("k624ex", bi.k624ex.getText().toString());
        json.put("k625", bi.k625a.isChecked() ? "1"
                : bi.k625b.isChecked() ? "2"
                : bi.k625c.isChecked() ? "3"
                : bi.k625d.isChecked() ? "4"
                : bi.k625e.isChecked() ? "5"
                : "-1");

        json.put("k625dx", bi.k625dx.getText().toString());
        json.put("k625ex", bi.k625ex.getText().toString());
        json.put("k626", bi.k626a.isChecked() ? "1"
                : bi.k626b.isChecked() ? "2"
                : bi.k626c.isChecked() ? "3"
                : bi.k626d.isChecked() ? "4"
                : bi.k626e.isChecked() ? "5"
                : "-1");

        json.put("k626dx", bi.k626dx.getText().toString());
        json.put("k626ex", bi.k626ex.getText().toString());
        json.put("k627", bi.k627a.isChecked() ? "1"
                : bi.k627b.isChecked() ? "2"
                : bi.k627c.isChecked() ? "3"
                : bi.k627d.isChecked() ? "4"
                : bi.k627e.isChecked() ? "5"
                : "-1");

        json.put("k627dx", bi.k627dx.getText().toString());
        json.put("k627ex", bi.k627ex.getText().toString());
        json.put("k628", bi.k628a.isChecked() ? "1"
                : bi.k628b.isChecked() ? "2"
                : bi.k628c.isChecked() ? "3"
                : bi.k628d.isChecked() ? "4"
                : bi.k628e.isChecked() ? "5"
                : "-1");

        json.put("k628dx", bi.k628dx.getText().toString());
        json.put("k628ex", bi.k628ex.getText().toString());


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
