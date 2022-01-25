# Progetto Mentcare - Ingegneria del Software
*Elisa Acciari VR478828 , Giulio Cappelletti VR478827
A.A. 2021/2022 
Università degli Studi di Verona.*

## Assunzioni iniziali
Un membro del personale medico può fare parte di una sola clinica.
Una clinica è divisa in ambulatori.
Il sistema prevede le seguenti tipologie di utenti
 - medico
 - infermiere
 - receptionist
 - paziente
 - manager
 
Il personale della clinica presenta i ruoli di: 
 - medico
 - infermiere
 - receptionist
 
I pazienti in base al giudizio del medico sono suddivisi in:
-pazienti autosufficienti, che sono ritenuti in grado di aggiornare in modo autonomo la propria situazione di somministrazione dei farmaci.
-pazienti non autosufficienti, la cui somministrazione dei farmaci è gestita dagli infermieri.

Un’ulteriore estensione del progetto dovrebbe prevedere che un receptionist possa creare e visualizzare appuntamenti solamente per il personale medico e per i pazienti della sua stessa clinica.

# Requisiti
Per la realizzazione del nostro Sistema informativo Mentcare abbiamo condotto una prima fase di analisi e specifica dei requisiti:
- Raccolta dei requisiti tramite realizzazione di Scenari
- Dagli scenari sono scaturite le funzionalità del sistema ed i requisiti funzionali e non funzionali
##  Scenari
### 1)  Registrazione paziente
#####  *Assunzione iniziale*
Successivamente alla prima visita medica, il nuovo paziente viene registrato nel database dal medico. 

#####  *Come si concretizza*
Il medico accede alla sezione "registra paziente" dalla sua pagina profilo. In questa andrà ad inserire le informazioni del paziente, tra cui il codice fiscale e l'username, che dovranno essere univoci, la patologia da cui e' affetto e la descrizione relativa, infine se il paziente è autosufficiente o meno. Successivamente per confermare ed inviare i dati al sistema andra' a premere il rispettivo bottone.

#####  *Cosa può andare storto*
Se il codice fiscale inserito è già presente nel database, il sistema generera' un messaggio di errore e il medico potrà tornare indietro risolvere il problema.
Se l'username e' gia' presente nel database, il sistema generera' un messaggio di errore e il medico potra' tornare indietro risolvere il problema.
Si dovranno inserire tutte le informazioni affinche' sia possibile registrare il paziente.

#####  *Altre attivita'*
Il sistema, durante la registrazione, assocerà automaticamente quel paziente al medico che lo sta registrando.

#####  *Completamento scenario*
Quando tutti i campi sono stati inseriti correttamente e il medico ha cliccato il bottone di registrazione, il sistema generera' un messaggio di successo.


### 2) Login
##### *Assunzione iniziale*
Un utente, già registrato, per entrare nel sistema informativo deve inserire le proprie credenziali nella sezione login.

##### *Come si concretizza* 
L’utente che vuole effettuare il login, inserisce le proprie credenziali, username e password, specificando anche il suo ruolo all’interno del sistema informativo(infatti un utente può essere un “medico”, un “infermiere”, un “receptionist”, un “paziente”). Dopo aver inserito i dati, l’utente preme il bottone sottostante  per inviare i dati al sistema, che verificherà se l’account è o meno presente.

##### *Altre attività*
Nella fase di login il sistema andrà a verificare il ruolo dell’utente che si vuole loggare e lo reindirizzerà alla pagina corretta.

##### *Cosa può andare storto*
L’utente può:
  - inserire credenziali errate
  -lasciare vuoti i campi “username” e/o “password” e/o “ruolo”
  -Selezionare un ruolo non associato ai suoi dati(anche se presenti nel database) 
Se l’utente commette uno di questi errori e preme il bottone “invia”, risulterà un messaggio d’errore che indicherà che l’account non è presente. 

##### *Come si completa*
Se i dati inseriti dall’utente sono corretti, esso viene reindirizzato nella propria pagina profilo.

### 3) Inserimento Farmaci
##### *Assunzione iniziale*
Un medico vuole inserire nella cartella di un suo specifico paziente i farmaci che egli dovrà assumere.

