package edu.aku.hassannaqvi.hfa_rs.ui.other;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionMainBinding;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionBActivity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionC1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionD1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionE1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionF1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionG1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionH16Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionH2Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionI1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionJ1Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionJ2Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionJ3Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionJ4Activity;
import edu.aku.hassannaqvi.hfa_rs.ui.sections.SectionK1Activity;
import edu.aku.hassannaqvi.hfa_rs.utils.JSONUtils;

public class SectionMainActivity extends AppCompatActivity {
    //public static String maternalCount = 0, paedsCount = 0;
    public static int countC2 = 0, countI = 0;
    ActivitySectionMainBinding bi;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_main);
        bi.setCallback(this);


        if (countC2 != 0 && !flag) {

            JSONObject json = new JSONObject();

            try {
                json.put("countC2", String.valueOf(countC2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsC()), json);
                fc.setsC(String.valueOf(json_merge));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            DatabaseHelper db = MainApp.appInfo.getDbHelper();
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, MainApp.fc.getsC());
            Toast.makeText(this, "countC2: 0" + countC2, Toast.LENGTH_SHORT).show();
        }


        if (fc.getsB() != null) {
            bi.form01.setEnabled(false);
            bi.form01.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsC() != null || fc.getA10().equals("2")) {
            bi.form02.setEnabled(false);
            bi.form02.setBackgroundResource(R.color.dullWhite);
            flag = true;
        }

        if (fc.getsD() != null) {
            bi.form03.setEnabled(false);
            bi.form03.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsE() != null) {
            bi.form04.setEnabled(false);
            bi.form04.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsF() != null || fc.getA10().equals("2")) {
            bi.form05.setEnabled(false);
            bi.form05.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsG() != null || fc.getA10().equals("2")) {
            bi.form06.setEnabled(false);
            bi.form06.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsH() != null) {
            bi.form07.setEnabled(false);
            bi.form07.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsI() != null) {
            bi.form08.setEnabled(false);
            bi.form08.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsJ() != null) {
            bi.form09.setEnabled(false);
            bi.form09.setBackgroundResource(R.color.dullWhite);
        }

        if (fc.getsK() != null) {
            bi.form10.setEnabled(false);
            bi.form10.setBackgroundResource(R.color.dullWhite);
        }


    }


    public void openForm(View v) {
        OpenFormFunc(v.getId());
    }


    public void BtnContinue() {
        if (!bi.form01.isEnabled()
                && !bi.form02.isEnabled()
                && !bi.form03.isEnabled()
                && !bi.form04.isEnabled()
                && !bi.form05.isEnabled()
                && !bi.form06.isEnabled()
                && !bi.form07.isEnabled()
                && !bi.form08.isEnabled()
                && !bi.form09.isEnabled()
                && !bi.form10.isEnabled()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            //MainApp.endActivity(this, SectionBActivity.class);
        } else {
            Toast.makeText(this, "Sections still in Pending!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        if (bi.form01.isEnabled()
                || bi.form02.isEnabled()
                || bi.form03.isEnabled()
                || bi.form04.isEnabled()
                || bi.form05.isEnabled()
                || bi.form06.isEnabled()
                || bi.form07.isEnabled()
                || bi.form08.isEnabled()
                || bi.form09.isEnabled()
                || bi.form10.isEnabled()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            //MainApp.endActivity(this, EndingActivity.class).putExtra("complete", false);
        } else {
            Toast.makeText(this, "ALL SECTIONS FILLED \n Good to GO GREEN!", Toast.LENGTH_SHORT).show();
        }

    }


    private void OpenFormFunc(int id) {
        Intent oF = new Intent();
        if (!MainApp.userName.equals("0000")) {
            switch (id) {
                case R.id.form01:
                    oF = new Intent(this, SectionBActivity.class);
                    break;
                case R.id.form02:
                    oF = new Intent(this, SectionC1Activity.class);
                    break;
                case R.id.form03:
                    oF = new Intent(this, SectionD1Activity.class);
                    break;
                case R.id.form04:
                    oF = new Intent(this, SectionE1Activity.class);
                    break;
                case R.id.form05:
                    oF = new Intent(this, SectionF1Activity.class);
                    break;
                case R.id.form06:
                    oF = new Intent(this, SectionG1Activity.class);
                    break;
                case R.id.form07:
                    oF = new Intent(this, fc.getA10().equals("2") ? SectionH16Activity.class : SectionH2Activity.class);
                    break;
                case R.id.form08:
                    countI = 0;
                    oF = new Intent(this, SectionI1Activity.class);
                    break;
                case R.id.form09:
                    if (fc.getA10().equals("1")) {
                        oF = new Intent(this, SectionJ1Activity.class);
                    } else {
                        if (fc.getDistrictType().equals("2") || fc.getDistrictType().equals("4")) {
                            oF = new Intent(this, SectionJ1Activity.class);
                        } else if (!fc.getDistrictType().equals("1")) {
                            oF = new Intent(this, SectionJ2Activity.class);
                        } else if (fc.getDistrictType().equals("3") || fc.getDistrictType().equals("4")) {
                            oF = new Intent(this, SectionJ3Activity.class);
                        } else if (fc.getDistrictType().equals("1")) {
                            oF = new Intent(this, SectionJ4Activity.class);
                        }
                    }
                    break;
                case R.id.form10:
                    oF = new Intent(this, SectionK1Activity.class);
                    break;
            }
            startActivity(oF);
        } else {
            Toast.makeText(getApplicationContext(), "Please login Again!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
