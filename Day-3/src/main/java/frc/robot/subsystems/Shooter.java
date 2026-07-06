package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class Shooter extends SubsystemBase {
  private SparkMax m_flywheel = new SparkMax(0, MotorType.kBrushless);
  private RelativeEncoder m_encoder = m_flywheel.getEncoder();
  private SparkMaxConfig m_flywheelConfig = new SparkMaxConfig(); 

  public Shooter() {
    m_flywheelConfig.smartCurrentLimit(40);
    m_flywheelConfig.inverted(false);
    m_flywheelConfig.idleMode(IdleMode.kCoast);
  }

  // make methods here

  @Override
  public void periodic() {
  }

  public Command doNothing() {
    return run(
        () -> {
        });
  }

  public Command runMotor() {
    return run(
        () -> {
        });
  }
}
