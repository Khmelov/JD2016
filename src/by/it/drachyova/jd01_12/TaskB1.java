package by.it.drachyova.jd01_12;

import java.util.HashMap;

/**
    Задать текст на английском языке (100 и более слов). Вывести все различные слова. Для каждого слова
    подсчитать частоту его встречаемости. Слова, отличающиеся регистром букв, считать различными.
    Использовать класс HashMap.
 */

public class TaskB1 {
    private static String text=" All books about London usually starts with the same phrase: «The capital" +
            " of Great Britain is London». Of course, it is true. This fact knows practically everybody. But " +
            "there are also so many other interesting and marvellous information about London. For me London " +
            "is a dream city, a city which I want to visit one day. Obviously, London is a great place to see." +
            " The first world underground was built in London. London subway is famous all over the world." +
            " I want to have a look on it. With the help of London subway you will have a chance to know London."+
            "London contains 4 parts, unlike to each other: the West End, the East End, the City and Westminster." +
            " The West End is famous for its various rich shops, restaurants, museums. It is a part of London" +
            " for people with a big amount of money. Contrarily, the East End means poverty, working people are its" +
            " inhabitants. The City is a business place. Here you can find a great amount of offices, companies, " +
            "business centers. Lastly, Westminster is full of  sightseeing attractions."+
            "There are so many places in London to see that it is difficult to mark some most famous, but I would try " +
            "to do this. I can not but mention Big Ben. Practically everybody knows that Big Ben is London famous" +
            " clock. Far from Big Ben you will see London eye, the biggest one in Europe. It is a unique chance" +
            " to see London from bird’s eye panorama. It’s height is 135 metres. London eye is one of the biggest" +
            " in the world. London is famous for Westminster Abbey — a gothic church. It is a traditional place" +
            " of king’s coronation and deposition. London is rich for its parks." +
            " One of them is Guide Park. Here you can have a rest on weekends. It is famous fot it’s oratory corner." +
            " The list of London sightseeing attractions can be endless."+
            "Finally I want to say that London is city-fairy tale. This city should visit everyone to broaden" +
            " his/her outlook.";
    static HashMap<String, Integer> createHashMap() {          //создаем частотный словарь
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] words = text.split("[^a-zA-Z]+");            //разбиваем текст на слова
        for (int i=0; i<words.length;i++) {
            if (!hashMap.containsKey(words[i])) {              //если слово не содержится в словаре
                hashMap.put(words[i],1); }                     //записываем его и его частоту равную 1
            else {                                             //если же слово содержится
                int count = hashMap.get(words[i])+1;           //увеличиваем счетчик на 1
                hashMap.put(words[i], count);                  //записываем слово с новым счетчиком
            }
        }
        return hashMap;
    }
    static void printHashMap(HashMap <String,Integer> hashMap) {       //выводим в консоль пары слово и частота
        for (HashMap.Entry<String, Integer> pair: hashMap.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