##### *Come si concretizza*
Il medico, dalla sua pagina profilo, può accedere alla sezione “visualizza paziente” per visualizzare la lista di tutti i suoi pazienti.
Il medico può inserire nuovi farmaci per ogni paziente, infatti premendo il rispettivo bottone “inserisci farmaco”  sarà reindirizzato in una pagina dove dovrà inserire:
- i dati del farmaco
- il numero di dosi che dovranno essere assunte in ogni giorno
- il numero di giorni in cui il paziente dovrà assumere quel determinato farmaco

##### *Cosa può andare storto*
Se il medico per uno stesso paziente inserisce più farmaci con lo stesso identificativo , apparirà una pagina di errore, la quale indicherà che lo stesso id farmaco è già presente.

##### *Come si completa*
Se i dati inseriti dal medico sono corretti,  apparirà una schermata che conferma il corretto inserimento del farmaco

##### *Altre attività*
Il sistema passa in modo automatico i dati del paziente selezionato e del medico, affinché il farmaco risulti associato ad un determinato paziente e si possa sapere quale medico prescrive quale farmaco



### 4) Somministrazione farmaci
##### *Assunzione iniziale*
Il sistema permette di tenere traccia della somministrazione della dose giornaliera di un farmaco,  comprendera' anche la funzionalita' di segnare le somministrazione dei farmaci per i vari pazienti. 

##### *Come si concretizza*
Le somministrazioni potranno essere svolte sia dal paziente, se questi e' autosufficiente, o, nel caso in cui non lo sia,  dall'infermiere.
Se il paziente e' autosufficiente gli bastera' accedere alla sezione "visualizza farmaci" in cui potra' vedere tutti i farmaci a lui assegnati con i relativi dati per ognuno, tra cui  la dose giornaliera ed il numero di giorni mancanti al completamento del ciclo di assunzione.
Se, invece, non gli e' stato assegnato nessun medicinale, il sistema generera' il messaggio "farmaci non presenti".

Nel caso in cui il paziente non e' autosufficiente, solo l'infermiere potra' accedere alla sua somministrazione dei farmaci. 
Infatti nella sua pagina profilo, l'infermiere potra' andare nella pagina "visualizza paziente" per vedere tutta la lista dei pazienti.
Per ogni paziente potra' essere visualizzato il relativo status dei farmaci ancora da assumere, ma per i soli pazienti non autosufficienti si avra' la possibilita' di registrare la somministrazione di un farmaco.
 Sia l'infermiere che il paziente avranno una pagina relativa ai farmaci gia' somministrati che viene aggiornata ogni qual volta che viene somministrato un farmaco.


#####  *Altre attivita'*
Inoltre ogni volta che un farmaco viene somministrato va ad aumentare di uno il numero di giorni in cui il farmaco e' stato somministrato nella pagina "Farmaci somministrati".
Questo per segnare da quanto tempo il paziente sta assumendo quella medicina.

##### *Completamento scenario*
Una volta cliccato il bottone "somministra", il sistema generera' un messaggio di successo per indicare la corretta somministrare.
Nel caso in cui, il medico somministra un farmaco con un solo giorno rimanente, il sistema generera' un messaggio di "completamento farmaco" e lo eliminera' dalla lista della visualizzazione dei farmaci del paziente.

### 5) Inserimento Appuntamenti

##### *Assunzione iniziale*
Al receptionist viene comunicato di prendere un appuntamento per un paziente.
Può essere sia un appuntamento per farsi somministrare dei farmaci da un infermiere, sia un appuntamento per una visita medica

##### *Come si concretizza*
Il receptionist nella sua pagina profilo ha una sezione per inserire nuovi appuntamenti, infatti inserendo il codice fiscale del paziente e del medico/infermiere per cui si vuole registrare l’appuntamento, sarà reindirizzato in una pagina in cui dovrà inserire i dettagli dell’appuntamento.

##### *Cosa può andare storto* 
Il receptionist può inserire in modo errato il codice fiscale del paziente oppure del medico/infermiere, in tal caso sarà reindirizzato ad una pagina di errore la quale indicherà che l’account ricercato non è presente.

##### *Come si completa* 
Se il receptionist ha inserito correttamente i codici fiscali del paziente e del medico/infermiere e tutti i dati dell’appuntamento, allora apparirà una schermata che confermerà che l’appuntamento è stato correttamente inserito nel database.

##### *Altre attività*
Il sistema inserisce in modo automatico i dati significativi del paziente e del medico/infermiere nell’appuntamento

