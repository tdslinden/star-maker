import javax.swing.JFrame;

// File: Student
// Name: Linden Kyaw
// Student ID: 100263295

/**
   A class which creates the frame where graphics can be viewed.
*/

public class StarViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 800;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("Stars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		StarComponent component = new StarComponent();
		frame.add(component);
		
		frame.setVisible(true);
   }
}