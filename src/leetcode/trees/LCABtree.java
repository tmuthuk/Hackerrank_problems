package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class LCABtree {public Node lowestCommonAncestor(Node p, Node q) {
    // Store the path from p to root
    // Traverse from q and check if it matches with any of the node in the list of p
    List<Node> path = new ArrayList<>();

    while(p != null){
        path.add(p);
        p = p.parent;
    }

    while(q.parent != null) {
        for(Node node: path) {
            if (node == q) return q;
        }
        q = q.parent;
    }
    System.out.println("path " + path);
    return q;
}

}
