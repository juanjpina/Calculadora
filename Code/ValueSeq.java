package es.uned.lsi.eped.pract2018_2019;

import es.uned.lsi.eped.DataStructures.List;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.Stack;

public class ValueSeq extends Value {
	
	
	
	
	Stack<String> value; 
	
	/* Constructor: recibe un String con el valor numérico */
	public ValueSeq(String s) {
		super();		
		value = new Stack<String>();
		value.push(s);
	
	}
	
	/* Método que transforma el valor numérico en un String */
	public String toString() {
	
		return value.getTop();
	}

	
	/* Método que modifica el valor numérico llamante, sumándole el valor numérico parámetro */
	public void addValue(Value n) {
		Stack<Integer> n1 = new Stack<Integer>();	
		Stack<Integer> n2 = new Stack<Integer>();	
		Stack<Integer> resul = new Stack<Integer>();
		Queue<Integer> acarreo = new Queue<Integer>();
		String valor="";
		Integer total;
		Integer a=0,b=0;		
		int a1= value.getTop().toString().length();
		int a2 =n.toString().length();
		
	//comprueba longitud de n y relleno de zeros a la izquierda 			
		if(a1>a2) {
			 int vf =a1-a2;
			 for(int x=1; x<=vf; x++) {
				 n2.push(0); 
			 }
		}else if(a1<a2) {
			int vf =a2-a1;
			 for(int x=1; x<=vf; x++) {
				 n1.push(0); 
			 }
		 }
		
	// insertar en pila  
	 if(!value.isEmpty()) {
		 for(int i=0; i<=a1-1; i++) {		   
			    n1.push(Integer.parseInt(Character.toString(value.getTop().charAt(i))));}
					}
	
	// insertar en pila
	if(!n.toString().isEmpty()) {
		for(int i=0; i<=a2-1; i++) {
			n2.push(Character.getNumericValue(n.toString().charAt(i)));	}		
				}
		
			
	//cuerpo de programa principal
do {
		if(!n1.isEmpty()) {a=(n1.getTop());}
		if(!n2.isEmpty()) {b=(n2.getTop());}
			
			if(a==0) {total=b;}
			else if(b==0) {total=a;}
			else if (a==0 && b==0) {total=0;}
			else {total = a+b;}
			// llamada a metodo que comprueba los numeros de digitos 1 o 2.
			int d = digitos(total);
			
			n1.pop();
			n2.pop();
	
			if(d == 1) {
					
					if(!acarreo.isEmpty()) {
						total=total+acarreo.getFirst();
						acarreo.dequeue();}
						d = digitos(total);
						if(d==1) {resul.push(total); 
								 }	
							else {
								int unidad = total%10;
								total = total/10;
								int decenas = total%1000;
								total%=1000/1000;
								resul.push(unidad);
								acarreo.enqueue(decenas);
								}		
				}else if(d>=2){
		
					if(!acarreo.isEmpty()) {	
						total = total + acarreo.getFirst();
						acarreo.dequeue();
						int unidad = total%10;
						total = total/10;
						int decenas = total%1000;
						total%=1000/1000;
						resul.push(unidad);
						acarreo.enqueue(decenas);
						}
					else {
						int unidad = total%10;
						total = total/10;
						int decenas = total%1000;
						total%=1000/1000;
						resul.push(unidad);
						acarreo.enqueue(decenas);
							}
				
				}else if(d==0) {
								if(!acarreo.isEmpty()) {
										total=total+acarreo.getFirst();
										acarreo.dequeue();
										resul.push(total);
										}else {resul.push(total);}
								}
}while(!n1.isEmpty() && !n2.isEmpty());
				
		while(!resul.isEmpty()) {
			resul.getTop();
			valor = valor+resul.getTop().toString();
			resul.pop();
		}
		
			if(!acarreo.isEmpty()) {
				valor=acarreo.getFirst().toString()+valor; 
				}
			acarreo.clear();
			value.clear();
		    value.push( eliminaZeros(valor));
}	//clase
		


