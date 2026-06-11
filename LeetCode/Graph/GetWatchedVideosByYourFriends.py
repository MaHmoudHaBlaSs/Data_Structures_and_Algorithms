# https://leetcode.com/problems/get-watched-videos-by-your-friends

from collections import deque

class Solution:
    def watchedVideosByFriends(self, watchedVideos, friends, id, level):
        # level k of videos are all watched videos by people with the 
        # shortest path exactly equal to k with you.
        # Remember that BFS finds the shortest path for non-weigthed graphs
        q = deque([id])
        visited = {id}

        # when queue size is 0 the loop will keep rushing till reaching 0
        while level > 0:
            for _ in range(len(q)):
                node = q.popleft()

                for friend in friends[node]:
                    if friend not in visited:
                        visited.add(friend)
                        q.append(friend)

            level -= 1

        freq = {}

        for person in q:
            for video in watchedVideos[person]: # Uniqueness is guaranteed
                freq[video] = freq.get(video, 0) + 1

        # Use freq[x] to sort as primary option then x as secondary option
        return sorted(freq.keys(), key=lambda x: (freq[x], x)) 