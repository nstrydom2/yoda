package org.bitnick.yoda;

import org.bitnick.yoda.repository.QuoteRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YodaApplication implements CommandLineRunner {
	private Logger LOG = LoggerFactory.getLogger(YodaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(YodaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Goodbye, cruel world!");
	}
}
