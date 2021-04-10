package top50_string_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    public static void main(String[] args) {
        MeetingRoom2 a = new MeetingRoom2();
        Interval in1 = new Interval(5,15);
        Interval in2 = new Interval(4,9);
        Interval in3 = new Interval(10,16);
        Interval in4 = new Interval(0,30);
        Interval[] intervals = {in1,in2,in3,in4};
        System.out.println(a.solve(intervals));
    }

    public int solve(Interval... intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x.start));
        Queue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.end));

        pq.offer(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            if(pq.peek().end <= intervals[i].start) {
                pq.poll();
            }

            pq.offer(intervals[i]);
        }

        return pq.size();
    }

}
