package com.lzyblog.pagetransform;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class AlphaPageTransformer implements PageTransformer {

	//��Ļ��߽�position=0���ұ߽�position=1
	public void transformPage(View view, float position) {
		if (position < -1) { // [-Infinity,-1)
			// ���󻬶�����ǰҳ���ǰһҳ.
			ViewHelper.setAlpha(view, 0);
		} else if (position <= 0) { //[-1, 0]
			if (position < -0.6f) {
				ViewHelper.setAlpha(view, 0.4f);
			} else {
				ViewHelper.setAlpha(view, 1 + position);
			}
		} else if (position <= 1) { // (0,1]
			ViewHelper.setAlpha(view, 1 - position);
		} else { // (1,+Infinity]
			//���һ�������ǰҳ��ĺ�һҳ
			ViewHelper.setAlpha(view, 0);
		}
	}

}
