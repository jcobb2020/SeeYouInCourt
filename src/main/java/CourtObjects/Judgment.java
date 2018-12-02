import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Judgment {
    private int id;
    private CourtType courtType;
    private List<ReferencedCourtCase> courtCases;
    private JudgmentType judgmentType;
    private List<Judge> judges;
    private List<String> courtReporters;
    private String decision;
    private String summary;
    private String textContent;
    private List<String> legalBases;
    private List<Regulation> referencedRegulations;
    private List<String> keywords;
    private List<ReferencedCourtCase> referencedCourtCases;
    private String receiptDate;
    private String meansOfAppeal;
    private String judgmentResult;
    private List<String> lowerCourtJudgements;
    private PersonelType personelType;
    private Map<String, String> judgmentForm;
    @SerializedName("division.id")
    private int divisionID;
    private List<Chamber> chambers;
    private List<DissentingOpinion> dissentingOpinions;


    public void displayRubrum(){
        System.out.println("Sygnatura: " + this.id);
        System.out.println("Data" + this.receiptDate);
        System.out.println("Typ Sądu" + this.courtType);
        displayAllJudges();
    }

    private void displayAllJudges(){
        for (Judge j : this.judges){
            j.displayJudge();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public List<ReferencedCourtCase> getCourtCases() {
        return courtCases;
    }

    public void setCourtCases(List<ReferencedCourtCase> courtCases) {
        this.courtCases = courtCases;
    }

    public JudgmentType getJudgmentType() {
        return judgmentType;
    }

    public void setJudgmentType(JudgmentType judgmentType) {
        this.judgmentType = judgmentType;
    }

    public List<Judge> getJudges() {
        return judges;
    }

    public void setJudges(List<Judge> judges) {
        this.judges = judges;
    }

    public List<String> getCourtReporters() {
        return courtReporters;
    }

    public void setCourtReporters(List<String> courtReporters) {
        this.courtReporters = courtReporters;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getLegalBases() {
        return legalBases;
    }

    public void setLegalBases(List<String> legalBases) {
        this.legalBases = legalBases;
    }

    public List<Regulation> getReferencedRegulations() {
        return referencedRegulations;
    }

    public void setReferencedRegulations(List<Regulation> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<ReferencedCourtCase> getReferencedCourtCases() {
        return referencedCourtCases;
    }

    public void setReferencedCourtCases(List<ReferencedCourtCase> referencedCourtCases) {
        this.referencedCourtCases = referencedCourtCases;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getMeansOfAppeal() {
        return meansOfAppeal;
    }

    public void setMeansOfAppeal(String meansOfAppeal) {
        this.meansOfAppeal = meansOfAppeal;
    }

    public String getJudgmentResult() {
        return judgmentResult;
    }

    public void setJudgmentResult(String judgmentResult) {
        this.judgmentResult = judgmentResult;
    }

    public List<String> getLowerCourtJudgements() {
        return lowerCourtJudgements;
    }

    public void setLowerCourtJudgements(List<String> lowerCourtJudgements) {
        this.lowerCourtJudgements = lowerCourtJudgements;
    }

    public PersonelType getPersonelType() {
        return personelType;
    }

    public void setPersonelType(PersonelType personelType) {
        this.personelType = personelType;
    }

    public Map<String, String> getJudgmentForm() {
        return judgmentForm;
    }

    public void setJudgmentForm(Map<String, String> judgmentForm) {
        this.judgmentForm = judgmentForm;
    }

    public int getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(int divisionID) {
        this.divisionID = divisionID;
    }

    public List<Chamber> getChambers() {
        return chambers;
    }

    public void setChambers(List<Chamber> chambers) {
        this.chambers = chambers;
    }

    public List<DissentingOpinion> getDissentingOpinions() {
        return dissentingOpinions;
    }

    public void setDissentingOpinions(List<DissentingOpinion> dissentingOpinions) {
        this.dissentingOpinions = dissentingOpinions;
    }
}