### 6) Visualizza Appuntamenti
##### *Assunzione iniziale*
Un utente generico del sistema vuole visionare gli appuntamenti.
Se l’utente è un paziente/infermiere/medico può visualizzare solo i suoi appuntamenti.
Se l’utente è un receptionist può visualizzare tutti gli appuntamenti presenti.

##### *Come si concretizza*
Un uten te può visualizzare gli appuntamenti tramite l’apposita sezione “visualizza appuntamenti”, con la possibilità di filtrare la ricerca per codice fiscale. E successivamente premere l’apposito bottone per visualizzare gli appuntamenti.

##### *Cosa può andare storto*
Se vengono ricercati gli appuntamenti filtrando per codice fiscale, possono sorgere due errori:
-il codice fiscale non risulta associato a nessun appuntamento e si viene reindirizzati ad una pagina di errore che indica che non vi sono appuntamenti presenti.
-il codice fiscale non risulta associato a nessun utente nel database e si viene reindirizzati ad una pagina di errore che indica che non vi è un account presente con quel rispettivo codice fiscale.

##### *Come si completa*
Se non è stato inserito alcun codice fiscale allora il sistema mostrerà la lista di tutti gli appuntamenti presenti.
Se il medico/infermiere/paziente hanno filtrato per codice fiscale allora il sistema visualizzerà i soli appuntamenti associati a quel codice fiscale.
Se il receptionist ha filtrato per codice fiscale sia del paziente che dell’infermiere/medico allora verrà visualizzata solamente la lista degli appuntamenti che contengono entrambi i codici fiscali. 

##### *Altre attività*
Quando il medico/infermiere/paziente visualizzano degli appuntamenti, il sistema in automatico presenta solo i rispettivi appuntamenti associati al codice fiscale dell’utente che li ricerca

### 7) Visualizza Pazienti 
##### *Assunzione iniziale*
La visualizzazione dei pazienti puo' essere svolta sia dai medici che dagli infermieri.
I medici possono visualizzare la lista delle sole persone che sono suoi pazienti.
Gli infermieri invece possono visualizzare tutti i pazienti.

##### *Come si concretizza*
Sia gli infermieri che i medici potranno accedere dalla loro pagina profilo a questa funzione cliccando il bottone "visualizza paziente".
Potranno inserire anche il codice fiscale del relativo paziente che vogliono visualizzare, se invece non inseriranno niente li visualizzeranno tutti, con le relative informazioni.

##### *Cosa può andare storto*
Se il codice fiscale e' stato inserito in modo errato oppure non risulta associato a nessun account presente nel sistema, il sistema generera' il messaggio di errore per indicare che l'account non e' stato ttrovato.

##### *Altre attivita'*
Quando il medico andra' a cliccare il bottone di visualizzazione, potra' vedere solamente i pazienti a lui associati.

##### *Completamento scenario*
Se non e' stato inserito alcun codice fiscale, il sistema generera' la lista di tutti i pazienti, altrimenti solo le informazioni della persona associata a quel codice fiscale.

## Specifica dei requisiti 

### Requisiti Funzionali

Un medico deve essere in grado di:

 - Registrare pazienti nel DB
 - Registrare farmaci per ogni paziente
 - Visualizzare la lista di informazioni e stato dei farmaci di tutti i suoi pazienti, con la possibilità di ricercare i pazienti per codice fiscale
 - Visualizzare la lista di farmaci somministrati di ogni paziente
 - Visualizzare la lista dei suoi appuntamenti, con la possibilità di ricercare i pazienti per codice fiscale

Un infermiere deve essere in grado di:
 - Aggiornare la somministrazione dei farmaci per i soli pazienti non autosufficienti
 - Visualizzare la lista di informazioni e stato dei farmaci di tutti i suoi pazienti, con la possibilità di ricercare i pazienti per codice fiscale
 - Visualizzare la lista di farmaci assunti da ogni paziente
 - Visualizzare la lista dei suoi appuntamenti, con la possibilità di filtrare i pazienti per codice fiscale

Un receptionist deve essere in grado di:

 - Registrare gli appuntamenti  inserendo il codice fiscale del paziente e del personale medico(infermiere o medico) per cui si vuole creare l’appuntamento
 - Visualizzare la lista di tutti gli appuntamenti, con la possibilità di ricercare per codice fiscale del paziente o del medico

