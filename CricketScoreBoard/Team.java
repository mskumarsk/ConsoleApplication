package Cricket_Score;

import java.util.Scanner;

public class Team {
    public void teamPage(Score score, ScoreBoard scoreBoard, MatchDetails matchDetails, Bowler bowler) {
        boolean trueFalse = true;
        while (trueFalse) {
            System.out.println("============================>> TEAM <<===========================");
            System.out.println("1. Team");
            System.out.println("2. Run");
            System.out.println("3. Score Board");
            System.out.println("4. Exit");
            System.out.println("Enter the number:");
            Scanner scan = new Scanner(System.in);
            int number = scan.nextInt();
            switch (number) {
                case 1: {
                    score.insertScore(matchDetails, bowler);
                    break;
                }
                case 2: {
                    score.insertRuns(matchDetails, bowler);
                    break;
                }
                case 3: {
                    scoreBoard.viewData(matchDetails, bowler);
                    break;
                }
                case 4: {
                    trueFalse = false;
                }
            }
        }
    }
}
