package org.bitnick.yoda.repository;

import org.bitnick.yoda.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String> {
    @Query(value = "SELECT * FROM yoda_quotes ORDER BY random() LIMIT 1", nativeQuery = true)
    Quote findOneRandom();
}

