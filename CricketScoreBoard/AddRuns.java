package Cricket_Score;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddRuns {
    boolean win = false;

    public String centerString(int width, String value) {
        return String.format("%-" + width + "s", String.format("%" + (value.length() + (width - value.length()) / 2) + "s",
                value));
    }

    private void addRunTeamOne(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() != 0) {
            teamOneSecondBat(matchDetails, bowler);
        } else {
                 teamOneFirstBat(matchDetails, bowler);
        }

    }

    private void teamOneFirstBat(MatchDetails matchDetails, Bowler bowler){
        int balls = matchDetails.matchFormat * 6;
        boolean trueFalse1 = true;
        int playerOne = 1;
        int playerTwo = 2;
        int no = 3;
        matchDetails.teamOneRun.put(0, new MatchDetails());
        for (int i = 1; i <= 12; i++) {
            matchDetails.teamOneRun.put(i, new MatchDetails());
        }
        System.out.println("Balls       :  " + balls);
        Scanner scanner1 = new Scanner(System.in);
        int one1 = 1;
        int ball = 0;
        for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
            System.out.println("Over        :  " + i);
            System.out.println("Enter the Bowler:");
            String bowlerName = scanner1.nextLine();
            bowler.setBowlerName(bowlerName);
            bowler.teamTwoBowler.put(bowlerName, new Bowler());
            bowler.teamTwoBowler.get(bowlerName).setOver(1);
            System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
            for (int j = 1; j <= 6; j++) {
                ball++;
                bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                String teamRun = scanner1.nextLine();
                if (teamRun.equals("W")) {
                    bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                    if (trueFalse1) {
                        playerOne = no;
                        no++;
                    } else {
                        playerTwo = no;
                        no++;
                    }
                } else if (teamRun.equals(".")) {
                    matchDetails.teamOneRun.get(0).setDatBal(one1);
                } else {
                    int intRun1 = Integer.parseInt(teamRun);
                    matchDetails.teamOneRun.get(0).setTeamTotalRun(intRun1);
                    matchDetails.setTotRun(intRun1);
                    bowler.teamTwoBowler.get(bowlerName).setRun(intRun1);
                    if (trueFalse1) {
                        int intRun = Integer.parseInt(teamRun);
                        matchDetails.teamOneRun.get(playerOne).setRuns(intRun);
                        if (intRun % 2 == 0) {
                            if (intRun == 4) {
                                matchDetails.teamOneRun.get(playerOne).setFour(one1);
                            } else if (intRun == 6) {
                                matchDetails.teamOneRun.get(playerOne).setSix(one1);
                            }
                        } else if (intRun == 1 || intRun == 3) {
                            trueFalse1 = false;
                        }
                    } else {
                        int intRun = Integer.parseInt(teamRun);
                        matchDetails.teamOneRun.get(playerTwo).setRuns(intRun);
                        if (intRun % 2 == 0) {
                            if (intRun == 4) {
                                matchDetails.teamOneRun.get(playerTwo).setFour(one1);
                            } else if (intRun == 6) {
                                matchDetails.teamOneRun.get(playerTwo).setSix(one1);
                            }
                        } else if (intRun == 1 || intRun == 3) {
                            trueFalse1 = true;
                        }
                    }
                }
            }
            if (trueFalse1) {
                trueFalse1 = false;
            } else {
                trueFalse1 = true;
            }
        }
        addRunTeamTwo(matchDetails, bowler);
    }

    private void teamOneSecondBat(MatchDetails matchDetails, Bowler bowler){
        Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
        System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<========" +
                "===================");
        System.out.print(" ==========================================");
        System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20,
                "NAME") + " | ");
        System.out.print("\n ==========================================");
        for (Map.Entry<Integer, String> map : group1Set) {
            System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20,
                    map.getValue()) + " |");
        }
        System.out.print("\n ==========================================");
        System.out.println();

        System.out.println("Batting     :  " + matchDetails.getTeam1());
        // System.out.println(matchDetails.getTeam1() + " is bating...");
        int balls = matchDetails.getMatchFormat() * 6;
        boolean trueFalse = true;
        int playerOne = 1;
        int playerTwo = 2;
        int no = 3;
        matchDetails.teamOneRun.put(0, new MatchDetails());
        for (int i = 1; i <= 12; i++) {
            matchDetails.teamOneRun.put(i, new MatchDetails());
        }
        System.out.println("Balls       :  " + balls);
        Scanner scanner1 = new Scanner(System.in);
        int one = 1;
        System.out.println("Target      :  " + matchDetails.teamTwoRun.get(0).teamTotalRun);
        for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
            System.out.println("Over        :  " + i);
            System.out.println("Enter the Bowler:");
            String bowlerName = scanner1.nextLine();
            bowler.setBowlerName(bowlerName);
            bowler.teamTwoBowler.put(bowlerName, new Bowler());
            bowler.teamTwoBowler.get(bowlerName).setOver(1);
            System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
            for (int j = 1; j <= 6; j++) {
                bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                if (matchDetails.teamOneRun.get(0).teamTotalRun <= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                    String teamRun = scanner1.nextLine();
                    if (teamRun.equals("W")) {
                        bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                        if (trueFalse) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun.equals(".")) {
                        matchDetails.teamOneRun.get(0).setDatBal(one);
                    } else {
                        int intRun1 = Integer.parseInt(teamRun);
                        bowler.teamTwoBowler.get(bowlerName).setRun(intRun1);
                        matchDetails.teamOneRun.get(0).setTeamTotalRun(intRun1);
                        matchDetails.setTotRun(intRun1);
                        if (trueFalse) {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamOneRun.get(playerOne).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamOneRun.get(playerOne).setFour(one);
                                } else if (intRun == 6) {
                                    matchDetails.teamOneRun.get(playerOne).setSix(one);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                trueFalse = false;
                            }
                        } else {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamOneRun.get(playerTwo).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamOneRun.get(playerTwo).setFour(one);
                                } else if (intRun == 6) {
                                    matchDetails.teamOneRun.get(playerTwo).setSix(one);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                trueFalse = true;
                            }
                        }
                    }

                } else {
                    int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
                    win = true;
                    break;
                }
            }
            if (trueFalse) {
                trueFalse = false;
            } else {
                trueFalse = true;
            }
        }

        if (matchDetails.teamOneRun.get(0).teamTotalRun > matchDetails.teamTwoRun.get(0).teamTotalRun) {
            if (!win) {
                int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
            }
        } else if (!win) {
            int run1 = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
            System.out.println(matchDetails.getTeam2() + " won by " + run1 + " runs");
        }
        if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
            System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
            System.out.println("Match draw");
        }
    }

    private void addRunTeamTwo(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() == 0) {
            teamTwoFirstBat(matchDetails, bowler);
        } else {
            teamTwoSecondBat(matchDetails, bowler);
        }
    }

    private void teamTwoFirstBat(MatchDetails matchDetails, Bowler bowler){
        int balls = matchDetails.getMatchFormat() * 6;
        boolean trueFalse2 = true;
        int playerOne = 1;
        int playerTwo = 2;
        int no = 3;
        matchDetails.teamTwoRun.put(0, new MatchDetails());
        for (int i = 1; i <= 12; i++) {
            matchDetails.teamTwoRun.put(i, new MatchDetails());
        }
        System.out.println("Balls       :  " + balls);
        Scanner scanner1 = new Scanner(System.in);
        int one2 = 1;
        for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
            System.out.println("Over        :  " + i);
            System.out.println("Enter the Bowler:");
            String bowlerName = scanner1.nextLine();
            bowler.setBowlerName(bowlerName);
            bowler.teamOneBowler.put(bowlerName, new Bowler());
            bowler.teamOneBowler.get(bowlerName).setOver(1);
            System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
            for (int j = 1; j <= 6; j++) {
                bowler.teamOneBowler.get(bowlerName).setBalls(1);
                String teamRun = scanner1.nextLine();
                if (teamRun.equals("W")) {
                    bowler.teamOneBowler.get(bowlerName).setWicker(1);
                    if (trueFalse2) {
                        playerOne = no;
                        no++;
                    } else {
                        playerTwo = no;
                        no++;
                    }
                } else if (teamRun.equals(".")) {
                    matchDetails.teamTwoRun.get(0).setDatBal(one2);
                } else {
                    int intRun1 = Integer.parseInt(teamRun);
                    matchDetails.teamTwoRun.get(0).setTeamTotalRun(intRun1);
                    matchDetails.setTotRun(intRun1);
                    bowler.teamOneBowler.get(bowlerName).setRun(intRun1);
                    if (trueFalse2) {
                        int intRun = Integer.parseInt(teamRun);
                        matchDetails.teamTwoRun.get(playerOne).setRuns(intRun);
                        if (intRun % 2 == 0) {
                            if (intRun == 4) {
                                matchDetails.teamTwoRun.get(playerOne).setFour(one2);
                            } else if (intRun == 6) {
                                matchDetails.teamTwoRun.get(playerOne).setSix(one2);
                            }
                        } else if (intRun == 1 || intRun == 3) {
                            trueFalse2 = false;
                        }
                    } else {
                        int intRun = Integer.parseInt(teamRun);
                        matchDetails.teamTwoRun.get(playerTwo).setRuns(intRun);
                        if (intRun % 2 == 0) {
                            if (intRun == 4) {
                                matchDetails.teamTwoRun.get(playerTwo).setFour(one2);
                            } else if (intRun == 6) {
                                matchDetails.teamTwoRun.get(playerTwo).setSix(one2);
                            }
                        } else if (intRun == 1 || intRun == 3) {
                            trueFalse2 = true;
                        }
                    }
                }
            }
        }
        if (trueFalse2) {
            trueFalse2 = false;
        } else {
            trueFalse2 = true;
        }
        addRunTeamOne(matchDetails, bowler);
    }

    private void teamTwoSecondBat(MatchDetails matchDetails, Bowler bowler){
        System.out.println("===========================>>  " + matchDetails.team2.toUpperCase() + "  <<========" +
                "===================");
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

        System.out.println("Batting     :  " + matchDetails.getTeam2());
        int balls = matchDetails.matchFormat * 6;
        boolean trueFalse3 = true;
        int playerOne = 1;
        int playerTwo = 2;
        int no = 3;
        matchDetails.teamTwoRun.put(0, new MatchDetails());
        for (int i = 1; i <= 12; i++) {
            matchDetails.teamTwoRun.put(i, new MatchDetails());
        }
        System.out.println("Balls       :  " + balls);
        Scanner scanner1 = new Scanner(System.in);
        int one3 = 1;
        System.out.println("Target      :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
        for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
            System.out.println("Over        :  " + i);
            System.out.println("Enter the Bowler:");
            String bowlerName = scanner1.nextLine();
            bowler.setBowlerName(bowlerName);
            bowler.teamOneBowler.put(bowlerName, new Bowler());
            bowler.teamOneBowler.get(bowlerName).setOver(1);
            System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
            for (int j = 1; j <= 6; j++) {
                bowler.teamOneBowler.get(bowlerName).setBalls(1);
                if (matchDetails.teamOneRun.get(0).teamTotalRun >= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                    String teamRun = scanner1.nextLine();
                    if (teamRun.equals("W")) {
                        bowler.teamOneBowler.get(bowlerName).setWicker(1);
                        if (trueFalse3) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun.equals(".")) {
                        matchDetails.teamTwoRun.get(0).setDatBal(one3);
                    } else {
                        int intRun1 = Integer.parseInt(teamRun);
                        matchDetails.teamTwoRun.get(0).setTeamTotalRun(intRun1);
                        matchDetails.setTotRun(intRun1);
                        bowler.teamOneBowler.get(bowlerName).setRun(intRun1);
                        if (trueFalse3) {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamTwoRun.get(playerOne).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamTwoRun.get(playerOne).setFour(one3);
                                } else if (intRun == 6) {
                                    matchDetails.teamTwoRun.get(playerOne).setSix(one3);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                trueFalse3 = false;
                            }
                        } else {
                            int intRun = Integer.parseInt(teamRun);
                            matchDetails.teamTwoRun.get(playerTwo).setRuns(intRun);
                            if (intRun % 2 == 0) {
                                if (intRun == 4) {
                                    matchDetails.teamTwoRun.get(playerTwo).setFour(one3);
                                } else if (intRun == 6) {
                                    matchDetails.teamTwoRun.get(playerTwo).setSix(one3);
                                }
                            } else if (intRun == 1 || intRun == 3) {
                                trueFalse3 = true;
                            }
                        }
                    }
                } else {
                    int run = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam2() + " won by " + run + " runs");
                    win = true;
                    break;
                }
            }
            if (trueFalse3) {
                trueFalse3 = false;
            } else {
                trueFalse3 = true;
            }
        }
        if (matchDetails.teamOneRun.get(0).teamTotalRun < matchDetails.teamTwoRun.get(0).teamTotalRun) {
            if (!win) {
                int run = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                System.out.println(matchDetails.getTeam2() + " won by " + run + " runs");
            }
        } else if (!win) {
            int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
            System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
        }
        if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
            System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
            System.out.println("Match draw");
        }
    }
}
