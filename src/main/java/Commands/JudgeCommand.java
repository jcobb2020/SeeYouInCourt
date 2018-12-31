package Commands;

import CollectionUtilities.ListPrinter;
import CourtObjects.IJudge;
import CourtObjects.IJudgment;


import java.util.Arrays;
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

    public String buildJudgeJudgements(List<IJudgment> judgments, String[] names){
        StringBuilder nameBuilder = new StringBuilder();
        for(int i = 1; i<names.length; i++){
            nameBuilder.append(names[i] + " ");
        }
        String name = nameBuilder.toString();
        name = name.substring(0, name.length()-1);
        List<IJudgment> judgeJudgments = judgeJudgments(judgments, name);
        if (judgeJudgments.size()==0){
            return "no cases found for " + name;
        }
        return judgeJudgments.size() + " cases found for " + name;
    }

    public void runJudgeCommand(List<IJudgment> judgments){
        String name;
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        displayJudgeJudgments(judgments, name);
        s.close();
    }


}
