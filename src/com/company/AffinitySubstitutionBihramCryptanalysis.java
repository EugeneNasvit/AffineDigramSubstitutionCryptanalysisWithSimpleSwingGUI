package com.company;

import java.io.*;
import java.util.*;


/**
 * Created by User on 10.04.2017.
 */
class AffinitySubstitutionBihramCryptanalysis {

    private final String cipherText = "C:\\text.txt";
    private final String alphabet = "абвгдежзийклмнопрстуфхцчшщьыэюя";
    final String[] mostFrequentRussianBihrams = {"ст", "но", "то", "на", "ен"};

    private String filterText(String unfiltered) throws Exception{
        return unfiltered.replaceAll("[^а-яА-Я]", "").replaceAll("ё", "е").replaceAll("ъ", "ь").toLowerCase();
    }

    private String writeFileIntoString (String filePath) throws Exception{
        StringBuilder builder = new StringBuilder();
        FileInputStream inputStream = new FileInputStream(filePath);
        InputStreamReader streamReader = new InputStreamReader(inputStream, "Windows-1251");
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            builder.append(currentLine);
        }
        return builder.toString();
    }

    String writeFileIntoStringForEncodedText (String filePath) throws Exception{
        StringBuilder builder = new StringBuilder();
        FileInputStream inputStream = new FileInputStream(filePath);
        InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            builder.append(currentLine);
        }
        return builder.toString();
    }

    private Map<String, Double> createBihramList() throws Exception{
        char[] arrAlphabet = alphabet.toCharArray();
        List<String> list = new LinkedList<>();

        for (char ch : arrAlphabet) {
            list.add(ch+"");
        }

        for (int i = 0; i <31; i++) {
            for (int j = 0; j < 31; j++) {
                list.add(list.get(i)+list.get(j));
            }
        }

        for (int i = 0; i < 31; i++) {
            list.remove(list.get(0));
        }

        Map<String, Double> map = new TreeMap<>();
        for (String str : list) {
            map.put(str, 0d);
        }
        return map;
    }

    String[] getBihramFrequency(String filepath) throws Exception{
        String[] mostFrequentBihrams = new String[5];
        int cipherTextLength = writeFileIntoString(filepath).length();
        Map<String, Double> map = createBihramList();
        String text = writeFileIntoString(filepath);
        char[] arrText = text.toCharArray();

        for (int i = 0; i < cipherTextLength; i+=2) {

            if (i != cipherTextLength - 1) {
                StringBuilder builder = new StringBuilder("");
                String bihram = builder.append(arrText[i]).append(arrText[i + 1]).toString();

                if (map.containsKey(bihram)) {
                    map.computeIfPresent(bihram, (k, v) -> v + 1);
                }
            } else {
                break;
            }
        }

        /* remove zero frequency */
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> pair = iterator.next();
            if (pair.getValue() == 0d) {
                iterator.remove();
            }
        }

        /* print 5 most frequent bihram */
        int counter = 0;
        while (counter < 5) {
            mostFrequentBihrams[counter] = findTheMostFrequentBihram(map);
            counter++;
        }
        return mostFrequentBihrams;
    }

    private String[] getBihramFrequencyFromString(String str) throws Exception{
        String[] mostFrequentBihrams = new String[5];
        int cipherTextLength = str.length();
        Map<String, Double> map = createBihramList();
        char[] arrText = str.toCharArray();

        for (int i = 0; i < cipherTextLength; i+=2) {

            if (i != cipherTextLength - 1) {
                StringBuilder builder = new StringBuilder("");
                String bihram = builder.append(arrText[i]).append(arrText[i + 1]).toString();

                if (map.containsKey(bihram)) {
                    map.computeIfPresent(bihram, (k, v) -> v + 1);
                }
            } else {
                break;
            }
        }

        /* remove zero frequency */
        Iterator<Map.Entry<String, Double>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Double> pair = iterator.next();
            if (pair.getValue() == 0d) {
                iterator.remove();
            }
        }

        /* print 5 most frequent bihram */
        int counter = 0;
        while (counter < 5) {
            mostFrequentBihrams[counter] = findTheMostFrequentBihram(map);
            counter++;
        }
        return mostFrequentBihrams;
    }

    private String findTheMostFrequentBihram(Map<String, Double> map) throws Exception{
        double max = 0;
        String bihram = "";
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            String key = pair.getKey();
            double value = pair.getValue();

            if (max < value) {
                max = value;
                bihram = key;
            }
        }
        map.remove(bihram, max);
        return bihram;
    }

    int simpleEuclideanAlgorithm(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    private static int[] gcd(int p, int q) {
        if (q == 0) {
            return new int[]{p, 1, 0};
        }
        int[] vals = gcd(q, p % q);
        int d = vals[0];
        int a = vals[2];
        int b = vals[1] - (p / q) * vals[2];
        return new int[] { d, a, b };
    }

    String useExtendedEA(int p, int q) {
        int values[] = gcd(p, q);
        return values[1] + "(" + p + ") + " + values[2] + "(" + q + ") = " + values[0];
    }

    int getModularInverse(int p, int q) {
        int values[] = gcd(p, q);
        int result = values[1];
        if (result < 0) {
            while (result < 0) {
                result += q;
            }
        }
        return result;
    }

    int[] solveLinearComparison(int a, int b, int module) {
        int[] solutions = {};
        if (a != 0 || b != 0) {
            int x;
            int gcd = simpleEuclideanAlgorithm(a, module);

            if (gcd == 1) {
                x = getModularInverse(a, module) * b;

                if (x > module) {
                    x %= module;
                } else if (x < 0) {
                    while (x < 0) {
                        x += module;
                    }
                }
                solutions = new int[1];
                solutions[0] = x;
            } else {

                if (b % gcd != 0) {
                    return solutions;
                } else {
                    a /= gcd;
                    b /= gcd;
                    module /= gcd;
                    x = b * getModularInverse(a, module);

                    if (x > module) {
                        x %= module;
                    } else if (x < 0) {
                        while (x < 0) {
                            x += module;
                        }
                    }
                    int counter;
                    solutions = new int[gcd];
                    for (counter = 0; counter < gcd; counter++) {
                        solutions[counter] = x + counter * module;
                    }
                }
            }
        }
        return solutions;
    }

    void encodingTest(int a, int b, String fullPath) throws Exception{
        File file = new File("C:\\testEncodedText.txt");
        FileWriter writer = new FileWriter(file);
        String text0 = writeFileIntoString(fullPath);
        String text;
        if (text0.contains(" ") || text0.contains(".") || text0.contains(",")) {
            text = filterText(text0);
        } else {
            text = text0;
        }
        char[] textArr = text.toCharArray();
        int length = textArr.length;
        int m = alphabet.length();

        /* alphabet */
        char[] arrAlphabet = alphabet.toCharArray();

        /* alphabet map*/
        Map<Character, Integer> alphabetMap = new TreeMap<>();
        for (int i = 0; i < arrAlphabet.length; i++) {
            alphabetMap.put(arrAlphabet[i], i);
        }

        /* plain text letter numbers */
        int[] letterNumbers = new int[length];
        for (int i = 0; i < letterNumbers.length; i++) {
            if (alphabetMap.containsKey(textArr[i])) {
                letterNumbers[i] = alphabetMap.get(textArr[i]);
            }
        }

        /* encoded letter's numbers array */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i+=2) {
            int bihramNumber = letterNumbers[i] * m + letterNumbers[i + 1];
            int encodedNumber = a * bihramNumber + b;
            if (encodedNumber > m * m) {
                encodedNumber %= (m * m);
            }
            list.add(encodedNumber / m);
            list.add(encodedNumber % m);
        }

        int[] encodedLetters = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            encodedLetters[i] = list.get(i);
        }

        /* encoded text*/
        StringBuilder encodedText = new StringBuilder("");
        for (int i = 0; i < encodedLetters.length; i++) {
            for (Map.Entry<Character, Integer> pair : alphabetMap.entrySet()) {
                char ch = pair.getKey();
                int value = pair.getValue();
                if (value == encodedLetters[i]) {
                    encodedText.append(ch);
                }
            }
        }
        String encodedPlainText = encodedText.toString();
        writer.write(encodedPlainText);
        writer.flush();
        writer.close();
    }

    void decodingTest(int a, int b, String fullPath) throws Exception{
        File file = new File("C:\\testDecodedText.txt");
        FileWriter writer = new FileWriter(file);
        String text = writeFileIntoString(fullPath);
        char[] textArr = text.toCharArray();
        int length = textArr.length;
        int m = alphabet.length();

        /* alphabet */
        char[] arrAlphabet = alphabet.toCharArray();

        /* alphabet map*/
        Map<Character, Integer> alphabetMap = new TreeMap<>();
        for (int i = 0; i < arrAlphabet.length; i++) {
            alphabetMap.put(arrAlphabet[i], i);
        }

        /* encoded text letter numbers */
        int[] letterNumbers = new int[length];
        for (int i = 0; i < letterNumbers.length; i++) {
            if (alphabetMap.containsKey(textArr[i])) {
                letterNumbers[i] = alphabetMap.get(textArr[i]);
            }
        }

        /* plain letter's numbers array */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i+=2) {
            int encodedBihramNumber = letterNumbers[i] * m + letterNumbers[i + 1];
            int decodedBihramNumber = getModularInverse(a, m * m) * (encodedBihramNumber - b);
            if (decodedBihramNumber > m * m) {
                decodedBihramNumber %= (m * m);
            } else if (decodedBihramNumber < 0){
                while (decodedBihramNumber < 0) {
                    decodedBihramNumber += m * m;
                }
            }
            list.add(decodedBihramNumber / m);
            list.add(decodedBihramNumber % m);
        }

        int[] decodedLetters = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            decodedLetters[i] = list.get(i);
        }

        /* decoded text*/
        StringBuilder encodedText = new StringBuilder("");
        for (int i = 0; i < decodedLetters.length; i++) {
            for (Map.Entry<Character, Integer> pair : alphabetMap.entrySet()) {
                char ch = pair.getKey();
                int value = pair.getValue();
                if (value == decodedLetters[i]) {
                    encodedText.append(ch);
                }
            }
        }
        String encodedPlainText = encodedText.toString();
        writer.write(encodedPlainText);
        writer.flush();
        writer.close();
    }

    void decodingTestForAnotherEncoding(int a, int b, String fullPath) throws Exception{
        File file = new File("C:\\testDecodedText.txt");
        FileWriter writer = new FileWriter(file);
        String text = writeFileIntoStringForEncodedText(fullPath);
        char[] textArr = text.toCharArray();
        int length = textArr.length;
        int m = alphabet.length();

        /* alphabet */
        char[] arrAlphabet = alphabet.toCharArray();

        /* alphabet map*/
        Map<Character, Integer> alphabetMap = new TreeMap<>();
        for (int i = 0; i < arrAlphabet.length; i++) {
            alphabetMap.put(arrAlphabet[i], i);
        }

        /* encoded text letter numbers */
        int[] letterNumbers = new int[length];
        for (int i = 0; i < letterNumbers.length; i++) {
            if (alphabetMap.containsKey(textArr[i])) {
                letterNumbers[i] = alphabetMap.get(textArr[i]);
            }
        }

        /* plain letter's numbers array */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i+=2) {
            int encodedBihramNumber = letterNumbers[i] * m + letterNumbers[i + 1];
            int decodedBihramNumber = getModularInverse(a, m * m) * (encodedBihramNumber - b);
            if (decodedBihramNumber > m * m) {
                decodedBihramNumber %= (m * m);
            } else if (decodedBihramNumber < 0){
                while (decodedBihramNumber < 0) {
                    decodedBihramNumber += m * m;
                }
            }
            list.add(decodedBihramNumber / m);
            list.add(decodedBihramNumber % m);
        }

        int[] decodedLetters = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            decodedLetters[i] = list.get(i);
        }

        /* decoded text*/
        StringBuilder encodedText = new StringBuilder("");
        for (int i = 0; i < decodedLetters.length; i++) {
            for (Map.Entry<Character, Integer> pair : alphabetMap.entrySet()) {
                char ch = pair.getKey();
                int value = pair.getValue();
                if (value == decodedLetters[i]) {
                    encodedText.append(ch);
                }
            }
        }
        String encodedPlainText = encodedText.toString();
        writer.write(encodedPlainText);
        writer.flush();
        writer.close();
    }

    private void decoding13(int a, int b) throws Exception{
        File file = new File("C:\\cracked.txt");
        FileWriter writer = new FileWriter(file, true);
        String text = writeFileIntoString(cipherText);
        char[] textArr = text.toCharArray();
        int length = textArr.length;
        int m = alphabet.length();

        /* alphabet */
        char[] arrAlphabet = alphabet.toCharArray();

        /* alphabet map*/
        Map<Character, Integer> alphabetMap = new TreeMap<>();
        for (int i = 0; i < arrAlphabet.length; i++) {
            alphabetMap.put(arrAlphabet[i], i);
        }

        /* encoded text letter numbers */
        int[] letterNumbers = new int[length];
        for (int i = 0; i < letterNumbers.length; i++) {
            if (alphabetMap.containsKey(textArr[i])) {
                letterNumbers[i] = alphabetMap.get(textArr[i]);
            }
        }

        /* plain letter's numbers array */
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i+=2) {
            int encodedBihramNumber = letterNumbers[i] * m + letterNumbers[i + 1];
            int decodedBihramNumber = getModularInverse(a, m * m) * (encodedBihramNumber - b);
            if (decodedBihramNumber > m * m) {
                decodedBihramNumber %= (m * m);
            } else if (decodedBihramNumber < 0) {
                while (decodedBihramNumber < 0) {
                    decodedBihramNumber += m * m;
                }
            }
            list.add(decodedBihramNumber / m);
            list.add(decodedBihramNumber % m);
        }

        int[] decodedLetters = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            decodedLetters[i] = list.get(i);
        }

        /* decoded text*/
        StringBuilder encodedText = new StringBuilder("");
        for (int i = 0; i < decodedLetters.length; i++) {
            for (Map.Entry<Character, Integer> pair : alphabetMap.entrySet()) {
                char ch = pair.getKey();
                int value = pair.getValue();
                if (value == decodedLetters[i]) {
                    encodedText.append(ch);
                }
            }
        }
        String encodedPlainText = encodedText.toString();
        if (isThatText(encodedPlainText)) {

            writer.write("\r\n" + "key -> (" + a + "," + b + ") " + "\r\n");
            writer.write(encodedPlainText + "\r\n");
            writer.flush();
            writer.close();
        }
    }

    private void checkKeyFor13(String bihram1, String encodedBihram1, String bihram2, String encodedBihram2) throws Exception{

        /* alphabet */
        char[] arrAlphabet = alphabet.toCharArray();

        /* alphabet map*/
        Map<Character, Integer> alphabetMap = new TreeMap<>();
        for (int i = 0; i < arrAlphabet.length; i++) {
            alphabetMap.put(arrAlphabet[i], i);
        }

        char[] first = bihram1.toCharArray();
        char[] firstEncoded = encodedBihram1.toCharArray();
        char[] second = bihram2.toCharArray();
        char[] secondEncoded = encodedBihram2.toCharArray();

        /* bihram 1 letter numbers */
        int[] firstIndexes = new int[2];
        for (int i = 0; i < 2; i++) {
            if (alphabetMap.containsKey(first[i])) {
                firstIndexes[i] = alphabetMap.get(first[i]);
            }
        }
        int bihram1Number = firstIndexes[0] * arrAlphabet.length + firstIndexes[1]; //-------Х*

        /* encoded bihram 1 letter numbers */
        int[] firstEncodedIndexes = new int[2];
        for (int i = 0; i < 2; i++) {
            if (alphabetMap.containsKey(firstEncoded[i])) {
                firstEncodedIndexes[i] = alphabetMap.get(firstEncoded[i]);
            }
        }
        int encodedBihram1Number = firstEncodedIndexes[0] * arrAlphabet.length + firstEncodedIndexes[1]; //------У*

        /* bihram 2 letter numbers */
        int[] secondIndexes = new int[2];
        for (int i = 0; i < 2; i++) {
            if (alphabetMap.containsKey(second[i])) {
                secondIndexes[i] = alphabetMap.get(second[i]);
            }
        }
        int bihram2Number = secondIndexes[0] * arrAlphabet.length + secondIndexes[1]; //-----Х**

        /* encoded bihram 2 letter numbers */
        int[] secondEncodedIndexes = new int[2];
        for (int i = 0; i < 2; i++) {
            if (alphabetMap.containsKey(secondEncoded[i])) {
                secondEncodedIndexes[i] = alphabetMap.get(secondEncoded[i]);
            }
        }
        int encodedBihram2Number = secondEncodedIndexes[0] * arrAlphabet.length + secondEncodedIndexes[1]; //------У**


        /* finding X* - X** and Y* - Y** */
        int firstCoef = bihram1Number - bihram2Number;
        if (firstCoef < 0) {
            firstCoef += arrAlphabet.length * arrAlphabet.length;
        }
        int secondCoef = encodedBihram1Number - encodedBihram2Number;
        if (secondCoef < 0) {
            secondCoef += arrAlphabet.length * arrAlphabet.length;
        }

        int[] solutionsForA = solveLinearComparison(firstCoef, secondCoef, arrAlphabet.length * arrAlphabet.length); //----possible variants of a

        /* finding coefficients for different b to solve linear comparisons */
        int[] coefsForB = new int[solutionsForA.length];
        for (int i = 0; i < solutionsForA.length; i++) {
            coefsForB[i] = encodedBihram1Number - solutionsForA[i] * bihram1Number;
            if (coefsForB[i] > arrAlphabet.length * arrAlphabet.length) {
                coefsForB[i] %= arrAlphabet.length * arrAlphabet.length;
            } else if (coefsForB[i] < 0) {
                while(coefsForB[i] < 0)
                coefsForB[i] += arrAlphabet.length * arrAlphabet.length;
            }
        }

        /* solving linear comparison for B */
        int[] solutionsForB = new int[coefsForB.length]; //-----possible variants of b
        for (int i = 0; i < coefsForB.length; i++) {
            int[] sol = solveLinearComparison(1, coefsForB[i], arrAlphabet.length * arrAlphabet.length);
            solutionsForB[i] = sol[0];
        }

        /* decoding text with appropriate pair of (a, b) */
        for (int i = 0; i < solutionsForA.length; i++) {
            decoding13(solutionsForA[i], solutionsForB[i]);
        }
    }

    void keyBust() throws Exception{
        String[] mostFrequentBihrams = getBihramFrequency(cipherText);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    checkKeyFor13(mostFrequentRussianBihrams[i], mostFrequentBihrams[j], mostFrequentRussianBihrams[j], mostFrequentBihrams[k]);
                }
            }
        }
    }

    private boolean isThatText(String str) throws Exception{
        boolean b = false;
        String[] arr = getBihramFrequencyFromString(str);
        if (!stringFind(str, "ыы") && !stringFind(str, "ьь") && !stringFind(str, "ыь") && !stringFind(str, "фь")
                && !stringFind(str, "ьы") && !stringFind(str, "аь") && !stringFind(str, "еь") && !stringFind(str, "оь")
                && !stringFind(str, "яь") && !stringFind(str, "уь") && !stringFind(str, "юь") && !stringFind(str, "эь")) {
            if (arr[0].equals("ст") || arr[0].equals("но") || arr[0].equals("то") || arr[0].equals("на") || arr[0].equals("ен")) {
                b = true;
            }
        }
        return b;
    }

    private static boolean stringFind(String str, String subStr) throws Exception {
        return str.contains(subStr);
    }
}