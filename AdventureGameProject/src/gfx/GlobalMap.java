package gfx;

public class GlobalMap {

	protected LocalMap[][] localMaps;
	protected int mapSizeX = 3;
	protected int mapSizeY = 3;
	protected String environmentType;
	protected String filePath;
	private String[][] filePaths;
	
	public GlobalMap(){
		
		environmentType = "testLevel";
		filePath = "res/maps/" + environmentType + "/";
		initializeFilepaths();
		localMaps = new LocalMap[mapSizeY][mapSizeX];
		Sprites.loadImages(environmentType);
		
	}
	
	public LocalMap enterLocalMap(int posX , int posY){
		
		if(localMaps[posY][posX] != null){
			
			return localMaps[posY][posX];
			
		}
		
		else{
			// Loads map from file
			localMaps[posY][posX] = new LocalMap(filePaths[posY][posX]);
			
			System.out.println("Loaded " + filePaths[posY][posX]);
			
			return localMaps[posY][posX];
			
		}		
	}
	
	protected void initializeFilepaths(){
		
		filePaths = new String[mapSizeY][mapSizeX];
		
		int n = 1;
		
		for(int i = 0; i < mapSizeY; i++){
			
			for(int j = 0; j < mapSizeX; j++){
				
				filePaths[i][j] = filePath + "testLevel" + n;
				n++;
			}
			
		}
		
	}
}