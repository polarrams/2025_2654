package frc.robot.subsystems.LEDs;

import java.util.Optional;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LEDSubsystem extends SubsystemBase {
    AddressableLED m_leds = new AddressableLED(1);
    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(220);
    public void led_init() {
        m_leds.setLength(220);
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
            //Sets LED rgb values for red
            m_ledBuffer.setRGB(i, 0, 78, 151);
        }
        m_leds.setData(m_ledBuffer);
        m_leds.start();
    }
    public void leds() {
        Optional<Alliance> ally = DriverStation.getAlliance();
        //if (SmartDashboard.getBoolean("a1", false)) {
        if (ally.isPresent()){
            SmartDashboard.putBoolean("ally present", true);
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
    //}
    /*else{ 
        for (var i = 0; i < m_ledBuffer.getLength(); i++) {
        // Sets the specified LED to the RGB values for red
        m_ledBuffer.setRGB(i, 191, 255, 0);
        }
    }*/
    m_leds.setData(m_ledBuffer);
    }
    public void reefHeight() {
        switch ((int) SmartDashboard.getNumber("reefheight", 0)) {
            case 1:
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 0, 255, 255);
                }
                SmartDashboard.putNumber("reefdebug", 1);
                break;
            case 2:
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 0, 255, 0);
                }
                SmartDashboard.putNumber("reefdebug", 2);
            break;
            case 3:
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 255, 255, 0);
                }
                SmartDashboard.putNumber("reefdebug", 3);
            break;
        
            default:
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 255, 0, 255);
                }
                SmartDashboard.putNumber("reefdebug", 0);
            break;
        }
        m_leds.setData(m_ledBuffer);
    }
    
}
