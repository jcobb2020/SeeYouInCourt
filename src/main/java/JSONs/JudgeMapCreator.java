import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
//import CourtObjects;

public class JudgeMapCreator {
    private List<Judgment> judgments;
    private List<JSONJudge> judges;
    public HashMap<JSONJudge, List<Judgment>> judgeJudgments;


    public JudgeMapCreator(List<Judgment> judgs){
        this.judgments = judgs;
        createJudgeJudgementsMap();
    }


    private void createJudgeJudgementsMap(){
        this.judgeJudgments = new HashMap<>();
        this.judges= new LinkedList<>();
        for (Judgment j : judgments) {
            for (JSONJudge judge : j.getJudges()) {
                judgeJudgments.put(judge, new LinkedList<>());
            }
        }
        for(JSONJudge key : this.judgeJudgments.keySet()){
                judges.add(key);
        }

        for (Judgment j: judgments){
            for (JSONJudge judge: j.getJudges()){
                judgeJudgments.get(judge).add(j);
           }
        }
    }

    public void judgesPrinter(){

        for(JSONJudge j : judges){
            int x = this.judgeJudgments.get(j).size();
            System.out.println(j.getName() + "ilość spraw" +x);
        }
    }
}