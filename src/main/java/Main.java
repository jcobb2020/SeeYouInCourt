import java.util.LinkedList;

import CollectionUtilities.JudgmentListCreator;
import Commands.JudgeCommand;
import Commands.JudgesCommand;
import Commands.Month;
import CourtObjects.IJudgment;


public class Main {

    public static void main(String[] args){
//        FileGetters.FileGetter getter = new FileGetters.FileGetter();
//        List<String> jsons;                         //judgement list contained as strings
////
////        String directory = getter.getDirectory();
//        String directory =  "C:/Users/JCobb/Desktop/Studia/Obiektowe/json";
//        jsons = getter.getJSONStringsFromDirectory(directory);
////        CollectionUtilities.ListPrinter.jsonPrinter(jsons);
////        System.out.println("json Size is" + jsons.size());
//////        CollectionUtilities.ListPrinter.printElemAtIndex(jsons, 0);
//        JudgmentCreator jCreator = new JudgmentCreator();
//        List<Judgment> judgments = jCreator.createAllJudgmentList(jsons);
//        List<IJudgment> iJudgments = new LinkedList<>();
//        iJudgments = jCreator.convertToInterface(judgments);
//
////        judgments = jCreator.createJudgment(jsons.get(0));
////        Judgment toDisplayRubrum = judgments.get(0);
// //       String toDisplay = toDisplayRubrum.displayRubrum();
////        System.out.println(toDisplay);
////
////        JudgeMapCreator2 JMP = new JudgeMapCreator2(judgments);
////        JMP.judgesPrinter();
//        String toTakeHTLMFrom = "C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa";
//        List<String> html30 = getter.getHTMLStringsFromDirectory(toTakeHTLMFrom);
//        CollectionUtilities.ListPrinter.jsonPrinter(html30);
////        CollectionUtilities.JudgeMapCreator JMP = new CollectionUtilities.JudgeMapCreator(iJudgments);
//
//        HTMLParser htmlParser = new HTMLParser();
//        Document doc = htmlParser.createDocument(html30.get(1));
////        String title = htmlParser.getTitle(doc);
////        System.out.println(title);
////        String table = htmlParser.getSTH(doc);
////        System.out.println(table);
////        String a = htmlParser.getJudgmentDate(doc);
////        System.out.println(a);
////        htmlParser.listKeys(doc);
////        HTMLJudgment d = new HTMLJudgment();
//        HTMLJudgment d = htmlParser.buildJudgment(doc);
//        DocumentListMaker maker = new DocumentListMaker();
//        List<HTMLJudgment> htmlJudgments = maker.buildList(html30);
//        List<IJudgment> htmlIJudgments = maker.buildIJudgementList(htmlJudgments);
//        List<IJudgment> allJudgements = new LinkedList<>();
//        allJudgements.addAll(htmlIJudgments);
//        allJudgements.addAll(iJudgments);
////        CollectionUtilities.JudgeMapCreator JMP2 = new CollectionUtilities.JudgeMapCreator(htmlIJudgments);
//        CollectionUtilities.JudgeMapCreator JMP3 = new CollectionUtilities.JudgeMapCreator(allJudgements);
        JudgmentListCreator jlc = new JudgmentListCreator();
        String[] dirs = {"C:/Users/JCobb/Desktop/Studia/Obiektowe/json", "C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa"};
        LinkedList<IJudgment> judgements = jlc.buildIudgmentsFromDirs(dirs);
        String a = judgements.get(111).getCaseSignature();
        String b = judgements.get(1120).getCaseSignature();
        //Rubrum r = new Rubrum();
        //r.displayRubrum(judgements);
//        Content c = new Content();
//        c.displayContent(judgements);
//        JudgeCommand jc = new JudgeCommand();
//        jc.runJudgeCommand(judgements);
//        JudgesCommand jcs = new JudgesCommand();
//        jcs.displayTopXJudges(judgements, 12);
        Month month = new Month();
        month.displayMonthStatistics(judgements);
    }
}
//C:/Users/JCobb/Desktop/Studia/Obiektowe/json
//C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa/01/14
// II Cz 259/14
// I SA 1495/03