package com.example.elibrary.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elibrary.components.EmailInput
import com.example.elibrary.components.PasswordInput

@Composable
fun AppLoginScreen(navController: NavController) {
    val showLoginForm = rememberSaveable { mutableStateOf(true) }
    if (showLoginForm.value) UserForm(isCreateAccount = false)
    else UserForm(isCreateAccount = true)
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showLoginForm.value) UserForm(isCreateAccount = false)
            else UserForm(isCreateAccount = true)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val text = if (showLoginForm.value) "Sign up" else "Login"
            if(text=="Sign up") Text(text = "New User?")
            Text(text,
                modifier = Modifier
                    .clickable {
                        showLoginForm.value = !showLoginForm.value

                    }
                    .padding(start = 5.dp),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary)


        }




    }
}

@Preview(showBackground = true)
@Composable
fun UserFormPreview() {
    UserForm(
        isCreateAccount = false
    )
}

@Composable
fun UserForm(
    isCreateAccount: Boolean
) {
    val email = rememberSaveable { mutableStateOf("") }
    val password = rememberSaveable { mutableStateOf("") }
    val valid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
//                && email.value.contains("@")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column {
        EmailInput(
            value = email,
        )
        PasswordInput(
            value = password,
            onSubmit = { keyboardController?.hide() }
        )
        Submit(
            label = if (isCreateAccount) "Create Account" else "Login",
            loading = false,
            validInputs = valid,
            onClick = {
                keyboardController?.hide()
            }
        )
    }
}

@Composable
fun Submit(
    label: String,
    onClick: () -> Unit,
    loading: Boolean,
    validInputs: Boolean,


    ) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        enabled = !loading && validInputs,
        shape = CircleShape
    ) {
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        else Text(text = label, modifier = Modifier.padding(5.dp))
    }
}
