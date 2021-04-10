package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Platformer {

    private List<Integer> tiles;
    private int position;

    public Platformer(int n, int position) {
        List<Integer> tiles = new LinkedList<>();
        for(int i=0; i<n; i++) {
            tiles.add(Integer.valueOf(i));
        }

        this.tiles = tiles;
        this.position = position;
    }

    public void jumpLeft() {
        System.out.println("left " + this.position);
        System.out.println("left prev " + Arrays.toString(this.tiles.toArray()));

        this.position = this.tiles.indexOf(this.position-2);
        this.tiles.remove(this.position);
        System.out.println("left After " + Arrays.toString(this.tiles.toArray()));
    }

    public void jumpRight() {
        System.out.println("right " + this.position);
        System.out.println("right prev " + Arrays.toString(this.tiles.toArray()));
        this.position = this.tiles.indexOf(this.position)+1;
        this.tiles.remove(this.position);

        System.out.println("right After " + Arrays.toString(this.tiles.toArray()));
    }

    public int position() {
        return this.position;
    }

    public static void main(String[] args) {
        Platformer platformer = new Platformer(10, 3);
        System.out.println(platformer.position()); // should print 3

        platformer.jumpLeft();
        System.out.println(platformer.position()); // should print 1

        platformer.jumpRight();
        System.out.println(platformer.position()); // should print 4
    }
}