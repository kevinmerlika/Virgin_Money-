package com.example.virgin_money_app.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virgin_money_app.Model.PeopleItem
import com.example.virgin_money_app.Repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel
    @Inject
    constructor(private val repository: ApiRepository): ViewModel() {

        private val _response = MutableLiveData<List<PeopleItem>>()

    val responsePeople: MutableLiveData<List<PeopleItem>>
    get() = _response

    init {
        getAllPeople()
    }
    private fun getAllPeople() = viewModelScope.launch {
        repository.getAllPeople().let {
            response ->
            if(response.isSuccessful){
                _response.postValue(response.body())
                Log.d("TAG", "${response.body()}")
            }else{
                Log.d("TAG", "getAllPeople Error: ${response.errorBody()}")
            }
        }
    }

}
