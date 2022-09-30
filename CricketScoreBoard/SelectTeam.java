package Cricket_Score;

import java.util.Random;
import java.util.Scanner;

public class SelectTeam {
    RandomCricket randomCricket = new RandomCricket();
    Match match = new Match();

    public void selectDefaultTeam(MatchDetails matchDetails, Bowler bowler) {

        String[] indianTeam = {"KL Rahul", "R. Sharma", "V. Kohli", "S. Yadav", "H. Pandya", "A. Patel",
                "H. Patel", "D. Karthik", "B. Kumar", "Umesh Yadav", "Yuzyendra"};
        String[] australiaTeam = {"Aaron Finch (c)", "Steve Smith", "Glenn Maxwell", "Josh Inglis", "Tim David",
                "Matthew Wade", "Pat Cummins", "Josh Inglis", "Nathan Ellis", "Adam Zampa", "Josh Hazlewood"};
        String[] pakistanTeam = {"Babar Azam", "Shadab Khan", "Aamir Jamal", "Abrar Ahmed", "Asif Ali", "Haider Ali",
                "Haris Rauf", "Iftikhar Ahmed", "Khushdil Shah", "Mohammad Haris", "Mohammad Hasnain"};
        String[] englandTeam = {"Eoin Morgan", "Moeen Ali", "Jonathan Bairstow", "Sam Billings", "Jos Buttler",
                "Reece Topley", "Chris Jordan", "Liam Livingstone", "Dawid Malan", "Tymal Mills", "Adil Rashid"};

        System.out.println("==========================>> CRICKET <<==========================");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the match format(-> OVER <-):");
        matchDetails.setMatchFormat(scanner.nextInt());
        System.out.println("1. INDIAN TEAM");
        System.out.println("2. AUSTRALIA TEAM");
        System.out.println("3. PAKISTAN TEAM");
        System.out.println("4. ENGLAND TEAM");
        System.out.println("Enter your team (1 - 4):");
        int number = scanner.nextInt();
        int randomNumber = (int) Math.floor(Math.random() * 4);
        if (number == 1) {
            matchDetails.setTeam1("INDIAN TEAM");
            for (int i = 1; i <= 11; i++) {
                matchDetails.group1.put(i, indianTeam[i - 1]);
            }

            if (randomNumber == 0) {
                matchDetails.setTeam2("AUSTRALIA TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, australiaTeam[i - 1]);
                }
            } else if (randomNumber == 1) {
                matchDetails.setTeam2("AUSTRALIA TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, australiaTeam[i - 1]);
                }
            } else if (randomNumber == 2) {
                matchDetails.setTeam2("PAKISTAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, pakistanTeam[i - 1]);
                }
            } else if (randomNumber == 3) {
                matchDetails.setTeam2("ENGLAND TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, englandTeam[i - 1]);
                }
            }
            randomCricket.toss(matchDetails, bowler, match);

        } else if (number == 2) {
            matchDetails.setTeam1("AUSTRALIA TEAM");
            for (int i = 1; i <= 11; i++) {
                matchDetails.group1.put(i, australiaTeam[i - 1]);
            }

            if (randomNumber == 0) {
                matchDetails.setTeam2("INDIAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, indianTeam[i - 1]);
                }
            } else if (randomNumber == 1) {
                matchDetails.setTeam2("INDIAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, indianTeam[i - 1]);
                }
            } else if (randomNumber == 2) {
                matchDetails.setTeam2("PAKISTAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, pakistanTeam[i - 1]);
                }
            } else if (randomNumber == 3) {
                matchDetails.setTeam2("ENGLAND TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, englandTeam[i - 1]);
                }
            }
            randomCricket.toss(matchDetails, bowler, match);

        } else if (number == 3) {
            matchDetails.setTeam1("PAKISTAN TEAM");
            for (int i = 1; i <= 11; i++) {
                matchDetails.group1.put(i, pakistanTeam[i - 1]);
            }


            if (randomNumber == 0) {
                matchDetails.setTeam2("INDIAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, indianTeam[i - 1]);
                }
            } else if (randomNumber == 1) {
                matchDetails.setTeam2("AUSTRALIA TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, australiaTeam[i - 1]);
                }
            } else if (randomNumber == 2) {
                matchDetails.setTeam2("AUSTRALIA TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, australiaTeam[i - 1]);
                }
            } else if (randomNumber == 3) {
                matchDetails.setTeam2("ENGLAND TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, englandTeam[i - 1]);
                }
            }
            randomCricket.toss(matchDetails, bowler, match);
        } else if (number == 4) {
            matchDetails.setTeam1("ENGLAND TEAM");
            for (int i = 1; i <= 11; i++) {
                matchDetails.group1.put(i, englandTeam[i - 1]);
            }
            if (randomNumber == 0) {
                matchDetails.setTeam2("INDIAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, indianTeam[i - 1]);
                }
            } else if (randomNumber == 1) {
                matchDetails.setTeam2("AUSTRALIA TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, australiaTeam[i - 1]);
                }
            } else if (randomNumber == 2) {
                matchDetails.setTeam2("PAKISTAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, pakistanTeam[i - 1]);
                }
            } else if (randomNumber == 3) {
                matchDetails.setTeam2("PAKISTAN TEAM");
                for (int i = 1; i <= 11; i++) {
                    matchDetails.group2.put(i, pakistanTeam[i - 1]);
                }
            }
            randomCricket.toss(matchDetails, bowler, match);

        } else {
            System.out.println("Enter 1 to 4 number...");
        }


    }

}
