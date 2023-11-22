import java.awt.*;

public class Scania extends Car {

    public Ramp ramp;


    public Scania(double[] position) {
        super(position, 2, Color.decode("#09CDDA"), 50, "Scania");
        ramp = new Ramp(0, 70);
    }

    public double speedFactor() {
        if (this.ramp.getAngle() == 0) {
            return enginePower * 0.01;
        }
        return 0;
    }

    /**
     * override so startEngine() only works if the ramp is down
     */
    @Override
    public void startEngine() {
        if(ramp.getAngle() == 0){
            super.startEngine();
        }
    }


    public void raiseRamp(double angle) {
        if (getCurrentSpeed() == 0) {
            ramp.raise(angle);
        }
    }

    public void lowerRamp(double angle) {
        ramp.lower(angle);
    }

}
