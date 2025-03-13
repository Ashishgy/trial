package nsf.controller;
public class LikesData{
    private String title;
    private String description;
    private String channelTitle;
    private String duration;

    public LikesData(String title, String description, String channelTitle, String duration) {
        this.title = title;
        this.description = description;
        this.channelTitle = channelTitle;
        this.duration=duration;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    public String getChannelTitle() {
        return channelTitle;
    }
    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title + "\nDescription: " + description + "\n"+"Channel Title: " + channelTitle +"\n" + "Duration: " + duration +"\n";
    }
}