package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import photomanager.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void student01() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		String answer = "umcp/college1.jpg,100,100,10/18/2020-17:10";
		assertTrue(photo.toString().equals(answer));
	}

	@Test
	public void student02() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		String answer = "umcp/college1.jpg";
		assertTrue(photo.getPhotoSource().equals(answer));
	}

	@Test
	public void student03() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		int answer = 100;
		assertTrue(photo.getWidth() == answer);
	}

	@Test
	public void student04() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 200, "10/18/2020-17:10");
		int answer = 200;
		assertTrue(photo.getHeight() == answer);
	}

	@Test
	public void student05() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		String answer = "10/18/2020-17:10";
		assertTrue(photo.getDate().equals(answer));
	}

	@Test
	public void student06() {
		try {
			Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
			photo.addComments("");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void student07() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		photo.addComments("barn");
		String answer = "barn";
		assertTrue(photo.getComments().equals(answer));
	}

	@Test
	public void student08() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		photo.addComments("barn");
		Photo copy = new Photo(photo);
		assertTrue(photo.toString().equals(copy.toString()));
	}

	@Test
	public void student09() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		photo.addComments("barn");
		Photo copy = new Photo(photo);
		assertTrue(photo.compareTo(copy) == 0);
	}

	@Test
	public void student10() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		Photo newPhoto = new Photo("umcp/college1.jpg", 100, 100, "10/19/2020-17:10");
		assertTrue(photo.compareTo(newPhoto) == -1);
	}

	@Test
	public void student11() {
		Photo photo = new Photo("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		Photo newPhoto = new Photo("umcp/college1.jpg", 100, 100, "10/17/2020-17:10");
		assertTrue(photo.compareTo(newPhoto) == 1);
	}

	@Test
	public void student12() {
		PhotoManager pman = new PhotoManager();
		assertTrue(pman.addPhoto(null, 100, 100, "10/18/2020-17:10") == false);

	}

	@Test
	public void student13() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		String answer = "umcp/college1.jpg,100,100,10/18/2020-17:10\n";
		assertTrue(pman.toString().equals(answer));

	}

	@Test
	public void student14() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		assertTrue(pman.findPhoto(null) == -1);

	}

	@Test
	public void student15() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		assertFalse(pman.addComment("umcp/college1.jpg", ""));

	}

	@Test
	public void student16() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		assertTrue(pman.getComments(null) == null);

	}

	@Test
	public void student17() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		pman.addPhoto("umcp/college2.jpg", 500, 400, "10/18/2020-17:10");
		pman.removeAllPhotos();
		assertTrue(pman.toString().equals(""));

	}

	@Test
	public void student18() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		pman.addPhoto("umcp/college2.jpg", 500, 400, "10/18/2020-17:10");
		pman.removePhoto("umcp/college1.jpg");
		String answer = "umcp/college2.jpg,500,400,10/18/2020-17:10\n";
		assertTrue(pman.toString().equals(answer));

	}

	@Test
	public void student19() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/18/2020-17:10");
		assertFalse(pman.loadPhotos(null));

	}

	@Test
	public void student20() {
		PhotoManager pman = new PhotoManager();
		pman.addPhoto("umcp/college1.jpg", 100, 100, "10/20/2020-17:10");
		pman.addPhoto("umcp/college2.jpg", 400, 500, "10/18/2020-17:10");
		pman.sortPhotosByDate();
		System.out.println(pman.toString());
		assertTrue(pman.toString()
				.equals("umcp/college2.jpg,400,500,10/18/2020-17:10\numcp/college1.jpg,100,100,10/20/2020-17:10\n"));

	}

}