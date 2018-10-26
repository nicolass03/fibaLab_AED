package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dataStructures.BST;
import dataStructures.BST_AVL;
import dataStructures.BST_RBT;
import dataStructures.Node;

public class Main {

	public static final int INDEX_REBOUNDS = 12;
	public static final int INDEX_STEALS = 14;
	public static final int INDEX_POINTS = 6;
	public static final int INDEX_ASSIST = 13;
	public static final int INDEX_NAME = 2;
	public static final int INDEX_BLOCKS = 15;
	
	private BST_RBT rootRebounds;
	private BST_RBT rootSteals;
	private BST_AVL rootPoints;
	private BST_AVL rootAssist;

	int numberofFiles;
	
	public List foundPlayers;

	public Main() {
		rootRebounds = new BST_RBT<>();
		rootSteals = new BST_RBT<>();
		rootPoints = new BST_AVL<>();
		rootAssist = new BST_AVL<>();
	}

	public void loadData(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			line = br.readLine();
			int i = 0;
			while(line != null && !line.equals("")) {
				BufferedWriter bw = new BufferedWriter(new FileWriter("./data/player_"+i+".txt"));
				bw.write(line);
				bw.close();
				line = br.readLine();
				i++;
			}
			numberofFiles = i;
			System.out.println("Loaded");
			br.close();
			createBSTSteals();
			createBSTRebounds();
			createBSTAssists();
			createBSTPoints();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createBSTRebounds(){
		try {
			int i = 0;
			while(i < numberofFiles) {
				String fileRoute = "./data/player_"+i+".txt";
				BufferedReader br = new BufferedReader(new FileReader(fileRoute));
				String[] line = br.readLine().split(",");
				System.out.println(line[INDEX_REBOUNDS]);
				rootRebounds.agregarNodo(Double.parseDouble(line[INDEX_REBOUNDS]), fileRoute);

				br.close();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createBSTSteals() {
		try {
			int i = 0;
			while(i < numberofFiles) {
				String fileRoute = "./data/player_"+i+".txt";
				BufferedReader br = new BufferedReader(new FileReader(fileRoute));
				String[] line = br.readLine().split(",");
				System.out.println(line[5]);
				rootSteals.agregarNodo(Double.parseDouble(line[INDEX_STEALS]), fileRoute);

				br.close();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createBSTAssists() {
		try {
			int i = 0;
			while(i < numberofFiles) {
				String fileRoute = "./data/player_"+i+".txt";
				BufferedReader br = new BufferedReader(new FileReader(fileRoute));
				String[] line = br.readLine().split(",");
				rootAssist.agregarNodo(Double.parseDouble(line[INDEX_ASSIST]), fileRoute);

				br.close();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createBSTPoints() {
		try {
			int i = 0;
			while(i < numberofFiles) {
				String fileRoute = "./data/player_"+i+".txt";
				BufferedReader br = new BufferedReader(new FileReader(fileRoute));
				String[] line = br.readLine().split(",");
				rootPoints.agregarNodo(Double.parseDouble(line[INDEX_POINTS]), fileRoute);

				br.close();
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] toArray(List l) {
		String[] names = new String[l.size()];
		try {
			for (int i = 0; i < l.size(); i++) {
				Node n = (Node) l.get(i);
				BufferedReader br = new BufferedReader(new FileReader((String)n.getValue()));
				String name = br.readLine().split(",")[INDEX_NAME];
				names[i] = name;
				br.close();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return names;
	}

	public List searchRebounds(Double key){
		if(rootRebounds.raiz == null){
			return null;
		}
		else{
			foundPlayers = new ArrayList();
			searchAllRebounds(key, rootRebounds.raiz, foundPlayers);
		}
		return foundPlayers;
	}

	private void searchAllRebounds(Double key, Node current, List l) {
		if(current != null && current.getKey() != null) {
			if(current.getKey() != null && current.getKey().compareTo(key) == 0){
				l.add(current);
			}
			if(current.getLeft() != Node.NODONULL){
				searchAllRebounds(key, current.getLeft(),l);
			}
			if(current.getRight() != Node.NODONULL){
				searchAllRebounds(key, current.getRight(),l);
			}			
		}
	}
	
	public List searchAssist(Double key){
		if(rootAssist.raiz == null){
			return null;
		}
		else{
			foundPlayers = new ArrayList();
			searchAllAssists(key, rootAssist.raiz, foundPlayers);
		}
		return foundPlayers;
	}

	private void searchAllAssists(Double key, Node current, List l) {
		if(current != null && current.getKey() != null) {
			if(current.getKey().compareTo(key) == 0){
				l.add(current);
			}
			if(current.getLeft() != Node.NODONULL){
				searchAllAssists(key, current.getLeft(),l);
			}
			if(current.getRight() != Node.NODONULL){
				searchAllAssists(key, current.getRight(),l);
			}			
		}
	}

	public List searchPoints(Double key){
		if(rootPoints.raiz == null){
			return null;
		}
		else{
			foundPlayers = new ArrayList();
			searchAllPoints(key, rootPoints.raiz, foundPlayers);
		}
		return foundPlayers;
	}

	private void searchAllPoints(Double key, Node current, List l) {
		if(current != null && current.getKey() != null) {
			if(current.getKey() != null && current.getKey().compareTo(key) == 0){
				l.add(current);
			}
			if(current.getLeft() != Node.NODONULL){
				searchAllPoints(key, current.getLeft(),l);
			}
			if(current.getRight() != Node.NODONULL){
				searchAllPoints(key, current.getRight(),l);
			}			
		}
	}
	
	public List searchSteals(Double key){
		if(rootSteals.raiz == null){
			return null;
		}
		else{
			foundPlayers = new ArrayList();
			searchAllSteals(key, rootSteals.raiz, foundPlayers);
		}
		return foundPlayers;
	}

	private void searchAllSteals(Double key, Node current, List l) {
		if(current != null && current.getKey() != null) {
			if(current.getKey() != null && current.getKey().compareTo(key) == 0){
				l.add(current);
			}
			if(current.getLeft() != Node.NODONULL){
				searchAllSteals(key, current.getLeft(),l);
			}
			if(current.getRight() != Node.NODONULL){
				searchAllSteals(key, current.getRight(),l);
			}			
		}
	}
	
	public String searchBSTAssist(String key) {
		return (String) rootAssist.buscarNodo(key).getValue();
	}

	public String searchBSTPoints(String key) {
		return (String) rootPoints.buscarNodo(key).getValue();
	}

	public String searchBSTSteals(String key) {
		return (String) rootSteals.buscarNodo(key).getValue();
	}

	public String[] getPlayerData(String url) {
		String[] data = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(url));
			data = br.readLine().split(",");
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	/**
	 * @return the rootRebounds
	 */
	public BST_RBT getRootRebounds() {
		return rootRebounds;
	}

	/**
	 * @param rootRebounds the rootRebounds to set
	 */
	public void setRootRebounds(BST_RBT rootRebounds) {
		this.rootRebounds = rootRebounds;
	}

	/**
	 * @return the rootSteals
	 */
	public BST_RBT getRootSteals() {
		return rootSteals;
	}

	/**
	 * @param rootSteals the rootSteals to set
	 */
	public void setRootSteals(BST_RBT rootSteals) {
		this.rootSteals = rootSteals;
	}

	/**
	 * @return the rootPoints
	 */
	public BST getRootPoints() {
		return rootPoints;
	}

	/**
	 * @param rootPoints the rootPoints to set
	 */
	public void setRootPoints(BST_AVL rootPoints) {
		this.rootPoints = rootPoints;
	}

	/**
	 * @return the rootAssist
	 */
	public BST getRootAssist() {
		return rootAssist;
	}

	/**
	 * @param rootAssist the rootAssist to set
	 */
	public void setRootAssist(BST_AVL rootAssist) {
		this.rootAssist = rootAssist;
	}

	/**
	 * @return the numberofFiles
	 */
	public int getNumberofFiles() {
		return numberofFiles;
	}

	/**
	 * @param numberofFiles the numberofFiles to set
	 */
	public void setNumberofFiles(int numberofFiles) {
		this.numberofFiles = numberofFiles;
	}
	
	public void addPlayer(String key, String value) {
		rootSteals.agregarNodo(Double.valueOf(key), value);
		rootRebounds.agregarNodo(Double.valueOf(key), value);
		rootPoints.agregarNodo(Double.valueOf(key), value);
		rootAssist.agregarNodo(Double.valueOf(key), value);
		numberofFiles++;
	}
}
