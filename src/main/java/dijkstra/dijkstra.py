graph = {"start": {}}
graph["start"]["a"] = 6
graph["start"]["b"] = 2
print(graph.keys())
print(graph.values())

graph["a"] = {}
graph["a"]["fin"] = 1
graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["fin"] = 5
graph["fin"] = {}

infinity = float("inf")
costs = {"a": 6, "b": 2, "fin": infinity}

parents = {"a": "start", "b": "start", "fin": None}

processed = []


def find_the_lowest_cost_node(input_costs):
    lowest_cost = float("inf")
    lowest_cost_node = None
    for nod in input_costs.keys():
        cst = input_costs[nod]
        if cst < lowest_cost and nod not in processed:
            lowest_cost = cst
            lowest_cost_node = nod
    return lowest_cost_node


node = find_the_lowest_cost_node(costs)
while node is not None:
    cost = costs[node]
    neighbors = graph[node]
    for n in neighbors.keys():
        new_cost = cost + neighbors[n]
        if costs[n] > new_cost:
            costs[n] = new_cost
            parents[n] = node
    processed.append(node)
    node = find_the_lowest_cost_node(costs)

print(costs)
print(parents)
