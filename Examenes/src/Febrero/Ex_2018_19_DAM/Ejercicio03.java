/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Febrero.Ex_2018_19_DAM;

import java.util.Scanner;

/**
 * Examen DAM.
 * Comprobacion de c�digo.
 * @author salva
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        
//        String[] prueba = new String[10]; //- no tiene que hacerla el alumnado
        
        /* Generaci�n de c�digos de prueba - no tiene que hacerla el alumnado */        
//        char[] letters={'V','X'};
//        for (int i=0;i<prueba.length;i++)
//        {   
//            int i1=(int)(Math.random()*90+10);
//            int i2=(int)(Math.random()*900+100);            
//            char letra=letters[(i1*i2)%2];
//            prueba[i]=""+i1+"-"+i2+"-"+letra;            
//        }
        
        /* Comprobaci�n de los c�digos de prueba - no tiene que hacerla el alumnado*/
//        for (int i=0;i<prueba.length;i++)
//            checkCode(prueba[i]);
        
        /* C�digo a realizar por el alumnado */
        Scanner sc=new Scanner(System.in);        
        System.out.println("Introduce un n�mero un c�digo:");
        String codigo=sc.next().trim();
        checkCode(codigo);
        
           
    }   
    
    /**
     * M�todo que comprueba si el c�digo sigue el formato "NN-NNN-L".
     * (N es un n�mero y L es una letra que ser� V o X)
     * - Si (NN * NNN) % 2 es 0, L deber�a ser 'V'.
     * - Si (NN * NNN) % 2 es 1, L deber�a ser 'X'.
     * @param codigo c�digo a comprobar (distingo de null)
     */
    public static void checkCode (String codigo)
    {
        
        // Soluci�n admitida como correcta:
        String pattern="[0-9]{2}-[0-9]{3}-[VX]";
        // Soluci�n m�s completa:
        // String pattern="[1-9][0-9]{1}-[1-9][0-9]{2}-[VX]";
        if (codigo.matches(pattern))
        {
            String[] partes=codigo.split("-");
            int num=Integer.parseInt(partes[0])*Integer.parseInt(partes[1]);
            num=num%2;                      
            char letra=partes[2].charAt(0);
            if (num==0 && letra=='V' || num==1 && letra=='X')
            {
                System.out.printf("C�digo %s v�lido.\n",codigo);
            }
            else
            {
                System.out.println("C�digo no v�lido.");
            }
        } else {
            System.out.println("Formato de c�digo no v�lido.");
        }       
    }
}
