package com.golaso.api;

import com.golaso.dao.PlayerDao;
import com.golaso.dao.PlayerDaoImpl;
import com.golaso.modal.Player;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created by dheinisch on 12/8/17.
 */
@Path("/users")
public class PlayersAPI {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(String id) throws IOException {
        Player player = new Player(id);
        PlayerDao playerDao = new PlayerDaoImpl();
        playerDao.create(player);

        return Response.ok().entity(player).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("id") String id) {
        PlayerDao playerDao = new PlayerDaoImpl();
        return Response.ok().entity(playerDao.read(id)).build();
    }
}
