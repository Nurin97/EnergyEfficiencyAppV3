package com.example.energyefficiencyappv3;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartActivity extends AppCompatActivity {

    private List<String> xValues = new ArrayList<>();
    private ArrayList<BarEntry> entries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        BarChart barChart = findViewById(R.id.chart);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("energyUsage")) {
            double energyUsage = intent.getDoubleExtra("energyUsage", 0.0);

            entries.add(new BarEntry(0, (float) energyUsage));
        }

        setupChart();
        generateChartData(barChart);
    }

    private void setupChart() {
        BarChart barChart = findViewById(R.id.chart);

        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(60);
        barChart.setPinchZoom(false);
        barChart.setDrawGridBackground(true);

        Description description = new Description();
        description.setText("");
        barChart.setDescription(description);

        barChart.getAxisLeft().setEnabled(false);

        barChart.getAxisRight().setEnabled(true);
        barChart.getAxisRight().setAxisMinimum(0f);

        barChart.getXAxis().setEnabled(true);
        barChart.getXAxis().setGranularity(1f);
        barChart.getXAxis().setCenterAxisLabels(true);
        barChart.getXAxis().setDrawGridLines(false);
        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xValues));

        barChart.getLegend().setEnabled(false);
    }

    private void generateChartData(BarChart barChart) {
        BarDataSet dataSet = new BarDataSet(entries, "Energy Usage");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }
}

