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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ7Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ7Activity extends AppCompatActivity {

    ActivitySectionJ7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j7);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0701a);
        radioGroup(bi.j0701b);
        radioGroup(bi.j0701c);
        radioGroup(bi.j0701d);
        radioGroup(bi.j0701e);
        radioGroup(bi.j0701f);
    }


    public void hideKeyboard(View v) {
        InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0701ab.isChecked() || bi.j0701bb.isChecked() || bi.j0701cb.isChecked()
                    || bi.j0701db.isChecked() || bi.j0701eb.isChecked() || bi.j0701fb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0701g);
                bi.fldGrpCVj0701g.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0701g);
                bi.fldGrpCVj0701g.setVisibility(View.GONE);
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
            startActivity(new Intent(this, SectionJ8Activity.class));
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

        json.put("j0700a", bi.j0700a.getText().toString().trim().length() > 0 ? bi.j0700a.getText().toString() : "-1");
        json.put("j0700b", bi.j0700b.getText().toString().trim().length() > 0 ? bi.j0700b.getText().toString() : "-1");

        json.put("j0700c", bi.j0700ca.isChecked() ? "1"
                : bi.j0700cb.isChecked() ? "2"
                : "-1");

        json.put("j0701a", bi.j0701aa.isChecked() ? "1"
                : bi.j0701ab.isChecked() ? "2"
                : "-1");

        json.put("j0701b", bi.j0701ba.isChecked() ? "1"
                : bi.j0701bb.isChecked() ? "2"
                : "-1");

        json.put("j0701c", bi.j0701ca.isChecked() ? "1"
                : bi.j0701cb.isChecked() ? "2"
                : "-1");

        json.put("j0701d", bi.j0701da.isChecked() ? "1"
                : bi.j0701db.isChecked() ? "2"
                : "-1");

        json.put("j0701e", bi.j0701ea.isChecked() ? "1"
                : bi.j0701eb.isChecked() ? "2"
                : "-1");

        json.put("j0701f", bi.j0701fa.isChecked() ? "1"
                : bi.j0701fb.isChecked() ? "2"
                : "-1");

        json.put("j0701ga", bi.j0701ga.isChecked() ? "1" : "-1");
        json.put("j0701gb", bi.j0701gb.isChecked() ? "2" : "-1");
        json.put("j0701gc", bi.j0701gc.isChecked() ? "3" : "-1");
        json.put("j0701gd", bi.j0701gd.isChecked() ? "4" : "-1");
        json.put("j0701ge", bi.j0701ge.isChecked() ? "5" : "-1");
        json.put("j0701gf", bi.j0701gf.isChecked() ? "6" : "-1");
        json.put("j0701gx", bi.j0701gx.isChecked() ? "96" : "-1");
        json.put("j0701gxx", bi.j0701gxx.getText().toString().trim().length() > 0 ? bi.j0701gxx.getText().toString() : "-1");

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
