package Commands;

import CourtObjects.IJudgment;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Month {

    private Months getMonth(IJudgment judgment) {
        String month = judgment.getDate();
        if (month.length() < 7) return Months.WRONG;
        else return Months.parse(month.substring(5, 7));
    }

    public void displayMonthStatistics(List<IJudgment> judgments) {
        int months[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (IJudgment j : judgments) {
            Months a = getMonth(j);
            int i = Months.toInt(a);
            months[i]++;
        }
        for (int i = 0; i < 13; i++) {
            System.out.println(Months.parseFromInt(i) + " iloć spraw " + months[i]);
        }
    }

    public String bouildMonthsString(List<IJudgment> judgments) {
        int months[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (IJudgment j : judgments) {
            Months a = getMonth(j);
            int i = Months.toInt(a);
            months[i]++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 13; i++){
            builder.append(new String(Months.parseFromInt(i) + " iloć spraw " + months[i] + "\n"));
        }
        return builder.toString();
    }
}
