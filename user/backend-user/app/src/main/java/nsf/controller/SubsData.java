package nsf.controller;
public class SubsData{
    private String title;
    private String description;
    private int videos;

    public SubsData(String title, String description, int videos) {
        this.title = title;
        this.description = description;
        this.videos=videos;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public int getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title + "\nDescription: " + description + "\n"+"Total Videos: " + videos +"\n";
    }
}