/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.moviedatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Glissted
 */
public class MovieHandeler {

    //get data from database
    public List<Movie> getMovie() {

        List<Movie> MovieList = new ArrayList<>();

        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM movies";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                int id = data.getInt("id");
                String title = data.getString("Title");
                String studio = data.getString("Studio");
                int score = data.getInt("score");
                Movie Movies = new Movie(id, title, studio, score);
                MovieList.add(Movies);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return MovieList;
    }

    public void addMovie(Movie movie) {
        // add new data to database
        try ( Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO movies VALUES(NULL, '%s','%s',%d)", movie.getTitle(), movie.getStudio(), movie.getScore());
            // String sql = "INSERT INTO `movies`( `Title`, `Studio`, `Score`) VALUES ([value-1],[value-2],[value-3])";
            stmt.executeUpdate(sql); //1
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
