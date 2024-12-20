// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class driveSwerveTrain extends SubsystemBase {
  private static driveSwerveTrain instance = null;

  /**
   * Singleton Constructor for {@link Swerve}
   * @return Single instance of {@link Swerve} common to all contexts.
   */
  public static synchronized driveSwerveTrain getInstance() {
    if (instance == null) instance = new driveSwerveTrain();
    return instance;
  }

  public PIDController rotPID = Constants.ROT_PID;
  public PIDController correctionPID = Constants.CORRECTION_PID;



  public double setOmega = 0.0;

 public void setChassisSpeeds(ChassisSpeeds speeds) {
    ChassisSpeeds correctedSpeeds = speeds;

   
    

   
  }

  private SwerveModule[] moduleList = {
    new SwerveModule(
      "Front Left",
      Constants.FL_LOCATION,
      Constants.DRIVE_GEARING,
      Constants.FL_SPEED,
      Constants.FL_ANGLE,
      Constants.FL_ENCODER,
      Constants.FL_ZERO
    ),
    new SwerveModule(
      "Front Right",
      Constants.FR_LOCATION,
      Constants.DRIVE_GEARING,
      Constants.FR_SPEED,
      Constants.FR_ANGLE,
      Constants.FR_ENCODER,
      Constants.FR_ZERO
    ),
    new SwerveModule(
      "Back Left",
      Constants.BL_LOCATION,
      Constants.DRIVE_GEARING,
      Constants.BL_SPEED,
      Constants.BL_ANGLE,
      Constants.BL_ENCODER,
      Constants.BL_ZERO
    ),
    new SwerveModule(
      "Back Right",
      Constants.BR_LOCATION,
      Constants.DRIVE_GEARING,
      Constants.BR_SPEED,
      Constants.BR_ANGLE,
      Constants.BR_ENCODER,
      Constants.BR_ZERO
    )
  };


}