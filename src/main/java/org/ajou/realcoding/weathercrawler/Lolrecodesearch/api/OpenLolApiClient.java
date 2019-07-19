package org.ajou.realcoding.weathercrawler.Lolrecodesearch.api;

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
    private final String api_key = "RGAPI-ed426b69-30d1-418c-b109-9fcca68ba053";
    private final String riotUrl1 = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonername}?api_key={api_key}";


    @Autowired
    RestTemplate restTemplate;

    public CurrentState requestCurrentState(String summonername){
        return restTemplate.exchange(riotUrl1, HttpMethod.GET,null, CurrentState.class, summonername , api_key).getBody();
    }

}
