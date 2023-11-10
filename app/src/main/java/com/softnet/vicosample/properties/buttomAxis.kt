package com.softnet.vicosample.properties

import android.text.TextUtils
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.axisLineComponent
import com.patrykandpatrick.vico.compose.axis.axisTickComponent
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.style.currentChartStyle
import com.patrykandpatrick.vico.core.axis.Axis
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.axis.formatter.DecimalFormatAxisValueFormatter
import com.patrykandpatrick.vico.core.axis.vertical.VerticalAxis
import com.patrykandpatrick.vico.core.dimensions.emptyDimensions

@Composable
fun bottomAxis() = rememberBottomAxis(
    label = axisLabelComponent(
        color = Color.Red,
        textSize = currentChartStyle.axis.axisLabelTextSize,
        background = currentChartStyle.axis.axisLabelBackground,
        ellipsize = TextUtils.TruncateAt.END,
        lineCount = 50,
        verticalPadding = currentChartStyle.axis.axisLabelVerticalPadding,
        horizontalPadding = currentChartStyle.axis.axisLabelHorizontalPadding,
        verticalMargin = currentChartStyle.axis.axisLabelVerticalMargin,
        horizontalMargin = currentChartStyle.axis.axisLabelHorizontalMargin,
        typeface = currentChartStyle.axis.axisLabelTypeface,
        textAlignment= currentChartStyle.axis.axisLabelTextAlignment,
    ),
    axis = axisLineComponent(
        color = currentChartStyle.axis.axisLineColor,
        thickness = currentChartStyle.axis.axisLineWidth,
        shape = currentChartStyle.axis.axisLineShape,
        strokeWidth = 0.dp,
        strokeColor = Color.Transparent,
        dynamicShader = null,
        margins = emptyDimensions(),
    ),
    tick = axisTickComponent(
        color = currentChartStyle.axis.axisTickColor,
        thickness = 0.dp, //currentChartStyle.axis.axisTickWidth,
        shape = currentChartStyle.axis.axisTickShape,
        strokeWidth = 0.dp,
        strokeColor = Color.Transparent,
        dynamicShader = null,
    ),
    tickLength = 1.dp,
    guideline = axisGuidelineComponent(
        color = currentChartStyle.axis.axisGuidelineColor,
        thickness = currentChartStyle.axis.axisGuidelineWidth,
        shape = currentChartStyle.axis.axisGuidelineShape,
        strokeWidth = 0.dp,
        strokeColor = Color.Transparent,
        dynamicShader = null,
        margins = emptyDimensions()
    ),
    sizeConstraint = Axis.SizeConstraint.Auto(),
    itemPlacer = remember { AxisItemPlacer.Horizontal.default() },
    labelRotationDegrees = 0f,
    titleComponent = null,
    title = "테스트 타이틀",
    valueFormatter = DecimalFormatAxisValueFormatter(),
)