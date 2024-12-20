package folder;

import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;

public class MyCANCoder extends CANcoder {
    public boolean inverted = false;
    public double zero = 0.0;

    public MyCANCoder(int id, String canBus) {
        super(id, canBus);
        init();
    }
    public MyCANCoder(int id) {
        this(id, "rio");
    }

    public void init() {//initalizies it 
        super.getConfigurator().apply(new CANcoderConfiguration());
        super.clearStickyFaults();
    }

    public void setPositionDegrees(double position) {//sets the postition degrees
        super.setPosition(position / (2.0 * Math.PI));
    }

    public void resetPosition() {//resets posoiton
        super.setPosition(0.0);
    }

    
    public double getPositionDegrees() {//gets the position
        if(!inverted) {
            return super.getAbsolutePosition().getValueAsDouble() * 360.0;
        } else {
            return -super.getAbsolutePosition().getValueAsDouble() * 360.0;
        }
    }

    public void setInverted(boolean inverted) {//sees if true or false for inverted
        this.inverted = inverted;
    }

    public boolean getInverted() {//gets if it is inverted basic getters and setters 
        return inverted;
    }

    public void setZero(double zero) {//zero
        this.zero = zero;
    }
}