	/* Método que modifica el valor numérico llamante, restándole el valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico llamante */
	public void subValue(Value n) {
		Stack<Integer> n1 = new Stack<Integer>();	
		Stack<Integer> n2 = new Stack<Integer>();	
		Stack<Integer> resul = new Stack<Integer>();
		Queue<Integer> acarreo = new Queue<Integer>();
		String valor="";
		Integer total;
		int a1= value.getTop().toString().length();
		int a2 =n.toString().length();
		Integer a=0, b=0;
	//comprueba longitud de n y rellena de zeros a la izquierda	
	if(a1>a2) {
			 int vf =a1-a2;
			 for(int x=1; x<=vf; x++) {
				 n2.push(0); 
			 }
		}else if(a1<a2) {
			int vf =a2-a1;
			 for(int x=1; x<=vf; x++) {
				 n1.push(0); 
			 }
			 }
		
	// insertar en pila this. 	 
	 if(!value.isEmpty()) {
		 for(int i=0; i<=a1-1; i++) {   
			    n1.push(Integer.parseInt(Character.toString(value.getTop().charAt(i))));}
		}
			
	// insertar en pila
	if(!n.toString().isEmpty()) {
		for(int i=0; i<=a2-1; i++) {
			n2.push(Character.getNumericValue(n.toString().charAt(i)));	}
			}
			
		//cuerpo principal
do {
		if(!n1.isEmpty()) {a=(n1.getTop());}
		if(!n2.isEmpty()) {b=(n2.getTop());}
		 n1.pop();
		 n2.pop();
			
		 if(a>b  && acarreo.isEmpty()) {
			 		total=a-b;
			 		resul.push(total);
		 }
		 else if(a>b  && !acarreo.isEmpty()) {
			 
			 		b=(b+acarreo.getFirst());
			 		acarreo.dequeue();
			 		
			 		if(a>b) {total=a-b;
			 		resul.push(total);}
			 		else if(a<b) {  total=(a+10)-b;
			 		resul.push(total);
			 		acarreo.enqueue(1);  }
			 		else if(a==b) {total=0;
			 		resul.push(total);}
		 }
		 else if(a<b  && acarreo.isEmpty()) {
			 		total=(a+10)-b;
			 		resul.push(total);
			 		acarreo.enqueue(1);
		 }
		 else if(a<b  && !acarreo.isEmpty()) {
			 	total=(a+10)-(b+acarreo.getFirst());
		 		acarreo.dequeue();
		 		resul.push(total);
		 		acarreo.enqueue(1);	 
		 }
		 else if(a==b && acarreo.isEmpty()) {
			 total=0;
			 resul.push(total);
		 }		
		 else if(a==b && !acarreo.isEmpty()) {
			 	total=(a+10)-(b+acarreo.getFirst());
		 		acarreo.dequeue();
		 		resul.push(total);
		 		acarreo.enqueue(1);
		 }		
	}while(!n1.isEmpty() && !n2.isEmpty());
		
		while(!resul.isEmpty()) {
			resul.getTop();
			valor = valor+resul.getTop().toString();
			resul.pop();
		}
		value.clear();
		value.push(eliminaZeros(valor));	
	}

