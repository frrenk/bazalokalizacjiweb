package pl.piasecki.bazalokalizacjiweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;
import pl.piasecki.bazalokalizacjiweb.service.LokalizacjaService;

import java.util.List;

@Controller
public class LokalizacjaController {

    @Autowired
    LokalizacjaService service;

    @RequestMapping("/showStworz")
    public String showStworz() {
        return "stworzLokalizacje";
    }

    @RequestMapping("/saveLok")
    public String saveLokalizacja(@ModelAttribute("lokalizacja") Lokalizacja lokalizacja, ModelMap modelMap) {
        Lokalizacja lokalizacjaS = service.saveLokalizacja(lokalizacja);
        String msg = "Lokalizacja zapisana z id: "+lokalizacjaS.getId();
        modelMap.addAttribute("msg", msg);
        return "stworzLokalizacje";
    }

    @RequestMapping("/displayLokalizacje")
    public String displayLokalizacja(ModelMap modelMap) {
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);

        return "displayLokalizacje";
    }

    @RequestMapping("/deleteLokalizacja")
    public String deleteLokalizacja(@RequestParam("id") int id, ModelMap modelMap) {
        Lokalizacja lokalizacja = service.getLokalizacjaById(id);
        service.deleteLokalizacja(lokalizacja);
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);

        return "displayLokalizacje";
    }

    @RequestMapping("/updateLokalizacja")
    public String showAktualizuj(@RequestParam("id") int id, ModelMap modelMap) {
        Lokalizacja lok = service.getLokalizacjaById(id);
        modelMap.addAttribute("lokalizacja", lok);
        return "editLokalizacje";

    }

    @RequestMapping("/updateLok")
    public String updateLokalizacja(@ModelAttribute("lokalizacja") Lokalizacja lokalizacja, ModelMap modelMap) {
        service.updateLokalizacja(lokalizacja);
        List<Lokalizacja> lokalizacje = service.getAllLokalizacja();
        modelMap.addAttribute("lokalizacje", lokalizacje);
        return "displayLokalizacje";

    }
}
