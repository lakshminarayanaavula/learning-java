package com.monetize.jwjson;

import java.util.List;

public interface IplStatService {

    List<String> getTeamNames();
    List<Player> maxPaidPlayers(String teamName);
}
