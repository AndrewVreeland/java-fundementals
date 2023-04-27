package inheritance;

import java.util.ArrayList;

public class Restaurant extends Establishment {
    protected int dollarSigns;
    // constructor


    public Restaurant(String name, int stars, int dollarSigns) {
        this.name = name;
        setStars(stars);
        this.reviews = new ArrayList<>();
        this.dollarSigns = dollarSigns;
    }
    // methods
    // not sure how to test this
    public void addReview(Review review){
        reviews.add(review);
        updateStars();
    }

    private void updateStars(){
        int totalStars =0;
        for (Review review : reviews){
            totalStars += review.getStars();
        }
        this.stars =  (float) totalStars / reviews.size();
    }




    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", stars=" + stars +
                ", dollarSigns=" + dollarSigns +
                '}';
    }



    //getter and setter

    public void setStars(float stars) {
        if (stars >= 0 && stars <= 5) {
            this.stars = stars;
        } else {
            System.out.println("The stars must be between 0 and 5!");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStars() {
        return stars;
    }


    public int getDollarSigns() {
        return dollarSigns;
    }

    public void setDollarSigns(int dollarSigns) {
        this.dollarSigns = dollarSigns;
    }
}


