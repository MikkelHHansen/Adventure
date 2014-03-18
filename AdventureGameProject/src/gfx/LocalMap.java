package gfx;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LocalMap {
	
	public int[][] map;
	
	private ArrayList<Integer> doorIds = new ArrayList<Integer>();
	private ArrayList<Integer> interactiveIds = new ArrayList<Integer>();
 	
	public int x , y;
	
	public LocalMap(int x , int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	public int[][] getBlocks() {
		return map;
	}
	
	public int getDoorId(int value) {
		if (doorIds == null) {
			return -1;
		} else {		
			return doorIds.get(value);
		}
	}
	
	public int getInteractiveId(int value) {
		if (interactiveIds == null) {
			return -1;
		} else {
			return interactiveIds.get(value);
		}
	}
	
	public LocalMap(String filePath){
		
		try{
			
			Scanner reader = new Scanner(new File(filePath));
		
			this.x = reader.nextInt();
			this.y = reader.nextInt();
			
			map = new int[y][x];
			
			for(int i = 0; i < y; i++){
			
				for(int j = 0; j < x; j++){
					
					int type = (Integer)reader.nextInt();
					
					if (type == 3 || type == 14) {
						doorIds.add(reader.nextInt());
						doorIds.add(reader.nextInt());
					}
					
					if (type == 13) {
						interactiveIds.add(reader.nextInt());
						interactiveIds.add(reader.nextInt());
					}
					
					map[i][j] = type;
					
				}
					
			}
			
			reader.close();
		
		} catch (FileNotFoundException e) {
				System.err.println(filePath + " not found.");
		};
	}
	
}