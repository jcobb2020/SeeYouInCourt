package Commands;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CaseSignaturesGetter {
    public static List<String> getCaseSignatures(){
        List<String> signatures = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String toDisplayRubrum = scanner.nextLine();
            if(toDisplayRubrum.equals("exit")){
                break;
            }
            else{
                signatures.add(toDisplayRubrum);
            }
        }
        scanner.close();
        return signatures;
    }


}
