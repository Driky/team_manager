package com.gmail.driktheviking.modules.user.db.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class RoleEntity {

    @Id
    @SequenceGenerator(name = "RoleSequenceGenerator", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoleSequenceGenerator")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @Column(name = "users")
    private Collection<UserEntity> users;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    @Column(name = "privileges")
    private Collection<PrivilegeEntity> privileges;
}
