package ru.alepadesign.hobbitcalck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class StartPage extends AppCompatActivity {
    MagicButton magicButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        magicButton = (MagicButton) findViewById(R.id.magic_button);

        magicButton.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_wood_page();
            }
        });

        magicButton.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_block_page();
            }
        });
    }
    private void activity_wood_page(){
        Intent intent = new Intent(StartPage.this,wood_page.class);
        startActivity(intent);
    }

    private void activity_block_page(){
        Intent intent = new Intent(StartPage.this,BlockPage.class);
        startActivity(intent);
    }
}

