package Main;
import java.util.*;

import model.Struttura;
import model.Cliente;
import model.Host;
import model.Utente;

public class Main {
    // Simuliamo un database in memoria
    private static List<Utente> databaseUtenti = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Utente utenteLoggato = null;

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== BENVENUTO NEL SISTEMA PRENOTAZIONI ===");
            System.out.println("1. Accesso Cliente");
            System.out.println("2. Accesso Host");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            int sceltaPrincipale = scanner.nextInt();
            scanner.nextLine(); // Pulisci buffer

            switch (sceltaPrincipale) {
                case 1 -> menuAccesso("CLIENTE");
                case 2 -> menuAccesso("HOST");
                case 0 -> exit = true;
                default -> System.out.println("Scelta non valida.");
            }
        }
    }

    private static void menuAccesso(String tipo) {
        System.out.println("\n--- Area " + tipo + " ---");
        System.out.println("1. Login");
        System.out.println("2. Registrazione");
        System.out.print("Scelta: ");
        int scelta = scanner.nextInt();
        scanner.nextLine();

        if (scelta == 1) {
            login(tipo);
        } else if (scelta == 2) {
            registrazione(tipo);
        }
    }

    private static void registrazione(String tipo) {
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Cognome: "); String cognome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Password: "); String pass = scanner.nextLine();

        if (tipo.equals("CLIENTE")) {
            System.out.print("Telefono: "); String tel = scanner.nextLine();
            System.out.print("Indirizzo Fatturazione: "); String ind = scanner.nextLine();
            // Creazione oggetto Cliente (id generato casualmente per l'esempio)
            Cliente c = new Cliente(nome, cognome, email, pass, "CLI-" + (databaseUtenti.size() + 1), tel, ind);
            databaseUtenti.add(c);
        } else {
            System.out.print("ID Host (Codice Univoco): "); String idHost = scanner.nextLine();
            System.out.print("Coordinate bancarie: "); String coordinate = scanner.nextLine();
            // Creazione oggetto Host
            Host h = new Host(nome, cognome, email, pass, idHost, coordinate);
            databaseUtenti.add(h);
        }
        System.out.println("Registrazione completata con successo!");
    }

    private static void login(String tipo) {
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Password: "); String pass = scanner.nextLine();

        for (Utente u : databaseUtenti) {
            if (u.geteMail().equals(email) && u.getPassword().equals(pass)) {
                // Controllo se il tipo di utente nel DB corrisponde a quello richiesto nel menu
                if ((tipo.equals("CLIENTE") && u instanceof Cliente) ||
                        (tipo.equals("HOST") && u instanceof Host)) {
                    utenteLoggato = u;
                    System.out.println("Login effettuato! Benvenuto " + u.getNome());
                    mostraDashboard(tipo);
                    return;
                }
            }
        }
        System.out.println("Errore: Credenziali errate o tipo di account non valido.");
    }

    private static void mostraDashboard(String tipo) {
        boolean logout = false;

        // Finché non sceglie di fare logout, rimane in questo menu
        while (!logout) {
            System.out.println("\n=== AREA PERSONALE " + tipo + " ===");
            System.out.println("Utente: " + utenteLoggato.getNome() + " " + utenteLoggato.getCognome());

            if (tipo.equals("CLIENTE")) {
                System.out.println("1. Cerca Struttura (da implementare)");
                System.out.println("2. Le mie Prenotazioni (da implementare)");
                System.out.println("0. Logout");
                System.out.print("Scelta: ");
                int scelta = scanner.nextInt();
                scanner.nextLine(); // Pulisci buffer

                switch (scelta) {
                    case 1 -> System.out.println("--- Funzione Cerca Struttura in costruzione ---");
                    case 2 -> System.out.println("--- Funzione Le mie Prenotazioni in costruzione ---");
                    case 0 -> logout = true; // Esce dal ciclo while
                    default -> System.out.println("Scelta non valida.");
                }

            } else if (tipo.equals("HOST")) {
                System.out.println("1. Aggiungi Struttura");
                System.out.println("2. Visualizza la mia Dashboard (Elenco strutture)");
                System.out.println("0. Logout");
                System.out.print("Scelta: ");
                int scelta = scanner.nextInt();
                scanner.nextLine(); // Pulisci buffer

                // Cast per poter usare i metodi specifici della classe Host
                Host hostAttuale = (Host) utenteLoggato;

                switch (scelta) {
                    case 1:
                        // Creazione dinamica di una Struttura
                        System.out.print("Inserisci Nome Struttura: ");
                        String nomeStruttura = scanner.nextLine(); // <-- Aggiunto input per il nome
                        System.out.print("Inserisci Indirizzo Struttura: ");
                        String indirizzo = scanner.nextLine();
                        System.out.print("Inserisci Categoria (numero di stelle): ");
                        int categoria = scanner.nextInt();
                        scanner.nextLine(); // Pulisci buffer

                        // NOTA: Ho aggiunto "nomeStruttura". Assicurati che l'ordine
                        // (nome, indirizzo, categoria) sia esattamente quello che hai
                        // nel costruttore del tuo file Struttura.java!
                        Struttura nuovaStruttura = new Struttura(nomeStruttura, indirizzo, categoria);

                        hostAttuale.aggiungiStruttura(nuovaStruttura);
                        System.out.println("Struttura aggiunta con successo!");
                        break;

                    case 2:
                        // Richiama il fantastico metodo che hai scritto tu nella classe Host!
                        System.out.println(hostAttuale.mostraDashboard());
                        break;

                    case 0:
                        logout = true; // Esce dal ciclo while
                        break;

                    default:
                        System.out.println("Scelta non valida.");
                }
            }
        }

        // Quando il ciclo finisce (logout = true), scolleghiamo l'utente
        utenteLoggato = null;
        System.out.println("Logout effettuato con successo. Arrivederci!");
    }
}
