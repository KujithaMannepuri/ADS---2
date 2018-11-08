
public class SeamCarver {
	Picture pic;
	int height;
	int width;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.pic = picture;
		this.width = pic.width();
		this.height = pic.height();

	}
	// current picture
	public Picture picture() {
		return null;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		if (x == 0 || y == 0 || x == pic.width() - 1 || y == pic.height() - 1) {
			return 1000;
		}
		double col = 0;
		double row = 0;
		double xRedTop = pic.get(x - 1, y).getRed();
		double xRedBot = pic.get(x + 1, y).getRed();
		double yRedRght = pic.get(x, y - 1).getRed();
		double yRedLeft = pic.get(x, y + 1).getRed();
		double xBlueTop = pic.get(x - 1, y).getBlue();
		double xBlueBot = pic.get(x + 1, y).getBlue();
		double yBlueRght = pic.get(x, y - 1).getBlue();
		double yBlueLeft = pic.get(x, y + 1).getBlue();
		double xGreenTop = pic.get(x - 1, y).getGreen();
		double xGreenBot = pic.get(x + 1, y).getGreen();
		double yGreenRght = pic.get(x, y - 1).getGreen();
		double yGreenLeft = pic.get(x, y + 1).getGreen();
		col = Math.pow(xRedTop - xRedBot, 2) + Math.pow(xBlueTop - xBlueBot, 2) + Math.pow(xGreenTop - xGreenBot, 2);
		row = Math.pow(yRedRght - yRedLeft, 2) + Math.pow(yBlueRght - yBlueLeft, 2) + Math.pow(yGreenRght - yGreenLeft, 2);
		double energySum = Math.sqrt(col + row);
		return energySum;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}