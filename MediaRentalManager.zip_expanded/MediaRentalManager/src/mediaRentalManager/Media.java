package mediaRentalManager;

public interface Media extends Comparable<Media> {

	public String getTitle();

	public int getNumberOfCopies();

	public String toString();

	public void setNumberOfCopies(int num);

}
