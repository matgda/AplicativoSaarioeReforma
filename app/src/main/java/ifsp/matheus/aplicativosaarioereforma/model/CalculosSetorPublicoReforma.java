package ifsp.matheus.aplicativosaarioereforma.model;

import android.util.Log;

import java.util.List;

import ifsp.matheus.aplicativosaarioereforma.dao.InssReformaDao;
import ifsp.matheus.aplicativosaarioereforma.dao.IrpfDao;


public class CalculosSetorPublicoReforma {


    private boolean checkBox;
    private double entradaDados;
    private double salarioInicial;
    private double valorSalarioLiquido;
    private double valorInss;
    private double valorIrpf;


    public double getTesteAliquota() {
        return testeAliquota;
    }

    public double getTesteValorInss() {
        return testeValorInss;
    }


    double testeAliquota;
    double testeValorInss;
    double testeDeducao;

    public double getTesteDeducao() {
        return testeDeducao;
    }

    public double getValorSalarioLiquido() {
        return valorSalarioLiquido;
    }

    public double getValorInss() {
        return valorInss;
    }

    public double getValorIrpf() {
        return valorIrpf;
    }


    private double tetoInss = 5839.45;

    public void calcularInss(double x, boolean b) {
        checkBox = b;
        entradaDados = x;
        InssReformaDao inssReformaDao = new InssReformaDao();

        if (checkBox) {
            List<Inss> inssList2 = inssReformaDao.inssList2();


            for (Inss c : inssList2) {

                if (entradaDados >= c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax()) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = ((entradaDados * c.getAliquota()) - c.getDeducao());
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;
                    Log.v("teste", "Aliquota CB: " + c.getAliquota());
                    Log.v("teste", "Deducao CB: " + c.getDeducao());
                    Log.v("teste", "Salario CB" + salarioInicial);
                }


            }


        } else {
            List<Inss> inssList = inssReformaDao.inssList();
            for (Inss f : inssList) {

                if (entradaDados > tetoInss) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = ((tetoInss * f.getAliquota()) - f.getDeducao());
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;
                } else if (entradaDados >= f.getSalarioBrutoMin() && entradaDados <= f.getSalarioBrutoMax()) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = (entradaDados * f.getAliquota()) - f.getDeducao();
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;

                    /*
                    Log.v("teste","Aliquota CB false: "+f.getAliquota());
                    Log.v("teste","Deducao CB false: "+f.getDeducao());
                    Log.v("teste","Salario CB false "+salarioInicial);*/
                }
                Log.v("teste", "Entrada de Dados: " + entradaDados);
                Log.v("teste", "Inss CB false: " + valorInss);
            }


        }
    }


    public void calcularIrpf() {
        IrpfDao irpfDao = new IrpfDao();
        List<Irpf> calcular = irpfDao.irpfList();

        for (Irpf i : calcular) {

            if (valorSalarioLiquido >= i.getSalarioBrutoMin() && valorSalarioLiquido <= i.getSalarioBrutoMax()) {

                valorIrpf = (valorSalarioLiquido * i.getAliquota()) - i.getDeducao();


            }


            valorSalarioLiquido = (salarioInicial - valorIrpf);


        }


    }


}
