import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;


public class Main {

    public static void main(String[] args){
        FileGetter getter = new FileGetter();
        List<String> jsons;                         //judgement list contained as strings
//
//        String directory = getter.getDirectory();
        String directory =  "C:/Users/JCobb/Desktop/Studia/Obiektowe/json";
        jsons = getter.getJSONStringsFromDirectory(directory);
//        ListPrinter.jsonPrinter(jsons);
//        System.out.println("json Size is" + jsons.size());
////        ListPrinter.printElemAtIndex(jsons, 0);
        JudgmentCreator jCreator = new JudgmentCreator();
        List<Judgment> judgments = jCreator.createAllJudgmentList(jsons);
        List<IJudgment> iJudgments = new LinkedList<>();
        iJudgments = jCreator.convertToInterface(judgments);

//        judgments = jCreator.createJudgment(jsons.get(0));
//        Judgment toDisplayRubrum = judgments.get(0);
 //       String toDisplay = toDisplayRubrum.displayRubrum();
//        System.out.println(toDisplay);
//
//        JudgeMapCreator2 JMP = new JudgeMapCreator2(judgments);
//        JMP.judgesPrinter();
        String toTakeHTLMFrom = "C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa";
        List<String> html30 = getter.getHTMLStringsFromDirectory(toTakeHTLMFrom);
        ListPrinter.jsonPrinter(html30);
//        JudgeMapCreator JMP = new JudgeMapCreator(iJudgments);

        HTMLParser htmlParser = new HTMLParser();
        Document doc = htmlParser.createDocument(html30.get(1));
//        String title = htmlParser.getTitle(doc);
//        System.out.println(title);
//        String table = htmlParser.getSTH(doc);
//        System.out.println(table);
//        String a = htmlParser.getJudgmentDate(doc);
//        System.out.println(a);
//        htmlParser.listKeys(doc);
//        HTMLJudgment d = new HTMLJudgment();
        HTMLJudgment d = htmlParser.buildJudgment(doc);
        DocumentListMaker maker = new DocumentListMaker();
        List<HTMLJudgment> htmlJudgments = maker.buildList(html30);
        List<IJudgment> htmlIJudgments = maker.buildIJudgementList(htmlJudgments);
        List<IJudgment> allJudgements = new LinkedList<>();
        allJudgements.addAll(htmlIJudgments);
        allJudgements.addAll(iJudgments);
//        JudgeMapCreator JMP2 = new JudgeMapCreator(htmlIJudgments);
        JudgeMapCreator JMP3 = new JudgeMapCreator(allJudgements);
    }
}
//C:/Users/JCobb/Desktop/Studia/Obiektowe/json
//C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa/01/14