/*
 * Denis Bernovschi
 * 4AIN
 * Gioco dell'oca
 * 26/04/2015
 */
import java.util.Random;
import java.io.*;
/**
 * The Class Gioco.
 *
 * @author Denis Bernovschi
 */
public class Gioco implements java.io.Serializable {
	
	/** The Constant newline. */
	private final static String newline = "\n";
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The posta. */
	private int posta ;
	
	/** The nome_giocatore_1. */
	private String nome_giocatore_1;
	
	/** The nome_giocatore_2. */
	private String nome_giocatore_2;
	
	/** The errore. */
	private String errore;
	
	/** The posizione giocatore1. */
	private int posizioneGiocatore1;
	
	/** The posizione giocatore2. */
	private int posizioneGiocatore2;
	
	/** The random. */
	Random random = new Random() ;
	
	/** The saldo_1. */
	private int saldo_1;
	
	/** The saldo_2. */
	private int saldo_2;
	
	/** The turno. */
	private int turno ;
	
	/** The somma dadi. */
	private int sommaDadi;
	
	/** The vittoria. */
	private String vittoria;
	
	/** The attesa. */
	private boolean attesa ;
	
	/** The win_1. */
	private boolean win_1 ;
	
	/** The win_2. */
	private boolean win_2 ;
	
	/** The oca. */
	private boolean oca , oca2;
	/*metodo costruttore*/
	/**
	 * Instantiates a new gioco.
	 *
	 * @param n1 the nome Giocatore 1
	 * @param n2 the nome Giocatore 2
	 */
	public Gioco (String n1  , String n2){
		this.setNome_giocatore1(n1);
		this.setNome_giocatore2(n2);
		this.setPosizioneGiocatore1(0);
		this.setPosizioneGiocatore2(0);
		this.setSaldo_1(20);
		this.setSaldo_2(20);
		this.setPosta(2);
		this.setOca(false);
		this.setOca2(false);
		this.setWin_1(false);
		this.setWin_2(false);
		this.setAttesa(false);
	}
	/*metodi set */
	/**
	 * Sets the nome_giocatore1.
	 *
	 * @param nome the new nome_giocatore1
	 */
	public void setNome_giocatore1(String nome){
		this.nome_giocatore_1=nome;
	}
	
	/**
	 * Sets the nome_giocatore2.
	 *
	 * @param nome the new nome_giocatore2
	 */
	public void setNome_giocatore2(String nome){
		this.nome_giocatore_2=nome;
	}
	
	/**
	 * Sets the posizione giocatore1.
	 *
	 * @param posizioneGiocatore1 the new posizione giocatore1
	 */
	public void setPosizioneGiocatore1(int posizioneGiocatore1) {
		if(posizioneGiocatore1 >= 0 && posizioneGiocatore1 < 64)
			this.posizioneGiocatore1 = posizioneGiocatore1;
	}
	
	/**
	 * Sets the posizione giocatore2.
	 *
	 * @param posizioneGiocatore2 the new posizione giocatore2
	 */
	public void setPosizioneGiocatore2(int posizioneGiocatore2) {
		if(posizioneGiocatore2 >= 0 && posizioneGiocatore2 < 64)
			this.posizioneGiocatore2 = posizioneGiocatore2;
	}
	
	/**
	 * Sets the errore.
	 *
	 * @param s the new errore
	 */
	private void setErrore(String s){
		this.errore=s;
	}
	
	/**
	 * Sets the posta.
	 *
	 * @param n the new posta
	 */
	private void setPosta(int n){
		this.posta=n;
	}
	
	/**
	 * Sets the dado.
	 *
	 * @param dado the new dado
	 */
	private void setDado(int dado) {
		this.sommaDadi = dado;
	}
	
	/**
	 * Sets the saldo_1.
	 *
	 * @param saldo_1 the new saldo_1
	 */
	private void setSaldo_1(int saldo_1) {
		this.saldo_1 = saldo_1;
	}
	
