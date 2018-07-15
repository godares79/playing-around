package bitwise;

import org.junit.jupiter.api.Test;

class PlayingAroundTest {
    @Test
    void bitwiseAndTest() {
        System.out.println(PlayingAround.bitwiseAnd(13, 10));
    }

    @Test
    void bitwiseOrTest() {
        System.out.println(PlayingAround.bitwiseOr(13, 10));
    }

    @Test
    void bitwiseXorTest() {
        System.out.println(PlayingAround.bitwiseXor(13, 10));
    }

    @Test
    void bitwiseNegationTest() {
        System.out.println(PlayingAround.bitwiseNegation(13));
    }

    @Test
    void bitwiseLeftShiftTest() {
        System.out.println(PlayingAround.bitwiseLeftShift(13, 2));
    }

    @Test
    void bitwiseRightShiftTest() {
        System.out.println(PlayingAround.bitwiseRightShift(13, 2));
        System.out.println("12 in binary: " + Integer.toBinaryString(12));
        System.out.println("-13 in binary: " + Integer.toBinaryString(-13));
        System.out.println(PlayingAround.bitwiseRightShift(-13, 2));
    }

    @Test
    void bitwiseRightShiftZeroFillTest() {
        System.out.println(PlayingAround.bitwiseRightShiftZeroFill(13, 2));
        System.out.println(PlayingAround.bitwiseRightShiftZeroFill(-13, 2));
    }
}
