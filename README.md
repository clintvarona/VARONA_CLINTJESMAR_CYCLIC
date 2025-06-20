# Varona_ClintJesmar_Cyclic

# Graph Cycle Detection

This repository contains two implementations for detecting cycles in undirected graphs:

1. **cyclic_dfs.js** - Uses Depth-First Search (DFS) to traverse the graph and detect cycles by checking for back edges. Returns the first cycle found between two vertices.

2. **cyclic_bfs.js** - Implements Union-Find (Disjoint Set Union) algorithm to detect cycles during graph construction. Efficiently tracks connected components and detects cycles during edge processing.

Both implementations:
- Handle graphs with up to 100 vertices
- Validate input for adjacency matrix values (0/1)
- Provide clear cycle detection results
- Use Node.js readline for interactive input

Run with: `node filename.js` and follow the prompts to enter graph data.
