package org.ajou.realcoding.weathercrawler.Lolrecodesearch.repository;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentRecord;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertCurrentState(CurrentState currentState) { mongoTemplate.insert(currentState);}

    public void insertCurrentRecord(List<CurrentRecord> currentRecord) { mongoTemplate.insertAll(currentRecord); }




}
