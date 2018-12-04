import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ASCII {
	public static void printImg(String path, int resolution) throws IOException {
		File file = new File(path);
		BufferedImage img = ImageIO.read(file);
		String cha = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/|()1{}[]?-_+~<>i!lI;:,^`.";
		char[] chaArr = cha.toCharArray();
		int width = img.getWidth();
		int height = img.getHeight();
		int sizeW,sizeH,scale;
		if (width > height) {
			sizeW = resolution;
			scale = width / sizeW;
			if (scale <= 1) {
				scale = 1;
			}
			sizeW = width / (scale / 2);
			sizeH = height / scale;
		} else {
			sizeH = resolution;
			scale = height / sizeH;
			if (scale <=1 ) {
				scale = 1;
			}
			sizeH = height / scale;
			sizeW = width / (scale / 2);
		}

		int temp = 0;
		int c = 0;
		char[] output = new char[(sizeW * (scale / 2)) * (sizeH * scale)];
		
		/*
		 * This section gets the average greyscale of the pixels in which the size of the average
		 * is calculated from the resolution. This is initialised by selecting easy, medium or hard
		 * in the game startup
		 */
		for (int i = 0; i < height - (scale - 1); i += scale) {
			for (int j = 0; j < width - ((scale / 2) - 1); j += (scale / 2)) {
				for (int k = 0; k < (scale) / 2; k++) {
					for (int l = 0; l < scale; l++) {
						int p = img.getRGB(j + k, i + l);
						int r = (p >> 16) & 0xff;
						int g = (p >> 8) & 0xff;
						int b = p & 0xff;
						temp += r + g + b;
					}
				}
				temp = (temp / (scale * (scale / 2)))/chaArr.length;
				output[c] = chaArr[chaArr.length-1-temp];
				c++;
				temp = 0;
			}
		}

		for (int i = 0; i < sizeW * sizeH; i++) {
			System.out.print(output[i]);
			if ((i + 1) % (sizeW) == 0) {
				System.out.println();
			}
		}
	}
}
