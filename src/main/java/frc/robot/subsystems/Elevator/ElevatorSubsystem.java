package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;

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



public void drive_to_pos(double desired_pos,double speed){  //desired pos should be 1.833 times the desired angle
    desired_pos = desired_pos;//1.92
    double current = getPos();
    double difference =  desired_pos-current;   
    double truespeed = speed*difference*.5;
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

