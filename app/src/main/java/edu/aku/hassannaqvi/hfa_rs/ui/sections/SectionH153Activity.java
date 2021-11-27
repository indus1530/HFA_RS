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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH153Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionH153Activity extends AppCompatActivity {

    ActivitySectionH153Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h153);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.h1501q0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501q0ay.getId()) {
                bi.fldGrpCVh1501q0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501q0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501q0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501q0b);
                Clear.clearAllFields(bi.fldGrpCVh1501q0c);
                Clear.clearAllFields(bi.fldGrpCVh1501q0d);
                bi.fldGrpCVh1501q0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501q0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501q0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501q0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501q0cy.getId()) {
                bi.fldGrpCVh1501q0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501q0d);
                bi.fldGrpCVh1501q0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501r0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501r0ay.getId()) {
                bi.fldGrpCVh1501r0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501r0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501r0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501r0b);
                Clear.clearAllFields(bi.fldGrpCVh1501r0c);
                Clear.clearAllFields(bi.fldGrpCVh1501r0d);
                bi.fldGrpCVh1501r0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501r0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501r0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501r0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501r0cy.getId()) {
                bi.fldGrpCVh1501r0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501r0d);
                bi.fldGrpCVh1501r0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501s0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501s0ay.getId()) {
                bi.fldGrpCVh1501s0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501s0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501s0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501s0b);
                Clear.clearAllFields(bi.fldGrpCVh1501s0c);
                Clear.clearAllFields(bi.fldGrpCVh1501s0d);
                bi.fldGrpCVh1501s0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501s0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501s0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501s0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501s0cy.getId()) {
                bi.fldGrpCVh1501s0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501s0d);
                bi.fldGrpCVh1501s0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501t0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501t0ay.getId()) {
                bi.fldGrpCVh1501t0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501t0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501t0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501t0b);
                Clear.clearAllFields(bi.fldGrpCVh1501t0c);
                Clear.clearAllFields(bi.fldGrpCVh1501t0d);
                bi.fldGrpCVh1501t0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501t0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501t0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501t0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501t0cy.getId()) {
                bi.fldGrpCVh1501t0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501t0d);
                bi.fldGrpCVh1501t0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501u0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501u0ay.getId()) {
                bi.fldGrpCVh1501u0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501u0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501u0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501u0b);
                Clear.clearAllFields(bi.fldGrpCVh1501u0c);
                Clear.clearAllFields(bi.fldGrpCVh1501u0d);
                bi.fldGrpCVh1501u0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501u0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501u0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501u0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501u0cy.getId()) {
                bi.fldGrpCVh1501u0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501u0d);
                bi.fldGrpCVh1501u0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501v0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501v0ay.getId()) {
                bi.fldGrpCVh1501v0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501v0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501v0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501v0b);
                Clear.clearAllFields(bi.fldGrpCVh1501v0c);
                Clear.clearAllFields(bi.fldGrpCVh1501v0d);
                bi.fldGrpCVh1501v0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501v0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501v0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501v0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501v0cy.getId()) {
                bi.fldGrpCVh1501v0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501v0d);
                bi.fldGrpCVh1501v0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501w0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501w0ay.getId()) {
                bi.fldGrpCVh1501w0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501w0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501w0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501w0b);
                Clear.clearAllFields(bi.fldGrpCVh1501w0c);
                Clear.clearAllFields(bi.fldGrpCVh1501w0d);
                bi.fldGrpCVh1501w0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501w0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501w0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501w0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501w0cy.getId()) {
                bi.fldGrpCVh1501w0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501w0d);
                bi.fldGrpCVh1501w0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501x0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501x0ay.getId()) {
                bi.fldGrpCVh1501x0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501x0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501x0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501x0b);
                Clear.clearAllFields(bi.fldGrpCVh1501x0c);
                Clear.clearAllFields(bi.fldGrpCVh1501x0d);
                bi.fldGrpCVh1501x0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501x0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501x0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501x0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501x0cy.getId()) {
                bi.fldGrpCVh1501x0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501x0d);
                bi.fldGrpCVh1501x0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501y0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501y0ay.getId()) {
                bi.fldGrpCVh1501y0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501y0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501y0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501y0b);
                Clear.clearAllFields(bi.fldGrpCVh1501y0c);
                Clear.clearAllFields(bi.fldGrpCVh1501y0d);
                bi.fldGrpCVh1501y0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501y0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501y0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501y0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501y0cy.getId()) {
                bi.fldGrpCVh1501y0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501y0d);
                bi.fldGrpCVh1501y0d.setVisibility(View.GONE);
            }
        }));


        bi.h1501z0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501z0ay.getId()) {
                bi.fldGrpCVh1501z0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501z0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501z0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501z0b);
                Clear.clearAllFields(bi.fldGrpCVh1501z0c);
                Clear.clearAllFields(bi.fldGrpCVh1501z0d);
                bi.fldGrpCVh1501z0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501z0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501z0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501z0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501z0cy.getId()) {
                bi.fldGrpCVh1501z0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501z0d);
                bi.fldGrpCVh1501z0d.setVisibility(View.GONE);
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
            startActivity(new Intent(this, SectionMainActivity.class));
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


        json.put("h1501q0a", bi.h1501q0ay.isChecked() ? "1"
                : bi.h1501q0an.isChecked() ? "2"
                : "-1");

        json.put("h1501q0b", bi.h1501q0by.isChecked() ? "1"
                : bi.h1501q0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501q0c", bi.h1501q0cy.isChecked() ? "1"
                : bi.h1501q0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501q0dy", bi.h1501q0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501q0dy.getText().toString());
        json.put("h1501q0dn", bi.h1501q0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501q0dn.getText().toString());


        json.put("h1501r0a", bi.h1501r0ay.isChecked() ? "1"
                : bi.h1501r0an.isChecked() ? "2"
                : "-1");

        json.put("h1501r0b", bi.h1501r0by.isChecked() ? "1"
                : bi.h1501r0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501r0c", bi.h1501r0cy.isChecked() ? "1"
                : bi.h1501r0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501r0dy", bi.h1501r0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501r0dy.getText().toString());
        json.put("h1501r0dn", bi.h1501r0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501r0dn.getText().toString());


        json.put("h1501s0a", bi.h1501s0ay.isChecked() ? "1"
                : bi.h1501s0an.isChecked() ? "2"
                : "-1");

        json.put("h1501s0b", bi.h1501s0by.isChecked() ? "1"
                : bi.h1501s0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501s0c", bi.h1501s0cy.isChecked() ? "1"
                : bi.h1501s0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501s0dy", bi.h1501s0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501s0dy.getText().toString());
        json.put("h1501s0dn", bi.h1501s0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501s0dn.getText().toString());


        json.put("h1501t0a", bi.h1501t0ay.isChecked() ? "1"
                : bi.h1501t0an.isChecked() ? "2"
                : "-1");

        json.put("h1501t0b", bi.h1501t0by.isChecked() ? "1"
                : bi.h1501t0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501t0c", bi.h1501t0cy.isChecked() ? "1"
                : bi.h1501t0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501t0dy", bi.h1501t0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501t0dy.getText().toString());
        json.put("h1501t0dn", bi.h1501t0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501t0dn.getText().toString());


        json.put("h1501u0a", bi.h1501u0ay.isChecked() ? "1"
                : bi.h1501u0an.isChecked() ? "2"
                : "-1");

        json.put("h1501u0b", bi.h1501u0by.isChecked() ? "1"
                : bi.h1501u0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501u0c", bi.h1501u0cy.isChecked() ? "1"
                : bi.h1501u0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501u0dy", bi.h1501u0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501u0dy.getText().toString());
        json.put("h1501u0dn", bi.h1501u0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501u0dn.getText().toString());


        json.put("h1501v0a", bi.h1501v0ay.isChecked() ? "1"
                : bi.h1501v0an.isChecked() ? "2"
                : "-1");

        json.put("h1501v0b", bi.h1501v0by.isChecked() ? "1"
                : bi.h1501v0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501v0c", bi.h1501v0cy.isChecked() ? "1"
                : bi.h1501v0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501v0dy", bi.h1501v0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501v0dy.getText().toString());
        json.put("h1501v0dn", bi.h1501v0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501v0dn.getText().toString());


        json.put("h1501w0a", bi.h1501w0ay.isChecked() ? "1"
                : bi.h1501w0an.isChecked() ? "2"
                : "-1");

        json.put("h1501w0b", bi.h1501w0by.isChecked() ? "1"
                : bi.h1501w0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501w0c", bi.h1501w0cy.isChecked() ? "1"
                : bi.h1501w0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501w0dy", bi.h1501w0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501w0dy.getText().toString());
        json.put("h1501w0dn", bi.h1501w0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501w0dn.getText().toString());


        json.put("h1501x0a", bi.h1501x0ay.isChecked() ? "1"
                : bi.h1501x0an.isChecked() ? "2"
                : "-1");

        json.put("h1501x0b", bi.h1501x0by.isChecked() ? "1"
                : bi.h1501x0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501x0c", bi.h1501x0cy.isChecked() ? "1"
                : bi.h1501x0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501x0dy", bi.h1501x0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501x0dy.getText().toString());
        json.put("h1501x0dn", bi.h1501x0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501x0dn.getText().toString());

        json.put("h1501y0a", bi.h1501y0ay.isChecked() ? "1"
                : bi.h1501y0an.isChecked() ? "2"
                : "-1");

        json.put("h1501y0b", bi.h1501y0by.isChecked() ? "1"
                : bi.h1501y0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501y0c", bi.h1501y0cy.isChecked() ? "1"
                : bi.h1501y0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501y0dy", bi.h1501y0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501y0dy.getText().toString());
        json.put("h1501y0dn", bi.h1501y0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501y0dn.getText().toString());


        json.put("h1501z0a", bi.h1501z0ay.isChecked() ? "1"
                : bi.h1501z0an.isChecked() ? "2"
                : "-1");

        json.put("h1501z0b", bi.h1501z0by.isChecked() ? "1"
                : bi.h1501z0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501z0c", bi.h1501z0cy.isChecked() ? "1"
                : bi.h1501z0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501z0dy", bi.h1501z0dy.getText().toString().trim().isEmpty() ? "-1" : bi.h1501z0dy.getText().toString());
        json.put("h1501z0dn", bi.h1501z0dn.getText().toString().trim().isEmpty() ? "-1" : bi.h1501z0dn.getText().toString());

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


    public void BtnEnd(View v) {
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
            //String infoText = (String) getResources().getText(stringRes);
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
