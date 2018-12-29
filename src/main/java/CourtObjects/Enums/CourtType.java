package CourtObjects.Enums;

public enum CourtType {

    COMMON, // sąd powszechny

    SUPREME, // Sąd Najwyższy

    ADMINISTRATIVE, // sąd administracyjny

    SUPREME_ADMINISTRATIVE_COURT, //naczelny sąd adminitracyjny

    CONSTITUTIONAL_TRIBUNAL, // Trybunał Konstytucyjny

    NATIONAL_APPEAL_CHAMBER,
    WRONG; // Krajowa Izba Odwoławcza

    public static int parseToInt(CourtType ct){
        switch (ct){
            case COMMON:
                return 1;
            case SUPREME:
                return 2;
            case ADMINISTRATIVE:
                return 3;
            case SUPREME_ADMINISTRATIVE_COURT:
                return 4;
            case CONSTITUTIONAL_TRIBUNAL:
                return 5;
            case NATIONAL_APPEAL_CHAMBER:
                return 6;
            default:
                return 0;
        }
    }
    public static CourtType parseFromInt(int i){
        switch (i){
            case 1:
                return COMMON;
            case 2:
                return SUPREME;
            case 3:
                return ADMINISTRATIVE;
            case 4:
                return SUPREME_ADMINISTRATIVE_COURT;
            case 5:
                return CONSTITUTIONAL_TRIBUNAL;
            case 6:
                return NATIONAL_APPEAL_CHAMBER;
            default:
                return WRONG;
        }
    }
}

