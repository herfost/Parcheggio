package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String username;
    private String phone;
    private String email;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permesso> permessi;

    public Utente() {
    }

    public Utente(String username, String phone, String email, List<Permesso> permessi) {
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.permessi = permessi;
    }

    public Utente(String username, String phone, String email) {
        this.username = username;
        this.phone = phone;
        this.email = email;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the permessi
     */
    @XmlTransient
    public List<Permesso> getPermessi() {
        return permessi;
    }

    /**
     * @param permessi the permessi to set
     */
    public void setPermessi(List<Permesso> permessi) {
        this.permessi = permessi;
    }

    @Override
    public String toString() {
        return "{\n"
                + "\"username\": \"" + username + "\",\n"
                + "\"phone\": \"" + phone + "\",\n"
                + "\"email\": \"" + email + "\"\n"
                + "}";

    }

}
