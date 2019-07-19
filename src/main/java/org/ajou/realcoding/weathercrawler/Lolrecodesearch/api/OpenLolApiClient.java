package org.ajou.realcoding.weathercrawler.Lolrecodesearch.api;

import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentRecord;
import org.ajou.realcoding.weathercrawler.Lolrecodesearch.domain.CurrentState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OpenLolApiClient {
    private final String api_key = "RGAPI-2d8c93b3-ef13-4667-9eb9-86313fac9272";
    private final String riotUrl1 = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonername}?api_key={api_key}";
    private final String riotUrl2 = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/{encryptedSummonerId}?api_key={api_key}";

    @Autowired
    RestTemplate restTemplate;

    public CurrentState requestCurrentState(String summonername){
        return restTemplate.exchange(riotUrl1, HttpMethod.GET,null, CurrentState.class, summonername , api_key).getBody();
    }

    public List<CurrentRecord> requestCurrentRecord(String encryptedSummonerId){
        ResponseEntity<List<CurrentRecord>> response = restTemplate.exchange(riotUrl2,HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrentRecord>>() {}, encryptedSummonerId ,api_key );
        List<CurrentRecord> list = response.getBody();
        return list;

    }
}
