import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        FileGetter getter = new FileGetter();
        List<String> jsons;                         //judgement list contained as strings

        String directory = getter.getDirectory();
        jsons = getter.getJSONStringsFromDirectory(directory);
        ListPrinter.jsonPrinter(jsons);
        System.out.println("json Size is" + jsons.size());
        ListPrinter.printElemAtIndex(jsons, 0);
        JudgmentCreator jCreator = new JudgmentCreator();
        List<Judgment> judgments = new ArrayList<>();
        judgments = jCreator.createAllJudgmentList(jsons);
//        judgments = jCreator.createJudgment(jsons.get(0));
        System.out.println("wat");
    }
}
//C:/Users/JCobb/Desktop/Studia/Obiektowe/json