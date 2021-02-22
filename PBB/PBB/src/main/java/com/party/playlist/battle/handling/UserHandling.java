package com.party.playlist.battle.handling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.party.playlist.battle.game.User;
import com.party.playlist.battle.resthttp.RequestContext;
import com.party.playlist.battle.resthttp.ResponseHandler;
import com.party.playlist.battle.operate.Users;
import com.party.playlist.battle.connections.Constants;

public class UserHandling {
    private final RequestContext context;
    private Users users;

    public UserHandling(RequestContext context) {
        this.context = context;
        this.users = new Users();
    }

    //Return status for User Login/Registering
    public String mapHttpMethods() throws JsonProcessingException {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().endsWith("/users/auth")) {
                final User authenticate = users.authenticate(context.getRequestBody());
                return ResponseHandler.response("User "+authenticate.getUsername()+" Login Successfully",
                        "200", "Success");
            }
            if(context.getPath().endsWith("/users")){
                final User user = users.registerUser(context.getRequestBody());
                return ResponseHandler.response("User created with username " + user.getUsername(),
                        "201", "Created");
            }

        }
        //Other errors
        return ResponseHandler.response("Resource not found",
                "404", "NotFound");
    }


}
