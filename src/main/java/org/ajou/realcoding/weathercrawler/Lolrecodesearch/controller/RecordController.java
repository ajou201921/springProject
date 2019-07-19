package org.ajou.realcoding.weathercrawler.Lolrecodesearch.controller;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentState;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RecordController {

    @Autowired
    RecordService recordService;

    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    public CurrentState getCurrentState (@PathVariable String summonerName) throws IOException {
        return recordService.getSummonerId(summonerName);
    }


}
