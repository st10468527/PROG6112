/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seriesmanager;

/**
 *
 * @author RC_Student_lab
 */
public class TVseries  {

    private String title;
    private String genre;
    private double rating;
    private int seasons;
    private int totalEpisodes;
    
    public TVseries(String title, String genre, double rating, int seasons, int totalEpisodes) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.seasons = seasons;
        this.totalEpisodes = totalEpisodes;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public double getRating() {
        return rating;
    }
    
    public int getSeasons() {
        return seasons;
    }
    
    public int getTotalEpisodes() {
        return totalEpisodes;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }
    
    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }
    //assissted by AI to help create formatted strings with basic series information
    public String getInfo() {
        return String.format("%s (%s) - Rating: %.1f", title, genre, rating);
    }
    //assissted by AI to help create formatted strings with basic series information
    public String getDetailedInfo() {
        return String.format("%s | Genre: %s | Rating: %.1f/10 | Seasons: %d | Episodes: %d",
                           title, genre, rating, seasons, totalEpisodes);
    }
    
    public double getEpisodesPerSeason() {
        return (double) totalEpisodes / seasons;
    }
}    
