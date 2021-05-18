package visma.praktika.uzd.service.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import visma.praktika.uzd.dto.Books;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service("fileService")
class FileServiceImpl implements FileService{
    private ArrayList<Books> books = new ArrayList<>();
    @Override
    public ArrayList<Books> readFile(String fileLocation) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
        if (reader.ready()){
            Type bookType = new TypeToken<ArrayList<Books>>(){}.getType();
            this.books = gson.fromJson(reader, bookType);
            reader.close();
        }
        return this.books;
    }

    @Override
    public void writeFile(String fileLocation) throws IOException {
        Writer writer = new FileWriter(fileLocation);
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        gson.toJson(this.books, writer);
        writer.flush();
        writer.close();
    }
}
