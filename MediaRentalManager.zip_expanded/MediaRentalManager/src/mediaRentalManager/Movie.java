package mediaRentalManager;

public class Movie implements Media {
	private String title, rating;
	private int copiesAvailable;

	public Movie(String title, int copiesAvailable, String rating) {
		this.title = title;
		this.rating = rating;
		this.copiesAvailable = copiesAvailable;
	}

	public String getTitle() {
		return title;
	}

	public int getNumberOfCopies() {
		return copiesAvailable;
	}

	public String toString() {
		String answer = "Title: " + title + ", Copies Available: " + copiesAvailable;
		answer += ", Rating: " + rating;
		return answer;
	}

	public String getRating() {
		return rating;
	}

	public void setNumberOfCopies(int num) {
		copiesAvailable += num;
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
