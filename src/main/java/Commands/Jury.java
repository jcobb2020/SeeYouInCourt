package Commands;

import CourtObjects.IJudgment;

import java.util.List;

public class Jury {

    public String displayJuryNumber(List<IJudgment> judgments){
        int juries[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for (IJudgment judgment : judgments){
            int i = judgment.getJudges().size();
            juries[i] ++;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        for(int j: juries){
            if(j==0){
                index++;
                continue;
            }
            builder.append(index + " Judges: " + j + " cases" + "\n");
            index ++;
        }
        return builder.toString();
    }
}
