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
fun SignUpScreen(
    onBack: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Criar Conta", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            value = username,
            onValueChange = { username = it },
            label = "Nome"
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email"
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = "CPF",
            isError = cpf.length < 11
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Senha"
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirmar Senha"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { }) {
            Text("Criar Conta")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}