package com.example.parsingdata.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parsingdata.view.FormSiswa
import com.example.parsingdata.view.TampilSiswa
import com.example.parsingdata.viewmodel.SiswaViewModel


enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun SiswaApp(
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
){
    Scaffold { isiRuang ->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulirku.name){
                FormSiswa(
                    // pilihanJK = JenisK.map {id -> konteks.resources.getString(id)},
                    OnSubmitBtnClick={
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name){
                TampilSiswa { }(
                    onBackBtnClick = {cancelAndBackToFormulirku(navController)})
            }
        }
    }
}


private fun cancelAndBackToFormulirku(navController: NavController){
    navController.popBackStack(Navigasi.Formulirku.name, inclusive = false)
}