import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JudgeMapCreator {

    //import CourtObjects;
    private List<Judgment> judgments;
    private List<Judge> judges;
    public HashMap<Judge, List<Judgment>> judgeJudgments;


    public JudgeMapCreator(List<Judgment> judgs) {
        this.judgments = judgs;
        createJudgeJudgementsMap();
    }

    private void createJudgeJudgementsMap() {
        this.judgeJudgments = new HashMap<>();
        this.judges = new LinkedList<>();
        for (Judgment j : judgments) {
            for (Judge judge : j.getJudges()) {
                judgeJudgments.put(judge, new LinkedList<>());
            }
        }
        for (Judge key : this.judgeJudgments.keySet()) {
            judges.add(key);
        }

        for (Judgment j : judgments) {
            for (Judge judge : j.getJudges()) {
                judgeJudgments.get(judge).add(j);
            }
        }
    }

    public void printJudges() {

        for (Judge j : judges) {
            int x = this.judgeJudgments.get(j).size();
            System.out.println(j.getName() + "ilość spraw" + x);
        }
    }
}
