package by.it.belsky.jd01_12.TaskB;

import java.util.*;

/**
 * Created by misha on 12.06.2016.
 */
public class VariantB1 {
    // public static void main(String[] args) {
    String text = "Let's imagine ...You're watching TV. It's a hot evening: You feel thirsty.\n" +
            " You see an advert for a refreshing drink. You see people looking cool and relaxed.\n" +
            "You notice the name of the refreshing drink because you think it could be useful for\n" +
            " you to satisfy your thirst.\n" +
            "Advertisers study how people learn so that they can 'teach' them to respond to their \n" +
            "advertising. They want us to be interested, to try something, and then to do it again.\n" +
            " These are the elements of learning: interest, experience and repetition. If an advert\n" +
            "can achieve this, it is successful. If an advert works well, the same technique can be \n" +
            "used to advertise different things. So, for example, in winter if the weather is cold\n" +
            " and you see a family having a warming cup of tea and feeling cosy, you may be interested\n" +
            " and note the name of the tea ... Here the same technique is being used as with the cool,\n" +
            " refreshing drink.";

    public Map<String, Integer> WordMatching() {
        Map<String, Integer> map = new HashMap<>();
        String word[] = text.split("[^a-zA-Z]+");
        List<String> words=Arrays.asList(word);

        for (int i = 0; i < word.length; i++) {
            if (!map.containsKey(word[i])) {
                int count = Collections.frequency(words, word[i]);
                map.put(word[i], count);
            }
//            if (!map.containsKey(word[i])) {
//                map.put(word[i], 1);
//            } else {
//                int x = map.get(word[i]) + 1;
//                map.put(word[i], x);
//              System.out.println();
//            }
        }
        return map;
    }

}