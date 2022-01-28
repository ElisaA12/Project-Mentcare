package univr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Controller
public class AppController implements univr.structure.PazienteNonAutoSufficiente, univr.structure.PazienteAutoSufficiente, univr.structure.Receptionist,
        univr.structure.Medico, univr.structure.Infermiere, univr.structure.Manager {

    @Autowired
    private AppuntamentoRepository appuntamentoRepository;
    @Autowired
    private PazienteRepository pazienteRepository;
    @Autowired
    private SomministratiFarmaciRepository farmaciSomministratiRepository;
    @Autowired
    private PersonaleMedicoRepository personaleMedicoRepository;
    @Autowired
    private FarmaciRepository farmaciRepository;

    public boolean valida_CF(String cf, String ruolo){
        if(ruolo.equals("Medico") || ruolo.equals("Receptionist") || ruolo.equals("Infermiere")) {

            Optional<PersonaleMedico> result = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(cf));
            return result.isPresent();
        }
        else{
            Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByCodFiscale(cf));
            return paziente.isPresent();
        }
    }
    public boolean valida_username(String username, String ruolo){
        if(ruolo.equals("Medico") || ruolo.equals("Receptionist") || ruolo.equals("Infermiere")) {

            Optional<PersonaleMedico> result = Optional.ofNullable(personaleMedicoRepository.findByUsername(username));
            return result.isPresent();
        }else{
            Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByUsername(username));
            return paziente.isPresent();
        }
    }
    public boolean valida_idF(String idF, String codPaziente){

        Optional<Farmaci> result = Optional.ofNullable(farmaciRepository.findByIdFarmaco(idF));
        if (result.isPresent()) {
            for (Farmaci f: farmaciRepository.findAll()){
                if(f.getCodPaziente().equals(codPaziente) && f.getIdFarmaco().equals(idF)){
                    return true;
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() throws ParseException {

        return "login";
    }

    //Login Features

    //Consente di ritornare alla login page, dove inserire le credenziali
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    //Login utente
    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public String loginP(@RequestParam(name = "username", required = true) String username,
                         @RequestParam(name = "password", required = true) String password,
                         Model model) {
        Optional<PersonaleMedico> result = Optional.ofNullable(personaleMedicoRepository.findByUsername(username));
        Optional<Paziente> result2 = Optional.ofNullable(pazienteRepository.findByUsername(username));
        //se il personale medico è presente nel db lo reindirizzo alla sua profile page
        if (result.isPresent()) {
            PersonaleMedico persona = result.get();
            if(persona.getPassword().equals(password)) {
                model.addAttribute("personale", persona);
                return "profilePage" + persona.getRuolo();
            }else{
                return "Errori/personaNonTrovata";
            }
        }
        //se il paziente è presente nel db lo reindirizzo alla sua profile page
        else if (result2.isPresent()) {
            Paziente persona = result2.get();
            if(persona.getPassword().equals(password)) {
                model.addAttribute("paziente", persona);
                if (persona.isAutosufficiente()) {
                    return "profilePagePaziente";
                } else {
                    return "profilePagePazienteNonAuto";
                }
            }else{
                return "Errori/personaNonTrovata";
            }
        } else {
            return "Errori/personaNonTrovata";
        }
    }

    //log out
    @RequestMapping(value = "/loggout", method = RequestMethod.GET)
    public String loggout(){
        return "redirect:/login";
    }

    //Manager Features

    //Reindirizza alla pagina dove si deve inserire la secret key per accedere all'area riservata
    @RequestMapping(value = "/loginManager", method = RequestMethod.GET)
    public String loginManager() {
        return "loginManager";
    }
    //login del manager
    @RequestMapping(value = "/logManager", method = RequestMethod.POST )
    public String logManager( @RequestParam(name = "chiave", required = true) String key, Model model){
        if(key.equals("key")){

            return "/profilePageManager";
        }
        return "Errori/chiaveErrata";
    }
    //Reindirizza il manager alla pagina per registrare nuovo personale
    @RequestMapping(value = "/nuovoPersonale" , method = RequestMethod.GET)
    public String nuovoPersonale( Model model) {
        model.addAttribute(new PersonaleMedico());
        return "nuovoPersonale";
    }
    //Registrazione nuovo account di un membro dello staff
    @RequestMapping(value = "/createAccPers", method = RequestMethod.POST )
    public String createAccPersonale( @ModelAttribute PersonaleMedico personale) {
        if(valida_CF(personale.getCodFiscale(), personale.getRuolo())) {
            return "Errori/codFiscaleDuplicato";
        }else if(valida_username(personale.getUsername(), personale.getRuolo())){
            return "Errori/usernameDuplicato";
        }else {
            personaleMedicoRepository.save(personale);
            return "Verifiche/accountCreato";
        }
    }
    //Visualizzazione del personale medico
    @RequestMapping(value = "/mostraPersonale",  method = RequestMethod.GET )
    public String mostraPersonale(@RequestParam(name = "codPersonale") String codPersonale, Model model) {
        List<PersonaleMedico> personale = new LinkedList<>();
        //Se il campo per ricercare tramite cod fiscale è vuoto allora compare tutta la lista del personale medico, altrimenti compare
        // il solo dipendente con quel codice fiscale
        if (codPersonale.equals("")) {
            for (PersonaleMedico p : personaleMedicoRepository.findAll()) {
                personale.add(p);
            }
        }
        else {
            Optional<PersonaleMedico> personaleMedico = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
            if (personaleMedico.isPresent()) {
                personale.add(personaleMedicoRepository.findByCodFiscale(codPersonale));}
            else {return "Errori/personaNonTrovata";}
        }
        if(personale.isEmpty()){return "Errori/personaNonTrovata";}

        model.addAttribute("persona", personale);
        return "mostraPersonale";
    }

    //Users Features

    //Reindirizza il medico alla pagina per registrare un nuovo paziente
    @RequestMapping(value = "/nuovoPaziente",  method = RequestMethod.GET )
    public String nuovoPaziente(@RequestParam(name = "cod") String codPersonale,  Model model) {

        Optional<PersonaleMedico> result = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
        if (result.isPresent()) {
            PersonaleMedico person = result.get();
            model.addAttribute("medico", person);
            model.addAttribute(new Paziente());
            //alla pagina nuovoPaziente passo un oggetto
            return "nuovoPaziente";
        }
        else{
            return "Errori/personaNonTrovata";}
    }
    //Registrazione nuovo paziente, utilizzata solamente dal medico
    @RequestMapping(value = "/createAcc",  method = RequestMethod.POST )
    public String create( @ModelAttribute Paziente paziente, Model model) {
        if(valida_CF(paziente.getCodFiscale(), "paziente")) {
            return "Errori/codFiscaleDuplicato";
        }
        else if(valida_username(paziente.getUsername(), "paziente")){
            return "Errori/usernameDuplicato";
        }
        else {
            pazienteRepository.save(paziente);
            return "Verifiche/accountCreato";
        }

    }
    //Reindirizza il medico o l'infermiere alla pagina per visualizzare le informazioni del paziente/i
    @RequestMapping(value = "/visualizzaPaziente", method = RequestMethod.GET )
    public String visualizzaPaziente(@RequestParam(name = "codPersonale") String codPersonale, @RequestParam(name = "codPaziente") String codPaziente,
                                     Model model) {

        List<Paziente> pazienti = new LinkedList<>();
        //la variabile ruolo indica la pagina a cui sarà reindirizzato l'utente, se l'utente è un medico sarà reindirizzato a mostraPaziente
        //ma se l'utente è un infermiere sarà reindirizzato a mostraPazienteInfermiere
        String ruolo="";
        Optional<PersonaleMedico> personaleMedico = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));

        //Controllo se il personale medico è presente
        if(personaleMedico.isPresent()) {
            PersonaleMedico personaleMedico1 = personaleMedico.get();
            if (personaleMedico1.getRuolo().equals("Medico")) {
                ruolo="mostraPaziente";
                //controllo se la ricerca è o meno filtrata per codice fiscale
                if (codPaziente.equals("")) {
                    for (Paziente p : pazienteRepository.findAll()) {
                        if (p.getCodiceMedico().equals(codPersonale)) {
                            pazienti.add(p);
                        }
                    }
                }
                else {
                    Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));
                    if (paziente.isPresent()) {
                        for (Paziente p : pazienteRepository.findAll()) {
                            if (p.getCodiceMedico().equals(codPersonale) && p.getCodFiscale().equals(codPaziente)) {
                                pazienti.add(p);}}
                    }
                    else {return "Errori/personaNonTrovata";}
                }

            }
            else if (personaleMedico1.getRuolo().equals("Infermiere")) {
                ruolo="mostraPazienteInfermiere";
                if (codPaziente.equals("")) {
                    for (Paziente p : pazienteRepository.findAll()) {
                        pazienti.add(p);}
                }
                else {
                    for (Paziente p : pazienteRepository.findAll()) {
                        if (p.getCodFiscale().equals(codPaziente)) {
                            pazienti.add(p);}}
                }
            }
        }
        //il caso in cui il personale medico non è presente nel db
        else{return "Errori/personaNonTrovata";}

        //controllo se la lista dei pazienti è o meno vuota
        if(pazienti.isEmpty()){return "Errori/personaNonTrovata";}

        model.addAttribute("pazienti", pazienti);
        model.addAttribute("personaleCod", codPersonale);
        return ruolo;
    }

    //Features Appuntamento

    //reindirizza il receptionist alla pagina per inserire l'appuntamento, passandogli
    // il cod fiscale del paziente e del medico/infermiere per cui si vuole realizzare l'appuntamento
    @RequestMapping(value = "/inserisciAppuntamento", method = RequestMethod.GET)
    public String inserisciAppuntamento(@RequestParam(name = "codPersonale") String codPersonale,
                                        @RequestParam(name = "codPaziente") String codPaziente, Model model) {
        Optional<PersonaleMedico> result = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
        Optional<Paziente> result1 = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));
        if ( result.isPresent() && result1.isPresent()) {
            PersonaleMedico person = result.get();
            Paziente persona = result1.get();
            model.addAttribute("personale", person);
            model.addAttribute("paziente", persona);
            model.addAttribute(new Appuntamento());
            return "Appuntamenti/inserisciAppuntamento";
        } else
            return "Errori/personaNonTrovata";
    }
    //Salva nuovo appuntamento nel db
    @RequestMapping(value = "/inserisciApp", method = RequestMethod.POST)
    public String inserisciApp(@ModelAttribute Appuntamento appuntamento){
        appuntamentoRepository.save(appuntamento);
        return "Verifiche/appuntamentoInserito";
    }
    //Reindirizza alla pagina in cui si visualizzano gli appuntamenti
    @RequestMapping(value = "/mostraAppuntamento", method = RequestMethod.GET)
    public String mostraAppuntamento(@RequestParam(name = "codPersonale") String codPersonale, @RequestParam(name = "codPaziente") String codPaziente, Model model) {

        List<Appuntamento> appuntamento = new LinkedList<>();
        //Se il campo cod fiscale del paziente è lasciato vuoto si visionerà
        // la lista di tutti gli appuntamenti di quel membro del personale medico
        if (codPaziente.equals("") & !codPersonale.equals("")) {
            Optional<PersonaleMedico> personaleMedico = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
            if (personaleMedico.isPresent()) {
                for (Appuntamento app : appuntamentoRepository.findAll()) {
                    if (app.getCodFiscalePersonale().equals(codPersonale)) {
                        appuntamento.add(app);
                    }}
            }
            else{return "Errori/personaNonTrovata";}
        }
        //Se il campo cod fiscale del personale medico è lasciato vuoto si visionerà
        // la lista di tutti gli appuntamenti di quel paziente
        else if (codPersonale.equals("") & !codPaziente.equals("")) {

            Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));

            if (paziente.isPresent()) {

                for (Appuntamento app : appuntamentoRepository.findAll()) {
                    if (app.getCodFiscalePaziente().equals(codPaziente)) {
                        appuntamento.add(app);
                    }}
            }
            else{return "Errori/personaNonTrovata";}

        }

        //Se vengono inseriti entrambi i cod fiscali in modo corretto
        //si visioneranno gli appuntamenti con entrambi i i cod fiscali associati
        else if (!codPersonale.equals("") & !codPaziente.equals("")) {

            Optional<PersonaleMedico> personaleMedico = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
            Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));

            if (personaleMedico.isPresent() & paziente.isPresent()) {

                for (Appuntamento app : appuntamentoRepository.findAll()) {
                    if (app.getCodFiscalePersonale().equals(codPersonale) & app.getCodFiscalePaziente().equals(codPaziente)) {
                        appuntamento.add(app);
                    }
                }

            }
            else{return "Errori/personaNonTrovata";}
        }
        //Se i campi cod fiscale sono lasciati vuoti
        //si visioneranno tutti gli appuntamenti
        else {
            for (Appuntamento app : appuntamentoRepository.findAll()) {
                appuntamento.add(app);
            }
        }
        if(appuntamento.isEmpty()){return "Errori/appuntamentiNonTrovati";}

        model.addAttribute("App", appuntamento);
        return "Appuntamenti/mostraAppuntamento";
    }

    //Features farmaci
    //Reindirizza il medico alla pagina per l'inserimento di un nuovo farmaco
    @RequestMapping(value = "/inserisciFarmaco", method = RequestMethod.GET)
    public String inserisciFarmaco(@RequestParam(name = "codPaziente") String codPaziente,
                                   @RequestParam(name = "codPersonale") String codPersonale,
                                   Model model) {
        Optional<Paziente> paziente = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));
        Optional<PersonaleMedico> personaleMedico = Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
        if(!paziente.isPresent() || !personaleMedico.isPresent()){
            return "Errori/personaNonTrovata";
        }
        Paziente paziente1 = paziente.get();
        model.addAttribute("paziente", paziente1);
        model.addAttribute(new Farmaci());
        return "Farmaci/inserisciFarmaco";
    }
    //Salva il nuovo farmaco nel database
    @RequestMapping(value = "/inserisciFarm", method = RequestMethod.POST)
    public String inserisciFarm(@ModelAttribute Farmaci farmaco){
        if(valida_idF(farmaco.getIdFarmaco(), farmaco.getCodPaziente())){
            return "Errori/idFarmacoDuplicato";
        }
        farmaciRepository.save(farmaco);
        return "Verifiche/farmaciTrovati";
    }
    //Quando per un dato paziente si procede a somministrare un farmaco
    // nella “lista dei farmaci ancora da somministrare”, il numero di giorni di quel
    // farmaco scende di uno, e viene registrato nella “lista dei farmaci già somministrati”
    @RequestMapping(value = "/somministraFarmaco", method = RequestMethod.GET)
    public String somministraFarmaco(@RequestParam(name="codPaz", required=true) String codPaziente,
                                     @RequestParam(name="codPer", required=true) String codPersonale,
                                     @RequestParam(name="codFar", required=true) String codFarmaci){
        Optional<PersonaleMedico> person= Optional.ofNullable(personaleMedicoRepository.findByCodFiscale(codPersonale));
        Optional<Paziente> paz= Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));
        if(paz.isPresent()) {
            Paziente paziente=paz.get();
            if(!paziente.isAutosufficiente() && !person.isPresent()) {
                return "Errori/somministrazioneErrata";
            }
        }else{
            return "Errori/personaNonTrovata";
        }

        Optional<Farmaci> f= Optional.ofNullable(farmaciRepository.findByIdFarmaco(codFarmaci));
        //viene controllato che il farmaco che si vuole somministrare è presente nel db
        if(f.isPresent()){
            Farmaci farmaco= f.get();
            List<FarmaciSomministrati> farmaciSomministrati =new LinkedList<>();
            //l'oggetto 'newFarmacoSomministrato' indica il farmaco che sarà inserito nel db
            FarmaciSomministrati newFarmacoSomministrato = new FarmaciSomministrati();
            //Inizializzo il nuovo farmaco somministrato con le informazioni dell'ultima dose somministrata di quel farmaco
            for(FarmaciSomministrati fs: farmaciSomministratiRepository.findAll()){
                if(fs.getIdFarmaco().equals(codFarmaci) && fs.getCodPaziente().equals(codPaziente)){
                    farmaciSomministrati.add(fs);
                    // inizializzo il nuovo farmaco somministrato con le informazioni di quello già somministrato
                    newFarmacoSomministrato.setIdFarmaco(fs.getIdFarmaco());
                    newFarmacoSomministrato.setSomministrato(true);
                    newFarmacoSomministrato.setNome_farmaco(fs.getNome_farmaco());
                    newFarmacoSomministrato.setCosto(fs.getCosto());
                    newFarmacoSomministrato.setCodPaziente(fs.getCodPaziente());
                    newFarmacoSomministrato.setCodMedico(fs.getCodMedico());
                    newFarmacoSomministrato.setNumGiorni(fs.getNumGiorni());
                    newFarmacoSomministrato.setDose(fs.getDose());
                    newFarmacoSomministrato.setSomministratore((fs.getSomministratore()));
                }
            }
            //se il farmaco è già stato somministrato in precedenza aumento di 1 il numero di giorni già completati
            if (!farmaciSomministrati.isEmpty()){
                newFarmacoSomministrato.setNumGiorni(newFarmacoSomministrato.getNumGiorni()+1);
            }
            //se il farmaco è alla prima somministrazione inserisco le informazioni in base al farmaco ancora da somministrare
            else{
                newFarmacoSomministrato.setIdFarmaco(codFarmaci);
                //setto la variabile booleana 'somministrato' a true per indicare che è stato assunto
                newFarmacoSomministrato.setSomministrato(true);
                newFarmacoSomministrato.setNome_farmaco(farmaco.getNome_farmaco());
                newFarmacoSomministrato.setCosto(farmaco.getCosto());
                newFarmacoSomministrato.setCodPaziente(codPaziente);
                newFarmacoSomministrato.setCodMedico(farmaco.getCodMedico());
                //setto ad 1 il numero di giorni per indicare che è il primo giorno in cui viene somministrato
                newFarmacoSomministrato.setNumGiorni(1);
                newFarmacoSomministrato.setDose(farmaco.getDose());
            }
            //Se dal sistema non viene passato un cod personale vuol dire che è stato il paziente a somministrarlo
            if (codPersonale.equals("")){
                newFarmacoSomministrato.setSomministratore(codPaziente);
            }
            //Se dal sistema viene invece passato un cod personale, nel campo somministratore viene
            // indicato il cod fiscale dell'infermiere
            else{newFarmacoSomministrato.setSomministratore(codPersonale);}

            //Una volta che la dose giornaliera di quel farmaco è stato somministrato diminuisco di 1 il num di giorni mancanti
            farmaco.setNumGiorni(farmaco.getNumGiorni()-1);

            farmaciSomministratiRepository.save(newFarmacoSomministrato);
            //se il farmaco è all'ultima somministrazione dopo che questa è avvenuta, il farmaco viene rimosso dalla lista dei farmaci e viene indicato
            // che è stato somministrato per intero
            if(farmaco.getNumGiorni() == 0){
                farmaciRepository.delete(farmaco);
                return "Verifiche/farmaciCompletati";

            }
            return "Verifiche/somministraFarmaci";

        }else{return "Errori/personaNonTrovata";}
    }
    //reindirizza alla lista dei farmaci ancora da somministrare
    @RequestMapping(value = "/farmaciDaSomministrare", method = RequestMethod.GET)
    public String farmaciDaSomministrare(@RequestParam(name="codPaziente", required=true) String codPaziente,
                                         @RequestParam(name="codPersonale", required=true) String codPersonale,
                                         Model model){
        List<Farmaci> farmaci = new LinkedList<>();
        for (Farmaci f : farmaciRepository.findAll()) {
            if(f.getCodPaziente().equals(codPaziente)){
                farmaci.add(f);
            }
        }
        if( farmaci.isEmpty()){return "Errori/farmaciNonTrovati";}

        Optional<Paziente> p = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPaziente));
        Optional<Paziente> pers = Optional.ofNullable(pazienteRepository.findByCodFiscale(codPersonale));

        if(p.isPresent() ){
            Paziente paziente= p.get();
            //se il paziente per cui si richiede la visualizzazione dei farmaci non è autosufficiente allora si mostra la lista senza la possibilità
            // di somministrare il farmaco
            if(!paziente.isAutosufficiente() && pers.isPresent()){
                model.addAttribute("Farm", farmaci);
                return "Farmaci/mostraFarmaci";
            }
        }

        //se il paziente per cui si richiede la visualizzazione dei farmaci è autosufficiente
        // allora si mostra la lista con la possibilità di somministrare il farmaco
        model.addAttribute("persona",codPersonale);
        model.addAttribute("Farm", farmaci);
        return "Farmaci/farmaciDaSomministrare";
    }
    //Visualizza la lista dei farmaci senza la possibilità di somministrarli, quindi per il medico ed il paziente non autosufficiente
    @RequestMapping(value = "/mostraFarmaci", method = RequestMethod.GET)
    public String mostraFarmaci(@RequestParam(name="codPaziente", required=true) String codPaziente,
                                @RequestParam(name="codPersonale", required=true) String codPersonale,
                                Model model){
        List<Farmaci> farmaci = new LinkedList<>();
        for (Farmaci f : farmaciRepository.findAll()) {
            if(f.getCodPaziente().equals(codPaziente)){
                farmaci.add(f);
            }
        }
        if( farmaci.isEmpty()){
            return "Errori/farmaciNonTrovati";
        }
        model.addAttribute("persona",codPersonale);
        model.addAttribute("Farm", farmaci);
        return "Farmaci/mostraFarmaci";
    }
    //Visualizza la lista dei farmaci con la possibilità di somministrarli, quindi per l'infermiere ed il paziente non autosufficiente
    @RequestMapping(value = "/farmaciSomministrati", method = RequestMethod.GET)
    public String farmaciSomministrati(@RequestParam(name="codPaziente", required=true) String codPaziente, Model model){
        List<FarmaciSomministrati> farmaci = new LinkedList<>();
        for (FarmaciSomministrati f : farmaciSomministratiRepository.findAll()) {
            if(f.getCodPaziente().equals(codPaziente)){
                farmaci.add(f);
            }
        }
        if( farmaci.isEmpty()){
            return "Errori/farmaciNonTrovati";
        }
        model.addAttribute("Farm", farmaci);
        return "Farmaci/farmaciSomministrati";
    }
}
