// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.factories.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj2.command.button.*;

public class RobotContainer {

  private final LEDSubsystem m_LED_subsystem = new LEDSubsystem();
  private final LEDFactory m_LED_factory = new LEDFactory(m_LED_subsystem);
  private final CommandXboxController XBOX_CONTROLLER_0 = new CommandXboxController(0);

  public RobotContainer() {
    // m_LED_subsystem.setDefaultCommand(m_LED_factory.defaultCommand());
    XBOX_CONTROLLER_0.a().whileTrue(m_LED_factory.white());
    XBOX_CONTROLLER_0.b().whileTrue(m_LED_factory.orange());
    XBOX_CONTROLLER_0.x().onTrue(m_LED_factory.toggleWhiteAndOrange());
    XBOX_CONTROLLER_0.y().whileTrue(m_LED_factory.rainbow());
  }

  public Command getAutonomousCommand() {
    return new InstantCommand();
  }
}