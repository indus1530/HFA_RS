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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ6Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ6Activity extends AppCompatActivity {

    ActivitySectionJ6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j6);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0601a);
        radioGroup(bi.j0601b);
        radioGroup(bi.j0601c);
        radioGroup(bi.j0601d);
        radioGroup(bi.j0601e);
        radioGroup(bi.j0601f);
        radioGroup(bi.j0601g);
        radioGroup(bi.j0601h);
        radioGroup(bi.j0601i);
        radioGroup(bi.j0601j);
        radioGroup(bi.j0601k);
        radioGroup(bi.j0601l);
    }


    public void hideKeyboard(View v) {
        InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0601ab.isChecked() || bi.j0601bb.isChecked() || bi.j0601cb.isChecked()
                    || bi.j0601db.isChecked() || bi.j0601eb.isChecked() || bi.j0601fb.isChecked()
                    || bi.j0601gb.isChecked() || bi.j0601hb.isChecked() || bi.j0601ib.isChecked()
                    || bi.j0601jb.isChecked() || bi.j0601kb.isChecked() || bi.j0601lb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0601m);
                bi.fldGrpCVj0601m.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0601m);
                bi.fldGrpCVj0601m.setVisibility(View.GONE);
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

            if (MainApp.fc.getA10().equals("2") && !MainApp.fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ8Activity.class);
            } else {
                intent = new Intent(this, SectionJ7Activity.class);
            }
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0600a", bi.j0600a.getText().toString().trim().length() > 0 ? bi.j0600a.getText().toString() : "-1");
        json.put("j0600b", bi.j0600b.getText().toString().trim().length() > 0 ? bi.j0600b.getText().toString() : "-1");

        json.put("j0600c", bi.j0600ca.isChecked() ? "1"
                : bi.j0600cb.isChecked() ? "2"
                : "-1");

        json.put("j0601a", bi.j0601aa.isChecked() ? "1"
                : bi.j0601ab.isChecked() ? "2"
                : "-1");

        json.put("j0601b", bi.j0601ba.isChecked() ? "1"
                : bi.j0601bb.isChecked() ? "2"
                : "-1");

        json.put("j0601c", bi.j0601ca.isChecked() ? "1"
                : bi.j0601cb.isChecked() ? "2"
                : "-1");

        json.put("j0601d", bi.j0601da.isChecked() ? "1"
                : bi.j0601db.isChecked() ? "2"
                : "-1");

        json.put("j0601e", bi.j0601ea.isChecked() ? "1"
                : bi.j0601eb.isChecked() ? "2"
                : "-1");

        json.put("j0601f", bi.j0601fa.isChecked() ? "1"
                : bi.j0601fb.isChecked() ? "2"
                : "-1");

        json.put("j0601g", bi.j0601ga.isChecked() ? "1"
                : bi.j0601gb.isChecked() ? "2"
                : "-1");

        json.put("j0601h", bi.j0601ha.isChecked() ? "1"
                : bi.j0601hb.isChecked() ? "2"
                : "-1");

        json.put("j0601i", bi.j0601ia.isChecked() ? "1"
                : bi.j0601ib.isChecked() ? "2"
                : "-1");

        json.put("j0601j", bi.j0601ja.isChecked() ? "1"
                : bi.j0601jb.isChecked() ? "2"
                : "-1");

        json.put("j0601k", bi.j0601ka.isChecked() ? "1"
                : bi.j0601kb.isChecked() ? "2"
                : "-1");

        json.put("j0601l", bi.j0601la.isChecked() ? "1"
                : bi.j0601lb.isChecked() ? "2"
                : "-1");

        json.put("j0601ma", bi.j0601ma.isChecked() ? "1" : "-1");
        json.put("j0601mb", bi.j0601mb.isChecked() ? "2" : "-1");
        json.put("j0601mc", bi.j0601mc.isChecked() ? "3" : "-1");
        json.put("j0601md", bi.j0601md.isChecked() ? "4" : "-1");
        json.put("j0601me", bi.j0601me.isChecked() ? "5" : "-1");
        json.put("j0601mf", bi.j0601mf.isChecked() ? "6" : "-1");
        json.put("j0601mx", bi.j0601mx.isChecked() ? "96" : "-1");
        json.put("j0601mxx", bi.j0601mxx.getText().toString().trim().length() > 0 ? bi.j0601mxx.getText().toString() : "-1");

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
