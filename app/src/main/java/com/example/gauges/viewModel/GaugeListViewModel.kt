package com.example.gauges.viewModel

import androidx.lifecycle.ViewModel
import com.example.gauges.model.Gauge
import com.example.gauges.model.Type
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GaugeListViewModel : ViewModel() {
    private val _gaugeList = MutableStateFlow<List<Gauge>>(emptyList());
    val gaugeList: StateFlow<List<Gauge>> = _gaugeList

    init {
        _gaugeList.value = listOf(
            Gauge(id = "1", title = "제목.. 필요한가?", yarn = "솜솜뜨개 베이글 쉐도우", needle = 4.5,
                type = Type.STOCKING, stitches = 21.0, rows = 28.0),
            Gauge(id = "2", title = "내가 유저라면 제목을 쓰려나...쓸 듯? 2합", yarn = "낙양모사 아임울4", needle = 8.0,
                type = Type.STOCKING, stitches = 12.0, rows = 15.0),
            Gauge(id = "3", title = "올드스쿨 무늬 게이지", yarn = "솜솜뜨개 베이글 쉐도우", needle = 5.0,
                type = Type.PATTERN, width = 10.5, height = 8.5),
        )
    }

    fun getGaugeById(gaugeId: String): Gauge? {
        return _gaugeList.value.find { it.id == gaugeId }
    }

    fun addGauge(newGauge: Gauge) {
        _gaugeList.value += newGauge
    }
}