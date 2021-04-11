package com.company;

import java.util.HashSet;
import java.util.Set;

/** Program to get the first repeated character
 * i/P : a green apple
 * o/p : a */
public class FindFirstRepeatedCharacter {
    public static void main(String[] args) {
        System.out.println(getFirstRepeatedCharacter("a green apple"));
    }
    private static char getFirstRepeatedCharacter(String sentence){

        Set<Character> characterSet= new HashSet<>();

        var firstRepeatedCharacter = sentence.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                //We are just checking the duplicates using add() method which returns the boolean value
                .filter(character -> character != ' ' && !characterSet.add(character))
                .findFirst();

        return firstRepeatedCharacter.orElse(Character.MIN_VALUE);
    }
}
