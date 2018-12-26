import java.util.LinkedList;
import java.util.List;

public class JudgmentListCreator {


    public LinkedList<IJudgment> buildIudgmentsFromDirs(String[] directories) {
        FileGetter getter = new FileGetter();
        DocumentListMaker maker = new DocumentListMaker();
        JudgmentCreator jCreator = new JudgmentCreator();
        LinkedList<IJudgment> allJudgments = new LinkedList<>();
        for (String directory : directories) {
            List<String> htmlStringsFromDirectory = getter.getHTMLStringsFromDirectory(directory);
            List<String> jsonStringsFromDirectory = getter.getJSONStringsFromDirectory(directory);
            List<HTMLJudgment> htmlJudgments = maker.buildList(htmlStringsFromDirectory);
            List<Judgment> jsonJudgments = jCreator.createAllJudgmentList(jsonStringsFromDirectory);
            LinkedList<IJudgment> judgments1 = iJudgmentsFromJson(jsonJudgments);
            LinkedList<IJudgment> judgments2 = iJudgmentsFromHtml(htmlJudgments);
            judgments1 = mergeIJudgmentLists(judgments1, judgments2);
            allJudgments = mergeIJudgmentLists(allJudgments,judgments1);
        }
        return allJudgments;
    }

    private LinkedList<IJudgment> iJudgmentsFromJson(List<Judgment> judgments){
        LinkedList<IJudgment> toReturn = new LinkedList<>();
        for(Judgment j : judgments){
            toReturn.add(j);
        }
        return toReturn;
    }

    private LinkedList<IJudgment> iJudgmentsFromHtml(List<HTMLJudgment> judgments){
        LinkedList<IJudgment> toReturn = new LinkedList<>();
        for(HTMLJudgment j : judgments){
            toReturn.add(j);
        }
        return toReturn;
    }

    private LinkedList<IJudgment> mergeIJudgmentLists(LinkedList<IJudgment> list1, LinkedList<IJudgment> list2){
        list1.addAll(list2);
        return list1;
    }



}
