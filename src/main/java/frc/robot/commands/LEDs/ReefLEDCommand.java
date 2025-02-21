package frc.robot.commands.LEDs;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LEDs.LEDSubsystem;

public class ReefLEDCommand extends Command {
    private final LEDSubsystem m_reefled;
    public ReefLEDCommand(
        LEDSubsystem m_reefled
    ) 
    {
        this.m_reefled = m_reefled;
        addRequirements(m_reefled);
    }
    @Override
    public void execute() {
        m_reefled.change_colors();
    }
}
