import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    private String description;
    private String tips;
    private List<String> reviewList;
    private String addedBy;

    public Game(String name, String description, String tips, String initialReview, String addedBy) {
        this.name = name;
        this.description = description;
        this.tips = tips;
        this.reviewList = new ArrayList<>();
        this.reviewList.add(addedBy + ": " + initialReview);
        this.addedBy = addedBy;
    }

    public Game(String name, String description, String tips) {
        this.name = name;
        this.description = description;
        this.tips = tips;
        this.reviewList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTips() {
        return tips;
    }

    public List<String> getReviewList() {
        return reviewList;
    }

    public void addReview(String review) {
        reviewList.add(review);
    }
}
