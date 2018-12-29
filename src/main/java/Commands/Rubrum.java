package Commands;

import CourtObjects.IJudgment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Rubrum {

    public void displayRubrum(List<IJudgment> judgments){
        List<String> signatures = CaseSignaturesGetter.getCaseSignatures();
        for (IJudgment judgment : judgments){
            for(String signature : signatures){
                if(signature.equals(judgment.getCaseSignature())){
                    judgment.displayRubrum();
                    signatures.remove(signature);
                }
            }
        }
    }

    public void displayRubrum2(List<IJudgment> judgments, String[] signatures2){
        List<String> signatures = new LinkedList<>();
        signatures = Arrays.asList(signatures2);
        signatures.remove(0);
        for (IJudgment judgment : judgments){
            for(String signature : signatures){
                if(signature.equals(judgment.getCaseSignature())){
                    judgment.displayRubrum();
                }
            }
        }
    }
    public String CreateRubrums(List<IJudgment> judgments, String[] signatures2){
        List<String> signatures = new LinkedList<>();
        signatures = Arrays.asList(signatures2);
        signatures.remove(0);
        StringBuilder builder = new StringBuilder();
        for (IJudgment judgment : judgments){
            for(String signature : signatures){
                if(signature.equals(judgment.getCaseSignature())){
                    builder.append(judgment.generateRubrum() + "\n");
                }
            }
        }
        return builder.toString();
    }
}
