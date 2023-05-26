package domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Permesso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String plateNumber;
    private LocalDateTime releaseDate;
    private LocalDateTime expirationDate;

    @ManyToOne
    private Utente utente;

    public Permesso() {
    }

    public Permesso(String plateNumber, LocalDateTime releaseDate, LocalDateTime expirationDate, Utente utente) {
        this.plateNumber = plateNumber;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.utente = utente;
    }

    public Permesso(Long id, String plateNumber, LocalDateTime releaseDate, LocalDateTime expirationDate, Utente utente) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.utente = utente;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the releaseDate
     */
    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the expirationDate
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * @return the utente
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * @param utente the utente to set
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "{"
                + "\"targa\": \"" + plateNumber + "\",\n"
                + "\"releaseDate\": \"" + releaseDate.format(DateTimeFormatter.ISO_DATE) + "\",\n"
                + "\"expirationDate\": \"" + expirationDate.format(DateTimeFormatter.ISO_DATE) + "\",\n"
                + "\"datiUtente\": " + utente.toString()
                + "}";

    }
}
