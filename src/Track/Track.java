package Track;

public class Track {

    private String title;
    private String album;
    private Format format;

    public static Track builder(){
        return new Track();
    }

    public Track title(String title){
        this.title = title;
        return this;
    }

    public Track album(String album){
        this.album = album;
        return this;
    }

    public Track format(Format format){
        this.format = format;
        return this;
    }

    public Format getFormat() {
        return this.format;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", format=" + format +
                '}';
    }

}
