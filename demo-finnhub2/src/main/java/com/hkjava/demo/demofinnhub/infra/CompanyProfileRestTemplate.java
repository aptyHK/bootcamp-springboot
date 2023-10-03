package com.hkjava.demo.demofinnhub.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hkjava.demo.demofinnhub.model.CompanyProfile;

// @Service // Bean
public class CompanyProfileRestTemplate { // Service

    // @Autowired // Bean
    RestTemplate restTemplate;

    static final String url = "xxxx";

    public CompanyProfileRestTemplate(RestTemplate restTemplate) {
        if (restTemplate == null)
            throw new IllegalArgumentException(); // can use @NonNull to represent this checking
        this.restTemplate = restTemplate;
    }

    public CompanyProfile invoke(String url) {
        return restTemplate.getForObject(url, CompanyProfile.class);
    }

    public CompanyProfile[] invokeForList(String url) {
        return restTemplate.getForObject(url, CompanyProfile[].class);
    }

    public CompanyProfile getProfile(String symbol) {
        // String url = "xxxx";
        return restTemplate.getForObject(url, CompanyProfile.class);
    }

    public static void main(String[] args) {
        CompanyProfileRestTemplate restClient = new CompanyProfileRestTemplate(new RestTemplate());
        CompanyProfile profile = restClient.invoke(url);
    }
}

// this class is a self create RestTemplate
// Originally we just put everything in service layer
// now we encapsulate an extra level as a library
// it is worth to do if you know a lot of people will call in this method
// also no need to config yml for this class

// when a class have state, I can ask other people to set
// but I can set the state with encapsulation an extra class, to lesser the
// state that other people need to set
