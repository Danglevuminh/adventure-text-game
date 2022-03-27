package TextGame;



import java.awt.Color; //Imports colors

import java.awt.Container; //Import container

import java.awt.Font; //Import Fonts

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton; //Imports JButton

import javax.swing.JFrame; //Import JFrame

import javax.swing.JPanel; //Import JPanel

import javax.swing.JTextArea; //Import Text Area
import javax.swing.JTextField;
import javax.swing.JLabel; //Import JLabel


public class TextGame{        //Classes are created in this public class
	Container cont;
	JFrame myWindow;
	JPanel titleNamePanel, startButtonPanel, storyTextPanel, choiceButtonPanel1, choiceButtonPanel2,  statusPanel, inputPanel;//Panels
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	JButton startButton, choice1, choice2, choice3, choice4, choice5, choice6, codeEnterButton;
	JTextArea storyText;
	Font fontStoryText = new Font("Tahoma", Font.PLAIN, 28); //Font for story texts
	Font fontChoicesText = new Font("Times", Font.PLAIN, 26);//Font for choices
	Font fontStatus = new Font ("Garamond", Font.BOLD, 34); //Font for player status
	Font normalText = new Font ("Garamond", Font.BOLD, 54); //Set the font for the startButton
	Font titleFont = new Font ("Georgia", Font.PLAIN, 100); //Set the font for the title and narrative
	JTextField codeInsertField;
	int goldenKey, doorOpened;
	codeInputHandler inputHandler = new codeInputHandler ();
	
	
	
	TitleScreenHandler tsHandler = new TitleScreenHandler (); //Set the usage for start Button
	choiceHandler choiceHandler = new choiceHandler ();
	 
	
	 
	 GraphicsDevice gDevice;
	int playerHP;
	String playerWeapon, position;
	
	//Scanner for user input for the pinpad
	Scanner scanner = new Scanner (System.in);
	

