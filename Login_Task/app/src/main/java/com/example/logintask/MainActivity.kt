package com.example.logintask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 40.dp)
                ) {
                    Text(

                        text = "Welcome Back",
                        color = Color(0xFF3680FF),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 20.dp),
                        text = "We're excited to have you back, can't wait to see what" +
                                " you've been up to since you last logged in.",
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        color = Color.Gray
                    )
                    TextField(
                        "Email", "Enter your email"
                    )
                    TextField(
                        "Password", "Enter your password"
                    )


                    var checkedState by remember { mutableStateOf(false) }
                    Row(
                        modifier = Modifier
                            .padding(top = 25.dp)
                    ) {
                        Checkbox(
                            checked = checkedState,
                            onCheckedChange = { checkedState = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFF3680FF),
                                uncheckedColor = Color.Gray,
                            )
                        )
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            text = "Remember me",
                            color = Color.Gray
                        )

                        Text(
                            modifier = Modifier
                                .clickable {}
                                .align(Alignment.CenterVertically),
                            text = "Forgot Password?",
                            color = Color(0xFF3680FF)
                        )
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF3680FF),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(top = 30.dp, bottom = 40.dp)
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        Text("Login")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(Color.Gray)
                        )
                        Text(
                            text = "Or sign in with",
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(horizontal = 5.dp),
                            fontSize = 14.sp,
                        )
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(Color.Gray)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .weight(0.5f)
                                .size(50.dp)
                                .clickable {}
                        )
                        Image(
                            painter = painterResource(id = R.drawable.facebook),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .size(50.dp)
                                .clickable {}
                        )
                        Image(
                            painter = painterResource(id = R.drawable.apple),
                            contentDescription = "My Image",
                            modifier = Modifier
                                .weight(0.5f)
                                .size(50.dp)
                                .clickable {}
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(bottom = 30.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("By logging, you agree to our ")
                            }
                            append("Terms & Conditions ")
                            withStyle(style = SpanStyle(color = Color.Gray)) {
                                append("and")
                            }
                            append(" PrivacyPolicy .")
                        },
                        textAlign = TextAlign.Center
                    )
                    val annotatedString = buildAnnotatedString {
                        append("Already have an account yet? ")
                        withStyle(style = SpanStyle(color = Color(0xFF3680FF))) {
                            append("Sign Up")
                        }
                    }
                    Text(
                        text = annotatedString,
                        modifier = Modifier
                            .padding(top = 30.dp)
                    )

//                      Text(
//                          text = "Sign Up",
//                          color = Color(0xFF3680FF),
//                          modifier = Modifier.clickable{}
//                      )

                }
            }
        }
    }
}

@Composable
fun TextField(labelName: String = "", holderName: String = "") {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    return OutlinedTextField(
        shape = RoundedCornerShape(12.dp),
        value = text,
        label = { Text(text = labelName, color = Color.Gray) },
        placeholder = { Text(text = holderName, color = Color.Gray) },
        onValueChange = { text = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    )
}
