package com.example.movie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class CircularFrameView extends View {
    private Paint mWhitePaint;
    // Path객체를 생성하고, 이제 해당 객체를 통해 원하는 이미지를 만든다.
    private Path mPath = new Path();

    // 복붙
    public CircularFrameView(Context context) {
        super(context); initPaints();
    }

    // 복붙
    public CircularFrameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    // 복붙
    public CircularFrameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    private void initPaints(){
        mWhitePaint = new Paint();
        mWhitePaint.setColor(getResources().getColor(R.color.colorPrimaryDark)); // 원의 색깔
        mWhitePaint.setStrokeWidth(6); // 원의 두께
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();
        // 경로에 동그라미 추가
        mPath.addCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2-4, Path.Direction.CW);
        // 만약 색칠하면 원 안쪽에만 채우겠다!
        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);

        canvas.clipPath(mPath);
        // 원 안쪽에 '투명' 색?을 칠한다.
        canvas.drawColor(Color.parseColor("#FFFFFF"));

        mWhitePaint.setStyle(Paint.Style.STROKE);
        // 위에서 작성한 내용대로 캔버스에 그림을 그린다. 그린 결과물이 우리가 만든 CircularFrameView 객체가 된다.
        canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2-2, mWhitePaint);
    }
}
