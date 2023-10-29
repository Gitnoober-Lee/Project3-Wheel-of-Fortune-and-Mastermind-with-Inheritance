import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @Title: AllGameRecords
 * @Package PACKAGE_NAME
 * @Author: lijunpeng
 * @CreateTime: 10/24/23 6:47 PM
 */
public class AllGameRecords {

    private Map<String, List<GameRecord>> recordMap;

    public AllGameRecords() {
        recordMap = new HashMap<>();
    }

    public void add(GameRecord gr) {
        String id = gr.getId();
        if (recordMap.containsKey(id)) {
            recordMap.get(id).add(gr);
        } else {
            List<GameRecord> list = new ArrayList<>();
            list.add(gr);
            recordMap.put(id, list);
        }
    }

    public int average() {
        Set<String> set = recordMap.keySet();
        int sum = 0;
        int count = 0;
        for (String id : set) {
            List<GameRecord> list = recordMap.get(id);
            for (GameRecord gr : list) {
                sum += gr.getGrade();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return sum / count;
    }

    public int average(String playerId) {
        if (recordMap.get(playerId) != null) {
            List<GameRecord> list = recordMap.get(playerId);
            int sum = 0;
            int count = 0;
            for (GameRecord gr : list) {
                sum += gr.getGrade();
                count++;
            }
            return sum / count;
        }
        return -1;
    }

    public List<GameRecord> highGameList(int n) {
        Set<Map.Entry<String, List<GameRecord>>> entrySet = recordMap.entrySet();
        Iterator<Map.Entry<String, List<GameRecord>>> iterator = entrySet.iterator();
        List<GameRecord> allRecordsList = new ArrayList<>();
        while (iterator.hasNext()) {
            List<GameRecord> gameRecordList = iterator.next().getValue();
            allRecordsList.addAll(gameRecordList);
        }
        Collections.sort(allRecordsList);
        List<GameRecord> l = new ArrayList<>();
        for (int i = 0; i < n && i < allRecordsList.size(); i++) {
            l.add(allRecordsList.get(i));
        }
        return l;
    }

    public List<Integer> highGameList(String playerId, int n) {
        List<GameRecord> grList = recordMap.get(playerId);
        if (grList != null) {
            Collections.sort(grList);
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n && i < grList.size(); i++) {
                l.add(grList.get(i).getGrade());
            }
            return l;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "AllGameRecords{" +
                "recordMap=" + recordMap +
                '}';
    }
}
