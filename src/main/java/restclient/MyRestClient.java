package restclient;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;

@Path("/extensions")
@RegisterRestClient
public interface MyRestClient {

    @GET
    Uni<Set<Extension>> extensions();

    @GET
    Set<Extension> extensions2();

    @GET
    Set<Extension> getById(@QueryParam String id);

    @GET
    Uni<Set<Extension>> getByIdAsUni(@QueryParam String id);
}
