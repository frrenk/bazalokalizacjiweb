package pl.piasecki.bazalokalizacjiweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.piasecki.bazalokalizacjiweb.entities.Lokalizacja;

import java.util.List;

public interface LokalizacjaRepository extends JpaRepository<Lokalizacja, Integer> {

    @Query(value="select rodzaj,count(rodzaj) from lokalizacja group by rodzaj", nativeQuery=true)
    public List<Object[]> znajdzRodzajIIlosc();
}
