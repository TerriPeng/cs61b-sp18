public class Palindrome {

    /** Turns a string into a Deque of chars */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> stringDeque = new LinkedListDeque();
        for (int i = 0; i < word.length(); i += 1) {
            stringDeque.addLast(word.charAt(i));
        }
        return stringDeque;
    }

    /** Check if given word is a palindrome */
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        boolean result = isPalindromeHelper(wordDeque);
        return result;
    }

    private boolean isPalindromeHelper(Deque<Character> word) {
        if (word.size() <= 1) {
            return true;
        }
        if (word.removeFirst() == word.removeLast()) {
            return isPalindromeHelper(word);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque = wordToDeque(word);
        boolean result = isPalindromeHelper(wordDeque, cc);
        return result;
    }

    private boolean isPalindromeHelper(Deque<Character> word, CharacterComparator cc) {
        if (word.size() <= 1) {
            return true;
        }
        if (cc.equalChars(word.removeFirst(), word.removeLast())) {
            return isPalindromeHelper(word, cc);
        }
        return false;
    }

}
