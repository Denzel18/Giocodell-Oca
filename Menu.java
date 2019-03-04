/*
 * Denis Bernovschi
 * 4AIN
 * Gioco dell'oca
 * 26/04/2015
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JPanel; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class MyPanel.
 */
public class Menu extends JPanel implements ActionListener, java.io.Serializable {
	/** image */
	ImageIcon oca = new ImageIcon ("oca.png");
	ImageIcon ponte = new ImageIcon ("ponte.png");
	ImageIcon labirinto = new ImageIcon ("labirinto.png");
	ImageIcon prigione = new ImageIcon ("prigione.png");
	ImageIcon locanda = new ImageIcon ("locanda.png");
	ImageIcon scheletro = new ImageIcon ("scheletro.png");
	ImageIcon pozzo = new ImageIcon ("pozzo.png");
	ImageIcon exit = new ImageIcon("exit.png");
	ImageIcon premio = new ImageIcon("premio.png");
	
	/** The num max caselle. */
	private static int NUM_MAX_CASELLE = 64;
	//menu
	/** The menu. */
	private JLabel  puntata, saldo1, saldo2, sommaDadi ,posizione1 , posizione2 , menu , nome1 , nome2 ;
	
	/** The caselle. */
	private JLabel[] caselle = new JLabel [NUM_MAX_CASELLE];
	
	/** The vittoria. */
	private JLabel vittoria;

	/** The gioca1. */
	private JButton gioca1;
	
	/** The gioca2. */
	private JButton gioca2;
	
	/** The reset. */
	private JButton reset;
	
	/** The partita. */
	private Gioco partita;
	
	/** The i. */
	private int i = 0;
	
	
	// Border
	/** The border. */
	Border border = LineBorder.createBlackLineBorder();
	
