package frc.robot.commands.Miselaneous;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Miselaneous.InvertedControllerSubsystem;

public class InvertedControllerCommand extends Command {
    public final InvertedControllerSubsystem m_InvertedControllerSubsystem;
    private Debouncer m_Debouncer = new Debouncer(1);
    private boolean m_InvertedController = false;
    public InvertedControllerCommand(
    InvertedControllerSubsystem c_InvertedControllerSubsystem
    
)
{
    this.m_InvertedControllerSubsystem = c_InvertedControllerSubsystem;
    
    addRequirements(m_InvertedControllerSubsystem);
    m_InvertedControllerSubsystem.Invertedset(m_InvertedController);
    if (m_Debouncer.calculate(m_InvertedControllerSubsystem.getInverted()) == true) {
        m_InvertedControllerSubsystem.Invertedset(true);
    } else {
        m_InvertedControllerSubsystem.Invertedset(false);
    }
}
}

