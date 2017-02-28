package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
	
	private String title = "title cd";
	private String artist = "the artist";
	
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}
}
