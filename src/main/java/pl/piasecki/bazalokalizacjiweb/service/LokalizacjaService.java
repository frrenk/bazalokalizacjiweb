package pl.piasecki.bazalokalizacjiweb.service;

import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;

import java.util.List;

public interface LokalizacjaService {

    Lokalizacja saveLokalizacja(Lokalizacja lokalizacja);

    Lokalizacja updateLokalizacja(Lokalizacja lokalizacja);

    void deleteLokalizacja(Lokalizacja lokalizacja);

    Lokalizacja getLokalizacjaById(int id);

    List<Lokalizacja> getAllLokalizacja();
}
