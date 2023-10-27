import java.util.Scanner;

/**
 * @Description:
 * @ClassName: WheelOfFortuneUserGame
 * @Package: PACKAGE_NAME
 * @Author: Junpeng Li
 * @CreateTime: 10/24/23 8:57 PM
 */
public class WheelOfFortuneUserGame extends WheelOfFortune {

    public WheelOfFortuneUserGame() {
        isAI = false;
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        WheelOfFortuneUserGame userGame = new WheelOfFortuneUserGame();
        userGame.setUserName(RoleIte.HUMAN);
        AllGameRecords records = userGame.playAll();
        System.out.println("highGameList: " + records.highGameList(1));
        System.out.println("average: " + records.average());
    }

    @Override
    protected void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    char getGuess(String previousGuesses) {
        System.out.println("Please take a guess: ");
        return sc.next().toCharArray()[0];
    }

    @Override
    WheelOfFortunePlayer getPlayer() {
        return null;
    }
}
