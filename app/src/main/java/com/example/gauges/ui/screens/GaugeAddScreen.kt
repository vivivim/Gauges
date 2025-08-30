package com.example.gauges.ui.screens

import android.R.attr.label
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gauges.model.Gauge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GaugeAddScreen(
    onGaugeAdd: (Gauge) -> Unit
) {
    val (title: String, setTitle: (String) -> Unit) = remember { mutableStateOf("") }
    val (yarn: String, setYarn: (String) -> Unit) = remember { mutableStateOf("") }
    val (needle: String, setNeedle: (String) -> Unit) = remember { mutableStateOf("")}
    val ( rows: String, setRows: (String) -> Unit) = remember { mutableStateOf("") }
    val (stitches: String, setStitches: (String) -> Unit) = remember { mutableStateOf("") }
    val (width: String, setWidth: (String) -> Unit) = remember { mutableStateOf("") }
    val (length: String, setLength: (String) -> Unit) = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("스와치 추가하기 ^^") }
            )
        },
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TextField(
                value = title,
                onValueChange = setTitle,
                label = { Text("스와치 이름") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = yarn,
                onValueChange = setYarn,
                label = { Text("실 이름") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = needle,
                onValueChange = setNeedle,
                label = { Text("바늘 크기") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = stitches,
                onValueChange = setStitches,
                label = { Text("콧수") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = rows,
                onValueChange = setRows,
                label = { Text("단수") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = width,
                onValueChange = setWidth,
                label = { Text("가로 크기") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))

            TextField(
                value = length,
                onValueChange = setLength,
                label = { Text("세로 크기") },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}