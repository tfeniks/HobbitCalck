package ru.alepadesign.hobbitcalck;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class StartPage extends AppCompatActivity {

    private MagicButton mbtn_wood, mbtn_blocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        mbtn_wood = (MagicButton) findViewById(R.id.mbtn_wood);
        mbtn_blocks = (MagicButton) findViewById(R.id.mbtn_blocks);

        mbtn_blocks.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity(StartPage.this, BlockPage.class);
            }
        });

        mbtn_wood.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpActivity(StartPage.this,WoodPage.class);
            }
        });
    }

    private void jumpActivity(Context context, Class class_jump){
        Intent intent = new Intent(context, class_jump);
        startActivity(intent);
    }

}

