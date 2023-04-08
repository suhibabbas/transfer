package com.app.transfer;

import com.jk.web.faces.controllers.JKWebController;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

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
}
