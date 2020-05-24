import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentlyMentionedKeywords {
    /*
     * Given a list of reviews, a list of keywords and an integer k. Find the most
     * popular k keywords in order of most to least frequently mentioned.
     * 
     * The comparison of strings is case-insensitive. Multiple occurances of a
     * keyword in a review should be considred as a single mention. If keywords are
     * mentioned an equal number of times in reviews, sort alphabetically.
     * 
     * Example 1:
     * 
     * Input: k = 2 keywords = ["anacell", "cetracular", "betacellular"] reviews = [
     * "Anacell provides the best services in the city",
     * "betacellular has awesome services",
     * "Best services provided by anacell, everyone should use anacell", ]
     * 
     * Output: ["anacell", "betacellular"]
     * 
     * Explanation: "anacell" is occuring in 2 different reviews and "betacellular"
     * is only occuring in 1 review. Example 2:
     * 
     * Input: k = 2 keywords = ["anacell", "betacellular", "cetracular",
     * "deltacellular", "eurocell"] reviews = [
     * "I love anacell Best services; Best services provided by anacell",
     * "betacellular has great services",
     * "deltacellular provides much better services than betacellular",
     * "cetracular is worse than anacell",
     * "Betacellular is better than deltacellular.", ]
     * 
     * Output: ["betacellular", "anacell"]
     * 
     * Explanation: "betacellular" is occuring in 3 different reviews. "anacell" and
     * "deltacellular" are occuring in 2 reviews, but "anacell"
     */

    public static List<String> topKfrequency(int k, String[] keywords, String[] reviews) {
        Map<String, Integer> frequency = new HashMap<>();
        List<String> keywordsList = Arrays.asList(keywords);
        for (String review : reviews) {
            String[] words = review.toLowerCase().split("\\W+");
            for (String word : words) {
                if (keywordsList.contains(word)) {
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        }
        List<String> result = new ArrayList<>(frequency.keySet());
        Collections.sort(result, (s1, s2)->{
            if (frequency.get(s1) > frequency.get(s2)){
                return -1;
            } else if (frequency.get(s1) < frequency.get(s2)){ 
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });
        return result.subList(0, k);
    }

    public static void main(String[] args) {
        int k = 2;
        String[] keywords = { "anacell", "cetracular", "betacellular" };
        String[] reviews = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell" };
        System.out.println(topKfrequency(k, keywords, reviews));
    }
}