package org.freecoding.servicesmanager.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.EditText;

public class LinedEditText extends EditText {

    private Paint linePaint;


    public LinedEditText(Context paramContext, AttributeSet paramAttributeSet) {

        super(paramContext, paramAttributeSet);

        this.linePaint = new Paint();

    }

    protected void onDraw(Canvas paramCanvas) {

        paramCanvas.drawColor(Color.parseColor("#ff0000"));

        int i = getLineCount();

        int j = getHeight();

        int k = getLineHeight();

        int m = 1 + j / k;

        if (i < m)

            i = m;

        int n = getCompoundPaddingTop();

        paramCanvas.drawLine(0.0F, n, getRight(), n, this.linePaint);

        for (int i2 = 0; ; i2++) {

            if (i2 >= i) {

                setPadding(10 , 0, 0, 0);

                super.onDraw(paramCanvas);

                paramCanvas.restore();

                return;

            }

            n += k;

            paramCanvas.drawLine(0.0F, n, getRight(), n, this.linePaint);

            paramCanvas.save();

        }

    }

}