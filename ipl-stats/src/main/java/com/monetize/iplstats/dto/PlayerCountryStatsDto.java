package com.monetize.iplstats.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class PlayerCountryStatsDto {
  private String country;
  private int totalPlayers;
  private int totalAmount;
}
