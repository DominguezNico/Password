package passwords;

import java.util.ArrayList;
import java.util.Scanner;

public class PasswordImplementacion {

	public PasswordImplementacion() {
		
	}

		public static void Armar(int n,String contraseña_usuario) {
			ArrayList<Character> c=new  ArrayList<Character>();
			c.add('A');			c.add('a');		c.add('0');		c.add('+');
			c.add('B');			c.add('b');		c.add('1');		c.add('-');
			c.add('C');			c.add('c');		
			
			c.add('2');			c.add('*');
			c.add('D');			c.add('d');		c.add('3');		c.add('/');
			c.add('E');			c.add('e');		c.add('4');		c.add('%');
			c.add('F');			c.add('f');		c.add('5');		c.add('&');
			c.add('G');			c.add('g');		c.add('6');
			c.add('H');			c.add('h');		c.add('7');
			c.add('I');			c.add('i');		c.add('8');
			c.add('J');			c.add('j');		c.add('9');
			c.add('K');			c.add('k');
			c.add('L');			c.add('l');
			c.add('M');			c.add('m');
			c.add('N');			c.add('n');
			c.add('O');			c.add('o');
			c.add('P');			c.add('p');
			c.add('Q');			c.add('q');
			c.add('R');			c.add('r');
			c.add('S');			c.add('s');
			c.add('T');			c.add('t');
			c.add('U');			c.add('u');
			c.add('V');			c.add('v');
			c.add('W');			c.add('w');
			c.add('X');			c.add('x');
			c.add('Y');			c.add('y');
			c.add('Z');			c.add('z');
			
			boolean password_valida;
			if(n<4||(contraseña_usuario.length()<4))
				password_valida=false;
			
			else {
				char[] p= new char[n];		
				 password_valida=false;
				password_valida=recursiva(p,0,n,c,contraseña_usuario,password_valida);			//O(n a**n)
			
			}
			
			if(password_valida==true) {
				System.out.println("");
				System.out.println("Su contraseña es valida");
			}
			else
				System.out.println("Contraseña poco segura ");
		
		}
		
		

		public static boolean recursiva( char[] p, int i,int n ,ArrayList<Character> caracteres,String  contraseña_usuario,boolean password_valida ) {
			if (i==n) {
				if(esvalida(p) )	{												//k=1  a= cant caracteres m  b= 1 caso suma:  O(n a**n)		
																			
					if(contraseña_usuario.equals(String.valueOf(p))){
						System.out.println(String.valueOf(p));
						return password_valida=true;
					}
				}
			}
			
			else {
				int x=0;
				while(x<caracteres.size() && password_valida==false) {
					p[i]= caracteres.get(x);									
					
					password_valida=recursiva(p, i + 1, n,caracteres,contraseña_usuario, password_valida );
					x++;
					}
				}
			
			return password_valida;
		}
		
		
		
		public static boolean esvalida(char[] p) {		// costo O(n)
			boolean valida=false;
			boolean mayuscula=false;
			boolean minuscula=false;
			boolean numero=false;
			
			int cant_caract=0;
			
			int j=0;
			while(j<p.length && cant_caract<2) {
				
				if(Character.isDigit(p[j])==true)
					numero=true;
				
				if(Character.isLetter(p[j])==true) {
					if(Character.isUpperCase(p[j])==true)
						mayuscula=true;
					else {
						minuscula=true;
					}
				}
				if(isSimbolo(p[j])==true) {
					
					cant_caract++;
				}
				j++;
			}
			
			if(numero==true && mayuscula==true &&minuscula==true && cant_caract==1)
				valida=true;
			
			return valida;	
				
		}
		
		
		
		private static boolean isSimbolo(Character c) {					// costo O(n)
			boolean es=false;
			char carac[]= new char[6];
			carac[0]='+';
			carac[1]='-';
			carac[2]='*';
			carac[3]='/';
			carac[4]='%';
			carac[5]='&';
			for(int i=0; i<6;i++) {
				if(c==carac[i])
					es=true;
			}
			return es;
		}
		
		
		public static void main(String[] args) {
			System.out.println(" Verifique si su contraseña es segura  ");
			System.out.println("Ingrese una contraseña: ");
			Scanner ent = new Scanner(System.in);
			String contraseña_usuario = ent.nextLine();
			
			System.out.println("Ingrese la cantidad de caracteres que posee su contraseña (mayor o igual a 4): ");
			Integer n=ent.nextInt();
			ent.close();
			Armar(n,contraseña_usuario);										//O(n a**n)
		}
	}


