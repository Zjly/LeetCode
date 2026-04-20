package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/20 23:48
 */
public class Question2078_两栋颜色不同且距离最远的房子 {
    public int maxDistance(int[] colors) {
        int dis = 1;
        int indexLeft = 0;
        while (indexLeft < colors.length) {
            if (colors[indexLeft] != colors[colors.length - 1]) {
                dis = Math.max(dis, colors.length - indexLeft - 1);
                break;
            }
            indexLeft++;
        }

        int indexRight = colors.length - 1;
        while (indexRight >= 0) {
            if (colors[indexRight] != colors[0]) {
                dis = Math.max(dis, indexRight);
                break;
            }
            indexRight--;
        }

        return dis;
    }
}
