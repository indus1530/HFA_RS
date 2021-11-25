package edu.aku.hassannaqvi.hfa_rs.base.repository

import edu.aku.hassannaqvi.hfa_rs.contracts.UsersContract

interface GeneralDataSource {

    //For login Start
    suspend fun getLoginInformation(username: String, password: String): UsersContract
    //For login End

}