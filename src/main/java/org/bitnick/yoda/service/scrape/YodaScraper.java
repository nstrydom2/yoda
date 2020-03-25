package org.bitnick.yoda.service.scrape;

import org.bitnick.yoda.model.Quote;
import org.bitnick.yoda.repository.QuoteRespository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class YodaScraper {
    private QuoteRespository quoteRespository;

    private Logger LOG = LoggerFactory.getLogger(YodaScraper.class);

    @Autowired
    public void setQuoteRespository(QuoteRespository quoteRespository) {
        this.quoteRespository = quoteRespository;
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
                quoteRespository.save(quote);
            }
        }
    }
}
