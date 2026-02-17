package com.example.frcscoutingapp2022;

import android.app.Application;

public class GlobalVariables extends Application {

    private static String teamNum;
    private static String matchNum;
    private static String TournamentNum;

    // Standard Getters
    public static String getTeamNum() { return teamNum; }
    public static String getMatchNum() { return matchNum; }
    public static String getTournamentNum() {
        return TournamentNum;
    }

    // Standard Setters
    public static void setTeamNum(String tn) { teamNum = tn; }
    public static void setMatchNum(String mn) { matchNum = mn; }
    public static void setTournamentNum(String tn) { TournamentNum = tn; }
}