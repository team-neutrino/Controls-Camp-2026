package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.FakeSubsystem;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final FakeSubsystem m_fakeSubsystem = new FakeSubsystem();
  private final LEDs m_LEDs = new LEDs();
  private final Shooter m_shooter = new Shooter();
  
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(m_fakeSubsystem.CountUpCommand());
    m_driverController.b().whileTrue(m_fakeSubsystem.resetCommand());
  }
}
