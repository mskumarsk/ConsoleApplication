package Cricket_Score;


import java.util.Map;
import java.util.Set;

public class ScoreBoard {
    public String centerString(int width, String s) {
        return String.format("%-" + width + "s", String.format("%" + (s.length() + (width - s.length()) / 2) + "s", s));
    }

    public void viewData(MatchDetails matchDetails, Bowler bowler) {
        System.out.println("=========================>> SCOREBOARD <<========================");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + matchDetails.getTeam1().toUpperCase() + " BATTING" + "  " +
                "<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("                     Team            : " + matchDetails.getTeam1());
        System.out.println("                     Team Score      : " + matchDetails.teamOneRun.get(0).teamTotalRun);

        System.out.print("\n ------------------------------------------------------------------------");
        System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(15,
                "RUNS") + " | " + centerString(15, "FOUR") + " | " + centerString(15, "SIX") + "|");
        System.out.print("\n ------------------------------------------------------------------------");
        for (int i = 1; i <= 11; i++) {
            System.out.printf("\n | " + centerString(20, matchDetails.group1.get(i)) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamOneRun.get(i).getRuns())) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamOneRun.get(i).getFour())) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamOneRun.get(i).getSix())) + "|");
        }
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + matchDetails.getTeam1().toUpperCase() + " BOWLING" + "" +
                "  <<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(15,
                "OVER") + " | " + centerString(15, "RUNS") + " | " + centerString(15, "WICKET") + "|");
        System.out.print("\n ------------------------------------------------------------------------");
        Set<Map.Entry<String, Bowler>> set = bowler.teamOneBowler.entrySet();
        for (Map.Entry<String, Bowler> set1 : set) {
            System.out.printf("\n | " + centerString(20, set1.getKey()) + " | " + centerString(15,
                    String.valueOf(set1.getValue().over)) + " | " + centerString(15,
                    String.valueOf(set1.getValue().run)) + " | " + centerString(15,
                    String.valueOf(set1.getValue().wicker)) + "|");
        }
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + matchDetails.getTeam2().toUpperCase() + " BATTING" + "" +
                "  <<<<<<<<<<<<<<<<<<<<<<<<<<");

        System.out.println("                     Team            : " + matchDetails.getTeam2());
        System.out.println("                     Team Score      : " + matchDetails.teamTwoRun.get(0).teamTotalRun);

        System.out.print("\n ------------------------------------------------------------------------");
        System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(15,
                "RUNS") + " | " + centerString(15, "FOUR") + " | " + centerString(15, "SIX") + "|");
        System.out.print("\n ------------------------------------------------------------------------");
        for (int i = 1; i <= 11; i++) {

            System.out.printf("\n | " + centerString(20, matchDetails.group2.get(i)) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamTwoRun.get(i).getRuns())) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamTwoRun.get(i).getFour())) + " | " + centerString(15,
                    String.valueOf(matchDetails.teamTwoRun.get(i).getSix())) + "|");
        }
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.println();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>  " + matchDetails.getTeam2().toUpperCase() + " BOWLING" + "" +
                "  <<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.printf("\n | " + centerString(20, "NAME") + " | " + centerString(15,
                "OVER") + " | " + centerString(15, "RUNS") + " | " + centerString(15, "WICKET") + "|");
        System.out.print("\n ------------------------------------------------------------------------");
        Set<Map.Entry<String, Bowler>> set2 = bowler.teamTwoBowler.entrySet();
        for (Map.Entry<String, Bowler> set1 : set2) {
            System.out.printf("\n | " + centerString(20, set1.getKey()) + " | " + centerString(15,
                    String.valueOf(set1.getValue().over)) + " | " + centerString(15,
                    String.valueOf(set1.getValue().run)) + " | " + centerString(15,
                    String.valueOf(set1.getValue().wicker)) + "|");
        }
        System.out.print("\n ------------------------------------------------------------------------");
        System.out.println();
    }
}
