/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numerosenlletra;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Programa: numerosEnLletra.java
L’objectiu de la pràctica és fer un programa que passe una quantitat de 3 xifres a lletres.
Exemples:
483 quatre-cents huitanta-tres
950 nou-cents cinquanta
300 tres-cents
121 cent vint-i-un
Per a fer això, primer hauràs d’implementar unes funcions i utilitzar-les després. Seguix
els següents passos:
1.- Implementa les següents funcions:
EXEMPLE FUNCIÓ DESCRIPCIÓ ENTRADA EIXIDA
A partir d’una quantitat,
static int digitUnitats(int n)
483 3
483 8
483 4
retorna la xifra de les unitats.
A partir d’una quantitat,
static int digitDesenes(int n)
retorna la xifra de les desenes.
A partir d’una quantitat,
static int digitCentenes(int n)
retorna la xifra de les centenes.
static String desenaEnLletres(int n) A partir d’un dígit corresponent a 8 huitanta
                                        una desena, el retorna en lletra. 
static String digitEnLletres(int n) A partir d’un dígit (no 3 tres
                                       corresponent a una desena), el 
                                       retorna en lletra. 
Notes:
Les funcions han de dir-se exactament així i fer exactament el que diu la taula.
Si ho creus convenient, pots afegir més funcions.
2.- Fes el programa principal (funció main):
- Demanar una quantitat de 3 xifres.
- Cridar a la funció quantitatEnLletres(quantitat) (que implementaràs després) i
    guardar el resultat retornat en una variable de tipus String.
- Mostrar per pantalla eixa variable.
3.- Implementa la funció quantitatEnLletres:
EXEMPLE
FUNCIÓ
DESCRIPCIÓ
ENT 
static String quantitatEnLletres(int n)
-
A partir d’una quantitat
de 3 xifres, la retorna en
lletra.
EIXIDA
483 quatre-cents huitanta-tres
Recorda la lletra D-U-C. És a dir, el guionet només va entre Desenes-Unitats i
entre Unitats i Centenes. Per exemple:
Huitanta-quatre mil nou-cents seixanta-dos
D- U M U- C D - U 
* - Per a implementar esta funció cal anar construint una variable de tipus String on
  anirem composant la quantitat en lletres. Ajuda’t fent crides a les funcions que
   has fet anteriorment.
- Finalment, cal retornar eixa variable de tipus String.
4.- Part opcional. Millora la funció quantitatEnLletres perquè es puguen convertir
quantitats de més de 3 xifres. Posa tu el límit de xifres.
Heu de penjar la vostra solució al Moodle en un fitxer que es diga així:
elmeunomNumerosEnLletra.java

 * @author Raül Mulet i Enguix
 */
