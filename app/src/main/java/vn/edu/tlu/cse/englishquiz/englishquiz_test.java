package vn.edu.tlu.cse.englishquiz;
//
//
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import android.util.Log;
//
//import android.content.Intent;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Random;
//
//class QuestionNare {
//    public String ID;
//    public String AnswerA, AnswerB, AnswerC, AnswerD, Answer;
//}
//
//public class englishquiz_test extends AppCompatActivity {
//    TextView KetQua, CauHoi, ThoiGian;
//    ImageView HinhAnh;
//    RadioGroup RG;
//    Button TraLoi, TroGiup, BoQua, KetThuc;
//    RadioButton A, B, C, D;
//    int pos = 0;
//    int kq = 0;
//    CountDownTimer Time;
//    public ArrayList<QuestionNare> list = new ArrayList();
//    public ArrayList<Question> PList = new ArrayList();
//
//    public void countdown() {
//        Time = new CountDownTimer(21000, 1000) {
//
//            public void onTick(long millisUntilFinished) {
//                ThoiGian.setText(String.valueOf(millisUntilFinished / 1000));
//            }
//
//            public void onFinish() {
//                pos++;
//                if (pos >= list.size()) {
//                    Intent callerIntent = getIntent();
//                    Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
//                    String name = packageFromCaller.getString("name");
//                    Intent intent = new Intent(englishquiz_test.this, englishquiz_result.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("kq", kq);
//                    bundle.putInt("num", pos);
//                    bundle.putString("name", name);
//                    intent.putExtra("package", bundle);
//                    startActivity(intent);
//                    finish();
//                } else Display(pos);
//            }
//        }.start();
//    }
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.englishquiz_test);
//
//        CauHoi = (TextView) findViewById(R.id.Question);
//        KetQua = (TextView) findViewById(R.id.Result);
//        RG = (RadioGroup) findViewById(R.id.RadioGroup);
//        A = (RadioButton) findViewById(R.id.RdbA);
//        B = (RadioButton) findViewById(R.id.RdbB);
//        C = (RadioButton) findViewById(R.id.RdbC);
//        D = (RadioButton) findViewById(R.id.RdbD);
//        TraLoi = (Button) findViewById(R.id.Answer);
//        HinhAnh = (ImageView) findViewById(R.id.QuestionPicture);
//        TroGiup = (Button) findViewById(R.id.Help);
//        BoQua = (Button) findViewById(R.id.Skip);
//        ThoiGian = (TextView) findViewById(R.id.Time);
//        KetThuc = (Button) findViewById(R.id.End);
//        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);
//
//        AddQuestionFromFileTXT();
//        CreateQuestion();
//        Display(pos);
//
//        KetThuc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(englishquiz_test.this, englishquiz.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        TroGiup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mediaPlayer.start();
//                String temp = list.get(pos).Answer;
//                switch (temp) {
//                    case "A":
//                        B.setVisibility(View.INVISIBLE);
//                        D.setVisibility(View.INVISIBLE);
//                        break;
//                    case "B":
//                        A.setVisibility(View.INVISIBLE);
//                        C.setVisibility(View.INVISIBLE);
//                        break;
//                    case "C":
//                        B.setVisibility(View.INVISIBLE);
//                        D.setVisibility(View.INVISIBLE);
//                        break;
//                    case "D":
//                        A.setVisibility(View.INVISIBLE);
//                        C.setVisibility(View.INVISIBLE);
//                        break;
//                }
//                TroGiup.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        BoQua.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Time.cancel();
//                mediaPlayer.start();
//                kq = kq + 1;
//                pos++;
//                Display(pos);
//                BoQua.setVisibility(View.INVISIBLE);
//            }
//        });
//
//        TraLoi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Time.cancel();
//                mediaPlayer.start();
//                int idCheck = RG.getCheckedRadioButtonId();
////                switch (idCheck) {
////                    case R.id.RdbA:
////                        if (list.get(pos).Answer.compareTo("A") == 0) kq = kq + 1;
////                        break;
////                    case R.id.RdbB:
////                        if (list.get(pos).Answer.compareTo("B") == 0) kq = kq + 1;
////                        break;
////                    case R.id.RdbC:
////                        if (list.get(pos).Answer.compareTo("C") == 0) kq = kq + 1;
////                        break;
////                    case R.id.RdbD:
////                        if (list.get(pos).Answer.compareTo("D") == 0) kq = kq + 1;
////                        break;
////                }
//                if (idCheck == R.id.RdbA) {
//                    if (list.get(pos).Answer.equals("A")) kq++;
//                } else if (idCheck == R.id.RdbB) {
//                    if (list.get(pos).Answer.equals("B")) kq++;
//                } else if (idCheck == R.id.RdbC) {
//                    if (list.get(pos).Answer.equals("C")) kq++;
//                } else if (idCheck == R.id.RdbD) {
//                    if (list.get(pos).Answer.equals("D")) kq++;
//                }
//                pos++;
//                if (pos >= list.size()) {
//                    Intent callerIntent = getIntent();
//                    Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
//                    String name = packageFromCaller.getString("name");
//                    Intent intent1 = new Intent(englishquiz_test.this, englishquiz_result.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("kq", kq);
//                    bundle.putInt("num", pos);
//                    bundle.putString("name", name);
//                    intent1.putExtra("package", bundle);
//                    startActivity(intent1);
//                    pos = 0;
//                    kq = 0;
//                    Display(pos);
//                    finish();
//                } else Display(pos);
//            }
//        });
//    }
//
//    void Display(int i) {
//        countdown();
//        int resID = getResources().getIdentifier(list.get(i).ID, "drawable", getPackageName());
//        HinhAnh.setImageResource(resID);
//        A.setText(list.get(i).AnswerA);
//        B.setText(list.get(i).AnswerB);
//        C.setText(list.get(i).AnswerC);
//        D.setText(list.get(i).AnswerD);
//        KetQua.setText("Câu đúng: " + kq);
//        RG.clearCheck();
//        A.setVisibility(View.VISIBLE);
//        B.setVisibility(View.VISIBLE);
//        C.setVisibility(View.VISIBLE);
//        D.setVisibility(View.VISIBLE);
//    }
//    public void AddQuestionFromFileTXT() {
//        try {
//            String splitBy = ",";
//            InputStream is = getAssets().open("Question.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] value = line.split(splitBy);
//                if (value.length >= 2) {
//                    PList.add(new Question(value[1], Integer.parseInt(value[0])));
//                }
//            }
//            br.close();
//        } catch (Exception e) {
//            Log.e("FileError", "Lỗi đọc file: " + e.getMessage());
//        }
//    }
//
////    public void AddQuestionFromFileTXT() {
////        try {
////            String splitBy = ",";
//////            FileInputStream in = this.openFileInput("Question.txt");
//////            BufferedReader br = new BufferedReader(new InputStreamReader(in));
////            InputStream is = getAssets().open("Question.txt");
////            BufferedReader br = new BufferedReader(new InputStreamReader(is));
////
////            while (br != null) {
////                String line = br.readLine();
////                String[] value = line.split(splitBy);
////                PList.add(new Question(value[1], Integer.parseInt(value[0])));
////            }
////            br.close();
////        } catch (Exception e) {
////            System.out.println("" + e.getMessage());
////        }
////    }
//
//    public void CreateQuestion() {
//        Intent callerIntent = getIntent();
//        Bundle packageFromCaller = callerIntent.getBundleExtra("bundle");
//        int number = packageFromCaller.getInt("number");
//
//        for (int i = 0; i <= number - 1; i++) {
//            QuestionNare Q = new QuestionNare();
//            Random generator = new Random();
//            Q.AnswerA = PList.get(generator.nextInt(50)).getName();
//            do {
//                Q.AnswerB = PList.get(generator.nextInt(50)).getName();
//            } while (Q.AnswerA == Q.AnswerB);
//
//            do {
//                Q.AnswerC = PList.get(generator.nextInt(50)).getName();
//            } while (Q.AnswerC == Q.AnswerB || Q.AnswerC == Q.AnswerA);
//
//            do {
//                Q.AnswerD = PList.get(generator.nextInt(50)).getName();
//            } while (Q.AnswerD == Q.AnswerC || Q.AnswerD == Q.AnswerB || Q.AnswerD == Q.AnswerA);
//
//            int value = generator.nextInt(4);
//            int find = 0;
//
//            switch (value) {
//                case 0:
//                    find = PList.indexOf(searchQuestion(Q.AnswerA));
//                    Q.Answer = "A";
//                    break;
//                case 1:
//                    find = PList.indexOf(searchQuestion(Q.AnswerB));
//                    Q.Answer = "B";
//                    break;
//                case 2:
//                    find = PList.indexOf(searchQuestion(Q.AnswerC));
//                    Q.Answer = "C";
//                    break;
//                case 3:
//                    find = PList.indexOf(searchQuestion(Q.AnswerD));
//                    Q.Answer = "D";
//                    break;
//            }
//            Q.ID = "a" + PList.get(find).getId();
//            list.add(Q);
//        }
//    }
//
//    public Question searchQuestion(String code) {
//        for (Question in : PList) {
//            if (in.getName().equalsIgnoreCase(code)) {
//                return in;
//            }
//        }
//        return null;
//    }
//}


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.*;
class QuestionNare {
    public String imageUrl;
    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String Answer;
}

