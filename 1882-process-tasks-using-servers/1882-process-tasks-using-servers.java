import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int m = servers.length, n = tasks.length;

        // {weight, index}
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                                   : Integer.compare(a[1], b[1]));

        // {freeTime, weight, index}
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0])
                    : a[1] != b[1] ? Long.compare(a[1], b[1])
                                   : Long.compare(a[2], b[2]));

        for (int i = 0; i < m; i++) free.offer(new int[]{servers[i], i});

        int[] ans = new int[n];
        long time = 0;

        for (int j = 0; j < n; j++) {
            time = Math.max(time, j);

            // release servers that have finished by now
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[1], (int) s[2]});
            }

            // nobody free: fast-forward to the earliest finish time
            if (free.isEmpty()) {
                time = busy.peek()[0];
                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();
                    free.offer(new int[]{(int) s[1], (int) s[2]});
                }
            }

            int[] server = free.poll();
            ans[j] = server[1];
            busy.offer(new long[]{time + tasks[j], server[0], server[1]});
        }
        return ans;
    }
}