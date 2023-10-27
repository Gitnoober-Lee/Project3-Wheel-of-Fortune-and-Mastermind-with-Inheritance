/**
 * @Description:
 * @ClassName: Game
 * @Package: PACKAGE_NAME
 * @Author: Junpeng Li
 * @CreateTime: 10/24/23 7:56 PM
 */
public abstract class Game {

    abstract AllGameRecords playAll();

    abstract GameRecord play();

    abstract boolean playNext();
}
