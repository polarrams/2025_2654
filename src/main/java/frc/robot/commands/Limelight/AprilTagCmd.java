package frc.robot.commands.Limelight;

import edu.wpi.first.wpilibj2.command.Command;

import java.time.Instant;
import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterArm.ShooterRotation;
import frc.robot.subsystems.LimeLight.LimeLightSubsystem;
import java.lang.Math;
import edu.wpi.first.wpilibj.DriverStation;



public class AprilTagCmd extends Command {
    //declare variables in this. format and through subsystem here.
    private final ShooterRotation m_ShooterRotation;
    private final double pos;
    private final double speed;
    private final boolean reset;
    private final LimeLightSubsystem m_LimeLight;

    public AprilTagCmd(
    ShooterRotation c_ShooterRotation,
    double pos,
    double speed,
    boolean reset,
    LimeLightSubsystem c_LimeLight) {

    this.m_ShooterRotation = c_ShooterRotation;
    this.pos = pos;
    this.speed = speed;
    this.reset = reset;   
    this.m_LimeLight = c_LimeLight;
    addRequirements(m_ShooterRotation,m_LimeLight);
    }
  
   // set zero when robot starts 
@Override
public void initialize(){
    if(reset == true){
        m_ShooterRotation.setzero();
        }
 } 

//april tag progress, goes to arm angle when it sees tags on a button command
@Override
  public void execute() {
    SmartDashboard.putNumber("truepos", m_ShooterRotation.getPos());
    m_ShooterRotation.drive_to_pos(pos, speed);
   
    double[] SpeakerAprilTag = m_LimeLight.limelight();
    //double x = SpeakerAprilTag[0];
    double y = SpeakerAprilTag[1];
    double Area = SpeakerAprilTag[2];
    double Tid = SpeakerAprilTag[3];
    double DPOS = 0;

    Optional<Alliance> ally = DriverStation.getAlliance();
    if (ally.isPresent()){
            if(ally.get() == Alliance.Red){
                if(Tid == 5 ||Tid == 15){
                    double angle = Math.asin((96.04*(y*y -2.26*2.26)+44.296)/(2*9.8*Math.sqrt(y*y-2.26*2.26)*speed));//in radians?
                    m_ShooterRotation.drive_to_pos(angle,0.1);
                    
                    //return angle;
                }
            }
            else if(ally.get() == Alliance.Blue){
                if(Tid == 4||Tid == 14){
                    double angle = Math.asin((96.04*(y*y -2.26*2.26)+44.296)/(2*9.8*Math.sqrt(y*y-2.26*2.26)*speed));
                    m_ShooterRotation.drive_to_pos(angle,0.1);
                }
            }
     }

   // if(Tid == 8 ||Tid == 4 || Tid == 7){
   //     SmartDashboard.putNumber("Shooter Rotation Value",m_ShooterRotation.getPos());
   //     if(y >= 20){m_ShooterRotation.drive_to_pos(60,0.3);DPOS = 60;}
   //     else if((y<20) && (y>=19)){m_ShooterRotation.drive_to_pos(59, 0.3);DPOS = 59;}
//
   //     else {m_ShooterRotation.drive_to_pos(37.1, 0.3);DPOS = 37;}
   //     
   //         
   //     
   // }
    else{ 
        double current_pos = m_ShooterRotation.getPos();
        if (current_pos < -10 && speed>0){
            m_ShooterRotation.p2(speed);
            
        } else if(current_pos > 43.2 && speed<0){
        m_ShooterRotation.p2(speed);
        }
        else {m_ShooterRotation.drive_to_pos(SmartDashboard.getNumber("Shooter Rotation Value",-60)*1.4976, speed);}
       
        }
    }
}

