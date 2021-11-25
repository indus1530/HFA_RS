package edu.aku.hassannaqvi.hfa_rs.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class HFContract {

    private static final String TAG = "HF_CONTRACT";
    String tehsil_code;
    String hf_type;
    String hf_name;
    String hf_code;

    public HFContract() {
        // Default Constructor
    }

    public HFContract Sync(JSONObject jsonObject) throws JSONException {
        this.tehsil_code = jsonObject.getString(singleHF.COLUMN_TEHSIL_CODE);
        this.hf_type = jsonObject.getString(singleHF.COLUMN_HF_TYPE);
        this.hf_name = jsonObject.getString(singleHF.COLUMN_HF_NAME);
        this.hf_code = jsonObject.getString(singleHF.COLUMN_HF_CODE);
        return this;
    }

    public HFContract HydrateHF(Cursor cursor) {
        this.tehsil_code = cursor.getString(cursor.getColumnIndex(singleHF.COLUMN_TEHSIL_CODE));
        this.hf_type = cursor.getString(cursor.getColumnIndex(singleHF.COLUMN_HF_TYPE));
        this.hf_name = cursor.getString(cursor.getColumnIndex(singleHF.COLUMN_HF_NAME));
        this.hf_code = cursor.getString(cursor.getColumnIndex(singleHF.COLUMN_HF_CODE));
        return this;
    }

    public String getTehsil_code() {
        return tehsil_code;
    }

    public void setTehsil_code(String tehsil_code) {
        this.tehsil_code = tehsil_code;
    }


    public String getHf_type() {
        return hf_type;
    }

    public void setHf_type(String hf_type) {
        this.hf_type = hf_type;
    }


    public String getHf_name() {
        return hf_name;
    }

    public void setHf_name(String hf_name) {
        this.hf_name = hf_name;
    }


    public String getHf_code() {
        return hf_code;
    }

    public void setHf_code(String hf_code) {
        this.hf_code = hf_code;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleHF.COLUMN_TEHSIL_CODE, this.tehsil_code == null ? JSONObject.NULL : this.tehsil_code);
        json.put(singleHF.COLUMN_HF_TYPE, this.hf_type == null ? JSONObject.NULL : this.hf_type);
        json.put(singleHF.COLUMN_HF_NAME, this.hf_name == null ? JSONObject.NULL : this.hf_name);
        json.put(singleHF.COLUMN_HF_CODE, this.hf_code == null ? JSONObject.NULL : this.hf_code);
        return json;
    }


    public static abstract class singleHF implements BaseColumns {
        public static final String _ID = "_id";
        public static final String TABLE_NAME = "healthfacilities";
        public static final String COLUMN_TEHSIL_CODE = "tehsil_code";
        public static final String COLUMN_HF_TYPE = "hf_type";
        public static final String COLUMN_HF_NAME = "hf_name";
        public static final String COLUMN_HF_CODE = "hf_uen_code";

        public static final String _URI = "healthfacilities.php";
    }
}