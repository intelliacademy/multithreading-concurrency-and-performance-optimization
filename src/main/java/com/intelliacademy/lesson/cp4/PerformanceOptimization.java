package com.intelliacademy.lesson.cp4;

public class PerformanceOptimization {

    public static void main(String[] args) {
        ImageProcessor imageProcessor  = new ImageProcessor(
                "src/main/resources/input/flw2.jpg",
                "src/main/resources/output/flw2.jpg"
        );
        imageProcessor.proceed();
    }

}
