package dijkstra

fun main() {
    var graph = mutableMapOf<String, MutableMap<String, Int>>()
    graph["start"] = HashMap()
    graph["start"]!!["a"] = 6
    graph["start"]!!["b"] = 2
    graph["a"] = HashMap()
    graph["a"]!!["fin"] = 1
    graph["b"] = HashMap()
    graph["b"]!!["a"] = 3
    graph["b"]!!["fin"] = 5
    graph["fin"] = HashMap()

    val infinity = Int.MAX_VALUE

    var costs = mutableMapOf<String, Int>()
    costs["a"] = 6
    costs["b"] = 2
    costs["fin"] = infinity

    var parents = mutableMapOf<String, String?>()
    parents["a"] = "start"
    parents["b"] = "start"
    parents["fin"] = null

    var processed = mutableListOf<String>()

    dijkstra(graph, costs, parents, processed)

    parents.forEach { o -> println("${o.key} ${o.value}") }
}

fun dijkstra(
    graph: MutableMap<String, MutableMap<String, Int>>,
    costs: MutableMap<String, Int>,
    parents: MutableMap<String, String?>,
    processed: MutableList<String>
) {
    var node = findTheLowestCostNode(costs, processed)
    while (node != null) {
        val cost = costs[node]
        val neighbors = graph[node]
        for (n in neighbors!!.keys) {
            val newCost = cost?.plus(neighbors[n]!!)
            if (costs[n]!! > newCost!!) {
                costs[n] = newCost
                parents[n] = node
            }
        }
        processed.add(node)
        node = findTheLowestCostNode(costs, processed)
    }
}

fun findTheLowestCostNode(
    inputCosts: MutableMap<String, Int>,
    processed: MutableList<String>
): String? {
    var lowestCost = Int.MAX_VALUE
    var lowestCostNode: String? = null
    for (node in inputCosts.keys) {
        if (inputCosts[node]!! < lowestCost && !processed.contains(node)) {
            lowestCost = inputCosts[node]!!
            lowestCostNode = node
        }
    }
    return lowestCostNode
}