package Controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Utente> databaseUtenti;

    private Utente utenteLoggato;
    private ArrayList <Struttura> elencoStrutture;

    public Controller() {
        this.databaseUtenti = new ArrayList<>();
        utenteLoggato=null;
    }



    public String ottieniDashboard() {
        if (utenteLoggato != null) {

            return utenteLoggato.mostraDashboard();
        }
        return "Errore: Nessun utente ha effettuato l'accesso.";
    }


    public boolean registraStruttura (String nome, String indirizzo, int categoria, int numeroCamere) {
        if (utenteLoggato==null) {
            return false;
        }

        if(utenteLoggato instanceof Utente){
            Host h = (Host)utenteLoggato;
            Struttura s = new Struttura(nome, indirizzo, categoria);
            for (int i= 1; i<= numeroCamere; i++) {
                s.aggiungiCamera(new Camera(i, 70.0, Tipo.SINGOLA));
            }
            h.aggiungiStruttura(s);
            return true;
        }
        return false;
    }

    public ArrayList<Struttura> getStrutturaHostLoggato() {
        if(utenteLoggato instanceof Utente){
            Host h = (Host)utenteLoggato;
            return h.getElencoStrutture();
        }
        return new ArrayList<>();
    }


    public boolean login(String emailInserita, String passInserita) {
        for (Utente u : databaseUtenti) {


            if (u.geteMail().equals(emailInserita) && u.getPassword().equals(passInserita)) {

                this.utenteLoggato = u;
                return true;
            }
        }

        return false;
    }

    public boolean registrazione (String tipoUtente ,String nome , String cognome, String eMail, String password, String numeroTelefono, String indirizzoDiFatturazione,  String coordinateBancarie){
        for (Utente u : databaseUtenti) {
            if (eMail.equalsIgnoreCase(u.geteMail())) {
                System.out.println("impossibile completare la registrazione, email già associata a un'altro account");
                return false;
            }
        }
        if (tipoUtente.equalsIgnoreCase("Cliente")){
            String idUtente = "CLI" + (databaseUtenti.size()+100);
            Cliente c = new Cliente(nome, cognome, eMail, password, numeroTelefono, indirizzoDiFatturazione, idUtente );
            System.out.println("Benvenuto nell'area clienti " + nome + " " + cognome);
            databaseUtenti.add(c);
            return true;
        }
        if (tipoUtente.equalsIgnoreCase("Host")){
            String idHost= "HST" + (databaseUtenti.size()+200);
            Host h = new Host(nome,cognome, eMail, password,idHost,coordinateBancarie);
            System.out.println("Benvenuto nell'area host " + nome + " " + cognome);
            databaseUtenti.add(h);
            return true;
        }



        return  false;
    }

    public boolean sottoscriviAbbonamento (Piano pianoScelto){
        if(utenteLoggato==null){
            return false;
        }
        if (utenteLoggato instanceof Cliente){
            Cliente c = (Cliente) utenteLoggato;// cast
            c.setMioAbbonamento(pianoScelto);
            return true;
        }
        return false;
    }

    public boolean isUtenteLoggato() {
        return this.utenteLoggato != null;
    }

    public boolean isHostLoggato() {
        return this.utenteLoggato != null && this.utenteLoggato instanceof Host;
    }


    public String getNomeLoggato() {
        if (utenteLoggato != null) {
            return utenteLoggato.getNome();
        }
        return "";
    }
}