package HLE.repository;

import HLE.entity.Reader;

import java.util.List;

public interface ReaderRepository {
    String saveReader(Reader reader);

   void updateReader(Reader updateReader);

  Reader getReaderByBookId(Long id);

    List<Reader> getReadersByAuthorId(Long authorId);
    void deleteReaderById(Long id);


}
