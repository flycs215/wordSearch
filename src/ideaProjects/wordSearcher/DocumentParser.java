package ideaProjects.wordSearcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentParser {


    // Read files in the folder and return document object
    public Document parse(File file) throws IOException {

        String id = file.getName();
        String path = "/Users/David/IdeaProjects/wordSearch/src/files";
        String pathTotal = path + "/" + id;
        List<String> contentsList = Files.readAllLines(Paths.get(pathTotal));

        String docTitle = contentsList.get(0);
        List<String> docContents = new ArrayList<String>();
        for (int j = 1; j < contentsList.size(); j++) {
            docContents.add(contentsList.get(j));
        }

        Document document = new Document(getWithoutExtension(id), docTitle, docContents);
        return document;
    }

    public static String getWithoutExtension(String str) {
        String result = str.substring(0, str.length() - 4);
        return result;
    }

}



