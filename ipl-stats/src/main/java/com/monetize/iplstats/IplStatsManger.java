package com.monetize.iplstats;

import com.monetize.iplstats.service.IplStatService;
import com.monetize.iplstats.service.IplStatServiceImpl;

import java.util.Scanner;

public class IplStatsManger {

  public static void main(String[] args) {

    IplStatService statService = new IplStatServiceImpl();
    Scanner sc = new Scanner(System.in);
    while(true){
      System.out.println("""
              1. Get Team Names
              2. Get Players of a Team
              3. Get Team Stats
              4. Get Max Paid Players of Each Team
              5. Get Player Country Stats
              6. Get Top N Paid Players
              7. Get Max Paid Player of Each Role
              8. Get Role Stats
              9. Exit
              """);
      System.out.println("Enter your choice: ");
      int choice = sc.nextInt();
      switch (choice){
        case 1:
          System.out.println(statService.getTeamNames());
          break;
        case 2:
          System.out.println("Enter Team Name: ");
          String teamName = sc.nextLine();
          System.out.println(statService.getPlayers(teamName));
          break;
        case 3:
          System.out.println(statService.getTeamStats());
          break;
        case 4:
          System.out.println(statService.getMaxPaidPlayersOfEachTeam());
          break;
        case 5:
          System.out.println(statService.getPlayerCountryStats());
          break;
        case 6:
          System.out.println("Enter N: ");
          int n = sc.nextInt();
          System.out.println(statService.getTopNPaidPlayers(n));
          break;
        case 7:
          System.out.println(statService.getMaxPaidPlayerOfEachRole());
          break;
        case 8:
          System.out.println(statService.getRoleStats());
          break;
        case 9:
          sc.close();
          System.exit(0);
        default:
          System.out.println("Invalid Choice");
      }
      System.out.println("Do you want to continue y/n ");
      sc.skip("\n");
      if(sc.nextLine().equals("n") ){
          System.exit(0);
      }
    }

  }
}
