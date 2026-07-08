package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.command_factories.*;
import frc.robot.subsystems.*;
import static frc.robot.SubsystemContainer.*;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final FakeSubsystem m_fakeSubsystem = new FakeSubsystem();
  private final LEDFactory m_LEDFactory = new LEDFactory(LEDSub);
  private final ShooterFactory m_shooterFactory = new ShooterFactory(shooterSub);
  private final SuperstructureFactory m_superstructureFactory = new SuperstructureFactory();
  
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.x().whileTrue(m_fakeSubsystem.CountUpCommand());
    m_driverController.y().whileTrue(m_fakeSubsystem.resetCommand());
    m_driverController.a().whileTrue(m_LEDFactory.turnLEDsOrange());
    m_driverController.b().whileTrue(m_LEDFactory.turnLEDsWhite());
    m_driverController.leftBumper().whileTrue(m_shooterFactory.runMotor());
    // m_driverController.rightBumper().whileTrue(m_ShooterFactory.runMotorSlow());
    // m_driverController.start().whileTrue(m_superstructureFactory.changeLEDWhenMotorSpin());
  }
}
