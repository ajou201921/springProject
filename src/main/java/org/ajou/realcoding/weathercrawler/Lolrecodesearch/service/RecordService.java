package org.ajou.realcoding.weathercrawler.Lolrecodesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.api.OpenLolApiClient;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentRecord;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentState;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class RecordService {

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    OpenLolApiClient openLolApiClient;
    @Autowired
    RecordRepository recordRepository;

    public List<CurrentRecord> realgetSummonerRecord(String id3) throws IOException {


        List<CurrentRecord> currentRecords = openLolApiClient.requestCurrentRecord(id3);

        recordRepository.updateCurrentRecord(id3,currentRecords);

        return  currentRecords;
    }

    public CurrentState realgetSummonerId(String id1) throws IOException {

        CurrentState currentState = openLolApiClient.requestCurrentState(id1);

        return currentState;
    }
}
