package frc.robot.commands.LEDs;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDs.LEDSubsystem;

public class LEDCommand extends Command {
    private final LEDSubsystem m_leds;
    public LEDCommand(
        LEDSubsystem m_leds
    ) 
    {
        this.m_leds = m_leds;
        addRequirements(m_leds);
        
    }

    @Override
    public void initialize() {
        m_leds.led_init();
    }
    @Override
    public void execute() {
        m_leds.leds();
    }
}
