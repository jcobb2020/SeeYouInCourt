import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import AppFiles.App;
import CollectionUtilities.JudgmentListCreator;
import Commands.*;
import CourtObjects.IJudgment;
import java.awt.EventQueue;
import javax.swing.*;


public class Main {

    public static void main(String[] args){

//        JudgmentListCreator jlc = new JudgmentListCreator();
//
//        ArrayList<String> dirs = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        String directory = "";
//        System.out.println("Input directory or input \"exit\" to exit");
//        directory=scanner.nextLine();
//        while (!directory.equals("exit")){
//            dirs.add(directory);
//            directory=scanner.nextLine();
//        }
////        scanner.close();
//        String[] directories = new String[dirs.size()];
//        directories = dirs.toArray(directories);

//        String[] directories = {"C:/Users/JCobb/Desktop/Studia/Obiektowe/json", "C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa"};
//
//        LinkedList<IJudgment> judgements = jlc.buildIJudgmentsFromDirs(directories);
//        String a = judgements.get(111).getCaseSignature();
//        String b = judgements.get(1120).getCaseSignature();
//
//
//        Month month = new Month();
//        month.displayMonthStatistics(judgements);
//        Courts c = new Courts();
//        c.displayStatistics(judgements);
//        Regulations r = new Regulations();
//        r.displayTop10(judgements);
//        Jury j = new Jury();
//        String juryNumber = j.displayJuryNumber(judgements);
//        System.out.println(juryNumber);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
        //App app = new App();
        //app.displayText();

    }
}
//C:/Users/JCobb/Desktop/Studia/Obiektowe/json
//C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa/01/14
// II Cz 259/14
// I SA 1495/03