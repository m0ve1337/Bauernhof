package Loesung_Serialisieren;

import java.io.Serializable;

public class Auto extends Fahrzeug implements Serializable {

  private static final long serialVersionUID =
    -8218730653685179327L;

  private String farbe;
  
  private Motor motor;
  
  public Auto(String farbe, Motor motor) {
    super("ZH 123");
    this.farbe = farbe;
    this.motor = motor;
  }
  
  public String getFarbe() {
    return farbe;
  }
  
  public Motor getMotor() {
    return motor;
  }
  
}
