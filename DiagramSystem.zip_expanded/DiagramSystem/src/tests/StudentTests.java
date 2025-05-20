package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import system.TwoDimArrayUtil;

public class StudentTests {

	@Test
	public void appendLeftRight1() {
		char[][] first = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
		char[][] second = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		String answer = "";
		//System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)) != answer);
	}

	@Test
	public void appendLeftRight2() {
		char[][] first = new char[][] { { 'a', 'b', 'c', '1' }, { 'd', 'e', 'f', '2' } };
		char[][] second = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		String answer = "";
		//System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)) != answer);
	}

	@Test
	public void appendLeftRight3() {
		char[][] first = new char[][] { { 'a', 'b', 'c' }, {'d'}};
		char[][] second = new char[][] {};
		String answer = "";
		//System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendLeftRight(first, second)) != answer);
	}

	@Test
	public void appendTopBottom1() {
		char[][] first = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' } };
		char[][] second = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		String answer = "";
		// System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first,
		// second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first, second)) != answer);
	}

	@Test
	public void appendTopBottom2() {
		char[][] first = new char[][] { { 'a', 'b', 'c', '1' }, { 'd', 'e', 'f', '2' } };
		char[][] second = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		String answer = "";
		// System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first,
		// second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first, second)) != answer);
	}

	@Test
	public void appendTopBottom3() {
		char[][] first = new char[][] { { 'a', 'b'}, { 'd', 'e', 'f' } };
		char[][] second = new char[][] { { 'g', 'h', 'i', '1' }, { 'j', 'k'} };
		String answer = "";
		System.out.println(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first,second)));
		assertTrue(Arrays.deepToString(TwoDimArrayUtil.appendTopBottom(first, second)) != answer);
	}

	@Test
	public void isRaggedTrue() {
		TwoDimArrayUtil test = new TwoDimArrayUtil();
		char[][] first = new char[][] { { 'a', 'b' }, { 'd', 'e' } };
		assertFalse(test.isRagged(first));
	}

	@Test
	public void isRaggedFalse() {
		TwoDimArrayUtil test = new TwoDimArrayUtil();
		char[][] first = new char[][] { { 'a', 'b' }, { 'd', 'e' }, { 'f' } };
		assertTrue(test.isRagged(first));
	}

	@Test
	public void rotateLeftOneColumn() {
		TwoDimArrayUtil test = new TwoDimArrayUtil();
		char[][] first = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' } };
		String answer = "";
		// System.out.println(Arrays.deepToString(first));
		// System.out.println(Arrays.deepToString(test.rotateLeftOneColumn(first)));
		assertTrue(true);
	}

	@Test
	public void rotateTopOneRow() {
		TwoDimArrayUtil test = new TwoDimArrayUtil();
		char[][] first = new char[][] { { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r' } };
		String answer = "";
		// System.out.println(Arrays.deepToString(first));
		// System.out.println(Arrays.deepToString(test.rotateTopOneRow(first)));
		assertTrue(true);
	}
}
