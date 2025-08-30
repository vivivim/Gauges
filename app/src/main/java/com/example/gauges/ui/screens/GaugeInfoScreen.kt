package com.example.gauges.ui.screens

import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gauges.model.Gauge
import com.example.gauges.model.Type

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaugeInfoScreen(
    gauge: Gauge,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(gauge.title) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "뒤로 가기")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(gauge.title)
            Spacer(Modifier.height(8.dp))

            Text("사용한 실: ${gauge.yarn}")
            Spacer(Modifier.height(8.dp))

            Text("사용한 바늘: ${gauge.needle}")
            Spacer(Modifier.height(8.dp))

            Text("뜨개 기법: ${gauge.type}")
            Spacer(Modifier.height(8.dp))

            if (gauge.type == Type.STOCKING) {
                Text("코: ${gauge.stitches}")
                Spacer(Modifier.height(8.dp))

                Text("단: ${gauge.rows}")
            } else if (gauge.type == Type.PATTERN) {
                Text("가로: ${gauge.width} cm")
                Spacer(Modifier.height(8.dp))

                Text("세로: ${gauge.height} cm")
            }

        }
    }
}