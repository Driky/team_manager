package com.gmail.driktheviking.modules.user.db.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class PrivilegeEntity {

    @Id
    @SequenceGenerator(name = "PrivilegeSequenceGenerator", sequenceName = "privilege_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PrivilegeSequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    @Column(name = "roles")
    private Collection<RoleEntity> roles;
}
