package Cricket_Score;

import java.util.Scanner;

public class RandomCricket {
    public void toss(MatchDetails matchDetails, Bowler bowler, Match match) {
        int toss = (int) Math.floor(Math.random() * 2);
        System.out.println("==========================>> TOSS <<==========================");
        System.out.println("[   ++++ 0 -> HEAD  |  1 -> TAIL ++++   ]");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (toss == number) {
            System.out.println(matchDetails.getTeam2().toUpperCase() + " WIN THE TOSS");
            int choose = (int) Math.floor(Math.random() * 2);
            if (choose == 0) {
                System.out.println(matchDetails.getTeam2().toUpperCase() + " IS BATTING...");
                match.addRunTeamTwo(matchDetails, bowler);
            } else {
                System.out.println(matchDetails.getTeam2().toUpperCase() + " IS BOWLING...");
                match.addRunTeamOne(matchDetails, bowler);
            }
        } else {
            System.out.println(matchDetails.getTeam1().toUpperCase() + " WIN THE TOSS");
            System.out.println("[   ++++ 0 -> BATTING  |  1 -> BOWLING ++++   ]");
            int batOrBowling = scanner.nextInt();
            if (batOrBowling == 0) {
                System.out.println(matchDetails.getTeam1().toUpperCase() + " IS BATTING...");
                match.addRunTeamOne(matchDetails, bowler);
            } else if (batOrBowling == 1) {
                System.out.println(matchDetails.getTeam1().toUpperCase() + " IS BOWLING...");
                match.addRunTeamTwo(matchDetails, bowler);
            } else {
                System.out.println("Enter 0 or 1...");
                toss(matchDetails, bowler, match);
            }
        }
    }

}
