package test;

import java.util.UUID;

import org.junit.Test;

public class TestGarage {

	@Test
	public void testUUID() {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());

	}

	@Test
	public void testPostIncrement() {
		int i = 1;
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i++);
	}

	@Test
	public void testPreIncrement() {
		int i = 0;
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(++i);
		System.out.println(++i);
	}

}
