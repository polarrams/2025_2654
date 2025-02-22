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
import frc.robot.subsystems.ShooterArm.ShooterSubsystem;



public class AprilTagCmd extends Command {
    //declare variables in this. format and through subsystem here.
    private final ShooterRotation m_ShooterRotation;
    private final double pos;
    private final double speed;
    private final boolean reset;
    private final LimeLightSubsystem m_LimeLight;
    private final ShooterSubsystem m_ShooterSubsystem;
    private String armColor;

    public AprilTagCmd(
    ShooterRotation c_ShooterRotation,
    double pos,
    double speed,
    boolean reset,
    LimeLightSubsystem c_LimeLight,
    ShooterSubsystem c_ShooterSubsystem,
    String armColor
    ) {
    this.armColor = armColor;
    this.m_ShooterRotation = c_ShooterRotation;
    this.pos = pos;
    this.speed = speed;
    this.reset = reset;   
    this.m_LimeLight = c_LimeLight;
    this.m_ShooterSubsystem = c_ShooterSubsystem;
    addRequirements(m_ShooterRotation,m_LimeLight,m_ShooterSubsystem);
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
    m_ShooterRotation.drive_to_pos(pos, speed, armColor);
   
   
    double[] SpeakerAprilTag = m_LimeLight.limelight();
    //double x = SpeakerAprilTag[0];
    double y = SpeakerAprilTag[1];
    double Area = SpeakerAprilTag[2];
    double Tid = SpeakerAprilTag[3];
    double DPOS = 0;
    // Optional<Alliance> ally = DriverStation.getAlliance();
    // if (ally.isPresent()){
            // if(ally.get() == Alliance.Red){
                SmartDashboard.putNumber("TID", Tid);
                if(Tid == 5 ||Tid == 15 || Tid == 4||Tid == 14){
                  if (y >= 16){double angle = (Math.abs(14 - Math.asin((  y  -14 )/14)*9));
                    m_ShooterRotation.drive_to_pos(angle,speed, armColor);
                    SmartDashboard.putNumber("Shooter Arm Angle Equation", angle);
                    m_ShooterSubsystem.run(-0.57);
                  }
                  else if (y < 16 && y > 19){double angle = (Math.abs(12 - Math.asin((  y  -12 )/12)*7.7));
                    m_ShooterRotation.drive_to_pos(angle,speed,armColor);
                   
                    m_ShooterSubsystem.run(-0.6);}
                  else if (y < 19){double angle = (Math.abs(10 - Math.asin((  y  -10 )/10)*6.4));
                    m_ShooterRotation.drive_to_pos(angle,speed,armColor);
                   
                    m_ShooterSubsystem.run(-0.7);}
                }
             
            
     }
    }
  

