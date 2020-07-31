package ideaProjects.wordSearcher;

import java.io.IOException;
import java.util.*;


public class InvertedIndex {

    HashMap<String, List<Document>> index = new HashMap<String, List<Document>>();
    List<Document> value = new ArrayList<Document>();

    // inverted index map
    public void indexDocument(Document doc) throws IOException {

        Map<String, Integer> DocWordCount = doc.getWordCounts();
        Iterator<Map.Entry<String, Integer>> iterator = DocWordCount.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String keyWord = (String) entry.getKey();

            if (index.containsKey(keyWord)) {
                value = index.get(keyWord);
                value.add(doc);
                index.put(keyWord.toLowerCase(), value);
            } else {
                List<Document> value = new ArrayList<Document>();
                value.add(doc);
                index.put(keyWord.toLowerCase(), value);
            }
        }

    }

    public void indexDocuments(List<Document> documentList) throws IOException {

        System.out.println("== Start indexing document ==");


        for (int i = 0; i < documentList.size(); i++) {

            indexDocument(documentList.get(i));
        }

        System.out.println("The number of document indexed: " + this.index.size());
        System.out.println("== End loading document == ");
        System.out.println();

    }

}
