package edu.aku.hassannaqvi.hfa_rs

class CONSTANTS {
    companion object {
        //For Login
        const val MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0
        const val MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 2
        const val TWO_MINUTES = 1000 * 60 * 2
        const val MINIMUM_DISTANCE_CHANGE_FOR_UPDATES: Long = 1 // in Meters
        const val MINIMUM_TIME_BETWEEN_UPDATES: Long = 1000 // in Milliseconds


        const val MEMBER_ITEM = 101
        const val SERIAL_EXTRA = "key"
        const val MINYEAR = 1940
        const val MAXYEAR = 2020

        //For J Section
        const val MINYEAR_IM = 2015
        const val SEC_J_FLAG = "jFlag"

        //For E4 Section
        const val MORTALITY_INFO = 2017
        const val MWRA_INFO = "mwra"
        const val SYNC_LOGIN = "sync_login"

        //For CHC Section
        const val IM02FLAG = "im02_flag"

        //For C2
        const val TRAINED_STAFF_SERIAL = "trained_staff_serial"

        //For I
        const val SECTION_MAIN_CHECK_FOR_END = "section_main_check"


        //Login Result Code
        const val LOGIN_RESULT_CODE = 10101
        const val LOGIN_SPLASH_FLAG = "splash_flag"
    }
}