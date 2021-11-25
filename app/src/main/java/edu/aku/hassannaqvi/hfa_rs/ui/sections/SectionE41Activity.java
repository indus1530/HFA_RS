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
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionE41Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionE41Activity extends AppCompatActivity {

    ActivitySectionE41Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e41);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0401.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece401);
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0401", bi.e0401a.isChecked() ? "1"
                : bi.e0401b.isChecked() ? "2"
                : "-1");

        json.put("e0402", bi.e0402a.isChecked() ? "1"
                : bi.e0402b.isChecked() ? "2"
                : "-1");

        json.put("e0403a", bi.e0403aa.isChecked() ? "1"
                : bi.e0403ab.isChecked() ? "2"
                : bi.e0403ac.isChecked() ? "3"
                : bi.e0403ad.isChecked() ? "4"
                : "-1");

        json.put("e0403b", bi.e0403ba.isChecked() ? "1"
                : bi.e0403bb.isChecked() ? "2"
                : bi.e0403bc.isChecked() ? "3"
                : bi.e0403bd.isChecked() ? "4"
                : "-1");

        json.put("e0403c", bi.e0403ca.isChecked() ? "1"
                : bi.e0403cb.isChecked() ? "2"
                : bi.e0403cc.isChecked() ? "3"
                : bi.e0403cd.isChecked() ? "4"
                : "-1");

        json.put("e04041", bi.e04041a.isChecked() ? "1"
                : bi.e04041b.isChecked() ? "2"
                : bi.e04041c.isChecked() ? "3"
                : bi.e04041d.isChecked() ? "4"
                : "-1");

        json.put("e04042", bi.e04042a.isChecked() ? "1"
                : bi.e04042b.isChecked() ? "2"
                : bi.e04042c.isChecked() ? "3"
                : bi.e04042d.isChecked() ? "4"
                : "-1");

        json.put("e04043", bi.e04043a.isChecked() ? "1"
                : bi.e04043b.isChecked() ? "2"
                : bi.e04043c.isChecked() ? "3"
                : bi.e04043d.isChecked() ? "4"
                : "-1");

        json.put("e04044", bi.e04044a.isChecked() ? "1"
                : bi.e04044b.isChecked() ? "2"
                : bi.e04044c.isChecked() ? "3"
                : bi.e04044d.isChecked() ? "4"
                : "-1");

        json.put("e04045", bi.e04045a.isChecked() ? "1"
                : bi.e04045b.isChecked() ? "2"
                : bi.e04045c.isChecked() ? "3"
                : bi.e04045d.isChecked() ? "4"
                : "-1");

        json.put("e04046", bi.e04046a.isChecked() ? "1"
                : bi.e04046b.isChecked() ? "2"
                : bi.e04046c.isChecked() ? "3"
                : bi.e04046d.isChecked() ? "4"
                : "-1");

        json.put("e04047", bi.e04047a.isChecked() ? "1"
                : bi.e04047b.isChecked() ? "2"
                : bi.e04047c.isChecked() ? "3"
                : bi.e04047d.isChecked() ? "4"
                : "-1");

        json.put("e04048", bi.e04048a.isChecked() ? "1"
                : bi.e04048b.isChecked() ? "2"
                : bi.e04048c.isChecked() ? "3"
                : bi.e04048d.isChecked() ? "4"
                : "-1");

        json.put("e04051", bi.e04051a.isChecked() ? "1"
                : bi.e04051b.isChecked() ? "2"
                : bi.e04051c.isChecked() ? "3"
                : bi.e04051d.isChecked() ? "4"
                : "-1");

        json.put("e04052", bi.e04052a.isChecked() ? "1"
                : bi.e04052b.isChecked() ? "2"
                : bi.e04052c.isChecked() ? "3"
                : bi.e04052d.isChecked() ? "4"
                : "-1");

        json.put("e04053", bi.e04053a.isChecked() ? "1"
                : bi.e04053b.isChecked() ? "2"
                : bi.e04053c.isChecked() ? "3"
                : bi.e04053d.isChecked() ? "4"
                : "-1");

        json.put("e04054", bi.e04054a.isChecked() ? "1"
                : bi.e04054b.isChecked() ? "2"
                : bi.e04054c.isChecked() ? "3"
                : bi.e04054d.isChecked() ? "4"
                : "-1");

        json.put("e04055", bi.e04055a.isChecked() ? "1"
                : bi.e04055b.isChecked() ? "2"
                : bi.e04055c.isChecked() ? "3"
                : bi.e04055d.isChecked() ? "4"
                : "-1");

        json.put("e04056", bi.e04056a.isChecked() ? "1"
                : bi.e04056b.isChecked() ? "2"
                : bi.e04056c.isChecked() ? "3"
                : bi.e04056d.isChecked() ? "4"
                : "-1");

        json.put("e04057", bi.e04057a.isChecked() ? "1"
                : bi.e04057b.isChecked() ? "2"
                : bi.e04057c.isChecked() ? "3"
                : bi.e04057d.isChecked() ? "4"
                : "-1");

        json.put("e04058", bi.e04058a.isChecked() ? "1"
                : bi.e04058b.isChecked() ? "2"
                : bi.e04058c.isChecked() ? "3"
                : bi.e04058d.isChecked() ? "4"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsE()), json);

            fc.setsE(String.valueOf(json_merge));

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
            startActivity(new Intent(this, bi.e0401b.isChecked() ? SectionE5Activity.class : SectionE42Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "E");
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
