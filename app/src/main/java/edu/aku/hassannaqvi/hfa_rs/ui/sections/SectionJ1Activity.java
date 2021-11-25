package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionJ1Binding;

public class SectionJ1Activity extends AppCompatActivity {

    ActivitySectionJ1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {
        radioGroup(bi.j0101a);
        radioGroup(bi.j0101b);
        radioGroup(bi.j0101c);
        radioGroup(bi.j0101d);
        radioGroup(bi.j0101e);
        radioGroup(bi.j0101f);
        radioGroup(bi.j0101g);
        radioGroup(bi.j0101h);
        radioGroup(bi.j0101ia);
        radioGroup(bi.j0101ib);
        radioGroup(bi.j0101j);
        radioGroup(bi.j0101k);
        radioGroup(bi.j0101l);
    }


    public void radioGroup(RadioGroup grp) {

        grp.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (bi.j0101ab.isChecked() || bi.j0101bb.isChecked() || bi.j0101cb.isChecked()
                    || bi.j0101db.isChecked() || bi.j0101eb.isChecked() || bi.j0101fb.isChecked()
                    || bi.j0101gb.isChecked() || bi.j0101hb.isChecked() || bi.j0101iab.isChecked()
                    || bi.j0101ibb.isChecked() || bi.j0101jb.isChecked() || bi.j0101kb.isChecked() || bi.j0101lb.isChecked()) {
                Clear.clearAllFields(bi.fldGrpCVj0101m);
                bi.fldGrpCVj0101m.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVj0101m);
                bi.fldGrpCVj0101m.setVisibility(View.GONE);
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
            Intent intent;

            if (MainApp.fc.getA10().equals("2") && MainApp.fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ4Activity.class);
            } else {
                intent = new Intent(this, SectionJ2Activity.class);
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

        json.put("JDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("JTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("j0100a", bi.j0100a.getText().toString().trim().length() > 0 ? bi.j0100a.getText().toString() : "-1");
        json.put("j0100b", bi.j0100b.getText().toString().trim().length() > 0 ? bi.j0100b.getText().toString() : "-1");

        json.put("j0100c", bi.j0100ca.isChecked() ? "1"
                : bi.j0100cb.isChecked() ? "2"
                : "-1");

        json.put("j0101a", bi.j0101aa.isChecked() ? "1"
                : bi.j0101ab.isChecked() ? "2"
                : "-1");

        json.put("j0101b", bi.j0101ba.isChecked() ? "1"
                : bi.j0101bb.isChecked() ? "2"
                : "-1");

        json.put("j0101c", bi.j0101ca.isChecked() ? "1"
                : bi.j0101cb.isChecked() ? "2"
                : "-1");

        json.put("j0101d", bi.j0101da.isChecked() ? "1"
                : bi.j0101db.isChecked() ? "2"
                : "-1");

        json.put("j0101e", bi.j0101ea.isChecked() ? "1"
                : bi.j0101eb.isChecked() ? "2"
                : "-1");

        json.put("j0101f", bi.j0101fa.isChecked() ? "1"
                : bi.j0101fb.isChecked() ? "2"
                : "-1");

        json.put("j0101g", bi.j0101ga.isChecked() ? "1"
                : bi.j0101gb.isChecked() ? "2"
                : "-1");

        json.put("j0101h", bi.j0101ha.isChecked() ? "1"
                : bi.j0101hb.isChecked() ? "2"
                : "-1");


        json.put("j0101ia", bi.j0101iaa.isChecked() ? "1"
                : bi.j0101iab.isChecked() ? "2"
                : "-1");

        json.put("j0101ib", bi.j0101iba.isChecked() ? "1"
                : bi.j0101ibb.isChecked() ? "2"
                : "-1");

        json.put("j0101j", bi.j0101ja.isChecked() ? "1"
                : bi.j0101jb.isChecked() ? "2"
                : "-1");

        json.put("j0101k", bi.j0101ka.isChecked() ? "1"
                : bi.j0101kb.isChecked() ? "2"
                : "-1");

        json.put("j0101l", bi.j0101la.isChecked() ? "1"
                : bi.j0101lb.isChecked() ? "2"
                : "-1");

        json.put("j0101ma", bi.j0101ma.isChecked() ? "1" : "-1");
        json.put("j0101mb", bi.j0101mb.isChecked() ? "2" : "-1");
        json.put("j0101mc", bi.j0101mc.isChecked() ? "3" : "-1");
        json.put("j0101md", bi.j0101md.isChecked() ? "4" : "-1");
        json.put("j0101me", bi.j0101me.isChecked() ? "5" : "-1");
        json.put("j0101mf", bi.j0101mf.isChecked() ? "6" : "-1");
        json.put("j0101mx", bi.j0101mx.isChecked() ? "96" : "-1");
        json.put("j0101mxx", bi.j0101mxx.getText().toString().trim().length() > 0 ? bi.j0101mxx.getText().toString() : "-1");

        MainApp.fc.setsJ(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ1);

    }

}