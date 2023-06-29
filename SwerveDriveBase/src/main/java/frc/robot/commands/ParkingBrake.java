package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ParkingBrake extends CommandBase
{
    DriveSubsystem drivetrain;
    boolean releaseOnEnd;


    public ParkingBrake(DriveSubsystem ds, boolean releaseOnEnd)
    {
        this.drivetrain = ds;
        this.releaseOnEnd = releaseOnEnd;
        addRequirements(ds);
    }

    @Override
    public void initialize()
    {
        drivetrain.parkingBrake(true); // turns on the parking brake
    }

    @Override
    public void execute()
    {
    
    }

    @Override
    public void end(boolean interrupted)
    {
        if (releaseOnEnd == true){
        drivetrain.parkingBrake(false); // turns off the parking brake
        }
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
}
