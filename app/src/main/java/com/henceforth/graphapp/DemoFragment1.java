package com.henceforth.graphapp;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class DemoFragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_raise_request, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }


    private void init() {
        GraphView graph = (GraphView) getView().findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 0),
                new DataPoint(2, 0),
                new DataPoint(4, 2),
                new DataPoint(6, 4),
                new DataPoint(8, 6),
                new DataPoint(10, 8),
                new DataPoint(12, 10),
                new DataPoint(14, 12),
                new DataPoint(16, 12),
                new DataPoint(18, 16),

        });
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 1));
        series.setCustomPaint(paint);
        series.setThickness(20);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(20);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);

        staticLabelsFormatter.setHorizontalLabels(new String[]{"", 10 + "-20", 20 + "-30", 30 + "-40", 40 + "-50"});
        staticLabelsFormatter.setVerticalLabels(new String[]{0 + "", 1 + "k", 2 + "k", 3 + "k", 4 + "k"});
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
        graph.addSeries(series);
//        graph.getViewport().setMinX(0);
//        graph.getViewport().setMaxX(5);
//        graph.getViewport().setMinY(0);
//        graph.getViewport().setMaxY(10);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getGridLabelRenderer().setNumHorizontalLabels(12);
        graph.getViewport().setScrollable(true);
    }
}
