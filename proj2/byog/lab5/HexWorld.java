package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
/** Thought process: create a function that returns whether a letter
 * or a space should fill in the given coordinate.*/
    private static int computeWidth(int length) {
        return length * 2 + (length - 2);
    }

    private static int offsetNum(int length, int rowNum) {
        int width = computeWidth(length);
        if (rowNum >= length) {
            rowNum = rowNum - (2 * (rowNum - length) + 1);
        }
        return (width - length - (2 * rowNum)) / 2;
    }

    private static boolean letterOrNot(int length, int row, int col) {
        int width = computeWidth(length);
        int offset = offsetNum(length, row);
        return col > (offset - 1) && col < (width - offset);
    }

    public static void addHexagon(TETile[][] world, int length, TETile t) {

    }

    @Test
    public void testOffsetNum() {
        assertEquals(2, offsetNum(3, 0));
        assertEquals(1, offsetNum(3, 1));
        assertEquals(0, offsetNum(3, 2));
        assertEquals(0, offsetNum(3, 3));
        assertEquals(1, offsetNum(3, 4));
        assertEquals(2, offsetNum(3, 5));
        assertEquals(1, offsetNum(2, 0));
        assertEquals(0, offsetNum(2, 2));
    }

    @Test
    public void testLetterOrNot() {
        assertFalse(letterOrNot(2, 0, 0));
        assertTrue(letterOrNot(2, 0, 1));
        assertTrue(letterOrNot(2, 0, 2));
        assertFalse(letterOrNot(2, 0, 3));
        assertTrue(letterOrNot(3, 1, 1));
        assertFalse(letterOrNot(4, 1, 0));
    }
}
