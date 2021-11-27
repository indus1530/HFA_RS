package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static java.lang.Float.parseFloat;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionC1Binding;

public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.c01aa, new EditTextPicker[]{bi.c01ab, bi.c01ad, bi.c01ae}, bi.c01ac);
        editTextImplementation(bi.c01ba, new EditTextPicker[]{bi.c01bb, bi.c01bd, bi.c01be}, bi.c01bc);
        editTextImplementation(bi.c01ca, new EditTextPicker[]{bi.c01cb, bi.c01cd, bi.c01ce}, bi.c01cc);
        editTextImplementation(bi.c01da, new EditTextPicker[]{bi.c01db, bi.c01dd, bi.c01de}, bi.c01dc);
        editTextImplementation(bi.c01ea, new EditTextPicker[]{bi.c01eb, bi.c01ed, bi.c01ee}, bi.c01ec);
        editTextImplementation(bi.c01fa, new EditTextPicker[]{bi.c01fb, bi.c01fd, bi.c01fe}, bi.c01fc);
        editTextImplementation(bi.c01ga, new EditTextPicker[]{bi.c01gb, bi.c01gd, bi.c01ge}, bi.c01gc);
        editTextImplementation(bi.c01ha, new EditTextPicker[]{bi.c01hb, bi.c01hd, bi.c01he}, bi.c01hc);
        editTextImplementation(bi.c01ia, new EditTextPicker[]{bi.c01ib, bi.c01id, bi.c01ie}, bi.c01ic);
        editTextImplementation(bi.c01ja, new EditTextPicker[]{bi.c01jb, bi.c01jd, bi.c01je}, bi.c01jc);
        editTextImplementation(bi.c01ka, new EditTextPicker[]{bi.c01kb, bi.c01kd, bi.c01ke}, bi.c01kc);
        editTextImplementation(bi.c01la, new EditTextPicker[]{bi.c01lb, bi.c01ld, bi.c01le}, bi.c01lc);
    }


    public void editTextImplementation(EditTextPicker edit01, EditTextPicker[] editTextsArray, EditTextPicker edit02) {

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
                for (EditTextPicker item : editTextsArray) {
                    item.setMaxvalue(Integer.parseInt(edit01.getText().toString().trim()));
                }
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
                edit02.setText("");
                edit02.setEnabled(false);
                editTextsArray[1].setMaxvalue(Integer.parseInt(editTextsArray[0].getText().toString().trim()));
                editTextsArray[2].setMaxvalue(Integer.parseInt(editTextsArray[0].getText().toString().trim()));
                edit02.setText(String.valueOf(parseFloat(edit01.getText().toString().trim()) - parseFloat(editTextsArray[0].getText().toString().trim())));

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, fc.getsC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("CDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("CTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("c01aa", bi.c01aa.getText().toString().trim().isEmpty() ? "-1" : bi.c01aa.getText().toString());
        json.put("c01ab", bi.c01ab.getText().toString().trim().isEmpty() ? "-1" : bi.c01ab.getText().toString());
        json.put("c01ac", bi.c01ac.getText().toString().trim().isEmpty() ? "-1" : bi.c01ac.getText().toString());
        json.put("c01ad", bi.c01ad.getText().toString().trim().isEmpty() ? "-1" : bi.c01ad.getText().toString());
        json.put("c01ae", bi.c01ae.getText().toString().trim().isEmpty() ? "-1" : bi.c01ae.getText().toString());

        json.put("c01ba", bi.c01ba.getText().toString().trim().isEmpty() ? "-1" : bi.c01ba.getText().toString());
        json.put("c01bb", bi.c01bb.getText().toString().trim().isEmpty() ? "-1" : bi.c01bb.getText().toString());
        json.put("c01bc", bi.c01bc.getText().toString().trim().isEmpty() ? "-1" : bi.c01bc.getText().toString());
        json.put("c01bd", bi.c01bd.getText().toString().trim().isEmpty() ? "-1" : bi.c01bd.getText().toString());
        json.put("c01be", bi.c01be.getText().toString().trim().isEmpty() ? "-1" : bi.c01be.getText().toString());

        json.put("c01ca", bi.c01ca.getText().toString().trim().isEmpty() ? "-1" : bi.c01ca.getText().toString());
        json.put("c01cb", bi.c01cb.getText().toString().trim().isEmpty() ? "-1" : bi.c01cb.getText().toString());
        json.put("c01cc", bi.c01cc.getText().toString().trim().isEmpty() ? "-1" : bi.c01cc.getText().toString());
        json.put("c01cd", bi.c01cd.getText().toString().trim().isEmpty() ? "-1" : bi.c01cd.getText().toString());
        json.put("c01ce", bi.c01ce.getText().toString().trim().isEmpty() ? "-1" : bi.c01ce.getText().toString());

        json.put("c01da", bi.c01da.getText().toString().trim().isEmpty() ? "-1" : bi.c01da.getText().toString());
        json.put("c01db", bi.c01db.getText().toString().trim().isEmpty() ? "-1" : bi.c01db.getText().toString());
        json.put("c01dc", bi.c01dc.getText().toString().trim().isEmpty() ? "-1" : bi.c01dc.getText().toString());
        json.put("c01dd", bi.c01dd.getText().toString().trim().isEmpty() ? "-1" : bi.c01dd.getText().toString());
        json.put("c01de", bi.c01de.getText().toString().trim().isEmpty() ? "-1" : bi.c01de.getText().toString());

        json.put("c01ea", bi.c01ea.getText().toString().trim().isEmpty() ? "-1" : bi.c01ea.getText().toString());
        json.put("c01eb", bi.c01eb.getText().toString().trim().isEmpty() ? "-1" : bi.c01eb.getText().toString());
        json.put("c01ec", bi.c01ec.getText().toString().trim().isEmpty() ? "-1" : bi.c01ec.getText().toString());
        json.put("c01ed", bi.c01ed.getText().toString().trim().isEmpty() ? "-1" : bi.c01ed.getText().toString());
        json.put("c01ee", bi.c01ee.getText().toString().trim().isEmpty() ? "-1" : bi.c01ee.getText().toString());

        json.put("c01fa", bi.c01fa.getText().toString().trim().isEmpty() ? "-1" : bi.c01fa.getText().toString());
        json.put("c01fb", bi.c01fb.getText().toString().trim().isEmpty() ? "-1" : bi.c01fb.getText().toString());
        json.put("c01fc", bi.c01fc.getText().toString().trim().isEmpty() ? "-1" : bi.c01fc.getText().toString());
        json.put("c01fd", bi.c01fd.getText().toString().trim().isEmpty() ? "-1" : bi.c01fd.getText().toString());
        json.put("c01fe", bi.c01fe.getText().toString().trim().isEmpty() ? "-1" : bi.c01fe.getText().toString());

        json.put("c01ga", bi.c01ga.getText().toString().trim().isEmpty() ? "-1" : bi.c01ga.getText().toString());
        json.put("c01gb", bi.c01gb.getText().toString().trim().isEmpty() ? "-1" : bi.c01gb.getText().toString());
        json.put("c01gc", bi.c01gc.getText().toString().trim().isEmpty() ? "-1" : bi.c01gc.getText().toString());
        json.put("c01gd", bi.c01gd.getText().toString().trim().isEmpty() ? "-1" : bi.c01gd.getText().toString());
        json.put("c01ge", bi.c01ge.getText().toString().trim().isEmpty() ? "-1" : bi.c01ge.getText().toString());

        json.put("c01ha", bi.c01ha.getText().toString().trim().isEmpty() ? "-1" : bi.c01ha.getText().toString());
        json.put("c01hb", bi.c01hb.getText().toString().trim().isEmpty() ? "-1" : bi.c01hb.getText().toString());
        json.put("c01hc", bi.c01hc.getText().toString().trim().isEmpty() ? "-1" : bi.c01hc.getText().toString());
        json.put("c01hd", bi.c01hd.getText().toString().trim().isEmpty() ? "-1" : bi.c01hd.getText().toString());
        json.put("c01he", bi.c01he.getText().toString().trim().isEmpty() ? "-1" : bi.c01he.getText().toString());

        json.put("c01ia", bi.c01ia.getText().toString().trim().isEmpty() ? "-1" : bi.c01ia.getText().toString());
        json.put("c01ib", bi.c01ib.getText().toString().trim().isEmpty() ? "-1" : bi.c01ib.getText().toString());
        json.put("c01ic", bi.c01ic.getText().toString().trim().isEmpty() ? "-1" : bi.c01ic.getText().toString());
        json.put("c01id", bi.c01id.getText().toString().trim().isEmpty() ? "-1" : bi.c01id.getText().toString());
        json.put("c01ie", bi.c01ie.getText().toString().trim().isEmpty() ? "-1" : bi.c01ie.getText().toString());

        json.put("c01ja", bi.c01ja.getText().toString().trim().isEmpty() ? "-1" : bi.c01ja.getText().toString());
        json.put("c01jb", bi.c01jb.getText().toString().trim().isEmpty() ? "-1" : bi.c01jb.getText().toString());
        json.put("c01jc", bi.c01jc.getText().toString().trim().isEmpty() ? "-1" : bi.c01jc.getText().toString());
        json.put("c01jd", bi.c01jd.getText().toString().trim().isEmpty() ? "-1" : bi.c01jd.getText().toString());
        json.put("c01je", bi.c01je.getText().toString().trim().isEmpty() ? "-1" : bi.c01je.getText().toString());

        json.put("c01ka", bi.c01ka.getText().toString().trim().isEmpty() ? "-1" : bi.c01ka.getText().toString());
        json.put("c01kb", bi.c01kb.getText().toString().trim().isEmpty() ? "-1" : bi.c01kb.getText().toString());
        json.put("c01kc", bi.c01kc.getText().toString().trim().isEmpty() ? "-1" : bi.c01kc.getText().toString());
        json.put("c01kd", bi.c01kd.getText().toString().trim().isEmpty() ? "-1" : bi.c01kd.getText().toString());
        json.put("c01ke", bi.c01ke.getText().toString().trim().isEmpty() ? "-1" : bi.c01ke.getText().toString());

        json.put("c01la", bi.c01la.getText().toString().trim().isEmpty() ? "-1" : bi.c01la.getText().toString());
        json.put("c01lb", bi.c01lb.getText().toString().trim().isEmpty() ? "-1" : bi.c01lb.getText().toString());
        json.put("c01lc", bi.c01lc.getText().toString().trim().isEmpty() ? "-1" : bi.c01lc.getText().toString());
        json.put("c01ld", bi.c01ld.getText().toString().trim().isEmpty() ? "-1" : bi.c01ld.getText().toString());
        json.put("c01le", bi.c01le.getText().toString().trim().isEmpty() ? "-1" : bi.c01le.getText().toString());

        fc.setsC(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, SectionC2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    public void BtnEnd(View v) {
        //openSectionMainActivity(this, "C");
    }
}
