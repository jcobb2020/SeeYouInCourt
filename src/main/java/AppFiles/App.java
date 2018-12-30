package AppFiles;

import CollectionUtilities.*;
import Commands.*;
import CourtObjects.*;
import FileGetters.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class App extends JFrame {

    private JTextField input;
    private JTextArea output;
    private String prompt = "> ";
    private KeyListener listener;
    private String order;
    private JudgmentListCreator jlc;
    private FileGetter getter;
    private List<IJudgment> judgmentList;


    public App() {
        jlc = new JudgmentListCreator();
        getter = new FileGetter();
        setTitle("SeeYouInCourt");
        setSize(800, 600);
//        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel j = new JPanel();
        setLayout(new GridLayout(2, 1));
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);
        output = new JTextArea("");
        input = new JTextField("");
        output.setBackground(Color.BLACK);
        output.setForeground(Color.BLUE);
        input.setAlignmentY(700);
        add(output);
        add(input);
        setVisible(true);
        // add(new JButton("XDD"));
        ArrayList<String> dirs = new ArrayList<>();
        String directory = "";
        output.setText("please select directory or insert \"exit\" to exit");
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == 10) {
                    doThing(input.getText());
                    input.setText("");
                }
            }
        });
    }

    private void doThing(String line) {
        if (line.substring(0, 5).equals("load ")) {         //C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa
            line = line.substring(4);
            String[] directories = line.split(" ");
            judgmentList = jlc.buildIJudgmentsFromDirs(directories);
        }
        else {
            String[] command = line.split(" ");   //ex SA/Rz 160/02
            if (Commands.parser(command[0]) == Commands.rubrum) {
                Rubrum r = new Rubrum();
                String[] split = line.split(" ");
                String toDisplay = r.createRubrums(judgmentList, split);
                output.setText(toDisplay);
            }
            if (Commands.parser(command[0]) == Commands.regulations) {
                Regulations regs = new Regulations();
                regs.displayTop10(judgmentList);
            }
            if (Commands.parser(command[0]) == Commands.months) {
                Month month = new Month();
                output.setText(month.bouildMonthsString(judgmentList));
            }
            if (Commands.parser(command[0]) == Commands.content) {
                Content con = new Content();
                con.displayContent2(judgmentList, command);
            }
            if (Commands.parser(command[0]) == Commands.courts) {
                Courts courts = new Courts();
                courts.displayStatistics(judgmentList);
            }
            if (Commands.parser(command[0]) == Commands.judge) {
                JudgeCommand judgeCommand = new JudgeCommand();
                for (int i = 1; i < command.length; i++) {
                    judgeCommand.displayJudgeJudgments(judgmentList, command[i]);
                }
            }
            if (Commands.parser(command[0]) == Commands.judges) {
                JudgesCommand judgesCommand = new JudgesCommand();
                judgesCommand.displayTopXJudges(judgmentList, 10);
            }
            if (Commands.parser(command[0]) == Commands.WRONG) {
                Commands.displayHelp();
            }
        }
    }
}

//        directory=last;
//        while (!directory.equals("exit")){
//            dirs.add(directory);
//            directory = "exit";
//        }
//
//        output.setText(dirs.size() + " ");

//    public void displayText(){
//
//        String a = output.getText();
//        System.out.println(a);
//    }



    //    String line = input.getText();
//                    input.setText("");
//                    output.setText("pressedEnter");
//                    if (line.substring(0, 5).equals("load ")) {
//        line = line.substring(4);
//        String[] directories = line.split(" ");
//        judgmentList = jlc.buildIJudgmentsFromDirs(directories);
//    } else {
//        String[] command = line.split(" ");
//        Commands commands = Commands.parser(command[0]);
//    }

//    public String getStringFromInput(){
//
//    }


//        System.setOut(new PrintStream(new OutputStream() {
//            @Override
//            public void write(int b) throws IOException {
//                textArea.append(String.valueOf((char) b));
//            }
//        }));
//        frame.add(textArea);



