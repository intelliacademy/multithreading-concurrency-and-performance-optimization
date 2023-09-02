package com.intelliacademy.lesson.cp4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    private String SOURCE_FILE;
    private String DESTINATION_FILE;

    private BufferedImage outputImage;

    public ImageProcessor(String source,String output){
        this.SOURCE_FILE = source;
        this.DESTINATION_FILE = output;
    }

    public void proceed(){
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(SOURCE_FILE));
            this.outputImage = generateOutputImage(bufferedImage);
            this.proceedSingleThread(bufferedImage);
            ImageIO.write(this.outputImage,"jpg",new File(DESTINATION_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void proceedSingleThread(BufferedImage input){
        this.draw(input,this.outputImage,0,0,input.getWidth(),input.getHeight());
    }

    private void draw(BufferedImage input, BufferedImage output, int leftCorner, int topCorner,
                      int width, int height){
        for (int x = leftCorner;x < leftCorner + width && x < input.getWidth();x++){
            for (int y = topCorner; y < topCorner + height && y < input.getHeight(); y++){
                this.drawPixel(input,x,y);
            }
        }
    }

    private void drawPixel(BufferedImage input, int x, int y){
        RGB rgb = new RGB(input.getRGB(x, y));

        int newRed;
        int newGreen;
        int newBlue;

        if (rgb.isShadeOfGrey()){
            newRed = Math.min(255,rgb.getRed() + 10);
            newGreen = Math.max(0,rgb.getGreen() - 80);
            newBlue = Math.max(0,rgb.getBlue() - 20);
        }else {
            newRed = rgb.getRed();
            newGreen = rgb.getGreen();
            newBlue = rgb.getBlue();
        }
        RGB newRgb = RGB.Builder
                .builder()
                .red(newRed)
                .green(newGreen)
                .blue(newBlue)
                .build();
        this.setRGB(x,y,newRgb.getRgb());
    }

    private void setRGB(int x,int y,int rgb){
        this.outputImage.getRaster().setDataElements(x,y,this.outputImage.getColorModel().getDataElements(rgb,null));
    }

    private BufferedImage generateOutputImage(BufferedImage sourceImage){
        return new BufferedImage(sourceImage.getWidth(),sourceImage.getHeight(),BufferedImage.TYPE_INT_RGB);
    }
}
