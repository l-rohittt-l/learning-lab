package rohit_sawant.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// Interface to support keyword-based search
interface Searchable {
    boolean searchByKeyword(String keyword);
}

// Abstract class representing a generic media item
abstract class MediaItem implements Searchable {

    protected String title;
    protected String releaseDate;
    protected double rating;

    // Constructor to initialize common media item attributes
    public MediaItem(String title, String releaseDate, double rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for release date
    public String getReleaseDate() {
        return releaseDate;
    }

    // Getter for rating
    public double getRating() {
        return rating;
    }
}

// Movie class extending MediaItem
class Movie extends MediaItem {

    private String director;
    private List<String> cast;
    private int duration;

    // Constructor with defensive null checks
    public Movie(String title, String releaseDate, double rating,
                 String director, List<String> cast, int duration) {

        if (title == null || releaseDate == null || director == null || cast == null) {
            throw new IllegalArgumentException("Movie details cannot be null");
        }

        super(title, releaseDate, rating);
        this.director = director;
        this.cast = cast;
        this.duration = duration;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }

    // Getter for duration
    public int getDuration() {
        return duration;
    }

    // Searches keyword in title, director, or cast (case-insensitive)
    @Override
    public boolean searchByKeyword(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            return false;
        }

        String key = keyword.toLowerCase();

        if (title.toLowerCase().contains(key)) {
            return true;
        }

        if (director.toLowerCase().contains(key)) {
            return true;
        }

        for (String actor : cast) {
            if (actor.toLowerCase().contains(key)) {
                return true;
            }
        }

        return false;
    }
}

public class Day4 {

    // Sorts movie list based on attribute and order
    public static void sortByAttribute(List<Movie> movielist, String attribute, String order) {

        // Explicit null handling (static analyzer friendly)
        if (movielist == null) {
            return;
        }

        if (attribute == null) {
            return;
        }

        if (order == null) {
            return;
        }

        if (movielist.isEmpty() ||
            attribute.trim().isEmpty() ||
            order.trim().isEmpty()) {
            return;
        }

        Comparator<Movie> comparator = null;

        switch (attribute.toLowerCase()) {

            case "title":
                comparator = Comparator.comparing(
                        m -> m.getTitle().toLowerCase()
                );
                break;

            case "releasedate":
                comparator = Comparator.comparing(
                        m -> m.getReleaseDate().toLowerCase()
                );
                break;

            case "director":
                comparator = Comparator.comparing(
                        m -> m.getDirector().toLowerCase()
                );
                break;

            case "duration":
                comparator = Comparator.comparingInt(Movie::getDuration);
                break;

            default:
                // Invalid attribute provided
                return;
        }

        // Apply descending order if required
        if (order.equalsIgnoreCase("desc")) {
            comparator = comparator.reversed();
        }

        Collections.sort(movielist, comparator);
    }

    // ----------- NON-EDITABLE CODE STARTS HERE -----------
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Movie> movielist = new ArrayList<>();

        int numberOfMovies = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfMovies; i++) {

            String title = scanner.nextLine();
            String releaseDate = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());
            String director = scanner.nextLine();
            int duration = Integer.parseInt(scanner.nextLine());

            List<String> cast = new ArrayList<>(
                    Arrays.asList(scanner.nextLine().split(",\\s*"))
            );

            movielist.add(new Movie(title, releaseDate, rating, director, cast, duration));
        }

        String sortAttribute = scanner.nextLine();
        String sortOrder = scanner.nextLine();
        String searchKeyword = scanner.nextLine();

        // Search output
        movielist.stream()
                .filter(movie -> movie.searchByKeyword(searchKeyword))
                .forEach(movie -> System.out.println(movie.getTitle()));

        // Sort and output
        sortByAttribute(movielist, sortAttribute, sortOrder);
        movielist.forEach(movie -> System.out.println(movie.getTitle()));

        scanner.close();
    }
    // ----------- NON-EDITABLE CODE ENDS HERE -----------
}
