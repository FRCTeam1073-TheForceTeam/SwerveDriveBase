// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Diagnostics extends SubsystemBase {
  private boolean ok;
  private String diagnosticResult;
  /** Creates a new Diagnostics. */
  public Diagnostics() {
    ok = false;
    diagnosticResult = "";
  }

  public void runDiagnostics(){}

  public boolean isOK(){
    return ok;
  }

  public String getDiagnosticResult(){
    return diagnosticResult;
  }

  public void setOK(boolean ok){
    this.ok = ok;
  }

  public void setDiagnosticResult(String diagnosticResult){
    this.diagnosticResult = diagnosticResult;
  }
}
