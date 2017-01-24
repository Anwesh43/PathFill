package com.anwesome.ui.pathfilldemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.anwesome.game.pathfill.PathFillDirection;
import com.anwesome.game.pathfill.PathFillShape;
import com.anwesome.game.pathfill.PathFillView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PathFillView pathFillView = new PathFillView(this, PathFillDirection.DOWN, PathFillShape.CIRCLE, Color.parseColor("#F4511E"));
        pathFillView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Circle Click",Toast.LENGTH_SHORT).show();
            }
        });
        addContentView(pathFillView,new ViewGroup.LayoutParams(300,300));
    }
}
