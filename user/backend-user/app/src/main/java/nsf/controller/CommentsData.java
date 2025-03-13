package nsf.controller;
public class CommentsData{
    public String title;
    public String description;
    public String categoryId;
    public String comment;
    public String duration;
    public int sentiment;
    
    public CommentsData() {

    }
    public CommentsData(String title, String description, String categoryId, String duration) {
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.duration=duration;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\n";
    }
}