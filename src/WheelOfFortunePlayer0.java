import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @ClassName: WheelOfFortunePlayer0
 * @Package: PACKAGE_NAME
 * @Author: Junpeng Li
 * @CreateTime: 10/26/23 8:00 PM
 */
public class WheelOfFortunePlayer0 implements WheelOfFortunePlayer {

    private List<Character> letterList;
    private int counter;

    public WheelOfFortunePlayer0() {
        letterList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            letterList.add((char) ('A' + i));
        }
        Collections.shuffle(letterList);
        counter = letterList.size() - 1;
    }

    @Override
    public char nextGuess() {
        System.out.println(counter);
        return letterList.get(counter--);
    }

    @Override
    public String playerId() {
        return RoleIte.AI_0;
    }

    @Override
    public void reset() {
        counter = letterList.size() - 1;
    }
}
