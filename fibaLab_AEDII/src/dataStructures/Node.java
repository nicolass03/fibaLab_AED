package dataStructures;

public class Node<K extends Comparable<K>, V>{
	
	public final static boolean NEGRO = true;
	public final static boolean ROJO = false;
	public final static Node NODONULL = new Node(null, null, NEGRO);
	
	private K key;
	private V value;
	private Node<K,V> left;
	private Node<K,V> right;
	private Node<K,V> father;
	private boolean color;
	private int balance_factor;
	
	
	public Node(K i, V val, boolean co) {
		key = i;
		value =  val;
		father = null;
		left = null;
		right = null;
		color = co;
	}
	
	public Node(K i, V val) {
		key = i;
		value =  val;
		father = null;
		left = null;
		right = null;
		balance_factor = 0;
	}
	
	

	public int getBalance_factor() {
		return balance_factor;
	}

	public void setBalance_factor(int balance_factor) {
		this.balance_factor = balance_factor;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public Node<K, V> getLeft() {
		return left;
	}

	public void setLeft(Node<K, V> left) {
		this.left = left;
	}

	public Node<K, V> getRight() {
		return right;
	}

	public void setRight(Node<K, V> right) {
		this.right = right;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public Node<K, V> getFather() {
		return father;
	}


	public void setFather(Node<K, V> father) {
		this.father = father;
	}
	
	public Node<K,V> eliminar(K llave) {
		if(isHoja()) {
			return null;
		}
		if(key.compareTo(llave) == 0) {
			if(left == null)
				return right;
			
			if(right == null)
				return left;
			
			Node<K,V> suce = right.darMenor();
			right = right.eliminar(suce.getKey());
			suce.left = left;
			suce.right = right;
			return suce;
		}
		else if(key.compareTo(llave) > 0) {
			left = left.eliminar(llave);
		}else {
			right = right.eliminar(llave);
		}
		return this;
	}
	
	public Node<K,V> darMenor(){
		return (left == null)? this : left.darMenor();
	}


	public boolean isHoja() {
		return left == null && right == null;
	}
	
	
	

}
