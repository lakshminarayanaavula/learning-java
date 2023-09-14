package com.monetize.iplstats.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamStatsDto {
  private String team;
  private double totalAmount;
}
