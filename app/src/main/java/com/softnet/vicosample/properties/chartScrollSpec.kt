package com.softnet.vicosample.properties

import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.core.scroll.AutoScrollCondition
import com.patrykandpatrick.vico.core.scroll.InitialScroll


@Composable
fun chartScrollSpec() = rememberChartScrollSpec(
    isScrollEnabled = true,
    initialScroll = InitialScroll.Start,
    autoScrollCondition = AutoScrollCondition.Never,
    autoScrollAnimationSpec = spring(),
)