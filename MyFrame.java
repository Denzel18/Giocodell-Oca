/*
 * Denis Bernovschi
 * 4AIN
 * Gioco dell'oca
 * 26/04/2015
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * The Class MyFrame.
 */
public class MyFrame extends JFrame implements ActionListener{
	/** the panel */
	Menu panel = null ;

	/** The exit icon. */
	ImageIcon exitIcon = new ImageIcon ("exit.png");
	
	/** The manuale. */
	ImageIcon manuale = new ImageIcon ("manuale.png");
	
	/** The file. */
	ImageIcon file = new ImageIcon ("file.png");
	
	/** The binario. */
	ImageIcon binario = new ImageIcon ("binario.png");
	
	/** The partita. */
	private Gioco partita ;
	
	/** The menu bar. */
	private JMenuBar menuBar;
	
	/** The menu gioco. */
	private JMenu menuGioco;
	
	/** The salva su file. */
	private JMenuItem salvaSuFile;
	
	/** The leggi da file. */
	private JMenuItem leggiDaFile;
	
	/** The istruzioni. */
	private JMenuItem istruzioni;
	
	/** The serializzazione. */
	private JMenuItem serializzazione;
	
	/** The deserializzazione. */
	private JMenuItem deserializzazione ;
	
	/** The exit. */
	private JMenuItem exit ;
	
	
	private JMenu prova;
	/**
	 * Instantiates a new my frame.
	 *
	 * @param titolo the titolo
	 * @param p the partita
	 */
	public MyFrame(String titolo , Gioco p , Menu menu  ) {
		super(titolo);
		//Gioco 
		partita = p ;
		
		//menu
		panel = menu ;
			
		//barra del menu
       	menuBar = new JMenuBar();
      
       	
	    // creazione menuGioco
		menuGioco = new JMenu("Gioco");
		istruzioni = new JMenuItem("ISTRUZIONI" , manuale );
		salvaSuFile = new JMenuItem("SALVA SU FILE" , file );
		leggiDaFile = new JMenuItem("LEGGI DA FILE" , file );
		serializzazione = new JMenuItem("SERIALIZZAZIONE" , binario );
		deserializzazione = new JMenuItem("DESERIALIZZAZIONE" , binario );
		exit = new JMenuItem("EXIT" , exitIcon );
		
		//creazione prova
		prova = new JMenu("PROVA");
		    
		//aggiunta di item al menuGioco
		menuGioco.add(salvaSuFile);
		menuGioco.add(leggiDaFile);
		menuGioco.add(serializzazione);
		menuGioco.add(deserializzazione);
		menuGioco.add(istruzioni);
		menuGioco.add(exit);
		
		//aggiunta del menuGioco al menuBar
		menuBar.add(menuGioco);
		menuBar.add(prova); 
		 
		// aggiunta del menuBar al MyFrame
		this.setJMenuBar(menuBar);
		//setDimension
		setSize(1400,800);
		// aggiunta  dei menuItem all'actionListener
		istruzioni.addActionListener(this);
		leggiDaFile.addActionListener(this);
		salvaSuFile.addActionListener(this);
		serializzazione.addActionListener(this);
		deserializzazione.addActionListener(this);
		exit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource()== deserializzazione){
			JOptionPane.showMessageDialog(null, "SISTEMA : recupero partita ");
			try {
				partita.ricaricaPartita2();
			} catch (IOException exception) {
				JOptionPane.showMessageDialog(null, "SISTEMA : Errore nel recupero partita ");
			}
			panel.riscrivi();
			panel.riscriviCaselle();
		}
		if(e.getSource() == istruzioni ){
			JOptionPane.showMessageDialog(null, "SISTEMA : Istruzioni del gioco");
			JOptionPane.showMessageDialog(null, "istruzioni : inserire i nomi nel 2 campi a dispozione ");
			JOptionPane.showMessageDialog(null, "istruzioni : succesivamente premere i 2 bottoni gioca 1 e gioca 2 per giocare ");
			JOptionPane.showMessageDialog(null, "istruzioni : infine fare attenzione alle caselle rosse dato che comportano pericoli ");
			JOptionPane.showMessageDialog(null, "SISTEMA : Buon Divertimento ! ");
		}
		if(e.getSource() == salvaSuFile){
			JOptionPane.showMessageDialog(null, "SISTEMA : Salvataggio partita su file ");
			try{
				partita.salvataggioPartita();
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null, "SISTEMA : Errore nella scrittura su file");
			}
		}
		if(e.getSource() == leggiDaFile){
			JOptionPane.showMessageDialog(null, "SISTEMA : lettura della partita da file ");
			String l ;
			try{
				l = partita.letturaPartita();
				JOptionPane.showMessageDialog(null, "SISTEMA : ecco il contenuto del file --> " + l);
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null, "SISTEMA : Errore nella lettura da file");
			}
		}
		if(e.getSource() == serializzazione){
			JOptionPane.showMessageDialog(null, "SISTEMA : Salvataggio partita");
			try {
				partita.salvaPartita();
			}
			catch(Exception exception){
				JOptionPane.showMessageDialog(null, "SISTEMA : Errore Salvataggio partita");	
			}
		}
		if(e.getSource() == exit){
			int  n = JOptionPane.showConfirmDialog(null,"Vuoi veramente uscire dal gioco ? ", "EXIT" ,JOptionPane.YES_NO_OPTION );
			if(n==0)
				System.exit(0);
		}
	}
}
