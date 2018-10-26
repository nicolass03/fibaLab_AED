package dataStructures;

import dataStructures.I_BST;
import dataStructures.Node;

public  class BST<K extends Comparable<K>, V> implements I_BST<K, V>{
	
	public Node<K, V> raiz;
	
	public BST() {
		raiz = null;
	}

	@Override
	public void agregarNodo(K key, V value) {
		Node<K,V> newNode = new Node<>(key,value);
		if(raiz == null) {
			raiz = newNode;
		}else {
			agregarNodo(raiz, newNode);
		}
		 
	}
	
	private void agregarNodo(Node<K,V> actual, Node<K,V> newNode) {
		if(actual.getKey().compareTo(newNode.getKey()) > 0) {
			if(actual.getLeft() == null) {
				actual.setLeft(newNode);
				actual.getLeft().setFather(actual);
			}else {
				agregarNodo(actual.getLeft(), newNode);
			}
		}else {
			if(actual.getRight() == null) {
				actual.setRight(newNode);
				actual.getRight().setFather(actual);
			}else {
				agregarNodo(actual.getRight(), newNode);
			}
		}
	}

	@Override
	public V buscarValor(K key) {
		if(raiz!=null) {
			return buscarValor(raiz, key);
		}
		else {
			return null;
		}
				
	}
	
	private V buscarValor(Node<K, V> actual, K key) {
		if(actual.getKey().compareTo(key) == 0) {
			return actual.getValue();
		}
		else {
			if(actual.getKey().compareTo(key) < 0) {
				return (actual.getLeft()!=null)?buscarValor(actual.getLeft(), key):null;
			}
			else {
				return (actual.getRight()!=null)?buscarValor(actual.getRight(), key):null;
			}
		}
//		if(actual.getKey().compareTo(key) > 0) {
//			if(actual.getLeft().getKey().equals(key)) {
//				return actual.getLeft().getValue();
//			}else {
//				return buscarValor(actual.getLeft(), key);
//			}
//		}else {
//			if(actual.getRight().getKey().equals(key)) {
//				return actual.getRight().getValue();
//			}else {
//				return buscarValor(actual.getRight(), key);
//			}
//		}
	}
	
	@Override
	public Node<K, V> buscarNodo(K key){
		if(raiz!=null) {
			return buscarNodo(raiz, key);
		}
		else {
			return null;
		}

	}
	
	public Node<K, V> buscarNodo(Node<K, V> actual, K key){
		if(actual.getKey().compareTo(key) == 0) {
			return actual;
		}
		else {
			if(actual.getKey().compareTo(key) < 0) {
				return (actual.getRight()!=null)?buscarNodo(actual.getRight(), key):null;
			}
			else {
				return (actual.getLeft()!=null)?buscarNodo(actual.getLeft(), key):null;
			}
		}
		
		
//		if(actual.getKey().compareTo(key) > 0) {
//			if(actual.getLeft().getKey().equals(key)) {
//				return actual.getLeft();
//			}else {
//				return buscarNodo(actual.getLeft(), key);
//			}
//		}else {
//			if(actual.getRight().getKey().equals(key)) {
//				return actual.getRight();
//			}else {
//				return buscarNodo(actual.getRight(), key);
//			}
//		}
	}
	

	@Override
	public void eliminarNodo(K key) {
		Node<K,V> aEliminar = buscarNodo(key);
		raiz = raiz.eliminar(aEliminar.getKey());	
		
	}

	@Override
	public boolean isEmpty() {
		return raiz==null;
	}

	@Override
	public void modificarNodo(K aCambiar, K key, V value) {
	     Node<K, V> aModificar = buscarNodo(key);
	     aModificar.setKey(key);
	     aModificar.setValue(value);
	}
	
	public void imprimir(Node<K,V> actual) {
		if(actual != null) {
			System.out.println(actual.getKey().toString());
			imprimir(actual.getLeft());
			imprimir(actual.getRight());
		}
	}
	

	
	
	
	
	
	
	
	
}
