package model;

public class Dados{
  public double alt;
  public double peso;
  public double imc;

  public Dados(){
    super();
  }

  public double getAlt(){
    return this.alt;
  }

  public double getPeso(){
    return this.peso;
  }

  public double getImc(){
    return this.imc;
  }

  public void setAlt(double alt){
    this.alt = alt;
  }

  public void setPeso(double peso){
    this.peso = peso;
  }

  public void setImc(double imc){
    this.imc = imc;
  }
}