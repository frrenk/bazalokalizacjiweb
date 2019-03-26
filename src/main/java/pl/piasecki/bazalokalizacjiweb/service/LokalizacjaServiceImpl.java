package pl.piasecki.bazalokalizacjiweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;
import pl.piasecki.bazalokalizacjiweb.repo.LokalizacjaRepository;

import java.util.List;

@Service
public class LokalizacjaServiceImpl implements LokalizacjaService {

    @Autowired
    private LokalizacjaRepository repository;

    @Override
    public Lokalizacja saveLokalizacja(Lokalizacja lokalizacja) {
        return repository.save(lokalizacja);
    }

    @Override
    public Lokalizacja updateLokalizacja(Lokalizacja lokalizacja) {
        return repository.save(lokalizacja);
    }

    @Override
    public void deleteLokalizacja(Lokalizacja lokalizacja) {
        repository.delete(lokalizacja);
    }

    @Override
    public Lokalizacja getLokalizacjaById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Lokalizacja> getAllLokalizacja() {
        return repository.findAll();
    }

    public LokalizacjaRepository getRepository() {
        return repository;
    }

    public void setRepository(LokalizacjaRepository repository) {
        this.repository = repository;
    }
}
