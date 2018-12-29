package Commands;

import CourtObjects.IJudgment;

import java.util.Arrays;
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
    public void displayContent2(List<IJudgment> judgments, String[] signatures2){
        List<String> signatures = new LinkedList<>();
        signatures = Arrays.asList(signatures2);
        signatures.remove(0);
        for (IJudgment judgment : judgments){
            for(String signature : signatures){
                if(signature.equals(judgment.getCaseSignature())){
                    System.out.println(judgment.getGrounds());
                }
            }
        }
    }

//    public String buildContent(List<IJudgment> judgments, String[] signatures2){
//        List<String> signatures = new LinkedList<>();
//        signatures = Arrays.asList(signatures2);
//        signatures.remove(0);
//        for (IJudgment judgment : judgments){
//            for(String signature : signatures){
//                if(signature.equals(judgment.getCaseSignature())){
//
//                }
//            }
//        }
//    }
}
