/*
 * Denis Bernovschi
 * 4AIN
 * Gioco dell'oca
 * 26/04/2015
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * The Class Main.
 *
 * @author Denis Bernovschi
 * @date 01/04/2015
 * The Class Main.
 */
public class Main{
	/** The partita. */
	private static Gioco partita = new Gioco (null , null);
	/**
	 * The main method.
	 *
	 * @param v the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] v) throws IOException {
		String nomeGiocatore1 = null  ;
		String nomeGiocatore2 = null ;
		
		int  n = JOptionPane.showConfirmDialog(null,"Vuoi riprendere la partita salvata ?","deserializzazione",JOptionPane.YES_NO_OPTION);
		
		if(n == 0){
            JOptionPane.showMessageDialog(null, "SISTEMA : Verifico la partita salvata");
            try{            	 
            	 partita = partita.ricaricaPartita();
            	 nomeGiocatore1 = partita.getNomeGiocatore1();
            	 JOptionPane.showMessageDialog(null , "Giocatore 1 : "+nomeGiocatore1);
            	 nomeGiocatore2 = partita.getNomeGiocatore2();
            	 JOptionPane.showMessageDialog(null ,"Giocatore 2 : "+nomeGiocatore2);
            	          	 
            }
            catch(IOException e){
            	JOptionPane.showMessageDialog(null, "nessuna partita salvata");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "SISTEMA : Hai scelto una nuova partita");
            JOptionPane.showMessageDialog(null, "SISTEMA : Inserisci i nomi dei 2 giocatori ");
            nomeGiocatore1 = JOptionPane.showInputDialog("Inserisci il nome del giocatore 1", nomeGiocatore1);
            nomeGiocatore2 = JOptionPane.showInputDialog("Inserisci il nome del giocatore 2" , nomeGiocatore2);
            JOptionPane.showMessageDialog(null ,"Giocatore 1 : "+nomeGiocatore1);
            JOptionPane.showMessageDialog(null ,"Giocatore 2 : "+nomeGiocatore2);
            partita = new Gioco(nomeGiocatore1 , nomeGiocatore2);
        }
		Menu menuGioco = new Menu(partita );
		MyFrame frame = new MyFrame("GIOCO DELL'OCA" , partita , menuGioco);
    	Container c = frame.getContentPane(); 
    	c.add(menuGioco , BorderLayout.CENTER);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    	frame.setVisible(true);
    } 
}
