package com.intelliacademy.lesson.cp4;

import java.util.Objects;

public class RGB {
    private  Integer rgb;

    private  Integer red;
    private  Integer green;
    private  Integer blue;

    public RGB(Integer rgb){
        this.rgb = rgb;
        this.red = this.red(this.rgb);
        this.green = this.green(this.rgb);
        this.blue = this.blue(this.rgb);
    }

    public Integer getGreen() {
        return green;
    }

    public Integer getBlue() {
        return blue;
    }

    public Integer getRed() {
        return red;
    }

    private Integer red(Integer rgb){
        return (rgb & 0x00FF0000) >> 16;
    }


    private Integer green(Integer rgb){
        return (rgb & 0x0000FF00) >> 8;
    }


    private Integer blue(Integer rgb){
        return (rgb & 0x000000FF);
    }

    private RGB(Builder builder) {
        rgb = builder.rgb;
        red = builder.red;
        green = builder.green;
        blue = builder.blue;
    }

    public Integer getRgb() {
        return rgb;
    }

    public Boolean isShadeOfGrey(){
        return Math.abs(red - green) < 30
                && Math.abs(red - blue) < 30
                && Math.abs(green - blue) < 30;
    }

    public static final class Builder {
        private Integer rgb;
        private Integer red;
        private Integer green;
        private Integer blue;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder red(Integer val) {
            red = Objects.requireNonNullElse(val,0);
            return this;
        }

        public Builder green(Integer val) {
            green = Objects.requireNonNullElse(val,0);
            return this;
        }

        public Builder blue(Integer val) {
            blue = Objects.requireNonNullElse(val,0);
            return this;
        }

        public RGB build() {
            int rgb = 0;
            rgb |= blue;
            rgb |= green << 8;
            rgb |= red << 16;

            rgb |= 0xFF000000;
            return new RGB(this);
        }
    }


}
