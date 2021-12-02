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