	/**
	 * Instantiates a new menu.
	 *
	 * @param p the Gioco
	 */
	public Menu(Gioco p) {
		partita = p;
		/* layout */
		GridLayout layout= new GridLayout(10 ,12);
		setLayout(layout);
		/* JLabel nomi */
		nome1 = new JLabel();
		nome2 = new JLabel();
	
		/* labels saldi */
		saldo1 = new JLabel("Saldo giocatore 1 : " + partita.getSaldo_1());
		saldo2 = new JLabel("Saldo giocatore 2 : " + partita.getSaldo_2());
		/* label somma dei dadi */
		sommaDadi = new JLabel("SOMMA DADI : "+partita.getSommaDadi());
		/* buttons gioca */
		gioca1 = new JButton(" GIOCA 1 ");
		gioca2 = new JButton(" GIOCA 2 ");
		/* button reset */
		reset = new JButton("RESET ");
		/* label puntata (posta) */ 
		puntata = new JLabel("PUNTATA : " +partita.getPosta());
		/* labels posione giocatori  */
		posizione1 = new JLabel("Posizione1 : "+partita.getPosizioneGiocatore1());
		posizione2 = new JLabel("Posizione2 : "+partita.getPosizioneGiocatore2());
		/* label vincitore */
		vittoria = new JLabel("Vittoria : ");
		/* label menu */ 
		menu = new JLabel("Menu");
		menu.setFont(new Font("Vladimir Script", Font.PLAIN, 30));
		
		//label caselle
		for( i=0 ; i< NUM_MAX_CASELLE ; i++){
			caselle[i] = new JLabel(Integer.toString(i));
		}
		/* caselle principali & pericoli  */		
		caselle[0].setText("INIZIO");  
		caselle[6].setText("6 : PONTE");
		caselle[19].setText("19 :  LOCANDA"); 	
		caselle[31].setText("31 : POZZO");
		caselle[42].setText("42 : LABIRINTO"); 
		caselle[52].setText("52 : PRIGIONE");	
		caselle[58].setText("58 : SCHELETRO"); 
		caselle[63].setText("63 : VITTORIA");
			
		for(i=5 ; i <= 59 ; i=i+9){
			caselle[i]= new JLabel(Integer.toString(i)+" : OCA");
		}
		for(i=9 ; i <NUM_MAX_CASELLE-1 ; i=i+9){
			caselle[i]= new JLabel(Integer.toString(i)+" : OCA");
		}
		/* add , border , opacizza */
		for (i=0 ; i < NUM_MAX_CASELLE ; i++){
			this.caselle[i].setBorder(border);
			this.caselle[i].setOpaque(true);
			this.add(caselle[i]);
		}
		/*1 riga*/
		for(i=1 ; i<= 10 ; i++){
			caselle[i].setBackground(Color.MAGENTA);
		}
		/*2 riga*/
		for(i=11 ; i<=21 ; i++){
			caselle[i].setBackground(Color.CYAN);
		}
		/*3 riga*/
		for(i=22 ; i<=32 ;i++){
			caselle[i].setBackground(Color.ORANGE);
		}
		/*4 riga*/
		for(i=33 ; i<=43 ;i++){
			caselle[i].setBackground(Color.YELLOW);
		}
		/*5 riga*/
		for(i=44 ; i<=54 ; i++){
			caselle[i].setBackground(Color.getHSBColor(90, 100, 100));
		}
		/*6 riga*/
		for(i=55 ; i<=62 ; i++){
			caselle[i].setBackground(Color.GRAY);
		}
		
		/*colorazione caselle principali*/
		caselle[0].setBackground(Color.GREEN);
		caselle[6].setBackground(Color.RED);
		caselle[19].setBackground(Color.RED);
		caselle[31].setBackground(Color.RED);
		caselle[42].setBackground(Color.RED);
		caselle[52].setBackground(Color.RED);
		caselle[58].setBackground(Color.RED);
		caselle[63].setBackground(Color.GREEN);
		
		// Border
		nome1.setBorder(border); 		
		nome2.setBorder(border);
		posizione1.setBorder(border);	
		posizione2.setBorder(border);
		saldo1.setBorder(border);		
		saldo2.setBorder(border);
		puntata.setBorder(border);		
		sommaDadi.setBorder(border);
		gioca1.setBorder(border);		
		gioca2.setBorder(border);
		reset.setBorder(border);		
		menu.setBorder(border);
		vittoria.setBorder(border);		
		
		
		// aggiungi
		this.add(menu);					
		this.add(reset);         
		this.add(nome1);  				
		this.add(nome2);
		this.add(posizione1);			
		this.add(posizione2);
		this.add(saldo1); 				
		this.add(saldo2);
		this.add(puntata); 				
		this.add(sommaDadi);
		this.add(gioca1);				
		this.add(gioca2);
		this.add(vittoria);				
		
		
		//Button -> action listener
		gioca1.addActionListener(this);
		gioca2.addActionListener(this);
		reset.addActionListener(this);
		
		/*layout*/
		riscrivi();
		riscriviCaselle();
	}

