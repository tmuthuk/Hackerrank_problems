package interviews;

/**
 *
 */
/*
Snorkel
A regular map has the following interface methods:

- get(k) -> v or KeyError
- put(k, v)
- delete(k)

We wish to augment this with two more methods:

- take_snapshot() -> snap_id
- get(k, snap_id) -> v or KeyError


take_snapshot captures the logical state of the map as of that point which can later be accessed via snap_id
get(.., snap_id) allows us to refer to the value of a key as of a historical snap_id.

As an example:
// Starting with an empty map
put("a", 1)
put("b", 2)
take_snapshot() -> 1
put("a", 5)
delete("b")
put("a", 10)
take_snapshot() -> 2
put("b", 20)
take_snapshot() -> 3
put("a", 100)

get("a") -> 100
get("a", 1) -> 1
get("a", 2) -> 10
get("a", 3) -> 10

get("b") -> 20
get("b", 1) -> 2
get("b", 2) -> KeyError
get("b", 3) -> 20

Implement this data structure with following hard constraints:
- Values should not be duplicated
- All operations should be sub-linear in the size of the map (number of keys)

put("a", 5)
put("b", 10)
take_snapshot() -> {"a": 5, "b": 10} -> snapshot_1
put("b", 15)
take_snapshot() -> {"b": 15} -> snapshot_2
put("b", 16)
put("a", 6)
take_snapshot() -> {"a": 6, "b": 16} -> snapshot_3
get("a") : ??

get("a", 2)

As a reference point for performance, imagine the map will have ~1 million keys, with ~100 snapshots, and 1% of the keys change in every snapshot.
 */


import java.util.HashMap;

/**

 Snapshot 1:

 HashMap<Integer, HashMap<>>

 HashMap<a => 5>

 take snapshot

 Snapshot 2:

 c => 15

 ** what happens if multiple snapshots in a row without a key change
 ** mechanically, how do I get a value that's not in the "latest" snapshot?

 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class ModifiedMap {
    public static void main(String[] args) {
        ModifiedMap map = new ModifiedMap();

        map.put("a", 1);
        map.put("b", 2);
        System.out.println(map.takeSnapshot());
        map.put("a", 5);

        map.put("a", 10);
        System.out.println(map.takeSnapshot());
        map.put("b", 20);
        System.out.println(map.takeSnapshot());
        map.put("a", 100);
        System.out.println(map.get("a"));
        System.out.println(map.get("a", 1));
        System.out.println(map.get("a", 2));
        System.out.println(map.get("a", 3));

        System.out.println(map.get("a", 4));

        //   map.get("b") -> 20
        //   map.get("b", 1) -> 2
        //   map.get("b", 2) -> KeyError
        // get("b", 3) -> 20
        //     map
    }

    HashMap<Integer, HashMap<String, Integer>> snapshots = new HashMap<>();
    HashMap<String, Integer> currentSnapshotMap = new HashMap<>();
    int currentSnapshot = 1;

    public void put(String key, int value) {
        currentSnapshotMap.put(key, value);
    }

    public  int get(String key) {
        return currentSnapshotMap.getOrDefault(key, -1);
    }

    public int get(String key, int snapshot) {
        if(snapshot == currentSnapshot) {
            return currentSnapshotMap.getOrDefault(key, -1);
        }

        for(int index = snapshot; index > 0; index--) {
            HashMap<String, Integer> curMap = snapshots.get(index);
            if(curMap.containsKey(key)) {
                return curMap.get(key);
            }
        }
        return -1;
    }

    public HashMap<String, Integer> takeSnapshot() {
        snapshots.put(currentSnapshot, currentSnapshotMap);
        currentSnapshot++;
        currentSnapshotMap = new HashMap<>();
        return snapshots.get(currentSnapshot - 1);
    }
}
