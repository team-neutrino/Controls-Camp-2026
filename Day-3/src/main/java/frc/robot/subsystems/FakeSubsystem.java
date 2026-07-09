// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FakeSubsystem extends SubsystemBase {
  // Create member variable here
  private int m_number;

  public FakeSubsystem() {
  }

  // Create method here

  @Override
  public void periodic() {
    // run your method here!!
    m_number += 1;
    System.out.println(m_number);
  }

  // Problem #4
  public Command CountUpCommand() {
    return run(() -> {
    });
  }

  public void resetMethod() {
    m_number = 0;
  }

  // Problem #5
  public Command resetCommand() {
    return run(() -> {
      resetMethod();
    });
  }
}
