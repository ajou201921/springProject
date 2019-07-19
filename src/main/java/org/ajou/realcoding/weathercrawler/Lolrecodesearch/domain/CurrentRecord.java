package org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain;

import lombok.Data;

@Data
public class CurrentRecord {
    private String queueType;
    private String summonerName;
    private Boolean hotStreak;
    private MiniSeriesDTO miniSeries;
    private int wins;
    private Boolean veteran;
    private int losses;
    private String rank;
    private String leagueId;
    private Boolean inactive;
    private Boolean freshBlood;
    private String tier;
    private String summonerId;
    private int leaguePoints;

    @Data
    public static class MiniSeriesDTO {
        private String progress;
        private int losses;
        private int target;
        private int wins;

    }
}

