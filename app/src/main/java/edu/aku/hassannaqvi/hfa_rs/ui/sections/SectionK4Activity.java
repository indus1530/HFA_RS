package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionK4Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionK4Activity extends AppCompatActivity {

    ActivitySectionK4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k4);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {
        bi.k410.setOnCheckedChangeListener(((radioGroup, i) -> Clear.clearAllFields(bi.llk410)));
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
            startActivity(new Intent(this, SectionK6AActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
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

        json.put("k401", bi.k401a.isChecked() ? "1"
                : bi.k401b.isChecked() ? "2"
                : bi.k401c.isChecked() ? "3"
                : bi.k401d.isChecked() ? "4"
                : bi.k401e.isChecked() ? "5"
                : bi.k401f.isChecked() ? "6"
                : bi.k401g.isChecked() ? "7"
                : bi.k40197.isChecked() ? "97"
                : "-1");

        json.put("k402", bi.k402a.isChecked() ? "1"
                : bi.k402b.isChecked() ? "2"
                : "-1");

        json.put("k403", bi.k403a.isChecked() ? "1"
                : bi.k403b.isChecked() ? "2"
                : bi.k403c.isChecked() ? "3"
                : "-1");

        json.put("k404", bi.k404a.isChecked() ? "1"
                : bi.k404b.isChecked() ? "2"
                : "-1");

        json.put("k405", bi.k405a.isChecked() ? "1"
                : bi.k405b.isChecked() ? "2"
                : bi.k405c.isChecked() ? "3"
                : bi.k405d.isChecked() ? "4"
                : bi.k405e.isChecked() ? "5"
                : "-1");

        json.put("k406", bi.k406.getText().toString().trim().isEmpty() ? "-1" : bi.k406.getText().toString());

        json.put("k407", bi.k407a.isChecked() ? "1"
                : bi.k407b.isChecked() ? "2"
                : "-1");

        json.put("k408", bi.k408a.isChecked() ? "1"
                : bi.k408b.isChecked() ? "2"
                : bi.k408c.isChecked() ? "3"
                : "-1");

        json.put("k409", bi.k409a.isChecked() ? "1"
                : bi.k409b.isChecked() ? "2"
                : bi.k409c.isChecked() ? "3"
                : bi.k409d.isChecked() ? "4"
                : bi.k40997.isChecked() ? "97"
                : "-1");

        json.put("k410", bi.k410a.isChecked() ? "1"
                : bi.k410b.isChecked() ? "2"
                : bi.k410c.isChecked() ? "3"
                : "-1");

        json.put("k411a", bi.k411a.isChecked() ? "1" : "-1");
        json.put("k411b", bi.k411b.isChecked() ? "2" : "-1");
        json.put("k411c", bi.k411c.isChecked() ? "3" : "-1");

        json.put("k412a", bi.k412a.getText().toString().trim().isEmpty() ? "-1" : bi.k412a.getText().toString());
        json.put("k412b", bi.k412b.getText().toString().trim().isEmpty() ? "-1" : bi.k412b.getText().toString());
        json.put("k412c", bi.k412c.getText().toString().trim().isEmpty() ? "-1" : bi.k412c.getText().toString());
        json.put("k412d", bi.k412d.getText().toString().trim().isEmpty() ? "-1" : bi.k412d.getText().toString());
        json.put("k412e", bi.k412e.getText().toString().trim().isEmpty() ? "-1" : bi.k412e.getText().toString());
        json.put("k412f", bi.k412f.getText().toString().trim().isEmpty() ? "-1" : bi.k412f.getText().toString());
        json.put("k412g", bi.k412g.getText().toString().trim().isEmpty() ? "-1" : bi.k412g.getText().toString());

        json.put("k413a", bi.k413a.getText().toString().trim().isEmpty() ? "-1" : bi.k413a.getText().toString());
        json.put("k413b", bi.k413b.getText().toString().trim().isEmpty() ? "-1" : bi.k413b.getText().toString());
        json.put("k413c", bi.k413c.getText().toString().trim().isEmpty() ? "-1" : bi.k413c.getText().toString());

        json.put("k414a", bi.k414a.isChecked() ? "1" : "-1");
        json.put("k414b", bi.k414b.isChecked() ? "2" : "-1");
        json.put("k414c", bi.k414c.isChecked() ? "3" : "-1");
        json.put("k414d", bi.k414d.isChecked() ? "4" : "-1");
        json.put("k414e", bi.k414e.isChecked() ? "5" : "-1");
        json.put("k414f", bi.k414f.isChecked() ? "6" : "-1");
        json.put("k414g", bi.k414g.isChecked() ? "7" : "-1");
        json.put("k414h", bi.k414h.isChecked() ? "8" : "-1");
        json.put("k414i", bi.k414i.isChecked() ? "9" : "-1");

        json.put("k415", bi.k415a.isChecked() ? "1"
                : bi.k415b.isChecked() ? "2"
                : "-1");

        json.put("k416", bi.k416a.isChecked() ? "1"
                : bi.k416b.isChecked() ? "2"
                : bi.k416c.isChecked() ? "3"
                : bi.k416d.isChecked() ? "4"
                : "-1");

        json.put("k417", bi.k417a.isChecked() ? "1"
                : bi.k417b.isChecked() ? "2"
                : bi.k417c.isChecked() ? "3"
                : bi.k417d.isChecked() ? "4"
                : bi.k417e.isChecked() ? "5"
                : bi.k417f.isChecked() ? "6"
                : bi.k41796.isChecked() ? "96"
                : "-1");
        json.put("k41796x", bi.k41796x.getText().toString().trim().isEmpty() ? "-1" : bi.k41796x.getText().toString());

        json.put("k418", bi.k418a.isChecked() ? "1"
                : bi.k418b.isChecked() ? "2"
                : "-1");

        json.put("k419a", bi.k419a.isChecked() ? "1" : "-1");
        json.put("k419b", bi.k419b.isChecked() ? "2" : "-1");
        json.put("k419c", bi.k419c.isChecked() ? "3" : "-1");
        json.put("k419d", bi.k419d.isChecked() ? "4" : "-1");
        json.put("k419e", bi.k419e.isChecked() ? "5" : "-1");
        json.put("k419f", bi.k419f.isChecked() ? "6" : "-1");
        json.put("k419g", bi.k419g.isChecked() ? "7" : "-1");


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
