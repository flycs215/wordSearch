package ideaProjects.wordSearcher;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        DataLoader dataLoader = new DataLoader();
        List<Document> documents = dataLoader.loadDocument();

        InvertedIndex invertedIndex = new InvertedIndex();
        invertedIndex.indexDocuments(documents);

        Searcher searcher = new Searcher(invertedIndex);

        // Input keyword and return file names in which the keyword is and unlimites loop.
        while (true) {

            System.out.println();
            System.out.println("== Search ==");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.print(" - Search keyword: ");
            String inputKeyword = sc.nextLine();

            System.out.print(" - Searched document IDs: ");
            List<String> intersectionId = searcher.Search(inputKeyword);

            for (int i = 0; i < intersectionId.size(); i++) {
                System.out.print(intersectionId.get(i) + " ");
            }

        }

    }
}
