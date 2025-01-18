package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterRotation;


public class ShooterRotationCommand extends Command{
    private final ShooterRotation m_ShooterRotation;
    private final double speed;

    public ShooterRotationCommand(
        ShooterRotation c_ShooterRotation,
        double speed
        
        ){
            this.speed = speed;
            this.m_ShooterRotation = c_ShooterRotation;
            addRequirements(c_ShooterRotation);
        }
    

    

@Override
public void execute() {
    m_ShooterRotation.run(speed);

}
/* @Override
  public void execute() {
    double current_pos = m_ArmSubsystem.getPos();
    if (current_pos < 45 && speed>0){
        m_ArmSubsystem.p2(speed);
        
    } else if(current_pos > -10 && speed<0){
    m_ArmSubsystem.p2(speed);
    }
    else{m_ArmSubsystem.p2(0);}
}*/
}

