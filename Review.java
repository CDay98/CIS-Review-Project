public class Review {

    public int rating;
    public String comment;


    public Review(int rating, String comment){
        this.rating = rating;
        this.comment = comment;
    }

    public String toString(){
        return "Rating: " + rating + " Comment: " + comment;
    }

    public String getComment(){
        return comment;
    }

    public int getRating(){
        return rating;
    }

}