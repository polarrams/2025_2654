package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InvertedControllerSubsystem;

public class InvertedControllerCommand extends Command {
    public final InvertedControllerSubsystem m_InvertedControllerSubsystem;
    private boolean m_InvertedController = false;
    public InvertedControllerCommand(
    InvertedControllerSubsystem c_InvertedControllerSubsystem,
    boolean c_InvertedController
)
{
    this.m_InvertedControllerSubsystem = c_InvertedControllerSubsystem;
    this. m_InvertedController = c_InvertedController;
    addRequirements(m_InvertedControllerSubsystem);
    
}
}

