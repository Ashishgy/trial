package nsf.controller;
public class VideoData{
    private String title;
    private String description;
    private String categoryId;
    private String duration;

    public VideoData(String title, String description, String categoryId, String duration) {
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
        return "Title: " + title + "\nDescription: " + description + "\n" + "duration: "+duration+"\n cat: " +categoryId;
    }
}