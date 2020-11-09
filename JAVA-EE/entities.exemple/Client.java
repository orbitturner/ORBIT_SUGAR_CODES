package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Client implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long              id;

    @Column( nullable = false, length = 50 )
    private String            nom;

    @Column( nullable = false, length = 75 )
    private String            prenom;

    @Column( nullable = false, length = 255 )
    private String            adresse;

    @Column( nullable = false, length = 100 )
    private String            telephone;

    @ManyToOne( optional = false )
    @JoinColumn( name = "ID_VILLAGE", referencedColumnName = "id", nullable = false )
    private Village           village;

    @Column( nullable = false, length = 255 )
    private String            created_at;

    @ManyToOne( optional = false )
    @JoinColumn( name = "ID_USER", referencedColumnName = "id", nullable = false )
    private User              created_by;

    @Column( nullable = false, length = 2 )
    private int               state;

    // ====== CONSTRUCTOR ======
    /**
     * 
     */
    public Client() {
        super();
    }

    // ====== Getters & Setters ======
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId( Long id ) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom
     *            the nom to set
     */
    public void setNom( String nom ) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom
     *            the prenom to set
     */
    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @param adresse
     *            the adresse to set
     */
    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    /**
     * @return the created_at
     */
    public String getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at
     *            the created_at to set
     */
    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    /**
     * @return the state
     */
    public int getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public void setState( int state ) {
        this.state = state;
    }

    /**
     * @return the village
     */
    public Village getVillage() {
        return village;
    }

    /**
     * @param village
     *            the village to set
     */
    public void setVillage( Village village ) {
        this.village = village;
    }

    /**
     * @return the created_by
     */
    public User getCreated_by() {
        return created_by;
    }

    /**
     * @param created_by
     *            the created_by to set
     */
    public void setCreated_by( User created_by ) {
        this.created_by = created_by;
    }

}
