package com.practice.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // return a fortune
        return "Expect heavy traffic today";
    }

    @Override
    public String getFortune(boolean tripWire) {

       if (tripWire) {
           throw new RuntimeException("Final destination typa shit! highway closed!!");
       }

       return getFortune();
    }
}
