package com.example.gauges.ui.screens

import android.R.attr.text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.invalidateGroupsWithKey
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gauges.model.Gauge
import com.example.gauges.viewModel.GaugeListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaugeListScreen(
    navController: NavController,
    viewModel: GaugeListViewModel,
    onGaugeClicked: (String) -> Unit
) {
    val gaugeList: List<Gauge> by viewModel.gaugeList.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("나의 게이지") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("gaugeAdd")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "스와치 기록하기")
            }
        }
    ) { innerPadding ->
//        needle.toDouble()
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(gaugeList) { gauge ->
                Card (
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            onGaugeClicked(gauge.id)
                        }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp),
                    ) {
                        Text(gauge.title)
                        Spacer(Modifier.height(4.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(gauge.yarn,
                                fontSize = 12.sp
                            )
                            Text("/ ${gauge.needle} mm",
                                fontSize = 12.sp)
                        }
                    }
                }
            }
        }
    }
}