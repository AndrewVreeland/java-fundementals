package inheritance;

public class Review extends Restaurant {
    // properties
    protected String body;
    protected String author;
    protected int stars;

    // constructor


    public Review(String name, int dollarSigns, String author, String body, int stars) {
        super(name, stars, dollarSigns);
        this.author = author;
        this.body = body;
        this.stars = stars;
    }
    // methods

    public String reviewOfRestaurant(){
        return("Restaurant name: "+ this.name + ", Average stars: " + this.stars + ", Average Cost: " + this.dollarSigns +  ", Author: " + this.author + ", Rating: " + this.stars + ", Review: " + this.body);

    }
    // getter and setter


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

    public int getStars() {
        return stars;
    }

    public void setStars(int stars){
        if (stars >= 0 && stars <= 5){
            this.stars = stars;
        }else{
            System.out.println("The stars must be between 0 and 5!");
        }
    }




}
