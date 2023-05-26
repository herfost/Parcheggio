package utility;

import domain.Permesso;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PermessoControllo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String plateNumber;
    private LocalDateTime releaseDate;
    private LocalDateTime expirationDate;
    private String utenteCifrato;

    public PermessoControllo() {
    }

    public PermessoControllo(Permesso permesso) {
        this.id = permesso.getId();
        this.plateNumber = permesso.getPlateNumber();
        this.releaseDate = permesso.getReleaseDate();
        this.expirationDate = permesso.getExpirationDate();
        this.utenteCifrato = "";
    }

    public PermessoControllo(Long id, String plateNumber, LocalDateTime releaseDate, LocalDateTime expirationDate, String utenteCifrato) {
        this.id = id;
        this.plateNumber = plateNumber;
        this.releaseDate = releaseDate;
        this.expirationDate = expirationDate;
        this.utenteCifrato = utenteCifrato;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
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
     * @return the utenteCifrato
     */
    public String getUtenteCifrato() {
        return utenteCifrato;
    }

    /**
     * @param utenteCifrato the utenteCifrato to set
     */
    public void setUtenteCifrato(String utenteCifrato) {
        this.utenteCifrato = utenteCifrato;
    }

    @Override
    public String toString() {
        return "{"
                + "\"targa\": \"" + plateNumber + "\",\n"
                + "\"releaseDate\": \"" + releaseDate.format(DateTimeFormatter.ISO_DATE) + "\",\n"
                + "\"expirationDate\": \"" + expirationDate.format(DateTimeFormatter.ISO_DATE) + "\",\n"
                + "\"datiUtente\": \"" + utenteCifrato + "\"\n"
                + "}";
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
}
