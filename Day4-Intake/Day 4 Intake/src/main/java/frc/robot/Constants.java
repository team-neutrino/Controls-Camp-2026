package frc.robot;

import com.ctre.phoenix6.CANBus;

public final class Constants {
  public static class RioConstants {
    public static final CANBus RIO_BUS = new CANBus("rio");
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class IntakeConstants {
    public static final int ROLLER_MOTOR_ID = 12;
    public static final int DEPLOY_MOTOR_ID = 13;
    public static final int FOLLOWER_MOTOR_ID = 31;

    public static final double ROLLER_CURRENT_LIMIT = 45;
    public static final double DEPLOY_CURRENT_LIMIT = 45;

    public static final double INTAKE_VOLTAGE = 10;
    public static final double OUTTAKE_VOLTAGE = -10;

    public static final double STARTING_POSITION = 0;
    public static final double DEPLOYED_POSITION = -14.6;
    public static final double INTERMEDIATE_POSITION_1 = -5;
    public static final double INTERMEDIATE_POSITION_2 = -12;
    public static final double ALLOWED_TARGET_ERROR = 0.25;

    public static final double INTAKE_kP = 2.25;
    public static final double INTAKE_kI = 0.0;
    public static final double INTAKE_kD = 0.0;
  }
}
