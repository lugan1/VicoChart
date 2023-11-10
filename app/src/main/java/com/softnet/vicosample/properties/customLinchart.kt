package com.softnet.vicosample.properties

import androidx.compose.runtime.Composable
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.style.currentChartStyle

@Composable
fun customLineChart() = lineChart(
    lines = currentChartStyle.lineChart.lines,
    spacing = currentChartStyle.lineChart.spacing,
    decorations = null,
    persistentMarkers = null,
    axisValuesOverrider = null,
    targetVerticalAxisPosition = null,
)