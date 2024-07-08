package com.aalaa.tictactoegame


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aalaa.tictactoegame.ui.theme.Aqua
import com.aalaa.tictactoegame.ui.theme.GreenishYellow


@Composable
fun BoardBase() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp),
    ) {
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width / 3, y = 0f),
            end = Offset(x = size.width / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 2 / 3, y = 0f),
            end = Offset(x = size.width * 2 / 3, y = size.height)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height / 3),
            end = Offset(x = size.width, y = size.height / 3)
        )
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 2 / 3),
            end = Offset(x = size.width, y = size.height * 2 / 3)
        )
    }
}


@Composable
fun Circle() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color =Color(0xFF352264),
            style = Stroke(width = 30f)
        )
    }
}

@Composable
fun Cross() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawLine(
            color =Color(0xFFE01F9A),
            strokeWidth = 30f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
        drawLine(
            color =Color(0xFFE01F9A),
            strokeWidth = 30f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )
    }
}


@Composable
fun WinVerticalLine1() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 6, y = 0f),
            end = Offset(x = size.width * 1 / 6, y = size.height)
        )
    }
}


@Composable
fun WinVerticalLine2() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 2, y = 0f),
            end = Offset(x = size.width * 1 / 2, y = size.height)
        )
    }
}

@Composable
fun WinVerticalLine3() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 5 / 6, y = 0f),
            end = Offset(x = size.width * 5 / 6, y = size.height)
        )
    }
}

@Composable
fun WinHorizontalLine1() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 6),
            end = Offset(x = size.width, y = size.height * 1 / 6)
        )
    }
}

@Composable
fun WinHorizontalLine2() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 1 / 2),
            end = Offset(x = size.width, y = size.height * 1 / 2)
        )
    }
}

@Composable
fun WinHorizontalLine3() {
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height * 5 / 6),
            end = Offset(x = size.width, y = size.height * 5 / 6)
        )
    }
}


@Composable
fun WinDiagonalLine1() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height)
        )
    }
}

@Composable
fun WinDiagonalLine2() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color =Color(0xFF4C5523),
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = 0f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun Prevs() {
    BoardBase()
    Circle()
  //  Cross()
//    WinVerticalLine1()
//    WinVerticalLine2()
//    WinVerticalLine3()
//    WinHorizontalLine1()
//    WinHorizontalLine2()
//    WinHorizontalLine3()
//    WinDiagonalLine1()
//    WinDiagonalLine2()
}

