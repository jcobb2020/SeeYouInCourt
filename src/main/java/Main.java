import java.util.ArrayList;
import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;

public class Main {

    public static void main(String[] args){
        FileGetter getter = new FileGetter();
//        List<String> jsons;                         //judgement list contained as strings
//
//        String directory = getter.getDirectory();
//        jsons = getter.getJSONStringsFromDirectory(directory);
//        ListPrinter.jsonPrinter(jsons);
//        System.out.println("json Size is" + jsons.size());
////        ListPrinter.printElemAtIndex(jsons, 0);
//        JudgmentCreator jCreator = new JudgmentCreator();
//        List<Judgment> judgments = jCreator.createAllJudgmentList(jsons);
////        judgments = jCreator.createJudgment(jsons.get(0));
//        Judgment toDisplayRubrum = judgments.get(0);
//        String toDisplay = toDisplayRubrum.displayRubrum();
//        System.out.println(toDisplay);
//
//        JudgeMapCreator JMP = new JudgeMapCreator(judgments);
//        JMP.judgesPrinter();
        List<String> html30 = getter.getHTMLStringsFromDirectory("C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa/10/04");
        ListPrinter.jsonPrinter(html30);
        HTMLParser htmlParser = new HTMLParser();
        Document doc = htmlParser.createDocument(html30.get(0));
        String title = htmlParser.getTitle(doc);
        System.out.println(title);
        String table = htmlParser.getSTH(doc);
        System.out.println(table);


        String a = htmlParser.getJudgmentDate(doc);

        System.out.println(a);
        htmlParser.listKeys(doc);
        HTMLJudgment d = new HTMLJudgment();
        d = htmlParser.buildJudgment(doc);

    }
}
//C:/Users/JCobb/Desktop/Studia/Obiektowe/json
//C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa/01/14