package edu.aku.hassannaqvi.hfa_rs.ui.sync;

import static edu.aku.hassannaqvi.hfa_rs.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.hfa_rs.utils.CreateTable.DB_NAME;
import static edu.aku.hassannaqvi.hfa_rs.utils.CreateTable.PROJECT_NAME;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.hfa_rs.CONSTANTS;
import edu.aku.hassannaqvi.hfa_rs.R;
import edu.aku.hassannaqvi.hfa_rs.adapter.SyncListAdapter;
import edu.aku.hassannaqvi.hfa_rs.adapter.UploadListAdapter;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.PatientsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.StaffingContract;
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper;
import edu.aku.hassannaqvi.hfa_rs.core.MainApp;
import edu.aku.hassannaqvi.hfa_rs.databinding.ActivitySyncBinding;
import edu.aku.hassannaqvi.hfa_rs.get.GetAllData;
import edu.aku.hassannaqvi.hfa_rs.otherClasses.SyncModel;
import edu.aku.hassannaqvi.hfa_rs.sync.SyncAllData;
import edu.aku.hassannaqvi.hfa_rs.sync.SyncDevice;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDevicInterface {
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    String DirectoryName;
    DatabaseHelper db;
    SyncListAdapter syncListAdapter;
    UploadListAdapter uploadListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private boolean sync_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        bi.noItem.setVisibility(View.VISIBLE);
        bi.noDataItem.setVisibility(View.VISIBLE);
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        db = new DatabaseHelper(this);
        dbBackup();

        sync_flag = getIntent().getBooleanExtra(CONSTANTS.SYNC_LOGIN, false);

        bi.btnSync.setOnClickListener(v -> onSyncDataClick());
        bi.btnUpload.setOnClickListener(v -> syncServer());
        setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setAdapter() {
        syncListAdapter = new SyncListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bi.rvSyncList.setLayoutManager(mLayoutManager);
        bi.rvSyncList.setItemAnimator(new DefaultItemAnimator());
        bi.rvSyncList.setAdapter(syncListAdapter);
        syncListAdapter.notifyDataSetChanged();
        if (syncListAdapter.getItemCount() > 0) {
            bi.noItem.setVisibility(View.GONE);
        } else {
            bi.noItem.setVisibility(View.VISIBLE);
        }
    }

    void setUploadAdapter() {
        uploadListAdapter = new UploadListAdapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(uploadListAdapter);
        uploadListAdapter.notifyDataSetChanged();
        if (uploadListAdapter.getItemCount() > 0) {
            bi.noDataItem.setVisibility(View.GONE);
        } else {
            bi.noDataItem.setVisibility(View.VISIBLE);
        }
    }

    public void syncServer() {
//        if(true) return;

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            DatabaseHelper db = new DatabaseHelper(this);

            new SyncDevice(this, false).execute();
//  *******************************************************Forms*********************************
            String[] unsyncedString = {"updateSyncedForms", "updateSyncedForms02", "updateSyncedForms03"};
            for (int i = 1; i <= 3; i++) {
                Toast.makeText(getApplicationContext(), "Syncing Forms (" + i + "/3)", Toast.LENGTH_SHORT).show();
                if (uploadlistActivityCreated) {
                    uploadmodel = new SyncModel();
                    uploadmodel.setstatusID(0);
                    uploadlist.add(uploadmodel);
                }
                new SyncAllData(
                        this,
                        "Forms Forms (" + i + "/3)",
                        unsyncedString[i - 1],
                        FormsContract.class,
                        MainApp._HOST_URL + MainApp._SERVER_URL,
                        FormsContract.FormsTable.TABLE_NAME + String.format("%02d", i),
                        db.getUnsyncedForms(i), i - 1, uploadListAdapter, uploadlist
                ).execute(i - 1);
            }

//  *******************************************************StaffingTable*********************************
            Toast.makeText(getApplicationContext(), "Syncing StaffingTable", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "StaffingTable",
                    "updateSyncedStaffing",
                    StaffingContract.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    StaffingContract.StaffingTable.TABLE_NAME,
                    db.getUnsyncedStaffing(), 3, uploadListAdapter, uploadlist
            ).execute();

//  *******************************************************PatientsTable*********************************
            Toast.makeText(getApplicationContext(), "Syncing PatientsTable", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "PatientsTable",
                    "updateSyncedPatient",
                    PatientsContract.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    PatientsContract.PatientsTable.TABLE_NAME,
                    db.getUnsyncedPatients(), 4, uploadListAdapter, uploadlist
            ).execute();


            bi.noDataItem.setVisibility(View.GONE);

            uploadlistActivityCreated = false;

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastDataUpload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    public void dbBackup() {

        sharedPref = getSharedPreferences("src", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", false)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));

            if (!dt.equals(new SimpleDateFormat("dd-MM-yy").format(new Date()))) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()));
                editor.apply();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + PROJECT_NAME);
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {
                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {
                        File dbFile = new File(this.getDatabasePath(DATABASE_NAME).getPath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator + DB_NAME;

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();
                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            MainApp.appInfo.updateTagName(SyncActivity.this);
            new SyncData(SyncActivity.this, MainApp.DIST_ID).execute();
        }
    }

    public class SyncData extends AsyncTask<Boolean, String, String> {

        private final Context mContext;
        private final String distID;

        private SyncData(Context mContext, String districtId) {
            this.mContext = mContext;
            this.distID = districtId;
        }

        @Override
        protected String doInBackground(Boolean... booleans) {
            runOnUiThread(() -> {


//                  getting Users!!
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "User", syncListAdapter, list).execute();

//                    Getting App Version
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "VersionApp", syncListAdapter, list).execute();

//                    Getting Districts
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "Districts", syncListAdapter, list).execute();

//                    Getting Tehsils
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "Tehsils", syncListAdapter, list).execute();

//                    Getting UCs
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "UCs", syncListAdapter, list).execute();

//                    Getting HealthFacilities
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "HealthFacilities", syncListAdapter, list).execute();

                bi.noItem.setVisibility(View.GONE);

                listActivityCreated = false;
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {
                SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = syncPref.edit();
                editor1.putString("LastDataDownload", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
                editor.putBoolean("flag", true);
                editor.commit();

                dbBackup();

            }, 1200);
        }
    }


}
