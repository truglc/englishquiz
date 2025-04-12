package vn.edu.tlu.cse.englishquiz;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    WebView chatWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatWebView = findViewById(R.id.chatWebView);
        chatWebView.setWebViewClient(new WebViewClient());
        chatWebView.getSettings().setJavaScriptEnabled(true);
        chatWebView.loadUrl("https://tlk.io/englishquizcommunity"); // ví dụ web chat
    }
}
