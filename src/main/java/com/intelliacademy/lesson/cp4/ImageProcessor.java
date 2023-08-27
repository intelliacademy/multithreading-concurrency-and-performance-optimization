package com.intelliacademy.lesson.cp4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {
    private String SOURCE_FILE;
    private String DESTINATION_FILE;

    public ImageProcessor(String source,String output){
        this.SOURCE_FILE = source;
        this.DESTINATION_FILE = output;
    }

    public void proceed(){
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(SOURCE_FILE));
            var outputImage = generateOutputImage(bufferedImage);
            this.proceedSingleThread(bufferedImage,outputImage);
            ImageIO.write(outputImage,"jpg",new File(DESTINATION_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void proceedSingleThread(BufferedImage input,BufferedImage output){
        this.recolorImage(input,output,0,0,input.getWidth(),input.getHeight());
    }

    private void recolorImage(BufferedImage input,BufferedImage output,int leftCorner,int rightCorner,
                              int width,int height){
        for (int x = leftCorner;x < leftCorner + width && x < input.getWidth();x++){
            for (int y = rightCorner; y < rightCorner + height && y < input.getHeight(); y++){
                this.recolorPixel(input,output,x,y);
            }
        }
    }

    private void recolorPixel(BufferedImage input,BufferedImage outPut,int x,int y){
        RGB rgb = new RGB(input.getRGB(x, y));

        int newRed;
        int newGreen;
        int newBlue;

        if (rgb.isShadeOfGrey()){
            newRed = Math.min(255,rgb.getRed());
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
    }

    private void setRGB(BufferedImage output,int x,int y,int rgb){
        output.getRaster().setDataElements(x,y,output.getColorModel().getDataElements(rgb,null));
    }

    private BufferedImage generateOutputImage(BufferedImage sourceImage){
        return new BufferedImage(sourceImage.getWidth(),sourceImage.getHeight(),BufferedImage.TYPE_INT_RGB);
    }
}
