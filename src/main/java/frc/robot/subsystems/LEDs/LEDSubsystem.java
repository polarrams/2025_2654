package frc.robot.subsystems.LEDs;

import static edu.wpi.first.units.Units.Second;
import static edu.wpi.first.units.Units.Seconds;

import java.time.Duration;
import java.util.Optional;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.units.measure.Time;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.commands.Elevator.ElevatorDTP;
import frc.robot.subsystems.Elevator.ElevatorSubsystem;

public class LEDSubsystem extends SubsystemBase {
    AddressableLED m_leds = new AddressableLED(1);
    AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(220);
    public void led_init() {
        m_leds.setLength(220);
        SmartDashboard.putNumber("reefdebug", 14);
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
                SmartDashboard.putNumber("reefdebug", 11);
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                // Sets the specified LED to the RGB values for red
                m_ledBuffer.setRGB(i, 255, 0, 0);
                }
            }
            else if (ally.get() == Alliance.Blue) {
                SmartDashboard.putNumber("reefdebug", 12);
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                // Sets the specified LED to the RGB values for red
                m_ledBuffer.setRGB(i, 0, 0, 255);
                }
            }
            else {
                SmartDashboard.putNumber("reefdebug", 13);
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
    //changes the color of the LEDs on the elevator based on its height and the direction it is moving in
    public void change_colors() {
        /*if(SmartDashboard.getBoolean("blinking", true)){
            if(SmartDashboard.getBoolean("blinked", false)){
                if(SmartDashboard.getBoolean("moving down", false)) {
                    LEDPattern purple_flashing = LEDPattern.solid(Color.kYellow);
                    //purple_flashing.blink(Time.ofBaseUnits(0.1, Seconds));
                    //purple_flashing.synchronizedBlink(RobotController::getRSLState); 
                    purple_flashing.applyTo(m_ledBuffer);
                    purple_flashing.breathe(Time.ofBaseUnits(1, Seconds));
                    SmartDashboard.putBoolean("blinked", true);
                    
                    m_leds.setData(m_ledBuffer);
                }
                else {
                    LEDPattern Yellow_flashing = LEDPattern.solid(Color.kYellow);
                    //Yellow_flashing.blink(Time.ofBaseUnits(0.1, Seconds));
                    Yellow_flashing.applyTo(m_ledBuffer);
                    SmartDashboard.putBoolean("blinked", true);
                    m_leds.setData(m_ledBuffer);
                }
        }
    }
        else {*/
        SmartDashboard.putBoolean("reefcheck", SmartDashboard.getBoolean("ReefReached", true));
        if(SmartDashboard.getBoolean("ReefReached", true) == true | SmartDashboard.getBoolean("wheel_switch", false) == true) {
            switch ((String) SmartDashboard.getString("ReefColor", "purple-flashing")) {
                case "Teal":
                    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                        //Sets LED rgb values for red
                        m_ledBuffer.setRGB(i, 0, 255, 255);
                    }
                    SmartDashboard.putNumber("reefdebug", 4);
                break;
                case "Green":
                    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                        //Sets LED rgb values for red
                        m_ledBuffer.setRGB(i, 0, 255, 0);
                    }
                    SmartDashboard.putNumber("reefdebug", 5);
                break;
                case "Flashing-Yellow":
                SmartDashboard.putNumber("reefdebug", 10);
                if (System.currentTimeMillis() % 300 > 150) {
                    LEDPattern yellow = LEDPattern.solid(Color.kYellow);
                    yellow.applyTo(m_ledBuffer);
                }
                else {
                    LEDPattern black = LEDPattern.solid(Color.kBlack);
                    black.applyTo(m_ledBuffer);
                }
                break;
                case "Flashing-Purple":
                SmartDashboard.putNumber("reefdebug", 9);
                    if (System.currentTimeMillis() % 300 > 150) {
                        LEDPattern purple = LEDPattern.solid(Color.kPurple);
                        purple.applyTo(m_ledBuffer);
                    }
                    else {
                        LEDPattern black = LEDPattern.solid(Color.kBlack);
                        black.applyTo(m_ledBuffer);
                    }
                break;
                case "Purple":
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 255, 0, 255);
                    }
                    SmartDashboard.putNumber("reefdebug", 15);
                break;
                case "Pink":
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 202, 7, 206);
                    }
                    SmartDashboard.putNumber("reefdebug", 8);
                break;
                case "Orange": 
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i, 239, 83, 4);
                    SmartDashboard.putNumber("reefdebug", 8);
                    }
                break;
                case "White":
                    SmartDashboard.putNumber("reefdebug", 1);
                    LEDPattern white = LEDPattern.solid(Color.kWhite);
                    white.applyTo(m_ledBuffer);
                break;
                case "Yellow":
                    SmartDashboard.putNumber("reefdebug", 16);
                    LEDPattern yellow = LEDPattern.solid(Color.kYellow);
                    yellow.applyTo(m_ledBuffer);
                break;
                case "Lime":
                for (var i = 0; i < m_ledBuffer.getLength(); i++) {
                    //Sets LED rgb values for red
                    m_ledBuffer.setRGB(i,174 , 201, 48);
                    SmartDashboard.putNumber("reefdebug", 6);
                    }
                default:
                LEDPattern default_pattern = LEDPattern.solid(Color.kPurple);
                //default_pattern.blink(Time.ofBaseUnits(0.5, Seconds));
                default_pattern.applyTo(m_ledBuffer);
                SmartDashboard.putNumber("reefdebug", 2);
                break;
            
            }
            m_leds.setData(m_ledBuffer);
        }
        else {
            LEDPattern default_pattern = LEDPattern.solid(Color.kPurple);
            //default_pattern.blink(Time.ofBaseUnits(0.5, Seconds));
            default_pattern.applyTo(m_ledBuffer);
            SmartDashboard.putNumber("reefdebug", 3);
            m_leds.setData(m_ledBuffer);
            
        }
    }
        
    //}


    public void blinkled() {
        SmartDashboard.putNumber("reefdebug", 7);
        if(SmartDashboard.getNumber("Elevator Speed", 0)<0) {
            LEDPattern purple = LEDPattern.solid(Color.kPurple);
        }
        else {
            LEDPattern yellow = LEDPattern.solid(Color.kYellow);
        }
    }
}
