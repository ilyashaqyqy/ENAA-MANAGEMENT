/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectbr;

import java.util.ArrayList;

public class Classe {
    private String numero;
    private String nom;
    private String effectif;
    
    private final ArrayList<Classe> listeClasses = new ArrayList<>();
    
    // Constructor
    public Classe(String numero, String nom, String effectif) {
        this.numero = numero;
        this.nom = nom;
        this.effectif = effectif;
    }
    
    // Getters and setters
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setEffectif(String effectif) {
        this.effectif = effectif;
    }
    
    public String getNumero() {
        return numero;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getEffectif() {
        return effectif;
    }
    
    // Method to add a new class
    public void ajouterNouvelleClasse(String numero, String nom, String effectif) {
        Classe nouvelleClasse = new Classe(numero, nom, effectif);
        listeClasses.add(nouvelleClasse);
    }
}
