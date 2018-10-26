package dataStructures;

import dataStructures.Node;

public interface I_BST<K extends Comparable<K>, V> {
	
	// Agrega un nuevo un nuevo nodo al arbol binario y lo ingresa en la posicion si cumple con la condicion de ser mayor o menor
	public void agregarNodo(K key,V value);
	
	// Busca el valor en un Nodo del arbol binario y lo retorna
	public V buscarValor(K key);
	
	// Busca un nodo en el arbol binario y lo retorna
	public Node<K, V> buscarNodo(K key);
	
	//Elimina el nodo pasado por parametro del arbol binario
	public void eliminarNodo(K key);
	
	//Retorna verdadero si el arbol no tiene ningun nodo
	public boolean isEmpty();
	
	//Modifica el nodo ya existente
	public void modificarNodo(K aCambiar, K key,  V value);



}
