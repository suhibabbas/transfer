package com.app.transfer;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
//import org.primefaces.model.charts.line.LineChartModel;

import jakarta.annotation.PostConstruct;

public class LineChart{
	
	ServiceClient sClient = new ServiceClient();
	
	
	private LineChartModel lineModel;
	
	

	@PostConstruct
	public void init() {
        createLineModels();
	}
	
	public LineChartModel getLineModel() {
		return lineModel;
	}
	
	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();
		
		return model;
	}
	
	private LineChartModel initLineChart() {
		LineChartModel model = new LineChartModel();
		LineChartSeries series = new LineChartSeries();
		series.setLabel("amount");
		
		for (Model m : sClient.getAll()) {
			series.set(m.getId(), m.getAmount());
			
		}
		model.addSeries(series);

		return model;
	}

    private void createLineModels(){
        lineModel = initCategoryModel();
        lineModel.setTitle("Transfer");
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(500);

    }

}
