package edu.aku.hassannaqvi.hfa_rs.base.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.aku.hassannaqvi.hfa_rs.base.repository.GeneralRepository
import edu.aku.hassannaqvi.hfa_rs.base.usecase.LoginUsecase
import edu.aku.hassannaqvi.hfa_rs.base.viewmodel.LoginViewModel

/*
* @author Ali Azaz Alam dt. 01.07.21
* */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: GeneralRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(
                LoginUsecase(
                    repository
                )
            ) as T
            else -> throw IllegalArgumentException("Unknown viewModel class $modelClass")
        }
    }

}