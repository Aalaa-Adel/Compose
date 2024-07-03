package com.aalaa.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember { mutableStateOf(200.dp) }
            val size by animateDpAsState(
                targetValue = sizeState,
                tween(
                    durationMillis = 3000,
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing
                )
            )
//                spring(
//                    Spring.DampingRatioHighBouncy
//                )
//                keyframes {
//                    durationMillis = 5000
//                    sizeState at 0 with LinearEasing
//                    sizeState * 1.5f at 1000 with FastOutSlowInEasing
//                    sizeState * 2f at 5000
//                }
//            )
//            val infiniteSensitization = rememberInfiniteTransition(label = "")
            val color by rememberInfiniteTransition(label = "").animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(durationMillis = 2000),
                    repeatMode = RepeatMode.Reverse
                ), label = ""
            )
            Box(
                modifier = Modifier
                    .size(size)
                    .background(color),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text(text = "Increase Size")

                }

            }
//            Column(modifier = Modifier.fillMaxSize()) {
//                var isVisible by remember {
//                    mutableStateOf(false)
//                }
//                var isRound by remember {
//                    mutableStateOf(false)
//                }
//                Button(onClick = {
//                    isVisible = !isVisible
//                    isRound = !isRound
//                }) {
//                    Text(text = "Toggle")
//                }
//                val transient = updateTransition(
//                    targetState = isRound,
//                    label = null
//                )
//
//                val borderRadius by animateIntAsState(
//                    targetValue = if (isRound) 40 else 20,
//                    animationSpec = tween(
//                        durationMillis = 3000,
//                        delayMillis = 500,
//                    )
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioHighBouncy,
//                        stiffness = Spring.StiffnessVeryLow
//                    )
//                )
//                Box(
//                    modifier = Modifier
//                        .size(200.dp)
//                        .clip(RoundedCornerShape(borderRadius))
//                        .background(Color.Red)
//                )


//                AnimatedVisibility(
//                    visible = isVisible,
//                    enter = slideInHorizontally() + fadeIn(),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .weight(1f)
//                ) {
//                    Box(modifier = Modifier.background(Color.Red))
//                }
            //}
        }
    }
}

