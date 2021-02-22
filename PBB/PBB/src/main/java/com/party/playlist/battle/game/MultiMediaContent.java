package com.party.playlist.battle.game;

import java.util.ArrayList;

public class MultiMediaContent {
    private String name ;
    private ArrayList<ContentAttributes> attributes;

    public MultiMediaContent(String name, ArrayList<ContentAttributes> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
}
