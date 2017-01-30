package es.cifpcm.sakilarest.services.rest;

import es.cifpcm.sakilarest.data.Actor;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 2dawb
 */
@Path("actors")
public class ActorRest {

    private final Logger log = LoggerFactory.getLogger(ActorRest.class);

    private static final List<Actor> actorList;

    static {
        actorList = new ArrayList<>();
        actorList.add(new Actor("Pepe", "Perez"));
        actorList.add(new Actor("Juan", "García"));
    }

    public ActorRest() {

    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Actor> read() {
        log.debug("Petición al método read");

        return actorList;
    }

    @POST
    @Path("/add/{nombre}")
    public void addPersona(@FormParam("nombre") String nombre/*,
            @FormParam("apellidos") String apellidos*/) {

        Actor a = new Actor(nombre, null);
        actorList.add(a);
    }

    @GET
    @Path("{name}")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON})
    public Actor select(@PathParam("name") String name) {
        log.debug("Buscar actor por Nombre");

        Actor actor = null;
        for (Actor a : actorList) {
            if (name.equals(a.getFirstName())) {

                actor = a;
            }
        }

        return actor;
    }

    @GET
    @Path("/actors")
    @Produces({MediaType.APPLICATION_JSON})
    public Actor selectClasic(@QueryParam("name") String name) {
        log.debug("Buscar actor por Nombre");

        Actor actor = null;
        for (Actor a : actorList) {
            if (name.equals(a.getFirstName())) {

                actor = a;
            }
        }

        return actor;
    }

}
