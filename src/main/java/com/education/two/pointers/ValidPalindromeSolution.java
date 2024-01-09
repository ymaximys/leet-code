package com.education.two.pointers;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindromeSolution {
    public boolean isPalindrome(String s) {
        List<Character> alphabeticInput = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                alphabeticInput.add(Character.toLowerCase(c));
            }
        }

        for (int i = 0, j = alphabeticInput.size() - 1; i < alphabeticInput.size() / 2; i++, j--) {
            if (i >= j) {
                return true;
            }

            char start = alphabeticInput.get(i);
            char tail = alphabeticInput.get(j);
            if (start != tail) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeSolution validPalindromeSolution = new ValidPalindromeSolution();
        boolean result = validPalindromeSolution.isPalindrome("a");
        System.out.println(result);
    }
}