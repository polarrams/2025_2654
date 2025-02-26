package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.LEDs.LEDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import java.lang.Math;

public class ElevatorSubsystem extends SubsystemBase{
    private SparkMax motor1 = new SparkMax(19,MotorType.kBrushless);
    
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
    SmartDashboard.putString("ReefColor", color);
    double m_speed, error, posCurrent, kpc;
    double kp = 0.05, kp1 = .01; // p multiplier constant
    double deadBand = 2, minSpeed = 0.05;//motor deadband, min speed,
    double lowError = 100;// lowError for slow position approach
    double current = getPos();
    double minSpeedPos = 0.05, minSpeedNeg = -0.05;
    posCurrent = getPos();//get current motor position
    error = pos - posCurrent;//find count error
    if (Math.abs(pos - current) < 5) {
        SmartDashboard.putBoolean("ReefReached", true);
    }
    else {
        SmartDashboard.putBoolean("ReefReached", false);
    }
    if(error > lowError || error < -lowError){//motor speed calculated from error with higher kp value
        kpc = kp;
    }
    else {
        kpc = kp1;
    }
    m_speed = speed* kp1* error;//calculate motor speed
    //limit speed positve and negative
    if(m_speed > speed && speed > 0){//pos limit
        m_speed = speed;
    }
    else if(m_speed < speed && speed < 0){//neg limit
        m_speed = speed;
    }
    //minimum speed
    if(m_speed > 0 && m_speed < minSpeedPos){//pos minimum
        m_speed = minSpeed;
    }
    if(m_speed < 0 && m_speed < minSpeedNeg){//neg minimum
        m_speed = -minSpeed;
    }
    
    //deadband - dont move motor when in deadband
    //can be left out if you want motor to constantly drive to position
    if(error < deadBand || error > -deadBand){
        m_speed = 0;
    }
}
public void drive_to_pos(double desired_pos,double speed, String color){  //desired pos should be 1.833 times the desired angle
    desired_pos = desired_pos;//1.92
    double current = getPos();
    double difference =  desired_pos-current;   
    double truespeed = speed*difference*.5;
    SmartDashboard.getNumber("Elevator Speed", truespeed);
    SmartDashboard.putString("ReefColor", color);
    SmartDashboard.putNumber("elevator difference", Math.abs(desired_pos - current));
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

}

