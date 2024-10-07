package com.ensias.scolarite.cours;

import com.ensias.scolarite.modules.Module;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity // JPA annotation to map this class to the Cours table
public class Cours {

    @Id // Denotes that 'id' is the primary key
    private int id;

    private String nom;
    private String description;

    @ManyToOne // Specifies that many courses can be associated with one module
    private Module module;

    // Constructor with parameters
    public Cours(int id, String nom, String description, Module module) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.module = module;
    }

    // Default constructor, necessary when a custom constructor is defined
    public Cours() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }


}
