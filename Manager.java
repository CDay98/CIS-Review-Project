import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {

    public void inputController(Scanner scnr){
        int rating = -1;
        String comment;
        Reviews r = new Reviews();
        boolean not_valid = true;

        while(not_valid) {
            try {
                rating = scnr.nextInt();
                not_valid = false;
                if(r.getAllReviews().isEmpty() && rating == -1) {
                    System.out.println("Review list is empty, please add a review");
                    scnr.nextLine();
                    not_valid = true;
                }
                if (rating < -1 || rating > 5) {
                    System.out.println("Error: Rating must be in the range of 0-5");
                    System.out.println("Please enter a valid Review:");
                    scnr.nextLine();
                    not_valid = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Not a valid review, please try again.");
                scnr.nextLine();
            }
        }


        while(rating != -1) {
            if (rating > -1 && rating < 6) {
                comment = scnr.nextLine();
                r.addReviews(new Review(rating, comment));
                System.out.println("Add another review:");
            } else {
                System.out.println("Error: Rating must be in the range of 0-5");
                System.out.println("Please enter a valid Review:");
                scnr.nextLine();
            }
            not_valid = true;
            while (not_valid) {
                try {
                    rating = scnr.nextInt();
                    not_valid = false;
                } catch (InputMismatchException e) {
                    System.out.println("Not a valid review, please try again.");
                    scnr.nextLine();
                }
            }
        }

        System.out.println("\nAverage Rating:");
        System.out.println(r.getAverageRating());
        System.out.println("\nHighest Review:");
        System.out.println(r.highestReview());
        System.out.println("\nLowest Review:");
        System.out.println(r.lowestReview());
        System.out.println("\nType a rating for the ratings comments. For all ratings type 6. To end -1");

        not_valid = true;
        while (not_valid) {
            try {
                rating = scnr.nextInt();
                not_valid = false;
            } catch (InputMismatchException e) {
                System.out.println("Not a valid review, please try again.");
                scnr.nextLine();
            }
        }
        while (rating != -1){
            ArrayList<Review> list = r.getAllReviews();
            if(rating == 6){
                for(Review rev : list){
                    System.out.print(rev+ "\n");
                }
            }

            if (rating < -1 || rating > 6){
                System.out.println(rating + "is not a valid rating");
            }
            else {
                for (Review rev : list) {
                    if (rev.getRating() == rating) {
                        System.out.println(rev);
                    }
                }
            }
            System.out.println("\nType another rating:");
            not_valid = true;
            while (not_valid) {
                try {
                    rating = scnr.nextInt();
                    not_valid = false;
                } catch (InputMismatchException e) {
                    System.out.println("Not a valid review, please try again.");
                    scnr.nextLine();
                }
            }
        }
        System.out.println("Done");
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Manager m = new Manager();
        System.out.println("Type rating + comments. To end: -1");
        m.inputController(scnr);

    }

}
