package frc.robot.commands.Autos;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elevator.ElevatorArmSubsystem;

    public class ElevatorArmAuto extends Command{
        private ElevatorArmSubsystem m_ElevatorArmRotation;
        private double speed;
        private double pos;
    
        public ElevatorArmAuto(
                ElevatorArmSubsystem c_ElevatorArmRotation,
                double speed,
                double pos
              ) {
            this.m_ElevatorArmRotation = c_ElevatorArmRotation;
            this.speed = speed;
            this.pos = pos;
            addRequirements(m_ElevatorArmRotation);
            
        }
        @Override
        public void execute() {
            m_ElevatorArmRotation.drive_to_pos(pos, speed);
        }
        @Override
        public boolean isFinished() {
            m_ElevatorArmRotation.getPos();
            if(m_ElevatorArmRotation.getPos() - pos <= 0.5) {
                return true;
            }
            else {
                return false;
        }
    }
}