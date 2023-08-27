package com.intelliacademy.lesson.cp4;

public class PerformanceOptimization {

    public static void main(String[] args) {
        ImageProcessor imageProcessor  = new ImageProcessor(
                "src/main/resources/input/flw1.jpg",
                "src/main/resources/output/flw1.jpg"
        );
        imageProcessor.proceed();
    }

}
