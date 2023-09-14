package com.monetize.iplstats.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleStatsDto {
  private String roleName;
  private double totalAmount;
  private long playerCount;
}
