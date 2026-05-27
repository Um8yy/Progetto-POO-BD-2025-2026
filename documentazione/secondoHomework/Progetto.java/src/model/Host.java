package model;
import java.util.ArrayList;

/**
 Creazione dell'Host che potrà gestire , aggiungere o eliminare delle strutture
 */
public class Host extends Utente {
    private String idHost;
    private String coordinateBancarie;
    private ArrayList<Struttura> elencoStrutture;


    /**
     * Instantiates a new Host.
     *
     * @param nome                nome
     * @param cognome             cognome
     * @param email               email
     * @param password            password
     * @param idHost              idhost
     * @param coordinateBancarie  coordinate bancarie
     */
    public Host(String nome, String cognome, String email, String password, String idHost, String coordinateBancarie) {
        super(nome, cognome, email, password);
        this.idHost = idHost;
        this.coordinateBancarie = coordinateBancarie;


        elencoStrutture = new ArrayList<>();

    }

    /**
     * Restituisci id string.
     *
     * @return the string
     */
    public String restituisciId() {
        return idHost;
    }

    /**
     * Restituisci coordinate string.
     *
     * @return the string
     */
    public String restituisciCoordinate() {
        return coordinateBancarie;
    }

    /**
     * Aggiungi struttura al suo elenco
     *
     * @param s  Struttura
     */
    public void aggiungiStruttura(Struttura s) {
        elencoStrutture.add(s);
    }

    /**
     * Cerca struttura boolean.
     *
     * @param strutturaDaCercare
     * @return the boolean (true se ha trovato , false se invece non è stato trovato)
     */
    public boolean CercaStruttura(String strutturaDaCercare) {
        boolean trovato;
        for (int i = 0; i < elencoStrutture.size(); i++) {
            if (elencoStrutture.get(i).restituisciNome().equalsIgnoreCase(strutturaDaCercare)) {
                trovato = true;
                return trovato;
            }
        }
        trovato = false;
        return trovato;
    }

    /**
     * Elimina struttura dall'arraylist
     *
     * @param strutturaDaEliminare
     */
    public void eliminaStruttura(String strutturaDaEliminare) {
        boolean trovato;
        for (int i = 0; i < elencoStrutture.size(); i++) {
            if (elencoStrutture.get(i).restituisciNome().equalsIgnoreCase(strutturaDaEliminare)) {
                elencoStrutture.remove(i);
            }
        }
    }

    /**
     * Restituisci numero strutture int.
     *
     * @return the int
     */
    public int restituisciNumeroStrutture() {
        return elencoStrutture.size();
    }


    @Override
    public String mostraDashboard() {
        String risultato = "Dashborad Host: \n";
        risultato += "Nome: " + getNome() + ". Cognome: " + getCognome() + "\n";
        risultato += "e-mail: " + geteMail() + ". ID host: " + restituisciId() + "\n" +
                "Coordinate Bancarie: " + restituisciCoordinate();
        risultato += " Numero di strutture gestite: " + restituisciNumeroStrutture();
        risultato += "================================================== \n";
        for (Struttura s : elencoStrutture) {
            risultato += "Nome: " + s.restituisciNome();
            risultato += "Indirizzo: " + s.restituisciIndirizzo();
            risultato += "Categoria: " + s.restituisciCategoria();


        }

        return risultato;

    }

    /**
     * Gets elenco strutture.
     *
     * @return the elenco strutture
     */
    public ArrayList<Struttura> getElencoStrutture() {
        return this.elencoStrutture;
    }

}