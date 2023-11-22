public class Ramp {
    private double minAngle;
    private double maxAngle;

    private double angle;

    public Ramp(double minAngle, double maxAngle) {
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        this.angle = minAngle;
    }

    public Ramp() {
        minAngle = 0;
        maxAngle = 90;
        this.angle = minAngle;
    }

    /**
     * Lowers the ramp by an angle
     *
     * @param angle, the angle of which the ramp is lowered
     */
    public void lower(double angle) {
        if (this.angle - angle > minAngle && angle >= 0) {
            this.angle -= angle;
        } else if (angle >= 0) {
            this.angle = minAngle;
        }
    }

    /**
     * Lowers the ramp to its minimum angle
     */
    public void lower() {
        angle = minAngle;
    }

    /**
     * Raises the ramp by an angle
     *
     * @param angle, the angle of which the ramp is raised
     */
    public void raise(double angle) {
        if (this.angle + angle < maxAngle && angle >= 0) {
            this.angle += angle;
        } else if (angle >= 0) {
            this.angle = maxAngle;
        }
    }

    /**
     * Raises the ramp to its minimum angle
     */
    public void raise() {
        angle = maxAngle;
    }

    /**
     * gets the angle
     *
     * @return returns the angle
     */
    public double getAngle() {
        return angle;
    }
}
