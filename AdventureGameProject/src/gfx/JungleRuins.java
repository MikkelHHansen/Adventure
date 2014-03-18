package gfx;

public class JungleRuins extends GlobalMap{

	public JungleRuins(){
		
		System.out.println("Generating global map");
		super.mapSizeX = 3;
		super.mapSizeY = 3;
		super.environmentType = "JungleRuins";
		super.filePath = "res/maps/" + environmentType + "/";
		initializeFilepaths();
		Sprites.loadImages(environmentType);
		System.out.println(environmentType + " generated, loading from " + filePath);
		
	}
}
