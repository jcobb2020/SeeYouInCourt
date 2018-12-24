import java.util.LinkedList;
import java.util.List;

public class HTMLJudgment implements IJudgment {
    private LinkedList<Judge> judges;

    private String judgmentType;
    private String judgmentDate;
    private String inDate;
    private String court;
    private String descriptionSymbol;
    private String bodyOfComplaint;
    private String judgmentContents;
    private String sentence;
    private String grounds;
    private String caseSignature;

    private CourtType courtType;

    public List<IJudge> getJudges(){

        List<IJudge> judgs = new LinkedList<>();
        for (Judge judge : this.judges){
            judgs.add(judge);
        }
        if(judgs.isEmpty()){
            Judge empty = new Judge();
            empty.setName("Empty");
            empty.setFunction("Empty");
            judgs.add(empty);
        }
        return judgs;
    }

    public void displayRubrum(){
        System.out.println(this.generateRubrum());
    }

    public String getDate(){
        return getJudgmentDate();  //added for easier Interface implementation
    }

    public String generateRubrum(){
        StringBuilder sb = new StringBuilder();

        sb.append("Sygnatura: " + this.caseSignature + "\n");
        sb.append("Data: " + this.judgmentDate + "\n");
        sb.append("Typ Sądu: " + this.court +"\n");
        sb.append(displayAllJudges());
        return sb.toString();
    }

    public String displayAllJudges(){
        StringBuilder builder = new StringBuilder();
        for (IJudge j : this.judges){
            builder.append(j.getName() + " - " + j.getFunction() + "\n");
        }
        return builder.toString();
    }
    public String getCaseSignature() {
        return caseSignature;
    }

    public void setCaseSignature(String signature) {
        this.caseSignature = signature;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getGrounds() {
        return grounds;
    }

    public void setGrounds(String grounds) {
        this.grounds = grounds;
    }


    public String getJudgmentContents() {
        return judgmentContents;
    }

    public void setJudgmentContents(String judgmentContents) {
        this.judgmentContents = judgmentContents;
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

    public CourtType getCourtType() {           //used in interface
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }


}
