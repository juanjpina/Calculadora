package es.uned.lsi.eped.pract2018_2019;
import es.uned.lsi.eped.DataStructures.BTree;
import es.uned.lsi.eped.DataStructures.BTreeIF;
import es.uned.lsi.eped.DataStructures.IteratorIF;
import es.uned.lsi.eped.DataStructures.Queue;
import es.uned.lsi.eped.DataStructures.Stack;
import es.uned.lsi.eped.pract2018_2019.Node.NodeType;
import es.uned.lsi.eped.pract2018_2019.Operator.OperatorType;

public class StackMachine {
	Operand od,a,b;  
	Operator op;
	  
	public StackMachine() {
	}	
	
	public Operand execute(SynTree syn) {     
		
		BTree<Node> btree = new BTree<Node>();
		btree = syn.getSynTree(); 
		  
    	
		class Ordena{
			   
			Stack<Operand> stack = new Stack<Operand>();
			Queue<Operator> sig = new Queue<Operator>();  
			String total="";
	    private void post(BTreeIF<Node> btree) {
			
				 if(!btree.isEmpty()) {
				   
				   if(btree.getLeftChild()!=null) {post((BTree<Node>) btree.getLeftChild());}
				
			       if(btree.getRightChild()!=null) {post((BTree<Node>) btree.getRightChild());}   
			       
			       Node raiz = btree.getRoot(); 
			       
			       NodeType x = raiz.getNodeType();
			       
			       String j= raiz.toString();
			       switch(x){
					case OPERAND:		
						stack.push(new Operand(j));
						break;
					case OPERATOR:
						Operator operator = (Operator) btree.getRoot();
						OperatorType ope = operator.getOperatorType();
						switch(ope) {
						case ADD:
							sig.enqueue(new Operator(Operator.OperatorType.ADD));
							break;
						case SUB:
							sig.enqueue(new Operator(Operator.OperatorType.SUB));
							break;
						case MULT:
							sig.enqueue(new Operator(Operator.OperatorType.MULT));
							break;							
						}	   
			   }
			       if(sig.size()==1  && stack.size()>=2) {
						if(sig.getFirst().getOperatorType()==OperatorType.ADD && stack.size()>1) {
							sig.dequeue();
							a = stack.getTop();
							stack.pop();
							b = stack.getTop();
							stack.pop();
								b.add(a);
								String t = b.val().toString();
								if(t.equals("0")) { total = t;}
								else {
								if(b.sig()==-1) {String sa = "-";
								total = sa + t;
								}
								if(b.sig()==1) {total = t;}
								if(b.sig()==0) {total = t;}
								}
								stack.push(new Operand(total));						
							}
			
				else if(sig.getFirst().getOperatorType()==OperatorType.SUB) {
							sig.dequeue();
							a = stack.getTop();
							Boolean aZ = stack.getTop().val().isZero();
							stack.pop();
							b = stack.getTop();
							Boolean bZ = stack.getTop().val().isZero();
							stack.pop();
								if(aZ && bZ){ total= "0";}
								if(!aZ && bZ) {total = a.val().toString();}
								if(aZ && !bZ) {total = b.val().toString();}
								else {
									
									b.sub(a);
								String t = b.val().toString();
								if(b.val().isZero()) {total=t;}
								else {
								
								if(b.val().toString().equals("0")) {total=t;}	
								else {
								if(b.sig()==-1) {String sa = "-";
								total = sa + t;
							}
								else if(b.sig()==1) {total = t;}
								else if(b.sig()==0) {total = t;}
								}}
								stack.push(new Operand(total));
							}
							}
							
				else if(sig.getFirst().getOperatorType()==OperatorType.MULT) {
							sig.dequeue();
							a = stack.getTop();
							stack.pop();
							b = stack.getTop();
							stack.pop();
								a.mult(b);
								String t = a.val().toString();
								if(t=="0" || t=="") {total="0";}
								else {
								if(a.sig()==-1) {String sa = "-";
								total = sa + t;}
								else if(a.sig()==1) {total = t;}
								else if(a.sig()==0) {total = t;}
								}
								stack.push(new Operand(total));
								a = stack.getTop();
							}
							
				else if(sig.getFirst().getOperatorType()==OperatorType.ADD && stack.size()==1) {
								sig.dequeue();
								a = stack.getTop();
								stack.pop();
			
								String t = a.val().toString();
								if(a.sig()==-1) {String sa = "-";
								total = sa + t;}
							
								else if(a.sig()==1) {total = t;}
								else if(a.sig()==0) {total = t;}
								stack.push(new Operand(total));
				}		    	   
			       }  
		   }
	}	
		
		}

		Ordena or = new Ordena();
		or.post(btree);
		Operand resultado= or.stack.getTop();
		or.stack.clear();
		or.sig.clear();
        return resultado;	
}	
				
	
}
	
	
