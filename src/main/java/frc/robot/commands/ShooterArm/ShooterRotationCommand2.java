package frc.robot.commands.ShooterArm;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import java.util.function.DoubleSupplier;

public class ShooterRotationCommand2 extends Command {
    private final ShooterRotation m_ShooterRotation;
    private final double pos;
    private final double speed;
<<<<<<< HEAD
    private final boolean reset;
    private final DoubleSupplier m_PositionSupplier;
=======

>>>>>>> 36a0e34e992a1d6ea343c22dbf157333fe6173cf
    private final String armColor;


    //declare variables in this. format and through subsystem here.

    public ShooterRotationCommand2(
        ShooterRotation c_Armsub,
<<<<<<< HEAD
        DoubleSupplier c_PostionSupplier,
        double pos,
        double speed,
        boolean reset,
=======
        double pos,
        double speed,
>>>>>>> 36a0e34e992a1d6ea343c22dbf157333fe6173cf
        String armColor
    )
     {
        this.armColor = armColor;
        this.m_ShooterRotation = c_Armsub;
        this.pos = pos;
        this.speed = speed;
<<<<<<< HEAD
        this.reset = reset;
        this.m_PositionSupplier = c_PostionSupplier;
=======

   
>>>>>>> 36a0e34e992a1d6ea343c22dbf157333fe6173cf
        addRequirements(m_ShooterRotation);
     }

//Sets zero when robot starts.
<<<<<<< HEAD
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
    
    if(m_PositionSupplier == null){m_ShooterRotation.drive_to_pos(pos, speed, armColor);}
    else{m_ShooterRotation.drive_to_pos(m_PositionSupplier.getAsDouble() *-78+10, speed, armColor);}
=======

//Arm movement command.
@Override
  public void execute() {
    m_ShooterRotation.drive_to_pos(pos, speed, armColor);
>>>>>>> 36a0e34e992a1d6ea343c22dbf157333fe6173cf
}

}

