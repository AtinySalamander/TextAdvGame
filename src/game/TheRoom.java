package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TheRoom {

    private JFrame window;
    //JFrame is the top level window, with border and a title bar
    private Container container;
    private JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    private JLabel titleNameLabel, subTitleLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    private Font titleFont = new Font("Myriad Pro", Font.PLAIN, 76);
    private Font subTitleFont = new Font("Times New Roman", Font.PLAIN, 36);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    private Font choiceFont = new Font("Times New Roman", Font.PLAIN, 20);
    private JButton startButton, choice1, choice2, choice3, choice4;
    private JTextArea mainTextArea;

    int playerHP;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    //tsHandler = title screen Handler
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new TheRoom();

    }

    public TheRoom() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation EXIT_ON_CLOSE must be there for the program/app to be able to close properly
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        //have to make window visible even if it has been fully defined or else it wont show
        container = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        //x100y100 is the start point 600,150 is the size
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("THE DARK ROOM");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 150);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);

        subTitleLabel = new JLabel("Escaping from the Unknown");
        subTitleLabel.setForeground(Color.white);
        subTitleLabel.setFont(subTitleFont);

        titleNamePanel.add(subTitleLabel);
        startButtonPanel.add(startButton);

        container.add(titleNamePanel);
        container.add(startButtonPanel);
    }

    public void createGameScreen() {

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("This is where the story will be displayed to the player");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        //if text exceeds the bounds this LineWrap will keep it within the box specified
        mainTextPanel.add(mainTextArea);
        mainTextArea.setWrapStyleWord(true);
        //basically acts as hyphenate function from design programs

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(200, 350, 400, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        container.add(choiceButtonPanel);

        choice1 = new JButton("1:");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(choiceFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("2:");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(choiceFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("3:");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(choiceFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("4:");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(choiceFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        container.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();

    }

    public void playerSetup() {

        weapon = "Fist";
        weaponLabelName.setText(weapon);

        playerHP = 50;
        //gave value to my int playerHP as 50 which is the default value
        hpLabelNumber.setText("" + playerHP);

        darkRoom();

    }

    public void darkRoom() {

        position = "darkRoom";
        mainTextArea.setText("You are in a pitch black room,"
                + " the room is so dark you can't even see your hand in front of your face.\n"
                + "\n" + "What do you do?");

        choice1.setText("Feel Around for any objects");
        choice2.setText("Try Standing up");
        choice3.setText("Call out for help");
        choice4.setText("Listen out for any sounds");

    }

    public void feelObjects() {

        position = "feelObjects";
        mainTextArea.setText("You feel around, running your hands along"
                + " the damp and cold stone and to your surprise you find a sizable Kitchen Knife'");

        choice1.setText("Pick up");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void knifeInHand() {

        weapon = "Knife";
        weaponLabelName.setText(weapon);

        position = "knifeInHand";
        mainTextArea.setText("With your new weapon in hand you feel more confident for whatever lies ahead.\n"
                + "\n\n" + "You hear the distant and muffled sound of a torch flickering...");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void approachTheSound() {

        /*
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        */

        position = "approachTheSound";
        mainTextArea.setText("As you realise the presence of a new sound,"
                + "you instantly mobilise with new found determination to get out of the darkness.\n"
                + "\nYou slowly get into a crouched position ready to spring into action.");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void exitTheRoom() {

        position = "exitTheRoom";
        mainTextArea.setText("You slowly walk towards the direction of the sound carefully feeling around as you go.\n"
                + "\nAs you get closer to the source of the sound you brush up against a big wooden door with a hefty metal lock.");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void standingUp() {

        position = "standingUp";
        mainTextArea.setText("You rush to your feet only to hit your head into some heavy chains"
                + "\n\n" + "The sound of rattling chains echos throughout the room"
                + "\n" + "(You receive 5 damage)");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void checkingYourHead(){

        position = "checkingYourHead";
        mainTextArea.setText("");

        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void callingForHelp() {

        position = "darkRoom";
        mainTextArea.setText("You try shouting out to see if anyone is nearby."
        + "\n" + "Seems like nobody is responded to your calls.");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public void listenForSounds() {

        position = "darkRoom";
        mainTextArea.setText("You still you breath as you listen for any sounds...\n"
                + "\nYou notice the faint wispy sound of a torch flickering in the distance"
                + ", almost as if muffled by something");

        choice1.setText("Next");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");

    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {

                case "darkRoom":
                    switch (yourChoice) {
                        case "c1":
                            feelObjects();
                            break;
                        case "c2":
                            standingUp();
                            break;
                        case "c3":
                            callingForHelp();
                            break;
                        case "c4":
                            listenForSounds();
                            break;
                    }
                    break;

                case "feelObjects":
                    switch (yourChoice) {
                        case "c1":
                            knifeInHand();
                            break;
                        case "c2":
                            darkRoom();
                            break;
                        case "c3":
                            darkRoom();
                            break;
                        case "c4":
                            darkRoom();
                            break;
                    }
                    break;

                case "knifeInHand":
                    switch (yourChoice) {
                        case "c1":
                            approachTheSound();
                            break;
                        case "c2":
                            knifeInHand();
                            break;
                        case "c3":
                            knifeInHand();
                            break;
                        case "c4":
                            knifeInHand();
                            break;
                    }
                    break;

                case "approachTheSound":
                    switch (yourChoice){
                        case "c1":
                            exitTheRoom();
                            break;
                        case "c2":
                            approachTheSound();
                            break;
                        case "c3":
                            approachTheSound();
                            break;
                        case "c4":
                            approachTheSound();
                            break;
                    }
                    break;

                case "exitTheRoom":
                    switch (yourChoice){
                        case "c1":
                            break;
                        case "c2":
                            exitTheRoom();
                            break;
                        case "c3":
                            exitTheRoom();
                            break;
                        case "c4":
                            exitTheRoom();
                            break;
                    }
                    break;

                case "callingForHelp":
                    switch (yourChoice){
                        case "c1":
                            break;
                        case "c2":
                            callingForHelp();
                            break;
                        case "c3":
                            callingForHelp();
                            break;
                        case "c4":
                            callingForHelp();
                            break;
                    }
                    break;

                case "listenForSounds":
                    switch (yourChoice){
                        case "c1":
                            approachTheSound();
                            break;
                        case "c2":
                            listenForSounds();
                            break;
                        case "c3":
                            listenForSounds();
                            break;
                        case "c4":
                            listenForSounds();
                            break;
                    }
                    break;

                case "x":
                    switch (yourChoice){
                        case "c1":
                        case "c2":
                        case "c3":
                        case "c4":
                    }
                    break;

                case "c":
                    switch (yourChoice){
                        case "c1":
                        case "c2":
                        case "c3":
                        case "c4":
                    }
                    break;
            }

        }

    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            createGameScreen();

        }
    }

}