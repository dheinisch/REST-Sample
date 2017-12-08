package com.golaso.modal;

/**
 * Created by dheinisch on 12/8/17.
 */
public class Player {
    private String id;

    public Player(String id) {
        this.id = id;
    }

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Player{");
        sb.append("id='").append(id).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
