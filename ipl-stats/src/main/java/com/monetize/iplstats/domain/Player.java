package com.monetize.iplstats.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
  private String name;
  private String role;
  private String team;
  private String amount;
  private String country;
}