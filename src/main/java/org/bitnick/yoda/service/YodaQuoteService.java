package org.bitnick.yoda.service;

import org.bitnick.yoda.model.Quote;
import org.bitnick.yoda.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YodaQuoteService {
    private QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        return null;
        //return quoteRespository.findOneRandom();
    }
}
