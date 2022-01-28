# Progetto finale per il corso di Programmazione Web

Applicazione che permette di salvare, visualizzare e modificare i propri viaggi.

## Funzionamento:
Nella schermata 'I Tuoi Viaggi', l'utente può selezionare una data e visualizzare una tabella in cui sono elencati i viaggi salvati effettuati in quella data.<br>
Il record del viaggio contiene data, mezzo utilizzato, tappe principali, utente al quale è associato e percorso effettuato in formato GeoJSON.<br>
L'utente può visualizzare il percorso sulla mappa premendo il tasto 'Visualizza'.<br>
Tramite la schermata 'Nuovo Viaggio', l'utente potrà inserire un nuovo viaggio, compilando i campi data, mezzo, tappe principali e percorso (l'utente dovrà inserire il percorso effettuato in formato GeoJSON).<br>
Tramite la schermata 'Modifica Viaggio' l'utente può selezionare un viaggio precedentemente inserito e può modificarne i vari campi.<br>

## Implementazione:
Per la parte di login, è stata utilizzata la Declarative Security di Tomcat, come visto a lezione.<br>
Per la parte di Backend, è stata realizzata una RestAPI in Java ed è stato utilizzato MongoDB come database, sullo schema di quanto visto a lezione.<br>
Per la parte di Frontend, è stato utilizzato VueJS e in particolare VueCLI.<br>
Per la visualizzazione della mappa è stato utilizzato Leaflet.<br>
Per la parte di stile è stato utilizzato Bootstrap.<br>
In generale sono state riviste e utilizzate tutte le tecnologie per lo sviluppo di Applicazioni Web viste a lezione.<br>

## Demo e frontend files
Una demo del progetto è disponibile su <br>
https://www.youtube.com/watch?v=s-144WD99Sw <br>
<br>
I file relativi al frontend sono disponibili nella directory webapp/frontend-files <br>
