package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionG422Binding;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;


public class SectionG422Activity extends AppCompatActivity {

    ActivitySectionG422Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g422);
        bi.setCallback(this);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("g4301a", bi.g4301aa.isChecked() ? "1"
                : bi.g4301ab.isChecked() ? "2"
                : "-1");

        json.put("g4301b", bi.g4301ba.isChecked() ? "1"
                : bi.g4301bb.isChecked() ? "2"
                : "-1");

        json.put("g4301cd", bi.g4301cd.getText().toString().trim().length() > 0 ? bi.g4301cd.getText().toString() : "-1");
        json.put("g4301cm", bi.g4301cm.getText().toString().trim().length() > 0 ? bi.g4301cm.getText().toString() : "-1");


        json.put("g4302a", bi.g4302aa.isChecked() ? "1"
                : bi.g4302ab.isChecked() ? "2"
                : "-1");

        json.put("g4302b", bi.g4302ba.isChecked() ? "1"
                : bi.g4302bb.isChecked() ? "2"
                : "-1");

        json.put("g4302cd", bi.g4302cd.getText().toString().trim().length() > 0 ? bi.g4302cd.getText().toString() : "-1");
        json.put("g4302cm", bi.g4302cm.getText().toString().trim().length() > 0 ? bi.g4302cm.getText().toString() : "-1");


        json.put("g4303a", bi.g4303aa.isChecked() ? "1"
                : bi.g4303ab.isChecked() ? "2"
                : "-1");

        json.put("g4303b", bi.g4303ba.isChecked() ? "1"
                : bi.g4303bb.isChecked() ? "2"
                : "-1");

        json.put("g4303cd", bi.g4303cd.getText().toString().trim().length() > 0 ? bi.g4303cd.getText().toString() : "-1");
        json.put("g4303cm", bi.g4303cm.getText().toString().trim().length() > 0 ? bi.g4303cm.getText().toString() : "-1");


        json.put("g4304a", bi.g4304aa.isChecked() ? "1"
                : bi.g4304ab.isChecked() ? "2"
                : "-1");

        json.put("g4304b", bi.g4304ba.isChecked() ? "1"
                : bi.g4304bb.isChecked() ? "2"
                : "-1");

        json.put("g4304cd", bi.g4304cd.getText().toString().trim().length() > 0 ? bi.g4304cd.getText().toString() : "-1");
        json.put("g4304cm", bi.g4304cm.getText().toString().trim().length() > 0 ? bi.g4304cm.getText().toString() : "-1");


        json.put("g4305a", bi.g4305aa.isChecked() ? "1"
                : bi.g4305ab.isChecked() ? "2"
                : "-1");

        json.put("g4305b", bi.g4305ba.isChecked() ? "1"
                : bi.g4305bb.isChecked() ? "2"
                : "-1");

        json.put("g4305cd", bi.g4305cd.getText().toString().trim().length() > 0 ? bi.g4305cd.getText().toString() : "-1");
        json.put("g4305cm", bi.g4305cm.getText().toString().trim().length() > 0 ? bi.g4305cm.getText().toString() : "-1");


        json.put("g4306a", bi.g4306aa.isChecked() ? "1"
                : bi.g4306ab.isChecked() ? "2"
                : "-1");

        json.put("g4306b", bi.g4306ba.isChecked() ? "1"
                : bi.g4306bb.isChecked() ? "2"
                : "-1");

        json.put("g4306cd", bi.g4306cd.getText().toString().trim().length() > 0 ? bi.g4306cd.getText().toString() : "-1");
        json.put("g4306cm", bi.g4306cm.getText().toString().trim().length() > 0 ? bi.g4306cm.getText().toString() : "-1");


        json.put("g4307a", bi.g4307aa.isChecked() ? "1"
                : bi.g4307ab.isChecked() ? "2"
                : "-1");

        json.put("g4307b", bi.g4307ba.isChecked() ? "1"
                : bi.g4307bb.isChecked() ? "2"
                : "-1");

        json.put("g4307cd", bi.g4307cd.getText().toString().trim().isEmpty() ? "-1" : bi.g4307cd.getText().toString());
        json.put("g4307cm", bi.g4307cm.getText().toString().trim().isEmpty() ? "-1" : bi.g4307cm.getText().toString());


        json.put("g4308a", bi.g4308aa.isChecked() ? "1"
                : bi.g4308ab.isChecked() ? "2"
                : "-1");

        json.put("g4308b", bi.g4308ba.isChecked() ? "1"
                : bi.g4308bb.isChecked() ? "2"
                : "-1");

        json.put("g4308cd", bi.g4308cd.getText().toString().trim().length() > 0 ? bi.g4308cd.getText().toString() : "-1");
        json.put("g4308cm", bi.g4308cm.getText().toString().trim().length() > 0 ? bi.g4308cm.getText().toString() : "-1");


        json.put("g4309a", bi.g4309aa.isChecked() ? "1"
                : bi.g4309ab.isChecked() ? "2"
                : "-1");

        json.put("g4309b", bi.g4309ba.isChecked() ? "1"
                : bi.g4309bb.isChecked() ? "2"
                : "-1");

        json.put("g4309cd", bi.g4309cd.getText().toString().trim().length() > 0 ? bi.g4309cd.getText().toString() : "-1");
        json.put("g4309cm", bi.g4309cm.getText().toString().trim().length() > 0 ? bi.g4309cm.getText().toString() : "-1");


        json.put("g4310a", bi.g4310aa.isChecked() ? "1"
                : bi.g4310ab.isChecked() ? "2"
                : "-1");

        json.put("g4310b", bi.g4310ba.isChecked() ? "1"
                : bi.g4310bb.isChecked() ? "2"
                : "-1");

        json.put("g4310cd", bi.g4310cd.getText().toString().trim().length() > 0 ? bi.g4310cd.getText().toString() : "-1");
        json.put("g4310cm", bi.g4310cm.getText().toString().trim().length() > 0 ? bi.g4310cm.getText().toString() : "-1");

        json.put("g4311a", bi.g4311aa.isChecked() ? "1"
                : bi.g4311ab.isChecked() ? "2"
                : "-1");

        json.put("g4311b", bi.g4311ba.isChecked() ? "1"
                : bi.g4311bb.isChecked() ? "2"
                : "-1");

        json.put("g4311cd", bi.g4311cd.getText().toString().trim().length() > 0 ? bi.g4311cd.getText().toString() : "-1");
        json.put("g4311cm", bi.g4311cm.getText().toString().trim().length() > 0 ? bi.g4311cm.getText().toString() : "-1");


        json.put("g4312a", bi.g4312aa.isChecked() ? "1"
                : bi.g4312ab.isChecked() ? "2"
                : "-1");

        json.put("g4312b", bi.g4312ba.isChecked() ? "1"
                : bi.g4312bb.isChecked() ? "2"
                : "-1");

        json.put("g4312cd", bi.g4312cd.getText().toString().trim().length() > 0 ? bi.g4312cd.getText().toString() : "-1");
        json.put("g4312cm", bi.g4312cm.getText().toString().trim().length() > 0 ? bi.g4312cm.getText().toString() : "-1");


        json.put("g4313a", bi.g4313aa.isChecked() ? "1"
                : bi.g4313ab.isChecked() ? "2"
                : "-1");

        json.put("g4313b", bi.g4313ba.isChecked() ? "1"
                : bi.g4313bb.isChecked() ? "2"
                : "-1");

        json.put("g4313cd", bi.g4313cd.getText().toString().trim().length() > 0 ? bi.g4313cd.getText().toString() : "-1");
        json.put("g4313cm", bi.g4313cm.getText().toString().trim().length() > 0 ? bi.g4313cm.getText().toString() : "-1");


        json.put("g4314a", bi.g4314aa.isChecked() ? "1"
                : bi.g4314ab.isChecked() ? "2"
                : "-1");

        json.put("g4314b", bi.g4314ba.isChecked() ? "1"
                : bi.g4314bb.isChecked() ? "2"
                : "-1");

        json.put("g4314cd", bi.g4314cd.getText().toString().trim().length() > 0 ? bi.g4314cd.getText().toString() : "-1");
        json.put("g4314cm", bi.g4314cm.getText().toString().trim().length() > 0 ? bi.g4314cm.getText().toString() : "-1");


        json.put("g4315a", bi.g4315aa.isChecked() ? "1"
                : bi.g4315ab.isChecked() ? "2"
                : "-1");

        json.put("g4315b", bi.g4315ba.isChecked() ? "1"
                : bi.g4315bb.isChecked() ? "2"
                : "-1");

        json.put("g4315cd", bi.g4315cd.getText().toString().trim().length() > 0 ? bi.g4315cd.getText().toString() : "-1");
        json.put("g4315cm", bi.g4315cm.getText().toString().trim().length() > 0 ? bi.g4315cm.getText().toString() : "-1");


        json.put("g4316a", bi.g4316aa.isChecked() ? "1"
                : bi.g4316ab.isChecked() ? "2"
                : "-1");

        json.put("g4316b", bi.g4316ba.isChecked() ? "1"
                : bi.g4316bb.isChecked() ? "2"
                : "-1");

        json.put("g4316cd", bi.g4316cd.getText().toString().trim().length() > 0 ? bi.g4316cd.getText().toString() : "-1");
        json.put("g4316cm", bi.g4316cm.getText().toString().trim().length() > 0 ? bi.g4316cm.getText().toString() : "-1");


        json.put("g4317a", bi.g4317aa.isChecked() ? "1"
                : bi.g4317ab.isChecked() ? "2"
                : "-1");

        json.put("g4317b", bi.g4317ba.isChecked() ? "1"
                : bi.g4317bb.isChecked() ? "2"
                : "-1");

        json.put("g4317cd", bi.g4317cd.getText().toString().trim().isEmpty() ? "-1" : bi.g4317cd.getText().toString());
        json.put("g4317cm", bi.g4317cm.getText().toString().trim().isEmpty() ? "-1" : bi.g4317cm.getText().toString());


        json.put("g4318a", bi.g4318aa.isChecked() ? "1"
                : bi.g4318ab.isChecked() ? "2"
                : "-1");

        json.put("g4318b", bi.g4318ba.isChecked() ? "1"
                : bi.g4318bb.isChecked() ? "2"
                : "-1");

        json.put("g4318cd", bi.g4318cd.getText().toString().trim().length() > 0 ? bi.g4318cd.getText().toString() : "-1");
        json.put("g4318cm", bi.g4318cm.getText().toString().trim().length() > 0 ? bi.g4318cm.getText().toString() : "-1");


        json.put("g4319a", bi.g4319aa.isChecked() ? "1"
                : bi.g4319ab.isChecked() ? "2"
                : "-1");

        json.put("g4319b", bi.g4319ba.isChecked() ? "1"
                : bi.g4319bb.isChecked() ? "2"
                : "-1");

        json.put("g4319cd", bi.g4319cd.getText().toString().trim().length() > 0 ? bi.g4319cd.getText().toString() : "-1");
        json.put("g4319cm", bi.g4319cm.getText().toString().trim().length() > 0 ? bi.g4319cm.getText().toString() : "-1");


        json.put("g4320a", bi.g4320aa.isChecked() ? "1"
                : bi.g4320ab.isChecked() ? "2"
                : "-1");

        json.put("g4320b", bi.g4320ba.isChecked() ? "1"
                : bi.g4320bb.isChecked() ? "2"
                : "-1");

        json.put("g4320cd", bi.g4320cd.getText().toString().trim().length() > 0 ? bi.g4320cd.getText().toString() : "-1");
        json.put("g4320cm", bi.g4320cm.getText().toString().trim().length() > 0 ? bi.g4320cm.getText().toString() : "-1");

        json.put("g4321a", bi.g4321aa.isChecked() ? "1"
                : bi.g4321ab.isChecked() ? "2"
                : "-1");

        json.put("g4321b", bi.g4321ba.isChecked() ? "1"
                : bi.g4321bb.isChecked() ? "2"
                : "-1");

        json.put("g4321cd", bi.g4321cd.getText().toString().trim().length() > 0 ? bi.g4321cd.getText().toString() : "-1");
        json.put("g4321cm", bi.g4321cm.getText().toString().trim().length() > 0 ? bi.g4321cm.getText().toString() : "-1");


        json.put("g4322a", bi.g4322aa.isChecked() ? "1"
                : bi.g4322ab.isChecked() ? "2"
                : "-1");

        json.put("g4322b", bi.g4322ba.isChecked() ? "1"
                : bi.g4322bb.isChecked() ? "2"
                : "-1");

        json.put("g4322cd", bi.g4322cd.getText().toString().trim().length() > 0 ? bi.g4322cd.getText().toString() : "-1");
        json.put("g4322cm", bi.g4322cm.getText().toString().trim().length() > 0 ? bi.g4322cm.getText().toString() : "-1");


        json.put("g4323a", bi.g4323aa.isChecked() ? "1"
                : bi.g4323ab.isChecked() ? "2"
                : "-1");

        json.put("g4323b", bi.g4323ba.isChecked() ? "1"
                : bi.g4323bb.isChecked() ? "2"
                : "-1");

        json.put("g4323cd", bi.g4323cd.getText().toString().trim().length() > 0 ? bi.g4323cd.getText().toString() : "-1");
        json.put("g4323cm", bi.g4323cm.getText().toString().trim().length() > 0 ? bi.g4323cm.getText().toString() : "-1");


        json.put("g4324a", bi.g4324aa.isChecked() ? "1"
                : bi.g4324ab.isChecked() ? "2"
                : "-1");

        json.put("g4324b", bi.g4324ba.isChecked() ? "1"
                : bi.g4324bb.isChecked() ? "2"
                : "-1");

        json.put("g4324cd", bi.g4324cd.getText().toString().trim().length() > 0 ? bi.g4324cd.getText().toString() : "-1");
        json.put("g4324cm", bi.g4324cm.getText().toString().trim().length() > 0 ? bi.g4324cm.getText().toString() : "-1");


        json.put("g4325a", bi.g4325aa.isChecked() ? "1"
                : bi.g4325ab.isChecked() ? "2"
                : "-1");

        json.put("g4325b", bi.g4325ba.isChecked() ? "1"
                : bi.g4325bb.isChecked() ? "2"
                : "-1");

        json.put("g4325cd", bi.g4325cd.getText().toString().trim().length() > 0 ? bi.g4325cd.getText().toString() : "-1");
        json.put("g4325cm", bi.g4325cm.getText().toString().trim().length() > 0 ? bi.g4325cm.getText().toString() : "-1");


        json.put("g4326a", bi.g4326aa.isChecked() ? "1"
                : bi.g4326ab.isChecked() ? "2"
                : "-1");

        json.put("g4326b", bi.g4326ba.isChecked() ? "1"
                : bi.g4326bb.isChecked() ? "2"
                : "-1");

        json.put("g4326cd", bi.g4326cd.getText().toString().trim().length() > 0 ? bi.g4326cd.getText().toString() : "-1");
        json.put("g4326cm", bi.g4326cm.getText().toString().trim().length() > 0 ? bi.g4326cm.getText().toString() : "-1");


        json.put("g4327a", bi.g4327aa.isChecked() ? "1"
                : bi.g4327ab.isChecked() ? "2"
                : "-1");

        json.put("g4327b", bi.g4327ba.isChecked() ? "1"
                : bi.g4327bb.isChecked() ? "2"
                : "-1");

        json.put("g4327cd", bi.g4327cd.getText().toString().trim().isEmpty() ? "-1" : bi.g4327cd.getText().toString());
        json.put("g4327cm", bi.g4327cm.getText().toString().trim().isEmpty() ? "-1" : bi.g4327cm.getText().toString());


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsG()), json);

            MainApp.fc.setsG(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, SectionG423Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void btnEnd(View v) {
        openSectionMainActivity(this, "G");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
