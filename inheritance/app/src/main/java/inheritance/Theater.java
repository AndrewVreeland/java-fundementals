package inheritance;

import java.util.ArrayList;

public class Theater extends Establishment {
    // properties
    protected ArrayList<String> movies;
    //constructor

    public Theater(String name, ArrayList<String> movies) {
        this.name = name;
        this.movies = movies;
        this.reviews = new ArrayList<>();
    }

    //Methods
    @Override
    public String toString() {
        return "Theater{" +
                "name='" + name + '\'' +
                ", movies=" + movies +
                ", reviews=" + reviews +
                '}';
    }

    public void addMovie(String movieName){
        movies.add(movieName);
    }

    public void removeMovie(String movieName){
        movies.remove(movieName);
    }

}
