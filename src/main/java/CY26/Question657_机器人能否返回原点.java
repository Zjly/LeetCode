package CY26;

/**
 * @author ZhangLei
 * @version 2026/04/05 23:39
 */
public class Question657_机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int UD = 0;
        int LR = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                UD++;
            } else if (c == 'D') {
                UD--;
            } else if (c == 'L') {
                LR++;
            } else if (c == 'R') {
                LR--;
            }
        }

        return UD == 0 && LR == 0;
    }
}
