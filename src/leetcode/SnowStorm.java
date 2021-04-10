package leetcode;

class SnowStorm extends Storm{

    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        super(eyeRadius, eyePositionX, eyePositionY);
        this.amountOfSnow = amountOfSnow;
    }

    public double getAmountOfSnow() {
        return amountOfSnow;
    }

}