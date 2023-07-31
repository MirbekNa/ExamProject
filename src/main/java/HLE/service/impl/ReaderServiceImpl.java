package HLE.service.impl;

import HLE.entity.Reader;
import HLE.repository.ReaderRepository;
import HLE.repository.impl.ReaderRepositoryImpl;
import HLE.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
   ReaderRepository repository = new ReaderRepositoryImpl();
    @Override
    public String saveReader(Reader reader) {
        return repository.saveReader(reader);
    }
}
