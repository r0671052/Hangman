package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	private JLabel alfabet;
	
	private TekenVenster tekenVenster;
	private HangMan spel;
	private String titel;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		titel = spel.getSpeler().getNaam()+" - Hangman";
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		alfabet = new JLabel("");
		woord = new JLabel("");
		this.setLayout(new BorderLayout());
		this.add(alfabet, BorderLayout.NORTH);
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		spel.resetGame();
		alfabet.setText("Geraden letters:"+getSpel().getAlfabet());
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
		
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
				String input = letter.getText();
				char guess = '\u0000';
				if(input.length() > 0){
					guess = input.charAt(0);
				}
				spel.raad(guess);
				alfabet.setText("Geraden letters: "+getSpel().getAlfabet());
				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();
				
				if(spel.isGewonnen()){
					spel.getSpeler().addToScore(spel.getTekening().getAantalOnzichtbaar());
					JOptionPane.showConfirmDialog(null,"Proficiat, u heeft gewonnen!\nU heeft "+spel.getSpeler().getScore()+" punten", titel, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
					gameFinished();
				}
				else if(spel.isGameOver()){
					JOptionPane.showConfirmDialog(null,"Helaas, u heeft verloren :/\nHet woord was:"+spel.getWoord()+"\nU heeft "+spel.getSpeler().getScore()+" punten", titel,JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
					gameFinished();
				}
				
				
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
	 private void gameFinished(){
		 int n = JOptionPane.showConfirmDialog(null, "Wilt u nog eens spelen?", titel, JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION){
				reset();
		      }
		      else{
		          System.exit(0);	
		      }
	 }

}