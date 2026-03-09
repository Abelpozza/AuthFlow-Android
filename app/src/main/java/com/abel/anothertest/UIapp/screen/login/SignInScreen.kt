package com.abel.anothertest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abel.anothertest.components.CustomTextField

@Composable
fun SignInScreen(
    onBack: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Login", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email ou Usuário"
        )

        Spacer(modifier = Modifier.height(10.dp))

       CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Senha",
           isPassword = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}