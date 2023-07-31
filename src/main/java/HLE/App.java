package HLE;

import HLE.entity.Author;
import HLE.entity.Book;
import HLE.entity.Publisher;
import HLE.enums.Gender;
import HLE.service.AuthorService;
import HLE.service.BookService;
import HLE.service.PublisherService;
import HLE.service.ReaderService;
import HLE.service.impl.BookServiceImpl;
import HLE.service.impl.PublisherServiceImpl;
import HLE.service.impl.ReaderServiceImpl;
import HLE.service.impl.AuthorServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AuthorService authorService = new AuthorServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        PublisherService publisherService = new PublisherServiceImpl();
        BookService bookService = new BookServiceImpl();
        publisherService.getPublisherByName("Inuzukas");

    }
}