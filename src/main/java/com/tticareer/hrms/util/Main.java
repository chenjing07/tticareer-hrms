package com.tticareer.hrms.util;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main
{
    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入图片地址ַ");
        String img_file = scanner.nextLine();
        System.out.println("输入txt存储地址ַ");
        String out_file = scanner.nextLine();
        // 读取图片
        BufferedImage binaryBufferedImage = ImageIO.read(new File(img_file));
        int orgWidth=binaryBufferedImage.getWidth();
        int orgHeight=binaryBufferedImage.getHeight();
        int size=Math.max(orgHeight,orgWidth);
        int w = size>1000?binaryBufferedImage.getWidth()/3:orgWidth;
        int h = size>1000?binaryBufferedImage.getHeight()/3:orgHeight;

        binaryBufferedImage.getGraphics().drawImage(binaryBufferedImage, 0, 0, w, h, null);

        BufferedWriter bw = new BufferedWriter(new FileWriter(out_file));

        final String base = "@#&$%*o!;.";// 字符串从复杂到简单
        for (int y = 0; y < h; y += 2) {
            for (int x = 0; x < w; x++) {
                final int pixel = binaryBufferedImage.getRGB(x, y);
                final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                final int index = Math.round(gray * (base.length() + 1) / 255);
                bw.write((index >= base.length() ? " " : String.valueOf(base.charAt(index))));
            }
            bw.newLine();
        }
        bw.close();
    }
}