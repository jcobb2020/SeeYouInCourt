import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
//import CourtObjects;

public class JudgeMapCreator {
    private List<Judgment> judgments;
    private List<Judge> judges;
    public HashMap<Judge, List<Judgment>> judgeJudgments;


    public JudgeMapCreator(List<Judgment> judgs){
        this.judgments = judgs;
        createJudgeJudgementsMap();
    }


    private void createJudgeJudgementsMap(){
        this.judgeJudgments = new HashMap<>();
        this.judges= new LinkedList<>();
        for (Judgment j : judgments) {
            for (Judge judge : j.getJudges()) {
                judgeJudgments.put(judge, new LinkedList<>());
            }
        }
        for(Judge key : this.judgeJudgments.keySet()){
                judges.add(key);
        }

        for (Judgment j: judgments){
            for (Judge judge: j.getJudges()){
                judgeJudgments.get(judge).add(j);
           }
        }
    }

    public void judgesPrinter(){

        for(Judge j : judges){
            int x = this.judgeJudgments.get(j).size();
            System.out.println(j.getName() + "ilość spraw" +x);
        }
    }
}



//    private void createJudgeJudgementsMap(){
//        this.judgeJudgments = new LinkedHashMap<>();
//        this.judges= new LinkedList<>();
//        for (Judgment j : judgments) {
//            for (Judge judge : j.getJudges()) {
//
//                boolean flag = true;
//                for (int i = 0; i < judges.size(); i++) {
//                    if (judges.get(i).equals(judge)) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    judges.add(judge);
//                    judgeJudgments.put(judge, new LinkedList<>());
//                }
//            }
//        }