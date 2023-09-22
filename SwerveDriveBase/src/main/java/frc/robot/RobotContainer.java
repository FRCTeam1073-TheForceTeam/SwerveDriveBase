// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTestCommand;
import frc.robot.commands.EngageBalance;
import frc.robot.commands.EngageDriveUp;
import frc.robot.commands.EngageForward;
import frc.robot.commands.ParkingBrake;
import frc.robot.commands.TeleopDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.SwerveModuleConfig;
import frc.robot.subsystems.OI;
import frc.robot.subsystems.SwerveModule;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final OI m_OI = new OI();
  private final TeleopDrive m_teleopCommand = new TeleopDrive(m_driveSubsystem, m_OI);

  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private static final String kCenterEngage = "CenterEngage";
  private static final String kNoAuto = "No Autonomous";
  
  /**
   * Robot container constructor
   * Set default commands, adds options to the auto chooser.
   */
  public RobotContainer() {
    CommandScheduler.getInstance().setDefaultCommand(m_driveSubsystem, m_teleopCommand);
   
    m_chooser.addOption("Center Engage", kCenterEngage);

    SmartDashboard.putData("Auto Chooser", m_chooser);
    configureBindings();
    //
  }

  // Initialize Preferences For Subsystem Classes:
  public static void initPreferences() {
    System.out.println("RobotContainer: init Preferences.");
    SwerveModuleConfig.initPreferences();
    DriveSubsystem.initPreferences();
    OI.initPreferences();
    SwerveModule.initPreferences();
  }

  public void diagnostics() {
    
    String driveSubDiagnostics = m_driveSubsystem.getDiagnostics();
    String oiDiagnostics = m_OI.getDiagnostics();


    SmartDashboard.putString("Diag/Drive Subsystem", driveSubDiagnostics);
    SmartDashboard.putString("Diag/OI", oiDiagnostics);

  }

  // called when robot initializes. Sets parking brake to false
  public void teleopInit() {
    m_driveSubsystem.parkingBrake(false);
  }

  public void disableInit() {
  }

  // Configures the button mappings for controllers
  private void configureBindings() {
    System.out.println("RobotContainer: configure Bindings");

    }

  /**
   * Sets test mode
   */
  public void setTestMode() {
    DriveTestCommand dtc = new DriveTestCommand(m_driveSubsystem, m_OI);
    dtc.schedule();
    System.out.println("Robot Container: Test mode set");
  }

  public Command getAutonomousCommand(){
      System.out.println(String.format("Autonomous Command Selected: %s", m_chooser.getSelected()));

      switch (m_chooser.getSelected()) {
        case kNoAuto:
          return null;
        case kCenterEngage:
          return centerEngage();
        default:
          System.out.println("No Auto Selected -_-");
          return null;
      }
  }

  /**
   * Sets the bling and underglow of the Robot on startup. Underglow to the color
   * of the alliance.
   * bling to green if shoulder angle initializes correctly and red if it doesn't.
   */
  public void setStartupLighting() {
  }

  public Command centerEngage(){
    return new SequentialCommandGroup(
      new EngageDriveUp(m_driveSubsystem, 0.4, false),
      new EngageForward(m_driveSubsystem, 0.4, false),
      new EngageBalance(m_driveSubsystem, 0.4, false),
      new ParkingBrake(m_driveSubsystem, false));
  }
}
