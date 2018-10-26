package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dataStructures.BST;
import dataStructures.BST_AVL;
import dataStructures.BST_RBT;
import dataStructures.Node;
import junit.framework.AssertionFailedError;

public class BSTTest {
	
	private BST<Integer, Integer> abb;
	private BST_RBT<Integer, Integer> redBlack;
	private BST_AVL<Integer, Integer> avl;
	
	private void setup1() {
		redBlack = new BST_RBT<>();
	}
	
	private void setup2() {
		avl = new BST_AVL<>();
	}
	
	private void setup3() {
		abb = new BST<>();
	}
	
	//Este test verifica que el nodo se agrego en la raiz, si la llave de la raiz es igual a 2 es por que se agrego correctamente
	@Test
	public void testAddRBT1() {
		setup1();
		redBlack.agregarNodo(2,6);
		assertTrue(redBlack.raiz.getKey()==2);
	}
	
	//Este test verifica que el nodo se halla agregado en un arbol rojinegro un poco mas grande y de manera correcta, si el nodo se agrego correctamente entonces debe existir por tanto si es igual a tres existe
	@Test
	public void testAddRBT2() {
		setup1();
		redBlack.agregarNodo(2,6);
		redBlack.agregarNodo(6,0);
		redBlack.agregarNodo(1,0);
		redBlack.agregarNodo(3,4);
		assertTrue(redBlack.raiz.getKey()==2);
		assertTrue(redBlack.buscarNodo(3).getKey() == 3);
	}
	
	
	//Este test verifica que el nodo se haya agregado de manera correcta en el arbol rojinegro(mucho mas grande), si existe es por que se agrego correctamente.
	@Test
	public void testAddRBT3() {
		setup1();
		redBlack.agregarNodo(2,6);
		redBlack.agregarNodo(6,0);
		redBlack.agregarNodo(1,0);
		redBlack.agregarNodo(3,4);
		redBlack.agregarNodo(47, 1);
		redBlack.agregarNodo(60, 2);
		redBlack.agregarNodo(22, 3);
		redBlack.agregarNodo(12, 5);
		redBlack.agregarNodo(6,6);
		redBlack.agregarNodo(13, 7);
		redBlack.agregarNodo(41, 8);
		redBlack.agregarNodo(20, 9);
		redBlack.agregarNodo(52, 10);
		redBlack.agregarNodo(16,11);
		redBlack.agregarNodo(50,11);
		assertTrue(redBlack.buscarNodo(3).getKey() == 3);
		assertTrue(redBlack.buscarNodo(50).getKey() == 50);
	}
	
	//Este test verifica que se haya eliminado el nodo del arbol correctemante si ya no existe entonces el apuntador de la raiz sera el nodo nill.
	@Test
	public void testDeleteRBT1() {
		setup1();
		redBlack.agregarNodo(1,6);
		redBlack.eliminarNodo(1);
		assertTrue(redBlack.raiz == Node.NODONULL);
	}
	
	//Este test verifica que se haya eliminado el nodo del arbol correctemante si ya no existe entonces el metodo lanzara un error al no encontrarlo.
	@Test
	public void testDeleteRBT2() {
		setup1();
		redBlack.agregarNodo(2,6);
		redBlack.agregarNodo(6,0);
		redBlack.agregarNodo(1,0);
		redBlack.agregarNodo(3,4);
		redBlack.eliminarNodo(6);
		try {
		redBlack.buscarNodo(6);
		fail();
		}catch(Exception e) {
			
		}
	}
	
	//Este test verifica que se haya eliminado el nodo del arbol correctemante si ya no existe entonces el metodo lanzara un error al no encontrarlo.
	@Test
	public void testDeleteRBT3() {
		setup1();
		redBlack.agregarNodo(2,6);
		redBlack.agregarNodo(6,0);
		redBlack.agregarNodo(1,0);
		redBlack.agregarNodo(3,4);
		redBlack.agregarNodo(47, 1);
		redBlack.agregarNodo(60, 2);
		redBlack.agregarNodo(22, 3);
		redBlack.agregarNodo(12, 5);
		redBlack.agregarNodo(6,6);
		redBlack.agregarNodo(13, 7);
		redBlack.agregarNodo(41, 8);
		redBlack.agregarNodo(20, 9);
		redBlack.agregarNodo(52, 10);
		redBlack.agregarNodo(16,11);
		redBlack.agregarNodo(50,11);
		redBlack.agregarNodo(64, 12);
		redBlack.eliminarNodo(64);
		try {
			redBlack.eliminarNodo(64);
			fail();
		}catch(Exception e) {
			
		}
	}
	
	//Este test verifica que el nodo se agrego en la raiz, si la llave de la raiz es igual a 50 es por que se agrego correctamente
	@Test
	public void testAddAVL1() {
		setup2();
		avl.agregarNodo(50, 4);
		assertTrue(avl.raiz.getKey() == 50 && avl.raiz.getValue() == 4);
		
	}
	
