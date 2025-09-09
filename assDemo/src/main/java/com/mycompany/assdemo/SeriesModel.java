/*/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assdemo;
import java.util.ArrayList;
import java.util.Scanner;

public class SeriesModel {  // REMOVED "extends AssDemo"
    // Scanner objects for user input
    Scanner scanner = new Scanner(System.in); 
    Scanner obj = new Scanner(System.in);
    
    // Variables for series management
    int size;
    int series;
    int age;
    int MaxAttemps;
    int attempt;
    int searchID;
    int seriesID;
    int episodes; 
    
    ArrayList<Integer> seriesIds = new ArrayList<>();
    ArrayList<String> seriesNames = new ArrayList<>();
    ArrayList<Integer> ageRestrictions = new ArrayList<>();
    ArrayList<Integer> episodesList = new ArrayList<>();
    
    // Reference to the main application for navigation
    private AssDemo mainApp;
    
    // Constructor that accepts the main application reference
    public SeriesModel(AssDemo mainApp) {
        this.mainApp = mainApp;
    }
    
    public void CaptureSeries(){
        System.out.println("How many series are to be captured?");
        int size = obj.nextInt();
        
        for(int i = 0; i < size; i++) {
            System.out.println("Please enter a series ID");
            int seriesID = scanner.nextInt();
            scanner.nextLine(); 
           
            System.out.println("Enter the series name: ");
            String seriesName = scanner.nextLine();
             
            System.out.println("Enter the series age restriction (2-18): ");
            int age = scanner.nextInt();
            int MaxAttempts = 3;
            int attempts = 1;
            
            while ((age < 2 || age > 18) && attempts < MaxAttempts) {
                System.out.println("Invalid age! Please enter a value between 2 and 18 (" + 
                                  (MaxAttempts - attempts) + " attempts remaining): ");
                age = scanner.nextInt();
                attempts++;
            }
            
            if (age < 2 || age > 18) {
                System.out.println("Maximum attempts reached. Using default age 18.");
                age = 18;
            }
                                          
            System.out.println("Enter the number of episodes for " + seriesName + " : ");
            int episodes = scanner.nextInt();
            
            seriesIds.add(seriesID);
            seriesNames.add(seriesName);
            ageRestrictions.add(age);
            episodesList.add(episodes);
            
            System.out.println("Series captured successfully!\n");
        }
        
        System.out.println("Enter (1) to go back to the menu or any other key to exit"); 
        int choice = scanner.nextInt();
        if (choice == 1){
            mainApp.menuChoice();  // Changed to use mainApp reference
        }else {
            System.out.println("Thank you\ngoodbye!");
            System.exit(0);
        }
    }
    
    public void SearchSeries(){
        System.out.println("SEARCH FOR A SERIES");
        System.out.println("*************************************");
        System.out.println("Enter the series ID to search");
        int searchID = scanner.nextInt();
        
        boolean found = false;
        for(int i = 0; i < seriesIds.size(); i++) {
            if (searchID == seriesIds.get(i)){
                found = true;
                System.out.println("SERIES FOUND:");
                System.out.println("********************************************");
                System.out.println("SERIES ID: " + seriesIds.get(i) + "\n" +
                        "SERIES NAME: " + seriesNames.get(i) + "\n" +
                        "SERIES AGE RESTRICTION: " + ageRestrictions.get(i) + "\n" +
                        "SERIES NUMBER OF EPISODES: " + episodesList.get(i) + "\n");
                break;
            }
        }
        
        if(!found) {
            System.out.println("Series with series ID: " + searchID + " was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int Defaulty = scanner.nextInt();
        if (Defaulty == 1){
            mainApp.menuChoice();  // Changed to use mainApp reference
        }else{
            System.out.println("Thank you\ngoodbye!");   
        }
    }
    
    public void UpdateSeries(){
        System.out.println("Enter the series ID to update: ");
        int searchIDupdate = scanner.nextInt();
        scanner.nextLine();
        
        boolean found = false;
        for(int i = 0; i < seriesIds.size(); i++) {
            if (searchIDupdate == seriesIds.get(i)){
                found = true;
                System.out.println("Series found! Current details:");
                System.out.println("Series ID: " + seriesIds.get(i));
                System.out.println("Series Name: " + seriesNames.get(i));
                System.out.println("Age Restriction: " + ageRestrictions.get(i));
                System.out.println("Number of Episodes: " + episodesList.get(i));
                System.out.println("-------------------------------------");
                
                System.out.println("Enter new series name (press enter to keep current): ");
                String newName = scanner.nextLine();
                if(!newName.trim().isEmpty()) {
                    seriesNames.set(i, newName);
                }
                
                System.out.println("Enter new age restriction : ");
                int newAge = scanner.nextInt();
                if(newAge != 0) {
                    while (newAge < 2 || newAge > 18) {
                        System.out.println("Invalid age! Please enter a value between 2 and 18: ");
                        newAge = scanner.nextInt();
                    }
                    ageRestrictions.set(i, newAge);
                }
                
                System.out.println("Enter new number of episodes : ");
                int newEpisodes = scanner.nextInt();
                if(newEpisodes > 0) {
                    episodesList.set(i, newEpisodes);
                }
                
                System.out.println("Series updated successfully!");
                break;
            }
        }
        
        if(!found) {
            System.out.println("Series with series ID: " + searchIDupdate + " was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int Defaulty = scanner.nextInt();
        if (Defaulty == 1){
            mainApp.menuChoice();  // Changed to use mainApp reference
        }else{
            System.out.println("Thank you\ngoodbye!");
        }
    }
    
    public void DeleteSeries(){
        System.out.println("Enter the series ID to delete: ");   
        int deleteID = scanner.nextInt();
        
        boolean found = false;
        for(int i = 0; i < seriesIds.size(); i++) {
            if (deleteID == seriesIds.get(i)){
                found = true;
                seriesIds.remove(i);
                seriesNames.remove(i);
                ageRestrictions.remove(i);
                episodesList.remove(i);
                System.out.println("Series deleted successfully!");
                break;
            }
        }
        
        if(!found) {
            System.out.println("Series with series ID: " + deleteID + " was not found!");
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int Defaulty = scanner.nextInt();
        if (Defaulty == 1){
            mainApp.menuChoice();  // Changed to use mainApp reference
        }else{
            System.out.println("Thank you\ngoodbye!");
        }
    }
    
    public void SeriesReport(){
        System.out.println("SERIES REPORT");
        System.out.println("*************************************");
        
        if(seriesIds.isEmpty()) {
            System.out.println("No series data available.");
        } else {
            for(int i = 0; i < seriesIds.size(); i++) {
                System.out.println("Series ID: " + seriesIds.get(i));
                System.out.println("Series Name: |" + seriesNames.get(i)+"|");
                System.out.println("Age Restriction: " + ageRestrictions.get(i));
                System.out.println("Number of Episodes: " + episodesList.get(i));
                System.out.println("-------------------------------------");
            }
            
            System.out.println("Total series: " + seriesIds.size());
        }
        
        System.out.println("Enter (1) to launch menu or any other key to exit");
        int Defaulty = scanner.nextInt();
        if (Defaulty == 1){
            mainApp.menuChoice();  // Changed to use mainApp reference
        }else{
            System.out.println("Thank you\ngoodbye!");
        }
    }
    
    public void ExitSeriesApplication(){
        System.out.println("Thank you, goodbye!");
        System.exit(0);
    }
}
