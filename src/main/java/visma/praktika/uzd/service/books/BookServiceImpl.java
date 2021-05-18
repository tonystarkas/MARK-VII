package visma.praktika.uzd.service.books;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visma.praktika.uzd.dto.Books;
import visma.praktika.uzd.service.file.FileService;

@Service("bookService")
class BookServiceImpl implements BookService {
    private final FileService fileService;
    public BookServiceImpl(@Autowired FileService fileService) {
        this.fileService = fileService;
    }
    private static String bookFile = "books.json";
    private ArrayList<Books> books = new ArrayList<>();

    @Override
    public void addBook(String name, String author, String category, String language, String publicationDate, String ISBN) throws IOException {
        books = fileService.readFile(bookFile);
        Books newBook = new Books(name, author, category, language, publicationDate, ISBN);
        this.books.add(newBook);
        fileService.writeFile(bookFile);
    }

    @Override
    public void takeBook(String name, String username, String takeDate, String returnDate) throws IOException {
        books = fileService.readFile(bookFile);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(takeDate, dtf);
        LocalDate date2 = LocalDate.parse(returnDate, dtf);
        long p2 = ChronoUnit.DAYS.between(date1, date2);
        int timesTaken = 0;
        for (Books b : books){
            if (b.getOccupation()){
                if (b.getUsername().equals(username)){
                    timesTaken++;
                }
            }
        }
        for (Books b : books){
            if (b.getName().equals(name)){
                if (p2 < 61 && timesTaken <= 3 && !b.getOccupation()){
                    b.setOccupation(true);
                    b.setUsername(username);
                    b.setTime(String.valueOf(p2));
                    break;
                }
                else{
                    System.out.println("Book is not available.");
                }
            }
        }
        fileService.writeFile(bookFile);
    }
    @Override
    public void getBookByGUID(String GUID) throws IOException {
        books = fileService.readFile(bookFile);
        for (Books b : books){
            if(b.getGUID().equals(GUID)){
                System.out.println(b.getName());
            }
        }
    }
    @Override
    public void filterBooks(String filterBy, String secondFilter) throws IOException {
        books = fileService.readFile(bookFile);
        for (Books b : books){
            if (filterBy.equals("author")){
                if (b.getAuthor().contains(secondFilter)){
                    System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                            ";"+b.getGUID());
                }
            }
            if (filterBy.equals("category")){
                if (b.getCategory().contains(secondFilter)){
                    System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                            ";"+b.getGUID());
                }
            }
            if (filterBy.equals("language")){
                if (b.getLanguage().contains(secondFilter)){
                    System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                            ";"+b.getGUID());
                }
            }
            if (filterBy.equals("ISBN")){
                if (b.getISBN().equals(secondFilter)){
                    System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                            ";"+b.getGUID());
                }
            }
            if (filterBy.equals("occupation")){
                if (secondFilter.equals("true")){
                    if (b.getOccupation()){
                        System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                                ";"+b.getGUID());
                    }
                }
                else{
                    if (!b.getOccupation()){
                        System.out.println(b.getName()+";"+b.getAuthor()+";"+b.getCategory()+";"+b.getLanguage()+";"+b.getPublicationDate()+";"+b.getISBN()+
                                ";"+b.getGUID());
                    }
                }
            }
        }
    }
    @Override
    public void deleteBook(String name) throws IOException {
        books = fileService.readFile(bookFile);
        books.removeIf(b -> b.getName().equals(name));
        fileService.writeFile(bookFile);
    }
}