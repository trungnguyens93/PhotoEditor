package com.fragmgia.photoeditor.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.fragmgia.photoeditor.R;
import com.fragmgia.photoeditor.util.ConstantManager;

/**
 * Created by trungnguyens93gmail.com on 5/12/17.
 */
public class CustomMergeImage extends android.support.v7.widget.AppCompatImageView {
    private Paint mPaint;
    private static final int sWidth = 500, sHeight = 500;
    private Rect mRectFirstImage = new Rect();
    private Rect mRectSecondImage = new Rect();
    private Rect mRectThreeImage = new Rect();
    private Rect mRectFourImage = new Rect();
    private Context mContext;
    private Bitmap mBitmapOne;
    private Bitmap mBitmapTwo;
    private int mNumberLayout;
    private Bitmap mBitmapThree;
    private Bitmap mBitmapFour;
    private int mType;
    private EventImageView mEventImageView;

    public CustomMergeImage(Context context) {
        super(context);
        init(context);
    }

    public CustomMergeImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomMergeImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void setEvent(EventImageView event) {
        mEventImageView = event;
    }

    private void init(Context context) {
        mContext = context;
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(ConstantManager.STROCKE_WIDTH);
        mPaint.setStyle(Paint.Style.STROKE);
        mBitmapOne = BitmapFactory.decodeResource(mContext.getResources(),
            R.drawable.ic_function_done);
        mBitmapTwo = BitmapFactory.decodeResource(mContext.getResources(),
            R.drawable.ic_function_done);
        mBitmapThree = BitmapFactory.decodeResource(mContext.getResources(),
            R.drawable.ic_function_done);
        mBitmapFour = BitmapFactory.decodeResource(mContext.getResources(),
            R.drawable.ic_function_done);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (mNumberLayout) {
            case ConstantManager.LAYOUT_OLD:
                drawerTypeZezo(canvas);
                break;
            case ConstantManager.LAYOUT_ONE:
                drawerTypeOne(canvas);
                break;
            case ConstantManager.LAYOUT_TWO:
                drawerTypeTwo(canvas);
                break;
            case ConstantManager.LAYOUT_THREE:
                drawerThree(canvas);
                break;
            case ConstantManager.LAYOUT_FOUR:
                drawerFour(canvas);
                break;
            default:
                invalidate();
                break;
        }
    }

    private void drawerTypeZezo(Canvas canvas) {
        canvas.drawLine(sWidth / 2, 0, sWidth / 2, sHeight, mPaint);
        canvas.drawLine(0, sHeight / 3, sWidth / 2, sHeight / 3, mPaint);
        canvas.drawRect(0, 0, sWidth, sHeight, mPaint);
        mRectFirstImage.set(0, 0, sWidth / 2, sHeight / 3);
        mRectSecondImage.set(0, sHeight / 3, sWidth / 2, sHeight);
        mRectThreeImage.set(sWidth / 2, 0, sWidth, sHeight);
        canvas.drawBitmap(mBitmapOne, null, mRectFirstImage, mPaint);
        canvas.drawBitmap(mBitmapTwo, null, mRectSecondImage, mPaint);
        canvas.drawBitmap(mBitmapThree, null, mRectThreeImage, mPaint);
    }

    private void drawerTypeOne(Canvas canvas) {
        canvas.drawLine(sWidth / 2, 0, sWidth / 2, sHeight, mPaint);
        canvas.drawRect(0, 0, sWidth, sHeight, mPaint);
        mRectFirstImage.set(0, 0, sWidth / 2, sHeight);
        mRectSecondImage.set(sWidth / 2, 0, sWidth, sHeight);
        canvas.drawBitmap(mBitmapOne, null, mRectFirstImage, mPaint);
        canvas.drawBitmap(mBitmapTwo, null, mRectSecondImage, mPaint);
    }

    private void drawerTypeTwo(Canvas canvas) {
        canvas.drawLine(0, sHeight / 2, sWidth, sHeight / 2, mPaint);
        canvas.drawRect(0, 0, sWidth, sHeight, mPaint);
        mRectFirstImage.set(0, 0, sWidth, sHeight / 2);
        mRectSecondImage.set(0, sHeight / 2, sWidth, sHeight);
        canvas.drawBitmap(mBitmapOne, null, mRectFirstImage, mPaint);
        canvas.drawBitmap(mBitmapTwo, null, mRectSecondImage, mPaint);
        canvas.scale(sWidth, sHeight);
    }

