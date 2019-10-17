package ifsp.matheus.aplicativosaarioereforma.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ifsp.matheus.aplicativosaarioereforma.R;

public class MainActivity extends Activity {

    private Button mBt_pagina1;
    private Button mBt_pagina2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBt_pagina1 = findViewById(R.id.bt_pagina1);
        mBt_pagina2 = findViewById(R.id.bt_pagina2);

        mBt_pagina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SetorPrivado.class));
            }
        });
        mBt_pagina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SetorPublico.class));
            }
        });


    }
}
