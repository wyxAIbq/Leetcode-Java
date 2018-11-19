import java.util.*;

public class Main {

    public String nextClosestTime(String time) {
        int[] number = new int[4];

        time = time.substring(0, 2) + time.substring(3);

        for (int i = 0; i < time.length(); i++) {
            number[i] = time.charAt(i) - '0';
        }

        Arrays.sort(number);

        StringBuilder sb = new StringBuilder(time);

        int i;
        for (i = 3; i >= 0; i--) {
            char c = time.charAt(i);
            int k = nextNumber(number, c - '0');
            if (k >= 0) {
                sb.setCharAt(i, (char) (k + '0'));
                if (isValid(sb)) {
                    break;
                }
                sb.setCharAt(i, c);
            }
        }
        for (i++; i < 4; i++) {
            sb.setCharAt(i, (char) (number[0] + '0'));
        }
        sb.insert(2, ':');
        return sb.toString();
    }

    private boolean isValid(StringBuilder sb) {
        boolean flag1 = sb.charAt(0) < '2' || (sb.charAt(0) == '2' && sb.charAt(1) <= '3');
        boolean flag2 = sb.charAt(2) < '5' || (sb.charAt(2) == '5' && sb.charAt(3) <= '9');
        return flag1 && flag2;
    }

    private int nextNumber(int[] number, int n) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > n) {
                return number[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = new NextClosestTime().nextClosestTime("13:55");
        System.out.println(s);
    }
}
