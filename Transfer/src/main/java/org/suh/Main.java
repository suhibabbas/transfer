package org.suh;

import com.jk.data.dataaccess.JKDataAccessFactory;
import com.jk.data.dataaccess.core.JKDataAccessService;
import com.jk.services.server.JKServiceConfig;
import com.jk.web.embedded.JKWebApplication;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("app")
public class Main extends JKServiceConfig {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        JKDataAccessService da = JKDataAccessFactory.getDataAccessService();
        if (!da.isTableExists("transfer")) {
            da.runScript("/script.sql");
        }

        JKWebApplication.run();
    }
}