package visma.praktika.uzd.service.file;

import visma.praktika.uzd.dto.Books;

import java.io.IOException;
import java.util.ArrayList;

public interface FileService {
    ArrayList<Books> readFile(String fileLocation) throws IOException;
    void writeFile(String fileLocation) throws IOException;
}
