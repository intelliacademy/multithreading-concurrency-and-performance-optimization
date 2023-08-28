package com.intelliacademy.lesson.cp4;

public class PerformanceOptimizationApplication {

    public static void main(String[] args) {
        ImageProcessor imageProcessor  = new ImageProcessor(
                "src/main/resources/input/flw3.jpg",
                "src/main/resources/output/flw3.jpg"
        );
        imageProcessor.proceed();
    }

}
