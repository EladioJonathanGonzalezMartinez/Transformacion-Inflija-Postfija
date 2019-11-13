/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfijo;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author remix
 */
public class ValorPostfijo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    Metodos op = new Metodos();
    System.out.println("*Escribe una expresión algebraica: ");
    String expresion = op.DepuarExpr(leer.nextLine());
    String[] arrayInfix = expresion.split(" ");

    Stack < String > E = new Stack < String > ();
    Stack < String > P = new Stack < String > ();
    Stack < String > S = new Stack < String > ();

    for (int i = arrayInfix.length - 1; i >= 0; i--) {
      E.push(arrayInfix[i]);
    }

    try {
      while (!E.isEmpty()) {
        switch (op.opera(E.peek())){
          case 1:
            P.push(E.pop());
            break;
        case 2:
            while(!P.peek().equals("(")) {
              S.push(P.pop());
            }
            P.pop();
            E.pop();
            break;
          case 4:
            while(op.opera(P.peek()) >= op.opera(E.peek())) {
              S.push(P.pop());
            }
            P.push(E.pop());
            break;  
          default:
            S.push(E.pop()); 
        } 
      }

      String infix = expresion.replace(" ", "");
      String postfix = S.toString().replaceAll("[\\]\\[,]", "");

      System.out.println("Expresion Postfija: " + postfix);
      System.out.println("Expresion Infija: " + infix);

    }catch(Exception ex){ 
      System.out.println("Error en la expresión");
      System.err.println(ex);
    }
  }
}
    

