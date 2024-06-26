package com.example.calculatortask


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable

fun App() {
    var textInput by remember { mutableStateOf("") }
    var textResult by remember { mutableDoubleStateOf(0.0) }
    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFF316780))
    ) {
        Surface(
            onClick = { showDialog = true },
            modifier = Modifier.padding(14.dp).size(44.dp),
            color = Color(0xFF053D57)
        ) {
            Icon(
                painter = painterResource(id =R.drawable.sun),
                contentDescription = "Sun Icon",
                tint = Color.Black,
                modifier = Modifier.padding(10.dp).background(Color(0xFF053D57))
            )
        }

        Column(
            modifier = Modifier.padding(20.dp, top = 120.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            TextField(
                value = textInput,
                onValueChange = {
                    textInput = it
                },
                textStyle = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                ),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFF316780),
                    unfocusedIndicatorColor = Color(0xFF316780),
                    disabledIndicatorColor = Color(0xFF316780),
                    errorIndicatorColor = Color(0xFF316780),
                    focusedContainerColor = Color(0xFF316780),
                    unfocusedContainerColor = Color(0xFF316780),
                    disabledContainerColor = Color(0xFF316780),
                ),
            )

            Text(
                text = textResult.toString(),
                modifier = Modifier.padding(20.dp),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Surface(
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            modifier = Modifier.fillMaxWidth().height(450.dp).align(Alignment.BottomEnd),
            color = Color(0xFF053D57),
        ) {
            Column(
                modifier = Modifier.padding(20.dp, top = 30.dp, bottom = 30.dp, end = 20.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CalcButton({ textInput = "" }, "C", color = Color.Red)
                    CalcButton({ textInput += "÷" }, "÷", color = Color.Green)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CalcButton({ textInput += "7" }, "7")
                    CalcButton({ textInput += "8" }, "8")
                    CalcButton({ textInput += "9" }, "9")
                    CalcButton({ textInput += "*" }, "x", color = Color.Green)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CalcButton({ textInput += "4" }, "4")
                    CalcButton({ textInput += "5" }, "5")
                    CalcButton({ textInput += "6" }, "6")
                    CalcButton({ textInput += "-" }, "-", color = Color.Green)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CalcButton({ textInput += "1" }, "1")
                    CalcButton({ textInput += "2" }, "2")
                    CalcButton({ textInput += "3" }, "3")
                    CalcButton({ textInput += "+" }, "+", color = Color.Green)
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CalcButton({ textInput += "00" }, "00")
                    CalcButton({ textInput += "0" }, "0")
                    CalcButton({ textInput += "." }, ".")
                    CalcButton({ textResult += textInput.toInt() }, "=", color = Color.Green)

                    if (textInput.isEmpty()) textResult = 0.0

                    if (showDialog) {
                        AlertDialog(text = {
                            Text(
                                text = "Dark mode ^_^",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }, onDismissRequest = { showDialog = false }, confirmButton = {
                            Button(
                                onClick = { showDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF053D57),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "Save ")
                            }
                        }, dismissButton = {
                            TextButton(
                                onClick = { showDialog = false },
                            ) {
                                Text(text = "Cancel", color = Color(0xFF053D57))

                            }
                        }

                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CalcButton(onClick: () -> Unit, text: String, color: Color = Color.White) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier.size(80.dp).padding(6.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF053D57), contentColor = color
        )
    ) {
        Text(text, fontSize = 24.sp)
    }
}