	public void actionPerformed(ActionEvent e){
		riscriviCaselle();
		
		if(e.getSource() == gioca1){
			reset.setEnabled(false);
			if(partita.gioca_1()){
				riscrivi();
			}
			else{
				JOptionPane.showMessageDialog(null, partita.getErrore());
				gioca1.setEnabled(false);
				riscrivi();
			}
			if(partita.isOca()){
				JOptionPane.showMessageDialog(null, "Il giocatore 1 ha trovato l'oca ");
				riscrivi();
			}	
			/*serve per gestire il turno*/
			gioca1.setOpaque(true);
			gioca1.setBackground(Color.DARK_GRAY);
			gioca2.setOpaque(true);
			gioca2.setBackground(Color.PINK);	
		}
		
		if(e.getSource() == gioca2){
			reset.setEnabled(false);
			if(partita.gioca_2()){
				riscrivi();
			}
			if(!partita.gioca_2()){
				JOptionPane.showMessageDialog(null, partita.getErrore());
				gioca2.setEnabled(false);
				riscrivi();
			}
			if(partita.isOca2()){
				JOptionPane.showMessageDialog(null, "Il giocatore 2 ha trovato l'oca ");
				riscrivi();
			}
			/*serve per gestire il turno*/
			gioca2.setOpaque(true);
			gioca2.setBackground(Color.DARK_GRAY);
			gioca1.setOpaque(true);
			gioca1.setBackground(Color.PINK);
		}
		
		if(partita.isWin_1()){
			JOptionPane.showMessageDialog(null, partita.getVittoria());
			vittoria.setText(partita.getVittoria());
			gioca1.setEnabled(false);
			gioca2.setEnabled(false);
			reset.setEnabled(true);
		}
		
		if(partita.isWin_2()){
			JOptionPane.showMessageDialog(null, partita.getVittoria());
			vittoria.setText(partita.getVittoria());
			gioca1.setEnabled(false);
			gioca2.setEnabled(false);
			reset.setEnabled(true);
		}

		if(e.getSource() == reset){
			int x = JOptionPane.showConfirmDialog(null,"Vuoi veramente ressetare la partita ?","RESET",JOptionPane.YES_NO_OPTION);
			if(x == 0){
				partita.reset();
				riscriviCaselle();
				gioca1.setEnabled(true);
				gioca2.setEnabled(true);
				riscrivi();
				vittoria.setText("Vittoria : ");
				JOptionPane.showMessageDialog(null, "SISTEMA : ESEGUO IL RESET");
			}
		}
	}
	
	/**
	 * Riscrivi.
	 */
	public void riscrivi () {
		int p1 , p2 = 0;
		p1=(partita.getPosizioneGiocatore1());
		p2=(partita.getPosizioneGiocatore2());			
		puntata.setText("Posta : " + partita.getPosta());
		nome1.setText("Giocatore 1 \n "+partita.getNomeGiocatore1());
		nome2.setText("Giocatore 2 \n "+partita.getNomeGiocatore2());	
		sommaDadi.setText("SOMMA DADI : "+partita.getSommaDadi());
		posizione1.setText("Posizione1 : "+partita.getPosizioneGiocatore1());
		posizione2.setText("Posizione2 : "+partita.getPosizioneGiocatore2());
		saldo1.setText("Saldo giocatore 1 : " + partita.getSaldo_1());
		saldo2.setText("Saldo giocatore 2 : " + partita.getSaldo_2());
		vittoria.setText("Vittoria : ");
		caselle[p1].setText(caselle[p1].getText()+" "+partita.getNomeGiocatore1());
		caselle[p2].setText(caselle[p2].getText()+" "+partita.getNomeGiocatore2());
	}
	
	/**
	 * Riscrivi caselle.
	 */
	public void riscriviCaselle(){
		for( i=0 ; i < 63 ; i++){
			caselle[i].setText(Integer.toString(i));
		}		
		caselle[0].setText("INIZIO");   
		caselle[6].setText("6 : PONTE");		caselle[6].setIcon(ponte);
		caselle[19].setText("19 :  LOCANDA"); 	caselle[19].setIcon(locanda);	
		caselle[31].setText("31 : POZZO");    	caselle[31].setIcon(pozzo);
		caselle[42].setText("42 : LABIRINTO");	caselle[42].setIcon(labirinto);
		caselle[52].setText("52 : PRIGIONE");	caselle[52].setIcon(prigione);	
		caselle[58].setText("58 : SCHELETRO");  caselle[58].setIcon(scheletro); 
		caselle[63].setText("63 : VITTORIA");	caselle[63].setIcon(premio);
			
		for(i=5 ; i <= 59 ; i=i+9){
			caselle[i].setText(Integer.toString(i)+" : OCA");
			caselle[i].setIcon(oca);
		}
		for(i=9 ; i <  63 ; i=i+9){
			caselle[i].setText(Integer.toString(i)+" : OCA");
			caselle[i].setIcon(oca);
		}
	}
}

