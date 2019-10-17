package ifsp.matheus.aplicativosaarioereforma.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import ifsp.matheus.aplicativosaarioereforma.controller.SetorPublicoController;
import ifsp.matheus.aplicativosaarioereforma.R;

public class SetorPublico extends AppCompatActivity {


    private EditText mEntradaDados;
    private TextView mInss;
    private TextView mIprf;
    private TextView mSalarioLiquido;
    private Button mCalcular;
    double entradaDados;
    private TextView mDiferenca;

    private CheckBox mCheckBox;

    //Criando variaveis java - Sistema Reforma


    private TextView mInssReforma;
    private TextView mIprfReforma;
    private TextView mSalarioLiquidoReforma;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor_publico);
        setTitle("Setor Público");
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
        mCheckBox = findViewById(R.id.checkBox);


        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCheckBox.isChecked();
            }
        });

        //Botão que chama todos os metódos necessários paras as operacoes necessárias
        mCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetorPublicoController spc = new SetorPublicoController();

                //   CalculosSetorPublico csp = new CalculosSetorPublico();
                //  CalculosSetorPublicoReforma cspr = new CalculosSetorPublicoReforma();

                try {

                    entradaDados = Double.parseDouble(mEntradaDados.getText().toString());
                    spc.setEntradaDadosView(entradaDados);
                    spc.setCheckBoxView(mCheckBox.isChecked());
                    spc.calcular();
                } catch (Exception ex) {
                    Log.v("teste", "Exceção Botão Calcular " + ex);
                }


                Log.v("teste", "CheckBox " + mCheckBox.isChecked());
                DecimalFormat df = new DecimalFormat("#.00");

                mInss.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getInss()))));
                mIprf.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getIrpf()))));
                mSalarioLiquido.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getSalarioLiquido()))));

                mInssReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getInssReforma()))));
                mIprfReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getIrpfReforma()))));
                mSalarioLiquidoReforma.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getSalarioLiquidoReforma()))));
                mDiferenca.setText(getString(R.string.cifrao, String.valueOf(df.format(spc.getDiferenca()))));











            /*


        if(mCheckBox.isChecked()){
            Log.v("teste","CheckBox "+mCheckBox.isChecked());






            /*

            csp.calcularInss(entradaDados);
            csp.calcularIrpf();

            cspr.calcularInss(entradaDados,mCheckBox.isChecked());

            cspr.calcularIrpf();





            mInss.setText(String.valueOf(csp.getValorInss()));
            mIprf.setText(String.valueOf(csp.getValorIrpf()));
            mSalarioLiquido.setText(String.valueOf(csp.getValorSalarioLiquido()));

            mIprfReforma.setText(String.valueOf(cspr.getValorIrpf()));
            mInssReforma.setText(String.valueOf(cspr.getValorInss()));
            mSalarioLiquidoReforma.setText(String.valueOf(cspr.getValorSalarioLiquido()));







        }
     else if(!mCheckBox.isChecked()) {
         Log.v("teste","CheckBox "+mCheckBox.isChecked());


            csp.calcularInss(entradaDados);
            csp.calcularIrpf();

            cspr.calcularInss(entradaDados,mCheckBox.isChecked());
            cspr.calcularIrpf();



            mInss.setText(String.valueOf(csp.getValorInss()));
            mIprf.setText(String.valueOf(csp.getValorIrpf()));
            mSalarioLiquido.setText(String.valueOf(csp.getValorSalarioLiquido()));

            mIprfReforma.setText(String.valueOf(cspr.getValorIrpf()));
            mInssReforma.setText(String.valueOf(cspr.getValorInss()));
            mSalarioLiquidoReforma.setText(String.valueOf(cspr.getValorSalarioLiquido()));



        }*/


            }
        });

    }

}
