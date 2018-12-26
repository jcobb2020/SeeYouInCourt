import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JudgeCommand {

    public List<IJudgment> judgeJudgments(List<IJudgment> judgments, String name){
        List<IJudgment> judgeJudgments = new LinkedList<>();
        for (IJudgment judgment : judgments){
            List<IJudge> judges = judgment.getJudges();
            for(IJudge judge : judges){
                if(judge.getName().equals(name)){
                    judgeJudgments.add(judgment);
                }
            }
        }
        return judgeJudgments;
    }

    public void displayJudgeJudgments(List<IJudgment> judgments, String name){
        List<IJudgment> toDisplay = judgeJudgments(judgments, name);
        ListPrinter.signaturePrinter(toDisplay);
    }

    public void runJudgeCommand(List<IJudgment> judgments){
        String name;
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        displayJudgeJudgments(judgments, name);
        s.close();
    }


}
