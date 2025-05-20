package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {
	private String name, address, plan;
	private ArrayList<String> queue, rented;

	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		queue = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPlan() {
		return plan;
	}

	public void addQueue(String media) {
		queue.add(media);
	}

	public void removeQueue(String media) {
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) == media) {
				queue.remove(i);
			}
		}
	}

	public ArrayList<String> getQueue() {
		return queue;
	}

	public ArrayList<String> getRented() {
		return rented;
	}

	public int getQueueSize() {
		return queue.size();
	}

	public int getRentedSize() {
		return rented.size();
	}

	@Override
	public int compareTo(Customer customer) {
		if (name.compareTo(customer.name) > 0) {
			return 1;
		} else if (name.compareTo(customer.name) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
