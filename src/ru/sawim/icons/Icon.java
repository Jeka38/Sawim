package ru.sawim.icons;


import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class Icon {
    private Drawable image;

    public Icon(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }
}

