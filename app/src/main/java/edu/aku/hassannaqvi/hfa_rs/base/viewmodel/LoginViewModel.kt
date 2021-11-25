package edu.aku.hassannaqvi.hfa_rs.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.aku.hassannaqvi.hfa_rs.base.repository.ResponseStatusCallbacks
import edu.aku.hassannaqvi.hfa_rs.base.usecase.LoginUsecase
import edu.aku.hassannaqvi.hfa_rs.contracts.UsersContract
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUsecase: LoginUsecase) : ViewModel() {

    private val _loginResponse: MutableLiveData<ResponseStatusCallbacks<UsersContract>> =
        MutableLiveData()

    val loginResponse: MutableLiveData<ResponseStatusCallbacks<UsersContract>>
        get() = _loginResponse

    fun getLoginInfoFromDB(username: String, password: String) {
        _loginResponse.value = ResponseStatusCallbacks.loading(null)
        viewModelScope.launch {
            try {
                val loginData = loginUsecase(username, password)
                _loginResponse.value =
                    ResponseStatusCallbacks.success(data = loginData, "User exist")
            } catch (e: Exception) {
                _loginResponse.value = ResponseStatusCallbacks.error(null, e.message.toString())
            }
        }
    }

}