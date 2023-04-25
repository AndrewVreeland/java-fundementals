package inheritance;

public class Restaurant {
    protected String name;
    protected int stars;
    protected int dollarSigns;


// constructor
    public Restaurant(String name, int stars, int dollarSigns) {
        this.name = name;
        setStars(stars);
        this.dollarSigns = dollarSigns;
    }

    // methods

    public String nameOfRestaurant(){

        return ("I am a restaurant and this is my name: " + this.name);
    }

    //getter and setter

    public void setStars(int stars){
    if (stars >= 0 && stars <= 5){
        this.stars = stars;
    }else{
        System.out.println("The stars must be between 0 and 5!");
    }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }



    public int getDollarSigns() {
        return dollarSigns;
    }

    public void setDollarSigns(int dollarSigns) {
        this.dollarSigns = dollarSigns;
    }
}


