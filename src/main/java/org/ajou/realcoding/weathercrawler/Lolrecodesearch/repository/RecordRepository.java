package org.ajou.realcoding.weathercrawler.Lolrecodesearch.repository;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insertCurrentState(CurrentState currentState) { mongoTemplate.insert(currentState);}




    public void updateCurrentRecord(String summonerName, List<CurrentState> currentRecords){
        Criteria criteria = new Criteria("summonerName");
        criteria.is(summonerName);

        Query query = new Query(criteria);

        Update update = new Update();


    }

}