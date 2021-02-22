package com.party.playlist.battle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.party.playlist.battle.handling.GameHandling;
import com.party.playlist.battle.handling.UserHandling;
import com.party.playlist.battle.resthttp.RequestContext;
import com.party.playlist.battle.resthttp.ResponseHandler;

public class DataHttp {
    private RequestContext context;

    DataHttp(RequestContext context) {
        this.context = context;

    }

    public String router() {
        try {
            if (context.getPath().contains("/users")) {
                return new UserHandling(context).mapHttpMethods();
            } else if (context.getPath().contains("/game")) {
                return new GameHandling(context).mapHttpMethods();
            }
        } catch (JsonProcessingException jsonProcessingException) {
            return ResponseHandler.response("Server error", "500", "Server error");
        }
        return ResponseHandler.response("Server error", "500", "Server error");
    }


}
