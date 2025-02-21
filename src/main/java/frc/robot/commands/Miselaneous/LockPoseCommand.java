package frc.robot.commands.Miselaneous;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;


import frc.robot.subsystems.SwerveSubsystem;

public class LockPoseCommand extends Command {
    private final SwerveSubsystem swerveSubsystem;

    public LockPoseCommand(SwerveSubsystem swerveSubsystem) {
        this.swerveSubsystem = swerveSubsystem;
        addRequirements(swerveSubsystem);
    }

    @Override
    public void execute() {
        swerveSubsystem.lock();
        SmartDashboard.putString("setcolor","lime");
        SmartDashboard.putBoolean("ReefReached", true);
    
    }
}




