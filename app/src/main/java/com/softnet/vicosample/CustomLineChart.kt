package com.softnet.vicosample

import android.graphics.Typeface
import android.text.TextUtils
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.patrykandpatrick.vico.compose.axis.axisGuidelineComponent
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.axisLineComponent
import com.patrykandpatrick.vico.compose.axis.axisTickComponent
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.layout.fullWidth
import com.patrykandpatrick.vico.compose.chart.layout.segmented
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollState
import com.patrykandpatrick.vico.compose.component.shapeComponent
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.compose.style.currentChartStyle
import com.patrykandpatrick.vico.core.FADING_EDGE_VISIBILITY_THRESHOLD_DP
import com.patrykandpatrick.vico.core.FADING_EDGE_WIDTH_DP
import com.patrykandpatrick.vico.core.axis.Axis
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.axis.formatter.DecimalFormatAxisValueFormatter
import com.patrykandpatrick.vico.core.axis.vertical.VerticalAxis
import com.patrykandpatrick.vico.core.chart.decoration.ThresholdLine
import com.patrykandpatrick.vico.core.chart.edges.FadingEdges
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.chart.scale.AutoScaleUp
import com.patrykandpatrick.vico.core.component.marker.MarkerComponent
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.ShapeComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.shape.Shapes.rectShape
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.dimensions.emptyDimensions
import com.patrykandpatrick.vico.core.entry.ChartEntryModel
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryModelOf
import com.patrykandpatrick.vico.core.legend.LegendItem
import com.patrykandpatrick.vico.core.legend.VerticalLegend
import com.patrykandpatrick.vico.core.scroll.AutoScrollCondition
import com.patrykandpatrick.vico.core.scroll.InitialScroll
import com.softnet.vicosample.properties.bottomAxis
import com.softnet.vicosample.properties.customLineChart
import com.softnet.vicosample.properties.startAxis
import com.softnet.vicosample.ui.theme.VicoSampleTheme
import java.time.LocalDateTime


@Composable
fun CustomLineChart(
    modifier: Modifier = Modifier,
    dataSet: ChartEntryModel? = null,
    producer: ChartEntryModelProducer? = null,
) {

    if(dataSet != null) {
        Chart(
            modifier = modifier,
            chart = lineChart(
                lines = currentChartStyle.lineChart.lines,
                spacing = currentChartStyle.lineChart.spacing,
                decorations = null,
                persistentMarkers = null,
                axisValuesOverrider = null,
                targetVerticalAxisPosition = null,
            ),
            model = dataSet,
            startAxis = rememberStartAxis(
                label = axisLabelComponent(
                    color = Color.Red,
                    textSize = currentChartStyle.axis.axisLabelTextSize,
                    background = currentChartStyle.axis.axisLabelBackground,
                    ellipsize = TextUtils.TruncateAt.END,
                    lineCount = 9999,
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
                horizontalLabelPosition = VerticalAxis.HorizontalLabelPosition.Outside,
                verticalLabelPosition = VerticalAxis.VerticalLabelPosition.Center,
                itemPlacer = remember { AxisItemPlacer.Vertical.default() },
                labelRotationDegrees = 0f,
                titleComponent = null,
                title = "테스트 타이틀",
                valueFormatter = DecimalFormatAxisValueFormatter(),
            ),
            bottomAxis = bottomAxis(),
            marker = MarkerComponent(
                label = TextComponent.Builder().build(),
                indicator = LineComponent(
                    color = Color.Red.toArgb(),
                    thicknessDp = 2f,
                    shape = Shapes.pillShape,
                    dynamicShader = null,
                    margins = emptyDimensions(),
                    strokeWidthDp = 0f,
                    strokeColor= Color.Blue.toArgb(),
                ),
                guideline = LineComponent(
                    color = Color.Yellow.toArgb(),
                    thicknessDp = 2f,
                    shape = Shapes.pillShape,
                    dynamicShader = null,
                    margins = emptyDimensions(),
                    strokeWidthDp = 0f,
                    strokeColor= Color.Green.toArgb(),
                ),
            ),
            markerVisibilityChangeListener = null,
            legend = VerticalLegend(
                items = listOf<LegendItem>(
                    LegendItem(
                        icon = ShapeComponent(
                            shape = rectShape,
                            color = Color.Green.toArgb(),
                            dynamicShader = null,
                            margins = emptyDimensions(),
                            strokeWidthDp = 0f,
                            strokeColor = Color.Blue.toArgb(),
                        ),
                        label = TextComponent.Builder().build(),
                        labelText = "테스트 레전드",
                    )
                ),
                iconSizeDp = 0f,
                iconPaddingDp = 0f,
                spacingDp = 0f,
            ),
            chartScrollSpec = rememberChartScrollSpec(
                isScrollEnabled = true,
                initialScroll = InitialScroll.Start,
                autoScrollCondition = AutoScrollCondition.Never,
                autoScrollAnimationSpec = spring(),
            ),
            isZoomEnabled = true,
            oldModel = null,
            fadingEdges = FadingEdges(
                startEdgeWidthDp = FADING_EDGE_WIDTH_DP,
                endEdgeWidthDp = 10f,
                visibilityThresholdDp = FADING_EDGE_VISIBILITY_THRESHOLD_DP,
                visibilityInterpolator = AccelerateDecelerateInterpolator(),
            ),
            autoScaleUp= AutoScaleUp.None,
            chartScrollState = rememberChartScrollState(),
            horizontalLayout = HorizontalLayout.FullWidth(
                startPaddingDp = 1f,
                endPaddingDp = 1f,
            ),
            getXStep = { model -> 2f },
        )
    }
    else if(producer != null) {
        Chart(
            modifier = modifier,
            chart = customLineChart(),
            chartModelProducer = producer,
            startAxis = startAxis(),
            bottomAxis = bottomAxis(),
            runInitialAnimation = true,
            getXStep = { model -> 1f },
        )
    }
}

@Preview
@Composable
fun LineChartPreview() {
    val now = LocalDateTime.now()

    val list = listOf<Pair<LocalDateTime, Float>>(
        Pair(now, 10f),
        Pair(now.plusMinutes(1), 11f),
        Pair(now.plusMinutes(2), 12f),
        Pair(now.plusMinutes(3), 13f),
        Pair(now.plusMinutes(3), 100f),
    )

    val dataSet = entryModelOf(
        *list.map { it.second }.toTypedArray()
    )

    VicoSampleTheme {
        CustomLineChart(
            modifier = Modifier.fillMaxWidth(),
            dataSet = dataSet,
        )
    }
}
