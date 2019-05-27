package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namehobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sportuser_id")
    private SportUser sportUser;

    public Hobby(String namehobby){
        this.namehobby = namehobby;
    }
    public Hobby(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamehobby() {
        return namehobby;
    }

    public void setNamehobby(String namehobby) {
        this.namehobby = namehobby;
    }

    public SportUser getSportUser() {
        return sportUser;
    }

    public void setSportUser(SportUser sportUser) {
        this.sportUser = sportUser;
    }
}
