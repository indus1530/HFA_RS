package edu.aku.hassannaqvi.hfa_rs.ui.sections;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionH2Binding;


public class SectionH2Activity extends AppCompatActivity {

    ActivitySectionH2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2);
        bi.setCallback(this);

    }


    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionH31Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd(View v) {
        openSectionMainActivity(this, "H");
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, MainApp.fc.getsH());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("HDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("HTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("h0201", bi.h0201a.isChecked() ? "1"
                : bi.h0201b.isChecked() ? "2"
                : "-1");

        json.put("h0202", bi.h0202a.isChecked() ? "1"
                : bi.h0202b.isChecked() ? "2"
                : bi.h0202c.isChecked() ? "3"
                : "-1");

        json.put("h0203a", bi.h0203aa.isChecked() ? "1"
                : bi.h0203ab.isChecked() ? "2"
                : bi.h0203ac.isChecked() ? "3"
                : bi.h0203ad.isChecked() ? "4"
                : "-1");

        json.put("h0203b", bi.h0203ba.isChecked() ? "1"
                : bi.h0203bb.isChecked() ? "2"
                : bi.h0203bc.isChecked() ? "3"
                : bi.h0203bd.isChecked() ? "4"
                : "-1");

        MainApp.fc.setsH(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
