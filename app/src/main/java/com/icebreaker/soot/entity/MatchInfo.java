package com.icebreaker.soot.entity;

public class MatchInfo {
    private String hostname;
    private String hostlogo;
    private String guestname;
    private String guestlogo;

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setHostlogo(String hostlogo) {
        this.hostlogo = hostlogo;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public void setGuestlogo(String guestlogo) {
        this.guestlogo = guestlogo;
    }

    public String getHostname() {
        return hostname;
    }

    public String getHostlogo() {
        return hostlogo;
    }

    public String getGuestname() {
        return guestname;
    }

    public String getGuestlogo() {
        return guestlogo;
    }

}
