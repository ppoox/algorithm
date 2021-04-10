package leetcode;

class RainStorm extends Storm {

    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        super(eyeRadius, eyePositionX, eyePositionY);
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }

}