	public static void main(String[] args) {
		
		new TextGame();
		
		}
		public TextGame(){                     // This constructor is used to load up the initial starting screen for the game
			GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
			gDevice = gEnvironment.getDefaultScreenDevice(); //Allows your graphicsDevice to access the monitor. DefaultScreenDevice usually indicates the monitor.
			
			
			
			//Window
			myWindow = new  JFrame ();
			myWindow.setSize(1000, 750);
			myWindow. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			myWindow.getContentPane().setBackground(Color.black);
			myWindow.setLayout(null);
			myWindow.setVisible (true);
			cont = myWindow.getContentPane();
		
		
			
			
			//Title Name
			titleNamePanel = new JPanel(); //This class now has an object name titleNamPanel
			titleNamePanel.setBackground(Color.black);
			titleNamePanel.setBounds (125, 150, 750, 150);
			titleNameLabel = new JLabel("DISTORTION");
			titleNameLabel.setForeground(Color.white);
			titleNameLabel.setFont(titleFont);
			
			
			//Start Button Panel
			startButtonPanel = new JPanel ();
			startButtonPanel.setBounds (350, 400, 250, 200);
			startButtonPanel.setBackground (Color.black);
			startButtonPanel.setLayout (new GridLayout (2,1));
			
			
			//Start Button
			startButton = new JButton ("Start");
			startButton.setBackground(Color.black);
			startButton.setForeground(Color.white);
			startButton.setFont(normalText);
			startButton.addActionListener(tsHandler);
			startButton.setFocusPainted (false);
			startButton.setBorder(null);
			
			//Quit Button
			JButton quitButton = new JButton ("Quit");
			quitButton.setBackground(Color.black);
			quitButton.setForeground(Color.white);
			quitButton.setFont(normalText);
			quitButton.setFocusPainted (false);
			quitButton.setBorder (null);
			quitButton.addActionListener(
					  new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					     System.exit(0);
					    }
					  }
					);
			
			
			
			//Panels
			
			titleNamePanel.add(titleNameLabel);
			startButtonPanel.add(startButton);
			startButtonPanel.add(quitButton);
			
			
			cont.add (titleNamePanel);
			cont.add(startButtonPanel);
			
			
	
				

		}
		//setFullScreen();
	
		public void setFullScreen () {
			gDevice.setFullScreenWindow(myWindow);
		}
		
		//Game Screen for gameplay - ACT I
		public void createGameScreen() {
			//Disabling the title screen and start Button
			titleNamePanel.setVisible (false);
			startButtonPanel.setVisible (false);
			
			
			storyTextPanel = new JPanel ();
			storyTextPanel.setBounds (100,100,800,250);
			storyTextPanel.setBackground (Color.black);
			cont.add(storyTextPanel);
			
			//Text Area
			storyText = new JTextArea ();
			storyText.setBounds(100,100, 800, 200);
			storyText.setBackground(Color.black);
			storyText.setForeground(Color.white);
			storyText.setFont(fontStoryText);
			storyText.setLineWrap(true);
			storyTextPanel.add(storyText);
			
			
			//Choice Panel and Layout
			choiceButtonPanel1 = new JPanel (); 
			choiceButtonPanel1.setBounds(100, 400, 350,250 );
			choiceButtonPanel1.setForeground(Color.white);
			choiceButtonPanel1.setBackground(Color.black);
			choiceButtonPanel1.setLayout(new GridLayout(3,1));
			cont.add(choiceButtonPanel1);
			
			choiceButtonPanel2 = new JPanel (); 
			choiceButtonPanel2.setBounds(550, 400, 350,250 );
			choiceButtonPanel2.setForeground(Color.white);
			choiceButtonPanel2.setBackground(Color.black);
			choiceButtonPanel2.setLayout(new GridLayout(3,1));
			cont.add(choiceButtonPanel2);
			
			
		
			//Choice Buttons
		
			//Choice1
			choice1 = new JButton ("Choice 1");
			choice1.setBackground(Color.black);
			choice1.setForeground(Color.white);
			choice1.setFont(fontChoicesText);
			choiceButtonPanel1.add(choice1);
			choice1.setFocusPainted(false);
			choice1.addActionListener(choiceHandler);
			choice1.setActionCommand("c1");
			
			//Choice 2
			choice2 = new JButton ("Choice 2");
			choice2.setBackground(Color.black);
			choice2.setForeground(Color.white);
			choice2.setFont(fontChoicesText);
			choiceButtonPanel1.add(choice2);
			choice2.setFocusPainted(false);
			choice2.addActionListener (choiceHandler);
			choice2.setActionCommand("c2");
			
			//Choice 3
			choice3 = new JButton ("Choice 3");
			choice3.setBackground(Color.black);
			choice3.setForeground(Color.white);
			choice3.setFont(fontChoicesText);
			choiceButtonPanel1.add(choice3);
			choice3.setFocusPainted(false);
			choice3.addActionListener (choiceHandler);
			choice3.setActionCommand("c3");
		
			//Choice 4
			choice4 = new JButton ("Choice 4");
			choice4.setBackground(Color.black);
			choice4.setForeground(Color.white);
			choice4.setFont(fontChoicesText);
			choiceButtonPanel2.add(choice4);
			choice4.setFocusPainted(false);
			choice4.addActionListener (choiceHandler);
			choice4.setActionCommand("c4");
			
			//Choice 5
			choice5 = new JButton ("Choice 5");
			choice5.setBackground(Color.black);
			choice5.setForeground(Color.white);
			choice5.setFont(fontChoicesText);
			choiceButtonPanel2.add(choice5);
			choice5.setFocusPainted(false);
			choice5.addActionListener (choiceHandler);
			choice5.setActionCommand("c5");
			
			
			//Choice 6
			choice6 = new JButton ("Choice 6");
			choice6.setBackground(Color.black);
			choice6.setForeground(Color.white);
			choice6.setFont(fontChoicesText);
			choiceButtonPanel2.add(choice6);
			choice6.setFocusPainted(false);
			choice6.addActionListener (choiceHandler);
			choice6.setActionCommand("c6");
			
			
			//Player Status Panel
			statusPanel = new JPanel();
			statusPanel.setBounds(100,15,800,50);
			statusPanel.setBackground(Color.black);
			statusPanel.setLayout(new GridLayout (1,4));
			statusPanel.setVisible (true);
			cont.add(statusPanel); 
			
			
			//HP Label
			hpLabel = new JLabel ("HP:");
			hpLabel.setFont (fontStatus);
			hpLabel.setForeground (Color.white);
			statusPanel.add(hpLabel);
			
			
			//Stats for HP
			hpLabelNumber = new JLabel ();
			hpLabelNumber.setFont(fontStatus);
			hpLabelNumber.setForeground(Color.white);
			statusPanel.add(hpLabelNumber);
			
			
			//Weapons Panel
			weaponLabel = new JLabel ("Weapon: ");
			weaponLabel.setFont(fontStatus);
			weaponLabel.setForeground (Color.white);
			statusPanel.add(weaponLabel);
			
			
			//Weapon Name Display
			weaponLabelName = new JLabel ();
			weaponLabelName.setFont(fontStatus);
			weaponLabelName.setForeground(Color.white);
			statusPanel.add(weaponLabelName);
			
			
		
			
			
			//After the code above executes, the playerSetUp method will then be executed.
			playerSetUp();
 			
			
			
		}
		
		public void playerSetUp () {
			//Sets the HP and weapon type for the player
			playerHP = 20;
			playerWeapon = "";
			weaponLabelName.setText("");
			hpLabelNumber.setText(""+playerHP);
			
			
		//Opening a metal door. First scene.	
			metalDoor();
			
		}
		//Metal Door position
		
		public void metalDoor () {
			position = "metalDoor";
			storyText.setText("You woke up in a bed in nowhere. You have no memory. \nThere is a metal door in front of you. \n\nWhat would you like to do?");
			choice1.setText ("Open the metal door");
			choice2.setText("Examine door");
			choice3.setText("Call for help");
			choice4.setText ("Look around");
			choice5.setText ("Search your pockets");
			choice6.setText("Search the bed");
		}
		//Opening the metal door position
		
		public void openDoor () {
			position = "openDoor";
			storyText.setText("You turn the rusty doorknob, but to no avail.\nThe door is locked.");
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
		}
		//Calling for help position
		
		public void callHelp () {
			position = "callHelp";
			storyText.setText("You shouted desperately into the air but you received no replies from the other side.");
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
		}
		//Standing in the middle of the room position
		
		public void standingUp () {
			position = "standingUp";
			storyText.setText("You stand in the middle of the room.\nThere is a metal door in front of you. \nWhat would you like to do?");
			choice1.setText ("Open the metal door");
			choice2.setText("Examine door");
			choice3.setText("Call for help");
			choice4.setText ("Look around");
			choice5.setText ("Search your pockets");
			choice6.setText("Search the bed");
			choice1.setVisible (true);
			choice2.setVisible (true);
			choice3.setVisible (true);
			choice4.setVisible (true);
			choice5.setVisible (true);
			choice6.setVisible (true);
			
			
			
			
			if (doorOpened==1) {
				storyText.setText ("You stand in the middle of room. \n The metal door can now be opened. \nWhat would you like to do?");
			}
		
			}
		//For door solved problem
		public void standingUpDoorOpened () {
			position = "standingUpDoorOpened";
			storyText.setText("You turned the knob and the door creeks open. \n You walked out and stood in the dark hallway. What would you like to do?");
			choice1.setText ("Look around");
			choice2.setText("Go right");
			choice3.setText("Go left");
			choice4.setText ("Go back to the room");
			choice5.setText ("");
			choice6.setText("");
			choice1.setVisible (true);
			choice2.setVisible (true);
			choice3.setVisible (true);
			choice4.setVisible (true);
			choice5.setVisible (true);
			choice6.setVisible (true);
			
			}
		//Examining the door position
		public void examineDoor() {
			position = "examineDoor";
			storyText.setText("You take a careful look at the heavy metal door and noticed \nthat there is a big keyhole. What would you like to do?");
			choice1.setText ("Peek through the keyhole");
			choice2.setText("Go back");
			choice3.setText ("");
			choice4.setText("Open the door with the key");	
			choice5.setText("");
			choice6.setText("");
			
		}
		//Peeking the keyhole position
		
		public void peekKeyHole () {
			position = "peekKeyHole";
			storyText.setText("\nYou move closer and peek through the keyhole but you are \nunable to see anything. \n\nThe other side seems to be filled with darkness.");
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
			
		}
		public void openDoorWithKey() {
			position = "openDoorWithKey";
			storyText.setText ("You inserted the key into the keyhole and turns the key. You \nhear a \"creak\" sound. The door is now to ready to be opened. ");
			
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
			
			doorOpened = 1;
		}
		public void openDoorWithNoKey () {
			position = "openDoorWithNoKey";
			storyText.setText("You have no keys to insert into the keyhole.");
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
		}
		public void attackMonster () {
			position = "attackMonster";
			storyText.setText("You attacked the monster. It screams in pain." );
			choice2.setText("");
			choice2.setText("");
			choice2.setText("");
			choice2.setText("");
			choice2.setText("");
			choice2.setText("");
		}
		//Searching through the pockets position
		
		public void searchPockets () {
			position = "searchPockets";
			storyText.setText("You search through your pockets and found a dull pocket knife. \n\n You are not quite sure how you got it but it will surely come in handy. [Obtained: Dull Pocket Knife]");
			choice1.setText("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
		}
		public void searchBed () {
			position = "searchBed";
			storyText.setText("You looked under your pillow. There is a small black box with a key in it and a pinpad consisting of letters with 4 slots. It seems like you must insert some code. ");
			choice1.setText("Insert the code");
			choice2.setText("Go back");
			choice3.setText("");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
			
			if (goldenKey ==1) {
				storyText.setText("You searched the bed but there is nothing left here.");
				choice1.setText("");
				choice2.setText("Go back");
				
				
			}
		}
		//Insert panels for code answer
		public void insertCode () {
			position = "insertCode";
			storyText.setText("Type the code into the area below");
			//For the code field
			inputPanel = new JPanel();
			inputPanel.setBounds(150, 450, 500, 50);
			inputPanel.setBackground(Color.black);
			inputPanel.setLayout (new GridLayout (1,2));
			inputPanel.setVisible(true);
			
			codeInsertField = new JTextField ();
			inputPanel.add(codeInsertField);
			
			//For the Enter Button
			codeEnterButton = new JButton ("ENTER");
			codeEnterButton.setForeground(Color.black);
			codeEnterButton.addActionListener(inputHandler);
			inputPanel.add(codeEnterButton);
			
		
			
			cont.add (inputPanel);
			choice1.setText("");
			choice2.setText("");
			choice3.setText("Go back");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
			
			choice1.setVisible (false);
			choice2.setVisible (false);
			choice3.setVisible (true);
			choice4.setVisible (false);
			choice5.setVisible (false);
			choice6.setVisible (false);
			
			
				
			
			
			
			
			
		}
		public void boxOpened () {
			position =  "boxOpened";
			storyText.setText("A \"beep\" sound occurs and the box lid sprang open. You take \nhold of the key. It seems like you would be able to open the \ndoor with this. [Obtained: Key]");
			choice1.setText("");
			choice2.setText("");
			choice3.setText("Go back");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
			
			
			
			codeInsertField.setVisible (false);
			inputPanel.setVisible(false);
			codeEnterButton.setVisible(false);
			
			
			goldenKey = 1;
		}
		public void boxUnopened () {
			position ="boxUnopened";
			storyText.setText("The box rattled but nothing happened. It seems like the wrong code was inserted");
			choice1.setText("");
			choice2.setText("");
			choice3.setText("Go back");
			choice4.setText("");
			choice5.setText("");
			choice6.setText("");
			
			
			
			codeInsertField.setVisible (false);
			inputPanel.setVisible(false);
			codeEnterButton.setVisible(false);
			
		}
		public void lookAround () {
			position = "lookAround";
			storyText.setText("Taking a look through the room, you noticed a baseball bat lying on top of a table with a torn out piece of note nearby. \nWhat would you like to do? ");
			choice1.setText("Take the baseball bat");
			choice2.setText("Go back");
			choice3.setText("");
			choice4.setText("Read the note");
			choice5.setText("");
			choice6.setText("");
			if (playerWeapon == "Baseball bat") {
				choice1.setText("");
				storyText.setText("There is a torn out piece of note. What would you like to do?");
			}
		
		}
		public void baseballBat () {
			position = "baseballBat";
			storyText.setText ("The baseball is rusty and covered with dust. Would you like to \ntake it?");
			choice1.setText ("Yes");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("No");
			choice5.setText ("");
			choice6.setText("");
	
		}		
		public void yesBaseball () {
			position = "yesBaseball";
			storyText.setText ("You held the baseball bat in your hand and quickly clean off the dust. The baseball bat is now usable for combat. \n[Obtained weapon: Baseball bat]");
			playerWeapon = "Baseball bat";
			weaponLabelName.setText(playerWeapon);
			choice1.setText ("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
		}
		public void readNote () {
			position = "readNote";
			storyText.setText ("You held the piece of note in your hands and read its contents:");
			choice1.setText (" ==>");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
		}
		public void readNote2 () {
			position = "readNote2";
			storyText.setText("\"Welcome to our expriement, GAME. You have been very lucky to be our chosen test subject. Your first test lies beyond this \nroom.\n\n Regards,\n Boss\"");
			choice1.setText ("==>");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
		}
		public void readNote3() {
			position = "readNote3";
			storyText.setText ("Confused and startled, you left the note back in its place and \nwonder what is going on on the other side of the door. ");
			choice1.setText("Go back");
			choice2.setText("");
			choice3.setText("");
			choice4.setText ("");
			choice5.setText ("");
			choice6.setText("");
			
		}
		//Handler for code insert
		class codeInputHandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
			String code = codeInsertField.getText ();
			
			if (code.equals ("GAME")) {
				boxOpened ();
				
				
			}
			else {
				boxUnopened ();
			}
			}	
	
		
			
		}
		//Start button
		
		public class TitleScreenHandler implements ActionListener {

			
			public void actionPerformed(ActionEvent event) {
				
				createGameScreen();
				
			 
			}
			
		}
		
	
		//Set the events for the positions in the game
		public class choiceHandler implements ActionListener {
			
			public void actionPerformed (ActionEvent event) {
				String playerChoice = event.getActionCommand (); //receives and return the value from the buttons. If you click button 1, then "c1" will be put into the playerChoice String. Recognize what buttons that are being clicked. 
				
				
				switch (position) {
				case "metalDoor":
					switch (playerChoice) {
					case "c1": if (doorOpened==1) {
						standingUpDoorOpened ();
					}else {
						openDoor ();
					}
					;
					break;
					case "c2": examineDoor ();break;
					case "c3": callHelp ();break;
					case "c4": lookAround ();break;
					case "c5": searchPockets (); break;
					case "c6": searchBed (); break;
					}
					break;
					
				case "openDoor":
					switch(playerChoice) {
					case "c1": standingUp (); break;
					}
				break;
				case "examineDoor":
					switch (playerChoice) {
					case "c1": peekKeyHole (); break;
					case "c2": standingUp (); break;
					case "c4":  if (goldenKey==1) {
						openDoorWithKey ();
					}else {
						openDoorWithNoKey ();
					}
				
					}
					break;
				case "peekKeyHole":
					switch (playerChoice) {
					case "c1": standingUp (); break;
					}
					break;
				case "standingUp":
					switch (playerChoice) {
					case "c1": openDoor (); break;
					case "c2": examineDoor ();break;
					case "c3": callHelp ();break;
					case "c4": lookAround ();break;
					case "c5": searchPockets (); break;
					case "c6": searchBed (); break;
					}
					break;
				case "callHelp":
					switch (playerChoice) {
					case "c1": standingUp (); break;
					}
					break;
				case "lookAround":
					switch (playerChoice) {
					case "c1": baseballBat(); break;
					case "c4": readNote();break;
					case "c2": standingUp(); break;
					}
					break;
				case "baseballBat":
					switch (playerChoice) {
					case "c1": yesBaseball(); break;
					case "c4": standingUp (); break;
					
					}
					break;
				case "yesBaseball":
				switch (playerChoice) {
				case "c1": lookAround (); break;
				
				}
				break;
				case "readNote":
					switch (playerChoice) {
					case "c1": readNote2(); break;
					}
					break;
				case "readNote2":
					switch (playerChoice) {
					case "c1": readNote3 (); break;
					}
					break;
				case "readNote3":
					switch (playerChoice) {
					case "c1": standingUp (); break;
					}
					break;
				case "searchBed":
					switch (playerChoice) {
					case "c1": insertCode (); break;
					case "c2": standingUp (); break;
					
					}
					break;
				case "smashBox":
					switch (playerChoice) {
					case "c1": searchBed ();break;
					}
					break;
				case "searchPockets":
					switch (playerChoice) {
					case "c1": standingUp (); break;
				
					}
					break;
				case "insertCode":
					switch (playerChoice) {
					case "c3": searchBed (); break;
					}
					break;
				case "boxOpened":
					switch (playerChoice) {
					case "c3": standingUp (); break;
					}
					break;
				case "boxUnopened":
					switch (playerChoice) {
					case "c3": standingUp (); break;
					}
				
					break;
				case "openDoorWithNoKey":
					switch (playerChoice) {
					case "c1": standingUp (); break;
					}
					break;
				case "openDoorWithKey":
					switch (playerChoice) {
					case "c1": standingUpDoorOpened (); break;
					}
			}
				
				
		
			}
		}
}



