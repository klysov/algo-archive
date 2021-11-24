package dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {
        var graph = new HashMap<String, HashMap<String, Integer>>();
        graph.put("start", new HashMap<>());
        graph.get("start").put("a", 6);
        graph.get("start").put("b", 2);
        graph.put("a", new HashMap<>());
        graph.get("a").put("fin", 1);
        graph.put("b", new HashMap<>());
        graph.get("b").put("a", 3);
        graph.get("b").put("fin", 5);
        graph.put("fin", new HashMap<>());

        var infinity = Integer.MAX_VALUE;

        var costs = new HashMap<String, Integer>();
        costs.put("a", 6);
        costs.put("b", 2);
        costs.put("fin", infinity);

        var parents = new HashMap<String, String>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        var processed = new ArrayList<String>();

        dijkstra(graph, costs, parents, processed);

        parents.forEach((o1, o2) -> System.out.println(o1 + " " + o2));
    }

    private static void dijkstra(Map<String, ? extends Map<String, Integer>> graph,
                                 Map<String, Integer> costs,
                                 Map<String, String> parents,
                                 List<String> processed) {
        var node = findTheLowestCostNode(costs, processed);
        while (node != null) {
            var cost = costs.get(node);
            var neighbors = graph.get(node);
            for (var n : neighbors.keySet()) {
                var newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            processed.add(node);
            node = findTheLowestCostNode(costs, processed);
        }
    }

    private static String findTheLowestCostNode(Map<String, Integer> inputCosts,
                                                List<String> processed) {
        var lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;
        for (var node : inputCosts.keySet()) {
            if (inputCosts.get(node) < lowestCost && !processed.contains(node)) {
                lowestCost = inputCosts.get(node);
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
