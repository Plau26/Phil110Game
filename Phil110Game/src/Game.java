import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, locationLabel, locationLabelText;
	Font titleFont = new Font("Times New Roman", Font.BOLD, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 70);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	String location, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {
		
		new Game();
	}
	
	public Game() {
		
		window = new JFrame();
		window.setSize(1920, 1080); //width x height
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setTitle("Philosophy 110 game :-)");
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 1720, 200); // x,y,width,height
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("BYU PHILOSOPHY ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(760, 700, 400, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		window.setVisible(true);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(200, 200, 1520, 400);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Test for text.");
		mainTextArea.setBounds(200, 200, 1520, 400);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(400, 600, 1120, 300);
		choiceButtonPanel.setBackground(Color.red);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(400, 50, 1120, 100);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,2));
		con.add(playerPanel);
		
		locationLabel = new JLabel("Current location: ");
		locationLabel.setFont(normalFont);
		locationLabel.setForeground(Color.white);
		playerPanel.add(locationLabel);
		
		locationLabelText = new JLabel();
		locationLabelText.setFont(normalFont);
		locationLabelText.setForeground(Color.white);
		playerPanel.add(locationLabelText);
		
		playerSetup();
	}
	
	public void playerSetup() {
		location = "Home";
		locationLabelText.setText(location);
		
		starterLocation();
	}
	
	
	public void starterLocation() {
		mainTextArea.setText("You are a BYU student at your home. \nIt is Friday morning, and you have class in an hour. \nWhat do you do?");
		position = "starterLocation";
		
		choice1.setText("Go to class");
		choice2.setText("Go back to sleep");
		choice3.setText("Go to the gym");
		choice4.setText("Absolutely nothing");
	}
	
	public void sleep() {
		mainTextArea.setText("You go back to sleep. You wake up in the evening.");
		position = "sleep";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void gym() {
		mainTextArea.setText("You go to the gym. However, the guy next to you \nis lifting more than you've ever tried. \nDo you lift what you're comfortable with, or ego lift?");
		position = "gym";
		
		location = "Gym";
		locationLabelText.setText(location);
		
		choice1.setText("Lift a reasonable amount");
		choice2.setText("Potentially kill yourself");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void gymGood() {
		mainTextArea.setText("Like Aurelius, you are not fazed by external issues. \nYou have a good quick workout and get to your \nnext class in time.");
		position = "gymGood";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void gymBad() {
		mainTextArea.setText("You try to hit a 300 lb bench press to show him up. \nYou fail immediately, and the guy comes over to help you. You go home in shame.");
		position = "gymBad";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void whyCare() {
		mainTextArea.setText("You don't do anything, you just sit there and waste \nyour time for some reason. You go to class after a \nlittle while.");
		position = "whyCare";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void goToClass() {
		mainTextArea.setText("You decide to get ready for the day and go to class. \nDo you pay attention or screw around?");
		position = "goToClass";
		
		location = "Class";
		locationLabelText.setText(location);
		
		choice1.setText("Pay attention");
		choice2.setText("Slack off");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void payAttentionClass() {
		mainTextArea.setText("You figure that you should pay attention in class.\nAfter all, like Simone Weil said, education is \nthe path to sanctity.");
		position = "payAttentionClass";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void slackOffClass() {
		mainTextArea.setText("You decide to stay in Plato's cave today. \nInstead of paying attention, you look at your phone \nand doodle on your paper.");
		position = "slackOffClass";
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void afterClass() {
		mainTextArea.setText("Your class has finished. \nWhat do you feel like doing now?");
		position = "afterClass";
		
		location = "Outside Class";
		locationLabelText.setText(location);
		
		choice1.setText("Go home and study");
		choice2.setText("Go to the gym");
		choice3.setText("Wander around aimlessly");
		choice4.setText("");
	}
	
	public void homeStudy() {
		mainTextArea.setText("You go home and study, like the good student you are.");
		position = "homeStudy";
		
		location = "Home";
		locationLabelText.setText(location);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void aimlessWander() {
		mainTextArea.setText("You wander around Provo aimlessly. \nWhy are you doing this?");
		position = "aimlessWander";
		
		location = "Provo, somewhere";
		locationLabelText.setText(location);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void eveningEvent() {
		mainTextArea.setText("It is the evening, and you are home.\nWhat do you want to do now?\nGoing to bed will end the game.");
		position = "eveningEvent";
		
		location = "Home";
		locationLabelText.setText(location);
		
		choice1.setText("Hang out with friends");
		choice2.setText("Wander aimlessly");
		choice3.setText("Play video games");
		choice4.setText("Go to bed");
	}
	
	public void videoGames() {
		mainTextArea.setText("You decide to stay home and play video games. \nIt isn't particularly enlightening, but you have fun.");
		position = "videoGames";
		
		location = "Home";
		locationLabelText.setText(location);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void friendHangout() {
		mainTextArea.setText("You go out with your friends and have a good time.");
		position = "friendHangout";
		
		location = "Out with friends";
		locationLabelText.setText(location);
		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void nightTime() {
		mainTextArea.setText("It is now night time. What do you want to do?\nGoing to bed will end the game.");
		position = "nightTime";
		
		location = "Home";
		locationLabelText.setText(location);
		
		choice1.setText("Ponder life");
		choice2.setText("Get some work done");
		choice3.setText("Relax");
		choice4.setText("Go to bed");
	}
	
	public void ponderLife() {
		mainTextArea.setText("You lay down and ponder your life for a bit.\nHow did you get here? Why are you here?\nWas Nietzsche was right? \nIs there a meaning to anything?");
		position = "ponderLife";

		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	public void doWork() {
		mainTextArea.setText("You get on your laptop and do some work remotely \nfor your job. It isn't engaging or stimulating, \nbut you do get paid for it.");
		position = "doWork";

		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	
	public void relax() {
		mainTextArea.setText("You relax after a long day. After all, life is too short \nto always be doing something.");
		position = "relax";

		
		choice1.setText(">");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	
	
	public void endScreen() {
		mainTextArea.setText("The end. Why did you play this game? \nWhat did you learn? Does it matter? \nNot really. All choices lead to the same path. \nMaybe the meaning of this is what you want it to be.");
		position = "endScreen";
		
		location = "Existential Dread";
		locationLabelText.setText(location);
		
		choice1.setText("Restart");
		choice2.setText("Restart");
		choice3.setText("Restart");
		choice4.setText("Restart");
	}
	
	
	public class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
		
	}
	
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand();
			System.out.print(yourChoice); //Prints out the button pressed
			System.out.print("\n"); //then a newline for visibility
			switch(position) {
			case "starterLocation":
				switch(yourChoice) {
					case "c1": goToClass(); break;
					case "c2": sleep(); break;
					case "c3": gym(); break;
					case "c4": whyCare(); break;
				}
				break;
			case "sleep": //transition state
				switch(yourChoice) {
					case "c1": eveningEvent(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "gym":
				switch(yourChoice) {
					case "c1": gymGood(); break;
					case "c2": gymBad(); break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "gymGood": //transition state
				switch(yourChoice) {
					case "c1": goToClass(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "gymBad": //transition state
				switch(yourChoice) {
					case "c1": eveningEvent(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "whyCare":
				switch(yourChoice) {
					case "c1": goToClass(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "goToClass": //when in class
				switch(yourChoice) {
					case "c1": payAttentionClass(); break;
					case "c2": slackOffClass(); break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "payAttentionClass": //transition state
				switch(yourChoice) {
					case "c1": afterClass(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "slackOffClass": //transition state
				switch(yourChoice) {
					case "c1": afterClass(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "afterClass":
				switch(yourChoice) {
					case "c1": homeStudy(); break;
					case "c2": gym(); break;
					case "c3": aimlessWander(); break;
					case "c4": break;
				}
				break;
			case "homeStudy":
				switch(yourChoice) {
					case "c1": eveningEvent(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "aimlessWander":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "videoGames":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "friendHangout":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "eveningEvent":
				switch(yourChoice) {
					case "c1": friendHangout(); break;
					case "c2": aimlessWander(); break;
					case "c3": videoGames(); break;
					case "c4": endScreen(); break;
				}
				break;
			case "nightTime":
				switch(yourChoice) {
					case "c1": ponderLife(); break;
					case "c2": doWork(); break;
					case "c3": relax(); break;
					case "c4": endScreen(); break;
				}
				break;
			case "ponderLife":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "doWork":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "relax":
				switch(yourChoice) {
					case "c1": nightTime(); break;
					case "c2": break;
					case "c3": break;
					case "c4": break;
				}
				break;
			case "endScreen":
				switch(yourChoice) {
					case "c1": playerSetup(); break;
					case "c2": playerSetup(); break;
					case "c3": playerSetup(); break;
					case "c4": playerSetup(); break;
				}
				break;
			}
			
		}
	}

}

