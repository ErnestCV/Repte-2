import java.util.Arrays;
import java.util.stream.IntStream;

public class MyLambda {
    public void checker(int[] nums) {
        Arrays.stream(nums).forEach(num -> {
            if (num == 0) {
                System.out.println("NOT A POSSIBLE OPTION");
            } else {
                System.out.println("input:" + num);
                System.out.println("isOdd:" + isOdd(num));
                System.out.println("isPrime:" + isPrime(num));
                System.out.println("isPalindrome:" + isPalindrome(num) + "\n");
            }
        });
    }

    private boolean isOdd(int num) {
        return num > 0 && num % 2 == 0;
    }

    private boolean isPrime(int num) {
        return num > 0 && IntStream.rangeClosed(2, num / 2).noneMatch(i -> num % i == 0);
    }

    private boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        return num > 0 && IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
    }
}
