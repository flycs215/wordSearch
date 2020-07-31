package ideaProjects.wordSearcher;

import java.io.IOException;
import java.util.*;

public class Document {


    private String docId;
    private String docTitle;
    private List<String> docContents;
    private List<String> contentsList = new ArrayList<String>();
    private HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();

    public Document(String docId, String docTitle, List docContents) {
        this.docId = docId;
        this.docTitle = docTitle;
        this.docContents = docContents;
    }


    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }

    public List<String> getDocContents() {
        return docContents;
    }

    public void setDocContents(List<String> docContents) {
        this.docContents = docContents;
    }


    public HashMap<String, Integer> getWordCounts() throws IOException {


        contentsList = getDocContents();

        // Creat contents Array
        List<String> contentsTotalList = new ArrayList<String>();
        for (int i = 0; i < contentsList.size(); i++) {

            String[] contentsArray = contentsList.get(i).split("\\s+");
            for (int j = 0; j < contentsArray.length; j++) {
                contentsTotalList.add(contentsArray[j]);

            }
        }
        String[] contentsArray = contentsTotalList.toArray(new String[0]);

        // HashMap Words
        for (int i = 0; i < contentsArray.length; i++) {
            if (wordsMap.containsKey(contentsArray[i])) {
                wordsMap.put(contentsArray[i].toLowerCase(), wordsMap.get(contentsArray[i]) + 1);
            } else {
                wordsMap.put(contentsArray[i].toLowerCase(), 1);
            }
        }

        return wordsMap;
    }


    // Print hashmap
    public void getWordMap() {

        Set keyAndValue = wordsMap.entrySet();
        Iterator<Map.Entry> iterator = keyAndValue.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            System.out.println(key + ": " + value);
        }
    }


    @Override
    public String toString() {
        return "TotalDocument{" +
                "docId: '" + docId + '\'' +
                ", docTitle: '" + docTitle + '\'' +
                ", docContents: " + docContents +
                '}';
    }
}
