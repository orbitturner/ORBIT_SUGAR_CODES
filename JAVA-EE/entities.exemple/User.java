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

/* === 🌌 WELCOME TO ORBIT JEE REMIX 🌌  ===
*                     
*     By :
*
*     ██████╗ ██████╗ ██████╗ ██╗████████╗    ████████╗██╗   ██╗██████╗ ███╗   ██╗███████╗██████╗ 
*    ██╔═══██╗██╔══██╗██╔══██╗██║╚══██╔══╝    ╚══██╔══╝██║   ██║██╔══██╗████╗  ██║██╔════╝██╔══██╗
*    ██║   ██║██████╔╝██████╔╝██║   ██║          ██║   ██║   ██║██████╔╝██╔██╗ ██║█████╗  ██████╔╝
*    ██║   ██║██╔══██╗██╔══██╗██║   ██║          ██║   ██║   ██║██╔══██╗██║╚██╗██║██╔══╝  ██╔══██╗
*    ╚██████╔╝██║  ██║██████╔╝██║   ██║          ██║   ╚██████╔╝██║  ██║██║ ╚████║███████╗██║  ██║
*     ╚═════╝ ╚═╝  ╚═╝╚═════╝ ╚═╝   ╚═╝          ╚═╝    ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝
*          
*  AUTHOR : MOHAMED GUEYE [Orbit Turner] - Linkedin: www.linkedin.com/in/orbitturner - Email: orbitturner@orbitturner.com - Country: Senegal
*                              GITHUB : Orbit Turner    -   Website: http://orbitturner.com/ 
*/

@Entity
public class User implements Serializable {

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

    @Column( nullable = false, length = 50 )
    private String            username;

    @Column( nullable = false, length = 255 )
    private String            email;

    @Column( nullable = false, length = 512 )
    private String            password;

    @ManyToOne( optional = false )
    @JoinColumn( name = "ID_ROLE", referencedColumnName = "id", nullable = false )
    private Roles             role;

    @OneToMany( mappedBy = "created_by", targetEntity = Client.class, fetch = FetchType.LAZY )
    private List<Client>      clients;

    @OneToMany( mappedBy = "created_by", targetEntity = Village.class, fetch = FetchType.LAZY )
    private List<Village>     villages;

    @Column( nullable = false, length = 255 )
    private String            created_at;

    @Column( nullable = false, length = 2 )
    private int               state;

    // ===== Constructor =====
    /**
     * 
     */
    public User() {
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername( String username ) {
        this.username = username;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail( String email ) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword( String password ) {
        this.password = password;
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
     * @return the role
     */
    public Roles getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole( Roles role ) {
        this.role = role;
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

    /**
     * @return the villages
     */
    public List<Village> getVillages() {
        return villages;
    }

    /**
     * @param villages
     *            the villages to set
     */
    public void setVillages( List<Village> villages ) {
        this.villages = villages;
    }

}
