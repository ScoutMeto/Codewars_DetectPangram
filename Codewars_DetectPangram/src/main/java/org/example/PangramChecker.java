package org.example;


import java.util.Set;
import java.util.stream.Collectors;

public class PangramChecker {
    public boolean check(String sentence){

        String comparativePattern = "abcdefghijklmnopqrstuvwxyz";

        String processedSentence = sentence.trim().toLowerCase();

        // Sentence to a set of chars.
        Set<Character> sentenceSet = processedSentence.chars()
                .filter(Character::isLetter) // Ignore numbers and punctuation
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        // Contains "sentence" all characters of the "comparativePattern"?
        boolean containsAll = comparativePattern.chars()
                .mapToObj(c -> (char) c)
                .allMatch(sentenceSet::contains);

        return containsAll;
    }
}


/*
TESTING

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class PangramTest {
    @Test
    public void test1() {
      String pangram1 = "The quick brown fox jumps over the lazy dog.";
      PangramChecker pc = new PangramChecker();
      assertEquals(true, pc.check(pangram1));
    }
    @Test
    public void test2() {
      String pangram2 = "You shall not pass!";
      PangramChecker pc = new PangramChecker();
      assertEquals(false, pc.check(pangram2));
    }
}
 */
