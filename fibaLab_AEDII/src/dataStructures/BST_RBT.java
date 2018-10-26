package dataStructures;

import dataStructures.Node;

public class BST_RBT<K extends Comparable<K>, V> extends BST<K,V>{
	
	public BST_RBT() {
		raiz = Node.NODONULL;
	}
	
	@Override
	public void agregarNodo(K key, V value) {
		Node<K,V> newNodo = new Node<K,V>(key, value, Node.ROJO);
		agregarNodo(newNodo);
		
	}
	
	private void agregarNodo(Node<K,V> newNodo) {
		Node<K,V> y = Node.NODONULL;
		Node<K,V> x = raiz;
		while(x != Node.NODONULL) {
			y = x;
			if(newNodo.getKey().compareTo(x.getKey()) < 0) {
				x = x.getLeft();
			}else {
				x = x.getRight();
			}
		}
		newNodo.setFather(y);
		if(y == Node.NODONULL) {
			raiz = newNodo;
		}else if(newNodo.getKey().compareTo(y.getKey()) < 0) {
			y.setLeft(newNodo);
		}else {
			y.setRight(newNodo);
		}	
		newNodo.setLeft(Node.NODONULL);
		newNodo.setRight(Node.NODONULL);
		insertFixUp(newNodo);
 	}
	
	private void insertFixUp(Node<K,V> newNodo) {
		while(!newNodo.getFather().isColor()) {
			if(newNodo.getFather() == newNodo.getFather().getFather().getLeft()) {
				Node<K,V> y = newNodo.getFather().getFather().getRight();
				if(!y.isColor()) {
					newNodo.getFather().setColor(Node.NEGRO);
					y.setColor(Node.NEGRO);
					newNodo.getFather().getFather().setColor(Node.ROJO);
					newNodo = newNodo.getFather().getFather();
				}else if(newNodo == newNodo.getFather().getRight()) {
					newNodo = newNodo.getFather();
					leftRotate(newNodo);
				}else {
					newNodo.getFather().setColor(Node.NEGRO);
					newNodo.getFather().getFather().setColor(Node.ROJO);
					rightRotate(newNodo.getFather().getFather());
				}
			}else {
				Node<K,V> y = newNodo.getFather().getFather().getLeft();
				if(!y.isColor()) {
					newNodo.getFather().setColor(Node.NEGRO);
					y.setColor(Node.NEGRO);
					newNodo.getFather().getFather().setColor(Node.ROJO);
					newNodo = newNodo.getFather().getFather();
				}else if(newNodo == newNodo.getFather().getLeft()) {
					newNodo = newNodo.getFather();
					rightRotate(newNodo);
				}else {
					newNodo.getFather().setColor(Node.NEGRO);
					newNodo.getFather().getFather().setColor(Node.ROJO);
					leftRotate(newNodo.getFather().getFather());
				}
				
			}
		}
		raiz.setColor(Node.NEGRO);
	}
	
	private void leftRotate(Node<K,V> newNodo) {
		Node<K,V> y = newNodo.getRight();
		newNodo.setRight(y.getLeft());
		if(y.getLeft() != Node.NODONULL) {
			y.getLeft().setFather(newNodo);
		}
		y.setFather(newNodo.getFather());
		if(newNodo.getFather() == Node.NODONULL) {
			raiz = y;
		}else if(newNodo == newNodo.getFather().getLeft()) {
			newNodo.getFather().setLeft(y);
		}else {
			newNodo.getFather().setRight(y);
		}
		y.setLeft(newNodo);
		newNodo.setFather(y);
	}
	
