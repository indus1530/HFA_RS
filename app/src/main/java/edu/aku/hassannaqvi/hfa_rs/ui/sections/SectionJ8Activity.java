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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ8Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionJ8Activity extends AppCompatActivity {

    ActivitySectionJ8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j8);
        bi.setCallback(this);
        setupSkips();

    }


    public void hideKeyboard(View v) {
        InputMethodManager im = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }


    private void setupSkips() {
        radioGroup(bi.j0801a);
        radioGroup(bi.j0801b);
        radioGroup(bi.j0801c);
        radioGroup(bi.j0801d);
        radioGroup(bi.j0801e);
        radioGroup(bi.j0801f);
    }


    public void radioGroup(RadioGroup grp) {
        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0801ab.isChecked()
                    || bi.j0801bb.isChecked()
                    || bi.j0801cb.isChecked()
                    || bi.j0801db.isChecked()
                    || bi.j0801eb.isChecked()
                    || bi.j0801fb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0801g);
                bi.fldGrpCVj0801g.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0801g);
                bi.fldGrpCVj0801g.setVisibility(View.GONE);
            }
        }));
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
            startActivity(new Intent(this, SectionJ9Activity.class));
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

        json.put("j0800a", bi.j0800a.getText().toString().trim().length() > 0 ? bi.j0800a.getText().toString() : "-1");
        json.put("j0800b", bi.j0800b.getText().toString().trim().length() > 0 ? bi.j0800b.getText().toString() : "-1");

        json.put("j0800c", bi.j0800ca.isChecked() ? "1"
                : bi.j0800cb.isChecked() ? "2"
                : "-1");

        json.put("j0801a", bi.j0801aa.isChecked() ? "1"
                : bi.j0801ab.isChecked() ? "2"
                : "-1");

        json.put("j0801b", bi.j0801ba.isChecked() ? "1"
                : bi.j0801bb.isChecked() ? "2"
                : "-1");

        json.put("j0801c", bi.j0801ca.isChecked() ? "1"
                : bi.j0801cb.isChecked() ? "2"
                : "-1");

        json.put("j0801d", bi.j0801da.isChecked() ? "1"
                : bi.j0801db.isChecked() ? "2"
                : "-1");

        json.put("j0801e", bi.j0801ea.isChecked() ? "1"
                : bi.j0801eb.isChecked() ? "2"
                : "-1");

        json.put("j0801f", bi.j0801fa.isChecked() ? "1"
                : bi.j0801fb.isChecked() ? "2"
                : "-1");

        json.put("j0801ga", bi.j0801ga.isChecked() ? "1" : "-1");
        json.put("j0801gb", bi.j0801gb.isChecked() ? "2" : "-1");
        json.put("j0801gc", bi.j0801gc.isChecked() ? "3" : "-1");
        json.put("j0801gd", bi.j0801gd.isChecked() ? "4" : "-1");
        json.put("j0801gx", bi.j0801gx.isChecked() ? "96" : "-1");
        json.put("j0801gxx", bi.j0801gxx.getText().toString().trim().length() > 0 ? bi.j0801gxx.getText().toString() : "-1");

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


    public void BtnEnd(View v) {
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
