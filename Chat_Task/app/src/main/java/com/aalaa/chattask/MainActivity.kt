package com.aalaa.chattask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppChat()
        }
    }
}

@Composable
fun AppChat() {
    val itemChat = remember {
        mutableStateListOf(
            "Hi, Dr.Randy  ^_^  !",
            "Good morning, how can I help you?",
            "Good morning doctor, I have a headache and body aches.",
            "Fine, how long has the complaint been?",
            "It's been about the last 3 days.",
            "Fine, I'll do a check. Does the patient have a history of certain diseases?",
        )
    }
    var textInput by remember { mutableStateOf("") }


    Box {

        LazyColumn(
            modifier = Modifier
                .background(Color(0xFFF1F1F1))
                .fillMaxSize()
                .padding(8.dp, bottom = 100.dp)
        ) {
            itemsIndexed(itemChat) { index, item ->
                val isEven = index % 2 == 0
                ChatItem(text = item, isEven = isEven)
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .height(100.dp), color = Color(0xFFF7F7F7)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    modifier = Modifier.weight(1f),
                    placeholder = {
                        Text("Type a message ...", color = Color.Gray)
                    },
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                    ),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        disabledIndicatorColor = Color.White,
                        errorIndicatorColor = Color.White,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                )
                Icon(modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterVertically)
                    .weight(0.25f)
                    .clickable {
                        if (textInput.isNotEmpty()) {
                            itemChat.add(textInput)
                            textInput = ""
                        }
                    }
                    .size(50.dp),
                    tint = Color(0xFF3680FF),
                    painter = painterResource(id = R.drawable.dm),
                    contentDescription = "Send")
            }
        }
    }
}


@Composable
fun ChatItem(text: String, isEven: Boolean) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = if (!isEven) {
            Arrangement.Start
        } else {
            Arrangement.End
        }
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(
                    color = if (!isEven) {
                        Color.White
                    } else {
                        Color(0xFF3680FF)

                    }, shape = if (!isEven) {
                        RoundedCornerShape(
                            topEnd = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp
                        )
                    } else {
                        RoundedCornerShape(
                            topStart = 20.dp, bottomEnd = 20.dp, bottomStart = 20.dp
                        )
                    }
                )
                .then(
                    if (text.length > 40) Modifier.width(270.dp)
                    else Modifier.wrapContentWidth()
                )
                .padding(10.dp)
        ) {
            Text(
                text = text,
                color = if (!isEven) Color.Black else Color.White,
                fontSize = 17.sp,
                lineHeight = 26.sp
            )
        }

    }
}