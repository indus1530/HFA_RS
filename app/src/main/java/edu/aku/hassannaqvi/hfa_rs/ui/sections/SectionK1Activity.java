package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK1Binding;

public class SectionK1Activity extends AppCompatActivity {

    ActivitySectionK1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.k0001.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0001);
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
            startActivity(new Intent(this, bi.k0001b.isChecked() ? SectionK7Activity.class : SectionK2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "K");
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

        json.put("KDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("KTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("k0001", bi.k0001a.isChecked() ? "1"
                : bi.k0001b.isChecked() ? "2"
                : "-1");

        json.put("k0011", bi.k0011a.isChecked() ? "1"
                : bi.k0011b.isChecked() ? "2"
                : "-1");

        json.put("k00111", bi.k00111a.isChecked() ? "1"
                : bi.k00111b.isChecked() ? "2"
                : "-1");

        json.put("k001121", bi.k001121a.isChecked() ? "1"
                : bi.k001121b.isChecked() ? "2"
                : "-1");
        json.put("k001121c", bi.k001121c.getText().toString().trim().isEmpty() ? "-1" : bi.k001121c.getText().toString());

        json.put("k001122", bi.k001122a.isChecked() ? "1"
                : bi.k001122b.isChecked() ? "2"
                : "-1");
        json.put("k001122c", bi.k001122c.getText().toString().trim().isEmpty() ? "-1" : bi.k001122c.getText().toString());

        json.put("k001123", bi.k001123a.isChecked() ? "1"
                : bi.k001123b.isChecked() ? "2"
                : "-1");
        json.put("k001123c", bi.k001123c.getText().toString().trim().isEmpty() ? "-1" : bi.k001123c.getText().toString());

        json.put("k001124", bi.k001124a.isChecked() ? "1"
                : bi.k001124b.isChecked() ? "2"
                : "-1");
        json.put("k001124c", bi.k001124c.getText().toString().trim().isEmpty() ? "-1" : bi.k001124c.getText().toString());

        json.put("k001125", bi.k001125a.isChecked() ? "1"
                : bi.k001125b.isChecked() ? "2"
                : "-1");
        json.put("k001125c", bi.k001125c.getText().toString().trim().isEmpty() ? "-1" : bi.k001125c.getText().toString());

        json.put("k001126", bi.k001126a.isChecked() ? "1"
                : bi.k001126b.isChecked() ? "2"
                : "-1");
        json.put("k001126c", bi.k001126c.getText().toString().trim().isEmpty() ? "-1" : bi.k001126c.getText().toString());

        json.put("k001127", bi.k001127a.isChecked() ? "1"
                : bi.k001127b.isChecked() ? "2"
                : "-1");
        json.put("k001127c", bi.k001127c.getText().toString().trim().isEmpty() ? "-1" : bi.k001127c.getText().toString());

        json.put("k0011296", bi.k0011296a.isChecked() ? "1"
                : bi.k0011296b.isChecked() ? "2"
                : "-1");
        json.put("k0011296c", bi.k0011296c.getText().toString().trim().isEmpty() ? "-1" : bi.k0011296c.getText().toString());
        json.put("k0011296d", bi.k0011296d.getText().toString().trim().isEmpty() ? "-1" : bi.k0011296d.getText().toString());

        json.put("k0012", bi.k0012a.isChecked() ? "1"
                : bi.k0012b.isChecked() ? "2"
                : bi.k0012c.isChecked() ? "3"
                : bi.k0012d.isChecked() ? "4"
                : bi.k001296.isChecked() ? "96"
                : "-1");
        json.put("k001296x", bi.k001296x.getText().toString().trim().isEmpty() ? "-1" : bi.k001296x.getText().toString());

        json.put("k0013", bi.k0013a.isChecked() ? "1"
                : bi.k0013b.isChecked() ? "2"
                : bi.k0013c.isChecked() ? "3"
                : "-1");

        json.put("k0014", bi.k0014a.isChecked() ? "1"
                : bi.k0014b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setsK(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
