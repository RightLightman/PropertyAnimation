package com.jiangtea.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.iv);
    }

    public void alpha(View view) {
        // 参数1：要修改的目标控件
        // 参数2：属性名称,目标控件的属性名称
        // 参数3：属性的值,可变参数，可以设置多个值
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "alpha", 0, 1, 0.5f, 1);
        // 设置动画的时长
        objectAnimator.setDuration(3000);
        // 设置动画的重复次数
        objectAnimator.setRepeatCount(2);
        // 设置动画的重复模式
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        // 启动动画
        objectAnimator.start();
    }

    public void translate(View view) {
        //设置x方向平移
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "translationX", 0, 200);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void scale(View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "scaleX", 1, 2);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }

    public void rotate(View view) {

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv, "rotation", 0, 360);
        objectAnimator.setDuration(2000);
        //设置重复次数
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //设置重复模式
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.start();
    }

    public void duang(View view){
        //创建一个属性动画集合
        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(iv, "rotation", 0, 360);
        rotationAnimator.setDuration(2000);
        //设置重复次数
        rotationAnimator.setRepeatCount(ValueAnimator.INFINITE);
        //设置重复模式
        rotationAnimator.setRepeatMode(ValueAnimator.RESTART);

        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(iv, "scaleX", 1, 2);
        scaleAnimator.setDuration(2000);
        scaleAnimator.setRepeatCount(ValueAnimator.INFINITE);

        //一个一个动画一次执行
//		animatorSet.playSequentially(rotationAnimator,scaleAnimator);
        //同时执行所有动画
        animatorSet.playTogether(rotationAnimator,scaleAnimator);
        animatorSet.start();
    }

    // 通过属性动画文件实现渐变动画效果
    public void alpha2(View view) {
        // 参数2：属性动画的资源文件id
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.property_anim);
        // 设置目标控件
        animator.setTarget(iv);
        // 启动动画
        animator.start();
    }
}
