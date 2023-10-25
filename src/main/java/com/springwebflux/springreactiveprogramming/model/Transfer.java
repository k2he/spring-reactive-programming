package com.springwebflux.springreactiveprogramming.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

  @Id
  private Integer id;

  private String originator;

  private String recipient;

  private String description;
}
