package edu.aku.hassannaqvi.hfa_rs.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class TehsilsContract {

    private static final String TAG = "Tehsils_CONTRACT";
    String tehsilCode;
    String tehsilName;
    String districtcode;

    public TehsilsContract() {
        // Default Constructor
    }

    public TehsilsContract Sync(JSONObject jsonObject) throws JSONException {
        this.tehsilCode = jsonObject.getString(singleTehsil.COLUMN_TEHSIL_CODE);
        this.tehsilName = jsonObject.getString(singleTehsil.COLUMN_TEHSIL_NAME);
        this.districtcode = jsonObject.getString(singleTehsil.COLUMN_DISTRICT_CODE);
        return this;
    }

    public TehsilsContract HydrateTehsils(Cursor cursor) {
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(singleTehsil.COLUMN_TEHSIL_CODE));
        this.tehsilName = cursor.getString(cursor.getColumnIndex(singleTehsil.COLUMN_TEHSIL_NAME));
        this.districtcode = cursor.getString(cursor.getColumnIndex(singleTehsil.COLUMN_DISTRICT_CODE));
        return this;
    }

    public String getTehsilCode() {
        return tehsilCode;
    }

    public void setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
    }

    public String getTehsilName() {
        return tehsilName;
    }

    public void setTehsilName(String tehsilName) {
        this.tehsilName = tehsilName;
    }

    public String getDistrictcode() {
        return districtcode;
    }

    public void setDistrictcode(String districtcode) {
        this.districtcode = districtcode;
    }


    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(singleTehsil.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(singleTehsil.COLUMN_TEHSIL_NAME, this.tehsilName == null ? JSONObject.NULL : this.tehsilName);
        json.put(singleTehsil.COLUMN_DISTRICT_CODE, this.districtcode == null ? JSONObject.NULL : this.districtcode);
        return json;
    }


    public static abstract class singleTehsil implements BaseColumns {

        public static final String TABLE_NAME = "tehsils";
        public static final String COLUMN_TEHSIL_CODE = "tehsil_code";
        public static final String COLUMN_TEHSIL_NAME = "tehsil_name";
        public static final String COLUMN_DISTRICT_CODE = "district_code";

        public static final String _URI = "tehsils.php";
    }
}