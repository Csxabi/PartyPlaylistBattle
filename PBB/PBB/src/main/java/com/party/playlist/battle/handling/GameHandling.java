package com.party.playlist.battle.handling;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.party.playlist.battle.game.BattleStatus;
import com.party.playlist.battle.resthttp.RequestContext;
import com.party.playlist.battle.connections.Constants;

public class GameHandling {
    private final RequestContext context;

    public GameHandling(RequestContext context) throws JsonProcessingException {
        this.context = context;
    }

    //Return status for Battle
    public String mapHttpMethods() throws JsonProcessingException {
        String method = this.context.getMethod();
        if (method.equals(Constants.POST)) {
            if (context.getPath().contains("game/user/battle/request")) {
                playTournament();
                return "";
            }
        } else if (method.equals(Constants.GET)) {
            return "";
        }
        return "";
    }

    //Tournament
    private BattleStatus playTournament() throws JsonProcessingException {
        JsonNode requestBody = context.getRequestBody();
        JsonNode actions = requestBody.get("actions");



        return BattleStatus.WIN;
    }
}
