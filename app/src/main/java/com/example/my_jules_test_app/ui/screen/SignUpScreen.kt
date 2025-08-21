package com.example.my_jules_test_app.ui.screen

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up", style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = null
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = emailError != null,
        )
        emailError?.let {
            Text(text = it, color = androidx.compose.material3.MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError != null,
        )
        passwordError?.let {
            Text(text = it, color = androidx.compose.material3.MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                confirmPasswordError = null
            },
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            isError = confirmPasswordError != null,
        )
        confirmPasswordError?.let {
            Text(text = it, color = androidx.compose.material3.MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (email.isEmpty()) {
                emailError = "Email cannot be empty"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailError = "Invalid email address"
            }
            if (password.isEmpty()) {
                passwordError = "Password cannot be empty"
            } else if (password.length < 6) {
                passwordError = "Password must be at least 6 characters long"
            }
            if (confirmPassword.isEmpty()) {
                confirmPasswordError = "Please confirm your password"
            } else if (password != confirmPassword) {
                confirmPasswordError = "Passwords do not match"
            }
        }) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { navController.navigate("signin") }) {
            Text(text = "Already have an account? Sign in")
        }
    }
}
