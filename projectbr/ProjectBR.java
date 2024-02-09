package com.mycompany.projectbr;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class ProjectBR {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Apprenant administrateur = new Apprenant();
            
            boolean continuer = true;
            while (continuer) {
                System.out.println("\n========== Gérer les apprenants ==========");
                System.out.println("1. Ajouter un nouvel apprenant");
                System.out.println("2. Consulter la liste des apprenants");
                System.out.println("3. Modifier les informations d'un apprenant ");
                System.out.println("4. Supprimer un apprenant");
                System.out.println("5. Rechercher un apprenant");
                System.out.println("6. Quitter");
                System.out.println("==========================================");
                System.out.print(" > Votre choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine(); // pour vider le buffer
                
                switch (choix) {
                    case 1 -> ajouterApprenant(scanner, administrateur);
                    case 2 -> administrateur.consulterListeApprenants();
                    case 3 -> modifierApprenant(scanner, administrateur);
                    case 4 -> supprimerApprenant(scanner, administrateur);
                    case 5 -> rechercherApprenantParNomPrenom(scanner);
                    case 6 -> continuer = false;
                    default -> System.out.println("Choix invalide.");
                }
            }
        }
    }

    private static void ajouterApprenant(Scanner scanner, Apprenant administrateur) {
        System.out.println("\nAjout d'un nouvel apprenant :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        String dateNaissance;
        boolean dateValide = false;
        boolean ageValide = false;
        // Validation de la date de naissance et de l'âge
        do {
            System.out.print("Date de naissance (jj/mm/aaaa) : ");
            dateNaissance = scanner.nextLine();
            dateValide = isValidDate(dateNaissance);
            if (!dateValide) {
                System.out.println("La date de naissance est invalide. Veuillez saisir une date au format jj/mm/aaaa.");
                continue;
            }
            ageValide = isAgeValid(dateNaissance);
            if (!ageValide) {
                System.out.println("L'âge doit être entre 18 et 30 ans.");
            }
        } while (!dateValide || !ageValide);

        System.out.print("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.print("Numéro de téléphone : ");
        String numeroTelephone = scanner.nextLine();
        System.out.print("Numéro de classe : ");
        String numeroClasse = scanner.nextLine();

        administrateur.ajouterNouvelApprenant(nom, prenom, dateNaissance, adresse, numeroTelephone, numeroClasse);
        System.out.println("Nouvel apprenant ajouté avec succès.");
    }

    private static void modifierApprenant(Scanner scanner, Apprenant administrateur) {
        System.out.println("\nModification des informations d'un apprenant existant :");

        // Display the list of learners
        administrateur.consulterListeApprenants();

        System.out.print("Entrez le numéro de l'apprenant à modifier : ");
        int choixApprenant = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character from the buffer

        // Check if the chosen number is within the valid range
        if (choixApprenant < 1 || choixApprenant > administrateur.getNombreApprenants()) {
            System.out.println("Numéro d'apprenant invalide.");
            return;
        }

        // Get the chosen learner
        Apprenant apprenant = administrateur.getApprenant(choixApprenant - 1);

        // Modify the chosen learner's information
        modifyApprenantInformation(scanner, apprenant);
    }

    private static void modifyApprenantInformation(Scanner scanner, Apprenant apprenant) {
        // Prompt for which information to modify
        System.out.println("Quelles informations souhaitez-vous modifier pour " + apprenant.getNom() + " " + apprenant.getPrenom() + " ?");
        System.out.println("1. Nom");
        System.out.println("2. Prénom");
        System.out.println("3. Date de naissance");
        System.out.println("4. Adresse");
        System.out.println("5. Numéro de téléphone");
        System.out.println("6. Numéro de classe");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character from the buffer

        // Modify the chosen information
        switch (choix) {
            case 1 -> {
                System.out.print("Nouveau nom : ");
                String nouveauNom = scanner.nextLine();
                apprenant.setNom(nouveauNom);
            }
            case 2 -> {
                System.out.print("Nouveau prénom : ");
                String nouveauPrenom = scanner.nextLine();
                apprenant.setPrenom(nouveauPrenom);
            }
            case 3 -> {
                System.out.print("Nouvelle date de naissance : ");
                String nouvelleDateNaissance = scanner.nextLine();
                apprenant.setDateNaissance(nouvelleDateNaissance);
            }
            case 4 -> {
                System.out.print("Nouvelle adresse : ");
                String nouvelleAdresse = scanner.nextLine();
                apprenant.setAdresse(nouvelleAdresse);
            }
            case 5 -> {
                System.out.print("Nouveau numéro de téléphone : ");
                String nouveauNumeroTelephone = scanner.nextLine();
                apprenant.setTelephone(nouveauNumeroTelephone);
            }
            case 6 -> {
                System.out.print("Nouveau numéro de classe : ");
                String nouveauNumeroClasse = scanner.nextLine();
                apprenant.setNumeroClasse(nouveauNumeroClasse);
            }
            default -> {
                System.out.println("Choix invalide.");
                return;
            }
        }
        System.out.println("Informations de l'apprenant modifiées avec succès.");
    }
    
    
    private static void supprimerApprenant(Scanner scanner, Apprenant administrateur) {
    System.out.println("\nSupprimer un apprenant :");

    // Display the list of learners
    administrateur.consulterListeApprenants();

    System.out.print("Entrez le numéro de l'apprenant à supprimer : ");
    int choixApprenant = scanner.nextInt();
    scanner.nextLine(); // Clear the newline character from the buffer

    // Check if the chosen number is within the valid range
    if (choixApprenant < 1 || choixApprenant > administrateur.getNombreApprenants()) {
        System.out.println("Numéro d'apprenant invalide.");
        return;
    }

    // Delete the chosen learner
    administrateur.supprimerApprenant(choixApprenant - 1);
}
    
private static void rechercherApprenantParNomPrenom(Scanner scanner) {
    System.out.println("\nRechercher un apprenant par nom et prénom :");
    
    System.out.print("Entrez le nom de l'apprenant : ");
    String nomRecherche = scanner.nextLine();
    
    System.out.print("Entrez le prénom de l'apprenant : ");
    String prenomRecherche = scanner.nextLine();
    
    // Call the method to search for the learner by name and surname
    ArrayList<Apprenant> apprenantsTrouves = Apprenant.rechercherApprenantParNomPrenom(nomRecherche, prenomRecherche);
    
    // Display the search results
    if (apprenantsTrouves.isEmpty()) {
        System.out.println("Aucun apprenant trouvé avec le nom '" + nomRecherche + "' et le prénom '" + prenomRecherche + "'.");
    } else {
        System.out.println("Apprenants trouvés :");
        for (Apprenant apprenant : apprenantsTrouves) {
            System.out.println(apprenant);
        }
    }
}

// Méthode pour valider la date de naissance
private static boolean isValidDate(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);
    try {
        Date parsedDate = sdf.parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
}

// Méthode pour valider l'âge entre 18 et 30 ans
private static boolean isAgeValid(String dateNaissance) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try {
        Date date = sdf.parse(dateNaissance);
        Calendar dob = Calendar.getInstance();
        dob.setTime(date);
        Calendar now = Calendar.getInstance();
        int age = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return (age >= 18 && age <= 30);
    } catch (ParseException e) {
        e.printStackTrace();
        return false;
    }
}

}
