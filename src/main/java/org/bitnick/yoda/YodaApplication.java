package org.bitnick.yoda;

import org.bitnick.yoda.service.scrape.YodaScraper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class YodaApplication implements CommandLineRunner {
	private YodaScraper yodaScraper;

	private Logger LOG = LoggerFactory.getLogger(YodaApplication.class);

	@Autowired
	public void setYodaScraper(YodaScraper yodaScraper) {
		this.yodaScraper = yodaScraper;
	}

	public static void main(String[] args) {
		SpringApplication.run(YodaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		yodaScraper.scrapeYodaQuotes();
	}
}
