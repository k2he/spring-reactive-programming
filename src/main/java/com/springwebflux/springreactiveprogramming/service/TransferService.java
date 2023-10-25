package com.springwebflux.springreactiveprogramming.service;

import com.springwebflux.springreactiveprogramming.model.Transfer;
import com.springwebflux.springreactiveprogramming.repo.TransferRepository;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransferService {

  @NonNull
  private TransferRepository transferRepository;

  public Flux<Transfer> findAll() {
    return transferRepository.findAll();
  }

  public Flux<Transfer> findDescriptionContaining(String description) {
    return transferRepository.findByDescriptionContaining(description);
  }

  public Flux<Transfer> findByRecipient(String recipientName) {
    return transferRepository.findByRecipient(recipientName);
  }

  public Mono<Transfer> findById(int id) {
    return transferRepository.findById(id);
  }

  public Mono<Transfer> save(Transfer transfer) {
    return transferRepository.save(transfer);
  }

  public Mono<Transfer> update(int id, Transfer transfer) {
    return transferRepository.findById(id)
        .map(Optional::of)
        .defaultIfEmpty(Optional.empty())
        .flatMap(optionalTransfer -> {
          if(optionalTransfer.isPresent()) {
            transfer.setId(id);
            return transferRepository.save(transfer);
          }
          return Mono.empty();
        });
  }
}
