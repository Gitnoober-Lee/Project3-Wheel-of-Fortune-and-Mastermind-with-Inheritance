import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: WheelOfFortunePlayer_1
 * @Package: PACKAGE_NAME
 * @Author: Junpeng Li
 * @CreateTime: 10/26/23 8:00 PM
 */
public class WheelOfFortunePlayer1 implements WheelOfFortunePlayer {

    private List<Character> letterList;
    private int counter;

    public WheelOfFortunePlayer1() {
        // 26 letters of the alphabet in order of their frequency of usage in English
        String letters = "ETAOINSHRDLCUMWFGYPBVKJXQZ";
        letterList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            letterList.add(letters.charAt(i));
        }
        counter = letterList.size() - 1;
    }

    @Override
    public char nextGuess() {
        System.out.println(counter);
        Character guess = letterList.get(25 - (counter--));
        System.out.println("Guess letter: " + guess);
        return guess;
    }

    @Override
    public String playerId() {
        return RoleIte.AI_1;
    }

    @Override
    public void reset() {
        counter = letterList.size() - 1;
    }
}
