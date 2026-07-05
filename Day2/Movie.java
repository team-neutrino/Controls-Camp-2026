package Day2;

public class Movie {
    private String m_name;
    private String m_director;
    private int m_minutes;
    private double m_rating;

    public Movie(String p_name, String p_director, int p_minutes, double p_rating) {
        m_name = p_name;
        m_director = p_director;
        m_minutes = p_minutes;
        m_rating = p_rating;
    }

    public String getName() {
        return m_name;
    }

    public String getDirector() {
        return m_director;
    }

    public int getMinutes() {
        return m_minutes;
    }

    public double getRating() {
        return m_rating;
    }

    public void updateRating(double newRating) {
        m_rating = newRating;
    }

    public static void main(String[] args) {
        Movie ToyStory = new Movie("Toy Story", "John Lasseter", 81, 8.5);
        System.out.println("Movie Name: " + ToyStory.getName());
        System.out.println("Movie Director: " + ToyStory.getDirector());
        System.out.println("# of Minutes: " + ToyStory.getMinutes());
        System.out.println("Movie Rating: " + ToyStory.getRating());

        ToyStory.updateRating(9.0);
        System.out.println("Updated Rating: " + ToyStory.getRating());
    }
}
