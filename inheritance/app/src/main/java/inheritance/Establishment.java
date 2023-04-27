package inheritance;

import java.util.ArrayList;

public class Establishment {
    protected String name;
    protected float stars;
    protected ArrayList<Review> reviews;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
