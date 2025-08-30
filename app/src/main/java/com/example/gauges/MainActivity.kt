package com.example.gauges

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gauges.model.Gauge
import com.example.gauges.model.Type
import com.example.gauges.ui.screens.GaugeAddScreen
import com.example.gauges.ui.screens.GaugeInfoScreen
import com.example.gauges.ui.screens.GaugeListScreen
import com.example.gauges.ui.screens.MainScreen
import com.example.gauges.ui.theme.GaugesTheme
import com.example.gauges.viewModel.GaugeListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GaugesTheme {
                val navController = rememberNavController()
                val gaugeListViewModel = viewModel<GaugeListViewModel>()
                NavHost(
                    navController = navController,
                    startDestination = "main",
                ) {
                    composable("main") {
                        MainScreen(
                            navController = navController
                        )
                    }
                    composable("gaugeList") {
                        GaugeListScreen(
                            navController = navController,
                            viewModel = gaugeListViewModel,
                            onGaugeClicked = { gaugeId ->
                                navController.navigate("gauge/$gaugeId")
                            }
                        )
                    }
                    composable("gauge/{gaugeId}") { backStackEntry ->
                        val gaugeId = backStackEntry.arguments?.getString("gaugeId") ?: "1"
                        val gauge = gaugeListViewModel.getGaugeById(gaugeId)

                        if (gauge != null) {
                            GaugeInfoScreen(
                                gauge,
                                navController = navController,
                            )
                        } else {
                            val context = LocalContext.current
                            Toast.makeText(context, "존재하지 않는 정보입니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                    composable("gaugeAdd") {
                        GaugeAddScreen(
                            onGaugeAdd = { gauge ->
                                gaugeListViewModel.addGauge(gauge)
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}