package inheritance;

import java.util.ArrayList;

public class Review  {
    // properties
    protected String body;
    protected String author;
    protected float stars;

    protected ArrayList<Review> reviews;

    // constructor

    public Review(String author, String body, float stars) {
        this.author = author;
        this.body = body;
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Review{" +
                "body='" + body + '\'' +
                ", author='" + author + '\'' +
                ", stars=" + stars +
                '}';
    }

    // methods




    // getter and setter

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars){
        if (stars >= 0 && stars <= 5){
            this.stars = stars;
        }else{
            System.out.println("The stars must be between 0 and 5!");
        }
    }




}
