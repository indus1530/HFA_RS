package edu.aku.hassannaqvi.hfa_rs.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class StaffingContract {


    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String sysdate = "";
    private String userName = "";
    private String serialno = "";
    private String deviceID = "";
    private String status = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String devicetagID = "";
    private String districtCode = "";
    private String districtType = "";
    private String tehsilCode = "";
    private String ucCode = "";
    private String hfCode = "";
    private String sC2;


    public StaffingContract() {
    }


    public StaffingContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(StaffingTable.COLUMN_ID);
        this._UID = jsonObject.getString(StaffingTable.COLUMN_UID);
        this._UUID = jsonObject.getString(StaffingTable.COLUMN_UUID);
        this.sysdate = jsonObject.getString(StaffingTable.COLUMN_SYSDATE);
        this.userName = jsonObject.getString(StaffingTable.COLUMN_USERNAME);
        this.serialno = jsonObject.getString(StaffingTable.COLUMN_SERIALNO);
        this.districtCode = jsonObject.getString(StaffingTable.COLUMN_DISTRICT_CODE);
        this.districtType = jsonObject.getString(StaffingTable.COLUMN_DISTRICT_TYPE);
        this.tehsilCode = jsonObject.getString(StaffingTable.COLUMN_TEHSIL_CODE);
        this.ucCode = jsonObject.getString(StaffingTable.COLUMN_UC_CODE);
        this.hfCode = jsonObject.getString(StaffingTable.COLUMN_HF_CODE);
        this.sC2 = jsonObject.getString(StaffingTable.COLUMN_SC2);
        this.deviceID = jsonObject.getString(StaffingTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(StaffingTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(StaffingTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(StaffingTable.COLUMN_SYNCED_DATE);
        this.status = jsonObject.getString(StaffingTable.COLUMN_STATUS);
        this.appversion = jsonObject.getString(StaffingTable.COLUMN_APPVERSION);

        return this;

    }


    public StaffingContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_UUID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_SYSDATE));
        this.userName = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_USERNAME));
        this.serialno = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_SERIALNO));
        this.districtCode = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_DISTRICT_CODE));
        this.districtType = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_DISTRICT_TYPE));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_TEHSIL_CODE));
        this.ucCode = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_UC_CODE));
        this.hfCode = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_HF_CODE));
        this.sC2 = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_SC2));
        this.deviceID = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_SYNCED_DATE));
        this.status = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_STATUS));
        this.appversion = cursor.getString(cursor.getColumnIndex(StaffingTable.COLUMN_APPVERSION));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(StaffingTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(StaffingTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(StaffingTable.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(StaffingTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(StaffingTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(StaffingTable.COLUMN_SERIALNO, this.serialno == null ? JSONObject.NULL : this.serialno);
        json.put(StaffingTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(StaffingTable.COLUMN_DISTRICT_TYPE, this.districtType == null ? JSONObject.NULL : this.districtType);
        json.put(StaffingTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(StaffingTable.COLUMN_UC_CODE, this.ucCode == null ? JSONObject.NULL : this.ucCode);
        json.put(StaffingTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);

        if (this.sC2 != null && !this.sC2.equals("")) {
            json.put(StaffingTable.COLUMN_SC2, new JSONObject(this.sC2));
        }

        json.put(StaffingTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(StaffingTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(StaffingTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(StaffingTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(StaffingTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
        json.put(StaffingTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }


    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }


    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }


    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }


    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }


    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }


    public String getDistrictType() {
        return districtType;
    }

    public void setDistrictType(String districtType) {
        this.districtType = districtType;
    }


    public String getTehsilCode() {
        return tehsilCode;
    }

    public void setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
    }


    public String getUcCode() {
        return ucCode;
    }

    public void setUcCode(String ucCode) {
        this.ucCode = ucCode;
    }


    public String getHfCode() {
        return hfCode;
    }

    public void setHfCode(String hfCode) {
        this.hfCode = hfCode;
    }


    public String getsC2() {
        return sC2;
    }

    public void setsC2(String sC2) {
        this.sC2 = sC2;
    }


    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }


    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }


    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }


    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static abstract class StaffingTable implements BaseColumns {

        public static final String TABLE_NAME = "staffing";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_USERNAME = "userName";
        public static final String COLUMN_SERIALNO = "serialno";
        public static final String COLUMN_DISTRICT_CODE = "districtCode";
        public static final String COLUMN_DISTRICT_TYPE = "districtType";
        public static final String COLUMN_TEHSIL_CODE = "tehsilCode";
        public static final String COLUMN_UC_CODE = "ucCode";
        public static final String COLUMN_HF_CODE = "hfCode";
        public static final String COLUMN_SC2 = "sC2";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";


        public static String _URL = "sync.php";
    }
}
