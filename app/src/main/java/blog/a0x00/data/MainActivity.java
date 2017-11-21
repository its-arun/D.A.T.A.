package blog.a0x00.data;

/**
 * Created by Arun Chaudhary on 11/17/2017.
 */

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static blog.a0x00.data.R.drawable.button_shape;


public class MainActivity extends AppCompatActivity {
    private Button start;
    static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentActivity(v);
            }
        });
    }

    public void presentActivity(View view) {
        start.setText("Let's get started!");
        start.setBackgroundColor(Color.argb(66,73, 252, 191));
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, view, "transition");
        int revealX = (int) (view.getX() + view.getWidth() / 2);
        int revealY = (int) (view.getY() + view.getHeight() / 2);

        Intent intent = new Intent(this, ChatBoard.class);
        intent.putExtra(ChatBoard.EXTRA_CIRCULAR_REVEAL_X, revealX);
        intent.putExtra(ChatBoard.EXTRA_CIRCULAR_REVEAL_Y, revealY);
        start.setVisibility(View.INVISIBLE);


        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        count++;
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        if(count>1)
            start.setVisibility(View.INVISIBLE);

    }


}
