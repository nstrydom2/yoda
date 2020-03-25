package org.bitnick.yoda.service;

import org.bitnick.yoda.model.Quote;
import org.bitnick.yoda.repository.QuoteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YodaQuoteService {
    private QuoteRespository quoteRespository;

    @Autowired
    public void setQuoteRespository(QuoteRespository quoteRespository) {
        this.quoteRespository = quoteRespository;
    }

    public Quote getRandomQuote() {
        return null;
        //return quoteRespository.findOneRandom();
    }
}
