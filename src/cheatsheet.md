CHEATSHEET

GRAPH:
Topological Sort:
- Visit all the dependency nodes before considering the node to be visited
- Can only work on Directed Acyclic graphs (DAG)
- Trees are top sorted

Algorithm:
- Randomly pick a node
- Do a DFS (recrursive)
- mark a node as visited if there are no paths left to be visited from that node
- Have a list for storing the visited nodes

Topological Sort with Kahn's Algorithm:
- Keep removing nodes from a graph that doesn't have any dependency
- If the graph is not empty, it means that the graph has cycles
- Build the adjacency list
- Find the count / incoming degree or the dependencies for each node and store it
- Add all the nodes with incoming degree / dependencies to be 0 into the Queue
- Decrement the count on all the nodes which depended on this node
Find cycles in Graph:
- Use Tarjan's Strongly connected algorithm