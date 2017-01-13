package net.azurewebsites.irrationnelle.test08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MyView extends View {
    private Paint paint;
    private Path path;

    public MyView(Context context) {
        super(context);

        path = new Path();

        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f); // 실선의 두께
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setAntiAlias(true); // 선의 둘레 경계를 매끄럽게
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint); //
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
        }

        invalidate();
        return true;
    }
}
