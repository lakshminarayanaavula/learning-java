package com.monetize.iplstats.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.monetize.iplstats.domain.Player;
import com.monetize.iplstats.dto.PlayerCountryStatsDto;
import com.monetize.iplstats.dto.RoleStatsDto;
import com.monetize.iplstats.dto.TeamStatsDto;
import com.monetize.iplstats.util.JsonReaderUtil;

import java.util.*;
import java.util.stream.Collectors;

public class IplStatServiceImpl implements IplStatService{

  private List<Player> players;
  public IplStatServiceImpl(){
      players = JsonReaderUtil.loadFromDataFromJsonFile("/player_data.json", new TypeReference<List<Player>>() {});
  }
  @Override
  public List<String> getTeamNames() {
      return players.stream()
                    .map(Player::getTeam)
                    .distinct()
                    .toList();
  }

  @Override
  public List<Player> getPlayers(String team) {
    List<Player> teamPlayers = players.stream()
            .filter(player -> player.getTeam().equalsIgnoreCase(team))
            .collect(Collectors.toList());

    return teamPlayers;
  }

  @Override
  public List<TeamStatsDto> getTeamStats() {
    Map<String, List<Player>> map = players.stream().collect(
        Collectors.groupingBy(Player::getTeam));
    List<TeamStatsDto> teamStatsDtos = new ArrayList<>();
    for (Map.Entry<String, List<Player>> entry : map.entrySet()) {
      double totalAmount = entry.getValue().stream().mapToDouble(player -> Double.parseDouble(player.getAmount())).sum();
      teamStatsDtos.add(TeamStatsDto.builder().team(entry.getKey()).totalAmount(totalAmount).build());
    }
    return teamStatsDtos;
  }

  @Override
  public List<Map<String, List<Player>>> getMaxPaidPlayersOfEachTeam() {
    return null;
  }

  @Override
  public List<PlayerCountryStatsDto> getPlayerCountryStats() {
    return null;
  }

  @Override
  public List<Player> getTopNPaidPlayers(int n) {
    return null;
  }

  @Override
  public List<Map<String, List<Player>>> getMaxPaidPlayerOfEachRole() {
    return null;
  }

  @Override
  public List<RoleStatsDto> getRoleStats() {
    return null;
  }
}
