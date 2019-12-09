/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviedatabase;

/**
 *
 * @author Glissted
 */
public class Movie {
    private int id;
    private String Title;
    private String Studio;
    private int Score;

    public Movie() {
    }

    public Movie(int id, String Title, String Studio, int Score) {
        this.id = id;
        this.Title = Title;
        this.Studio = Studio;
        this.Score = Score;
    }

    Movie(String title, String studio, int score) {
        this.Title = title;
        this.Studio = studio;
        this.Score = score;
    }

    @Override
    public String toString() {
        return "Movies{" + "id=" + id + ", Title=" + Title + ", Studio=" + Studio + ", Score=" + Score + '}';
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getStudio() {
        return Studio;
    }

    public void setStudio(String Studio) {
        this.Studio = Studio;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
}
