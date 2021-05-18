package visma.praktika.uzd.dto;

import java.util.UUID;

public class Books {
    private String name;
    private String author;
    private String category;
    private String language;
    private String publicationDate;
    private String ISBN;
    private String GUID;
    private boolean occupation;
    private String username;
    private String time;

    public Books(String name, String author, String category, String language, String publicationDate, String ISBN) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.language = language;
        this.publicationDate = publicationDate;
        this.ISBN = ISBN;
        UUID uuid = UUID.randomUUID();
        this.GUID = uuid.toString();
        this.occupation = false;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public String getGUID() {
        return GUID;
    }
    public void setGUID(String GUID) {
        this.GUID = GUID;
    }
    public boolean getOccupation() {
        return occupation;
    }
    public void setOccupation(boolean occupation) {
        this.occupation = occupation;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
