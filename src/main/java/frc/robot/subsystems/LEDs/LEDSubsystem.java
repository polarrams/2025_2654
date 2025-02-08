package frc.robot.subsystems.LEDs;

import java.util.Optional;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LEDSubsystem extends SubsystemBase {
    AddressableLED m_leds = new AddressableLED(0);
    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(69);
    public void led_init() {
        m_leds.setLength(69);
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            //Sets LED rgb values for red
            m_ledBuffer.setRGB(i, 255, 0, 0);
        }
    }
    public void leds() {
        Optional<Alliance> ally = DriverStation.getAlliance();
         if (SmartDashboard.getBoolean("a1", false)) {
        if (ally.isPresent()){
            if(ally.get() == Alliance.Red){
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                // Sets the specified LED to the RGB values for red
                m_ledBuffer.setRGB(i, 255, 0, 0);
                }
            }
            else if (ally.get() == Alliance.Blue) {
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                // Sets the specified LED to the RGB values for red
                m_ledBuffer.setRGB(i, 0, 0, 255);
                }
            }
            else {
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                // Sets the specified LED to the RGB values for red
                m_ledBuffer.setRGB(i, 255, 0, 255);
                }

            }    
        }
    }
    m_leds.setData(m_ledBuffer);
    }
    
}
