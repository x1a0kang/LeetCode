public class IsPalindromeNum {
    public static void main(String[] args) {
        System.out.println(new IsPalindromeNum().isPalindrome(121));
    }

    // 总体思想是把x反转，更有效率的方法是只反转到一半，比较前一半和后一半是否相等
    public boolean isPalindrome(int x) {
        // base case：负数一定不是回文数，正数中以零结尾的数也一定不是回文数
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int revers = 0;
        int temp = 0;
        // reverse是反转后的数，当x小于等于reverse时，说明已经反转了一半
        while (x > revers) {
            temp = x % 10;
            x /= 10;
            revers = revers * 10 + temp;
        }
        // 如果x长度为奇数，如121，当x小于reverse时，reverse会多出一位，所以要再除以10
        return x == revers || x == revers / 10;
    }

    public boolean isPalindrome2(int x) {
        // base case：负数一定不是回文数，正数中以零结尾的数也一定不是回文数
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }
        int revers = 0;
        int temp = 0;
        // 和上一个方法相比，把对奇数的处理放在循环里，这样比上一个方法少循环一次
        while (x / 10 > revers) {
            temp = x % 10;
            x /= 10;
            revers = revers * 10 + temp;
        }
        // 如果x长度为奇数，这里x会多出一位，所以要再除以10
        return x == revers || x / 10 == revers;
    }
}
