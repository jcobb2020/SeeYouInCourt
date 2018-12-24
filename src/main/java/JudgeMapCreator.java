import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JudgeMapCreator {

    //import CourtObjects;
    private List<IJudgment> judgments;
    private List<IJudge> judges;
    public HashMap<IJudge, List<IJudgment>> judgeJudgments;


    public JudgeMapCreator(List<IJudgment> judgs) {
        this.judgments = judgs;
        createJudgeJudgementsMap();
    }

    private void createJudgeJudgementsMap() {
        this.judgeJudgments = new HashMap<>();
        this.judges = new LinkedList<>();
        for (IJudgment j : judgments) {
            for (IJudge judge : j.getJudges()) {
                judgeJudgments.put(judge, new LinkedList<>());
            }
        }
        for (IJudge key : this.judgeJudgments.keySet()) {
            judges.add(key);
        }

        for (IJudgment j : judgments) {
            for (IJudge judge : j.getJudges()) {
                judgeJudgments.get(judge).add(j);
            }
        }
    }



    public void printJudges() {

        for (IJudge j : judges) {
            int x = this.judgeJudgments.get(j).size();
            System.out.println(j.getName() + "ilość spraw" + x);
        }
    }
}