	//Este test verifica que el nodo se halla agregado en un arbol AVL un poco mas grande y de manera correcta, si el nodo se agrego correctamente entonces debe existir por tanto si es igual a tres existe
	@Test
	public void testAddAVL2() {
		setup2();
		avl.agregarNodo(2,6);
		avl.agregarNodo(6,0);
		avl.agregarNodo(1,0);
		avl.agregarNodo(3,4);
		avl.agregarNodo(50, 4);
		assertTrue(avl.buscarNodo(50).getKey() == 50 && (avl.buscarNodo(50).getBalance_factor() <= 1 && avl.buscarNodo(50).getBalance_factor() >= -1));
		
	}
	
	//Este test verifica que el nodo se halla agregado en un arbol AVL mas grande y de manera correcta, si el nodo se agrego correctamente entonces debe existir por tanto si es igual a tres existe
	@Test
	public void testAddAVL3() {
		setup2();
		avl.agregarNodo(2,6);
		avl.agregarNodo(6,0);
		avl.agregarNodo(1,0);
		avl.agregarNodo(3,4);
		avl.agregarNodo(2,6);
		avl.agregarNodo(6,0);
		avl.agregarNodo(1,0);
		avl.agregarNodo(3,4);
		avl.agregarNodo(47, 1);
		avl.agregarNodo(22, 3);
		avl.agregarNodo(12, 5);
		avl.agregarNodo(6,6);
		avl.agregarNodo(13, 7);
		avl.agregarNodo(41, 8);
		avl.agregarNodo(20, 9);
		avl.agregarNodo(52, 10);
		avl.agregarNodo(16,11);
		avl.agregarNodo(50,11);
		avl.agregarNodo(60, 2);
		assertTrue(avl.buscarNodo(60).getKey() == 60);
		
	}
	
	//Este test verifica que el nodo se busca correctamente
	@Test
	public void testSearch1() {
		setup3();
		abb.agregarNodo(2, 0);
		int a = abb.buscarNodo(2).getKey();
		assertTrue(a == 2);
	}
	
	//Este test verifica que el nodo se busca correctamente
	@Test
	public void testSearch2() {
		setup3();
		abb.agregarNodo(2,6);
		abb.agregarNodo(6,0);
		abb.agregarNodo(1,0);
		abb.agregarNodo(3,4);
		abb.agregarNodo(6,0);
		abb.agregarNodo(1,0);
		abb.agregarNodo(3,4);
		abb.agregarNodo(47, 1);
		abb.agregarNodo(22, 3);
		abb.agregarNodo(12, 5);
		abb.agregarNodo(6,6);
		abb.agregarNodo(13, 7);
		abb.agregarNodo(41, 8);
		abb.agregarNodo(20, 9);
		abb.agregarNodo(52, 10);
		abb.agregarNodo(16,11);
		abb.agregarNodo(50,11);
		abb.agregarNodo(60, 2);
		int a = abb.buscarNodo(47).getKey();
		assertTrue(a == 47);
	}
	
	//Este test verifica que el nodo se busca correctamente
	@Test
	public void testSearch3() {
		setup3();
		abb.agregarNodo(2,6);
		abb.agregarNodo(6,0);
		abb.agregarNodo(1,0);
		abb.agregarNodo(3,4);
		abb.agregarNodo(6,0);
		abb.agregarNodo(1,0);
		abb.agregarNodo(3,4);
		abb.agregarNodo(47, 1);
		abb.agregarNodo(22, 3);
		abb.agregarNodo(12, 5);
		abb.agregarNodo(6,6);
		abb.agregarNodo(13, 7);
		abb.agregarNodo(41, 8);
		abb.agregarNodo(20, 9);
		abb.agregarNodo(52, 10);
		abb.agregarNodo(16,11);
		abb.agregarNodo(50,11);
		abb.agregarNodo(60, 2);
		abb.agregarNodo(101,6);
		abb.agregarNodo(200,0);
		abb.agregarNodo(-1,0);
		abb.agregarNodo(-200,4);
		abb.agregarNodo(-150,0);
		abb.agregarNodo(30,0);
		abb.agregarNodo(40,4);
		abb.agregarNodo(8, 1);
		abb.agregarNodo(85, 3);
		abb.agregarNodo(-47, 5);
		abb.agregarNodo(75,6);
		abb.agregarNodo(71, 7);
		abb.agregarNodo(56, 8);
		abb.agregarNodo(38, 9);
		abb.agregarNodo(55, 10);
		abb.agregarNodo(10,11);
		abb.agregarNodo(80,11);
		abb.agregarNodo(-90, 2);
		int a = abb.buscarNodo(-90).getKey();
		assertTrue(a == -90);
	}
	
	

}
