package Controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Utente> databaseUtenti;

    private Utente utenteLoggato; // Può essere sia un Cliente che un Host (Polimorfismo)

    public Controller() {
        this.databaseUtenti = new ArrayList<>();
        utenteLoggato=null;
    }

    // --- METODO COMUNE (Polimorfismo puro) ---

    // Questo verrà chiamato da un JButton "Mostra Profilo / Dashboard"
    public String ottieniDashboard() {
        if (utenteLoggato != null) {
            // Il Controller non ha bisogno di sapere se è Host o Cliente.
            // Java chiamerà in automatico il mostraDashboard() corretto.
            return utenteLoggato.mostraDashboard();
        }
        return "Errore: Nessun utente ha effettuato l'accesso.";
    }




    public boolean login(String emailInserita, String passInserita) {
        // Scorriamo tutti gli utenti presenti nella nostra lista (database)
        for (Utente u : databaseUtenti) {

            // Usiamo i metodi getter dell'Entity "Utente" per fare il confronto
            // (Assicurati che i metodi si chiamino esattamente così nella tua classe Utente)
            if (u.geteMail().equals(emailInserita) && u.getPassword().equals(passInserita)) {

                // Abbiamo trovato l'utente! Lo salviamo nella variabile di sessione
                this.utenteLoggato = u;
                return true; // Login effettuato con successo
            }
        }

        // Se il ciclo finisce e non ha trovato nessuna corrispondenza:
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

}