	/* Método que modifica el valor numérico llamante, restándolo del valor numérico parámetro */
	/* Sabemos que el mayor es el valor numérico parámetro */
	public void subFromValue(Value n) {
		Stack<Integer> n1 = new Stack<Integer>();	
		Stack<Integer> n2 = new Stack<Integer>();	
		Stack<Integer> resul = new Stack<Integer>();
		Queue<Integer> acarreo = new Queue<Integer>();
		String valor="";
		Integer total;
		int s1= value.getTop().toString().length();
		int s2 =n.toString().length();
		Integer a=0;
		Integer b=0;
	//comprueba longitud de n y rellena de zeros a la izquierda	
	if(s1>s2) {
			 int vf =s1-s2;
			 for(int x=1; x<=vf; x++) {
				 n2.push(0); 
			 }
		}else if(s1<s2) {
			int vf =s2-s1;
			 for(int x=1; x<=vf; x++) {
				 n1.push(0); 
			 }
			 }
		
	// insertar en pila. 	 
	 if(!value.isEmpty()) {

		 for(int i=0; i<=s1-1; i++) {		   
			    n1.push(Integer.parseInt(Character.toString(value.getTop().charAt(i))));}
		 }	
	// insertar en pila
	if(!n.toString().isEmpty()) {
		for(int i=0; i<=s2-1; i++) {
			n2.push(Character.getNumericValue(n.toString().charAt(i)));}
		}
	//cuerpo principal	
do {
		if(!n1.isEmpty()) { a=(n1.getTop());}
		if(!n2.isEmpty()) { b=(n2.getTop());}
		 n1.pop();
		 n2.pop();	
			
		 if(a>b && acarreo.isEmpty()) {
			 	total=(b+10)-(a);
		 		acarreo.enqueue(1);
			 	resul.push(total);
		 }
		 else if(a>b && !acarreo.isEmpty()) {
			 		a=(a+acarreo.getFirst());
			 		acarreo.dequeue();
			 		
			 		if(a>b) {total=b-a;
			 		resul.push(total);}
		 }
		 else if(a<b && acarreo.isEmpty()) {

			 if(a==0) { total= b;
			 			resul.push(total);}
			 else {
			 		total=b-a;
			 		resul.push(total);
			 		}
		 }
		 else if(a<b && !acarreo.isEmpty()) {
			 	total=b-(a+acarreo.getFirst());
		 		acarreo.dequeue();
		 		resul.push(total);
		 }
		 else if(a==b && acarreo.isEmpty()) {
			 total=0;
			 resul.push(total);
		 }		
		 else if(a==b && !acarreo.isEmpty()) {
			 	total=(a+10)-(b+acarreo.getFirst());
		 		acarreo.dequeue();
		 		resul.push(total);
		 		acarreo.enqueue(1);
		 }
}while(!n1.isEmpty() && !n2.isEmpty());
		
		while(!resul.isEmpty()) {
			resul.getTop();
			valor = valor+resul.getTop().toString();
			resul.pop();
		}
			
		if(Integer.parseInt(valor)==0) {			
			value.push("0");
		}
		else {
			value.clear();
			value.push(eliminaZeros(valor));}
}

	
	/* Método que modifica el valor numérico llamante, multiplicándolo por el valor numérico parámetro */
	public void multValue(Value n) {
		List<Integer> n1 = new List<Integer>();	
		List<Integer> n2 = new List<Integer>();	
		Stack<Integer> resul = new Stack<Integer>();
		Queue<Integer> acarreo = new Queue<Integer>();
		String valor="";
		Integer total=0;			 
		int s1= value.getTop().toString().length();
		int s2 =n.toString().length();
		int x1=1;
		int x2=1;
		//comprueba longitud de n y rellena de zeros
		if(s1>s2) {
			 int vf =s1-s2;
		for( x1=1; x1<=vf; x1++) {
				 n2.insert(x2,0); 
			 }
		}else if(s1<s2) {
			int vf =s2-s1;
			 for( x2=1; x2<=vf; x2++) {
				 n1.insert(x1,0); 
			 }
		}
	
	// insertar en pila  	 
		 if(!value.isEmpty()) {
			 for(int i=0; i<=s1-1; i++) {
				    n1.insert(x2++,Integer.parseInt(Character.toString(value.getTop().charAt(i))));}
		}
	// insertar en pila
		if(!n.toString().isEmpty()) {	
			for(int i=0; i<=s2-1; i++) {
				//int y=1;		
				n2.insert(x1++,Character.getNumericValue(n.toString().charAt(i)));}
		}
		
	int sn1=n1.size();
	int sn2=n2.size();
	int d=0;
	
	//cuerpo de programa
		for(int k=0; k<=2 * sn1-2; k++ ) {
			
			if(k<=sn1-1) {
				int suma=0;
				for(int i=sn1-k; i<=sn1; i++) {
					suma=n1.get(i).intValue() * n2.get(2*sn1-i-k).intValue()+suma;
				}
				total=suma;
				
				if(acarreo.isEmpty()) {
					   d= digitos(total);
						if(d==1) {resul.push(total);}
						else {
							int unidad = total%10;
							total = total/10;
							int decenas = total%1000;
							total = total/1000;
							resul.push(unidad);
							acarreo.enqueue(decenas);}			
				}
				else {
					total=total + acarreo.getFirst();
					acarreo.dequeue();
					d=digitos(total);
					if(d==1) {resul.push(total);}
					else {
						int unidad = total%10;
						total = total/10;
						int decenas = total%1000;
						total%=1000/1000;
						resul.push(unidad);
						acarreo.enqueue(decenas);}
				}
			}
			else if(k>=sn1-1) {
				int suma=0;
				for(int i =1; i<=2*sn1-k-1; i++ ) {
					suma=suma+n1.get(i).intValue()*n2.get(2*sn1-i-k).intValue();
				}
				total=suma;
				if(acarreo.isEmpty()) {
					   d= digitos(total);
						if(d==1) {resul.push(total);}
						else {
							int unidad = total%10;
							total = total/10;
							int decenas = total%1000;
							total%=1000/1000;
							resul.push(unidad);
							acarreo.enqueue(decenas);}
				}
				else {
					total=total + acarreo.getFirst();
					acarreo.dequeue();
					d=digitos(total);
					if(d==1) {resul.push(total);}
					else {
						int unidad = total%10;
						total = total/10;
						int decenas = total%1000;
						total%=1000/1000;
						resul.push(unidad);
						acarreo.enqueue(decenas);}
				}			
			}
		}
		while(!resul.isEmpty()) {
			resul.getTop();
			valor = valor+resul.getTop().toString();
			resul.pop();
		}
			
		if(valor.equals("0")) {	
			value.push("0");
		}
		else {
			value.clear();
			value.push(eliminaZeros(valor));}
	}

