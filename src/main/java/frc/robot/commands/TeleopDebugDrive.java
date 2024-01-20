// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.OI;

public class TeleopDebugDrive extends Command {

  DriveSubsystem driveSubsystem;
  OI oi;
  /** Creates a new TeleopDebugDrive. */
  public TeleopDebugDrive(DriveSubsystem driveSubsystem, OI oi){

    this.driveSubsystem = driveSubsystem;
    this.oi = oi;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double joystickY = oi.getDriverLeftY() * 0.3;
    double joystickX = oi.getDriverRightX() * 0.3;

    joystickY = MathUtil.clamp(joystickY, -0.3, 0.3);
    joystickX = MathUtil.clamp(joystickX, -0.3, 0.3);

    driveSubsystem.setDebugDrivePower(joystickY);
    driveSubsystem.setDebugAngle(joystickX);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
