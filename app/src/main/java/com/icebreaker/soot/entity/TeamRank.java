package com.icebreaker.soot.entity;

public class TeamRank
{


    private String clubName;

    private int matchesTotal;

    private int matchesWon;

    private int matchesDraw;
    private int matchesLost;

    private int goalsAgainst;
    private int points;
    private int rank;

    private int teamId;

    private String teamLogo;
    private boolean live;
    private int goalsPro;

    public void setClubname(String clubName) {
        this.clubName = clubName;
    }
    public String getClubname() {
        return clubName;
    }

    public void setMatchestotal(int matchesTotal) {
        this.matchesTotal = matchesTotal;
    }
    public int getMatchestotal() {
        return matchesTotal;
    }

    public void setMatcheswon(int matchesWon) {
        this.matchesWon = matchesWon;
    }
    public int getMatcheswon() {
        return matchesWon;
    }

    public void setMatchesdraw(int matchesDraw) {
        this.matchesDraw = matchesDraw;
    }
    public int getMatchesdraw() {
        return matchesDraw;
    }

    public void setMatcheslost(int matchesLost) {
        this.matchesLost = matchesLost;
    }
    public int getMatcheslost() {
        return matchesLost;
    }

    public void setGoalsagainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
    public int getGoalsagainst() {
        return goalsAgainst;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() {
        return points;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getRank() {
        return rank;
    }

    public void setTeamid(int teamId) {
        this.teamId = teamId;
    }
    public int getTeamid() {
        return teamId;
    }

    public void setTeamlogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }
    public String getTeamlogo() {
        return teamLogo;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
    public boolean getLive() {
        return live;
    }

    public void setGoalspro(int goalsPro) {
        this.goalsPro = goalsPro;
    }
    public int getGoalspro() {
        return goalsPro;
    }

}

