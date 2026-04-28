package com.tp.pipeline;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Bienvenue dans votre Todo List ---");

        while (running) {
            System.out.println("\n1. Ajouter une tâche");
            System.out.println("2. Afficher les tâches");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            // Vérification pour éviter les erreurs si l'entrée n'est pas un nombre
            if (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scanner.next(); // Consomme l'entrée incorrecte
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme le retour à la ligne

            switch (choice) {
                case 1:
                    System.out.print("Entrez la description de la tâche : ");
                    String description = scanner.nextLine();
                    tasks.add(description);
                    System.out.println("Tâche ajoutée !");
                    break;
                case 2:
                    System.out.println("\n--- Vos Tâches ---");
                    if (tasks.isEmpty()) {
                        System.out.println("La liste est vide.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Numéro de la tâche à supprimer : ");
                    if (scanner.hasNextInt()) {
                        int index = scanner.nextInt();
                        if (index > 0 && index <= tasks.size()) {
                            tasks.remove(index - 1);
                            System.out.println("Tâche supprimée !");
                        } else {
                            System.out.println("Numéro invalide.");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Fermeture de l'application...");
                    break;
                default:
                    System.out.println("Option non reconnue.");
            }
        }
        scanner.close();
    }
}