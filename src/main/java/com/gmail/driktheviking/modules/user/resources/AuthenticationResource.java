package com.gmail.driktheviking.modules.user.resources;

        import com.gmail.driktheviking.modules.user.representations.UserCredentialsRepresentation;
        import com.gmail.driktheviking.modules.user.representations.UserRepresentation;
        import com.gmail.driktheviking.modules.user.service.UserService;

        import javax.inject.Inject;
        import javax.validation.Valid;
        import javax.ws.rs.*;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import java.util.Arrays;
        import java.util.List;
        import java.util.stream.Collectors;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

    @Inject
    private UserService userService;

    /**
     * Tries to authenticate the given user.
     *
     * Possible return codes:
     *     - 200 OK: Authentication successful
     *     - 401 Unauthorized: Credentials invalid
     *     - 500 Internal Server Error: An internal error occurred
     */
    @POST
    @Path("authentication")
    public Response authenticateUser(@Valid UserCredentialsRepresentation userCredentials) {
        if ((userCredentials != null) && userService.checkCredentials(userCredentials.getUsername(), userCredentials.getPassword())) {
            return Response.ok().build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    /**
     * Returns all users.
     *
     * Possible return codes:
     *     - 200 OK: Returning users
     *     - 500 Internal Server Error: An internal error occurred
     */
    @GET
    public List<UserRepresentation> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Returns the user with the given username.
     *
     * Possible return codes:
     *     - 200 OK: Returning user
     *     - 404 Not Found: User does not exist
     *     - 500 Internal Server Error: An internal error occurred
     */
    @GET
    @Path("{username}")
    public Response getUserByUsername(@PathParam("username") String username) {
        UserRepresentation user = userService.getUserByUsername(username);

        return (user != null) ? Response.ok(user).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    /**
     * Returns the user with the given username.
     *
     * Possible return codes:
     *     - 200 OK: Returning list of users
     *     - 400 Bad Request: Hair color does not exist
     *     - 500 Internal Server Error: An internal error occurred
     */
    /*@GET
    @Path("haircolor/{hairColor}")
    public Response getUsersByHairColor(@PathParam("hairColor") String hairColor) {
        try {
            return Response.ok(userService.getUsersByHairColor(HairColor.valueOf(hairColor.toUpperCase()))).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Unknown hair color. Valid hair colors: " + Arrays.asList(HairColor.values()).stream().map(HairColor::toString).collect(Collectors.joining(", "))).build();
        }
    }*/
}
