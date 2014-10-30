package com.lzyblog.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.lzyblog.R;
import com.lzyblog.indicator.CirclePageIndicator;
import com.lzyblog.pagetransform.AlphaPageTransformer;
import com.lzyblog.ui.fragment.FriendListFragment;
import com.lzyblog.ui.fragment.GroupListFrament;
import com.lzyblog.ui.module.TitleModule;

public class MainActivity extends FragmentActivity {
	private static final int NUM_PAGES = 2;

	TitleModule titleModule;

	ViewPager mPager;
	PagerAdapter mPagerAdapter;
	CirclePageIndicator mPageIndicator;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);

		init();
	}

	private void init() {
		//������
		titleModule = new TitleModule(this, "����");
		titleModule.showBack(false);
		titleModule.setBackText("�������");
		titleModule.setBackClickListener(onClickListener);

		//���һ�����ViewPager
		mPager = (ViewPager) findViewById(R.id.pager);
		mPageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mPagerAdapter = new PageAdapter(getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
		mPageIndicator.setViewPager(mPager);
		//page�л�����Ч������pagetransform���������Ķ���Ч��
		mPager.setPageTransformer(true, new AlphaPageTransformer());
		mPager.setOnPageChangeListener(new OnPageChangeListener() {
			public void onPageSelected(int position) {
				if (position == 0) {
					titleModule.setTitle("����");
				} else if (position == 1) {
					titleModule.setTitle("Ⱥ��");
				}
			}

			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			public void onPageScrollStateChanged(int arg0) {

			}
		});

		//��ʾ
		Toast.makeText(MainActivity.this, "�����һ������л������б��Ⱥ���б�", Toast.LENGTH_LONG).show();
	}

	OnClickListener onClickListener = new OnClickListener() {
		public void onClick(View v) {
			if (v == titleModule.btnBack) { //�������

			}
		}
	};

	class PageAdapter extends FragmentPagerAdapter {

		public PageAdapter(FragmentManager fm) {
			super(fm);
		}

		public Fragment getItem(int position) {
			if (position == 0) {
				return new FriendListFragment();
			} else {
				return new GroupListFrament();
			}
		}

		public int getCount() {
			return NUM_PAGES;
		}
	}

}