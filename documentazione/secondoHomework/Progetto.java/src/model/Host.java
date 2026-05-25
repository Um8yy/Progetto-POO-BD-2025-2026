package model;
import java.util.ArrayList;

public class Host extends Utente {
    private String idHost;
    private String coordinateBancarie;
    private ArrayList<Struttura> elencoStrutture;


    public Host(String nome, String cognome, String email, String password, String idHost, String coordinateBancarie) {
        super(nome, cognome, email, password);
        this.idHost = idHost;
        this.coordinateBancarie = coordinateBancarie;


        elencoStrutture = new ArrayList<>();

    }

    public String restituisciId() {
        return idHost;
    }

    public String restituisciCoordinate() {
        return coordinateBancarie;
    }

    public void aggiungiStruttura(Struttura s) {
        elencoStrutture.add(s);
    }

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

    public void eliminaStruttura(String strutturaDaEliminare) {
        boolean trovato;
        for (int i = 0; i < elencoStrutture.size(); i++) {
            if (elencoStrutture.get(i).restituisciNome().equalsIgnoreCase(strutturaDaEliminare)) {
                elencoStrutture.remove(i);
            }
        }
    }

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


}

