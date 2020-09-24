package com.mycompany.myapp;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import java.lang.String;

public class Game extends Form{

	private GameWorld gw;
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}
	
	private void play()
	{
		Label myLabel=new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener(){
		boolean wantToExit = false;
			
			public void actionPerformed(ActionEvent evt) {
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() != 0)
					switch (sCommand.charAt(0)) {
					case 'x':
						
						myLabel.setText("Exit? y/n");
						wantToExit = true;
						break;
						
					case'y':
						if(wantToExit == true)
						gw.exit();
						break;
					case 'n':
						wantToExit = false;
						myLabel.setText("Enter a Command:");
						break;
					//add code to handle rest of the commands
					case 'a':
						System.out.println("");
						break;
						
					case 'b':
						System.out.println("");
						break;
					case 'l':
						System.out.println("");
						break;
					case 'r':
						System.out.println("");
						break;
					case 'c':
						System.out.println("");
						break;
					case 'e':
						System.out.println("");
						break;
					case 'g':
						System.out.println("");
						break;
					case 't':
						System.out.println("");
						break;
					case 'd':
						System.out.println("");
						break;
					case 'm':
						System.out.println("");
						break;
						
						
						
					} //switch
			} //actionPerformed
		} //new ActionListener()
		); //addActionListener
	} //play
}
