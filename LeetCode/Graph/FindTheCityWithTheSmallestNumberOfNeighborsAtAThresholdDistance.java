// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<Integer[]>> graph = new HashMap<>();

        // Build undirected graph
        for(int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];

            if (graph.containsKey(from)) {
                graph.get(from).add(new Integer[]{to, weight});
            } else {
                List<Integer[]> list = new ArrayList<>();
                list.add(new Integer[]{to, weight});
                graph.put(from, list);
            }
            
            if (graph.containsKey(to)) {
                graph.get(to).add(new Integer[]{from, weight});
            } else {
                List<Integer[]> list = new ArrayList<>();
                list.add(new Integer[]{from, weight});
                graph.put(to, list);
            }
        }

        int minCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for(int i = 0; i < n; i++) {
            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;

            // Use PriorityQueue with a proper comparator
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{i, 0});

            while(!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentNode = current[0];
                int currentDist = current[1];

                // Skip if we already found a better path
                if(currentDist > distance[currentNode]) continue;

                if(graph.containsKey(currentNode)) {
                    for(Integer[] neighbor : graph.get(currentNode)) {
                        int nextNode = neighbor[0];
                        int weight = neighbor[1];
                        int newDist = currentDist + weight;

                        if(newDist < distance[nextNode]) {
                            distance[nextNode] = newDist;
                            pq.offer(new int[]{nextNode, newDist});
                        }
                    }
                }
            }

            int count = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && distance[j] <= distanceThreshold) {
                    count++;
                }
            }

            
            if(count < minCount) {
                minCount = count;
                resultCity = i;
            } else if(count == minCount && i > resultCity) {
                resultCity = i;
            }
        }

        return resultCity;
    }
}