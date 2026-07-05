package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.*;

public class LEDSubsystem extends SubsystemBase {

  private static final int ROBORIO_LED_PWM_PORT = 7;
  private static final int LED_STRIP_PIXELS = 8;

  private AddressableLED m_addressableLED;
  private AddressableLEDBuffer m_LEDBuffer;
  private Timer m_timer = new Timer();

  private boolean m_isOrange;

  public LEDSubsystem() {
    m_addressableLED = new AddressableLED(ROBORIO_LED_PWM_PORT);
    m_LEDBuffer = new AddressableLEDBuffer(LED_STRIP_PIXELS);
    m_addressableLED.setLength(m_LEDBuffer.getLength());
    m_addressableLED.setData(m_LEDBuffer);
    m_addressableLED.start();
    m_timer.start();
    m_isOrange = false;
  }

  @Override
  public void periodic() {
    m_addressableLED.setData(m_LEDBuffer);

  }

  public Command doNothing() {
    return runOnce(
        () -> {
        });
  }

  public Command colorCommand(int r, int g, int b) {
    return run(
        () -> {
          for (int i = 0; i < m_LEDBuffer.getLength(); i++) {
            m_LEDBuffer.setRGB(i, r, g, b);
          }
        });
  }

  public Command switchColors(int r1, int g1, int b1, int r2, int g2, int b2) {
    return runOnce(
        () -> {
          m_isOrange = !m_isOrange;

          if (m_isOrange) {
            System.out.println("orange");
            for (int i = 0; i < m_LEDBuffer.getLength(); i++) {
              m_LEDBuffer.setRGB(i, r1, g1, b1);
            }
          } else {
            System.out.println("white");
            for (int i = 0; i < m_LEDBuffer.getLength(); i++) {
              m_LEDBuffer.setRGB(i, r2, g2, b2);
            }
          }
        });
  }

  public Command timedColorSwitch() {
    return run(
        () -> {
          if (m_timer.hasElapsed(5)) {
            if (!m_isOrange) {
              m_isOrange = true;
              int r = 255;
              int g = 165;
              int b = 0;
              System.out.println("orange");
              for (int i = 0; i < m_LEDBuffer.getLength(); i++) {
                m_LEDBuffer.setRGB(i, r, g, b);
              }
              m_timer.stop();
              m_timer.reset();
              m_timer.start();
            } else {
              m_isOrange = false;
              int r = 255;
              int g = 255;
              int b = 255;
              System.out.println("white");
              for (int i = 0; i < m_LEDBuffer.getLength(); i++) {
                m_LEDBuffer.setRGB(i, r, g, b);
              }
              m_timer.stop();
              m_timer.reset();
              m_timer.start();
            }
          }
        });
  }
}