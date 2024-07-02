package com.wemoonyx.donarapp.auth.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.wemoonyx.donarapp.R
import com.wemoonyx.donarapp.main.ui.navigation.ScreenRoutes
import com.wemoonyx.donarapp.ui.theme.BluePrimary
import com.wemoonyx.donarapp.ui.theme.BlueTertiary
import com.wemoonyx.donarapp.ui.theme.Gray10
import com.wemoonyx.donarapp.ui.theme.GrayPrimary
import com.wemoonyx.donarapp.ui.theme.GraySecondary
import com.wemoonyx.donarapp.ui.theme.GrayTertiary
import com.wemoonyx.donarapp.ui.theme.YellowPrimary
import com.wemoonyx.donarapp.ui.theme.interFontFamily

@Composable
fun LoginScreen(
    navController: NavHostController?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginHeader()
        LoginDivider()
        LoginForm {
            navController?.navigate(route = ScreenRoutes.MainNav.route)
        }
    }
}

@Composable
fun LoginHeader() {
    Image(painter = painterResource(id = R.drawable.ic_donar_app), contentDescription = "Logo")
    Text(
        text = "Bienvenido a DonarApp",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = BluePrimary,
        lineHeight = 29.sp,
        modifier = Modifier.padding(top = 16.dp)
    )
    Text(
        text = "Crea una cuenta o inicia sesión para convertirte \n" +
                "en un agente de cambio ",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayPrimary,
        textAlign = TextAlign.Center,
        lineHeight = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 8.dp)
    )
    LoginSocialButtons()
}

@Composable
fun LoginSocialButtons() {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(42.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_apple),
                contentDescription = "Apple logo"
            )
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .size(42.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = "Apple logo"
            )
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(42.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                contentDescription = "Apple logo"
            )
        }
    }
}

@Composable
fun LoginDivider() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            Modifier
                .height(1.dp)
                .weight(1f),
            color = Gray10
        )
        Text(
            text = "O si prefieres",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 14.sp,
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            color = GrayPrimary
        )
        Divider(
            Modifier
                .height(1.dp)
                .weight(1f),
            color = Gray10
        )
    }
}

@Composable
fun LoginForm(
    onLoginClick: () -> Unit
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LoginEmailInput(email) {
            email = it
        }
        LoginPasswordInput(password) {
            password = it
        }
        Text(
            text = "¿Olvidaste tu contraseña",
            fontFamily = interFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = GrayPrimary,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 12.dp)
        )
        Button(
            onClick = { onLoginClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = YellowPrimary,
                contentColor = GrayPrimary
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Continuar")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¿No tienes cuenta?",
                fontSize = 14.sp,
                color = GrayPrimary,
                fontFamily = interFontFamily
            )
            Text(
                text = "Crear cuenta",
                modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 14.sp,
                fontFamily = interFontFamily,
                color = BluePrimary,
            )
        }
    }
}

@Composable
fun LoginEmailInput(email: String, onTextChanged: (String) -> Unit) {
    var inputBorderWithValue by remember {
        mutableStateOf(GraySecondary)
    }
    var inputContainerWithValue by remember {
        mutableStateOf(Color(0xFFF0F2F5))
    }

    Text(
        text = "Correo electrónico",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayPrimary,
    )
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, inputBorderWithValue), // Change the color as needed
        color = inputContainerWithValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        TextField(
            value = email,
            onValueChange = {
                onTextChanged(it)
                if (it.isBlank()) {
                    inputBorderWithValue = GraySecondary
                    inputContainerWithValue = Color(0xFFF0F2F5)
                } else {
                    inputBorderWithValue = BluePrimary
                    inputContainerWithValue = BlueTertiary
                }
            },
            placeholder = { Text(text = "nombre@correo.com") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = GrayTertiary,
                unfocusedPlaceholderColor = GrayTertiary,
            )
        )
    }
}

@Composable
fun LoginPasswordInput(password: String, onTextChanged: (String) -> Unit) {
    var inputBorderWithValue by remember {
        mutableStateOf(GraySecondary)
    }
    var inputContainerWithValue by remember {
        mutableStateOf(Color(0xFFF0F2F5))
    }

    Text(
        text = "Contraseña",
        fontFamily = interFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = GrayPrimary,
        modifier = Modifier.padding(top = 16.dp)
    )
    Surface(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, inputBorderWithValue), // Change the color as needed
        color = inputContainerWithValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        TextField(
            value = password,
            onValueChange = {
                onTextChanged(it)
                if (it.isBlank()) {
                    inputBorderWithValue = GraySecondary
                    inputContainerWithValue = Color(0xFFF0F2F5)
                } else {
                    inputBorderWithValue = BluePrimary
                    inputContainerWithValue = BlueTertiary
                }
            },
            placeholder = { Text(text = "●●●●●●●●●") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = GrayTertiary,
                unfocusedPlaceholderColor = GrayTertiary,
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(null)
}