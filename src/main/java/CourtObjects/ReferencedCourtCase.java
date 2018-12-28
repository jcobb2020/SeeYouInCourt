package CourtObjects;

import java.util.List;

public class ReferencedCourtCase {
    private String caseNumber;
    private List<String> judgmentIds;
    private boolean generated;

    public String getCaseNumber(){
        return this.caseNumber;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ReferencedCourtCase))
        {
            return false;
        }
        ReferencedCourtCase courtCase = (ReferencedCourtCase) o;
        if(this.caseNumber.equals(courtCase.getCaseNumber())){
            return true;
        }
        return false;
    }
}
