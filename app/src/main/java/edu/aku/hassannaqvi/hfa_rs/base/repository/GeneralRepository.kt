package edu.aku.hassannaqvi.hfa_rs.base.repository

import edu.aku.hassannaqvi.hfa_rs.contracts.UsersContract
import edu.aku.hassannaqvi.hfa_rs.core.DatabaseHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class GeneralRepository(private val db: DatabaseHelper) : GeneralDataSource {

    override suspend fun getLoginInformation(username: String, password: String): UsersContract =
        withContext(Dispatchers.IO) {
            db.getLoginUser(username, password)
        }

}