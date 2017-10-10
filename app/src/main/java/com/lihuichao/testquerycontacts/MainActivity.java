package com.lihuichao.testquerycontacts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.OvershootInterpolator;
import android.widget.ListView;
import android.widget.TextView;

import com.lihuichao.quicklyquerycontacts.MyAdapter;
import com.lihuichao.quicklyquerycontacts.QuickIndexBar;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {
	private QuickIndexBar quickIndexBar;
	private ListView listview;
	private TextView currentWord;
	
	private ArrayList<Entity> friendliest = new ArrayList<Entity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		quickIndexBar = (QuickIndexBar) findViewById(R.id.quickIndexBar);
		listview = (ListView) findViewById(R.id.listview);
		currentWord = (TextView) findViewById(R.id.currentWord);
		
		//1.准备数据
		fillList();
		//2.对数据进行排序
		Collections.sort(friendliest);
		//3.设置Adapter

		listview.setAdapter(new MyAdapter(this, friendliest));
		
		quickIndexBar.setOnTouchLetterListener(new QuickIndexBar.OnTouchLetterListener() {
			@Override
			public void onTouchLetter(String letter) {
				//根据当前触摸的字母，去集合中找那个item的首字母和letter一样，然后将对应的item放到屏幕顶端
				for (int i = 0; i < friendliest.size(); i++) {
					String firstWord = friendliest.get(i).getPinyin().charAt(0)+"";
					if(letter.equals(firstWord)){
						//说明找到了，那么应该讲当前的item放到屏幕顶端
						listview.setSelection(i);
						break;//只需要找到第一个就行
					}
				}
				
				//显示当前触摸的字母
				showCurrentWord(letter);
			}
		});
		
		
		//通过缩小currentWord来隐藏
		ViewHelper.setScaleX(currentWord, 0);
		ViewHelper.setScaleY(currentWord, 0);

	}
	private boolean isScale = false;
	private Handler handler = new Handler();
	protected void showCurrentWord(String letter) {
		currentWord.setText(letter);
		if(!isScale){
			isScale = true;
			ViewPropertyAnimator.animate(currentWord).scaleX(1f)
			.setInterpolator(new OvershootInterpolator())
			.setDuration(450).start();
			ViewPropertyAnimator.animate(currentWord).scaleY(1f)
			.setInterpolator(new OvershootInterpolator())
			.setDuration(450).start();
		}
		
		//先移除之前的任务
		handler.removeCallbacksAndMessages(null);
		
		//延时隐藏currentWord
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
//				currentWord.setVisibility(View.INVISIBLE);
				ViewPropertyAnimator.animate(currentWord).scaleX(0f).setDuration(450).start();
				ViewPropertyAnimator.animate(currentWord).scaleY(0f).setDuration(450).start();
				isScale = false;
			}
		}, 1500);
	}

	private void fillList() {
		//1，若果是使用框架把json串快速生成实体类，则需要在你的实体类中实现Friend的setName（）方法，传入的参数为排序的依据，可以为name等string类型字符串。
		Entity entity=new Entity();
		entity.setNick("hello");
		friendliest.add(entity);
		Entity entity2=new Entity();
		entity2.setNick("(^o^)~");
		friendliest.add(entity2);
		Entity entity3=new Entity();
		entity3.setNick("李的开");
		friendliest.add(entity3);
		Entity entity4=new Entity();
		entity4.setNick("#lll");
		friendliest.add(entity4);
Entity entity5=new Entity();
		entity5.setNick("$kdd");
		friendliest.add(entity5);
Entity entity6=new Entity();
		entity6.setNick("7928");
		friendliest.add(entity6);
Entity entity7=new Entity();
		entity7.setNick("重工");
		friendliest.add(entity7);


		//2，如果你用构造方法生成你的实体类，则需要在实体类的构造方法中实现Friend的setName（）方法，
		friendliest.add(new Entity("ame"));
		friendliest.add(new Entity("阿修罗"));
		friendliest.add(new Entity("昂纳阿斯"));
		friendliest.add(new Entity("阿里巴巴"));
		friendliest.add(new Entity("12345"));
		friendliest.add(new Entity("包装桶"));
		friendliest.add(new Entity("巴拉拉"));
		friendliest.add(new Entity("埲大砍刀"));
		friendliest.add(new Entity("碧绿的尅"));
		friendliest.add(new Entity("中国的"));
		friendliest.add(new Entity("知道就看见"));
		friendliest.add(new Entity("贼iti简易"));
		friendliest.add(new Entity("合适的看法"));
		friendliest.add(new Entity("决定看"));
		friendliest.add(new Entity("记得it界"));
		friendliest.add(new Entity("接口贴的"));
	}

}
