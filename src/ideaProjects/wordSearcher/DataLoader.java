package ideaProjects.wordSearcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataLoader {

    List<Document> documentList = new ArrayList<Document>();

    public List<Document> loadDocument() throws IOException {

        DocumentParser documentParser = new DocumentParser();
        DocumentFileLoader documentFileLoader = new DocumentFileLoader();
        File[] documentFileList = documentFileLoader.getFilesinFolder();

        System.out.println("== Start loading document ==");

        for (File fileEntry : documentFileList) {

            documentList.add(documentParser.parse(fileEntry));

        }

        System.out.println("The number of parsed document: " + documentList.size());
        System.out.println("== End loading document == ");
        System.out.println();

        return documentList;
    }


}