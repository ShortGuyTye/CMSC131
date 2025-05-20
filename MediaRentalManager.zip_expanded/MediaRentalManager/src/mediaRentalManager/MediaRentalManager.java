package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalManagerInt {
	private ArrayList<Media> allMedia;
	private ArrayList<Customer> allCustomers;
	private int limitedPlanLimit = 2;

	public MediaRentalManager() {
		allMedia = new ArrayList<Media>();
		allCustomers = new ArrayList<Customer>();
	}

	public void addCustomer(String name, String address, String plan) {
		Customer newCustomer = new Customer(name, address, plan);
		allCustomers.add(newCustomer);
	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie newMovie = new Movie(title, copiesAvailable, rating);
		allMedia.add(newMovie);
	}

	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album newAlbum = new Album(title, copiesAvailable, artist, songs);
		allMedia.add(newAlbum);
	}

	public void setLimitedPlanLimit(int value) {
		limitedPlanLimit = value;
	}

	public String getAllCustomersInfo() {
		Collections.sort(allCustomers);
		String answer = "***** Customers' Information *****\n";
		for (int i = 0; i < allCustomers.size(); i++) {
			answer += "Name: " + allCustomers.get(i).getName();
			answer += ", Address: " + allCustomers.get(i).getAddress();
			answer += ", Plan: " + allCustomers.get(i).getPlan();
			answer += "\nRented: " + allCustomers.get(i).getRented().toString();
			answer += "\nQueue: " + allCustomers.get(i).getQueue().toString() + "\n";
		}
		return answer;
	}

	public String getAllMediaInfo() {
		Collections.sort(allMedia);
		String answer = "***** Media Information *****\n";
		for (int i = 0; i < allMedia.size(); i++) {
			answer += allMedia.get(i).toString();
			answer += "\n";
		}
		return answer;
	}

	public boolean addToQueue(String customerName, String mediaTitle) {
		for (int i = 0; i < allCustomers.size(); i++) {
			if (allCustomers.get(i).getName().equals(customerName)) {
				allCustomers.get(i).addQueue(mediaTitle);
				return true;
			}
		}
		return false;
	}

	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (int i = 0; i < allMedia.size(); i++) {
			if (allCustomers.get(i).getName().equals(customerName)) {
				allCustomers.get(i).removeQueue(mediaTitle);
				return true;
			}
		}
		return false;
	}

	public String processRequests() {
		String answer = "";
		Collections.sort(allCustomers);
		for (int i = 0; i < allCustomers.size(); i++) {
			if (allCustomers.get(i).getPlan().equals("LIMITED")) {
				int index = 0;
				for (int j = 0; j < allCustomers.get(i).getQueue().size(); j++) {
					int numLeft = 0;
					for (int k = 0; k < allMedia.size(); k++) {
						if (allMedia.get(k).getTitle() == allCustomers.get(i).getQueue().get(j)) {
							numLeft = allMedia.get(k).getNumberOfCopies();
							index = k;
						}
					}
					if ((allCustomers.get(i).getRentedSize() < limitedPlanLimit) && numLeft > 0) {
						allCustomers.get(i).getRented().add(allCustomers.get(i).getQueue().get(j));
						answer += "Sending " + allCustomers.get(i).getQueue().get(j) + " to "
								+ allCustomers.get(i).getName() + " \n";
						allCustomers.get(i).removeQueue(allCustomers.get(i).getQueue().get(j));
						allMedia.get(index).setNumberOfCopies(-1);
						j--;
					}
				}

			}
			if (allCustomers.get(i).getPlan().equals("UNLIMITED")) {
				int index = 0;
				for (int j = 0; j < allCustomers.get(i).getQueue().size(); j++) {
					int numLeft = 0;
					for (int k = 0; k < allMedia.size(); k++) {
						if (allMedia.get(k).getTitle() == allCustomers.get(i).getQueue().get(j)) {
							numLeft = allMedia.get(k).getNumberOfCopies();
							index = k;
						}
					}
					if (numLeft > 0) {
						allCustomers.get(i).getRented().add(allCustomers.get(i).getQueue().get(j));
						answer += "Sending " + allCustomers.get(i).getQueue().get(j) + " to "
								+ allCustomers.get(i).getName() + " \n";
						allCustomers.get(i).removeQueue(allCustomers.get(i).getQueue().get(j));
						allMedia.get(index).setNumberOfCopies(-1);
						j--;
					}
				}
			}
		}
		return answer;
	}

	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int i = 0; i < allCustomers.size(); i++) {
			if (allCustomers.get(i).getName().equals(customerName)) {
				allCustomers.get(i).getRented().remove(mediaTitle);
				for (int j = 0; j < allMedia.size(); j++) {
					if (allMedia.get(j).getTitle().equals(mediaTitle)) {
						allMedia.get(j).setNumberOfCopies(1);
					}
				}
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		Collections.sort(allMedia);
		ArrayList<String> answer = new ArrayList<String>();
		for (int i = 0; i < allMedia.size(); i++) {
			answer.add(allMedia.get(i).getTitle());
		}
		for (int i = 0; i < allMedia.size(); i++) {
			if (!answer.isEmpty()) {
				if (title != null) {
					if (!allMedia.get(i).getTitle().equals(title)) {
						answer.remove(allMedia.get(i).getTitle());
					}
				}
				if ((rating != null)) {
					if (allMedia.get(i) instanceof Album) {
						answer.remove(allMedia.get(i).getTitle());
					} else if (!((Movie) allMedia.get(i)).getRating().equals(rating)) {
						answer.remove(allMedia.get(i).getTitle());
					}
				}
				if (artist != null && allMedia.get(i) instanceof Album) {
					if (!((Album) allMedia.get(i)).getArtist().equals(artist)) {
						answer.remove(allMedia.get(i).getTitle());
					}
				}
				if (songs != null) {
					if (allMedia.get(i) instanceof Movie) {
						answer.remove(allMedia.get(i).getTitle());
					} else {
						// for (int j = 0; j < ((Album) allMedia.get(i)).getSongs().length(); j++) {
						if (((Album) allMedia.get(i)).getSongs().indexOf(songs) == -1) {
							answer.remove(allMedia.get(i).getTitle());
						}
						// }
					}
				}
			}
		}
		return answer;
	}
}
