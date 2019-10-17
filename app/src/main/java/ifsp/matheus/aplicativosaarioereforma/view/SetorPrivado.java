package ifsp.matheus.aplicativosaarioereforma.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import ifsp.matheus.aplicativosaarioereforma.controller.SetorPrivadoController;
import ifsp.matheus.aplicativosaarioereforma.R;

public class SetorPrivado extends AppCompatActivity {

    //Criando variaveis java - Sistema Atual

    private EditText mEntradaDados;
    private TextView mInss;
    private TextView mIprf;
    private TextView mSalarioLiquido;
    private Button mCalcular;
    double entradaDados;
    private TextView mDiferenca;

    //Criando variaveis java - Sistema Reforma


    private TextView mInssReforma;
    private TextView mIprfReforma;
    private TextView mSalarioLiquidoReforma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina1);
        setTitle("Setor Privado");
        //Associando variaveis com layout

        mEntradaDados = findViewById(R.id.et_entradaDados);
        mInss = findViewById(R.id.tv_Inss);
        mIprf = findViewById(R.id.tv_iprf);
        mSalarioLiquido = findViewById(R.id.tv_SalarioLiquido);
        mCalcular = findViewById(R.id.bt_pagina2);

        mInssReforma = findViewById(R.id.tv_inss_reforma);
        mIprfReforma = findViewById(R.id.tv_iprf_reforma);
        mSalarioLiquidoReforma = findViewById(R.id.tv_SalarioLiquido_Reforma);
        mDiferenca = findViewById(R.id.tv_diferenca);

        //Botão que chamara todos os metódos necessários paras as operacoes necessárias
        mCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetorPrivadoController spc = new SetorPrivadoController();


                //  CalculosSetorPrivado csp = new CalculosSetorPrivado();
                //  CalculosSetorPrivadoReforma cspr = new CalculosSetorPrivadoReforma();

                try {

                    entradaDados = Double.parseDouble(mEntradaDados.getText().toString());
                    spc.setEntradaDadosView(entradaDados);
                    spc.calcular();
                } catch (Exception ex) {
                    Log.v("teste", "Exceção Botão Calcular " + ex);
                }

                DecimalFormat df = new DecimalFormat("#.00");

                //    mInss.setText(String.valueOf(spc.getInss()));
                mInss.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getInss()))));
                mIprf.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getIrpf()))));
                mSalarioLiquido.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getSalarioLiquido()))));

                mInssReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getInssReforma()))));
                mIprfReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getIrpfReforma()))));
                mSalarioLiquidoReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getSalarioLiquidoReforma()))));
                mDiferenca.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getDiferenca()))));









            /*

                csp.calcularInss(entradaDados);
                csp.calcularIrpf();

                cspr.calcularInss(entradaDados);
                cspr.calcularIrpf();

                mInss.setText(String.valueOf(csp.getValorInss()));
                mIprf.setText(String.valueOf(csp.getValorIrpf()));
                mSalarioLiquido.setText(String.valueOf(csp.getValorSalarioLiquido()));

                mInssReforma.setText(String.valueOf(cspr.getValorInss()));
                mIprfReforma.setText(String.valueOf(cspr.getValorIrpf()));
                mSalarioLiquidoReforma.setText(String.valueOf(cspr.getValorSalarioLiquido()));



*/


            }


        });

    }
}
