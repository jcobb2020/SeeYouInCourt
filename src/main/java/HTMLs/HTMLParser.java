import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

import java.util.LinkedList;

public class HTMLParser {
    public Document createDocument(String html){
        Document doc = Jsoup.parse(html);
        return doc;
    }

    public String getTitle(Document document){
        String Title = document.title();
        return Title;
    }

    public String getSTH(Document document){
        Element table = document.select("table").get(2);
        String tableString = table.toString();
        return tableString;
    }

    public Elements getKeys(Document document){
        Elements keys = document.select("td.info-list-label");
//        Elements judges = elements.after("Sędziowie");
//        return jugde.toString();
        return keys;
    }

    private Elements getValues(Document document){
        Elements values = document.select("td.info-list-value");
        return values;
    }
     public String getJudgmentDate(Document document){
        Elements values = getValues(document);
        String a = values.get(0).text();
                //childNode(1).childNode(1).childNode(0).childNode(1).childNode(0).toString();
        //.childNode(0).childNode(1).childNode(1).toString();
         // child(1).child(1).child(0).child(1).child(0);
        return a;
     }

     public void listKeys(Document document){
        Elements keys = getKeys(document);
         for (Element key : keys) {
             System.out.println(key.text());
         }
     }

     private void setDateAndType(HTMLJudgment judgment, String dateAndType){
        StringBuilder builder = new StringBuilder();
        String[] parts = dateAndType.split(" ");
        judgment.setJudgmentDate(parts[0]);
        judgment.setJudgmentType(parts[1]);
     }

    private LinkedList<Judge> makeJudgesList(String judgesString){
        String[] judges = judgesString.split("br/");
        LinkedList<Judge> judges1 = new LinkedList<>();
        for(String judge : judges){
            Judge toAdd = new Judge();
            if(judge.contains("/")){
                String[] nameAndType = judge.split("/");
                toAdd.setName(nameAndType[0]);
                toAdd.setFunction(nameAndType[1]);
                judges1.add(toAdd);
            }
            else{
                toAdd.setName(judge);
            }
        }
        return judges1;
    }

    public HTMLJudgment buildJudgment(Document document){
        HTMLJudgment judgment = new HTMLJudgment();
        Elements values = getValues(document);
        Elements keys = getKeys(document);
        int i = 0;
        for(Element key : keys){
            String keyString = key.text();
            if(keyString.equals("Data orzeczenia")){
                setDateAndType(judgment, values.get(i).text());
            }
            else if (keyString.equals("Data wpływu")){
                judgment.setInDate(cleanHTMLString(values.get(i).toString()));
            }
            else if (keyString.equals("Sąd")){
                judgment.setCourt(cleanHTMLString(values.get(i).toString()));
                
            }
            else if (keyString.equals("Sędziowie")){
                judgment.setJudges(makeJudgesList(values.get(i).text()));

            }
            else if (keyString.equals("Symbol z opisem")){
                judgment.setDescriptionSymbol(cleanHTMLString(values.get(i).text()));
            }
            else if (keyString.equals("Skarżony organ")){
                judgment.setBodyOfComplaint(cleanHTMLString(values.get(i).text()));
            }
            else if (keyString.equals("Treść wyniku")){
                judgment.setJudgmentContents(cleanHTMLString(values.get(i).text()));
            }
            i++;
        }
        return judgment;
    }

    private String cleanHTMLString(String toClean){
        if(toClean.contains(">")) {
            String[] first = toClean.split(">");
            toClean = first[1];
            if(toClean.contains("<")) {
                String[] second = toClean.split("<");
                toClean = second[0];
            }
        }
        return toClean;
    }
}
