package mmmobile.com.br.maospoker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class Principal extends AppCompatActivity {

    private NativeExpressAdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        setTitle(getString(R.string.p_003));

        Funcoes.adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        /*
        adView = new AdView(Principal.this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.admob_banner));

        LinearLayout layout = (LinearLayout) findViewById(R.id.banner_layout);
        if (layout != null) {
            try {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                adView.setLayoutParams(layoutParams);
                layout.addView(adView);
                adView.loadAd(Funcoes.adRequest);
            } catch (Exception ignored) {
            }
        }*/

        adView = (NativeExpressAdView) findViewById(R.id.banner_native);
        adView.loadAd(Funcoes.adRequest);

        Button btnSobre = (Button) findViewById(R.id.btnSobre);
        if (btnSobre != null) {
            btnSobre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Principal.this, Sobre.class);
                    startActivity(intent);
                }
            });
        }

        Button btnLista = (Button) findViewById(R.id.btnLista);
        if (btnLista != null) {
            btnLista.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Principal.this, Lista.class);
                    startActivity(intent);
                }
            });
        }

        Button btnMaos = (Button) findViewById(R.id.btnMaos);
        if (btnMaos != null) {
            btnMaos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Principal.this, Maos.class);
                    startActivity(intent);
                }
            });
        }

        Button btnBankroll = (Button) findViewById(R.id.btnBankroll);
        if (btnBankroll != null) {
            btnBankroll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("market://details?id=mmmobile.com.br.pokerbankroll"));
                        startActivity(intent);
                    } catch (Exception e) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=mmmobile.com.br.pokerbankroll"));
                        startActivity(intent);
                    }
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (adView != null) {
            adView.destroy();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (adView != null) {
            adView.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }
}
