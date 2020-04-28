/*
 * The MIT License
 *
 * Copyright (c) 2020, Nicholas Bruce Strydom
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.bitnick.yoda.service;

import org.bitnick.yoda.model.Quote;
import org.bitnick.yoda.repository.QuoteRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class YodaQuoteService {
    private QuoteRepository quoteRepository;

    private Logger LOG = LoggerFactory.getLogger(YodaQuoteService.class);

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        return quoteRepository.findOneRandom();
    }

    public void scrapeYodaQuotes() throws IOException {
        final String YODA_QUOTES_URL = "http://www.yodaquotes.net/page/";


        for (int page = 1; page <= 9; page++) {
            Document document = Jsoup.connect(YODA_QUOTES_URL + page).get();
            Elements quoteElements = document.select("h2");

            for (Element element : quoteElements) {
                Quote quote = new Quote();
                quote.setQuote(element.text());

                LOG.info("Saving: " + quote.toString());
                quoteRepository.save(quote);
            }
        }
    }
}
