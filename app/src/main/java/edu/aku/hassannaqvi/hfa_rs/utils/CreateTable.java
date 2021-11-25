package edu.aku.hassannaqvi.hfa_rs.utils;

import edu.aku.hassannaqvi.hfa_rs.contracts.DistrictContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.FormsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.HFContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.PatientsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.StaffingContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.TehsilsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.UCsContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.UsersContract;
import edu.aku.hassannaqvi.hfa_rs.contracts.VersionAppContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "uen_hfa_ml.db";
    public static final String DB_NAME = "uen_hfa_ml_copy.db";
    public static final String PROJECT_NAME = "UEN_HFA_ML2020";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USERNAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DISTRICT_TYPE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UC_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HF_CODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HF_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A01 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A03D + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A03M + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A03Y + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A07 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A08 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A09 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A10 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A11 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A12 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A13 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SB + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SD + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SF + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SH + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SI + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SJ + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SK + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_02 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE_02 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_03 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE_03 + " TEXT"
            + " );";


    public static final String SQL_CREATE_TSCONTRACT = "CREATE TABLE " + StaffingContract.StaffingTable.TABLE_NAME + "("
            + StaffingContract.StaffingTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + StaffingContract.StaffingTable.COLUMN_UID + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_UUID + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_SYSDATE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_USERNAME + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_SERIALNO + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_DISTRICT_TYPE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_UC_CODE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_HF_CODE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_SC2 + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_DEVICEID + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_DEVICETAGID + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_SYNCED + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_SYNCED_DATE + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_STATUS + " TEXT,"
            + StaffingContract.StaffingTable.COLUMN_APPVERSION + " TEXT"
            + " );";


    public static final String SQL_CREATE_PSCONTRACT = "CREATE TABLE " + PatientsContract.PatientsTable.TABLE_NAME + "("
            + PatientsContract.PatientsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + PatientsContract.PatientsTable.COLUMN_UID + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_UUID + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SYSDATE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_USERNAME + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SERIALNO + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_DISTRICT_CODE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_DISTRICT_TYPE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_TEHSIL_CODE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_UC_CODE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_HF_CODE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SI1 + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SI2 + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SI3 + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SI4 + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_DEVICEID + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_DEVICETAGID + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SYNCED + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_SYNCED_DATE + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_STATUS + " TEXT,"
            + PatientsContract.PatientsTable.COLUMN_APPVERSION + " TEXT"
            + " );";


    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT"
            + " );";


    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";


    public static final String SQL_CREATE_DISTRICTS = "CREATE TABLE " + DistrictContract.singleDistrict.TABLE_NAME + "("
            + DistrictContract.singleDistrict._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DistrictContract.singleDistrict.COLUMN_DISTRICT_CODE + " TEXT,"
            + DistrictContract.singleDistrict.COLUMN_DISTRICT_NAME + " TEXT,"
            + DistrictContract.singleDistrict.COLUMN_DISTRICT_TYPE + " TEXT );";


    public static final String SQL_CREATE_TEHSILS = "CREATE TABLE " + TehsilsContract.singleTehsil.TABLE_NAME + "("
            + TehsilsContract.singleTehsil._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TehsilsContract.singleTehsil.COLUMN_TEHSIL_CODE + " TEXT,"
            + TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME + " TEXT,"
            + TehsilsContract.singleTehsil.COLUMN_DISTRICT_CODE + " TEXT );";


    public static final String SQL_CREATE_UCS = "CREATE TABLE " + UCsContract.singleUCs.TABLE_NAME + "("
            + UCsContract.singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCsContract.singleUCs.COLUMN_UC_CODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_TEHSIL_CODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_UC_NAME + " TEXT );";


    public static final String SQL_CREATE_HF = "CREATE TABLE " + HFContract.singleHF.TABLE_NAME + "("
            + HFContract.singleHF._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + HFContract.singleHF.COLUMN_HF_CODE + " TEXT,"
            + HFContract.singleHF.COLUMN_TEHSIL_CODE + " TEXT,"
            + HFContract.singleHF.COLUMN_HF_NAME + " TEXT,"
            + HFContract.singleHF.COLUMN_HF_TYPE + " TEXT );";

}
