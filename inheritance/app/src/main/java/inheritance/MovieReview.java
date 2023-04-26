package inheritance;

public class MovieReview extends Review {
    protected String movieName;
    public MovieReview(String author, String body, int stars, String movieName) {
        super(author, body, stars);
        this.movieName = movieName;
    }


}
