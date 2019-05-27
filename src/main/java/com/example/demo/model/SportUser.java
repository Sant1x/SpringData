package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sportuser")
@NamedQueries({
        @NamedQuery(name = "sportuser.findAllWithHobby",
                query = "Select distinct u from SportUser u left join fetch u.hobbies where u.id = 6")
})
public class SportUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public SportUser(){

    }
    private String name;

    @OneToMany(mappedBy = "sportUser",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Hobby> hobbies = new ArrayList<>();

    public SportUser(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Hobby hobby) {
        hobbies.add(hobby);
        hobby.setSportUser(this);
    }
}
