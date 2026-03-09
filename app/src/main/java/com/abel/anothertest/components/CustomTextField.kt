package com.abel.anothertest.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    isError: Boolean = false,
    icon: ImageVector? = null
) {

    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,

        label = { Text(label) },

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        isError = isError,

        leadingIcon = icon?.let {
            {
                Icon(
                    imageVector = it,
                    contentDescription = null
                )
            }
        },

        trailingIcon = {

            if (isPassword) {

                val iconImage =
                    if (passwordVisible)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                IconButton(
                    onClick = { passwordVisible = !passwordVisible }
                ) {

                    Icon(
                        imageVector = iconImage,
                        contentDescription = "Toggle password"
                    )
                }
            }
        },

        visualTransformation =
            if (isPassword && !passwordVisible)
                PasswordVisualTransformation()
            else
                VisualTransformation.None
    )
}