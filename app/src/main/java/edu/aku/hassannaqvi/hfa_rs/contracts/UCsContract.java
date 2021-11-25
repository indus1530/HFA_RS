package edu.aku.hassannaqvi.hfa_rs.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class UCsContract {

    private static final String TAG = "UCs_CONTRACT";
    String uc_code;
    String uc_name;
    String tehsil_code;

    public UCsContract() {
        // Default Constructor
    }

    public UCsContract Sync(JSONObject jsonObject) throws JSONException {
        this.uc_code = jsonObject.getString(singleUCs.COLUMN_UC_CODE);
        this.uc_name = jsonObject.getString(singleUCs.COLUMN_UC_NAME);
        this.tehsil_code = jsonObject.getString(singleUCs.COLUMN_TEHSIL_CODE);
        return this;
    }

    public UCsContract HydrateUCs(Cursor cursor) {
        this.uc_code = cursor.getString(cursor.getColumnIndex(singleUCs.COLUMN_UC_CODE));
        this.uc_name = cursor.getString(cursor.getColumnIndex(singleUCs.COLUMN_UC_NAME));
        this.tehsil_code = cursor.getString(cursor.getColumnIndex(singleUCs.COLUMN_TEHSIL_CODE));
        return this;
    }

    public String getUc_code() {
        return uc_code;
    }

    public void setUc_code(String uc_code) {
        this.uc_code = uc_code;
    }


    public String getUc_name() {
        return uc_name;
    }

    public void setUc_name(String uc_name) {
        this.uc_name = uc_name;
    }


    public String getTehsil_code() {
        return tehsil_code;
    }

    public void setTehsil_code(String tehsil_code) {
        this.tehsil_code = tehsil_code;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleUCs.COLUMN_UC_CODE, this.uc_code == null ? JSONObject.NULL : this.uc_code);
        json.put(singleUCs.COLUMN_UC_NAME, this.uc_name == null ? JSONObject.NULL : this.uc_name);
        json.put(singleUCs.COLUMN_TEHSIL_CODE, this.tehsil_code == null ? JSONObject.NULL : this.tehsil_code);
        return json;
    }


    public static abstract class singleUCs implements BaseColumns {
        public static final String _ID = "_id";
        public static final String TABLE_NAME = "ucs";
        public static final String COLUMN_UC_CODE = "uc_code";
        public static final String COLUMN_UC_NAME = "uc_name";
        public static final String COLUMN_TEHSIL_CODE = "tehsil_code";

        public static final String _URI = "ucs.php";
    }
}