// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.command_factories;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDs;
import frc.robot.subsystems.Shooter;
import static frc.robot.SubsystemContainer.*;

/** Add your docs here. */
public class SuperstructureFactory {
    ShooterFactory shooterFactory = new ShooterFactory(shooterSub);

    LEDFactory LEDFactory = new LEDFactory(LEDSub);

    // public Command changeLEDWhenMotorSpin() {
        
    // }
}
