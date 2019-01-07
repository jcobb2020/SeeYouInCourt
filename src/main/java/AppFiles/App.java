package AppFiles;

import CollectionUtilities.*;
import Commands.*;
import CourtObjects.*;
import FileGetters.*;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.io.*;
import java.util.LinkedList;
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
    private List<String> commandsInputed;
    private int whichCommand;
    private String directoryToWrite = "";
    private boolean writeQuestionAnswered = false;
    private boolean fileMade;
    private PrintWriter writer;
    private FileWriter w;

    public App() {
        judgmentList = new LinkedList<>();
        jlc = new JudgmentListCreator();
        getter = new FileGetter();
        setTitle("SeeYouInCourt");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        JPanel outputPanel = new JPanel();
//        JPanel inputPanel = new JPanel();

        setLayout(new GridLayout(2, 1));
        setBackground(Color.BLACK);
        setForeground(Color.BLACK);
        output = new JTextArea(16, 58);
//        outputPanel.setBorder ( new TitledBorder( new EtchedBorder(), "Output" ) );
        input = new JTextField(58);
//        inputPanel.setBorder ( new TitledBorder( new EtchedBorder(), "Input" ) );

//        scroll.setBounds(10, 11, 455, 249);                     // <-- THIS
//        outputPanel.add(scroll);
//        add(outputPanel);
//        add(inputPanel);
        output.setLineWrap(true);
        add(output);
        add(input);
        JScrollPane scroll = new JScrollPane(output);
        add(scroll);
        output.setWrapStyleWord(true);
        output.setBackground(Color.BLACK);
        output.setForeground(Color.BLUE);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        commandsInputed = new LinkedList<>();
//        input.setAlignmentY(700);
//        outputPanel.add(output);
//        inputPanel.add(input);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setVisible(true);
        whichCommand = 0;

        output.setText("please select directory to build file or press enter to continue");
        input.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == 10) {
                    if (!writeQuestionAnswered) {
                        directoryToWrite = input.getText();
                        writeQuestionAnswered = true;
                        if (directoryToWrite.equals("")) {
                            fileMade = false;
                        } else {

                            File file = new File(directoryToWrite);
                            File actualFile = new File(file, "SeeYouInCourt.txt");
                            input.setText("");
                            try {
                                w = new FileWriter(actualFile);
                                writer = new PrintWriter(w);
                                output.setText("file created");
                                fileMade = true;
                            } catch (FileNotFoundException fnfe) {
                                output.setText("wrong file folder, file not created");
                                fileMade = false;
                                writeQuestionAnswered = false;
                                directoryToWrite = "";
                                fileMade = false;
                            } catch (IOException ioe) {
                                output.setText("sthWentWrong");
                                fileMade = false;
                                writeQuestionAnswered = false;
                                directoryToWrite = "";
                                fileMade = false;
                            }
                        }

                        //build file in directory
                    } else {
                        doThing(input.getText());
                        commandsInputed.add(input.getText());
                        input.setText("");
                        whichCommand = commandsInputed.size() - 1;
                    }
                }
                if (keyCode == 38) {
                    setInputTextFromHistory();
                    whichCommand--;
                    if (whichCommand < 0) {
                        whichCommand = 0;
                    }
                }
                if (keyCode == 40) {
                    whichCommand++;
                    setInputTextFromHistory();
                }
            }
        });
    }

    private void setInputTextFromHistory() {
        if (commandsInputed.size() == 0) {
            return;
        }
        if (commandsInputed.size() <= whichCommand) {
            input.setText(commandsInputed.get(commandsInputed.size() - 1));
            whichCommand = commandsInputed.size() - 1;
        }
        if (whichCommand < 0) {
            input.setText(commandsInputed.get(0));
            whichCommand = 0;
        } else {
            input.setText(commandsInputed.get(whichCommand));
        }
    }

    private void doThing(String line) {
        if (line.length() > 5 && line.substring(0, 5).equals("load ")) {         //C:/Users/JCobb/Desktop/Studia/Obiektowe/html/cbosa
            line = line.substring(4);
            String[] directories = line.split(" ");
            judgmentList.addAll(jlc.buildIJudgmentsFromDirs(directories));
        } else {
            String[] command = line.split(" ");                         //ex SA/Rz 160/02
            if (Commands.parser(command[0]) == Commands.rubrum) {
                Rubrum r = new Rubrum();
                String[] split = line.split(" ");
                String result = r.createRubrums(judgmentList, split);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.regulations) {
                Regulations regs = new Regulations();
                String result = regs.buildTop10(judgmentList);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.months) {
                Month month = new Month();
                String result = month.bouildMonthsString(judgmentList);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.content) {
                Content con = new Content();
                String result = con.buildContent(judgmentList, command);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.courts) {
                Courts courts = new Courts();
                String result = courts.buildStatistics(judgmentList);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }

            }
            if (Commands.parser(command[0]) == Commands.judge) {            //Marian Ekiert
                JudgeCommand judgeCommand = new JudgeCommand();
                String result = judgeCommand.buildJudgeJudgements(judgmentList, command);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.judges) {
                JudgesCommand judgesCommand = new JudgesCommand();
                String result = judgesCommand.displayTopXJudges(judgmentList, 10);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }

            }
            if (Commands.parser(command[0]) == Commands.jury) {
                Jury jury = new Jury();
                String result = jury.displayJuryNumber(judgmentList);
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                    writer.close();
                }

            }
            if (Commands.parser(command[0]) == Commands.WRONG) {
                String result = Commands.generateHelp();
                output.setText(result);
                if (fileMade) {
                    writer.println(result + "\n");
                }
            }
            if (Commands.parser(command[0]) == Commands.save) {
                if (fileMade) {
                    writer.close();

                }
                System.exit(0);
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



