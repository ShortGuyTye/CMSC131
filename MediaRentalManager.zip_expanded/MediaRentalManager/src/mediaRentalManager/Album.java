package mediaRentalManager;

public class Album implements Media {
	private String title, artist, songs;
	private int numCopies;

	public Album(String title, int numCopies, String artist, String songs) {
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.numCopies = numCopies;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	public int getNumberOfCopies() {
		return numCopies;
	}

	public void setNumberOfCopies(int num) {
		numCopies += num;
	}

	public String toString() {
		// Journey, Copies Available: 1, Artist: ABBA, Songs: Yesterday, Hello
		String answer = "Title: " + title + ", Copies Available: " + numCopies;
		answer += ", Artist: " + artist + ", Songs: " + songs;
		return answer;
	}

	@Override
	public int compareTo(Media media) {
		if (title.compareTo(media.getTitle()) > 0) {
			return 1;
		} else if (title.compareTo(media.getTitle()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
