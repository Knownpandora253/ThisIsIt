package folder;
import com.ctre.phoenix6.configs.ClosedLoopRampsConfigs;
import com.ctre.phoenix6.configs.OpenLoopRampsConfigs;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;



public class MyTalonFX extends TalonFX implements Motor {
  
  public MyTalonFX(int id, String canBus) {
    super(id, canBus);
    init();
  }
  public MyTalonFX(int id) {
    super(id, "rio");
    init();
  }

  public void init() {
    setEncoderDegrees(0.0);
  }

  public void set(double percent) {//percent of power
    super.set(percent);
  }

  
  public void setVoltage(double voltage) {//sets the voltage of power
    super.setVoltage(voltage);
  }

  
  public void setInverted(boolean inverted) {//true or false if motor is inverted
    super.setInverted(inverted);
  }

  public void setBrake(boolean braked) {//brake the robot, not break :)
    super.setNeutralMode(braked ? NeutralModeValue.Brake : NeutralModeValue.Coast);
  }

  
  public void setRampRate(double rampRate) {
    OpenLoopRampsConfigs openLoopRampsConfigs = new OpenLoopRampsConfigs();
    openLoopRampsConfigs.VoltageOpenLoopRampPeriod = rampRate;
    super.getConfigurator().apply(openLoopRampsConfigs);

    ClosedLoopRampsConfigs closedLoopRampsConfigs = new ClosedLoopRampsConfigs();
    closedLoopRampsConfigs.VoltageClosedLoopRampPeriod = rampRate;
    super.getConfigurator().apply(closedLoopRampsConfigs);
  }

  public void setEncoderDegrees(double position) {//set to where it is
    super.getConfigurator().setPosition(position / (360.0));
  }

  
  public double getPositionDegrees() {//get where it is
    return super.getRotorPosition().getValueAsDouble() * 360.0;
  }

 
  public double getRPM() {
    return ((super.getVelocity().getValueAsDouble() * 60.0));
  }

  
  public double getCurrent() {
    return super.getStatorCurrent().getValueAsDouble();
  }

 
  public double getTemperature() {//get temp of device
    return super.getDeviceTemp().getValueAsDouble();
  }

  
  public int getID() {//rio
    return super.getDeviceID();
  } 
}