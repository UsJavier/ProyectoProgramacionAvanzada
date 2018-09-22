/**
*
*
*@Bryan Us
*/
package proyecto;
import java.util.*;
import java.io.*;
public class RPN implements Pila,Lista{
    public NodoRPN inicio,fin;
    public int tamanio = 0;
    public double Total = 0.0;
    public double value1,value2;
    public String Operador;
    public RPN(){
      inicio=null;
      fin=null;
    }
    // En este metodo separa el String ingresado en main para separarlo por espacio
public double MetodoRPN(String Cadena){
  System.out.println("The Reverse Polish Notation is: " + Cadena + " y se evalua de izquierda a derecha.");
  System.out.println("Puedes encontrar mas de este tema en el siguiente link https://es.wikipedia.org/wiki/Notaci%C3%B3n_polaca_inversa");
  StringTokenizer st =new StringTokenizer(Cadena);
  System.out.println("Tokens count: " + st.countTokens());
  while(st.hasMoreElements()) {
  String token = st.nextElement().toString();
  /* Dentro de este metodo una vez separado por el espacio, comparo los operadores
  sin importar letras mayusculas y opero segun sea el caso*/
     String Operador = token;
     try{
     switch (Operador.toUpperCase()) {
       case "PLUS":
          value1 = inicio.dato;
          inicio = inicio.link;
          value2 = inicio.dato;
          inicio = inicio.link;
          Total = value1 + value2;
          push(Total);
          System.out.println("Result of Plus: "+Total);
          break;
       case "LESS":
          value1 = inicio.dato;
          inicio = inicio.link;
          value2 = inicio.dato;
          inicio = inicio.link;
          Total = value1 - value2;
          push(Total);
          System.out.println("Result of Less: "+Total);
          break;
       case "TIMES":
          value1 = inicio.dato;
          inicio = inicio.link;
          value2 = inicio.dato;
          inicio = inicio.link;
          Total = value1 * value2;
          push(Total);
          System.out.println("Result of Times: "+Total);
          break;
       case "DIVIDE":
          value1 = inicio.dato;
          inicio = inicio.link;
          value2 = inicio.dato;
          inicio = inicio.link;
          Total = value1 / value2;
          push(Total);
          System.out.println("Result of Divide: "+Total);
          break;
       default:
          double number = Double.parseDouble(token);
          push(number);
          break;
          }
          }catch (Exception e) {
        /* Aca esta mi exception en dado caso el operador ingrese un operador aritmetico
        que no se encuentre dentro de lo que pide el problema */
         System.out.println("- Exception occurred -");
         System.out.println("- We can continue operating if the others ones are correct -");
         System.out.println("- in other words please double check number/arithmetic operator -");
          }
          }
          System.out.println("Result of Reverse Polish Notation: " + Total);
          String totalString = String.valueOf(Total);
          //Aca envio a mi lista
          addInicio(totalString);
        return 0.d;
          }
    // agrega un elemento a la Pila
    public void push(double valor){
          NodoRPN nuevo = new NodoRPN(valor);
            nuevo.dato = valor;
            //es el primer elemento
            if(inicio == null){
              nuevo.link = null;
              inicio = nuevo;
            } else{ //Ya existe elementos
              nuevo.link = inicio;
              // el nuevo elemento es el inicio de la Pila
              inicio = nuevo;
            }
            tamanio++;
          }
    // Metodo agregar de la lista
    public void addInicio(String dato2){
      inicio = new NodoRPN(dato2, inicio);
      if(fin==null){
        fin=inicio;
      }
    }
    //Metodo para imprimir un text
    public void imprimirLista(){
      NodoRPN recorrer = inicio;
      try{
        FileOutputStream texto = new FileOutputStream("Proyecto_Programacion_Avanzada.txt");
        PrintStream File = new PrintStream(texto);
        while(recorrer!=null){
          File.println("["+recorrer.dato2+"]--->");
          recorrer=recorrer.link2;
        }
          } catch(FileNotFoundException fnfe) {
                  System.out.println(fnfe);
                                              }
      }
public static void main(String[]args){
  String Cadenaa = "3 2 1.5 TIMES 3 DIVIDE TIMES";
  RPN Prueba = new RPN();
  Prueba.MetodoRPN(Cadenaa);
  Prueba.addInicio(Cadenaa);
  Prueba.imprimirLista();
}
}
