/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectbr;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Apprenant {

    
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private String telephone;
    private String numeroClasse;

    private static final ArrayList<Apprenant> listeApprenants = new ArrayList<>();
    
    // définir les attributs
    
    public void setNom(String n) {
        nom = n;
    }
    
    public void setPrenom(String p) {
        prenom = p;
    }
    
    public void setDateNaissance(String date) {
        dateNaissance = date;
    }
    
    public void setAdresse(String adr) {
        adresse = adr;
    }
    
    public void setTelephone(String tel) {
        telephone = tel;
    }
    
    public void setNumeroClasse(String numero) {
        numeroClasse = numero;
    }
    
    // Méthodes pour obtenir les valeurs des attributs
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getDateNaissance() {
        return dateNaissance;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String getNumeroClasse() {
        return numeroClasse;
    }
   

    // Méthode pour ajouter un nouvel apprenant avec les informations demandées
    public void ajouterNouvelApprenant(String nom, String prenom, String dateNaissance, String adresse, String numeroTelephone, String numeroClasse) {
        Apprenant nouvelApprenant = new Apprenant();
        nouvelApprenant.setNom(nom);
        nouvelApprenant.setPrenom(prenom);
        nouvelApprenant.setDateNaissance(dateNaissance);
        nouvelApprenant.setAdresse(adresse);
        nouvelApprenant.setTelephone(numeroTelephone);
        nouvelApprenant.setNumeroClasse(numeroClasse);

        listeApprenants.add(nouvelApprenant);
    }

    // Autres méthodes pour gérer les apprenants (modifier, supprimer, consulter, rechercher)

    public void consulterListeApprenants() {
        if (listeApprenants.isEmpty()) {
            System.out.println("Aucun apprenant n'est présent dans la liste.");
        } else {
            for (int i = 0; i < listeApprenants.size(); i++) {
                System.out.println((i + 1) + ". " + listeApprenants.get(i));
            }
        }
    }

    public int getNombreApprenants() {
        return listeApprenants.size();
    }

    public Apprenant getApprenant(int i) {
        if (i >= 0 && i < listeApprenants.size()) {
            return (Apprenant) listeApprenants.get(i);
        } else {
            return null;
        }
    }

    public void modifierApprenant(String nom, String prenom, String nouvelleAdresse, String nouveauNumeroTelephone, String nouveauNumeroClasse) {
        Iterable<Apprenant> listeApprenants = null;
        for (var apprenant : listeApprenants) {
            if (apprenant.getNom().equals(nom) && apprenant.getPrenom().equals(prenom)) {
                apprenant.setAdresse(nouvelleAdresse);
                apprenant.setTelephone(nouveauNumeroTelephone);
                apprenant.setNumeroClasse(nouveauNumeroClasse);
                System.out.println("Informations de l'apprenant " + nom + " " + prenom + " modifiées avec succès.");
                return;
            }
        }
        System.out.println("Aucun apprenant trouvé avec le nom " + nom + " et le prénom " + prenom + ".");
    }

    @Override
public String toString() {
    return " Nom: " + nom + " | Prénom: " + prenom + "\n Date de naissance: " + dateNaissance + "\n Adresse: " + adresse + "\n Numéro de téléphone: " + telephone + "\n Numéro de classe: " + numeroClasse;
}

public void supprimerApprenant(int index) {
    if (index >= 0 && index < listeApprenants.size()) {
        Apprenant apprenant = (Apprenant) listeApprenants.remove(index);
        System.out.println("Apprenant supprimé avec succès : " + apprenant.getNom() + " " + apprenant.getPrenom());
    } else {
        System.out.println("Indice d'apprenant invalide.");
    }
}

 public static ArrayList<Apprenant> rechercherApprenantParNomPrenom(String nomRecherche, String prenomRecherche) {
        ArrayList<Apprenant> apprenantsTrouves = new ArrayList<>();
        for (Apprenant apprenant : listeApprenants) {
            if (apprenant.getNom().equalsIgnoreCase(nomRecherche) && apprenant.getPrenom().equalsIgnoreCase(prenomRecherche)) {
                apprenantsTrouves.add(apprenant);
            }
        }
        return apprenantsTrouves;
    }

}
    


    

