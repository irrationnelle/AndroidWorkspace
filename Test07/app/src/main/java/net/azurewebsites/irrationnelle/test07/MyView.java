package net.azurewebsites.irrationnelle.test07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MyView extends View {
    private int x=100, y=100;

    // Context object is attached something like Activity Object
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.BLACK);
    }

    // Whenever application execute, app call onDraw method

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(x, y, x+50, y+50, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventX = (int) event.getX();
        int eventY = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Rase", "Pushed!");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Rase", "Moving!");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("Rase", "Detached!");
                break;
        }

        x = eventX;
        y = eventY;

        // repaint with new x, y axis
        invalidate();

        return true;
    }
}
