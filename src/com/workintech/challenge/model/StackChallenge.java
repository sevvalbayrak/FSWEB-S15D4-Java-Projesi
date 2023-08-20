package com.workintech.challenge.model;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;

public class StackChallenge {

    public static boolean isPalindrome(String text) {
        text = text.toLowerCase(Locale.ENGLISH);
        text = text.replace(".", "")
                .replace(",", "")
                .replace("?", "")
                .replace("!", "")
                .replace("_", "")
                .replace("-", "")
                .replace(" ", "");

        Stack<Character> stack = new Stack<>();
        StringBuilder reversedText = new StringBuilder();

        for (int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            stack.add(c);
            reversedText.append(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        //System.out.println(reversed);
        return reversedText.toString().equals(reversed.toString());
    }


    public static boolean isPalindrome2(String text){
        text = text.toLowerCase(Locale.ENGLISH);
        text = text.replace(".", "")
                .replace(",", "")
                .replace("?", "")
                .replace("!", "")
                .replace("_", "")
                .replace("-", "")
                .replace(" ", "");

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            stack.push(c);
            queue.add(c);
        }
        while (!stack.isEmpty() && !queue.isEmpty()){
            if (stack.pop() != queue.remove()) {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String[] texts = {"I did, did I?", "Racecar", "hello", "Was it a car or a cat I saw ?"};


        for (String text : texts) {
            if (isPalindrome(text)) {
                System.out.println(text + " => palindrom");
            } else {
                System.out.println(text + " => palindrom değil");
            }
        }

    }
}
