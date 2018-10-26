package dataStructures;

public class BST_AVL<K extends Comparable<K>, V> extends BST<K,V>{

	public BST_AVL() {
		super();
	}
	
	
	@Override
	public void agregarNodo(K key, V value) {
		if(raiz == null) {
			raiz = new Node<K,V>(key,value);
		}else {
			agregar(key, value, raiz);
		}  
		                
	}
	
	private void agregar(K key, V value, Node<K,V> nodoActual) {
		if(key.compareTo(nodoActual.getKey()) < 0) {
	        if(nodoActual.getLeft() != null)
	                agregar(key,value,nodoActual.getLeft());
	        else {
	        	nodoActual.setLeft(new Node<K,V>(key,value));
				nodoActual.getLeft().setFather(nodoActual);
	                actualizarEquilibrio(nodoActual.getLeft());
	        }
		}else {
	        if(nodoActual.getRight() != null)
	                agregar(key,value,nodoActual.getRight());
	        else {
	        	nodoActual.setRight(new Node<K,V>(key,value));
				nodoActual.getRight().setFather(nodoActual);
	                actualizarEquilibrio(nodoActual.getRight());
	        }
		}
	}

		private void actualizarEquilibrio(Node<K,V> node) {
		    if(node.getBalance_factor() > 1 || node.getBalance_factor() < -1)
		    	reequilibrar(node);
		    else{
		    	if(node.getFather() != null) {
		    		if(node == node.getFather().getLeft())
		                node.getFather().setBalance_factor(node.getFather().getBalance_factor() + 1);
		            else if(node == node.getFather().getRight())
		                node.getFather().setBalance_factor(node.getFather().getBalance_factor() - 1);
		    		if(node.getFather().getBalance_factor() != 0)
		                actualizarEquilibrio(node.getFather());
		        }
		    }
		
		}
		
		
		
		private void reequilibrar(Node<K,V> node) {
			if(node.getBalance_factor() < 0) {
		         if(node.getRight().getBalance_factor() > 0) {
		            rotate_right(node.getRight());
		            rotate_left(node);
		         }else {
		            rotate_left(node);
		         }
			}else if(node.getBalance_factor() > 0) {
		         if(node.getLeft().getBalance_factor() < 0) {
		            rotate_left(node.getLeft());
		            rotate_right(node);
		         }else {
		            rotate_right(node);
		         }
			}

		}
	
	
	private void rotate_left(Node<K,V> rotRaiz) {
		Node<K,V> nuevaRaiz = rotRaiz.getRight();
		rotRaiz.setRight(nuevaRaiz.getLeft()); 
		if(nuevaRaiz.getLeft() != null)
			nuevaRaiz.getLeft().setFather(rotRaiz);
		nuevaRaiz.setFather(rotRaiz.getFather());  
		if(rotRaiz.getFather() == null) {
			raiz = nuevaRaiz;
			}else {
				if(rotRaiz == rotRaiz.getFather().getLeft())
					rotRaiz.getFather().setLeft(nuevaRaiz);
				else {
					rotRaiz.getFather().setRight(nuevaRaiz);  
					}
				}
		nuevaRaiz.setLeft(rotRaiz);
		rotRaiz.setFather(nuevaRaiz);
		rotRaiz.setBalance_factor(rotRaiz.getBalance_factor() + 1 - Math.min(nuevaRaiz.getBalance_factor(),0));  
		nuevaRaiz.setBalance_factor(nuevaRaiz.getBalance_factor() + 1 + Math.max(rotRaiz.getBalance_factor(), 0)); 
	}
	
	private void rotate_right(Node<K,V> rotRaiz) {
		Node<K,V> nuevaRaiz = rotRaiz.getLeft();
		rotRaiz.setLeft(nuevaRaiz.getRight()); 
		if(nuevaRaiz.getRight() != null)
			nuevaRaiz.getRight().setFather(rotRaiz);
		nuevaRaiz.setFather(rotRaiz.getFather());  
		if(rotRaiz.getFather() == null) {
			raiz = nuevaRaiz;
			}else {
				if(rotRaiz == rotRaiz.getFather().getRight())
					rotRaiz.getFather().setRight(nuevaRaiz);
				else {
					rotRaiz.getFather().setLeft(nuevaRaiz);  
					}
				}
		nuevaRaiz.setRight(rotRaiz);
		rotRaiz.setFather(nuevaRaiz);
		rotRaiz.setBalance_factor(rotRaiz.getBalance_factor() - 1 - Math.max(nuevaRaiz.getBalance_factor(),0));  
		nuevaRaiz.setBalance_factor(nuevaRaiz.getBalance_factor() - 1 + Math.min(rotRaiz.getBalance_factor(), 0));
	}
	
	@Override
	public void eliminarNodo(K key) {
		
	}
	
}
