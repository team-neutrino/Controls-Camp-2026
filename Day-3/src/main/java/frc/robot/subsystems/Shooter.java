package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.PersistMode;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class Shooter extends SubsystemBase {
  private static SparkMax m_flywheel = new SparkMax(10, MotorType.kBrushless);
  private static RelativeEncoder m_encoder = m_flywheel.getEncoder();
  private SparkMaxConfig m_flywheelConfig = new SparkMaxConfig(); 

  public Shooter() {
    m_flywheelConfig.smartCurrentLimit(40);
    m_flywheelConfig.inverted(false);
    m_flywheelConfig.idleMode(IdleMode.kCoast);

    m_flywheel.configure(m_flywheelConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  // make methods here
  public void shooterSpeed(double speed) {
    m_flywheel.set(speed);
  }

  public static double getMotorSpeed() {
    return m_encoder.getVelocity();
  }

  @Override
  public void periodic() {
    shooterSpeed(0.3);
    System.out.println(getMotorSpeed());
    if (getMotorSpeed() > 6000) {
      m_flywheel.set(0.2);
    }
    else if (getMotorSpeed() < 3000) {
      m_flywheel.set(0.3);
    }
  }

  public Command doNothing() {
    return run(
        () -> {
        });
  }

  public Command runMotor(double speed) {
    return run(
        () -> {
          m_flywheel.set(speed);
        });
  }
}
