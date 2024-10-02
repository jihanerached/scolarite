package com.ensias.scolarite.modules;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // GeneratedValue indique à JPA d'adopter une stratégie de génération de la clé primaire.
    // Les stratégies possibles sont AUTO, IDENTITY, SEQUENCE et TABLE. Pour Derby, la stratégie AUTO est recommandée.
    private int id;

    private String nom;
    private String description;

    // Constructeurs
    public Module() {
    }

    public Module(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    // Getters et Setters
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
}

