package com.senforage.orbit.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

// Lombok Injection
@Data
@NoArgsConstructor
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

}
