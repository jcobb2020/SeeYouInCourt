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

    public String buildContent(List<IJudgment> judgments, String[] signatures2){
        List<String> signatures = new LinkedList<>();
        signatures = Arrays.asList(signatures2);
        List<String> signatures3 = new LinkedList<>();
        try {
            for (int i = 1; i < signatures.size(); i++) {
                signatures3.add(signatures.get(i));
            }
        }
        catch (NullPointerException e){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (IJudgment judgment : judgments){
            for(int j = 0; j<signatures3.size(); j++){
                StringBuilder groundBuilder = new StringBuilder();
                try {
                    for(int i = 0; i < 3; i++){
                        if(i+j>signatures3.size()-1){
                            break;
                        }
                        groundBuilder.append(signatures3.get(i + j)+" ");
                        String sign = groundBuilder.toString();
                        if (sign.substring(0, sign.length()-1).equals(judgment.getCaseSignature())) {
                            builder.append(judgment.getGrounds() + "\n");
                        }
                    }
                }
                catch (IndexOutOfBoundsException f){
                    continue;
                }
            }
        }
        return builder.toString();
    }
}
