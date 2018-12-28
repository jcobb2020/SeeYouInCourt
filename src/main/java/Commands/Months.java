package Commands;

public enum Months {
    JANUARY,
    FEBUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER,
    WRONG;

    public static Months parse(String s){
        switch (s){
            case ("01"):
                return JANUARY;
            case ("02"):
                return FEBUARY;
            case ("03"):
                return MARCH;
            case ("04"):
                return APRIL;
            case ("05"):
                return MAY;
            case("06"):
                return JUNE;
            case ("07"):
                return JULY;
            case ("08"):
                return AUGUST;
            case ("09"):
                return SEPTEMBER;
            case ("10"):
                return OCTOBER;
            case ("11"):
                return NOVEMBER;
            case ("12"):
                return DECEMBER;
            default:
                return WRONG;
        }
    }
    public static int toInt(Months a){
        switch (a) {
            case WRONG:
                return 0;
            case JANUARY:
                return 1;
            case FEBUARY:
                return 2;
            case MARCH:
                return 3;
            case APRIL:
                return 4;
            case MAY:
                return 5;
            case JUNE:
                return 6;
            case JULY:
                return 7;
            case AUGUST:
                return 8;
            case SEPTEMBER:
                return 9;
            case OCTOBER:
                return 10;
            case NOVEMBER:
                return 11;
            case DECEMBER:
                return 12;
            default:
                return 0;
        }
    }
    public static Months parseFromInt(int i){
        switch (i){
            case (1):
                return JANUARY;
            case (2):
                return FEBUARY;
            case (3):
                return MARCH;
            case (4):
                return APRIL;
            case (5):
                return MAY;
            case(6):
                return JUNE;
            case (7):
                return JULY;
            case (8):
                return AUGUST;
            case (9):
                return SEPTEMBER;
            case (10):
                return OCTOBER;
            case (11):
                return NOVEMBER;
            case (12):
                return DECEMBER;
            default:
                return WRONG;
        }
    }
}
