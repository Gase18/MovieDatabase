package com.mycompany.moviedatabase;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    List<Movie> MovieList = new ArrayList<>();

    @FXML
    private TextArea text_area;

    @FXML
    private TextField Score;

    @FXML
    private TextField Search;

    @FXML
    private TextField Title;

    @FXML
    private Button SearchButton;

    @FXML
    private Label label;

    @FXML
    private TextField Studio;

    @FXML
    private Button ShowMovies;

    @FXML
    private Button AddMovie;

    public void ClearField() {
        Title.setText("");
        Studio.setText("");
        Score.setText("");
    }

    //Show data from database in the text area(in fxml window)
    @FXML
    void ShowMovies(ActionEvent event) {
        MovieHandeler moviehandler = new MovieHandeler();
        MovieList = moviehandler.getMovie();
        String output = "";

        for (Movie m : MovieList) {
              output +="Title:" + " " + m.getTitle() + ", ";
              output += "Studio:" + " " + m.getStudio() + ", ";
              output += "Score:" + " " + m.getScore()+ "\n" + "\n";
        }
        text_area.setText(output);
    }

    //add new movie from fxml window to database
    @FXML
    void AddMovie(ActionEvent event) {
        String title = Title.getText();
        String studio = Studio.getText();
        int score = Integer.parseInt(Score.getText());
        Movie movie = new Movie(title, studio, score);
        MovieHandeler moviehandler = new MovieHandeler();
        moviehandler.addMovie(movie);

        ClearField();
        ShowMovies(event);
    }

    //controller for searchfield in fxml window
    @FXML
    void searchMovies(ActionEvent event) {
        String output ="";
        List<Movie> searchList = searchForMovie(Search.getText());
        for(Movie m: searchList){
            output += "Title:" + " " + m.getTitle() + ", ";
            output += "Studio:" + " " + m.getStudio() + ", ";
            output += "Score:" + " " + m.getScore()+ "\n" + "\n";
        }
        text_area.setText(output);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private List<Movie> searchForMovie(String searchString) {
        List<Movie> searchList = new ArrayList<>();
        for (Movie m : MovieList) {
            if (m.getTitle().contains(searchString)) {
                searchList.add(m);
            } else if (m.getStudio().contains(searchString)) {
                searchList.add(m);
            } 
        }
        return searchList;
    }
}
