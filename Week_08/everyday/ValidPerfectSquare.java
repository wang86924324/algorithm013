package Week_08.everyday;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return i==0;
    }
}
