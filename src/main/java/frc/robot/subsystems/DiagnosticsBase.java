package frc.robot.subsystems;

public class DiagnosticsBase implements Diagnostics {
    private boolean diagnosticsOk = false;
    private String diagnosticsDetails = "I was too lazy to implement diagnotics!";
  
    /** Creates a new Diagnostics. */
    public DiagnosticsBase() {
    
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
  
    public boolean setDiagnosticsFeedback(String diagnosticDetails, boolean ok){
      this.diagnosticsDetails = diagnosticDetails;
      this.diagnosticsOk = ok;
      return this.diagnosticsOk;
    }   
    
}
