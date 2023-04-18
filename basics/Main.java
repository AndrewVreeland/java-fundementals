import java.util.Random;
import java.time.LocalDateTime;
public class Main {
  public static void main(String[] args) {
    String greeting = "Welcome to my Java program.";
    System.out.println(greeting);

    int x = 7;
    float f = 42.3f;
    double d = 42.3;

    // execute the function called "loopTo" and pass 10 as a parameter
    loopTo(10);

    int four = 4;
    int result = multiplyByTwo(four);
    System.out.println(four + " doubled is " + result);

    // execute the function pluralize
    String word = "cat";
    int number = 10;
    String pluralizedWord = pluralize(word, number);
    System.out.println("I own " + number + " " + pluralizedWord);

    // execute the function coinFlip
    int n = 3;
    String coinFlipResult = flipNHeads(n);
    System.out.println("It took me " + coinFlipResult + " flips to flip " + n + " Heads in a row.");

    // execute Clock
    String timeNow = clock();
    System.out.println(timeNow);
  }

  // Functions that return nothing have a return type of "void"
  public static void loopTo(int max) {
    for (int i = 0; i < max; i++) {
      System.out.println("Loop #" + i);
    }
  }

  // This function has a return type of "int"
  public static int multiplyByTwo(int n) {
    return n * 2;
  }

  // This Function adds an s to the end of a string if there are multiple of that string.
  public static String pluralize(String word, int number) {
    if (number == 0 || number > 1) {
      return word + "s";
    } else {
      return word;
    }
  }

  public static String flipNHeads(int n) {
    // Create an instance of Random class
    Random random = new Random();


    int numOfFlips = 0;
    int numOfHeads = 0;
    double middle = 0.5;
    String result = "";
    while (numOfHeads != n) {
      double coinFlip = random.nextDouble(); // Generate a new random value for each flip
      numOfFlips = coinFlip < middle ? numOfFlips + 1 : numOfFlips +1;
      System.out.println(coinFlip < middle ? "Tails" : "Heads");


      numOfHeads = coinFlip > middle ? numOfHeads + 1 : 0;
      result = Integer.toString(numOfFlips); // Store the number of flips in result variable
    }
    return result; // Return the number of flips as a string
  }

  public static String clock(){
    int seconds = 0;
    while (true) {
            LocalDateTime now = LocalDateTime.now();
            int hour = now.getHour();
            int minute = now.getMinute();
            int second = now.getSecond();
            if (second != seconds) {
                seconds = second;
                System.out.println(hour + ":" + minute + ":" + second);
            }
        }
  }
}