package visma.praktika.uzd.service.books;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public interface BookService{
    void addBook(String name, String author, String category, String language, String publicationDate, String ISBN) throws IOException, ParseException;
    void takeBook(String name, String username, String takeDate, String returnDate) throws IOException;
    void getBookByGUID(String GUID) throws IOException;
    void filterBooks(String filterBy, String secondFilter) throws IOException;
    void deleteBook(String name) throws IOException;
}