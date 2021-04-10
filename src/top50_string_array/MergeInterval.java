package top50_string_array;


import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Interval in1 = new Interval(1, 3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        MergeInterval mi = new MergeInterval();
        List<Interval> list = mi.merge(intervals);

    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) return intervals;

        List<Interval> results = new ArrayList<>();

        Collections.sort(intervals, Comparator.comparingInt(x -> x.start));

        Interval before = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(before.end >= current.start) {
                before.end = current.end;
            } else {
                results.add(before);
                before = current;
            }
        }

        if(!results.contains(before)) {
            results.add(before);
        }

        for(Interval result : results) {
            System.out.println(result.start + " / " + result.end);
        }


      return null;
    }

}
