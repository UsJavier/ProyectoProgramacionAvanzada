/**
*
*
*@Bryan Us
*/
package proyecto;
/*En esta parte creo mi Nodo tanto para mi lista como para mi Pila, con dos constructores
uno para cada almancenamiento dinamico*/
public class NodoRPN{
    public double dato;
    public String dato2;
    public NodoRPN link;
    public NodoRPN link2;
  public NodoRPN(double dato){
    this.dato = dato;
  }
  public NodoRPN(String dato2){
    this.dato2 = dato2;
  }
  public NodoRPN(String dato2, NodoRPN link2){
    this.dato2 = dato2;
    this.link2 = link2;
  }
  }
