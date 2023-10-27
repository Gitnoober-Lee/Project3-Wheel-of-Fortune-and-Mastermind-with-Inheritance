import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: WheelOfFortuneAIGame
 * @Package: PACKAGE_NAME
 * @Author: Junpeng Li
 * @CreateTime: 10/24/23 10:20 PM
 */
public class WheelOfFortuneAIGame extends WheelOfFortune {

    private WheelOfFortunePlayer player;
    private List<WheelOfFortunePlayer> playerList;

    public WheelOfFortuneAIGame() {
        this.isAI = true;
        this.player = new WheelOfFortunePlayer0();
    }

    public WheelOfFortuneAIGame(WheelOfFortunePlayer player) {
        this.isAI = true;
        this.player = player;
    }

    public WheelOfFortuneAIGame(List<WheelOfFortunePlayer> playerList) {
        this.isAI = true;
        this.playerList = playerList;
    }

    public static void main(String[] args) {
        // WheelOfFortuneAIGame wof = new WheelOfFortuneAIGame();
        // AllGameRecords records = wof.playAll();
        // System.out.println(records);

        // WheelOfFortuneAIGame wof = new WheelOfFortuneAIGame(new WheelOfFortunePlayer1());
        // AllGameRecords records = wof.playAll();
        // System.out.println(records);

        List<WheelOfFortunePlayer> playerList = new ArrayList<>();
        WheelOfFortunePlayer0 p0 = new WheelOfFortunePlayer0();
        // WheelOfFortunePlayer1 p1 = new WheelOfFortunePlayer1();
        // WheelOfFortunePlayer2 p2 = new WheelOfFortunePlayer2();
        playerList.add(p0);
        // playerList.add(p1);
        // playerList.add(p2);
        WheelOfFortuneAIGame wof = new WheelOfFortuneAIGame(playerList);
        for (WheelOfFortunePlayer p : playerList) {
            wof.setUserName(p.playerId());
            wof.player = p;
            AllGameRecords records = wof.playAll();
            System.out.println(records);
            p.reset();
        }
    }

    @Override
    protected void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    char getGuess(String previousGuesses) {
        return player.nextGuess();
    }

    @Override
    WheelOfFortunePlayer getPlayer() {
        return player;
    }

}