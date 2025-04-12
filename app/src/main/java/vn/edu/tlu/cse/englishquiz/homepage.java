////package vn.edu.tlu.cse.englishquiz;
////
////import android.content.Intent;
////import androidx.appcompat.app.AppCompatActivity;
////
////import android.media.MediaPlayer;
////import android.os.Bundle;
////import android.view.View;
////import android.widget.Button;
////
////public class homepage extends AppCompatActivity{
////    Button EnglishQuiz, CorrectWord, Thoat;
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.homepage);
////        EnglishQuiz = (Button) findViewById(R.id.EnglishQuiz);
////        Thoat = (Button) findViewById(R.id.LogOut);
//////        CorrectWord = (Button) findViewById(R.id.CorrectWord);
////        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.buttonclick);
////
////        EnglishQuiz.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                mediaPlayer.start();
////                Intent intent = new Intent(homepage.this, englishquiz.class);
////                startActivity(intent);
////            }
////        });
////
//////        CorrectWord.setOnClickListener(new View.OnClickListener() {
//////            @Override
//////            public void onClick(View v) {
//////                mediaPlayer.start();
//////                Intent intent1 = new Intent(homepage.this, correctword.class);
//////                startActivity(intent1);
//////            }
//////        });
////
////        Thoat.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                mediaPlayer.start();
////                Intent intent2 = new Intent(homepage.this, MainActivity.class);
////                startActivity(intent2);
////                finish();
////            }
////        });
////    }
////}
//
//
//
//
//package vn.edu.tlu.cse.englishquiz;
//
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.Button;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class homepage extends AppCompatActivity {
//    Button EnglishQuiz, Thoat, LearnTheory;
//    WebView webView;  // WebView to load the website
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.homepage);
//
//        EnglishQuiz = findViewById(R.id.EnglishQuiz);
//        Thoat = findViewById(R.id.LogOut);
//        LearnTheory = findViewById(R.id.LearnTheory);
//        webView = findViewById(R.id.webview);
//
//        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);
//
//        // WebView settings
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);  // Enable JavaScript if needed
//
//        // English Quiz button click
//        EnglishQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.start();
//                Intent intent = new Intent(homepage.this, englishquiz.class);
//                startActivity(intent);
//            }
//        });
//
//        // Log Out button click
//        Thoat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.start();
//                Intent intent = new Intent(homepage.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        // Learn Theory button click
//        LearnTheory.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.start();
//
//                // Hide other UI elements and show WebView
//                EnglishQuiz.setVisibility(View.GONE);
//                Thoat.setVisibility(View.GONE);
//                LearnTheory.setVisibility(View.GONE);
//
//                webView.setVisibility(View.VISIBLE);
//                webView.loadUrl("https://www.youtube.com");  // Replace with your URL
//            }
//        });
//    }
//}
//
package vn.edu.tlu.cse.englishquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {
    Button EnglishQuiz, LearnTheory, ChatCommunity, LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        EnglishQuiz = findViewById(R.id.EnglishQuiz);
        LearnTheory = findViewById(R.id.LearnTheory);
        ChatCommunity = findViewById(R.id.ChatCommunity);
        LogOut = findViewById(R.id.LogOut);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);

        EnglishQuiz.setOnClickListener(v -> {
            mediaPlayer.start();
            startActivity(new Intent(homepage.this, englishquiz.class));
        });

        LearnTheory.setOnClickListener(v -> {
            mediaPlayer.start();
            startActivity(new Intent(homepage.this, TheoryActivity.class));
        });

        ChatCommunity.setOnClickListener(v -> {
            mediaPlayer.start();
            startActivity(new Intent(homepage.this, ChatActivity.class));
        });

        LogOut.setOnClickListener(v -> {
            mediaPlayer.start();
            startActivity(new Intent(homepage.this, MainActivity.class));
            finish();
        });
    }
}