	private void rightRotate(Node<K,V> newNodo) {
		Node<K,V> y = newNodo.getLeft();
		newNodo.setLeft(y.getRight());
		if(y.getRight()!= Node.NODONULL) {
			y.getRight().setFather(newNodo);
		}
		y.setFather(newNodo.getFather());
		if(newNodo.getFather() == Node.NODONULL) {
			raiz = y;
		}else if(newNodo == newNodo.getFather().getRight()) {
			newNodo.getFather().setRight(y);
		}else {
			newNodo.getFather().setLeft(y);
		}
		y.setRight(newNodo);
		newNodo.setFather(y);
	}
	
	
	public void rN_Transplant(Node<K,V> u, Node<K,V> v) {
		if(u.getFather() == Node.NODONULL) {
			raiz = v;
		}else if(u == u.getFather().getLeft()) {
			u.getFather().setLeft(v);
		}else {
			u.getFather().setRight(v);
		}
		v.setFather(u.getFather());
	}
	
	@Override
	public void eliminarNodo(K key) {
		Node<K,V> z = buscarNodo(key);
		eliminarNodo(z);
		
	}
	
	private void eliminarNodo(Node<K,V> z) {
		Node<K,V> y = z;
		boolean originalColor = y.isColor();
		Node<K,V> x = null;
		if(z.getLeft() == Node.NODONULL) {
			x = z.getRight();
			rN_Transplant(z, z.getRight());
		}else if(z.getRight() == Node.NODONULL) {
			x = z.getLeft();
			rN_Transplant(z, z.getLeft());
		}else {
			y = minimun(z.getRight());
			originalColor = y.isColor();
			x = y.getRight();
			if(y.getFather() == z) {
				x.setFather(y);
			}else {
				rN_Transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setFather(y);
			}
			rN_Transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setFather(y);
			y.setColor(z.isColor());
		}
		if(originalColor) {
			deleteFixUp(x);
		}
	}
	
	
	private void deleteFixUp(Node<K,V> x) {
		while(x != raiz && x.isColor()) {
			if(x == x.getFather().getLeft()) {
				Node<K,V> w = x.getFather().getRight();
				if(!w.isColor()) {
					w.setColor(Node.NEGRO);
					x.getFather().setColor(Node.ROJO);
					leftRotate(x.getFather());
					w = x.getFather().getRight();
				}
				if(w.getLeft().isColor() && w.getRight().isColor()) {
					w.setColor(Node.ROJO);
					x = x.getFather();
				}else if(w.getRight().isColor()) {
					w.getLeft().setColor(Node.NEGRO);
					w.setColor(Node.ROJO);
					rightRotate(w);
					w = x.getFather().getRight();
				}else {
					w.setColor(x.getFather().isColor());
					x.getFather().setColor(Node.NEGRO);
					w.getRight().setColor(Node.NEGRO);
					leftRotate(x.getFather());
					x = raiz;
				}
			}else {
				Node<K,V> w = x.getFather().getLeft();
				if(!w.isColor()) {
					w.setColor(Node.NEGRO);
					x.getFather().setColor(Node.ROJO);
					rightRotate(x.getFather());
					w = x.getFather().getLeft();
				}
				if(w.getRight().isColor() && w.getLeft().isColor()) {
					w.setColor(Node.ROJO);
					x = x.getFather();
				}else if(w.getLeft().isColor()) {
					w.getRight().setColor(Node.NEGRO);
					w.setColor(Node.ROJO);
					leftRotate(w);
					w = x.getFather().getLeft();
				}else {
					w.setColor(x.getFather().isColor());
					x.getFather().setColor(Node.NEGRO);
					w.getLeft().setColor(Node.NEGRO);
					rightRotate(x.getFather());
					x = raiz;
				}
			}
		}
		x.setColor(Node.NEGRO);
		
	}
	
	private Node<K,V> minimun(Node<K,V> x){
		while(x.getLeft().getKey() != null) {
			x = x.getLeft();
		}
		return x;
	}
	
	public void imprimir(Node<K,V> actual) {
		if(actual.getKey() != null) {
			System.out.println(actual.getKey().toString()+", "+actual.isColor());
			imprimir(actual.getLeft());
			imprimir(actual.getRight());
		}
	}
	


}
