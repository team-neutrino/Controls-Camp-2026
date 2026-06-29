package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import static frc.robot.util.Constants.IntakeConstants.*;
import static frc.robot.util.Constants.RioConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private TalonFX m_rollerMotor = new TalonFX(ROLLER_MOTOR_ID, RIO_BUS);
  private TalonFXConfiguration m_rollerMotorConfig = new TalonFXConfiguration();
  private final VoltageOut m_rollerVoltageControl = new VoltageOut(0);
  private final CurrentLimitsConfigs m_rollerCurrentLimitConfig = new CurrentLimitsConfigs();

  public Intake() {
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    return runOnce(
        () -> {

        });
  }

  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
