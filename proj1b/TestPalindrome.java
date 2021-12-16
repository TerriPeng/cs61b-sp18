import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */

    @Test
    public void testIsPalindrome() {
        String a = "a";
        String b = "racecar";
        String c = "noon";
        String badA = "horse";
        String badB = "rancor";
        String badC = "aaaaab";
        assertTrue(palindrome.isPalindrome(a));
        assertTrue(palindrome.isPalindrome(b));
        assertTrue(palindrome.isPalindrome(c));
        assertFalse(palindrome.isPalindrome(badA));
        assertFalse(palindrome.isPalindrome(badB));
        assertFalse(palindrome.isPalindrome(badB));
    }

    @Test
    public void testIsPalindrome2() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }
}
