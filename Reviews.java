import java.util.ArrayList;

public class Reviews {

    final private ArrayList<Review> list;

    public Reviews() {
        list = new ArrayList<>();
    }

    public void addReviews(Review r) {
        list.add(r);
    }

    public ArrayList<Review> getAllReviews(){
        return list;
    }

    public Review highestReview(){
        int i;
        int rating = 0;
        Review highest = null;
        int size = list.size();

        for (i = 0; i < size; i++){
            if(list.get(i).getRating() > rating){
                rating = list.get(i).getRating();
                highest = list.get(i);
            }
        }
        return highest;
    }

    public Review lowestReview(){
        int i;
        int rating = 6;
        Review lowest = null;
        int size = list.size();

        for (i = 0; i < size; i++){
            if(list.get(i).getRating() < rating){
                rating = list.get(i).getRating();
                lowest = list.get(i);
            }
        }
        return lowest;
    }
    public int getAverageRating(){
        int average;
        int sum = 0;

        for (Review s : list){
            sum += s.getRating();
        }
        average = sum / list.size();
        return average;
    }
    public ArrayList<Review> commentsForRating(int rating){
        ArrayList<Review> result = new ArrayList<>();

        for (Review r: list){
            if(r.getRating() == rating){
                result.add(r);
            }

        }
        return result;
    }

}
