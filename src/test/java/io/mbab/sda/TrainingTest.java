package io.mbab.sda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TrainingTest {

    private Training training;

    @BeforeEach
    void setUp() {
        training = new Training();
    }

    @Test
    public void testJoin() {
        assertEquals("12345678", training.join(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), ""));
        assertEquals("To nie jest kraj dla starych ludzi", training.join(Arrays.asList("To", "nie", "jest", "kraj", "dla", "starych ludzi"), " "));
        assertEquals("To_nie_jest_kraj_dla_starych_ludzi", training.join(Arrays.asList("To", "nie", "jest", "kraj", "dla", "starych ludzi"), "_"));
    }

    @Test
    public void testSumPositive() {
        assertEquals(15, training.sumPositive(new int[]{1,2,3,4,5}));
        assertEquals(13, training.sumPositive(new int[]{1,-2,3,4,5}));
        assertEquals(0, training.sumPositive(new int[]{}));
        assertEquals(0, training.sumPositive(new int[]{-1,-2,-3,-4,-5}));
        assertEquals(9, training.sumPositive(new int[]{-1,2,3,4,-5}));
    }

    @Test
    public void testRemoveWhiteSpace() {
        assertEquals("8j8mBliB8gimjB8B8jlB", training.removeWhiteSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", training.removeWhiteSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr", training.removeWhiteSpace("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8", training.removeWhiteSpace("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam", training.removeWhiteSpace("8j aam"));
    }

    @Test
    public void testCountPositiveSumNegative() {
        assertArrayEquals(new int[] {10, -65}, training.countPositivesSumNegatives(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
        assertArrayEquals(new int[] {8, -50}, training.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
        assertArrayEquals(new int[] {}, training.countPositivesSumNegatives(new int[] {}));
        assertArrayEquals(new int[] {}, training.countPositivesSumNegatives(null));
    }

    @Test
    public void testConvertNumberToReverseArray() {
        assertEquals(new int[] {5, 4, 7, 4, 5, 6, 9, 8, 5, 2, 1 }, training.convertNumberToReverseArray(12589654745L));
        assertEquals(new int[] {0}, training.convertNumberToReverseArray(0));
        assertEquals(new int[] {6, 5, 4, 3, 2, 1, 1}, training.convertNumberToReverseArray(1123456));
    }

    @Test
    public void testGenerateInitials() {
        assertEquals("F.K", training.generateInitials("Ferdynad Kiepski"));
        assertEquals("M.P", training.generateInitials("marian paździoch"));
    }

    @Test
    public void testFindCommons() {
        assertEquals(new int[] {3}, training.findCommons(new int[] {1, 4, 6, 8, 3}, new int[] {0, 5, 3, 7, 2, 9}));
        assertEquals(new int[] {2, 9}, training.findCommons(new int[] {10, 2, 5, 7, 9}, new int[] {2, 9, 1}));
    }

    @Test
    public void testIsPalindrom(String test) {
        assertTrue(training.isPalindrom("Kobyła ma mały bok"));
        assertTrue(training.isPalindrom("A to kanapa pana Kota"));
        assertFalse(training.isPalindrom("To nie jest palindrom"));
    }

    @Test
    public void testIsAnagram(String test) {
        assertTrue(training.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
        assertTrue(training.isAnagram("beztalenciem", "mecz nie balet"));
    }

    @Test
    public void testRemoveDuplicates() {
        assertIterableEquals(Arrays.asList("jeden", "dwa", "trzy", "pięć", "jedenaście"),
                training.removeDuplicates(Arrays.asList("jeden", "dwa", "trzy", "dwa", "pięć", "jedenaście")));
        assertIterableEquals(Arrays.asList(1, 2, 3, 5, 11),
                training.removeDuplicates(Arrays.asList(1, 2, 3, 5, 2, 11)));
    }

    @Test
    public void testIsPangram() {
        assertTrue(training.isPangram("The quick brown fox jumps over the lazy dog"));
        assertTrue(training.isPangram("Pack my box with five dozen liquor jugs"));
        assertFalse(training.isPangram("This is not a pangram"));
    }

    @Test
    public void testIsFlatten() {
        assertIterableEquals(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                training.flatten(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6))));
    }
}
