package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LifterSubsystem;

public class LifterCommand extends Command{
    private final LifterSubsystem m_LifterSubsystem;
    private double m_speed1;
    public LifterCommand(
        LifterSubsystem c_LifterSubsystem,
        double c_speed1


    )
    {
        this.m_LifterSubsystem = c_LifterSubsystem;
        this.m_speed1 = c_speed1;
        addRequirements(m_LifterSubsystem);
    }
   
    
    @Override
    public void execute() {
    //m_LifterSubsystem.run(m_speed1);
    m_LifterSubsystem.getPos();
    double Lifter_pos = SmartDashboard.getNumber("Lifter Degrees",0);
    if (Lifter_pos <=120 && Lifter_pos >= -60){
        m_LifterSubsystem.run1(m_speed1);
    }
    else if (Lifter_pos >=120 && Lifter_pos >= -60){
        if (m_speed1 < 0){
        m_LifterSubsystem.run1(m_speed1);
        }
        else{m_LifterSubsystem.run1(0);
        }
    }
    else if (Lifter_pos <=120 && Lifter_pos <= -60){
        if (m_speed1 > 0){
        m_LifterSubsystem.run1(m_speed1);
        }
      else{m_LifterSubsystem.run1(0);
        }
    }
    else{m_LifterSubsystem.run1(0);}
    }
}