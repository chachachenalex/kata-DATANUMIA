import org.junit.jupiter.api.Test;
import yatzy.DiceRoll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static yatzy.Category.*;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        assertEquals(15, Chance.score(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(16, Chance.score(new DiceRoll(3, 3, 4, 5, 1)));
    }

    @Test
    public void yatzy_socres_50() {
        assertEquals(50, Yatzy.score(new DiceRoll(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.score(new DiceRoll(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.score(new DiceRoll(6, 6, 6, 6, 3)));
    }

    @Test
    public void test_1s() {
        assertEquals(1, Ones.score(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(2, Ones.score(new DiceRoll(1, 2, 1, 4, 5)));
        assertEquals(0, Ones.score(new DiceRoll(6, 2, 2, 4, 5)));
        assertEquals(4, Ones.score(new DiceRoll(1, 2, 1, 1, 1)));
    }

    @Test
    public void test_2s() {
        assertEquals(4, Twos.score(new DiceRoll(1, 2, 3, 2, 6)));
        assertEquals(10,Twos.score(new DiceRoll(2, 2, 2, 2, 2)));
    }

    @Test
    public void test_3s() {
        assertEquals(6, Threes.score(new DiceRoll(1, 2, 3, 2, 3)));
        assertEquals(12, Threes.score(new DiceRoll(2, 3, 3, 3, 3)));
    }

    @Test
    public void test_4s() {
        assertEquals(12, Fours.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(8, Fours.score(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(4, Fours.score(new DiceRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void test_5s() {
        assertEquals(10, Fives.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(15, Fives.score(new DiceRoll(4, 4, 5, 5, 5)));
        assertEquals(20, Fives.score(new DiceRoll(4, 5, 5, 5, 5)));
    }

    @Test
    public void test_6s() {
        assertEquals(0, Sixes.score(new DiceRoll(4, 4, 4, 5, 5)));
        assertEquals(6, Sixes.score(new DiceRoll(4, 4, 6, 5, 5)));
        assertEquals(18, Sixes.score(new DiceRoll(6, 5, 6, 6, 5)));
    }

    @Test
    public void one_pair() {
        assertEquals(6, Pair.score(new DiceRoll(3, 4, 3, 5, 6)));
        assertEquals(10, Pair.score(new DiceRoll(5, 3, 3, 3, 5)));
        assertEquals(12, Pair.score(new DiceRoll(5, 3, 6, 6, 5)));
    }

    @Test
    public void two_pair() {
        assertEquals(16, TwoPairs.score(new DiceRoll(3, 3, 5, 4, 5)));
        assertEquals(16, TwoPairs.score(new DiceRoll(3, 3, 5, 5, 5)));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 4, 5)));
        assertEquals(15, ThreeOfAKind.score(new DiceRoll(5, 3, 5, 4, 5)));
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(9, ThreeOfAKind.score(new DiceRoll(3, 3, 3, 3, 3)));
    }

    @Test
    public void four_of_a_kind() {
        assertEquals(12, FourOfAKind.score(new DiceRoll(3, 3, 3, 3, 5)));
        assertEquals(20, FourOfAKind.score(new DiceRoll(5, 5, 5, 4, 5)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, SmallStraight.score(new DiceRoll(1, 2, 3, 4, 5)));
        assertEquals(15, SmallStraight.score(new DiceRoll(2, 3, 4, 5, 1)));
        assertEquals(0, SmallStraight.score(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, LargeStraight.score(new DiceRoll(6, 2, 3, 4, 5)));
        assertEquals(20, LargeStraight.score(new DiceRoll(2, 3, 4, 5, 6)));
        assertEquals(0, LargeStraight.score(new DiceRoll(1, 2, 2, 4, 5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, FullHouse.score(new DiceRoll(6, 2, 2, 2, 6)));
        assertEquals(0, FullHouse.score(new DiceRoll(2, 3, 4, 5, 6)));
    }
}