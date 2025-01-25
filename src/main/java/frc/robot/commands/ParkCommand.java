package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ParkSub;

public class ParkCommand extends Command {
    private final ParkSub m_ParkSub;
    private double speed;
    private double pos;
    
public ParkCommand(ParkSub c_ParkSub, double speed, double pos){
    this.m_ParkSub = c_ParkSub;
    this.speed = speed;
    this.pos = pos;
    addRequirements(c_ParkSub);
}

@Override
    public void execute(){
        m_ParkSub.Rpark(pos,speed);
        m_ParkSub.Dpark(speed = 0);
}
}
