package com.senforage.orbit.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

// Lombok Injection
@Data
@NoArgsConstructor
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

}
