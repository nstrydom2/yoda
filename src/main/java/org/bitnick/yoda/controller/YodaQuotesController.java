package org.bitnick.yoda.controller;

import org.bitnick.yoda.model.Quote;
import org.bitnick.yoda.service.YodaQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YodaQuotesController {
    private YodaQuoteService yodaQuoteService;

    @Autowired
    public void setYodaQuoteService(YodaQuoteService yodaQuoteService) {
        this.yodaQuoteService = yodaQuoteService;
    }

    @RequestMapping(path = "yoda/", method = RequestMethod.GET)
    public Quote getRandomQuote() {
        return yodaQuoteService.getRandomQuote();
    }
}
