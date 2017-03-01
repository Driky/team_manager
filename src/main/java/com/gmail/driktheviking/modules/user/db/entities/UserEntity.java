package com.gmail.driktheviking.modules.user.db.entities;

        import lombok.EqualsAndHashCode;
        import lombok.Getter;
        import lombok.NoArgsConstructor;

        import javax.persistence.*;
        import java.util.Collection;
        import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class UserEntity {

    @Id
    @SequenceGenerator(name = "UserSequenceGenerator", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequenceGenerator")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", nullable = false, insertable = false, updatable = false)
    private Date createdTime;

    @Column(name = "enabled", columnDefinition = "false")
    private boolean enabled;

    @Column(name = "token_expired")
    private boolean tokenExpired;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    @Column(name = "roles")
    private Collection<RoleEntity> roles;

    public UserEntity(
            String username,
            String passwordHash,
            String firstName,
            String lastName,
            String emailAddress) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
}