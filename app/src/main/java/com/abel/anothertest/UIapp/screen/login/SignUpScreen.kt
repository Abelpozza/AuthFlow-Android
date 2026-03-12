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
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import kotlinx.coroutines.launch
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun SignUpScreen(
    onBack: () -> Unit,
    onSignUpSuccess: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val db = FirebaseFirestore.getInstance()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold (
        snackbarHost = {SnackbarHost(snackbarHostState)}
    ) { paddingValues ->

        Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Criar Conta", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            value = username,
            onValueChange = { username = it },
            label = "Nome",
            icon = Icons.Default.Person
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            icon = Icons.Default.Email

        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = "CPF",
            isError = cpf.length < 11,
            icon = Icons.Default.AccountBox
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Senha",
            isPassword = true,
            icon = Icons.Default.Lock
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Confirmar Senha",
            isPassword = true,
            icon = Icons.Default.Lock
        )

        Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                data class User(
                    val uid: String = "",
                    val nome: String = "",
                    val email: String = "",
                    val cpf: String = ""
                )

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->

                        if (task.isSuccessful) {

                            val uid = auth.currentUser?.uid

                            val user = User(
                                uid = uid!!,
                                nome = username,
                                email = email,
                                cpf = cpf
                            )

                            db.collection("users")
                                .document(uid)
                                .set(user)

                            onSignUpSuccess()

                        } else {

                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    task.exception?.message ?: "Erro ao criar conta"
                                )
                            }

                        }
                    }

            }) {
                Text("Criar Conta")
            }

        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = onBack) {
            Text("Voltar")
        }
    }
}