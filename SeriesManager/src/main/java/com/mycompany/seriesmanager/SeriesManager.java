/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seriesmanager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class SeriesManager {
    private ArrayList<TVseries> seriesList;
    private Scanner scanner;
     
   
    
    public SeriesManager() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
        addSampleData();
    }
    
    private void addSampleData() {
        seriesList.add(new TVseries("Breaking Bad", "Drama", 9.5, 5, 62));
        seriesList.add(new TVseries("Stranger Things", "Sci-Fi", 8.7, 4, 34));
        seriesList.add(new TVseries("The Office", "Comedy", 8.9, 9, 201));
    }
    
    public void start() {
        System.out.println("=== TV SERIES MANAGER ===");
        
        while (true) {
            showMenu();
            int choice = getNumberInput("Choose option: ");
            
            switch (choice) {
                case 1 -> addSeries();
                case 2 -> showAllSeries();
                case 3 -> searchSeries();
                case 4 -> deleteSeries();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
            System.out.println();
        }
    }
    
    private void showMenu() {
        System.out.println("\n1. Add New Series");
        System.out.println("2. Show All Series");
        System.out.println("3. Search Series");
        System.out.println("4. Delete Series");
        System.out.println("5. Exit");
    }
    
    private void addSeries() {
        System.out.println("\n--- Add New Series ---");
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        double rating = getNumberInput("Enter rating (0-10): ");
        int seasons = getNumberInput("Enter seasons: ");
        int episodes = getNumberInput("Enter total episodes: ");
        
        TVseries newSeries = new TVseries(title, genre, rating, seasons, episodes);
        seriesList.add(newSeries);
        
        System.out.println("Series added successfully!");
    }
    
    private void showAllSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series in collection.");
            return;
        }
        
        System.out.println("\n--- All Series ---");
        for (int i = 0; i < seriesList.size(); i++) {
            TVseries series = seriesList.get(i);
            System.out.println((i+1) + ". " + series.getInfo());
        }
    }
    
    private void searchSeries() {
        System.out.print("\nEnter title to search: ");
        String searchTitle = scanner.nextLine();
        
        boolean found = false;
        for (TVseries series : seriesList) {
            if (series.getTitle().equalsIgnoreCase(searchTitle)) {
                System.out.println("Found: " + series.getDetailedInfo());
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Series not found.");
        }
    }
    
    private void deleteSeries() {
        System.out.print("\nEnter title to delete: ");
        String deleteTitle = scanner.nextLine();
        
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getTitle().equalsIgnoreCase(deleteTitle)) {
                seriesList.remove(i);
                System.out.println("Series deleted successfully!");
                return;
            }
        }
        
        System.out.println("Series not found.");
    }
    
    private int getNumberInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    
   
    public static void main(String[] args) {
        SeriesManager manager = new SeriesManager();
        manager.start();
    }
}

