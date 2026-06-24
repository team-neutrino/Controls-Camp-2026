package frc.robot.util;

import com.ctre.phoenix6.CANBus;

public final class Constants {
  public static class RioConstants {
    public static final CANBus RIO_BUS = new CANBus("rio");
  }

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
