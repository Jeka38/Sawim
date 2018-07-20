package ru.sawim.icons;


import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.MultiCallback;
import ru.sawim.comm.DrawableCallback;

public class AniIcon extends Icon {
    private GifDrawable image;
    private DrawableCallback drawableCallback;

    @Override
    public GifDrawable getImage() {
        return image;
    }

    public void setDrawableCallback(DrawableCallback drawableCallback) {
        this.drawableCallback = drawableCallback;
    }

    public DrawableCallback getDrawableCallback() {
        return drawableCallback;
    }

    public AniIcon(GifDrawable image) {
        super(image);
        this.image = image;
    }

}