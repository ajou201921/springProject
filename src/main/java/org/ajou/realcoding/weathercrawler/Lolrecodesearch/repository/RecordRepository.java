package org.ajou.realcoding.weathercrawler.Lolrecodesearch.repository;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentRecord;
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

    public void updateCurrentRecord(String summonerName, List<CurrentRecord> currentRecords){
        String summoner_name=currentRecords.get(0).getSummonerName();
        Query query1 = Query.query(Criteria.where("summonerName").is(summoner_name));

        if(mongoTemplate.findOne(query1,CurrentRecord.class,"currentRecord")!=null){
            Update update = new Update();

            for(int i=0; i<currentRecords.size(); i++){
                update.set("freshBlood",currentRecords.get(i).getFreshBlood());
                update.set("hotStreak",currentRecords.get(i).getHotStreak());
                update.set("inactive",currentRecords.get(i).getInactive());
                update.set("leagueId",currentRecords.get(i).getLeagueId());
                update.set("leaguePoints",currentRecords.get(i).getLeaguePoints());
                update.set("losses",currentRecords.get(i).getLosses());
                update.set("queueType",currentRecords.get(i).getQueueType());
                update.set("miniSeries",currentRecords.get(i).getMiniSeries());
                update.set("rank",currentRecords.get(i).getRank());
                update.set("summonerID",currentRecords.get(i).getSummonerId());
                update.set("summonerName",currentRecords.get(i).getSummonerName());
                update.set("tier",currentRecords.get(i).getTier());
                update.set("veteran",currentRecords.get(i).getVeteran());
                update.set("wins",currentRecords.get(i).getWins());
            }

            mongoTemplate.updateMulti(query1,update,"currentRecord");
        }
        else {
            mongoTemplate.insertAll(currentRecords);
        }
    }

}
