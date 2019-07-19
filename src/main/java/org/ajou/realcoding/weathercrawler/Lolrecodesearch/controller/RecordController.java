package org.ajou.realcoding.weathercrawler.Lolrecodesearch.controller;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentRecord;
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

    @GetMapping("/lol/use_by_summoner_name/{summonerName}")
    public List<CurrentRecord> get_real_League_State(@PathVariable String summonerName) throws IOException{
        String realencryptedSummonerid = recordService.realgetSummonerId(summonerName).getId();
        return recordService.realgetSummonerRecord(realencryptedSummonerid);
    }
}