Un paziente autosufficiente deve essere in grado di:
 - Aggiornare la propria somministrazione dei farmaci
 - Visualizzare la lista di tutti i suoi appuntamenti, con la possibilità di ricercare un appuntamento tramite il codice fiscale del medico
 - Visualizzare il proprio status dei farmaci ancora da assumere e di quelli già somministrati
 
Un paziente non autosufficiente deve essere in grado di:
 - Visualizzare la lista di tutti i suoi appuntamenti, con la possibilità di ricercare un appuntamento tramite il codice fiscale del medico
 - Visualizzare il proprio status dei farmaci ancora da assumere e di quelli già somministrati
 
Tutti gli utenti del sistema devono essere in grado di eseguire il login

Il personale medico(infermiere/medico) oltre a poter visualizzare i farmaci per ogni paziente possono anche visualizzare i farmaci che quel paziente ha assunto, e chi ha somministrato quel farmaco

il manager deve essere in grado di 

 - registrare il personale medico
 - visualizzare tutto il personale medico presente
 - accedere alla sua area riservata tramite secret key

il sistema tiene  traccia di chi somministra i farmaci 
il sistema tiene  traccia di quale medico inserisce quale farmaco

### Requisiti non funzionali
Un receptionist non può visualizzare la lista dei pazienti della clinica
Un receptionist non può visualizzare, ne interagire con la lista dei farmaci di un paziente
Un paziente non autosufficiente non può aggiornare la propria somministrazione dei farmaci.
Solo l’infermiere può somministrare farmaci ai soli pazienti non autosufficienti
Solo il manager può registrare i membri del personale
Il medico può visionare le informazioni dei soli suoi pazienti
Quando per un dato paziente si procede a somministrare un farmaco nella “lista dei farmaci ancora da somministrare”, il numero di giorni di quel farmaco scende di uno, e viene registrato nella “lista dei farmaci già somministrati”
Un farmaco sarà costituito anche dal campo che indica il costo del farmaco, in vista di aggiunte di funzionalità che prevedono report per il costo dei farmaci
Solo il medico può inserire i farmaci associati ad un paziente
Solo il medico può registrare nuovi pazienti
I farmaci sono suddivisi in dose giornaliera e numero di giorni per cui devono essere assunte. 
Il sistema, per fini legali e giuridici, prevede che: 
 - ogni farmaco assegnato ad un paziente è associato anche al medico che lo ha prescritto. 
 - il sistema tiene traccia di chi effettua la somministrazione di una dose giornaliera di un farmaco.
 - il sistema prevede che un paziente ritenuto non autosufficiente, non possa aggiornare la propria somministrazione dei farmaci.
Nella descrizione di un appuntamento è previsto un campo indirizzo per inserire l’indirizzo della clinica o l’indirizzo del paziente qualora richiedesse la visita a domicilio.

# Design
Successivamente alla fase di raccolta e specifica dei requisiti abbiamo provveduto a realizzare un primo design di alto livello della struttura del progetto software tramite interfacce 

 - Manager 
 - Utente   
	 - Receptionist extends Utente
	 - Paziente extends Utente   
	 - Staff extends Utente
		 - Infermiere extends Personale medico
		 - Medico extends Personale Medico 

# Testing

### Scenario registrazione
TestRegistrazionePazienteValida

> 	Il medico cerca di registrare un nuovo paziente. Verrà reindirizzato ad una pagina che conferma il corretto inserimento del paziente nel database.

TestRegistrazionePazienteNonValidaUsername

> Il medico cerca di registrare il paziente con un username già registrato. Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.

	 
TestRegistrazionePazienteNonValidaCodFiscale
> Il medico cerca di registrare il paziente con un codice fiscale già registrato.  Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.	
	
TestRegistrazionePersonaleValida
> Il manager cerca di registrare un nuovo dipendente.  Verrà reindirizzato ad una pagina che conferma il corretto inserimento del personale nel database.

TestRegistrazionePersonaleNonValidaUsername
> Il medico cerca di registrare il personale con un username già registrato.  Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.

TestRegistrazionePersonaleNonValidaCodFiscale
> Il medico cerca di registrare il personale con un codice fiscale già registrato.  Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.

### Scenario login
TestLoginValido
> L'utente cerca di loggarsi.  Verrà reindirizzato alla sua pagina profilo.

TestLoginNonValidoUsername
> L'utente cerca di loggarsi con un username non valido.  Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.

TestLoginNonValidoPassword
> L'utente cerca di loggarsi con una password non valida.  Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.


