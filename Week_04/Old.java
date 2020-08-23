package homework;

import java.util.ArrayList;
import java.util.List;

public class Old {
    // DFS
    // 层次遍历
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, "", res);
        return res;
    }

    private void helper(int left, int right, int n, String cur, List<String> res) {
        if (left == n && right == n) {
            res.add(cur);
            return;
        }

        // drill down
        if (left < n) {
            helper(left + 1, right, n, cur + '(', res);
        }
        if (right < left) {
            helper(left, right + 1, n, cur + ')', res);
        }
    }


}
