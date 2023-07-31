package HLE.service.impl;

import HLE.entity.Book;
import HLE.repository.BookRepository;
import HLE.repository.impl.BookRepositoryImpl;
import HLE.service.BookService;

public class BookServiceImpl implements BookService {
   BookRepository repository = new BookRepositoryImpl();
    @Override
    public String saveBook(Book book) {
        return repository.saveBook(book);
    }
}
