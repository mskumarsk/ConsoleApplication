package Cricket_Score;

import java.util.Scanner;

public class CricketScore {
    public void cricketScore() {
        Score score = new Score();
        ScoreBoard scoreBoard = new ScoreBoard();
        MatchDetails matchDetails = new MatchDetails();
        Bowler bowler = new Bowler();
        Team team = new Team();
        SelectTeam selectTeam = new SelectTeam();
        boolean trueFalse = true;
        while (trueFalse) {
            System.out.println("=======================>> CRICKET SCORE <<=======================");
            System.out.println("1. SELECT TEAM");
            System.out.println("2. CREATE TEAM");
            System.out.println("3. SCOREBOARD");
            System.out.println("4. EXIT");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the number:");
            int no = scan.nextInt();
            switch (no) {
                case 1: {
                    selectTeam.selectDefaultTeam(matchDetails, bowler);
                    break;
                }
                case 2: {
                    team.teamPage(score, scoreBoard, matchDetails, bowler);
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

    public static void main(String[] args) throws Exception {
        CricketScore cricketScore = new CricketScore();
        cricketScore.cricketScore();
    }
}
