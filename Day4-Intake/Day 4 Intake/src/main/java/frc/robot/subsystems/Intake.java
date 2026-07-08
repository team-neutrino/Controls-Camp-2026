package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import static frc.robot.util.Constants.IntakeConstants.*;
import static frc.robot.util.Constants.RioConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private TalonFX m_rollerMotor;
  private TalonFXConfiguration m_rollerMotorConfig;
  private final VoltageOut m_rollerVoltageControl;
  private final CurrentLimitsConfigs m_rollerCurrentLimitConfig;

  public Intake() {
    m_rollerMotor = new TalonFX(ROLLER_MOTOR_ID, RIO_BUS);
    m_rollerMotorConfig = new TalonFXConfiguration();
    m_rollerVoltageControl = new VoltageOut(0);
    m_rollerCurrentLimitConfig = new CurrentLimitsConfigs();
    m_rollerCurrentLimitConfig.withSupplyCurrentLimit(ROLLER_CURRENT_LIMIT)
        .withSupplyCurrentLimitEnable(true)
        .withStatorCurrentLimit(ROLLER_CURRENT_LIMIT)
        .withStatorCurrentLimitEnable(true);
    m_rollerMotorConfig.CurrentLimits = m_rollerCurrentLimitConfig;

    // uncomment these two lines once you have the deploy motor config made
    // m_deployMotorConfig.Slot0.kP = INTAKE_kP;

    m_rollerMotor.getConfigurator().apply(m_rollerMotorConfig);
    m_rollerMotor.setNeutralMode(NeutralModeValue.Coast);
    m_rollerMotorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
  }

  // use this as a model for other commands you'll create
  public Command exampleMethodCommand() {
    return runOnce(
        () -> {

        });
  }

  public Command defaultCommand() {
    return runOnce(
        () -> {

        });
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
