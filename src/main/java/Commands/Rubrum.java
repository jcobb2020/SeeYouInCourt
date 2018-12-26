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
}