	/**
	 * Sets the saldo_2.
	 *
	 * @param saldo_2 the new saldo_2
	 */
	private void setSaldo_2(int saldo_2) {
		this.saldo_2 = saldo_2;
	}
	
	/**
	 * Sets the turno.
	 *
	 * @param turno the new turno
	 */
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	/**
	 * Sets the vittoria.
	 *
	 * @param vittoria the new vittoria
	 */
	public void setVittoria(String vittoria) {				
		this.vittoria = vittoria;
	}
	
	/**
	 * Sets the attesa.
	 *
	 * @param attesa the new attesa
	 */
	private void setAttesa(boolean attesa) {
		this.attesa = attesa;
	}
	
	/**
	 * Sets the win_1.
	 *
	 * @param vittoria the new win_1
	 */
	public void setWin_1(boolean vittoria) {
		this.win_1 = vittoria;
	}
	
	/**
	 * Sets the win_2.
	 *
	 * @param vittoria the new win_2
	 */
	public void setWin_2(boolean vittoria) {
		this.win_2 = vittoria;
	}
	
	/**
	 * Sets the oca.
	 *
	 * @param oca the new oca
	 */
	private void setOca(boolean oca) {
		this.oca = oca;
	}
	/**
	 * Sets the oca2.
	 *
	 * @param oca the new oca
	 */
	private void setOca2(boolean oca) {
		this.oca2 = oca;
	}
	/*metodi get*/
	/**
	 * Gets the nome giocatore1.
	 *
	 * @return the nome giocatore1
	 */
	public String getNomeGiocatore1(){
		return this.nome_giocatore_1;
	}
	
	/**
	 * Gets the nome giocatore2.
	 *
	 * @return the nome giocatore2
	 */
	public String getNomeGiocatore2(){
		return this.nome_giocatore_2;
	}	
	
	/**
	 * Gets the posta.
	 *
	 * @return the posta
	 */
	public int getPosta(){
		return this.posta;
	}
	
	/**
	 * Gets the errore.
	 *
	 * @return the errore
	 */
	public String getErrore(){
		return this.errore;
	}
	
	/**
	 * Gets the somma dadi.
	 *
	 * @return the somma dadi
	 */
	public int getSommaDadi() {
		return sommaDadi;
	}
	
	/**
	 * Gets the posizione giocatore1.
	 *
	 * @return the posizione giocatore1
	 */
	public int getPosizioneGiocatore1() {
		return posizioneGiocatore1;
	}	
	
	/**
	 * Gets the posizione giocatore2.
	 *
	 * @return the posizione giocatore2
	 */
	public int getPosizioneGiocatore2() {
		return posizioneGiocatore2;
	}
	
	/**
	 * Gets the saldo_1.
	 *
	 * @return the saldo_1
	 */
	public int getSaldo_1() {
		return saldo_1;
	}
	
	/**
	 * Gets the saldo_2.
	 *
	 * @return the saldo_2
	 */
	public int getSaldo_2() {
		return saldo_2;
	}
	
	/**
	 * Gets the turno.
	 *
	 * @return the turno
	 */
	public int getTurno() {
		return turno;
	}
	
	/**
	 * Gets the vittoria.
	 *
	 * @return the vittoria
	 */
	public String getVittoria() {
		return vittoria;
	}
	
	/**
	 * Checks if is attesa.
	 *
	 * @return true, if is attesa
	 */
	public boolean isAttesa() {
		return attesa;
	}
	
	/**
	 * Checks if is win_1.
	 *
	 * @return true, if is win_1
	 */
	public boolean isWin_1() {
		return this.win_1;
	}
	
	/**
	 * Checks if is win_2.
	 *
	 * @return true, if is win_2
	 */
	public boolean isWin_2() {
		return this.win_2;
	}
	
	/**
	 * Checks if is oca.
	 *
	 * @return true, if is oca
	 */
	public boolean isOca() {
		return oca;
	}
	
