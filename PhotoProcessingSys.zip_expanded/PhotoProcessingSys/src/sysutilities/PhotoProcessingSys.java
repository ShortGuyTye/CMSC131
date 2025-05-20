package sysutilities;

import javax.swing.JOptionPane;

public class PhotoProcessingSys {
	private String name;
	private Address address;
	private double balance;
	private int transNum = 1;
	private StringBuffer log = new StringBuffer("Image Transactions\n");
	
	public PhotoProcessingSys(String name, String street, String city, String state, String zipcode) {
		Address photoAddress = new Address(street, city, state, zipcode);
		address = new Address(photoAddress);
		this.name = name;
	}
	public PhotoProcessingSys() {
		name = "NONAME";
		address = new Address();
	}
	public String toString() {
		String output = "Customer Name: " + name +"\nCustomer Address: " 
	+ address + "\nBalance: " + balance;
		return output;
	}
	public String imageTransaction(String imageName, String task, String taskOptions, boolean graphicalMode) {
		if (graphicalMode) {
			PictureManager.graphicalModeOn();
		} else {
			PictureManager.graphicalModeOff();
		}
		if(task.equals("display")) {
			String returnString = PictureManager.displayPicture(imageName);
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("clear")) {
			String returnString = PictureManager.clearScreen();
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("displaylast")) {
			String returnString = PictureManager.displayLastPicture();
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("blackandwhite")) {
			String returnString = PictureManager.displayPictureBlackWhitePosterize(imageName, true, false);
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("posterize")) {
			String returnString = PictureManager.displayPictureBlackWhitePosterize(imageName, false, true);
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("blackandwhiteposterize")) {
			String returnString = PictureManager.displayPictureBlackWhitePosterize(imageName, true, true);
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 1;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		}else if(task.equals("selectcolors")) {
			boolean isRed = false, isGreen = false, isBlue = false;
			taskOptions = taskOptions.toUpperCase();
			for (int i = 0; i < taskOptions.length(); i++) {
				if (taskOptions.charAt(i) == 'R') {
					isRed = true;
				}
				if (taskOptions.charAt(i) == 'G') {
					isGreen = true;
				}
				if (taskOptions.charAt(i) == 'B') {
					isBlue = true;
				}
			}
			String returnString = PictureManager.displayPictureSelectRedGreenBlue(imageName, isRed, isGreen, isBlue);
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			balance += 2;
			log.append("Transaction #" + transNum + ": " + returnString);
			transNum += 1;
			return returnString;
		} else {
			JOptionPane.showMessageDialog(null, "Continue");
			log.append("Transaction #" + transNum + ": Invalid photoProcessing option");
			return "Invalid photoProcessing option";
		}
	}
	public String getTransactions() {
		return(log.toString());
	}
	public double getBalance() {
		return balance;
	}
}