package bitwise;

public final class PlayingAround {

    public static int bitwiseAnd(int left, int right) {
        return left & right;
    }

    public static int bitwiseOr(int left, int right) {
        return left | right;
    }

    public static int bitwiseXor(int left, int right) {
        return left ^ right;
    }

    public static int bitwiseNegation(int left) {
        return ~left;
    }

    public static int bitwiseLeftShift(int left, int shift) {
        return left << shift;
    }

    public static int bitwiseRightShift(int left, int shift) {
        return left >> shift;
    }

    public static int bitwiseRightShiftZeroFill(int left, int shift) {
        return left >>> shift;
    }
}
