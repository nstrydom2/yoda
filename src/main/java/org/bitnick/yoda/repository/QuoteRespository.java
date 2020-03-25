package org.bitnick.yoda.repository;

import org.bitnick.yoda.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRespository extends JpaRepository<Quote, String> {
    @Query("SELECT q FROM yoda_quotes q ORDER BY random() LIMIT 1")
    Quote findOneRandom();
}
