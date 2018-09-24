import javax.swing.SwingUtilities;

public class WindowsMain {

	public static void main(String args[]) throws Exception {
		SwingUtilities.invokeAndWait(new Runnable() {
			
			@Override
			public void run() {
				try {
					new WindowsGame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
