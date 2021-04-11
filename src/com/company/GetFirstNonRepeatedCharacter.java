package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/** Program to get the first non repeated character
 * i/P : a green apple
 * o/p : g */
public class GetFirstNonRepeatedCharacter {

    public static void main(String[] args) {

        System.out.println("Non Repeated Character is  : " + getFirstNonRepeatedCharacter("A GREEN APPLE"));

    }

    private static char getFirstNonRepeatedCharacter(String sentence) {

        /*I used LinkedHashMap so that it can maintain the order of insertion */
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();

        for (char character : sentence.toLowerCase().toCharArray()) {
            if (character != ' ') {
                if (characterIntegerMap.get(character) == null) {
                    characterIntegerMap.put(character, 1);
                } else {
                    characterIntegerMap.put(character, characterIntegerMap.get(character) + 1);
                }

            }
        }

        /*You can also you for loop and iterate over character map and get the first element that have value ==1 */
        Optional<Map.Entry<Character, Integer>> chars = characterIntegerMap.entrySet().stream().filter(intValue -> intValue.getValue() == 1).findFirst();

        return chars.isPresent() ? chars.get().getKey() : Character.MIN_VALUE;
    }
}
