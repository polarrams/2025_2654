package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDs.LEDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import java.lang.Math;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;

public class ElevatorSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(19,MotorType.kBrushless);
    private PIDController m_pid = new PIDController(0.2, 0., 0.83);
    private RelativeEncoder c_up = motor1.getEncoder();
    
public void run(double speed){
motor1.set(speed);

}
public void setzero() { 
        
        c_up.setPosition(0);
    }
    public double getPos() {
      SmartDashboard.putNumber("Elevator Degrees", c_up.getPosition());
      return  c_up.getPosition();

      
    
}
public void run1(double speed) {
    motor1.set(speed);

}


public void drive_to_pos_fast(double pos, double speed, String color) {
    //pos is ending position, speed is max speed
    double current = getPos();
    m_pid.setSetpoint(pos);
    m_pid.setIntegratorRange(-.098, .098);
    double truespeed = MathUtil.clamp(m_pid.calculate(getPos(),pos), -.2, .2);
    if ((current <=0 && truespeed <0) || (current >= -260 && truespeed > 0)) {
        motor1.set(truespeed);
    }
    else {
        motor1.set(0);
    }
    
    SmartDashboard.getNumber("Elevator Speed", truespeed);
}
public void drive_to_pos(double desired_pos,double speed, String color){  //desired pos should be 1.833 times the desired angle
    desired_pos = desired_pos;//1.92
    double current = getPos();
    double difference =  desired_pos-current;   
    double truespeed = speed*difference*.5;
    SmartDashboard.getNumber("Elevator Speed", truespeed);
    
    SmartDashboard.putNumber("elevator difference", Math.abs(desired_pos - current));

    if (truespeed > speed){
        truespeed = speed;
    }
    if (truespeed < -speed){
        truespeed = -speed;
    }
    if (Math.abs(desired_pos - current) < 5) {
        SmartDashboard.putString("ReefColor", color);
        SmartDashboard.putBoolean("ReefReached", true);
    }
    else {
        SmartDashboard.putBoolean("ReefReached", false);
        if(truespeed < 0){
            SmartDashboard.putString("ReefColor", "Yellow_flashing");
        } else{
            SmartDashboard.putString("ReefColor", "Purple_flashing");
        }
    }
    if (Math.abs(difference)>10){
        motor1.set(truespeed);
    }else if (Math.abs(difference)<10){
        motor1.set(truespeed/5);
    }
    
    //else if (difference>0){
    //    motor1.set(truespeed);
    //}
    else{
        motor1.set(0);
    }



}

}

