package frc.robot;

import frc.robot.util.Constants.OperatorConstants;
import frc.robot.factories.IntakeFactory;
import static frc.robot.util.Subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final CommandXboxController m_driverController = new CommandXboxController(
      OperatorConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    setDefaultCommands();
  }

  private void configureBindings() {
    m_driverController.leftBumper().whileTrue(IntakeFactory.runIntakeCommand());
    m_driverController.rightBumper().whileTrue(IntakeFactory.runOuttake());
    m_driverController.leftTrigger().onTrue(IntakeFactory.deployIntakeCommand());
    m_driverController.rightTrigger().onTrue(IntakeFactory.retractIntakeCommand());
    m_driverController.b().onTrue(IntakeFactory.toggleIntakeCommand());
  }

  private void setDefaultCommands() {
    intake.setDefaultCommand(intake.defaultCommand());
  }

  public Command getAutonomousCommand() {
    // does nothing
    return new InstantCommand();
  }
}
