package org.suh.account;

import com.jk.data.dataaccess.JKDataAccessFactory;
import com.jk.data.dataaccess.orm.JKObjectDataAccess;
import com.jk.services.server.JKAbstractRestController;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Path("/transfer")
public class Controller extends JKAbstractRestController {

    JKObjectDataAccess access = JKDataAccessFactory.getObjectDataAccessService();

    @GET
    public Response getAll(){
        List<Transfer> list = access.getList(Transfer.class);
        return Response.status(200).entity(list).build();
    }

    @POST
    public Response insert(Transfer fromModel){
        access.insert(fromModel);
        return Response.status(201).entity(fromModel).build();
    }

}
