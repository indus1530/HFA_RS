package edu.aku.hassannaqvi.hfa_rs.contracts;

import static edu.aku.hassannaqvi.hfa_rs.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.uen_hfa_ml";
    public static final String PATH_FORMS = "Forms";
    public static String one = "1";
    public static String two = "2";
    public static String three = "3";
    public static String four = "4";
    public static String five = "5";
    public static String six = "6";
    public static String seven = "7";
    public static String eight = "8";
    public static String nine = "9";
    public static String ten = "10";
    public static String eleven = "11";
    public static String twelve = "12";
    public static String thirteen = "13";
    public static String fourteen = "14";
    public static String fifteen = "15";
    public static String sixteen = "16";
    public static String nSix = "96";
    public static String nSeven = "97";
    public static String nEight = "98";
    public static String nNine = "99";
    private final String projectName = "HFA_RapidSurvey";
    private final String synced_date02 = "";
    private final String synced03 = "";
    private String _ID = _EMPTY_;
    private String _UID = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysdate = _EMPTY_;
    private String istatus = _EMPTY_;
    private String istatus88x = _EMPTY_;
    private String endingdatetime = _EMPTY_;
    private String gpsLat = _EMPTY_;
    private String gpsLng = _EMPTY_;
    private String gpsDT = _EMPTY_;
    private String gpsAcc = _EMPTY_;
    private String deviceID = _EMPTY_;
    private String devicetagID = _EMPTY_;
    private String synced = _EMPTY_;
    private String synced_date = _EMPTY_;
    private String synced02 = _EMPTY_;
    private String synced_date03 = _EMPTY_;
    private String appversion = _EMPTY_;
    private String districtCode = _EMPTY_;
    private String districtType = _EMPTY_;
    private String tehsilCode = _EMPTY_;
    private String ucCode = _EMPTY_;
    private String hfCode = _EMPTY_;
    private String hfName = _EMPTY_;
    private String a01 = _EMPTY_;
    private String a03d = _EMPTY_;
    private String a03m = _EMPTY_;
    private String a03y = _EMPTY_;
    private String a07 = _EMPTY_;
    private String a08 = _EMPTY_;
    private String a09 = _EMPTY_;
    private String a10 = _EMPTY_;
    private String a11 = _EMPTY_;
    private String a12 = _EMPTY_;
    private String a13 = _EMPTY_;
    private String sB = _EMPTY_;
    private String sC = _EMPTY_;
    private String sD = _EMPTY_;
    private String sE = _EMPTY_;
    private String sF = _EMPTY_;
    private String sG = _EMPTY_;
    private String sH = _EMPTY_;
    private String sI = _EMPTY_;
    private String sJ = _EMPTY_;
    private String sK = _EMPTY_;


    public FormsContract() {
    }


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }


   /* public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.userName = jsonObject.getString(FormsTable.COLUMN_USERNAME);
        this.formdate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.districtCode = jsonObject.getString(FormsTable.COLUMN_DISTRICT_CODE);
        this.districtType = jsonObject.getString(FormsTable.COLUMN_DISTRICT_TYPE);
        this.tehsilCode = jsonObject.getString(FormsTable.COLUMN_TEHSIL_CODE);
        this.ucCode = jsonObject.getString(FormsTable.COLUMN_UC_CODE);
        this.hfCode = jsonObject.getString(FormsTable.COLUMN_HF_CODE);
        this.hfName = jsonObject.getString(FormsTable.COLUMN_HF_NAME);
        this.a01 = jsonObject.getString(FormsTable.COLUMN_A01);
        this.a03d = jsonObject.getString(FormsTable.COLUMN_A03D);
        this.a03m = jsonObject.getString(FormsTable.COLUMN_A03M);
        this.a03y = jsonObject.getString(FormsTable.COLUMN_A03Y);
        this.a07 = jsonObject.getString(FormsTable.COLUMN_A07);
        this.a08 = jsonObject.getString(FormsTable.COLUMN_A08);
        this.a09 = jsonObject.getString(FormsTable.COLUMN_A09);
        this.a10 = jsonObject.getString(FormsTable.COLUMN_A10);
        this.a11 = jsonObject.getString(FormsTable.COLUMN_A11);
        this.a12 = jsonObject.getString(FormsTable.COLUMN_A12);
        this.a13 = jsonObject.getString(FormsTable.COLUMN_A13);
        this.sB = jsonObject.getString(FormsTable.COLUMN_SB);
        this.sC = jsonObject.getString(FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sF = jsonObject.getString(FormsTable.COLUMN_SF);
        this.sG = jsonObject.getString(FormsTable.COLUMN_SG);
        this.sH = jsonObject.getString(FormsTable.COLUMN_SH);
        this.sI = jsonObject.getString(FormsTable.COLUMN_SI);
        this.sJ = jsonObject.getString(FormsTable.COLUMN_SJ);
        this.sK = jsonObject.getString(FormsTable.COLUMN_SK);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88x);


        return this;

    }*/


    public FormsContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_USERNAME));
        this.sysdate = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SYSDATE));
        this.districtCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DISTRICT_CODE));
        this.districtType = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DISTRICT_TYPE));
        this.tehsilCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_TEHSIL_CODE));
        this.ucCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_UC_CODE));
        this.hfCode = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_HF_CODE));
        this.hfName = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_HF_NAME));
        this.a01 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A01));
        this.a03d = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A03D));
        this.a03m = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A03M));
        this.a03y = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A03Y));
        this.a07 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A07));
        this.a08 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A08));
        this.a09 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A09));
        this.a10 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A10));
        this.a11 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A11));
        this.a12 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A12));
        this.a13 = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_A13));
        this.sB = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SJ));
        this.sK = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_SK));
        this.istatus = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ISTATUS88x));
        this.endingdatetime = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndexOrThrow(FormsTable.COLUMN_APPVERSION));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(FormsTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(FormsTable.COLUMN_DISTRICT_TYPE, this.districtType == null ? JSONObject.NULL : this.districtType);
        json.put(FormsTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(FormsTable.COLUMN_UC_CODE, this.ucCode == null ? JSONObject.NULL : this.ucCode);
        json.put(FormsTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);
        json.put(FormsTable.COLUMN_HF_NAME, this.hfName == null ? JSONObject.NULL : this.hfName);

        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        json.put(FormsTable.COLUMN_A01, this.a01 == null ? JSONObject.NULL : this.a01);
        json.put(FormsTable.COLUMN_A03D, this.a03d == null ? JSONObject.NULL : this.a03d);
        json.put(FormsTable.COLUMN_A03M, this.a03m == null ? JSONObject.NULL : this.a03m);
        json.put(FormsTable.COLUMN_A03Y, this.a03y == null ? JSONObject.NULL : this.a03y);
        json.put(FormsTable.COLUMN_A07, this.a07 == null ? JSONObject.NULL : this.a07);
        json.put(FormsTable.COLUMN_A08, this.a08 == null ? JSONObject.NULL : this.a08);
        json.put(FormsTable.COLUMN_A09, this.a09 == null ? JSONObject.NULL : this.a09);
        json.put(FormsTable.COLUMN_A10, this.a10 == null ? JSONObject.NULL : this.a10);
        json.put(FormsTable.COLUMN_A11, this.a11 == null ? JSONObject.NULL : this.a11);
        json.put(FormsTable.COLUMN_A12, this.a12 == null ? JSONObject.NULL : this.a12);
        json.put(FormsTable.COLUMN_A13, this.a13 == null ? JSONObject.NULL : this.a13);
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);

        if (this.sB != null && !this.sB.equals("")) {
            json.put(FormsTable.COLUMN_SB, new JSONObject(this.sB));
        }

        if (this.sC != null && !this.sC.equals("")) {
            json.put(FormsTable.COLUMN_SC, new JSONObject(this.sC));
        }

        if (this.sD != null && !this.sD.equals("")) {
            json.put(FormsTable.COLUMN_SD, new JSONObject(this.sD));
        }

        if (this.sE != null && !this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, new JSONObject(this.sE));
        }

        if (this.sF != null && !this.sF.equals("")) {
            json.put(FormsTable.COLUMN_SF, new JSONObject(this.sF));
        }


        return json;
    }

    public JSONObject toJSONObject02() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(FormsTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(FormsTable.COLUMN_DISTRICT_TYPE, this.districtType == null ? JSONObject.NULL : this.districtType);
        json.put(FormsTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(FormsTable.COLUMN_UC_CODE, this.ucCode == null ? JSONObject.NULL : this.ucCode);
        json.put(FormsTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);
        json.put(FormsTable.COLUMN_HF_NAME, this.hfName == null ? JSONObject.NULL : this.hfName);

        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);


        if (this.sG != null && !this.sG.equals("")) {
            json.put(FormsTable.COLUMN_SG, new JSONObject(this.sG));
        }

        if (this.sH != null && !this.sH.equals("")) {
            json.put(FormsTable.COLUMN_SH, new JSONObject(this.sH));
        }

        /*if (this.sI != null && !this.sI.equals("")) {
            json.put(FormsTable.COLUMN_SI, new JSONObject(this.sI));
        }*/
        json.put(FormsTable.COLUMN_SI, this.sI == null ? JSONObject.NULL : this.sI);

        if (this.sJ != null && !this.sJ.equals("")) {
            json.put(FormsTable.COLUMN_SJ, new JSONObject(this.sJ));
        }

        return json;
    }

    public JSONObject toJSONObject03() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
        json.put(FormsTable.COLUMN_SYSDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(FormsTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(FormsTable.COLUMN_DISTRICT_TYPE, this.districtType == null ? JSONObject.NULL : this.districtType);
        json.put(FormsTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(FormsTable.COLUMN_UC_CODE, this.ucCode == null ? JSONObject.NULL : this.ucCode);
        json.put(FormsTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);
        json.put(FormsTable.COLUMN_HF_NAME, this.hfName == null ? JSONObject.NULL : this.hfName);

        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        if (this.sK != null && !this.sK.equals("")) {
            json.put(FormsTable.COLUMN_SK, new JSONObject(this.sK));
        }

        return json;
    }


    public String getProjectName() {
        return projectName;
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


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getSysdate() {
        return sysdate;
    }

    public void setSysdate(String sysdate) {
        this.sysdate = sysdate;
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


    public String getHfName() {
        return hfName;
    }

    public void setHfName(String hfName) {
        this.hfName = hfName;
    }


    public String getA01() {
        return a01;
    }

    public void setA01(String a01) {
        this.a01 = a01;
    }


    public String getA03d() {
        return a03d;
    }

    public void setA03d(String a03d) {
        this.a03d = a03d;
    }


    public String getA03m() {
        return a03m;
    }

    public void setA03m(String a03m) {
        this.a03m = a03m;
    }


    public String getA03y() {
        return a03y;
    }

    public void setA03y(String a03y) {
        this.a03y = a03y;
    }


    public String getA07() {
        return a07;
    }

    public void setA07(String a07) {
        this.a07 = a07;
    }


    public String getA08() {
        return a08;
    }

    public void setA08(String a08) {
        this.a08 = a08;
    }


    public String getA09() {
        return a09;
    }

    public void setA09(String a09) {
        this.a09 = a09;
    }


    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }


    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }


    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }


    public String getA13() {
        return a13;
    }

    public void setA13(String a13) {
        this.a13 = a13;
    }


    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }


    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }


    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }


    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }


    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }


    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }


    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }


    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }


    public String getsK() {
        return sK;
    }

    public void setsK(String sK) {
        this.sK = sK;
    }


    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }


    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }


    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }


    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }


    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
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

    public String getSynced02() {
        return synced02;
    }

    public void setSynced02(String synced02) {
        this.synced02 = synced02;
    }

    public String getSynced_date03() {
        return synced_date03;
    }

    public void setSynced_date03(String synced_date03) {
        this.synced_date03 = synced_date03;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "Forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "userName";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_DISTRICT_CODE = "districtCode";
        public static final String COLUMN_DISTRICT_TYPE = "districtType";
        public static final String COLUMN_TEHSIL_CODE = "tehsilCode";
        public static final String COLUMN_UC_CODE = "ucCode";
        public static final String COLUMN_HF_CODE = "hfCode";
        public static final String COLUMN_HF_NAME = "hfName";
        public static final String COLUMN_A01 = "a01";
        public static final String COLUMN_A03D = "a03d";
        public static final String COLUMN_A03M = "a03m";
        public static final String COLUMN_A03Y = "a03y";
        public static final String COLUMN_A07 = "a07";
        public static final String COLUMN_A08 = "a08";
        public static final String COLUMN_A09 = "a09";
        public static final String COLUMN_A10 = "a10";
        public static final String COLUMN_A11 = "a11";
        public static final String COLUMN_A12 = "a12";
        public static final String COLUMN_A13 = "a13";
        public static final String COLUMN_SB = "sB";
        public static final String COLUMN_SC = "sC";
        public static final String COLUMN_SD = "sD";
        public static final String COLUMN_SE = "sE";
        public static final String COLUMN_SF = "sF";
        public static final String COLUMN_SG = "sG";
        public static final String COLUMN_SH = "sH";
        public static final String COLUMN_SI = "sI";
        public static final String COLUMN_SJ = "sJ";
        public static final String COLUMN_SK = "sK";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_SYNCED_02 = "synced_02";
        public static final String COLUMN_SYNCED_DATE_02 = "synced_date_02";
        public static final String COLUMN_SYNCED_03 = "synced_03";
        public static final String COLUMN_SYNCED_DATE_03 = "synced_date_03";
        public static final String COLUMN_APPVERSION = "appversion";

        public static String _URL = "sync.php";

    }
}
