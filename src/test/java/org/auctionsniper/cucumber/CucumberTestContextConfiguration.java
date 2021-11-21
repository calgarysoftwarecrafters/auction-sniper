package org.auctionsniper.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.auctionsniper.AuctionsniperApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = AuctionsniperApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
