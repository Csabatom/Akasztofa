package nyiro.csaba.akasztofa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tippBetu;
    TextView szo;
    Button Btn_Minusz;
    Button Btn_Plusz;
    Button Btn_Tipp;
    ImageView akasztofa;
    private int karakterIndex;
    private int randomSzoIndex;
    private ArrayList<Character> tippeltKarakterek = new ArrayList<Character>();
    private String eddigKitalalt;
    private int probalkozasok;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private String[] szavakArray;
    private char[] karakterekArray;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LAYOUT WIDGET VÁLTOZÓK INICIALIZÁLÁSA
        tippBetu = findViewById(R.id.TxtV_Betu);
        szo = findViewById(R.id.TxtV_Szo);
        Btn_Minusz = findViewById(R.id.Btn_Minusz);
        Btn_Plusz = findViewById(R.id.Btn_Plusz);
        Btn_Tipp = findViewById(R.id.Btn_Tippel);
        akasztofa = findViewById(R.id.Img_Akasztofa);

        // JÁTÉK FUTÁSÁHOZ SZÜKSÉGES INICIALIZÁLT VÁLTOZÓK

        probalkozasok = 13;

        // SZAVAK
        Random r = new Random();
        randomSzoIndex = r.nextInt(11);
        szavakArray = new String[]{"Android", "Flutter", "Akasztófa", "Programozás", "Mobil", "Java", "Kotlin", "Dart", "Alkalmazás", "Programnyelv"};
        eddigKitalalt = szavakArray[randomSzoIndex].replaceAll(".", "_ ");
        szo.setText(eddigKitalalt);

        // KARAKTEREK
        karakterIndex = 0;
        karakterekArray = new char[]{'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M', 'N', 'O', 'Ó', 'Ö', 'Ő', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ü', 'Ű', 'V', 'W', 'X', 'Y', 'Z'};
        tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));

        // ESEMÉNYEK
        Btn_Minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                karakterIndex--;
                try {
                    tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));
                } catch (Exception e) {
                    karakterIndex = 34;
                    tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));
                }
                if(tippeltKarakterek.contains(karakterekArray[karakterIndex])) {
                    // MÁR TIPPELTE A FELHASZNÁLÓ
                    tippBetu.setTextColor(Color.parseColor("#000000"));
                } else {
                    // MÉG NEM TIPPELTE A FELHASZNÁLÓ
                    tippBetu.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        });

        Btn_Plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                karakterIndex++;
                try {
                    tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));
                } catch (Exception e) {
                    karakterIndex = 0;
                    tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));
                }
                if(tippeltKarakterek.contains(karakterekArray[karakterIndex])) {
                    // MÁR TIPPELTE A FELHASZNÁLÓ
                    tippBetu.setTextColor(Color.parseColor("#000000"));
                } else {
                    // MÉG NEM TIPPELTE A FELHASZNÁLÓ
                    tippBetu.setTextColor(Color.parseColor("#FF0000"));
                }
            }
        });

        Btn_Tipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tippeltKarakterek.contains(karakterekArray[karakterIndex])) {
                    tippeltKarakterek.add(karakterekArray[karakterIndex]);
                    eddigKitalalt = szavakArray[randomSzoIndex].toUpperCase();
                    for(char karakter: karakterekArray) {
                        if(!tippeltKarakterek.contains(karakter)) {
                            eddigKitalalt = eddigKitalalt.replaceAll(String.valueOf(karakter), "_");
                        }
                    }
                    if(eddigKitalalt.contains(String.valueOf(karakterekArray[karakterIndex]))) {
                        // TALÁLT EGY OLYAT AMI BENNE VAN
                        Toast.makeText(MainActivity.this,"Jó tipp", Toast.LENGTH_SHORT).show();
                        if(!eddigKitalalt.contains("_")) {
                            // MINDEN BETŰT KITALÁLT A FELHASZNÁLÓ - JÁTÉK VÉGE
                            alertDialog = setUzenet("Helyes megfejtés!");
                            alertDialog.show();
                        };
                    } else {
                        // AKASZTJA AZ EMBERT
                        Toast.makeText(MainActivity.this,"Rossz tipp", Toast.LENGTH_SHORT).show();
                        probalkozasok--;
                        switch(probalkozasok) {
                            case 13:
                                akasztofa.setImageResource(R.drawable.akasztofa13);
                                break;
                            case 12:
                                akasztofa.setImageResource(R.drawable.akasztofa12);
                                break;
                            case 11:
                                akasztofa.setImageResource(R.drawable.akasztofa11);
                                break;
                            case 10:
                                akasztofa.setImageResource(R.drawable.akasztofa10);
                                break;
                            case 9:
                                akasztofa.setImageResource(R.drawable.akasztofa09);
                                break;
                            case 8:
                                akasztofa.setImageResource(R.drawable.akasztofa08);
                                break;
                            case 7:
                                akasztofa.setImageResource(R.drawable.akasztofa07);
                                break;
                            case 6:
                                akasztofa.setImageResource(R.drawable.akasztofa06);
                                break;
                            case 5:
                                akasztofa.setImageResource(R.drawable.akasztofa05);
                                break;
                            case 4:
                                akasztofa.setImageResource(R.drawable.akasztofa04);
                                break;
                            case 3:
                                akasztofa.setImageResource(R.drawable.akasztofa03);
                                break;
                            case 2:
                                akasztofa.setImageResource(R.drawable.akasztofa02);
                                break;
                            case 1:
                                akasztofa.setImageResource(R.drawable.akasztofa01);
                                break;
                            case 0:
                                akasztofa.setImageResource(R.drawable.akasztofa00);
                                break;
                        }
                        if(probalkozasok == 0) {
                            // VÉGE A JÁTÉKNAK!
                            alertDialog = setUzenet("Nem sikerült kitalálni!");
                            alertDialog.show();
                        }
                    }
                    szo.setText(eddigKitalalt.replaceAll(".", "$0 "));
                    tippBetu.setTextColor(Color.parseColor("#000000"));
                } else {
                    Toast.makeText(MainActivity.this,"Már tippelted a betűt!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    AlertDialog setUzenet(String title) {
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnél még egyet játszani?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tippeltKarakterek.clear();
                        probalkozasok = 13;
                        Random r = new Random();
                        randomSzoIndex = r.nextInt(10);
                        eddigKitalalt = szavakArray[randomSzoIndex].replaceAll(".", "_ ");
                        szo.setText(eddigKitalalt);
                        akasztofa.setImageResource(R.drawable.akasztofa13);
                        karakterIndex = 0;
                        tippBetu.setText(String.valueOf(karakterekArray[karakterIndex]));
                        tippBetu.setTextColor(Color.parseColor("#FF0000"));
                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.cancel();
                    }
                })
                .setTitle(title)
                .setCancelable(false);
        alertDialog = builder.create();
        return alertDialog;
    }
}
