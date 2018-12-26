import java.util.List;

public class ListPrinter {
    public static void jsonPrinter(List<String> jsons) {
        for (String json : jsons) {
            System.out.println(json);
        }
    }

    public static void printElemAtIndex(List<String> jsons, int index){
        System.out.println(jsons.get(index));
    }

    public static void signaturePrinter(List<IJudgment> judgments){
        for (IJudgment judgment:judgments){
            System.out.println(judgment.getCaseSignature());
        }
    }
}
