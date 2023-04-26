package inheritance;

import java.util.ArrayList;

public class Shop {
    // properties
    protected int dollarSigns;
    protected String name;
    protected String description;
    protected ArrayList<Review> reviews;


    //constructor
    public Shop(String name, String description, int dollarSigns) {
        this.name = name;
        this.description = description;
        this.dollarSigns = dollarSigns;
        this.reviews = new ArrayList<>();
    }
// Methods
    @Override
    public String toString() {
        return "Shop " +
                "dollarSigns = " + dollarSigns +
                ", name = " + name + '\'' +
                ", description = " + description + '\''; }

    // not sure how to test this.

    public void addReview(String author, String body, int stars){
        Review newReview = new Review(author, body, stars);
        reviews.add(newReview);

    }


    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDollarSigns() {
        return dollarSigns;
    }

    public void setDollarSigns(int dollarSigns) {
        this.dollarSigns = dollarSigns;
    }



}
