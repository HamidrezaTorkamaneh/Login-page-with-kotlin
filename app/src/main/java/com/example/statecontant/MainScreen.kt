package com.example.statecontant

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var family by remember { mutableStateOf("") }
    var ID by remember { mutableStateOf("") }


    Scaffold(
        topBar = {

            CenterAlignedTopAppBar(
                title = {Text("Registration Screen", fontSize = 30.sp)},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
                )

        }
    ) {contentPadding ->
        Column(
            modifier = modifier
                .padding(contentPadding)
                .padding(30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
               modifier =  Modifier.fillMaxWidth(),
                value = username,
                onValueChange = { username = it },
                label = { Text("username") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier =  Modifier.fillMaxWidth(),
                value = family,
                onValueChange = { family = it },
                label = { Text("username") }
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                modifier =  Modifier.fillMaxWidth(),
                value = ID,
                onValueChange = { ID = it },
                label = { Text("username") }
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier= Modifier.fillMaxWidth().height(50.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    navController.navigate("InformationScreen/${username}/${family}/${ID}")
                }) {
                Text("Register", fontSize = 20.sp)
            }

        }
    }

}