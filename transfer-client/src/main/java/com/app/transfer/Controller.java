package com.app.transfer;

import com.jk.web.faces.controllers.JKWebController;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import java.util.List;
import java.util.Vector;

@Named("controller")
@ViewScoped
public class Controller extends JKWebController {
    Model model;
    List<Model> list;
    List<Model> filterLest;
    ServiceClient serviceClient = new ServiceClient();


    public boolean isAllowAdd(){
        return getModel().getId() == 0;
    }

    public String add(){
        serviceClient.insert(model);
        refresh();
        success("Added Successfully");
        return null;
    }
    public void setModel(Model model){
        this.model = model;
    }
    public Model getModel(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
    public List<Model>getList(){
        if(list == null){
            list = serviceClient.getAll();
        }
        return list;
    }
    public List<Model>getFilterLest(){
        return filterLest;
    }
    public void setFilterLest(Vector<Model> filterLest){
        this.filterLest = filterLest;
    }
    protected void refresh(){
        this.list = null;
        setModel(model);
    }

    ServiceClient sClient = new ServiceClient();


    private LineChartModel lineModel;



    @PostConstruct
    public void init() {
        createLineModels();
    }

    public LineChartModel getLineModel() {
        return lineModel;
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
        lineModel = initLineChart();
        lineModel.setTitle("Transfer");
        lineModel.setLegendPosition("e");
        Axis yAxis = lineModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(500);

    }
}
