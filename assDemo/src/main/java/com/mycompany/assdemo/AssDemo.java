/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.assdemo;
import java.util.Scanner;

public class AssDemo {
    Scanner scanner = new Scanner(System.in);
    public int episodes = 10; // Initialize with default values
    public int seriesID = 10; // Initialize with default values
    String[] series = new String[10];
    int[] CurrEpisodes;
    int[] SeriesId;
                    
    Scanner obj = new Scanner(System.in);
    SeriesModel seriesModel;
    
    public AssDemo() {
        // Initialize arrays after variables have values
        CurrEpisodes = new int[episodes];
        SeriesId = new int[seriesID];
        
        // Initialize SeriesModel AFTER all other fields are initialized
        seriesModel = new SeriesModel(this);
    }
    
    public void Menu(){
        int menuChoice;
        
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*********************************************");
        System.out.println("Enter (1) to launch any other key to exit");      
        menuChoice = scanner.nextInt();
        
        if (menuChoice == 1) {
            menuChoice();
        } else {
            ExitSeriesApplication();
        }
    }
    
    public void menuChoice(){
        int decision;
        do {
            System.out.println("Please select one of the following menu items: "+"\n"+
                " (1) Capture a new series."+"\n"+
                " (2) Search for a series"+"\n"+
                " (3) Update a series"+"\n"+
                " (4) Delete a series"+"\n"+
                " (5) Print series report - 2025 "+"\n"+
                " (6) Exit Application");
            decision = scanner.nextInt();  
            
            switch (decision){
                case 1:
                    seriesModel.CaptureSeries(); 
                    break;
                case 2:
                    seriesModel.SearchSeries(); 
                    break;
                case 3: 
                    seriesModel.UpdateSeries(); 
                    break;
                case 4:
                    seriesModel.DeleteSeries(); 
                    break;
                case 5:
                    seriesModel.SeriesReport(); 
                    break;
                case 6:
                    ExitSeriesApplication(); 
                    break;
                default:
                    System.out.println("Invalid option, please enter options 1-6");
            }
               
        } while (decision != 6);
    }
    
    public void CaptureSeries() {
        seriesModel.CaptureSeries(); 
    }

    public void SearchSeries(){
        seriesModel.SearchSeries(); 
    }
    
    public void UpdateSeries(){
        seriesModel.UpdateSeries();
    }
    
    public void DeleteSeries(){
        seriesModel.DeleteSeries(); 
    }
    
    public void SeriesReport (){
        seriesModel.SeriesReport(); 
    }
    
    public void ExitSeriesApplication (){
        System.out.println("Thank you, goodbye!");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        AssDemo app = new AssDemo(); 
        app.Menu();
    }
}

 

