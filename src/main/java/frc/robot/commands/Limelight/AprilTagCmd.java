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
    private final ShooterSubsystem m_ShooterSubsystem;
    private final double pos;
    private final double speed;
    private final boolean reset;
    private final LimeLightSubsystem m_LimeLight;
    private String armColor;

    public AprilTagCmd(
    ShooterSubsystem c_ShooterSubsystem,
    ShooterRotation c_ShooterRotation,
    double pos,
    double speed,
    boolean reset,
    LimeLightSubsystem c_LimeLight,
    String armColor
    ) {
    this.armColor = armColor;
    this.m_ShooterRotation = c_ShooterRotation;
    this.pos = pos;
    this.speed = speed;
    this.reset = reset;   
    this.m_LimeLight = c_LimeLight;
    this.m_ShooterSubsystem = c_ShooterSubsystem;
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
    m_ShooterRotation.drive_to_pos(pos, speed, armColor);
   
   
    double[] SpeakerAprilTag = m_LimeLight.limelight();
    //double x = SpeakerAprilTag[0];
    double y = SpeakerAprilTag[1]; // y angle 
    double Area = SpeakerAprilTag[2];
    double Tid = SpeakerAprilTag[3];
    double DPOS = 0;
    double AngleOffset = -30;
    double v0;
    // Optional<Alliance> ally = DriverStation.getAlliance();
    // if (ally.isPresent()){
            // if(ally.get() == Alliance.Red){
                SmartDashboard.putNumber("TID", Tid);
                if(Tid == 5 ||Tid == 15 || Tid == 4||Tid == 14){
                // 0. GET X DISTANCE 
                    double targetOffsetAngle_Vertical = y;
                    // how many degrees back is your limelight rotated from perfectly vertical?
                    double limelightMountAngleDegrees = 19.0; // mounted at 19 degrees
                    // distance from the center of the Limelight lens to the floor
                    double limelightLensHeightInches = 7.5; //7.5 inches
                    // distance from the target to the floor
                    // 10.5 feet in inches = 126
                    double goalHeightInches = 126; 
                    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
                    // angle in radians
                    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);
                    //calculate distance distanceFromLimelightToGoalInches
                    double x = (goalHeightInches - limelightLensHeightInches) / Math.tan(angleToGoalRadians);
                
                // 1. SET VELOCITY 
                    // max distance is 345.5
                    if(x < 60){ // less than 20 inches
                        v0 = 0; // LEAVE AT ZERO. TOO CLOSE TO BE ACCURATE
                    }
                    else if (x < 120){ // greater than 20 in. but less than 120 in.
                        v0 = 394; // MODIFY IF NEEDED
                    }
                    else if (x < 217){ // greater than 120 in. but less than 217 in.
                        v0 = 472; // MODIFY IF NEEDED 
                    }
                    else if (x < 315){ // greater than 217 in. but less than 315 in.
                        v0 = 827; // MODIFIED IF NEEDED 
                    }
                    else { // greater than 315 in. 
                        v0 = 0; // TOO FAR TO SHOOT 
                    }           
                // 2. CALCULATE ANGLE
                    double g = 386; // 386 in/s
                    double h = goalHeightInches; // height we want ball to hit
                    double d = x + 19.5; // distance we want ball to hit: x distance with half the trough depth added
                    double theta = Math.atan(((v0*v0)+ Math.sqrt((v0*v0*v0*v0)-g*(g*(x*x)+2*h*(v0*v0)))/(g*d)));
                    double angle = theta / (-3); // conversion to motor rotations with shooter straight forward as zero
    v0 = v0 / 1181; // convert in/sec to motor speed
 
                // 3. SHOOT 
                    m_ShooterRotation.drive_to_pos(angle,speed,armColor);
                    m_ShooterSubsystem.run(v0);
 
        }  
     }
    }    
  
