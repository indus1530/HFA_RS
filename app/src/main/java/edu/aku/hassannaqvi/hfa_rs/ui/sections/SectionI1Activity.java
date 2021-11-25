package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.CONSTANTS.SECTION_MAIN_CHECK_FOR_END;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;
import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.psc;
import static edu.aku.hassannaqvi.hfa_rs.utils.UtilKt.openSectionMainActivityI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.hfa_rs.CONSTANTS;
import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.PatientsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionI1Binding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.EndingActivity;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.hfa_rs.utils.EndSectionActivity;


public class SectionI1Activity extends AppCompatActivity implements EndSectionActivity {

    ActivitySectionI1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i1);
        bi.setCallback(this);
        setupSkips();
        setupContent();
    }


    private void setupContent() {

        psc = new PatientsContract();

        bi.hfType.setText(MainApp.fc.getA10().equals("1") ? getString(R.string.hfpublic) : getString(R.string.hfprivate));
        bi.countI.setText(new StringBuilder("Entries: 0").append(SectionMainActivity.countI));

        /*if (MainApp.fc.getA10().equals("1")) {
            if (SectionMainActivity.paedsCount == 3) bi.i0108a.setEnabled(false);
            else if (SectionMainActivity.maternalCount == 3) bi.i0108b.setEnabled(false);
        }*/
    }


    private void setupSkips() {

        bi.i0103.setOnCheckedChangeListener(((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpCVi0104)));

        bi.i0110a.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                bi.i0110b.setChecked(false);
                bi.i0110b.setEnabled(false);
                bi.i0110c.setChecked(false);
                bi.i0110c.setEnabled(false);
            } else {
                bi.i0110b.setEnabled(true);
                bi.i0110c.setEnabled(true);
            }
        });

        bi.i0111a.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {
                bi.i0111b.setChecked(false);
                bi.i0111b.setEnabled(false);
                bi.i0111c.setChecked(false);
                bi.i0111c.setEnabled(false);
            } else {
                bi.i0111b.setEnabled(true);
                bi.i0111c.setEnabled(true);
            }
        });

        /*bi.i0108.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i0108a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVi0105);
                bi.i0105a.setEnabled(true);
                Clear.clearAllFields(bi.fldGrpCVi0106);
                bi.i0106a.setMaxvalue(5);
                bi.i0106a.setMinvalue(0);
            } else if (i == bi.i0108b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVi0105);
                bi.i0105a.setEnabled(false);
                bi.i0105b.setChecked(true);
                Clear.clearAllFields(bi.fldGrpCVi0106);
                bi.i0106a.setMaxvalue(49);
                bi.i0106a.setMinvalue(15);
            }

        }));*/


        /*bi.i0106a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(bi.i0106a.getText()))
                    return;
                if (bi.i0108a.isChecked() && Integer.parseInt(bi.i0106a.getText().toString()) == 5) {
                    bi.i0106b.setMaxvalue(0);
                } else if (bi.i0108b.isChecked() && Integer.parseInt(bi.i0106a.getText().toString()) == 49) {
                    bi.i0106b.setMaxvalue(0);
                } else {
                    bi.i0106b.setMaxvalue(11);
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });*/


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
            SectionMainActivity.countI++;
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true).putExtra(CONSTANTS.SECTION_MAIN_CHECK_FOR_END, true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        /*if (!Validator.emptyCheckingContainer(this, bi.fldGrpEndForm)) return;
        contextEndActivity(this);*/
        openSectionMainActivityI(this);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addPSC(psc);
        psc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            psc.set_UID(psc.getDeviceID() + psc.get_ID());
            db.updatesPSCColumn(PatientsContract.PatientsTable.COLUMN_UID, psc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        psc.setSysdate(fc.getSysdate());
        psc.setUserName(fc.getUserName());
        psc.setDeviceID(MainApp.appInfo.getDeviceID());
        psc.setDevicetagID(MainApp.appInfo.getTagName());
        psc.setAppversion(MainApp.appInfo.getAppVersion());
        psc.set_UUID(MainApp.fc.get_UID());
        psc.setDistrictCode(MainApp.fc.getDistrictCode());
        psc.setDistrictType(MainApp.fc.getDistrictType());
        psc.setTehsilCode(MainApp.fc.getTehsilCode());
        psc.setUcCode(MainApp.fc.getUcCode());
        psc.setHfCode(MainApp.fc.getHfCode());
//        psc.serialno = serial.toString()

        JSONObject json = new JSONObject();

        json.put("i0101", bi.i0101a.isChecked() ? "1"
                : bi.i0101b.isChecked() ? "2"
                : "-1");

        json.put("i0102a", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("i0102b", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("i0103", bi.i0103a.isChecked() ? "1"
                : bi.i0103b.isChecked() ? "2"
                : "-1");

        json.put("i0104", bi.i0104a.isChecked() ? "1"
                : bi.i0104b.isChecked() ? "2"
                : bi.i0104c.isChecked() ? "3"
                : bi.i0104d.isChecked() ? "4"
                : "-1");

        json.put("i0105", bi.i0105a.isChecked() ? "1"
                : bi.i0105b.isChecked() ? "2"
                : "-1");

        json.put("i0106a", bi.i0106a.getText().toString().trim().isEmpty() ? "-1" : bi.i0106a.getText().toString());
        json.put("i0106b", bi.i0106b.getText().toString().trim().isEmpty() ? "-1" : bi.i0106b.getText().toString());

        json.put("i0107", bi.i0107a.isChecked() ? "1"
                : bi.i0107b.isChecked() ? "2"
                : "-1");

        json.put("i0108a", bi.i0108a.isChecked() ? "1" : "-1");
        json.put("i0108b", bi.i0108b.isChecked() ? "2" : "-1");
        json.put("i0108c", bi.i0108c.isChecked() ? "3" : "-1");
        json.put("i0108d", bi.i0108d.isChecked() ? "4" : "-1");
        json.put("i0108e", bi.i0108e.isChecked() ? "5" : "-1");
        json.put("i0108f", bi.i0108f.isChecked() ? "6" : "-1");
        json.put("i0108g", bi.i0108g.isChecked() ? "7" : "-1");
        json.put("i010896", bi.i010896.isChecked() ? "96" : "-1");
        json.put("i010896x", bi.i010896x.getText().toString().trim().isEmpty() ? "-1" : bi.i010896x.getText().toString());

        json.put("i01091", bi.i01091a.isChecked() ? "1"
                : bi.i01091b.isChecked() ? "2"
                : bi.i01091c.isChecked() ? "3"
                : bi.i01091d.isChecked() ? "4"
                : bi.i01091e.isChecked() ? "5"
                : "-1");

        json.put("i01092", bi.i01092a.isChecked() ? "1"
                : bi.i01092b.isChecked() ? "2"
                : bi.i01092c.isChecked() ? "3"
                : bi.i01092d.isChecked() ? "4"
                : bi.i01092e.isChecked() ? "5"
                : "-1");

        json.put("i01093", bi.i01093a.isChecked() ? "1"
                : bi.i01093b.isChecked() ? "2"
                : bi.i01093c.isChecked() ? "3"
                : bi.i01093d.isChecked() ? "4"
                : bi.i01093e.isChecked() ? "5"
                : "-1");

        json.put("i01094", bi.i01094a.isChecked() ? "1"
                : bi.i01094b.isChecked() ? "2"
                : bi.i01094c.isChecked() ? "3"
                : bi.i01094d.isChecked() ? "4"
                : bi.i01094e.isChecked() ? "5"
                : "-1");

        json.put("i01095", bi.i01095a.isChecked() ? "1"
                : bi.i01095b.isChecked() ? "2"
                : bi.i01095c.isChecked() ? "3"
                : bi.i01095d.isChecked() ? "4"
                : bi.i01095e.isChecked() ? "5"
                : "-1");

        json.put("i01096", bi.i01096a.isChecked() ? "1"
                : bi.i01096b.isChecked() ? "2"
                : bi.i01096c.isChecked() ? "3"
                : bi.i01096d.isChecked() ? "4"
                : bi.i01096e.isChecked() ? "5"
                : "-1");

        json.put("i0110a", bi.i0110a.isChecked() ? "1" : "-1");
        json.put("i0110b", bi.i0110b.isChecked() ? "2" : "-1");
        json.put("i0110c", bi.i0110c.isChecked() ? "3" : "-1");
        json.put("i0110bx", bi.i0110bx.getText().toString().trim().isEmpty() ? "-1" : bi.i0110bx.getText().toString());
        json.put("i0110cx", bi.i0110cx.getText().toString().trim().isEmpty() ? "-1" : bi.i0110cx.getText().toString());

        json.put("i0111a", bi.i0111a.isChecked() ? "1" : "-1");
        json.put("i0111b", bi.i0111b.isChecked() ? "2" : "-1");
        json.put("i0111c", bi.i0111c.isChecked() ? "3" : "-1");
        json.put("i0111bx", bi.i0111bx.getText().toString().trim().isEmpty() ? "-1" : bi.i0111bx.getText().toString());
        json.put("i0111cx", bi.i0111cx.getText().toString().trim().isEmpty() ? "-1" : bi.i0111cx.getText().toString());

        json.put("i0112a", bi.i0112a.isChecked() ? "1" : "-1");
        json.put("i0112b", bi.i0112b.isChecked() ? "2" : "-1");
        json.put("i0112ax", bi.i0112ax.getText().toString().trim().isEmpty() ? "-1" : bi.i0112ax.getText().toString());
        json.put("i0112bx", bi.i0112bx.getText().toString().trim().isEmpty() ? "-1" : bi.i0112bx.getText().toString());

        json.put("i0113", bi.i0113a.isChecked() ? "1"
                : bi.i0113b.isChecked() ? "2"
                : "-1");

        json.put("i0114", bi.i0114a.isChecked() ? "1"
                : bi.i0114b.isChecked() ? "2"
                : "-1");

        json.put("i0115", bi.i0115a.isChecked() ? "1"
                : bi.i0115b.isChecked() ? "2"
                : bi.i0115c.isChecked() ? "3"
                : "-1");
        json.put("i0115x", bi.i0115x.getText().toString().trim().isEmpty() ? "-1" : bi.i0115x.getText().toString());

        json.put("i0116a", bi.i0116a.isChecked() ? "1" : "-1");
        json.put("i0116b", bi.i0116b.isChecked() ? "2" : "-1");
        json.put("i0116c", bi.i0116c.isChecked() ? "3" : "-1");
        json.put("i0116d", bi.i0116d.isChecked() ? "4" : "-1");
        json.put("i0116e", bi.i0116e.isChecked() ? "5" : "-1");
        json.put("i0116f", bi.i0116f.isChecked() ? "6" : "-1");
        json.put("i011696", bi.i011696.isChecked() ? "96" : "-1");
        json.put("i011696x", bi.i011696x.getText().toString().trim().isEmpty() ? "-1" : bi.i011696x.getText().toString());

        json.put("i0117", bi.i0117a.isChecked() ? "1"
                : bi.i0117b.isChecked() ? "2"
                : "-1");

        psc.setsI1(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
       /* if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.i0106a.getText().toString().trim().length() > 0 && bi.i0106b.getText().toString().trim().length() > 0) {
            if (Integer.parseInt(bi.i0106a.getText().toString().trim()) + Integer.parseInt(bi.i0106a.getText().toString().trim()) == 0) {
                return ValidatorClass.EmptyCustomeTextBox(this, bi.i0106a, "Both!! Month & Year Can't be Zero!");
                //return Validator.emptyCheckingContainer(this, bi.i0106a);
            }
        }
        return true;*/
    }


    @Override
    public void endSecActivity(boolean flag) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            SectionMainActivity.countI++;
            startActivity(new Intent(this, EndingActivity.class).putExtra(SECTION_MAIN_CHECK_FOR_END, true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        if (SectionMainActivity.countI > 0) {
            Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
        } else super.onBackPressed();
    }


}
