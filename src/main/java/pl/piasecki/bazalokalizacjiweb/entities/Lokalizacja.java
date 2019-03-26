package pl.piasecki.bazalokalizacjiweb.entities;

import javax.persistence.*;

@Entity
@Table(name="lokalizacja")
public class Lokalizacja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String kod;
    private String nazwa;
    private String rodzaj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Override
    public String toString() {
        return "Lokalizacja{" +
                "id=" + id +
                ", kod='" + kod + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", rodzaj='" + rodzaj + '\'' +
                '}';
    }
}
