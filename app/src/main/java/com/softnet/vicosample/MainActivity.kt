package com.softnet.vicosample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.softnet.vicosample.ui.theme.VicoSampleTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VicoSampleTheme {
                val now = LocalDateTime.now()

                val list = listOf<Pair<LocalDateTime, Float>>(
                    Pair(now, 10f),
                    Pair(now.plusMinutes(1), 11f),
                    Pair(now.plusMinutes(2), 12f),
                    Pair(now.plusMinutes(3), 13f),
                    Pair(now.plusMinutes(4), 100f),
                )

                val dataSet = entryModelOf(
                    *list.map { it.second }.toTypedArray()
                )

                Column(modifier = Modifier.fillMaxSize()) {
                    CustomLineChart(
                        dataSet = dataSet,
                    )
                }
            }
        }
    }
}