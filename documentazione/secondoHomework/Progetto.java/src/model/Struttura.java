package model;

import java.util.ArrayList;

/**
 la struttura che viene gestita dall'host  che può permettere di modificarla
 */
public class Struttura {

    private String indirizzo;
    private String nome;
    private int categoria;
    private ArrayList <Camera> elencoCamere;
    private ArrayList <Servizio>  serviziOfferti;


    /**
     * Instantiates a new Struttura.
     *
     * @param nome       nome
     * @param indirizzo  indirizzo
     * @param categoria  categoria
     */
    public Struttura(String nome, String indirizzo, int categoria ){
        this.nome= nome;
        this.indirizzo=indirizzo;
        this.categoria=categoria;

        elencoCamere = new ArrayList<>();
        serviziOfferti = new ArrayList<>();

    }

    /**
     * Aggiungi camera alla struttura
     *
     * @param c  camera oggetto camera
     */
    public void aggiungiCamera (Camera c){elencoCamere.add(c);}

    /**
     * Aggiungi servizio.
     *
     * @param s  servizio oggetto servizio
     */
    public void aggiungiServizio (Servizio s){ serviziOfferti.add(s);}

    /**
     * Elimina camera dalla struttura
     *
     * @param numeroCameraDaEliminare il numero di camera che l'host vuole eliminare
     */
//elimina camera
    public void eliminaCamera (int numeroCameraDaEliminare){
        for (int i = 0 ; i < elencoCamere.size(); i++){
            if (elencoCamere.get(i).restituisciNumeroCamera() ==numeroCameraDaEliminare ){
                elencoCamere.remove(i);
            }
        }
    }

    /**
     * Cerca una camera specifica
     *
     * @param numeroCameraDaCercare numero di camera da cercare
     * @return  boolean true se è stata trovata , false se non  è stata trovata
     */
// cerca camera
    public boolean cercaCamera ( int numeroCameraDaCercare){
        boolean trovato;
        for (int i = 0 ; i < elencoCamere.size(); i++){
            if(elencoCamere.get(i).restituisciNumeroCamera() == numeroCameraDaCercare){
                trovato= true;
                return trovato;
            }
        }
        trovato= false;
        return trovato;
    }

    /**
     * Verifica la presenza di un singolo servizio
     *
     * @param nomeDaCercare nome del servizio da cercare
     * @return  boolean rue se è stata trovata , false se non  è stata trovata
     */
    public boolean PresenzaServizio(String nomeDaCercare) {
        for (Servizio s : serviziOfferti) {
            if (s.verificaServizio(nomeDaCercare)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Restituisci nome string.
     *
     * @return the string
     */
    public String restituisciNome () {return nome;}

    /**
     * Restituisci indirizzo string.
     *
     * @return the string
     */
    public String restituisciIndirizzo () { return indirizzo;}

    /**
     * Restituisci categoria int.
     *
     * @return the int
     */
    public int restituisciCategoria () {return categoria; }




    /**
     * Restituisci numero camere int.
     *
     * @return the int
     */
    public int restituisciNumeroCamere() {
        return elencoCamere.size();
    }

}