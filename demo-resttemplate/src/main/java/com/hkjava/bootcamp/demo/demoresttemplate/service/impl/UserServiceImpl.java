package com.hkjava.bootcamp.demo.demoresttemplate.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.hkjava.bootcamp.demo.demoresttemplate.exception.JPHException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.BusinessException;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Code;
import com.hkjava.bootcamp.demo.demoresttemplate.infra.Protocol;
import com.hkjava.bootcamp.demo.demoresttemplate.model.User;
import com.hkjava.bootcamp.demo.demoresttemplate.service.UserService;

@Service
public class UserServiceImpl implements UserService { // Bean
    
    // 3 stages:
    // 1st inject the bean to the RestTemplate by Autowired
    // 2nd + 3rd with the @Value annotation, it will go to the yml file and look for the path according to the variable you set
    //  if any spelling mistake, will make Value cannot find many matching 
    // which server can start, but will have whitelabel error on api
    
    // can be private String jphDomain = "jsonplaceholder.typicode.com", same effect
    // you can set private final String, but cannot use @Value
    // @Value is do at server start time
    // but final already settle everything on compile time and not allow to update the state 

    @Autowired
    private RestTemplate restTemplate; // search from spring-context
    // if inject fail, run-time error

    @Value(value = "${api.jsonplaceholder.domain}") // search from yml
    private String jphDomain; // jsonplaceholder.typicode.com

    @Value(value = "${api.jsonplaceholder.endpoints.user}") // search from yml
    private String userEndpoint; // jsonplaceholder.typicode.com

    @Override
    public List<User> findAll() throws BusinessException {
        String url = UriComponentsBuilder.newInstance() //
            //.scheme("https") //
            .scheme(Protocol.HTTPS.name()) //
            .host(jphDomain)
            .path(userEndpoint)
            .toUriString();
        
        System.out.println("url=" + url);

        //the below line happened a lot of things (6ms, very long)
        // it can hanld both static class and non static class, crazy
        // invoke API + Deserialization (JSON -> Object) (like magic xD)
        // invoke API + Jaskson Deserialization (JSON -> Object)
        try {
            User[] users = restTemplate.getForObject(url, User[].class);
            return Arrays.asList(users);
        } catch (RestClientException e) {
            throw new JPHException(Code.JPH_NOTFOUND); // if can't call server, throw BusinessException
        }
    }
}
