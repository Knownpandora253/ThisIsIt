
package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.driveSwerveTrain;
import folder.Controllerr;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import folder.Controllerr.Scale;

public class RobotContainer {
  public static Controllerr pilot = new Controllerr(Constants.controller.PILOT_PORT);
  public static Controllerr copilot = new Controllerr(Constants.controller.COPILOT_PORT);
  
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final CommandXboxController m_driverController =
      new CommandXboxController(Constants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  
  private void configureBindings() {

    new Trigger(m_exampleSubsystem::exampleCondition).onTrue(new ExampleCommand(m_exampleSubsystem));
    setDefaultCommands();
    configureBindings();
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }
  private void setDefaultCommands() {
    
    Controllerr.onTrue(-pilot.getCorrectedLeft().getX() * 1.0,-pilot.getCorrectedLeft().getY() * 1.0, pilot.getRightX(Scale.SQUARED) * 0.7);


  
  }

}