public class englishquiz_test extends AppCompatActivity {
    TextView KetQua, ThoiGian;
    ImageView HinhAnh;
    RadioGroup RG;
    RadioButton A, B, C, D;
    Button TraLoi, TroGiup, BoQua, KetThuc;
    int pos = 0;
    int kq = 0;
    CountDownTimer Time;

    ArrayList<QuestionNare> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.englishquiz_test);

        // Ánh xạ view
        KetQua = findViewById(R.id.Result);
        ThoiGian = findViewById(R.id.Time);
        HinhAnh = findViewById(R.id.QuestionPicture);
        RG = findViewById(R.id.RadioGroup);
        A = findViewById(R.id.RdbA);
        B = findViewById(R.id.RdbB);
        C = findViewById(R.id.RdbC);
        D = findViewById(R.id.RdbD);
        TraLoi = findViewById(R.id.Answer);
        TroGiup = findViewById(R.id.Help);
        BoQua = findViewById(R.id.Skip);
        KetThuc = findViewById(R.id.End);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.buttonclick);

        // Gọi API
        fetchQuestionsFromSheet();

        KetThuc.setOnClickListener(v -> {
            startActivity(new Intent(this, englishquiz.class));
            finish();
        });

        TraLoi.setOnClickListener(v -> {
            Time.cancel();
            mediaPlayer.start();

            int id = RG.getCheckedRadioButtonId();
            String selected = "";

            if (id == A.getId()) selected = "A";
            else if (id == B.getId()) selected = "B";
            else if (id == C.getId()) selected = "C";
            else if (id == D.getId()) selected = "D";

            if (list.get(pos).Answer.equals(selected)) {
                kq++;
            }

            pos++;
            if (pos >= list.size()) showResult();
            else displayQuestion(pos);
        });

        BoQua.setOnClickListener(v -> {
            Time.cancel();
            mediaPlayer.start();
            pos++;
            if (pos >= list.size()) showResult();
            else displayQuestion(pos);
        });

        TroGiup.setOnClickListener(v -> {
            mediaPlayer.start();
            String answer = list.get(pos).Answer;

            ArrayList<RadioButton> options = new ArrayList<>();
            if (!answer.equals("A")) options.add(A);
            if (!answer.equals("B")) options.add(B);
            if (!answer.equals("C")) options.add(C);
            if (!answer.equals("D")) options.add(D);

            // Xáo trộn thứ tự để ẩn ngẫu nhiên 2 đáp án sai
            java.util.Collections.shuffle(options);

            // Ẩn 2 đáp án sai
            options.get(0).setVisibility(View.INVISIBLE);
            options.get(1).setVisibility(View.INVISIBLE);

            // Ẩn nút trợ giúp
            TroGiup.setVisibility(View.INVISIBLE);
        });

    }

    void fetchQuestionsFromSheet() {
        String url = "https://script.google.com/macros/s/AKfycbybPQYKytjSUcMk4dUT7-iS1Uy3Km3_vE83-0oOZwdOH2vZ8xBFiIDIFiLgwcfL-DI_/exec"; // Thay bằng URL của bạn

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            public void onFailure(Call call, IOException e) {
                Log.e("ERROR", "Failed to load JSON: " + e.getMessage());
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String jsonData = response.body().string();
                        JSONArray jsonArray = new JSONArray(jsonData);

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            QuestionNare q = new QuestionNare();
                            q.imageUrl = obj.getString("imageUrl");
                            q.AnswerA = obj.getString("AnswerA");
                            q.AnswerB = obj.getString("AnswerB");
                            q.AnswerC = obj.getString("AnswerC");
                            q.AnswerD = obj.getString("AnswerD");
                            q.Answer = obj.getString("Answer");
                            list.add(q);
                        }

                        runOnUiThread(() -> displayQuestion(pos));
                    } catch (Exception e) {
                        Log.e("ERROR", "JSON parse error: " + e.getMessage());
                    }
                }
            }
        });
    }

    void displayQuestion(int i) {
        startCountdown();

        QuestionNare q = list.get(i);
        Picasso.get().load(q.imageUrl).into(HinhAnh);
        A.setText(q.AnswerA);
        B.setText(q.AnswerB);
        C.setText(q.AnswerC);
        D.setText(q.AnswerD);
        KetQua.setText("Câu đúng: " + kq);
        RG.clearCheck();

        A.setVisibility(View.VISIBLE);
        B.setVisibility(View.VISIBLE);
        C.setVisibility(View.VISIBLE);
        D.setVisibility(View.VISIBLE);
        TroGiup.setVisibility(View.VISIBLE);
    }

    void startCountdown() {
        if (Time != null) Time.cancel();
        Time = new CountDownTimer(21000, 1000) {
            public void onTick(long millisUntilFinished) {
                ThoiGian.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                pos++;
                if (pos >= list.size()) showResult();
                else displayQuestion(pos);
            }
        }.start();
    }

    void showResult() {
        Intent intent = new Intent(this, englishquiz_result.class);
        Bundle bundle = new Bundle();
        bundle.putInt("kq", kq);
        bundle.putInt("num", list.size());
        bundle.putString("name", getIntent().getBundleExtra("bundle").getString("name"));
        intent.putExtra("package", bundle);
        startActivity(intent);
        finish();
    }
}
