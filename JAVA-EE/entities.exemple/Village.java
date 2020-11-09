package metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Village implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long              id;

    @Column( nullable = false, length = 50 )
    private String            nom;

    @Column( nullable = false, length = 255 )
    private String            created_at;

    @ManyToOne( optional = false )
    @JoinColumn( name = "ID_USER", referencedColumnName = "id", nullable = false )
    private User              created_by;

    @OneToMany( mappedBy = "village", targetEntity = Client.class, fetch = FetchType.LAZY )
    private List<Client>      clients;

    @Column( nullable = false, length = 2 )
    private int               state;

    // ====== CONSTRUCTOR ======
    /**
     * 
     */
    public Village() {
        super();
    }

    // ====== Getters & Setters ======

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

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
     * @param nom
     *            the nom to set
     */
    public void setNom( String nom ) {
        this.nom = nom;
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

    /**
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * @param clients
     *            the clients to set
     */
    public void setClients( List<Client> clients ) {
        this.clients = clients;
    }

}
