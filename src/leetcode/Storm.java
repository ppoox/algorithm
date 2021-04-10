package leetcode;

public class Storm {

    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;

    public Storm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }

    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }


}
