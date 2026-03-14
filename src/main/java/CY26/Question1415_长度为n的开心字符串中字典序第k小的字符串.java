package CY26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangLei
 * @version 2026/03/14 17:32
 */
public class Question1415_长度为n的开心字符串中字典序第k小的字符串 {
    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {
        dfs("", n);
        if (k > list.size()) {
            return "";
        }

        Collections.sort(list);
        return list.get(k - 1);
    }

    private void dfs(String str, int n) {
        if (str.length() == n) {
            list.add(str);
            return;
        }

        if (str.isEmpty()) {
            dfs(str + "a", n);
            dfs(str + "b", n);
            dfs(str + "c", n);
            return;
        }
        char c = str.charAt(str.length() - 1);
        if (c == 'a') {
            dfs(str + "b", n);
            dfs(str + "c", n);
        } else if (c == 'b') {
            dfs(str + "a", n);
            dfs(str + "c", n);
        } else {
            dfs(str + "a", n);
            dfs(str + "b", n);
        }
    }
}
