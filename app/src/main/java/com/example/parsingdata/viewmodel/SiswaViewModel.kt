package com.example.parsingdata.viewmodel

import androidx.lifecycle.ViewModel
import com.example.parsingdata.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SiswaViewModel : ViewModel (){
    private val _statusUI = MutableStateFlow(siswa())
            val statusUI: StateFlow<Siswa> = _statusUI.asStateFlow()


}