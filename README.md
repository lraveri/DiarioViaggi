# Progetto finale per il corso di Programmazione Web

Applicazione che permette di salvare, visualizzare e modificare i propri viaggi.

## Funzionamento:
Nella schermata 'I Tuoi Viaggi', l'utente può selezionare una data e visualizzare una tabella in cui sono elencati i viaggi salvati effettuati in quella data.
Il record del viaggio contiene data, mezzo utilizzato, tappe principali, utente al quale è associato e percorso effettuato in formato GeoJSON.
L'utente può visualizzare il percorso sulla mappa premendo il tasto 'Visualizza'.
Tramite la schermata 'Nuovo Viaggio', l'utente potrà inserire un nuovo viaggio, compilando i campi data, mezzo, tappe principali e percorso (l'utente dovrà inserire il percorso effettuato in formato GeoJSON).
Tramite la schermata 'Modifica Viaggio' l'utente può selezionare un viaggio precedentemente inserito e può modificarne i vari campi.

## Implementazione:
Per la parte di login, è stata utilizzata la Declarative Security di Tomcat, come visto a lezione.
Per la parte di Backend, è stata realizzata una RestAPI in Java ed è stato utilizzato MongoDB come database, sullo schema di quanto visto a lezione.
Per la parte di Frontend, è stato utilizzato VueJS e in particolare VueCLI.
Per la visualizzazione della mappa è stato utilizzato Leaflet.
Per la parte di stile è stato utilizzato Bootstrap.
In generale sono state riviste e utilizzate tutte le tecnologie per lo sviluppo di Applicazioni Web viste a lezione.
