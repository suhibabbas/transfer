package com.app.transfer;

import com.jk.services.client.JKMatureServiceClient;

public class ServiceClient extends JKMatureServiceClient<Model> {

    @Override
    public String getServiceUrlPropertyName() {
        return "app.services.transfer.url";
    }
}
