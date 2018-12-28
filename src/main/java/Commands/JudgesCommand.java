package Commands;

import CollectionUtilities.JudgeMapCreator;
import CourtObjects.IJudge;
import CourtObjects.IJudgment;
import CourtObjects.Judge;

import java.security.Key;
import java.util.*;

public class JudgesCommand {

    private void displayTop(HashMap<IJudge, List<IJudgment>> hashMap, int howMany) {
        TreeMap<Integer, LinkedList<IJudge>> treeMap = new TreeMap<>();
        for (IJudge judge : hashMap.keySet()) {
            LinkedList<IJudge> judges = new LinkedList<>();
            treeMap.put(hashMap.get(judge).size(), judges);
        }
        for (IJudge judge : hashMap.keySet()) {
            treeMap.get(hashMap.get(judge).size()).add(judge);
        }
        for (int i = 0; i < howMany;) {
            int lastKey = treeMap.lastKey();
            for (int j = treeMap.get(lastKey).size()-1; j >= 0; j--) {
                System.out.println(treeMap.get(lastKey).get(j).displayJudge() + "cases amount " + lastKey);
                i++;
            }
            treeMap.remove(lastKey);
        }
    }

    public void displayTopXJudges(List<IJudgment> judgments, int howMany) {
        JudgeMapCreator JMP = new JudgeMapCreator(judgments);
        HashMap<IJudge, List<IJudgment>> judgeJudgments =JMP.judgeJudgments;
        displayTop(judgeJudgments, howMany);
    }
}

