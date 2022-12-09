/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labrepop1_uliseslargaespada;

/**
 *
 * @author ularg
 */
public class Carro {
  String numeroVIN;
  String marca;
  String model;
  String color;
  int year;

  public Carro(String numeroVIN, String marca, String model, String color, int year) {
    this.numeroVIN = numeroVIN;
    this.marca = marca;
    this.model = model;
    this.color = color;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Carro{" + "numeroVIN=" + numeroVIN + ", marca=" + marca + ", model=" + model + ", color=" + color + ", year=" + year + '}';
  }

  public String getNumeroVIN() {
    return numeroVIN;
  }

  public void setNumeroVIN(String numeroVIN) {
    this.numeroVIN = numeroVIN;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
  
  
  
}
