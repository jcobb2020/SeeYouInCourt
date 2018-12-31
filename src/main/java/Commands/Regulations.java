package Commands;

import CourtObjects.IJudge;
import CourtObjects.IJudgment;
import CourtObjects.ReferencedRegulation;
import CourtObjects.Regulation;

import java.util.*;

public class Regulations {
    public HashMap<ReferencedRegulation, Integer> regulationOccurances(List<IJudgment> judgments) {
        HashMap<ReferencedRegulation, Integer> rrOccurances = new LinkedHashMap<>();
        for (IJudgment judgment : judgments) {
            for (ReferencedRegulation RR : judgment.createReferencedRegulationList()) {

                if (rrOccurances.get(RR) != null) {
                    rrOccurances.put(RR, rrOccurances.get(RR) + 1);
                } else {
                    rrOccurances.put(RR, 1);
                }
            }
        }
        return rrOccurances;
    }

    public String top10(HashMap<ReferencedRegulation, Integer> regulationOccurances) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int j = 0;
            ReferencedRegulation toReturn = new ReferencedRegulation();
            for (ReferencedRegulation RR : regulationOccurances.keySet()) {
                if(regulationOccurances.get(RR)>j){
                    toReturn = RR;
                    j = regulationOccurances.get(RR);
                }
            }
            builder.append(toReturn.toString());
            builder.append("occurances: " + regulationOccurances.get(toReturn) +"\n");
            regulationOccurances.remove(toReturn);
        }
        return builder.toString();
    }

    public String buildTop10(List<IJudgment> judgments){
        HashMap<ReferencedRegulation, Integer> hashMap = regulationOccurances(judgments);
        return top10(hashMap);
    }

}
