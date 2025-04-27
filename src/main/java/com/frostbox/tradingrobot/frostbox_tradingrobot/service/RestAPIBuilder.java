package com.frostbox.tradingrobot.frostbox_tradingrobot.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestAPIBuilder {

    private String baseUrl;
    private final Map<String, String> headers = new HashMap<>();
    private final Map<String, String> urlParams = new HashMap<>();
    private final Map<String, String> bodyParams = new HashMap<>();


    public RestAPIBuilder setUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
        return this;
    }

    public RestAPIBuilder setHeaders(String key, String value)
    {
        headers.put(key,value);
        return this;
    }

    public RestAPIBuilder setUrlParams(String key, String value)
    {
        urlParams.put(key,value);
        return this;
    }

    public RestAPIBuilder setBodyParams(String key, String value)
    {
        bodyParams.put(key,value);
        return this;
    }


    public Object getMethod() {

        RestTemplate restTemplate = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(URI.create(baseUrl));

        for(Map.Entry<String, String> entry : urlParams.entrySet())
        {
            builder.queryParam(entry.getKey(), entry.getValue());
        }

        URI uri = builder.build().encode().toUri();

        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach(httpHeaders::set);

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
