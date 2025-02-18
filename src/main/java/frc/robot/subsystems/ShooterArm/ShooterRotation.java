package frc.robot.subsystems.ShooterArm;


import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import frc.robot.commands.ShooterArm.ShooterRotationCommand;


public class ShooterRotation extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(14,MotorType.kBrushless);
    private SparkMaxConfig config = new SparkMaxConfig();
    private RelativeEncoder m_Rotation = motor1.getEncoder();


public void run(double speed){
    motor1.set(speed);
    
    }
    public void drive_to_pos(double desired_pos,double speed, String armColor){  //desired pos should be 1.833 times the desired angle
        desired_pos = desired_pos /1.4976;//1.92
        SmartDashboard.putNumber("desired_pos", desired_pos);
        double current = getPos();
        double difference =  desired_pos-current;   
        SmartDashboard.putNumber("difference", difference);
        double truespeed = speed*difference*.5;
        SmartDashboard.putNumber("truespeed", truespeed);
        SmartDashboard.putString("ReefColor", armColor);
        if (Math.abs(desired_pos - current) < 5) {
            SmartDashboard.putBoolean("ReefReached", true);
        }
        else {
            SmartDashboard.putBoolean("ReefReached", false);
        }
        if (truespeed > speed){
            truespeed = speed;
        }
        if (truespeed < -speed){
            truespeed = -speed;
        }
        if (difference<0){
            motor1.set(truespeed);
        }
        else if (difference>0){
            motor1.set(truespeed);
        }
        else{
            motor1.set(0);
        }



    }

     public void setzero() { 
     m_Rotation.setPosition(0);
    }

    public double getPos() {
      SmartDashboard.putNumber("Shooter Arm Degrees", m_Rotation.getPosition());
      return  m_Rotation.getPosition();
    
    }

    public void mbrake(){
        config.idleMode(IdleMode.kBrake);
       
    }

    public void stop(){
        motor1.set(0);

    }
    public void p2(double n){
        motor1.set(n);

    }
 
}

