package Commands;

import CourtObjects.IJudgment;

import java.util.LinkedList;
import java.util.List;


public class Content {

    public void displayContent(List<IJudgment> judgments){
        List<String> signatures = CaseSignaturesGetter.getCaseSignatures();
        for (IJudgment judgment : judgments){
            for(String signature : signatures){
                if(signature.equals(judgment.getCaseSignature())){
                    System.out.println(judgment.getGrounds());
                }
            }
        }
    }
}
