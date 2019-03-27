package pl.piasecki.bazalokalizacjiweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;
import pl.piasecki.bazalokalizacjiweb.repo.LokalizacjaRepository;

import java.util.List;

@RestController
@RequestMapping("/lokalizacje")
public class LokalizacjaRESTController {

    @Autowired
    LokalizacjaRepository repo;

    @GetMapping
    public List<Lokalizacja> getLokalizacje() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Lokalizacja getLokalizacja(@PathVariable("id") int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Lokalizacja stworzLokalizacje(@RequestBody Lokalizacja lokalizacja) {
        return repo.save(lokalizacja);
    }

    @PutMapping
    public Lokalizacja aktualizujLokalizacje(@RequestBody Lokalizacja lokalizacja) {
        return repo.save(lokalizacja);
    }

    @DeleteMapping("/{id}")
    public void usunLokalizacje(@PathVariable("id") int id) {
        repo.deleteById(id);
    }
}
