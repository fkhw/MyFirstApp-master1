package comsci.alice.myfirstapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMe extends AppCompatActivity {

    //explicit ประกาศตัวแปร
    MediaPlayer mediaPlayer;
    int soundID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        //Toast onClick เมื่อคลิกที่รูปจะให้ขึ้นข้อความ
        ImageView clickImageView = (ImageView) findViewById(R.id.imvMyPic); //ผูก view บน xml ให้รู้จักกับตัวแปรบน java class
        clickImageView.setOnClickListener(new View.OnClickListener() { //พิมพ์ new เว้นวรรค พิมพ์ On
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hello! My name is Kanjanaporn Jantron",Toast.LENGTH_SHORT).show();
             //show sound 1 when click image
                soundID = R.raw.hello;
                //metboh play sound
                playSound(soundID);
            }
        });//End Toast onClick

        //Toast onLongClick
        ImageView longClickImageView = (ImageView) findViewById(R.id.imvMyPic);
        longClickImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks Guys!\n Nice to Meet U", Toast.LENGTH_SHORT).show();
                //show sound 2 when click image
                soundID = R.raw.thanks;
                //metboh play sound
                playSound(soundID);
                return true;
            }
        });
        //link to facebook
        TextView fbTextView = (TextView) findViewById(R.id.txtFacebook);
        fbTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fbIntent = new Intent(Intent.ACTION_VIEW);
                fbIntent.setData(Uri.parse("https://www.facebook.com/fangfangfang.khw"));
                startActivity(fbIntent);
            }
        });




    }//main method

    private void playSound(int soundID) {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), soundID);
        mediaPlayer.start();
    }

    public void onClickBack(View view){
        finish();
    }
}   //Main Class
