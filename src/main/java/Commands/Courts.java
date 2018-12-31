package Commands;

import CourtObjects.Enums.CourtType;
import CourtObjects.IJudgment;

import java.util.ArrayList;
import java.util.List;

public class Courts {

    public String buildStatistics(List<IJudgment> judgments) {
        int courtTypeArray[] = {0, 0, 0, 0, 0, 0, 0};
        StringBuilder builder = new StringBuilder();
        for(IJudgment judgment: judgments){
            CourtType ct = judgment.getCourtType();
            courtTypeArray[CourtType.parseToInt(ct)]++;
        }
        for (int i = 0; i<7; i++){
            builder.append(CourtType.parseFromInt(i) + ": " + courtTypeArray[i] + "\n");
        }
        return builder.toString();
    }
}
