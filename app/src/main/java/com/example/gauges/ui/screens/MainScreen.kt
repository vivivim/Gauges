package com.example.gauges.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gauges.R

@Composable
fun MainScreen(
    navController: NavController
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp))
            Text(
                text = "스와치 저장소",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Spacer(Modifier.height(16.dp))
            Image(
//                painter = painterResource(id = R)
                painter = painterResource(id = R.drawable.moongchi),
                contentDescription = "앱 로고",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
            )
            Button(
                onClick = { navController.navigate("gaugeList") },
                colors = ButtonDefaults.buttonColors(Color(0xffffc0cb)),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
            ) {
                Text("입장하기")
            }
        }
    }
}