package ideaProjects.wordSearcher;

import java.util.*;

public class Searcher {
    InvertedIndex invertedIndex;

    public Searcher(InvertedIndex invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    public String[] splitKeywords(String keyword) {
        String[] keywordArray = keyword.split("\\s+");

        return keywordArray;

    }

    // Keyword Search method
    private List<String> searchDocuments(String keyword) {

        List<Document> resultDocumentList = new ArrayList<Document>();
        resultDocumentList = this.invertedIndex.index.get(keyword);
        List<String> resultIdList = new ArrayList<String>();

        if (resultDocumentList == null) {
            System.out.println("No search result!");
        } else {
            for (int i = 0; i < resultDocumentList.size(); i++) {
                Document resultDocument = resultDocumentList.get(i);
                resultIdList.add(resultDocument.getDocId());
            }
        }

        return resultIdList;

    }

    // Keyword Search method
    public List<String> Search(String inputKeyword) {
        String[] terms = splitKeywords(inputKeyword.toLowerCase());
        List<String> resultIdFlattenList = new ArrayList<String>();
        HashMap<String, Integer> countMap = new HashMap<String, Integer>();
        List<String> searchResults = new ArrayList<String>();


        for (int j = 0; j < terms.length; j++) {
            resultIdFlattenList.addAll(searchDocuments(terms[j]));
        }


        for (String id : resultIdFlattenList) {
            if (countMap.containsKey(id)) {

                countMap.put(id, countMap.get(id) + 1);
            } else {
                countMap.put(id, 1);
            }
        }

        Set set = countMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();

            if (value == terms.length) {
                searchResults.add(key);
            }


        }

        return searchResults;
    }

}
