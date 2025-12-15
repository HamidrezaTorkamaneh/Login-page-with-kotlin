package com.example.statecontant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationScreen(navController: NavController,username:String,family:String, ID:String) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Information Screen", fontSize = 30.sp) },
                navigationIcon ={
                    IconButton(onClick = {
                        navController.navigate("MainScreen")

                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack , contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White

                )
            )
        }
    ) {
        contentPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(username, fontSize = 40.sp)
            Spacer(Modifier.height(10.dp))
            Text(family, fontSize = 40.sp)
            Spacer(Modifier.height(10.dp))
            Text(ID, fontSize = 40.sp)
            Spacer(Modifier.height(10.dp))
            Button(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    navController.navigate("SuccessScreen"){
                        popUpTo("MainScreen"){
                            inclusive=true
                        }
                    }
                }) {
                Text("Verify Data", fontSize = 20.sp)
            }
        }
    }


}