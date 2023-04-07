package com.app.transfer;

import com.jk.web.faces.controllers.JKWebController;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("controller")
@ViewScoped
public class Controller extends JKWebController {
    Model model;
    ServiceClient serviceClient = new ServiceClient();


    public boolean isAllowAdd(){
        return getModel().getId() == 0;
    }

    public String add(){
        serviceClient.insert(model);
        success("Added Successfully");
        return null;
    }


    public Model getModel(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
}
