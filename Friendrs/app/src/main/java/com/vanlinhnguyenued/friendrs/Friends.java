package com.vanlinhnguyenued.friendrs;

import java.io.Serializable;

public class Friends implements Serializable {
    private String nameFr, deception;
    private int avatarFr;

    public Friends(String nameFr, String deception, int avatarFr) {
        this.nameFr = nameFr;
        this.deception = deception;
        this.avatarFr = avatarFr;
    }

    public String getNameFr() {
        return nameFr;
    }

    public String getDeception() {
        return deception;
    }

    public int getAvatarFr() {
        return avatarFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public void setDeception(String deception) {
        this.deception = deception;
    }

    public void setAvatarFr(int avatarFr) {
        this.avatarFr = avatarFr;
    }
}