	/**
	 * Checks if is oca2.
	 *
	 * @return true, if is oca2
	 */
	public boolean isOca2(){
		return oca2;
	}
	/*metodi x gioca*/
	/**
	 * Tira dado.
	 */
	public void tiraDado(){
		int x = 0 ;
		x = random.nextInt(6)+1;
		setDado(x);
	}
	/*metodo to string*/
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String s="";
		s+="Nome giocatore 1 : "+getNomeGiocatore1()+"\n";
		s+="Nome giocatore 2 : "+getNomeGiocatore2()+"\n";
		s+="saldo 1 : "+getSaldo_1()+"\n";
		s+="saldo 2 : "+getSaldo_2()+"\n";
		s+="Somma Dadi : "+getSommaDadi()+"\n";
		s+="puntata : "+getPosta()+"\n";
		s+="posizone 1 : "+getPosizioneGiocatore1()+"\n";
		s+="posizone 2 : "+getPosizioneGiocatore2()+"\n";
		return s;
	}
	/*reset*/
	/**
	 * Reset.
	 */
	public void reset (){
		setWin_1(false);
		setWin_2(false);
		setNome_giocatore1(getNomeGiocatore1());
		setNome_giocatore2(getNomeGiocatore2());
		setSaldo_1(20);
		setSaldo_2(20);
		setDado(0);
		setPosizioneGiocatore1(0);
		setPosizioneGiocatore2(0);
		
	}	
	/*gioca-1*/
	/**
	 * Gioca_1.
	 *
	 * @return true, if successful
	 */
	public boolean gioca_1(){
		boolean check = true ;
		setOca(false);
		int posizA , posizF = 0;
		tiraDado();
		posizF = (getSommaDadi() + getPosizioneGiocatore1()) ;
		posizA = (getPosizioneGiocatore1());
		
		//movimento
		if(posizF < 63){
			setPosizioneGiocatore1(posizA + getSommaDadi());
		}
		else{
			int puntiInEccesso = (posizF - 63);
			setPosizioneGiocatore1(63 - puntiInEccesso);
		}
		posizA = (getPosizioneGiocatore1());
		//oca
		if(casellaOca_1()){
			setOca(true);
			setPosizioneGiocatore1(posizA + getSommaDadi()*2);
		}
		//ponte
		if(posizA == 6){
			this.setErrore("hai trovato il ponte");
			if(!paga_1())
				check = false ;
			tiraDado();
			setPosizioneGiocatore1(posizA+getSommaDadi());
			return check;	
		}
		//scheletro
		if(posizA == 58){
			this.setErrore("hai trovato lo scheletro");
			if(!paga_1())
				check = false ;
			setPosizioneGiocatore1(1);
			return check ;
			
		}
		//labirinto
		if(posizA == 42){
			this.setErrore("sei finito nel labirinto");
			if(!paga_1())
				check = false ;
			setPosizioneGiocatore1(39);
			return check;
		}
		//pozzo
		if(posizA == 31){
			this.setErrore("sei finito nel pozzo");
			if(getPosizioneGiocatore1() == getPosizioneGiocatore2()){
				if(!paga_1()){
					check = false;
					return check;
				}
				check = true ;
			}
			else{
				check = false ;
			}
		}
		//prigione
		if(posizA == 52){
			this.setErrore("sei finito in prigione");
			if(getPosizioneGiocatore1() == getPosizioneGiocatore2()){
				if(!paga_1()){
					check = false;
					return check;
				}
				check = true ;
			}
			else{
				check = false ;
			}
		}
		//locanda
		if(posizA == 19){
			this.setErrore("sei finito nella locanda");
			if(!paga_1()){
				check = false;
				return check;
			}
			for(int i = 0 ; i < 4 ; i++)
				gioca_2();
			check = true ;
		}
		//vittoria
		if (posizA == 63){
			setVittoria("HA VINTO G1"+"->"+getNomeGiocatore1());
			setWin_1(true);
			return check;
		}
		return check;
}	
	/*gioca-2*/
	/**
	 * Gioca_2.
	 *
	 * @return true, if successful
	 */
	public boolean gioca_2(){
		boolean check = true ;
		setOca2(false);
		int posizA , posizF = 0;
		tiraDado();
		posizF = (getSommaDadi() + getPosizioneGiocatore2()) ;
		posizA = (getPosizioneGiocatore2());
		//movimento
		if(posizF < 63){
			setPosizioneGiocatore2(posizA + getSommaDadi());
		}
		else{
			int puntiInEccesso = (posizF - 63);
			setPosizioneGiocatore2(63 - puntiInEccesso);
		}
		posizA = (getPosizioneGiocatore2());
		//oca
		if(casellaOca_2()){
			setOca2(true);
			setPosizioneGiocatore2(posizA + getSommaDadi()*2);
		}
		//ponte
		if(posizA == 6){
			this.setErrore("sei finito sul ponte");
			if(!paga_2()){
				check = false;
				return check ;
			}
			tiraDado();
			setPosizioneGiocatore2(posizA+getSommaDadi());
			return check;	
		}
		//scheletro
		if(posizA == 58){
			this.setErrore("hai trovato lo scheletro");
			if(!paga_2())
				check = false;
			setPosizioneGiocatore2(1);
			return check;
		}
		//labirinto
		if(posizA == 42){
			this.setErrore("sei finito nel labirinto");
			if(!paga_2()){
				check = false;
				return check;
			}
			setPosizioneGiocatore2(39);
			return check ;
		}
		//pozzo
		if(posizA == 31){
			this.setErrore("sei finito nel pozzo");
			if(getPosizioneGiocatore1() == getPosizioneGiocatore2()){
				if(!paga_2()){
					check = false;
					return check;
				}
				check = true ;
			}
			else{
				check = false ;
			}
		}
		//prigione
		if(posizA == 52){
			this.setErrore("sei finito in prigione");
			if(getPosizioneGiocatore1() == getPosizioneGiocatore2()){
				if(!paga_2()){
					check = false;
					return check;
				}
				check = true ;
			}
			else{
				check = false ;
			}
		}
		//locanda
		if(posizA == 19){
			this.setErrore("sei finito nella locanda");
			if(!paga_2()){
				check = false;
				return check;
			}
			for(int i = 0 ; i < 4 ; i++)
				gioca_1();
			check = true ;
			return check ;
		}
		//vittoria
		if (posizA == 63){
			setVittoria("HA VINTO G2"+"->"+getNomeGiocatore2());
			setWin_2(true);
			return check;
		}
		return check;
}
	
	/*paga-1*/
	/**
	 * Paga_1.
	 *
	 * @return true, if successful
	 */
	public boolean paga_1(){
		boolean ok = true ;
		if((this.getSaldo_1()-this.getPosta()) >= 0){
			this.setSaldo_1(this.getSaldo_1() - this.getPosta());
			ok = true;
		}
		if((this.getSaldo_1()-this.getPosta()) < 0){
			ok = false ;
			this.setErrore("SALDO INSUFFICIENTE");
		}
		return ok;
	}
	/*paga-2*/
	/**
	 * Paga_2.
	 *
	 * @return true, if successful
	 */
	public boolean paga_2(){
		boolean ok = true ;
		if((this.getSaldo_2()-this.getPosta()) >= 0){
			this.setSaldo_2(this.getSaldo_2() - this.getPosta());
			ok = true;
		}
		if((this.getSaldo_2()-this.getPosta()) < 0){
			ok = false ;
			this.setErrore("SALDO INSUFFICIENTE");
		}
		return ok;
	}
	/*casellaOca_1*/
	/**
	 * Casella oca_1.
	 *
	 * @return true, if successful
	 */
	public boolean casellaOca_1(){
		int i = 0;
		boolean okay = false ;
		for (i=5 ; i <= 63 ; i=i+9){
			if(getPosizioneGiocatore1() == i ){
				okay = true ;
				return okay ;
			}
		}
		for(i=9 ; i < 63 ; i=i+9){
			if(getPosizioneGiocatore1() == i ){
				okay = true ;
				return okay ;
			}
		}
		if(getPosizioneGiocatore1() == 63){
			okay = false;
			return okay ;
		}
		return okay ;
	}
	/*casellaOca_2*/
	/**
	 * Casella oca_2.
	 *
	 * @return true, if successful
	 */
	public boolean casellaOca_2(){
		int i = 0;
		boolean okay = false ;
		for (i=5 ; i <= 63 ; i=i+9){
			if(getPosizioneGiocatore2() == i ){
				okay = true ;
				return okay ;
			}
		}
		for(i=9 ; i < 63 ; i=i+9){
			if(getPosizioneGiocatore2() == i ){
				okay = true ;
				return okay ;
			}
		}
		if(getPosizioneGiocatore2() == 63){
			okay = false;
			return okay ;
		}
		return okay ;
	}
	
	/**
	 * Salva partita.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void salvaPartita() throws java.io.IOException{
		FileOutputStream out = new FileOutputStream("partita.bin");
		ObjectOutputStream stream = new ObjectOutputStream(out);
		stream.writeObject(this);
		out.close();
		stream.close();
	}
	
	/**
	 * Ricarica partita.
	 *
	 * @return the gioco
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Gioco ricaricaPartita() throws java.io.IOException{
		Gioco p1 = null;
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream("partita.bin"));
		try{
		  p1 = (Gioco)stream.readObject();
		}
		catch (ClassNotFoundException exception) {
			System.out.println("errore  "+exception.getException());
		}
		stream.close();
		return  p1;
	}
	
	/**
	 * Salvataggio partita.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void salvataggioPartita() throws java.io.IOException{
		String nomeFile = "partita.txt";
		String line = newline
				+"nome giocatore 1 : "+getNomeGiocatore1()+newline
				+"nome giocatore 2 : "+getNomeGiocatore2()+newline
				+"posiz. giocatore 1 : "+getPosizioneGiocatore1()+newline
				+"posiz. giocatore 2 : "+getPosizioneGiocatore2()+newline
				+"saldo 1 : "+getSaldo_1()+newline
				+"saldo 2 : "+getSaldo_2();
		try {
	      File file = new File(nomeFile);
	      FileWriter fw = new FileWriter(file);
	      fw.write(line);
	      fw.flush();
	      fw.close();
	    }
	    
		catch(IOException e) { 
	      e.printStackTrace();
	    }
	}
	
	/**
	 * Lettura partita.
	 *
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String letturaPartita() throws java.io.IOException {
	    String path = "partita.txt";
	    char[] in = new char[300];
	    String linea="";
	    int size = 0;
	    try {
	      File file = new File(path);
	      FileReader fr = new FileReader(file);
	      BufferedReader br = new BufferedReader(fr);
	      size = br.read(in);
	      for(int i=0; i<size; i++){
	      	linea+=in[i];
	      }
	      br.close();
	    }
	    catch(IOException e) { 
	      e.printStackTrace();
	    }
		return linea;
	}
	
	/**
	 * Ricarica partita2.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void ricaricaPartita2()  throws java.io.IOException {
		Gioco p2 = null;
		try{
		  p2 = (Gioco)new ObjectInputStream(new FileInputStream("partita.bin")).readObject();
		}
		catch (ClassNotFoundException exception) {
			System.out.println("errore  "+exception.getException());
		}
		this.setNome_giocatore1(p2.getNomeGiocatore1());
		this.setNome_giocatore2(p2.getNomeGiocatore2());
		this.setPosizioneGiocatore1(p2.getPosizioneGiocatore1());
		this.setPosizioneGiocatore2(p2.getPosizioneGiocatore2());
		this.setSaldo_1(p2.getSaldo_1());
		this.setSaldo_2(p2.getSaldo_2());
		
	}
}
