package haw.bmaajp.groceriesapp

import android.graphics.drawable.shapes.OvalShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginScreen(){

    Column (
        modifier = Modifier
            .background(Color.Green)
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text("Login",
            color = Color.White,
            fontFamily = FontFamily.Serif,
            fontSize = 50.sp,
            fontWeight = FontWeight(20)
        )

        var usernamee by remember { mutableStateOf(TextFieldValue("") )}
        var email by remember { mutableStateOf(TextFieldValue("") )}
        var password by remember { mutableStateOf(TextFieldValue("") )}


        OutlinedTextField(
            value = usernamee,
            label = {Text("USERNAME", color = Color.White)},
            leadingIcon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Text),
            onValueChange = {
                usernamee = it
            }
        )

        Spacer(modifier = Modifier.height(15.dp))


        OutlinedTextField(
            value = email,
            label = { Text(text = "EMAIL", color = Color.White)},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Email),
            onValueChange = {
                email = it
            }
        )

        Spacer(modifier = Modifier.height(15.dp))


        OutlinedTextField(
            value = password,
            label = { Text(text = "PASSWORD", color = Color.White)},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType =  KeyboardType.Password),
            onValueChange = {
                password = it
            }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Login")

        }







    }

}