    private void drawerThree(Canvas canvas) {
        canvas.drawLine(0, sHeight / 2, sWidth, sHeight / 2, mPaint);
        canvas.drawLine(sWidth / 2, 0, sWidth / 2, sHeight, mPaint);
        canvas.drawRect(0, 0, sWidth, sHeight, mPaint);
        mRectFirstImage.set(0, 0, sWidth / 2, sHeight / 2);
        mRectSecondImage.set(0, sHeight / 2, sWidth / 2, sHeight);
        mRectThreeImage.set(sWidth / 2, 0, sWidth, sHeight / 2);
        mRectFourImage.set(sWidth / 2, sHeight / 2, sWidth, sHeight);
        canvas.drawBitmap(mBitmapOne, null, mRectFirstImage, mPaint);
        canvas.drawBitmap(mBitmapTwo, null, mRectSecondImage, mPaint);
        canvas.drawBitmap(mBitmapThree, null, mRectThreeImage, mPaint);
        canvas.drawBitmap(mBitmapFour, null, mRectFourImage, mPaint);
    }

    private void drawerFour(Canvas canvas) {
        canvas.drawLine(0, sHeight / 3, sWidth, sHeight / 3, mPaint);
        canvas.drawRect(0, 0, sWidth, sHeight, mPaint);
        mRectFirstImage.set(0, 0, sWidth, sHeight / 3);
        mRectSecondImage.set(0, sHeight / 3, sWidth, sHeight);
        canvas.drawBitmap(mBitmapOne, null, mRectFirstImage, mPaint);
        canvas.drawBitmap(mBitmapTwo, null, mRectSecondImage, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(sWidth, sHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setImageItem(x, y);
                if (mEventImageView != null) mEventImageView.clickPickImage();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private void setImageItem(float x, float y) {
        switch (mNumberLayout) {
            case ConstantManager.LAYOUT_OLD:
                if (x <= sWidth / 2 && y <= sHeight / 3) mType = ConstantManager.LAYOUT_ONE;
                if (x <= sWidth / 2 && y >= sHeight / 3) mType = ConstantManager.LAYOUT_TWO;
                if (x >= sWidth / 2 && y <= sHeight) mType = ConstantManager.LAYOUT_THREE;
                break;
            case ConstantManager.LAYOUT_ONE:
                if (x <= sWidth / 2 && y <= sHeight) mType = ConstantManager.LAYOUT_ONE;
                else mType = ConstantManager.LAYOUT_TWO;
                break;
            case ConstantManager.LAYOUT_TWO:
                if (x <= sWidth && y <= sHeight / 2) mType = ConstantManager.LAYOUT_ONE;
                else mType = ConstantManager.LAYOUT_TWO;
                break;
            case ConstantManager.LAYOUT_THREE:
                if (x <= sWidth / 2 && y <= sHeight / 2) mType = ConstantManager.LAYOUT_ONE;
                if (x >= sWidth / 2 && y <= sHeight / 2) mType = ConstantManager.LAYOUT_TWO;
                if (x <= sWidth / 2 && y >= sHeight / 2) mType = ConstantManager.LAYOUT_THREE;
                if (x > sWidth / 2 && y > sHeight / 2) mType = ConstantManager.LAYOUT_FOUR;
                break;
            case ConstantManager.LAYOUT_FOUR:
                if (x <= sWidth && y < sHeight / 3) mType = ConstantManager.LAYOUT_ONE;
                if (x <= sWidth && y > sHeight / 3) mType = ConstantManager.LAYOUT_TWO;
                break;
            default:
                break;
        }
    }

    public void setBitmap(Bitmap bitmap) {
        switch (mType) {
            case ConstantManager.LAYOUT_ONE:
                this.mBitmapOne = bitmap;
                break;
            case ConstantManager.LAYOUT_TWO:
                this.mBitmapTwo = bitmap;
                break;
            case ConstantManager.LAYOUT_THREE:
                mBitmapThree = bitmap;
                break;
            case ConstantManager.LAYOUT_FOUR:
                mBitmapFour = bitmap;
                break;
            default:
                break;
        }
        invalidate();
    }

    public void setNumberLayout(int numberLayout) {
        mNumberLayout = numberLayout;
    }

    public interface EventImageView {
        void clickPickImage();
    }
}

