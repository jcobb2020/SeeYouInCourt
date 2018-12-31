package Commands;

import CollectionUtilities.JudgeMapCreator;
import CourtObjects.IJudge;
import CourtObjects.IJudgment;
import CourtObjects.Judge;

import java.security.Key;
import java.util.*;

public class JudgesCommand {

    public String displayTop(HashMap<IJudge, List<IJudgment>> hashMap, int howMany) {
        TreeMap<Integer, LinkedList<IJudge>> treeMap = new TreeMap<>();
        for (IJudge judge : hashMap.keySet()) {
            LinkedList<IJudge> judges = new LinkedList<>();
            treeMap.put(hashMap.get(judge).size(), judges);
        }
        for (IJudge judge : hashMap.keySet()) {
            treeMap.get(hashMap.get(judge).size()).add(judge);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < howMany;) {
            int lastKey = treeMap.lastKey();
            for (int j = treeMap.get(lastKey).size()-1; j >= 0; j--) {
                builder.append(treeMap.get(lastKey).get(j).displayJudge() + "cases amount " + lastKey + "\n");
                i++;
            }
            treeMap.remove(lastKey);
        }
        return builder.toString();
    }

    public String displayTopXJudges(List<IJudgment> judgments, int howMany) {
        StringBuilder builder = new StringBuilder();
        JudgeMapCreator JMP = new JudgeMapCreator(judgments);
        HashMap<IJudge, List<IJudgment>> judgeJudgments =JMP.judgeJudgments;
        builder.append(displayTop(judgeJudgments, howMany) + "\n");
        return builder.toString();
    }
}

