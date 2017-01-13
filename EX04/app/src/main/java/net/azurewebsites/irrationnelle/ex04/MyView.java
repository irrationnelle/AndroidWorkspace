package net.azurewebsites.irrationnelle.ex04;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by irrationnelle on 1/11/17.
 */

public class MyView extends View {
    private Paint paint;
    private Path path;
    private List<Paint> paintList;
    private List<Path> pathList;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        pathList = new ArrayList<>();

        paint = new Paint();
        paintList = new ArrayList<>();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(10f);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i=0; i<pathList.size(); i++) {
            canvas.drawPath(pathList.get(i), paintList.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        Paint currentPaint = this.paint;
        Path currentPath = this.path;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                currentPath.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE :
                currentPath.lineTo(eventX, eventY);
                break;
        }

        paintList.add(currentPaint);
        pathList.add(currentPath);

        invalidate();
        return true;
    }

//    public Paint getPaint() {
//        return this.paint;
//    }

    public void setPaint(Paint paint) {
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.BLACK);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(10f);
        paint.setAntiAlias(true);
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