public class NumerosEnLletra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int numero=-1;
       String lletres="";
       boolean error;
       do
             {  
                 error=false;
                System.out.print("Donam un numero no major de 9 cifres per a passar-te'l a lletra: ");
                try{
                numero=llegirInt();
                }
                catch(InputMismatchException e){
                    System.out.println("error, no has introduït un numero natural");
                    error=true;
                }
             }while(error==true);
        if(numero==0)
            {
                lletres+=" zero";
            }
        else// si no es un 0
            {
                if(numero>999999)//si hi han milions
                    {
                        switch(numero/1000000)//3 primeres cifres a partir del milió
                        {
                            case 1://1 milió i algo
                                if((numero%1000000)/1000==0)//si les 3 cifes del mil són 000
                                    {
                                        lletres=numeroEnLletres(numero/1000000)+" milió "+numeroEnLletres(numero%1000);
                                    }
                                else// si hi han cifres en la part del mil
                                     {
                                        if((numero%1000000)/1000==1)
                                            {
                                                lletres=numeroEnLletres(numero/1000000)+" milió "+"mil "+numeroEnLletres(numero%1000);

                                            }
                                        else{
                                                lletres=numeroEnLletres(numero/1000000)+" milió "+numeroEnLletres((numero%1000000)/1000)+" mil "+numeroEnLletres(numero%1000);
                                            }
                                     }
                                break;
                                
                            default://més d'un milió, milions i algo
                                if((numero%1000000)/1000==0)//si les 3 cifes del mil són 000
                                    {
                                        lletres=numeroEnLletres(numero/1000000)+" milions "+numeroEnLletres(numero%1000);
                                    }
                                else// si hi han cifres en la part del mil
                                     {
                                        if((numero%1000000)/1000==1)
                                            {
                                                lletres=numeroEnLletres(numero/1000000)+" milions "+"mil "+numeroEnLletres(numero%1000);

                                            }
                                        else
                                            {
                                         lletres=numeroEnLletres(numero/1000000)+" milions "+numeroEnLletres((numero%1000000)/1000)+" mil "+numeroEnLletres(numero%1000);
                                            }
                                     }
                        }

                    }
                else
                     {
                        if(numero>999)//si mil
                            {
                                if(numero/1000==1)// si es 1000 i algo
                                    {
                                       lletres="mil "+numeroEnLletres(numero%1000);
                                    }
                                else
                                    {
                                        lletres=numeroEnLletres(numero/1000)+" mil "+numeroEnLletres(numero%1000);
                                    }
                            }
                        else
                            {
                                lletres=numeroEnLletres(numero);
                            }
                     }
            }
        mostraLletres(lletres);
       
    }

    static int llegirInt(){
     Scanner teclat= new Scanner(System.in);
     int enter;
     enter=teclat.nextInt();
     return enter;
     }
    
    static int digitCentenes(int n){
        return n/100;
    }
    
    static int digitDecenes(int n){
       
        return (n%100)/10;
       
    }
    
    static int digitUnitats(int n){
        return n%10;
        
    }
    
    static String deDeusEnLletres(int unitat){
       String lletra="";
        switch(unitat)
                        {
                        case 0:
                            lletra="deu";break;
                        case 1:
                            lletra="onze";break;
                        case 2:
                            lletra="dotze";break;
                        case 3:
                            lletra="tretze";break;
                        case 4:
                            lletra="catorze";break;
                        case 5:
                            lletra="quinze";break;
                        case 6:
                            lletra="setze";break;
                        case 7:
                            lletra="dèsset";break;
                        case 8:
                            lletra="dihuit";break;
                        case 9:
                            lletra="dèneu";break;
                                                }
        return lletra;

    }
    
    
    
    static String decenaEnLletres(int decena){
        String lletra="";
        switch(decena)
            {
                  case 2:
                        lletra="vint";break;
                  case 3:
                        lletra="trenta";break;
                  case 4:
                        lletra="quaranta";break;
                  case 5:
                        lletra="cinquanta";break;
                  case 6:
                        lletra="seixanta";break;
                  case 7:
                        lletra="setanta";break;
                  case 8:
                        lletra="huitanta";break;
                  case 9:
                        lletra="noranta";break;
                  default: 
                      return lletra;
            }
        
        return lletra;
    }
    
    static String digitEnLletres(int n){
          String lletra="";
          switch(n)
               {
                   case 1:
                       lletra="un";break;
                   case 2:
                       lletra="dos";break;
                   case 3:
                       lletra="tres";break;
                   case 4:
                       lletra="quatre";break;
                   case 5:
                       lletra="cinc";break;
                   case 6:
                       lletra="sis";break;
                   case 7:
                       lletra="set";break;
                   case 8:
                       lletra="huit";break;
                   case 9:
                       lletra="nou";break;
                   default:
                       return lletra;
                        }  
          return lletra;
        
    }
    static void mostraLletres(String lletra){
        System.out.println("***********************************************************************************");
        System.out.println(" ________________________________________________________________________________\n");
        System.out.println("  "+lletra);
        System.out.println(" __________________________________________________________________________________");

    }
    
    static String numeroEnLletres(int n3xifres){
        String lletres="";
        
      
       switch(digitCentenes(n3xifres))
        {
           case 0:
               switch(digitDecenes(n3xifres))
                    {
                        case 0:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        return lletres;
                                    }
                               break;
                        case 1:
                                lletres+=deDeusEnLletres(digitUnitats(n3xifres));//fica 10 ... 19
                                return lletres;
                                
                        case 2:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=decenaEnLletres(digitDecenes(n3xifres))+"-i-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                        default:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=decenaEnLletres(digitDecenes(n3xifres))+"-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                    }
               break;
               
           case 1:
               lletres="cent";
                           
               switch(digitDecenes(n3xifres))
                    {
                        case 0:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        return lletres;
                                    }
                               break;
                        case 1:
                                lletres+=" "+deDeusEnLletres(digitUnitats(n3xifres));//fica 10 ... 19
                                return lletres;
                        case 2:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres))+"-i-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                        default:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres))+"-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                    }
               break;
           default:
                    lletres=digitEnLletres(digitCentenes(n3xifres))+"-cents";
                    switch(digitDecenes(n3xifres))
                    {
                        case 0:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        return lletres;
                                    }
                               break;
                        case 1:
                                lletres+=" "+deDeusEnLletres(digitUnitats(n3xifres));//fica 10 ... 19
                                return lletres;
                        case 2:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres))+"-i-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                        default:
                                if(digitUnitats(n3xifres)!=0)
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres))+"-"+digitEnLletres(digitUnitats(n3xifres));
                                    }
                                else
                                    {
                                        lletres+=" "+decenaEnLletres(digitDecenes(n3xifres));
                                    }
                               break;
                    }
               break;
               
               
               
               
               
               
        }
      return lletres;
    }

}
