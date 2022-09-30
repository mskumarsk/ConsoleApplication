package Cricket_Score;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Match {
    boolean win = false;

    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void addRunTeamOne(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() != 0) {
            Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
            System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<=========" +
                    "==================");
            System.out.print(" ==========================================");
            System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
            System.out.print("\n ==========================================");
            for (Map.Entry<Integer, String> map : group1Set) {
                System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20,
                        map.getValue()) + " |");
            }
            System.out.print("\n ==========================================");
            System.out.println();
            System.out.println("Batting     :  " + matchDetails.getTeam1());
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
            Scanner scanner3 = new Scanner(System.in);
            int db = 1;
            System.out.println("Target      :  " + matchDetails.teamTwoRun.get(0).teamTotalRun);
            boolean trueFalse1 = false;
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner3.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamTwoBowler.put(bowlerName, new Bowler());
                bowler.teamTwoBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                    if (matchDetails.teamOneRun.get(0).teamTotalRun <= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                        Scanner scanner = new Scanner(System.in);
                        int teamRun = scanner.nextInt();
                        int randomRun = (int) Math.floor(Math.random() * 7);
                        if (teamRun == randomRun || randomRun == 0) {
                            bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                            System.out.println("Wicket...");
                            if (trueFalse) {
                                playerOne = no;
                                no++;
                            } else {
                                playerTwo = no;
                                no++;
                            }
                        } else if (teamRun == 5 || randomRun == 5) {
                            System.out.println(".");
                            matchDetails.teamOneRun.get(0).setDatBal(db);
                        } else {
                            bowler.teamTwoBowler.get(bowlerName).setRun(teamRun);
                            matchDetails.teamOneRun.get(0).setTeamTotalRun(teamRun);
                            matchDetails.setTotRun(teamRun);
                            if (trueFalse) {
                                matchDetails.teamOneRun.get(playerOne).setRuns(teamRun);
                                if (teamRun % 2 == 0) {
                                    if (teamRun == 4) {
                                        matchDetails.teamOneRun.get(playerOne).setFour(db);
                                    } else if (teamRun == 6) {
                                        matchDetails.teamOneRun.get(playerOne).setSix(db);
                                    }
                                } else if (teamRun == 1 || teamRun == 3) {
                                    trueFalse = false;
                                }
                            } else {
                                matchDetails.teamOneRun.get(playerTwo).setRuns(teamRun);
                                if (teamRun % 2 == 0) {
                                    if (teamRun == 4) {
                                        matchDetails.teamOneRun.get(playerTwo).setFour(db);
                                    } else if (teamRun == 6) {
                                        matchDetails.teamOneRun.get(playerTwo).setSix(db);
                                    }
                                } else if (teamRun == 1 || teamRun == 3) {
                                    trueFalse = true;
                                }
                            }
                        }
                    } else {
                        int run = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                        System.out.println(matchDetails.getTeam1() + " won by " + run + " runs");
                        win = true;
                        trueFalse1 = true;
                        break;
                    }
                }
                if (trueFalse1) {
                    break;
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
                if ((matchDetails.teamOneRun.get(0).teamTotalRun < matchDetails.teamTwoRun.get(0).teamTotalRun)) {
                    int run1 = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam2() + " won by " + run1 + " runs");
                }
            }
            if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
                System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
                System.out.println("Match draw");
            }
        } else {
            Set<Map.Entry<Integer, String>> group1Set = matchDetails.group1.entrySet();
            System.out.println("===========================>>  " + matchDetails.team1.toUpperCase() + "  <<=========" +
                    "==================");
            System.out.print(" ==========================================");
            System.out.printf("\n | " + centerString(15, "No") + " | " + centerString(20, "NAME") + " | ");
            System.out.print("\n ==========================================");
            for (Map.Entry<Integer, String> map : group1Set) {
                System.out.printf("\n | " + centerString(15, String.valueOf(map.getKey())) + " | " + centerString(20,
                        map.getValue()) + " |");
            }
            System.out.print("\n ==========================================");
            System.out.println();
            System.out.println("Batting     :  " + matchDetails.getTeam1());
            int balls = matchDetails.matchFormat * 6;
            boolean trueFalse = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamOneRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamOneRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            Scanner scanner4 = new Scanner(System.in);
            int run = 1;
            int ball = 0;
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner4.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamTwoBowler.put(bowlerName, new Bowler());
                bowler.teamTwoBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    ball++;
                    bowler.teamTwoBowler.get(bowlerName).setBalls(1);
                    Scanner scanner = new Scanner(System.in);
                    int teamRun = scanner.nextInt();
                    int randomRun = (int) Math.floor(Math.random() * 7);
                    if (teamRun == randomRun || randomRun == 0) {
                        System.out.println("Wicket...");
                        bowler.teamTwoBowler.get(bowlerName).setWicker(1);
                        if (trueFalse) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun == 5 || randomRun == 5) {
                        System.out.println(".");
                        matchDetails.teamOneRun.get(0).setDatBal(run);
                    } else {
                        matchDetails.teamOneRun.get(0).setTeamTotalRun(teamRun);
                        matchDetails.setTotRun(teamRun);
                        bowler.teamTwoBowler.get(bowlerName).setRun(teamRun);
                        if (trueFalse) {
                            matchDetails.teamOneRun.get(playerOne).setRuns(teamRun);
                            if (teamRun % 2 == 0) {
                                if (teamRun == 4) {
                                    matchDetails.teamOneRun.get(playerOne).setFour(run);
                                } else if (teamRun == 6) {
                                    matchDetails.teamOneRun.get(playerOne).setSix(run);
                                }
                            } else if (teamRun == 1 || teamRun == 3) {
                                trueFalse = false;
                            }
                        } else {
                            matchDetails.teamOneRun.get(playerTwo).setRuns(teamRun);
                            if (teamRun % 2 == 0) {
                                if (teamRun == 4) {
                                    matchDetails.teamOneRun.get(playerTwo).setFour(run);
                                } else if (teamRun == 6) {
                                    matchDetails.teamOneRun.get(playerTwo).setSix(run);
                                }
                            } else if (teamRun == 1 || teamRun == 3) {
                                trueFalse = true;
                            }
                        }
                    }
                }
                if (trueFalse) {
                    trueFalse = false;
                } else {
                    trueFalse = true;
                }
            }
            addRunTeamTwo(matchDetails, bowler);
        }

        new ScoreBoard();

    }

    public void addRunTeamTwo(MatchDetails matchDetails, Bowler bowler) {
        if (matchDetails.getTotRun() == 0) {
            System.out.println("===========================>>  " + matchDetails.team2.toUpperCase() + "  <<=========" +
                    "==================");
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
            int balls = matchDetails.getMatchFormat() * 6;
            boolean trueFalse = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamTwoRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamTwoRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            Scanner scanner1 = new Scanner(System.in);
            int run = 1;
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
                    int teamRun = (int) Math.floor(Math.random() * 7);
                    int randomRun = (int) Math.floor(Math.random() * 7);
                    if (teamRun == randomRun) {
                        bowler.teamOneBowler.get(bowlerName).setWicker(1);
                        System.out.println("Wicket...");
                        if (trueFalse) {
                            playerOne = no;
                            no++;
                        } else {
                            playerTwo = no;
                            no++;
                        }
                    } else if (teamRun == 5 || teamRun == 0) {
                        System.out.println(".");
                        matchDetails.teamTwoRun.get(0).setDatBal(run);
                    } else {
                        System.out.println(teamRun);
                        matchDetails.teamTwoRun.get(0).setTeamTotalRun(teamRun);
                        matchDetails.setTotRun(teamRun);
                        bowler.teamOneBowler.get(bowlerName).setRun(teamRun);
                        if (trueFalse) {
                            matchDetails.teamTwoRun.get(playerOne).setRuns(teamRun);
                            if (teamRun % 2 == 0) {
                                if (teamRun == 4) {
                                    matchDetails.teamTwoRun.get(playerOne).setFour(run);
                                } else if (teamRun == 6) {
                                    matchDetails.teamTwoRun.get(playerOne).setSix(run);
                                }
                            } else if (teamRun == 1 || teamRun == 3) {
                                trueFalse = false;
                            }
                        } else {
                            matchDetails.teamTwoRun.get(playerTwo).setRuns(teamRun);
                            if (teamRun % 2 == 0) {
                                if (teamRun == 4) {
                                    matchDetails.teamTwoRun.get(playerTwo).setFour(run);
                                } else if (teamRun == 6) {
                                    matchDetails.teamTwoRun.get(playerTwo).setSix(run);
                                }
                            } else if (teamRun == 1 || teamRun == 3) {
                                trueFalse = true;
                            }
                        }
                    }
                }
            }
            if (trueFalse) {
                trueFalse = false;
            } else {
                trueFalse = true;
            }
            addRunTeamOne(matchDetails, bowler);
        } else {
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
            boolean trueFalse = true;
            int playerOne = 1;
            int playerTwo = 2;
            int no = 3;
            matchDetails.teamTwoRun.put(0, new MatchDetails());
            for (int i = 1; i <= 12; i++) {
                matchDetails.teamTwoRun.put(i, new MatchDetails());
            }
            System.out.println("Balls       :  " + balls);
            Scanner scanner2 = new Scanner(System.in);
            int run = 1;
            System.out.println("Target      :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
            for (int i = 1; i <= matchDetails.getMatchFormat(); i++) {
                System.out.println("Over        :  " + i);
                System.out.println("Enter the Bowler:");
                String bowlerName = scanner2.nextLine();
                bowler.setBowlerName(bowlerName);
                bowler.teamOneBowler.put(bowlerName, new Bowler());
                bowler.teamOneBowler.get(bowlerName).setOver(1);
                System.out.println("Enter the Run:    (W -> Wicket, 6 -> Six, 4 -> Four)");
                for (int j = 1; j <= 6; j++) {
                    bowler.teamOneBowler.get(bowlerName).setBalls(1);
                    if (matchDetails.teamOneRun.get(0).teamTotalRun >= matchDetails.teamTwoRun.get(0).teamTotalRun) {
                        int teamRun = (int) Math.floor(Math.random() * 7);
                        int randomRun = (int) Math.floor(Math.random() * 7);
                        if (teamRun == randomRun) {
                            System.out.println("Wicket...");
                            bowler.teamOneBowler.get(bowlerName).setWicker(1);
                            if (trueFalse) {
                                playerOne = no;
                                no++;
                            } else {
                                playerTwo = no;
                                no++;
                            }
                        } else if (teamRun == 0 || teamRun == 5) {
                            System.out.println(".");
                            matchDetails.teamTwoRun.get(0).setDatBal(run);
                        } else {
                            System.out.println(teamRun);
                            matchDetails.teamTwoRun.get(0).setTeamTotalRun(teamRun);
                            matchDetails.setTotRun(teamRun);
                            bowler.teamOneBowler.get(bowlerName).setRun(teamRun);
                            if (trueFalse) {
                                matchDetails.teamTwoRun.get(playerOne).setRuns(teamRun);
                                if (teamRun % 2 == 0) {
                                    if (teamRun == 4) {
                                        matchDetails.teamTwoRun.get(playerOne).setFour(run);
                                    } else if (teamRun == 6) {
                                        matchDetails.teamTwoRun.get(playerOne).setSix(run);
                                    }
                                } else if (teamRun == 1 || teamRun == 3) {
                                    trueFalse = false;
                                }
                            } else {
                                matchDetails.teamTwoRun.get(playerTwo).setRuns(teamRun);
                                if (teamRun % 2 == 0) {
                                    if (teamRun == 4) {
                                        matchDetails.teamTwoRun.get(playerTwo).setFour(run);
                                    } else if (teamRun == 6) {
                                        matchDetails.teamTwoRun.get(playerTwo).setSix(run);
                                    }
                                } else if (teamRun == 1 || teamRun == 3) {
                                    trueFalse = true;
                                }
                            }
                        }
                    } else {
                        int run1 = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                        System.out.println(matchDetails.getTeam2() + " won by " + run1 + " runs");
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
            if (matchDetails.teamOneRun.get(0).teamTotalRun < matchDetails.teamTwoRun.get(0).teamTotalRun) {
                if (!win) {
                    int run2 = matchDetails.teamTwoRun.get(0).teamTotalRun - matchDetails.teamOneRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam2() + " won by " + run2 + " runs");
                }
            } else if (!win) {
                if ((matchDetails.teamOneRun.get(0).teamTotalRun > matchDetails.teamTwoRun.get(0).teamTotalRun)) {
                    int run3 = matchDetails.teamOneRun.get(0).teamTotalRun - matchDetails.teamTwoRun.get(0).teamTotalRun;
                    System.out.println(matchDetails.getTeam1() + " won by " + run3 + " runs");
                }
            }
            if (matchDetails.teamOneRun.get(0).teamTotalRun == matchDetails.teamTwoRun.get(0).teamTotalRun) {
                System.out.println("Runs        :  " + matchDetails.teamOneRun.get(0).teamTotalRun);
                System.out.println("Match draw");
            }
        }
        new ScoreBoard();
    }

}
