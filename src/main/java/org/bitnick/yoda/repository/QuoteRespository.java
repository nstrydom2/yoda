package org.bitnick.yoda.repository;

import org.bitnick.yoda.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRespository extends JpaRepository<Quote, String> {
}
