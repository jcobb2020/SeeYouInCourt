import java.util.List;

public interface IJudgment {
    public void displayRubrum();

    public String displayAllJudges();

    public String getCaseSignature();

    public String getDate();

    public CourtType getCourtType();

    public List<IJudge> getJudges();

    public String getGrounds();



}
