package com.anwesome.ui.pathfilldemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.game.pathfill.PathFillDirection;
import com.anwesome.game.pathfill.PathFillHelper;
import com.anwesome.game.pathfill.PathFillShape;
import com.anwesome.game.pathfill.PathFillView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PathFillHelper.addPathFillView(this, PathFillDirection.DOWN, PathFillShape.CIRCLE, Color.parseColor("#F4511E"), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Circle Down",Toast.LENGTH_SHORT).show();
            }
        },300,0);
        PathFillHelper.addPathFillView(this, PathFillDirection.DOWN, PathFillShape.TRIANGLE, Color.parseColor("#F4511E"), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Triangle Down",Toast.LENGTH_SHORT).show();
            }
        },300,300);
        PathFillHelper.addPathFillView(this, PathFillDirection.UP, PathFillShape.CIRCLE, Color.parseColor("#F4511E"), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Circle Up",Toast.LENGTH_SHORT).show();
            }
        },300,600);
    }
}
