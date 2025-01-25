package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import java.util.function.DoubleSupplier;

public class ShooterRotationCommand2 extends Command {
    private final ShooterRotation m_ShooterRotation;
    private final double pos;
    private final double speed;
    private final boolean reset;
    private final DoubleSupplier m_PositionSupplier;

    //declare variables in this. format and through subsystem here.

    public ShooterRotationCommand2(
        ShooterRotation c_Armsub,
        DoubleSupplier c_PostionSupplier,
        double pos,
        double speed,
        boolean reset
    )
     {
    
        this.m_ShooterRotation = c_Armsub;
        this.pos = pos;
        this.speed = speed;
        this.reset = reset;
        this.m_PositionSupplier = c_PostionSupplier;
        addRequirements(m_ShooterRotation);
     }

//Sets zero when robot starts.
@Override
public void initialize(){
  if(reset == true){
  m_ShooterRotation.setzero();
  }
  
}
//Arm movement command.
@Override
  public void execute() {
    SmartDashboard.putNumber("truepos", m_ShooterRotation.getPos());
    
    if(m_PositionSupplier == null){m_ShooterRotation.drive_to_pos(pos, speed);}
    else{m_ShooterRotation.drive_to_pos(m_PositionSupplier.getAsDouble() *-78+10, speed);}
}

}

