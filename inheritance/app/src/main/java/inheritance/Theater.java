package inheritance;

import java.util.ArrayList;

public class Theater {
    // properties
    protected String name;

    protected ArrayList<String> movies;
    protected ArrayList<Review> reviews;

    //constructor
    public Theater(String name, ArrayList<String> movies) {
        this.name = name;
        this.movies = movies;
        this.reviews = new ArrayList<>();
    }

    //Methods

    public void addMovie(String movieName){
        movies.add(movieName);
    }

    public void removeMovie(String movieName){
        movies.remove(movieName);
    }

}
