import java.util.LinkedList;

public class HTMLJudgment implements IJudgment {
    private LinkedList<Judge> judges;

    private String judgmentType;
    private String judgmentDate;
    private String inDate;
    private String court;
    private String descriptionSymbol;
    private String bodyOfComplaint;
    private String judgmentContents;

    public String getJudgmentContents() {
        return judgmentContents;
    }

    public void setJudgmentContents(String judgmentContents) {
        this.judgmentContents = judgmentContents;
    }


    public String displayRubrum(){
        return "rubrum";
    }

    public LinkedList<Judge> getJudges() {
        return judges;
    }

    public void setJudges(LinkedList<Judge> judges) {
        this.judges = judges;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public String getDescriptionSymbol() {
        return descriptionSymbol;
    }

    public void setDescriptionSymbol(String descriptionSymbol) {
        this.descriptionSymbol = descriptionSymbol;
    }

    public String getBodyOfComplaint() {
        return bodyOfComplaint;
    }

    public void setBodyOfComplaint(String bodyOfComplaint) {
        this.bodyOfComplaint = bodyOfComplaint;
    }


    public String getJudgmentDate() {
        return judgmentDate;
    }

    public void setJudgmentDate(String judgmentDate) {
        this.judgmentDate = judgmentDate;
    }

    public String getJudgmentType() {
        return judgmentType;
    }

    public void setJudgmentType(String judgmentType) {
        this.judgmentType = judgmentType;
    }


}
