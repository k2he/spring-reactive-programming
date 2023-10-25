package com.springwebflux.springreactiveprogramming.controller;

import com.springwebflux.springreactiveprogramming.model.Transfer;
import com.springwebflux.springreactiveprogramming.service.TransferService;
import java.time.Duration;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TransferController {

  @NonNull
  private TransferService transferService;

  @GetMapping(path = "/transfers")
  public Flux<Transfer> getAll() {
    return transferService.findAll()
        .delayElements(Duration.ofSeconds(1L));
  }

  @GetMapping(path = "/transfers-reactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Transfer> transfers1() {
    return transferService.findAll()
        .delayElements(Duration.ofSeconds(1L));
  }


  @GetMapping("/transfers/{id}")
  public Mono<Transfer> getTutorialById(@PathVariable("id") int id) {
    return transferService.findById(id);
  }

  @PostMapping("/transfer")
  public Mono<Transfer> createTransfer(@RequestBody Transfer transfer) {
    return transferService.save(transfer);
  }

  @PutMapping("/transfer/{id}")
  public Mono<Transfer> updateTransfer(@PathVariable("id") int id, @RequestBody Transfer transfer) {
    return transferService.update(id, transfer);
  }

  @GetMapping("/tutorials/searchByName/{recipientName}")
  public Flux<Transfer> searchByRecipientName(@PathVariable("recipientName") String recipientName) {
    return transferService.findByRecipient(recipientName);
  }

  @GetMapping("/tutorials/searchByDescription/{description}")
  public Flux<Transfer> searchByDescription(@PathVariable("description") String description) {
    return transferService.findDescriptionContaining(description);
  }
}
