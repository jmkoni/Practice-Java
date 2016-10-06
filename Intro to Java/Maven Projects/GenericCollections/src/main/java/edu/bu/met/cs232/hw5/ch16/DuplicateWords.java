package edu.bu.met.cs232.hw5.ch16;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * DuplicateWords
 * 16.16
 * Created by jmkoni on 3/31/16.
 *
 * Write a program that determines and prints the number of duplicate words in a
 * sentence. Ignore case and punctuation.
 *
 * Wasn't clear what needed to be printed, so I created a function that would print
 * only the duplicate words (prettyPrintDups) and one that would print out all the
 * words with the number of times they occurred (prettyPrintWordNums).
 */
public class DuplicateWords {
  private HashMap<String, Integer> allWords;
  private LinkedList<String> duplicateWords = new LinkedList<String>();
  private String sentence;

  public DuplicateWords(String sentence){
    this.sentence = sentence;
    this.allWords = getNumWords();
    this.duplicateWords = determineDups();
  }

  public HashMap<String, Integer> getNumWords(){
    HashMap<String, Integer> duplicates = new HashMap<String, Integer>();
    String[] words = this.sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split
        ("\\s+");
    for (String word:words) {
      duplicates.put(word, duplicates.getOrDefault(word, 0) + 1);
    }
    return duplicates;
  }

  public LinkedList<String> determineDups(){
    LinkedList<String> dups = new LinkedList<String>();
    Iterator<Map.Entry<String, Integer>> iter = this.allWords.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      if (entry.getValue() > 1) {
        dups.add(entry.getKey());
      }
    }
    return dups;
  }

  public String prettyPrintWordNums(){
    String prettyWords = "";
    Iterator<Map.Entry<String, Integer>> iter = this.allWords.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Integer> entry = iter.next();
      prettyWords = String.format("%s\n\"%s\" occurs %d times.", prettyWords, entry
          .getKey(), entry.getValue());
    }
    return prettyWords;
  }

  public String prettyPrintDups(){
    String prettyDups = "Duplicated words: ";
    for (String word: this.duplicateWords) {
      prettyDups += " " + word + ",";
    }
    return prettyDups.substring(0,prettyDups.length() - 1);
  }
}
