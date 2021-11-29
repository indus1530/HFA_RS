package edu.aku.hassannaqvi.hfa_rs.ui.sections;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp.fc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.contracts.DistrictContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.HFContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.TehsilsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.UCsContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.hfa_rs.ui.other.SectionMainActivity;

public class SectionAActivity extends AppCompatActivity {

    private final boolean fcFlag = false;
    ActivitySectionABinding bi;
    private List<String> districtNames, tehsilNames, ucNames;
    private List<String> districtCodes, tehsilCodes, ucCodes;
    private List<String> districtTypes;
    private DatabaseHelper db;
    private List<String> hfNamesPrv, hfNamesPub;
    private Map<String, String> hfMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        //bi.setFormsContract(MainApp.fc);
        initializingComponents();
        initializeHF();
    }


    private void initializingComponents() {
        // Databinding Edit Mode (only in first activity for every contract)
        fc = new FormsContract();
        db = MainApp.appInfo.getDbHelper();
        populateSpinner(this);
    }


    private void initializeHF() {
        //For HF
        hfNamesPrv = new ArrayList<String>() {
            {
                add("....");
            }
        };
        hfNamesPub = new ArrayList<String>() {
            {
                add("....");
            }
        };
        hfMap = new HashMap<>();
    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();
        districtTypes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");
        districtTypes.add("....");

        Collection<DistrictContract> dc = db.getAllDistricts();

        for (DistrictContract d : dc) {
            districtNames.add(d.getDistrictName());
            districtCodes.add(d.getDistrictCode());
            districtTypes.add(d.getDistrictType());
        }

        bi.a07.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, districtNames));

        bi.a07.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                tehsilNames = new ArrayList<>();
                tehsilCodes = new ArrayList<>();

                tehsilNames.add("....");
                tehsilCodes.add("....");

                Collection<TehsilsContract> pc = db.getAllTehsils(districtCodes.get(position));
                for (TehsilsContract p : pc) {
                    tehsilNames.add(p.getTehsilName());
                    tehsilCodes.add(p.getTehsilCode());
                }

                bi.a08.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, tehsilNames));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        bi.a08.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                ucNames = new ArrayList<>();
                ucCodes = new ArrayList<>();

                ucNames.add("....");
                ucCodes.add("....");
                Clear.clearAllFields(bi.fldGrpCVa10);

                //For HF
                initializeHF();

                Collection<UCsContract> pc = db.getAllUCs(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
                for (UCsContract p : pc) {
                    ucCodes.add(p.getUc_code());
                    ucNames.add(p.getUc_name());
                }

                bi.a09.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucNames));
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Collections.emptyList()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.a09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Clear.clearAllFields(bi.fldGrpCVa10);

                if (position == 0) return;
                if (hfMap.size() > 0) return;
                Collection<HFContract> pc = db.getAllHFs(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
                for (HFContract p : pc) {
                    if (p.getHf_type().equals("1")) hfNamesPub.add(p.getHf_name());
                    else hfNamesPrv.add(p.getHf_name());
                    hfMap.put(p.getHf_name(), p.getHf_code());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.a10.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVa11);
            if (i == bi.a10a.getId()) {
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNamesPub));
            } else if (i == bi.a10b.getId()) {
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNamesPrv));
            }
        }));

        bi.a13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //                Toast.makeText(SectionAActivity.this, String.valueOf(hfCodes.get(bi.a13.getSelectedItemPosition())), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void btnContinue(View v) {
        if (!formValidation()) return;
        SaveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {

        if (!fc.get_ID().equals("")) return true;

        long updcount = db.addForm(fc);
        fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            fc.set_UID(fc.getDeviceID() + fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        if (!fc.get_ID().equals("")) return;

        fc = new FormsContract();

        fc.setSysdate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));

        fc.setUserName(MainApp.userName);

        fc.setA01(MainApp.userName);

        fc.setDeviceID(MainApp.appInfo.getDeviceID());

        fc.setDevicetagID(MainApp.appInfo.getTagName());

        fc.setAppversion(MainApp.appInfo.getAppVersion());

        fc.setA03d(bi.a03d.getText().toString().trim().isEmpty() ? "-1" : bi.a03d.getText().toString());
        fc.setA03m(bi.a03m.getText().toString().trim().isEmpty() ? "-1" : bi.a03m.getText().toString());
        fc.setA03y(bi.a03y.getText().toString().trim().isEmpty() ? "-1" : bi.a03y.getText().toString());

        fc.setDistrictCode(districtCodes.get(bi.a07.getSelectedItemPosition()));
        fc.setA07(districtCodes.get(bi.a07.getSelectedItemPosition()));
        fc.setDistrictType(districtTypes.get(bi.a07.getSelectedItemPosition()));

        fc.setUcCode(ucCodes.get(bi.a09.getSelectedItemPosition()));
        fc.setA09(ucCodes.get(bi.a09.getSelectedItemPosition()));

        fc.setTehsilCode(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
        fc.setA08(tehsilCodes.get(bi.a08.getSelectedItemPosition()));

        fc.setHfCode(hfMap.get(bi.a13.getSelectedItem().toString()));
        fc.setHfName(bi.a13.getSelectedItem().toString());
        fc.setA12(hfMap.get(bi.a13.getSelectedItem().toString()));
        fc.setA13(bi.a13.getSelectedItem().toString());

        fc.setA10(bi.a10a.isChecked() ? "1"
                : bi.a10b.isChecked() ? "2"
                : "-1");

        fc.setA11(bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1");

        MainApp.setGPS(this); // Set GPS
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) {
            return false;
        }

        if (db.CheckHF(String.valueOf(hfMap.get(bi.a13.getSelectedItem().toString())))) {
            Toast.makeText(this, "Facility Already filled ", Toast.LENGTH_LONG).show();
            return false;
        }

        fc = db.CheckHF(String.valueOf(hfMap.get(bi.a13.getSelectedItem().toString())), "1");
        if (fc == null) {
            Toast.makeText(this, "Partially filled Facility ", Toast.LENGTH_LONG).show();
            return true;
        }
        return true;
    }


    public void btnEnd(View v) {
        //openSectionMainActivity(this, "A");
    }

}
