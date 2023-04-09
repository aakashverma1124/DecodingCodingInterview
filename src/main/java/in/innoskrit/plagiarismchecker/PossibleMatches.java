package in.innoskrit.plagiarismchecker;

import java.util.*;

class Pair {
    int index;
    String word;
    Pair(int index, String word) {
        this.index = index;
        this.word = word;
    }
}

class PossibleMatches {

    public static int possibleMatches(String S, String[] words) {
        HashMap<Character, ArrayList<Pair>> characterMap = new HashMap<>();
        for(char ch = 'a'; ch <= 'z'; ch++)
            characterMap.put(ch, new ArrayList<>());

        for(String word : words)
            characterMap.get(word.charAt(0)).add(new Pair(0, word));

        int numOfStudents = 0;
        for(int index = 0; index < S.length(); index++) {
            ArrayList<Pair> list = characterMap.get(S.charAt(index));
            characterMap.put(S.charAt(index), new ArrayList<>());
            for(Pair pair : list) {
                if(pair.index + 1 == pair.word.length()) numOfStudents += 1;
                else {
                    pair.index += 1;
                    characterMap.get(pair.word.charAt(pair.index)).add(pair);
                }
            }
        }

        return numOfStudents;
    }

    public static void main( String args[] ) {
        // Driver code

        String plagiarised = "abcde";
        String students[] = {"a","bb","acd","ace"};

        System.out.println("The content was copied from " + possibleMatches(plagiarised, students) + " students");

        plagiarised = "dsahjpjauf";
        students = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println("The content was copied from " + possibleMatches(plagiarised, students) + " students");
    }
}
