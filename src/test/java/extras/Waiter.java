package extras;

public class Waiter {
	
	public static void waitForPage(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			System.out.println("Hubo una interrupcion");
		}
	}
}
