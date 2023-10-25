package com.springwebflux.springreactiveprogramming.repo;


import com.springwebflux.springreactiveprogramming.model.Transfer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface TransferRepository extends R2dbcRepository<Transfer, Integer> {

  Flux<Transfer> findByDescriptionContaining(String title);

  Flux<Transfer> findByRecipient(String recipient);
}
