package Cricket_Score;

import java.util.*;

public class Score {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void insertScore(MatchDetails matchDetails, Bowler bowler) {
        System.out.println("==========================>> DETAILS <<==========================");
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter the match format(-> OVER <-):");
        matchDetails.setMatchFormat(scanner2.nextInt());
        System.out.println("Enter the team name:");
        Scanner scanner = new Scanner(System.in);
        matchDetails.setTeam1(scanner.nextLine());
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the players:");
        for (int i = 1; i <= 11; i++) {
            String name = scanner1.nextLine();
            matchDetails.group1.put(i, name);
        }
        Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
        System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<============" +
                "===============");
        System.out.print(" ==========================================");
        System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
        System.out.print("\n ==========================================");
        for (Map.Entry<Integer, String> map : group1Set) {
            System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20,
                    map.getValue()) + " |");
        }
        System.out.print("\n ==========================================");
        System.out.println();
        System.out.println("==========================>>>>>>^<<<<<<==========================");
        System.out.println("Enter the team name:");
        matchDetails.setTeam2(scanner.nextLine());

        System.out.println("Enter the players:");
        for (int i = 1; i <= 11; i++) {
            String name = scanner1.nextLine();
            matchDetails.group2.put(i, name);
        }
        System.out.println("===========================>>  " + matchDetails.team2.toUpperCase() + "  <<=============" +
                "==============");
        System.out.print(" ==========================================");
        System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
        System.out.print("\n ==========================================");
        Set<Map.Entry<Integer, String>> group2Set = matchDetails.group2.entrySet();
        for (Map.Entry<Integer, String> map : group2Set) {
            System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20,
                    map.getValue()) + " |");
        }
        System.out.print("\n ==========================================");
        System.out.println();
        System.out.println("==========================>>>>>>^<<<<<<==========================");
    }

    public void insertRuns(MatchDetails matchDetails, Bowler bowler) {
        System.out.println("============================>> RUNS <<===========================");
        System.out.println("Select batting team:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. " + matchDetails.getTeam1().toUpperCase());
        System.out.println("2. " + matchDetails.getTeam2().toUpperCase());
        int number = scanner.nextInt();
        switch (number) {
            case 1: {
                Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
                System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<=====" +
                        "======================");
                System.out.print(" ==========================================");
                System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20,
                        "NAME") + " | ");
                System.out.print("\n ==========================================");
                for (Map.Entry<Integer, String> map : group1Set) {
                    System.out.printf("\n | " + centerString(15,
                            String.valueOf(map.getKey())) + " | " + centerString(20, map.getValue()) + " |");
                }
                System.out.print("\n ==========================================");
                System.out.println();
                System.out.println("Batting     :  " + matchDetails.getTeam1());
                new AddRuns().addRunTeamOne(matchDetails, bowler);
            }
            break;
            case 2: {
                System.out.println("===========================>>  " + matchDetails.team2.toUpperCase() + "  <<=====" +
                        "======================");
                System.out.print(" ==========================================");
                System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20,
                        "NAME") + " | ");
                System.out.print("\n ==========================================");
                Set<Map.Entry<Integer, String>> group2Set = matchDetails.group2.entrySet();
                for (Map.Entry<Integer, String> map : group2Set) {
                    System.out.printf("\n | " + centerString(15,
                            String.valueOf(map.getKey())) + " | " + centerString(20, map.getValue()) + " |");
                }
                System.out.print("\n ==========================================");
                System.out.println();
                System.out.println("Batting     :  " + matchDetails.getTeam2());
                new AddRuns().addRunTeamTwo(matchDetails, bowler);
            }
            break;
        }

    }
}
