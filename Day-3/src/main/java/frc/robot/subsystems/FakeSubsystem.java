// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FakeSubsystem extends SubsystemBase {
  // Create member variable here
  private static double m_double = 0.1;

  public FakeSubsystem() {

  }

  // Create method here

  public static double adderIHardlyKnowHer(double p_double) {
    m_double = p_double + 1;
    return m_double;
  }

  public static void resetCount() {
    m_double = 0;
  }

  @Override
  public void periodic() {
    //run your method here!! 
    if (m_double >= 500) {
      resetCount();
    }
  }

  // Problem #4
  public Command CountUpCommand() {
    return run(() -> {
        m_double = m_double + 1;
        System.out.println(m_double);
        });
  }

  // Problem #5
  public Command resetCommand() {
    return run(() -> {
      m_double = 0;
    });
  }
}
