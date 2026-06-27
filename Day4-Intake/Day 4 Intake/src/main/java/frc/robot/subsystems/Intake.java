package frc.robot.subsystems;

import static frc.robot.util.Constants.IntakeConstants.*;
import static frc.robot.util.Constants.RioConstants.*;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private TalonFX m_rollerMotor = new TalonFX(ROLLER_MOTOR_ID, RIO_BUS);
  private TalonFX m_rollerFollowerMotor = new TalonFX(FOLLOWER_MOTOR_ID, RIO_BUS);
  private TalonFX m_deployMotor = new TalonFX(DEPLOY_MOTOR_ID, RIO_BUS);

  private TalonFXConfiguration m_rollerMotorConfig = new TalonFXConfiguration();
  private TalonFXConfiguration m_deployMotorConfig = new TalonFXConfiguration();
  private final CurrentLimitsConfigs m_rollerCurrentLimitConfig = new CurrentLimitsConfigs();
  private final CurrentLimitsConfigs m_deployCurrentLimitConfig = new CurrentLimitsConfigs();

  private boolean m_isDeployed = false;
  private double m_targetAngle;
  private double m_rollerMotorVoltage;
  private final PositionVoltage m_deployPositionControl = new PositionVoltage(0);
  private final VoltageOut m_rollerVoltageControl = new VoltageOut(0);

  public Intake() {
    m_deployCurrentLimitConfig.withSupplyCurrentLimit(DEPLOY_CURRENT_LIMIT)
        .withSupplyCurrentLimitEnable(true)
        .withStatorCurrentLimit(DEPLOY_CURRENT_LIMIT)
        .withStatorCurrentLimitEnable(true);
    m_rollerCurrentLimitConfig.withSupplyCurrentLimit(ROLLER_CURRENT_LIMIT)
        .withSupplyCurrentLimitEnable(true)
        .withStatorCurrentLimit(ROLLER_CURRENT_LIMIT)
        .withStatorCurrentLimitEnable(true);
    m_deployMotorConfig.CurrentLimits = m_deployCurrentLimitConfig;
    m_rollerMotorConfig.CurrentLimits = m_rollerCurrentLimitConfig;

    m_deployMotorConfig.Slot0.kP = INTAKE_kP;
    m_deployMotorConfig.Slot0.kI = INTAKE_kI;
    m_deployMotorConfig.Slot0.kD = INTAKE_kD;

    m_rollerMotor.getConfigurator().apply(m_rollerMotorConfig);
    m_rollerFollowerMotor.getConfigurator().apply(m_rollerMotorConfig);
    m_deployMotor.getConfigurator().apply(m_deployMotorConfig);
    m_rollerMotor.setNeutralMode(NeutralModeValue.Coast);
    m_rollerFollowerMotor.setNeutralMode(NeutralModeValue.Coast);
    m_deployMotor.setNeutralMode(NeutralModeValue.Coast);
    m_deployMotor.setPosition(0);
    m_rollerMotorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;

    Follower followRequest = new Follower(ROLLER_MOTOR_ID, MotorAlignmentValue.Opposed);
    m_rollerFollowerMotor.setControl(followRequest);
  }

  public double getMotorAngle() {
    return m_deployMotor.getPosition().getValueAsDouble();
  }

  public double getTargetAngle() {
    return m_targetAngle;
  }

  public double getRollerRPM() {
    return m_rollerMotor.getVelocity().getValueAsDouble() * 60;
  }

  private void moveToIntake(double targetPosition) {
    m_deployMotor.setControl(m_deployPositionControl.withPosition(targetPosition));
  }

  private void spinRoller(double voltage) {
    m_rollerMotor.setControl(m_rollerVoltageControl.withOutput(voltage));
  }

  public void setIntakePID(double new_P, double new_I, double new_D) {
    m_deployMotorConfig.Slot0.kP = new_P;
    m_deployMotorConfig.Slot0.kI = new_I;
    m_deployMotorConfig.Slot0.kD = new_D;

    m_deployMotor.getConfigurator().apply(m_deployMotorConfig);
  }

  @Override
  public void periodic() {
    spinRoller(m_rollerMotorVoltage);
    moveToIntake(m_targetAngle);
  }

  public Command defaultCommand() {
    return run(
        () -> {
          m_rollerMotorVoltage = 0;
        });
  }

  public Command runIntake(double speed) {
    return run(() -> {
      m_rollerMotorVoltage = speed;
    });
  }

  public Command toggleIntake() {
    return runOnce(() -> {
      m_isDeployed = !m_isDeployed;

      if (m_isDeployed) {
        m_targetAngle = DEPLOYED_POSITION;
      } else {
        m_targetAngle = 0;
      }
    });
  }

  public Command deployIntake() {
    return runOnce(() -> {
      m_targetAngle = DEPLOYED_POSITION;
      m_isDeployed = true;
    });
  }

  public Command retractIntake() {
    return runOnce(() -> {
      m_targetAngle = 0;
      m_isDeployed = false;
    });
  }

  public boolean exampleCondition() {
    return false;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
