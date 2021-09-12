package org.school.entity;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @JoinColumn(name = "id_lecturer")
    @OneToOne
    private Lecturer lecturer;


    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