### Scenario somministrazione
TestSomministrazioneValida
> L'infermiere tenta di somministrare un farmaco ad un paziente. Verrà reindirizzato ad una pagina che gli notifica che la somministrazione è andata a buon fine.

TestSomministrazineCompletata
> L'infermiere tenta di somministrare ad un paziente un farmaco che ha numero di giorni rimanenti per l'assunzione uguale ad 1. Verrà reindirizzato ad una pagina che gli notifica che la somministrazione del farmaco è completa.

### Scenario inserimento farmaci 
TestInserimentoFarmaco
>Il medico tenta di inserire un nuovo farmaco ad un paziente. Verrà reindirizzato ad una pagina che gli notifica il corretto inserimento del farmaco.

TestInserimentoFarmavoNonValitoIdFarmacoDuplicatoPerPaziente
>Il medico tenta di inserire un nuovo farmaco ad un paziente, con un codice del farmaco che è già presente nella lista dei farmaci di quel paziente. Verrà reindirizzato ad una pagina che gli notifica il messaggio d'errore.

### Scenario inserimento appuntamenti
TestInserimentoAppuntamentoValido
>Il receptionist cerca di inserire un nuovo appuntamento. Verrà reindirizzato ad una pagina che gli notifica il corretto inserimento dell'appuntamento.

TestInserimentoaAppuntamentoNonValitoCodPaziente
>Il receptionist digita in modo errato il codice fiscale del paziente. Verrà reindirizzato ad una pagina che gli notifica che l'account non è presente nel database.

TestInserimentoApputamentoNonValidoCodPersonale
>Il receptionist digita  in modo errato il codice fiscale del personale medico. Verrà reindirizzato ad una pagina che gli notifica che l'account non è presente nel database.

TestInserimentoAppuntamentoNonValidoCodPazienteCodPersonale
>Il receptionist digita  in modo errato sia il codice fiscale del personale medico sia quello del paziente. Verrà reindirizzato ad una pagina che gli notifica che l'account non è presente nel database.

### Scenario visualizza appuntamenti
TestVisualizzaAppuntamento
>Il receptionist cerca di visualizzare la lista degli appuntamenti lasciando i campi codici fiscale vuoti. Verrà reindirizzato alla pagina che mostra la lista di tutti gli appuntamenti.

TestViasualizzaAppuntamentoConEntrambiCF
>Il receptionist cerca di visualizzare la lista degli appuntamenti inserendo entrambi i campi codici fiscale. Verrà reindirizzato alla pagina che mostra la lista gli appuntamenti relativi a entrambi quei codici fiscali.

TestVisualizzaAppuntamentoConCFPaziente
>Il receptionist cerca di visualizzare la lista degli appuntamenti inserendo solo il codice fiscale del paziente. Verrà reindirizzato alla pagina che mostra la lista gli appuntamenti relativi al paziente.

TestVisualizzaAppuntamentoConCFPersonale
>Il receptionist cerca di visualizzare la lista degli appuntamenti inserendo solo il codice fiscale del personale. Verrà reindirizzato alla pagina che mostra la lista gli appuntamenti relativi al personale.

TestVisualizzaAppuntamentoNonPresente
>Il receptionist cerca di visualizzare la lista degli appuntamenti inserendo entrambi i campi codici fiscale. Verrà reindirizzato ad una pagina che gli notifica che l'appuntamento non è presente.

TestVisualizzaAppuntamentoPersonaleNonPresente
>Il receptionist cerca di visualizzare la lista degli appuntamenti inserendo in modo errato il codice fiscale del personale . Verrà reindirizzato ad una pagina che gli notifica che l'account non è presente.

### Scenario visualizza pazienti
TestVisualizzaPazienteValida
>Il medico cerca di visualizzare la lista di tutti i pazienti lasciando il campo codici fiscale vuoti. Verrà reindirizzato alla pagina che mostra la lista di tutti i suoi pazienti.

TestVisualizzaPazienteCodFiscaleValida
>Il medico cerca di visualizzare un suo paziente inserendo il suo codice fiscale. Verrà reindirizzato alla pagina che mostra le informazioni di quel paziente.

TestVisualizzaPazientiNonValida
>Il medico cerca di visualizzare un suo paziente inserendo in modo errato il suo codice fiscale. Verrà reindirizzato alla pagina che gli notifica che l'account non è presente.


