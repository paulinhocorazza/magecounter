package com.magecounter.paulocorazza.magecounter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    private EditText vida1;
    private EditText vida2;
    private EditText cronometro;
    private int lifePoints1 = 20;
    private int lifePoints2 = 20;
    private int lifeCounter1 = 0;
    private int lifeCounter2 = 0;
    private ImageView d20;
    private Button btnMais1;
    private Button btnMenos1;
    private Button btnMais2;
    private Button btnMenos2;
    private Button btnZerar1;
    private Button btnZerar2;
    private AlertDialog.Builder dialogoDado;
    private ImageView botaoInfo;
    private AlertDialog.Builder dialogoInfo;
    private CountDownTimer contadorTempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);/// mantém a tela sempre acessa
        

        vida1 = (EditText) findViewById(R.id.inicioVida1);
        vida1.setText("20");
        vida1.setFocusable(false);
        vida1.setEms(0);
        btnMais1 = (Button) findViewById(R.id.btnMais1);
        btnMais1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCounter1 = 0;
                lifeCounter1++;
                lifePoints1 = lifePoints1 + lifeCounter1;
                vida1.setText(String.valueOf(lifePoints1));

            }
        });

        btnMenos1 = (Button) findViewById(R.id.btnMenos1);
        btnMenos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCounter1 = 0;
                lifeCounter1--;
                lifePoints1 = lifePoints1 + lifeCounter1;
                vida1.setText(String.valueOf(lifePoints1));


            }
        });

        vida2 = (EditText) findViewById(R.id.inicioVida2);
        vida2.setText("20");
        vida2.setFocusable(false);
        btnMais2 = (Button) findViewById(R.id.btnMais2);
        btnMais2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCounter2 = 0;
                lifeCounter2++;
                lifePoints2 = lifePoints2 + lifeCounter2;
                vida2.setText(String.valueOf(lifePoints2));
            }
        });

        btnMenos2 = (Button) findViewById(R.id.btnMenos2);
        btnMenos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifeCounter2 = 0;
                lifeCounter2--;
                lifePoints2 = lifePoints2 + lifeCounter2;
                vida2.setText(String.valueOf(lifePoints2));
            }
        });

        btnZerar1 = (Button) findViewById(R.id.botaoZerar1Id);
        btnZerar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifePoints1 = 20;
                vida1.setText(String.valueOf(lifePoints1));
            }
        });

        btnZerar2 = (Button) findViewById(R.id.botaoZerar2Id);
        btnZerar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lifePoints2 = 20;
                vida2.setText(String.valueOf(lifePoints2));
            }
        });
        d20 = (ImageView) findViewById(R.id.d20Id);
        d20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random dadoRandomico = new Random();
                int numeroDados = dadoRandomico.nextInt(20);

                dialogoDado = new AlertDialog.Builder(MainActivity.this);
                dialogoDado.setTitle("Vamos ver quem começa...");
                dialogoDado.setMessage("Você tirou" + "\n" + String.valueOf(numeroDados));
                dialogoDado.setCancelable(false);
                dialogoDado.setIcon(android.R.drawable.ic_dialog_alert);
                dialogoDado.setNegativeButton("",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogoDado.setCancelable(true);
                            }
                        });
                dialogoDado.setPositiveButton("Ok",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                dialogoDado.create();
                dialogoDado.show();

            }
      });
              botaoInfo = (ImageView) findViewById(R.id.infoId);
              botaoInfo.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      dialogoInfo = new AlertDialog.Builder(MainActivity.this);
                      dialogoInfo.setMessage("Fale com o desenvolvedor");
                      dialogoInfo.setCancelable(false);
                      dialogoInfo.setIcon(android.R.drawable.ic_dialog_email);
                      dialogoInfo.setNegativeButton("Não, talvez mais tarde",
                              new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialogInterface, int i) {
                                      dialogoInfo.setCancelable(true);
                                  }
                              });
                      dialogoInfo.setPositiveButton("Sim, vamos mandar um email !",
                              new DialogInterface.OnClickListener() {
                                  @Override
                                  public void onClick(DialogInterface dialogInterface, int i) {
                                      Intent intent=new Intent(Intent.ACTION_SEND);
                                      String[] recipients={"corazza.paulovinicius@gmail.com"};
                                      intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                                      intent.putExtra(Intent.EXTRA_SUBJECT,"Aplicativo MTG LIFE COUNTER");
                                      intent.putExtra(Intent.EXTRA_TEXT,"");
                                      intent.putExtra(Intent.EXTRA_CC,"corazza.paulovinicius@gmail.com");
                                      intent.setType("text/html");
                                      intent.setPackage("com.google.android.gm");
                                      startActivity(Intent.createChooser(intent, "Send mail"));
                               }
                            });
                       dialogoInfo.create();
                       dialogoInfo.show();
                    }
                  });
               }
              }

