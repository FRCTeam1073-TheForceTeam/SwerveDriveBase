// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DiagnosticsSubsystem extends SubsystemBase implements Diagnostics {
  private boolean diagnosticsOk = false;
  private String diagnosticsDetails = "I was too lazy to implement diagnotics!";

  /** Creates a new Diagnostics. */
  public DiagnosticsSubsystem() {
  
  }

  @Override
  public boolean updateDiagnostics() { return false;}

  @Override 
  public boolean diagnosticsOk() {
    return this.diagnosticsOk;
  }

  @Override
  public String getDiagnosticsDetails(){
    return this.diagnosticsDetails;
  }

  public boolean setDiagnosticsFeedback(String diagnosticDetails, boolean ok) {
    this.diagnosticsDetails = diagnosticDetails;
    this.diagnosticsOk = ok;
    return this.diagnosticsOk;
  }
}
