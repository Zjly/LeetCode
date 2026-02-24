package CY26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ZhangLei
 * @version 2026/02/25 00:23
 */
public class Question1356_根据数字二进制下1的数目排序 {
    public int[] sortByBits(int[] arr) {
        List<List<Integer>> numCountList = new ArrayList<>(15);
        for (int i = 0; i < 15; i++) {
            numCountList.add(new ArrayList<>());
        }
        for (int i : arr) {
            int count = count(i);
            numCountList.get(count).add(i);
        }

        int[] result = new int[arr.length];
        int index = 0;
        for (List<Integer> integerList : numCountList) {
            if (integerList.size() == 0) {
                continue;
            }

            Collections.sort(integerList);
            for (Integer i : integerList) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }

    private int count(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }

        return count;
    }
}
