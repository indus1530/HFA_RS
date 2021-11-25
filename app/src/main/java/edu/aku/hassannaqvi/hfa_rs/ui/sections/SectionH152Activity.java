package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH152Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionH152Activity extends AppCompatActivity {

    ActivitySectionH152Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h152);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

        bi.h1501i0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501i0ay.getId()) {
                bi.fldGrpCVh1501i0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501i0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501i0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501i0b);
                Clear.clearAllFields(bi.fldGrpCVh1501i0c);
                Clear.clearAllFields(bi.fldGrpCVh1501i0d);
                bi.fldGrpCVh1501i0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501i0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501i0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501i0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501i0cy.getId()) {
                bi.fldGrpCVh1501i0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501i0d);
                bi.fldGrpCVh1501i0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501j0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501j0ay.getId()) {
                bi.fldGrpCVh1501j0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501j0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501j0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501j0b);
                Clear.clearAllFields(bi.fldGrpCVh1501j0c);
                Clear.clearAllFields(bi.fldGrpCVh1501j0d);
                bi.fldGrpCVh1501j0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501j0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501j0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501j0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501j0cy.getId()) {
                bi.fldGrpCVh1501j0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501j0d);
                bi.fldGrpCVh1501j0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501k0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501k0ay.getId()) {
                bi.fldGrpCVh1501k0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501k0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501k0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501k0b);
                Clear.clearAllFields(bi.fldGrpCVh1501k0c);
                Clear.clearAllFields(bi.fldGrpCVh1501k0d);
                bi.fldGrpCVh1501k0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501k0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501k0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501k0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501k0cy.getId()) {
                bi.fldGrpCVh1501k0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501k0d);
                bi.fldGrpCVh1501k0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501l0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501l0ay.getId()) {
                bi.fldGrpCVh1501l0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501l0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501l0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501l0b);
                Clear.clearAllFields(bi.fldGrpCVh1501l0c);
                Clear.clearAllFields(bi.fldGrpCVh1501l0d);
                bi.fldGrpCVh1501l0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501l0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501l0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501l0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501l0cy.getId()) {
                bi.fldGrpCVh1501l0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501l0d);
                bi.fldGrpCVh1501l0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501m0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501m0ay.getId()) {
                bi.fldGrpCVh1501m0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501m0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501m0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501m0b);
                Clear.clearAllFields(bi.fldGrpCVh1501m0c);
                Clear.clearAllFields(bi.fldGrpCVh1501m0d);
                bi.fldGrpCVh1501m0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501m0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501m0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501m0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501m0cy.getId()) {
                bi.fldGrpCVh1501m0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501m0d);
                bi.fldGrpCVh1501m0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501n0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501n0ay.getId()) {
                bi.fldGrpCVh1501n0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501n0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501n0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501n0b);
                Clear.clearAllFields(bi.fldGrpCVh1501n0c);
                Clear.clearAllFields(bi.fldGrpCVh1501n0d);
                bi.fldGrpCVh1501n0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501n0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501n0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501n0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501n0cy.getId()) {
                bi.fldGrpCVh1501n0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501n0d);
                bi.fldGrpCVh1501n0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501o0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501o0ay.getId()) {
                bi.fldGrpCVh1501o0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501o0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501o0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501o0b);
                Clear.clearAllFields(bi.fldGrpCVh1501o0c);
                Clear.clearAllFields(bi.fldGrpCVh1501o0d);
                bi.fldGrpCVh1501o0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501o0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501o0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501o0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501o0cy.getId()) {
                bi.fldGrpCVh1501o0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501o0d);
                bi.fldGrpCVh1501o0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501p0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501p0ay.getId()) {
                bi.fldGrpCVh1501p0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501p0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501p0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501p0b);
                Clear.clearAllFields(bi.fldGrpCVh1501p0c);
                Clear.clearAllFields(bi.fldGrpCVh1501p0d);
                bi.fldGrpCVh1501p0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501p0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501p0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501p0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501p0cy.getId()) {
                bi.fldGrpCVh1501p0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501p0d);
                bi.fldGrpCVh1501p0d.setVisibility(View.GONE);
            }
        }));

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
            startActivity(new Intent(this, SectionH153Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, fc.getsH());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();


        json.put("h1501i0a", bi.h1501i0ay.isChecked() ? "1"
                : bi.h1501i0an.isChecked() ? "2"
                : "-1");

        json.put("h1501i0b", bi.h1501i0by.isChecked() ? "1"
                : bi.h1501i0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501i0c", bi.h1501i0cy.isChecked() ? "1"
                : bi.h1501i0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501i0dy", bi.h1501i0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501i0dy.getText().toString());
        json.put("h1501i0dn", bi.h1501i0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501i0dn.getText().toString());


        json.put("h1501j0a", bi.h1501j0ay.isChecked() ? "1"
                : bi.h1501j0an.isChecked() ? "2"
                : "-1");

        json.put("h1501j0b", bi.h1501j0by.isChecked() ? "1"
                : bi.h1501j0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501j0c", bi.h1501j0cy.isChecked() ? "1"
                : bi.h1501j0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501j0dy", bi.h1501j0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501j0dy.getText().toString());
        json.put("h1501j0dn", bi.h1501j0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501j0dn.getText().toString());


        json.put("h1501k0a", bi.h1501k0ay.isChecked() ? "1"
                : bi.h1501k0an.isChecked() ? "2"
                : "-1");

        json.put("h1501k0b", bi.h1501k0by.isChecked() ? "1"
                : bi.h1501k0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501k0c", bi.h1501k0cy.isChecked() ? "1"
                : bi.h1501k0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501k0dy", bi.h1501k0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501k0dy.getText().toString());
        json.put("h1501k0dn", bi.h1501k0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501k0dn.getText().toString());


        json.put("h1501l0a", bi.h1501l0ay.isChecked() ? "1"
                : bi.h1501l0an.isChecked() ? "2"
                : "-1");

        json.put("h1501l0b", bi.h1501l0by.isChecked() ? "1"
                : bi.h1501l0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501l0c", bi.h1501l0cy.isChecked() ? "1"
                : bi.h1501l0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501l0dy", bi.h1501l0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501l0dy.getText().toString());
        json.put("h1501l0dn", bi.h1501l0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501l0dn.getText().toString());


        json.put("h1501m0a", bi.h1501m0ay.isChecked() ? "1"
                : bi.h1501m0an.isChecked() ? "2"
                : "-1");

        json.put("h1501m0b", bi.h1501m0by.isChecked() ? "1"
                : bi.h1501m0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501m0c", bi.h1501m0cy.isChecked() ? "1"
                : bi.h1501m0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501m0dy", bi.h1501m0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501m0dy.getText().toString());
        json.put("h1501m0dn", bi.h1501m0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501m0dn.getText().toString());


        json.put("h1501n0a", bi.h1501n0ay.isChecked() ? "1"
                : bi.h1501n0an.isChecked() ? "2"
                : "-1");

        json.put("h1501n0b", bi.h1501n0by.isChecked() ? "1"
                : bi.h1501n0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501n0c", bi.h1501n0cy.isChecked() ? "1"
                : bi.h1501n0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501n0dy", bi.h1501n0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501n0dy.getText().toString());
        json.put("h1501n0dn", bi.h1501n0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501n0dn.getText().toString());


        json.put("h1501o0a", bi.h1501o0ay.isChecked() ? "1"
                : bi.h1501o0an.isChecked() ? "2"
                : "-1");

        json.put("h1501o0b", bi.h1501o0by.isChecked() ? "1"
                : bi.h1501o0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501o0c", bi.h1501o0cy.isChecked() ? "1"
                : bi.h1501o0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501o0dy", bi.h1501o0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501o0dy.getText().toString());
        json.put("h1501o0dn", bi.h1501o0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501o0dn.getText().toString());


        json.put("h1501p0a", bi.h1501p0ay.isChecked() ? "1"
                : bi.h1501p0an.isChecked() ? "2"
                : "-1");

        json.put("h1501p0b", bi.h1501p0by.isChecked() ? "1"
                : bi.h1501p0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501p0c", bi.h1501p0cy.isChecked() ? "1"
                : bi.h1501p0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501p0dy", bi.h1501p0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501p0dy.getText().toString());
        json.put("h1501p0dn", bi.h1501p0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501p0dn.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsH()), json);

            fc.setsH(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH15);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "H");
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
