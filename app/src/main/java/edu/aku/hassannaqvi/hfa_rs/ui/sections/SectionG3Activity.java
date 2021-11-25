package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static java.lang.Float.parseFloat;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.setMon1;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.setMon2;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.setMon3;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG3Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionG3Activity extends AppCompatActivity {

    ActivitySectionG3Binding bi;

    public static void setPreMonths() {

        List<String> allDates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM-yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);

        for (int i = 1; i <= 6; i++) {
            String monthName = sdf.format(cal.getTime());
            allDates.add(monthName);
            cal.add(Calendar.MONTH, -1);
        }

        Collections.shuffle(allDates);
        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    setMon1(allDates.get(i));
                    break;
                case 2:
                    setMon2(allDates.get(i));
                    break;
                case 3:
                    setMon3(allDates.get(i));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g3);
        bi.setCallback(this);
        //setPreMonths();
        setupTextWatchers();

        /*String[] one = MainApp.getMon1().split("-");
        bi.g0301aa.setText(one[0]);
        bi.g0301ab.setText(one[1]);

        String[] two = getMon2().split("-");
        bi.g0301ba.setText(two[0]);
        bi.g0301bb.setText(two[1]);

        String[] three = getMon3().split("-");
        bi.g0301ca.setText(three[0]);
        bi.g0301cb.setText(three[1]);*/

        //30-June Changes
        bi.g0301aa.setText("January");
        bi.g0301ab.setText("2020");

        bi.g0301ba.setText("February");
        bi.g0301bb.setText("2020");

        bi.g0301ca.setText("March");
        bi.g0301cb.setText("2020");

    }

    private void setupTextWatchers() {
        editTextImplementation(bi.g0302a10r, new EditTextPicker[]{bi.g0302a10i, bi.g0302a10d, bi.g0302a10b});
        editTextImplementation(bi.g0302a20r, new EditTextPicker[]{bi.g0302a20i, bi.g0302a20d, bi.g0302a20b});
        editTextImplementation(bi.g0302a30r, new EditTextPicker[]{bi.g0302a30i, bi.g0302a30d, bi.g0302a30b});
        editTextImplementation(bi.g0302a40r, new EditTextPicker[]{bi.g0302a40i, bi.g0302a40d, bi.g0302a40b});
        editTextImplementation(bi.g0302a50r, new EditTextPicker[]{bi.g0302a50i, bi.g0302a50d, bi.g0302a50b});
        editTextImplementation(bi.g0302a60r, new EditTextPicker[]{bi.g0302a60i, bi.g0302a60d, bi.g0302a60b});
        editTextImplementation(bi.g0302a70r, new EditTextPicker[]{bi.g0302a70i, bi.g0302a70d, bi.g0302a70b});
        editTextImplementation(bi.g0302b10r, new EditTextPicker[]{bi.g0302b10i, bi.g0302b10d, bi.g0302b10b});
        editTextImplementation(bi.g0302b20r, new EditTextPicker[]{bi.g0302b20i, bi.g0302b20d, bi.g0302b20b});
        editTextImplementation(bi.g0302b30r, new EditTextPicker[]{bi.g0302b30i, bi.g0302b30d, bi.g0302b30b});
        editTextImplementation(bi.g0302b40r, new EditTextPicker[]{bi.g0302b40i, bi.g0302b40d, bi.g0302b40b});
        editTextImplementation(bi.g0302b50r, new EditTextPicker[]{bi.g0302b50i, bi.g0302b50d, bi.g0302b50b});
        editTextImplementation(bi.g0302b60r, new EditTextPicker[]{bi.g0302b60i, bi.g0302b60d, bi.g0302b60b});
        editTextImplementation(bi.g0302b70r, new EditTextPicker[]{bi.g0302b70i, bi.g0302b70d, bi.g0302b70b});
        editTextImplementation(bi.g0302c10r, new EditTextPicker[]{bi.g0302c10i, bi.g0302c10d, bi.g0302c10b});
        editTextImplementation(bi.g0302c20r, new EditTextPicker[]{bi.g0302c20i, bi.g0302c20d, bi.g0302c20b});
        editTextImplementation(bi.g0302c30r, new EditTextPicker[]{bi.g0302c30i, bi.g0302c30d, bi.g0302c30b});
        editTextImplementation(bi.g0302c40r, new EditTextPicker[]{bi.g0302c40i, bi.g0302c40d, bi.g0302c40b});
        editTextImplementation(bi.g0302c50r, new EditTextPicker[]{bi.g0302c50i, bi.g0302c50d, bi.g0302c50b});
        editTextImplementation(bi.g0302c60r, new EditTextPicker[]{bi.g0302c60i, bi.g0302c60d, bi.g0302c60b});
        editTextImplementation(bi.g0302c70r, new EditTextPicker[]{bi.g0302c70i, bi.g0302c70d, bi.g0302c70b});
    }

    public void editTextImplementation(EditTextPicker edit01, EditTextPicker[] editTextsArray) {

        edit01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit01.getText()))
                    return;
                for (EditTextPicker item : editTextsArray) {
                    item.setMaxvalue(Integer.parseInt(edit01.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        editTextsArray[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit01.getText()) || TextUtils.isEmpty(editTextsArray[0].getText()))
                    return;
                editTextsArray[1].setText("");
                editTextsArray[2].setText("");
                editTextsArray[1].setMaxvalue(Integer.parseInt(edit01.getText().toString()) - Integer.parseInt(editTextsArray[0].getText().toString()));
                //editTextsArray[2].setText(String.valueOf(parseFloat(edit01.getText().toString()) - (parseFloat(editTextsArray[0].getText().toString()) + parseFloat(editTextsArray[1].getText().toString().trim()))));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });


        editTextsArray[1].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit01.getText()) || TextUtils.isEmpty(editTextsArray[0].getText()) || TextUtils.isEmpty(editTextsArray[1].getText()))
                    return;
                editTextsArray[2].setText("");
                editTextsArray[2].setEnabled(false);
                editTextsArray[2].setText(String.valueOf(parseFloat(edit01.getText().toString().trim()) - (parseFloat(editTextsArray[0].getText().toString().trim()) + parseFloat(editTextsArray[1].getText().toString().trim()))));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("g0301aa", bi.g0301aa.getText().toString().trim().isEmpty() ? "-1" : bi.g0301aa.getText().toString());
        json.put("g0301ab", bi.g0301ab.getText().toString().trim().isEmpty() ? "-1" : bi.g0301ab.getText().toString());

        json.put("g0301ba", bi.g0301ba.getText().toString().trim().isEmpty() ? "-1" : bi.g0301ba.getText().toString());
        json.put("g0301bb", bi.g0301bb.getText().toString().trim().isEmpty() ? "-1" : bi.g0301bb.getText().toString());

        json.put("g0301ca", bi.g0301ca.getText().toString().trim().isEmpty() ? "-1" : bi.g0301ca.getText().toString());
        json.put("g0301cb", bi.g0301cb.getText().toString().trim().isEmpty() ? "-1" : bi.g0301cb.getText().toString());


        json.put("g0302a10r", bi.g0302a10r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a10r.getText().toString());
        json.put("g0302a10i", bi.g0302a10i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a10i.getText().toString());
        json.put("g0302a10d", bi.g0302a10d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a10d.getText().toString());
        json.put("g0302a10b", bi.g0302a10b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a10b.getText().toString());

        json.put("g0302a20r", bi.g0302a20r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a20r.getText().toString());
        json.put("g0302a20i", bi.g0302a20i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a20i.getText().toString());
        json.put("g0302a20d", bi.g0302a20d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a20d.getText().toString());
        json.put("g0302a20b", bi.g0302a20b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a20b.getText().toString());

        json.put("g0302a30r", bi.g0302a30r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a30r.getText().toString());
        json.put("g0302a30i", bi.g0302a30i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a30i.getText().toString());
        json.put("g0302a30d", bi.g0302a30d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a30d.getText().toString());
        json.put("g0302a30b", bi.g0302a30b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a30b.getText().toString());

        json.put("g0302a40r", bi.g0302a40r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a40r.getText().toString());
        json.put("g0302a40i", bi.g0302a40i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a40i.getText().toString());
        json.put("g0302a40d", bi.g0302a40d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a40d.getText().toString());
        json.put("g0302a40b", bi.g0302a40b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a40b.getText().toString());

        json.put("g0302a50r", bi.g0302a50r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a50r.getText().toString());
        json.put("g0302a50i", bi.g0302a50i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a50i.getText().toString());
        json.put("g0302a50d", bi.g0302a50d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a50d.getText().toString());
        json.put("g0302a50b", bi.g0302a50b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a50b.getText().toString());

        json.put("g0302a60r", bi.g0302a60r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a60r.getText().toString());
        json.put("g0302a60i", bi.g0302a60i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a60i.getText().toString());
        json.put("g0302a60d", bi.g0302a60d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a60d.getText().toString());
        json.put("g0302a60b", bi.g0302a60b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a60b.getText().toString());

        json.put("g0302a70r", bi.g0302a70r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a70r.getText().toString());
        json.put("g0302a70i", bi.g0302a70i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a70i.getText().toString());
        json.put("g0302a70d", bi.g0302a70d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a70d.getText().toString());
        json.put("g0302a70b", bi.g0302a70b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302a70b.getText().toString());


        json.put("g0302b10r", bi.g0302b10r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b10r.getText().toString());
        json.put("g0302b10i", bi.g0302b10i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b10i.getText().toString());
        json.put("g0302b10d", bi.g0302b10d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b10d.getText().toString());
        json.put("g0302b10b", bi.g0302b10b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b10b.getText().toString());

        json.put("g0302b20r", bi.g0302b20r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b20r.getText().toString());
        json.put("g0302b20i", bi.g0302b20i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b20i.getText().toString());
        json.put("g0302b20d", bi.g0302b20d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b20d.getText().toString());
        json.put("g0302b20b", bi.g0302b20b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b20b.getText().toString());

        json.put("g0302b30r", bi.g0302b30r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b30r.getText().toString());
        json.put("g0302b30i", bi.g0302b30i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b30i.getText().toString());
        json.put("g0302b30d", bi.g0302b30d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b30d.getText().toString());
        json.put("g0302b30b", bi.g0302b30b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b30b.getText().toString());

        json.put("g0302b40r", bi.g0302b40r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b40r.getText().toString());
        json.put("g0302b40i", bi.g0302b40i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b40i.getText().toString());
        json.put("g0302b40d", bi.g0302b40d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b40d.getText().toString());
        json.put("g0302b40b", bi.g0302b40b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b40b.getText().toString());

        json.put("g0302b50r", bi.g0302b50r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b50r.getText().toString());
        json.put("g0302b50i", bi.g0302b50i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b50i.getText().toString());
        json.put("g0302b50d", bi.g0302b50d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b50d.getText().toString());
        json.put("g0302b50b", bi.g0302b50b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b50b.getText().toString());

        json.put("g0302b60r", bi.g0302b60r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b60r.getText().toString());
        json.put("g0302b60i", bi.g0302b60i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b60i.getText().toString());
        json.put("g0302b60d", bi.g0302b60d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b60d.getText().toString());
        json.put("g0302b60b", bi.g0302b60b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b60b.getText().toString());

        json.put("g0302b70r", bi.g0302b70r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b70r.getText().toString());
        json.put("g0302b70i", bi.g0302b70i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b70i.getText().toString());
        json.put("g0302b70d", bi.g0302b70d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b70d.getText().toString());
        json.put("g0302b70b", bi.g0302b70b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302b70b.getText().toString());


        json.put("g0302c10r", bi.g0302c10r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c10r.getText().toString());
        json.put("g0302c10i", bi.g0302c10i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c10i.getText().toString());
        json.put("g0302c10d", bi.g0302c10d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c10d.getText().toString());
        json.put("g0302c10b", bi.g0302c10b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c10b.getText().toString());

        json.put("g0302c20r", bi.g0302c20r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c20r.getText().toString());
        json.put("g0302c20i", bi.g0302c20i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c20i.getText().toString());
        json.put("g0302c20d", bi.g0302c20d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c20d.getText().toString());
        json.put("g0302c20b", bi.g0302c20b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c20b.getText().toString());

        json.put("g0302c30r", bi.g0302c30r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c30r.getText().toString());
        json.put("g0302c30i", bi.g0302c30i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c30i.getText().toString());
        json.put("g0302c30d", bi.g0302c30d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c30d.getText().toString());
        json.put("g0302c30b", bi.g0302c30b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c30b.getText().toString());

        json.put("g0302c40r", bi.g0302c40r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c40r.getText().toString());
        json.put("g0302c40i", bi.g0302c40i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c40i.getText().toString());
        json.put("g0302c40d", bi.g0302c40d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c40d.getText().toString());
        json.put("g0302c40b", bi.g0302c40b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c40b.getText().toString());

        json.put("g0302c50r", bi.g0302c50r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c50r.getText().toString());
        json.put("g0302c50i", bi.g0302c50i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c50i.getText().toString());
        json.put("g0302c50d", bi.g0302c50d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c50d.getText().toString());
        json.put("g0302c50b", bi.g0302c50b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c50b.getText().toString());

        json.put("g0302c60r", bi.g0302c60r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c60r.getText().toString());
        json.put("g0302c60i", bi.g0302c60i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c60i.getText().toString());
        json.put("g0302c60d", bi.g0302c60d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c60d.getText().toString());
        json.put("g0302c60b", bi.g0302c60b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c60b.getText().toString());

        json.put("g0302c70r", bi.g0302c70r.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c70r.getText().toString());
        json.put("g0302c70i", bi.g0302c70i.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c70i.getText().toString());
        json.put("g0302c70d", bi.g0302c70d.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c70d.getText().toString());
        json.put("g0302c70b", bi.g0302c70b.getText().toString().trim().isEmpty() ? "-1" : bi.g0302c70b.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsG()), json);

            MainApp.fc.setsG(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionG411Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
