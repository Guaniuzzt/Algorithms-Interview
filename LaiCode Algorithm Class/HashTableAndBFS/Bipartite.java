import utils.GraphNode;

import java.util.*;


/*
* public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
Determine if an undirected graph is bipartite.
A bipartite graph is one in which the nodes can be divided into
two groups such that no nodes have direct edges
to other nodes in the same group.
 */

public class Bipartite {



    public boolean method(List<GraphNode> graph){

        if(graph.size() == 0)
            return true;

        Map<GraphNode, Integer > map = new HashMap<>();
        for(GraphNode node : graph){
            if(!help(node, map))
                return false;
        }

        return true;
    }


    public static boolean help(GraphNode node, Map<GraphNode, Integer> map){

        if(map.containsKey(node))  //why here containsKey return true
            return true;            // because we only need to consider iteration in the list(graph)
                                    // we dont have to consider neighbors list of every node
                                    // once one neighbor of new graphnode have conflits with exists
                                    // node in map(this map is global memory), we return false
                                    // if the iteration of list finish and no conflits find, that
                                    // means true
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.offerLast(node);
        map.put(node, 0);

        while(queue.size() != 0){
            GraphNode temp = queue.pollFirst();
            int curvalue = map.get(temp);
            int neighborvalue = curvalue == 0 ? 1 : 0;
            for(GraphNode nei : temp.neighbors){

                if(!map.containsKey(nei)){
                    map.put(nei, neighborvalue);
                    queue.offerLast(nei);
                }else{              // here is the only point we need to find false;
                    if(map.get(nei) != neighborvalue)
                        return false;
                }
            }
        }
        return true;

    }
}
