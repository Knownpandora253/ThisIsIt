package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.configs.MagnetSensorConfigs;
import com.ctre.phoenix6.hardware.CANcoder;

import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import folder.MyTalonFX;
import folder.Motor;
import folder.MyCANCoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;


import edu.wpi.first.math.geometry.Translation2d;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveModule extends SubsystemBase{
  
    
    private final String MODULE_NAME;
    private final Translation2d LOCATION;

    private final int SPEED_ID;
    private final int ANGLE_ID;
    private final int ENCODER_ID;
    private final double ZERO;
  
    private final MyTalonFX speed;
    private final MyTalonFX angle;
    private final MyCANCoder encoder;
  
    private final PIDController anglePID;
    private final SimpleMotorFeedforward angleFF;//i need this don't let the yellow lines fool you 
    private final PIDController speedPID;
    private final SimpleMotorFeedforward speedFF;

    public SwerveModule(String moduleName, Translation2d location, double gearRatio, int speedID, int angleID, int encoderID, double zero) {
    this.MODULE_NAME = moduleName;
    this.LOCATION = location;
    
    this.anglePID = Constants.ANGLE_PID;
    this.angleFF = Constants.ANGLE_FF;
    this.speedPID = Constants.SPEED_PID;

    this.SPEED_ID = speedID;
    this.ANGLE_ID = angleID;
    this.ENCODER_ID = encoderID;
    this.ZERO = zero;


    
    this.speedFF = new SimpleMotorFeedforward(Constants.SPEED_FF.ks, Constants.SPEED_FF.kv);

    this.speed = new MyTalonFX(SPEED_ID, "rio");
    this.angle = new MyTalonFX (ANGLE_ID, "rio");
    this.encoder = new MyCANCoder(ENCODER_ID, "rio");//i should have left the C in Coder lowercase :( in MyCANCoder

    
    init();
    }
    
  public void init() {

    speed.setBrake(false);//break the robot bwahahaha
    speed.setRampRate(Constants.RAMP_RATE);

    angle.setBrake(false);
    angle.setInverted(true);

    encoder.clearStickyFaults();
    MagnetSensorConfigs sensorConfigs = new MagnetSensorConfigs();//make sensor
    sensorConfigs.MagnetOffset = -(ZERO / 360.0);//all the sensor stufffffffs
    sensorConfigs.AbsoluteSensorRange = AbsoluteSensorRangeValue.Signed_PlusMinusHalf;
    sensorConfigs.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
    encoder.getConfigurator().apply(sensorConfigs);

    anglePID.enableContinuousInput(-180, 180);
    anglePID.setTolerance(0);    
    angle.setEncoderDegrees(getAngleDegrees());//set how much encoder turned

    angle.getVelocity().setUpdateFrequency(50.0);//how fast pigeon(is it called that?, i think can't remeber rn) sends
    angle.getRotorPosition().setUpdateFrequency(50.0);
    encoder.getAbsolutePosition().setUpdateFrequency(100.0);

    speed.optimizeBusUtilization();
    angle.optimizeBusUtilization();
    encoder.optimizeBusUtilization();
    speed.clearStickyFaults();
    angle.clearStickyFaults();
  }
  public double getAngleDegrees() {
    return encoder.getPositionDegrees();
  }
}

