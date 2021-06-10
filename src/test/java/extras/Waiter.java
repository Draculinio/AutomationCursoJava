package extras;

public class Waiter {
	
	/**
	 * This is for static waiting
	 * @param milis the number of miliseconds
	 */
	public static void waitForPage(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			System.out.println("Hubo una interrupcion");
		}
	}
}
