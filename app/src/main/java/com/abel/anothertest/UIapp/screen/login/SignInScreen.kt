package com.abel.anothertest.UIapp.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@Composable
fun SignInScreen(
    onBack: () -> Unit
){

    var email by remember {mutableStateOf("") }
    var password by remember {mutableStateOf("") }

Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text("Login", fontSize = 24.sp)

    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") }
    )
    Spacer(modifier = Modifier.height(10.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Senha") }
    )

    Spacer(modifier = Modifier.height(20.dp))

    Button(onClick = {}) {
        Text("Entrar")
    }

    Spacer(modifier = Modifier.height(10.dp))

    Button(onClick = onBack) {
        Text("Voltar")
        }
    }
}