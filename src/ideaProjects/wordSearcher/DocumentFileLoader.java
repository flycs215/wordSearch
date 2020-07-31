package ideaProjects.wordSearcher;

import java.io.File;
import java.net.URL;

public class DocumentFileLoader {

    // Read and Get all files in the folder
    public File[] getFilesinFolder() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("main/resources/");
        String path = url.getPath();
        return new File(path).listFiles();
//
//
//        File fileDir = new File("/Users/David/IdeaProjects/wordSearch/src/files");
//        return fileDir.listFiles();
    }
}
