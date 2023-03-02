package wiseSaying.controller;

public class WiseSaying {
    private Long number;
    private String title;
    private String author;

    public WiseSaying(Long number, String title, String author) {
        this.number = number;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return number + " / " + author + " / " + title;
    }

    public Long getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