	/* Método que indica si el valor numérico llamante es mayor que el valor numérico parámetro */
	public boolean greater(Value n) {	
	
		int l1= value.getTop().toString().length();
		int l2 =n.toString().length();
		Queue<Integer> n1 = new Queue<Integer>();	
		Queue<Integer> n2 = new Queue<Integer>();	
		Boolean estado=false;
		Integer a=0;
		Integer b=0;
		
		if(l1>l2) {estado=true;}
		else if(l1<l2) {estado=false;}
		else if(l1==l2) {
			
							//recorre value e inserta en n1
							 if(!value.isEmpty()) {
								 for(int i=0; i<=l1-1; i++) {
										n1.enqueue(Integer.parseInt(Character.toString(value.getTop().charAt(i))));	}
											}
							//recorre n e inserta en n2
							if(!n.toString().isEmpty()) {
								for(int i=0; i<=l2-1; i++) {
									n2.enqueue(Character.getNumericValue(n.toString().charAt(i)));	}
								}								
		do {	
			
			a=(n1.getFirst());
			b=(n2.getFirst());
			n1.dequeue();
			n2.dequeue();						
							
			if(a>b) {
				estado=true;
				break;
			}else if(a<b) {
				estado=false;
				break;
			}
		}while(!n1.isEmpty() && !n2.isEmpty());
	}	
		return estado;		
}

	/* Método que indica si el valor numérico es cero */
	public boolean isZero() {	
		return value.toString().equals("0");
	}
	
	/*metoto que comprueba en numero de digitos de una opercion (1 o 2), para despues a�adir al acarreo*/
	public int digitos(int total) {
		int digitos=0;
		while(total !=0)
		 {total = total/10;   
		  digitos++;
		 }
		return digitos;
	}


	/*elimina numeros de la izquierda*/
	public String eliminaZeros(String valor) {
		String devolu="";
		Character ab;
		int len=valor.length();
		int i=0;
		ab=valor.charAt(0);	
		if(!ab.equals('0')) {
			devolu=valor;
		}
		else {
				while(ab.equals('0')){
						devolu="";	
						for ( i=1; i<=len-1;i++) {
							devolu=devolu + valor.charAt(i);
						}	
				len--;		
				valor=devolu;		
				try {
					ab=devolu.charAt(0);
				}catch(StringIndexOutOfBoundsException siobe) {
					devolu="0";
					break;
				}	
				}
		} 
		return devolu;
	}			

	/*Invertir lista*/
	 public List<Integer> inversora(List<Integer> li){
		    //System.out.println("Lista");
		    //Imprimir(li);
		    //System.out.println("Lista invetida");
		    int pos=1;
		    List <Integer> inver = new List<Integer>();
		    for(int x= li.size(); x<=li.size() && x != 0; x-- ){
		    
		    
		        int a = li.get(x);
		        
		        inver.insert(a,pos++);
		    }

		    return inver;
		   }

}
