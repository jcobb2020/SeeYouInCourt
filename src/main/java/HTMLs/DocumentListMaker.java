package HTMLs;
import CourtObjects.HTMLJudgment;
import CourtObjects.IJudgment;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DocumentListMaker {

    public List<HTMLJudgment> buildList(List<String> htmls){
        HTMLParser htmlParser = new HTMLParser();
        ArrayList<Document> docs = new ArrayList<Document>();

        for(String html : htmls){
            docs.add(htmlParser.createDocument(html));
        }
        ArrayList<HTMLJudgment> judgments = new ArrayList<HTMLJudgment>();
        for(Document doc : docs){
            judgments.add(htmlParser.buildJudgment(doc));
        }
        return judgments;
    }

    public List<IJudgment> buildIJudgementList(List<HTMLJudgment> judgments){
        List<IJudgment> judgs = new LinkedList<>();
        for(HTMLJudgment j : judgments){
            judgs.add(j);
        }
        return judgs;
    }
}
