package pl.piasecki.bazalokalizacjiweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;

public interface LokalizacjaRepository extends JpaRepository<Lokalizacja, Integer> {
}
