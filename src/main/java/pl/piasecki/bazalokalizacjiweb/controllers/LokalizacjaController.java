package pl.piasecki.bazalokalizacjiweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;
import pl.piasecki.bazalokalizacjiweb.repo.LokalizacjaRepository;
import pl.piasecki.bazalokalizacjiweb.service.LokalizacjaService;
import pl.piasecki.bazalokalizacjiweb.util.EmailUtil;
import pl.piasecki.bazalokalizacjiweb.util.ReportUtil;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class LokalizacjaController {

    @Autowired
    LokalizacjaService service;

    @Autowired
    LokalizacjaRepository repo;

    @Autowired
    ReportUtil reportUtil;

    @Autowired
    ServletContext sc;

    @Autowired
    EmailUtil emailUtil;

    @RequestMapping("/pokazStworz")
    public String pokazStworz() {
        return "stworzLokalizacje";
    }

    @RequestMapping("/zapiszLok")
    public String zapiszLokalizacje(@ModelAttribute("lokalizacja") Lokalizacja lokalizacja, ModelMap modelMap) {
        Lokalizacja lokalizacjaS = service.saveLokalizacja(lokalizacja);
        String msg = "Lokalizacja zapisana z id: "+lokalizacjaS.getId();
        modelMap.addAttribute("msg", msg);
        emailUtil.sendEmail("frpicipec@gmail.com", "Zapisano nową lokalizację", "Lokalizacja zapisana poprawnie ");
        return "stworzLokalizacje";
    }

    @RequestMapping("/pokazLokalizacje")
    public String pokazLokalizacje(ModelMap modelMap) {
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);

        return "pokazLokalizacje";
    }

    @RequestMapping("/usunLokalizacje")
    public String usunLokalizacje(@RequestParam("id") int id, ModelMap modelMap) {
        Lokalizacja lokalizacja = service.getLokalizacjaById(id);
        service.deleteLokalizacja(lokalizacja);
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);

        return "pokazLokalizacje";
    }

    @RequestMapping("/aktualizujLokalizacje")
    public String pokazAktualizuj(@RequestParam("id") int id, ModelMap modelMap) {
        Lokalizacja lok = service.getLokalizacjaById(id);
        modelMap.addAttribute("lokalizacja", lok);
        return "edytujLokalizacje";

    }

    @RequestMapping("/aktualizujLok")
    public String aktualizujLokalizacje(@ModelAttribute("lokalizacja") Lokalizacja lokalizacja, ModelMap modelMap) {
        service.updateLokalizacja(lokalizacja);
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);
        return "pokazLokalizacje";

    }

    @RequestMapping("/generujRaport")
    public String generujRaport() {

        List<Object[]> data = repo.znajdzRodzajIIlosc();
        reportUtil.generatePieChart(sc.getRealPath("/"), data);
        return "raport";
    }
}
