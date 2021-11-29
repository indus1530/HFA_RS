package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ4Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ4Activity extends AppCompatActivity {

    ActivitySectionJ4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j4);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0401a);
        radioGroup(bi.j0401b);
        radioGroup(bi.j0401c);
        radioGroup(bi.j0401d);
        radioGroup(bi.j0401e);
        radioGroup(bi.j0401f);
        radioGroup(bi.j0401g);
        radioGroup(bi.j0401h);
        radioGroup(bi.j0401i);
        radioGroup(bi.j0401j);
        radioGroup(bi.j0401k);
        radioGroup(bi.j0401l);
    }


    public void hideKeyboard(View v) {
        InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0401ab.isChecked() || bi.j0401bb.isChecked() || bi.j0401cb.isChecked()
                    || bi.j0401db.isChecked() || bi.j0401eb.isChecked() || bi.j0401fb.isChecked()
                    || bi.j0401gb.isChecked() || bi.j0401hb.isChecked() || bi.j0401ib.isChecked()
                    || bi.j0401jb.isChecked() || bi.j0401kb.isChecked() || bi.j0401lb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0401m);
                bi.fldGrpCVj0401m.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0401m);
                bi.fldGrpCVj0401m.setVisibility(View.GONE);
            }
        }));
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
            Intent intent;

            if (fc.getA10().equals("2") && !fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ8Activity.class);
            } else {
                intent = new Intent(this, SectionJ5Activity.class);
            }
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0400a", bi.j0400a.getText().toString().trim().length() > 0 ? bi.j0400a.getText().toString() : "-1");
        json.put("j0400b", bi.j0400b.getText().toString().trim().length() > 0 ? bi.j0400b.getText().toString() : "-1");

        json.put("j0400c", bi.j0400ca.isChecked() ? "1"
                : bi.j0400cb.isChecked() ? "2"
                : "-1");

        json.put("j0401a", bi.j0401aa.isChecked() ? "1"
                : bi.j0401ab.isChecked() ? "2"
                : "-1");

        json.put("j0401b", bi.j0401ba.isChecked() ? "1"
                : bi.j0401bb.isChecked() ? "2"
                : "-1");

        json.put("j0401c", bi.j0401ca.isChecked() ? "1"
                : bi.j0401cb.isChecked() ? "2"
                : "-1");

        json.put("j0401d", bi.j0401da.isChecked() ? "1"
                : bi.j0401db.isChecked() ? "2"
                : "-1");

        json.put("j0401e", bi.j0401ea.isChecked() ? "1"
                : bi.j0401eb.isChecked() ? "2"
                : "-1");

        json.put("j0401f", bi.j0401fa.isChecked() ? "1"
                : bi.j0401fb.isChecked() ? "2"
                : "-1");

        json.put("j0401g", bi.j0401ga.isChecked() ? "1"
                : bi.j0401gb.isChecked() ? "2"
                : "-1");

        json.put("j0401h", bi.j0401ha.isChecked() ? "1"
                : bi.j0401hb.isChecked() ? "2"
                : "-1");

        json.put("j0401i", bi.j0401ia.isChecked() ? "1"
                : bi.j0401ib.isChecked() ? "2"
                : "-1");

        json.put("j0401j", bi.j0401ja.isChecked() ? "1"
                : bi.j0401jb.isChecked() ? "2"
                : "-1");

        json.put("j0401k", bi.j0401ka.isChecked() ? "1"
                : bi.j0401kb.isChecked() ? "2"
                : "-1");

        json.put("j0401l", bi.j0401la.isChecked() ? "1"
                : bi.j0401lb.isChecked() ? "2"
                : "-1");

        json.put("j0401ma", bi.j0401ma.isChecked() ? "1" : "-1");
        json.put("j0401mb", bi.j0401mb.isChecked() ? "2" : "-1");
        json.put("j0401mc", bi.j0401mc.isChecked() ? "3" : "-1");
        json.put("j0401md", bi.j0401md.isChecked() ? "4" : "-1");
        json.put("j0401me", bi.j0401me.isChecked() ? "5" : "-1");
        json.put("j0401mf", bi.j0401mf.isChecked() ? "6" : "-1");
        json.put("j0401mx", bi.j0401mx.isChecked() ? "96" : "-1");
        json.put("j0401mxx", bi.j0401mxx.getText().toString().trim().length() > 0 ? bi.j0401mxx.getText().toString() : "-1");

        if (fc.getsJ() != null) {

            try {
                JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsJ()), json);

                fc.setsJ(String.valueOf(json_merge));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            json.put("JDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
            json.put("JTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));
            fc.setsJ(String.valueOf(json));
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "J");
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
