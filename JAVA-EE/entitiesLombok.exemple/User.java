package com.senforage.orbit.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

// Lombok Injection
@Data
@NoArgsConstructor
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

}
