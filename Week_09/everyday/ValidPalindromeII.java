package Week_09.everyday;

/**
 *
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int left = 0, right = chs.length - 1;
        for (; left < right && chs[left] == chs[right]; left++, right--) ;
        return left >= right ? true : (validPalindrome(chs, left + 1, right) || validPalindrome(chs, left, right - 1));
    }

    private boolean validPalindrome(char[] s, int start, int end) {
        for (;start<end && s[start]==s[end];start++,end--);
        return start>=end;
    }
}
