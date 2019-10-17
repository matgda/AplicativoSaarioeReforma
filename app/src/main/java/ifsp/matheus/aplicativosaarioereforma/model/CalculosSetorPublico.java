package ifsp.matheus.aplicativosaarioereforma.model;

import android.util.Log;

import java.util.List;

import ifsp.matheus.aplicativosaarioereforma.dao.InssDao;

import ifsp.matheus.aplicativosaarioereforma.dao.IrpfDao;


public class CalculosSetorPublico {

    private double entradaDados;
    private double valorSalarioLiquido;
    private double valorInss;
    private double valorIrpf;
    private double salarioInicial;
    private boolean checkBox;


    public double getValorIrpf() {
        return valorIrpf;
    }

    public double getValorSalarioLiquido() {
        return valorSalarioLiquido;
    }

    public double getValorInss() {
        return valorInss;
    }


    double tetoInss = 5839.45;

    public void calcularInss(double x, boolean b) {
        entradaDados = x;
        checkBox = b;
        InssDao inssDao = new InssDao();
        if (checkBox) {
            List<Inss> calcular = inssDao.inssList2();
            for (Inss c : calcular) {
                if (entradaDados >= c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax()) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = entradaDados * c.getAliquota();
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;

                }
            }

        } else {
            List<Inss> calcular = inssDao.inssList2();

            for (Inss c : calcular) {

                if (entradaDados > tetoInss) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = tetoInss * c.getAliquota();
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;
                } else if (entradaDados >= c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax()) {
                    valorSalarioLiquido = entradaDados;
                    valorInss = entradaDados * c.getAliquota();
                    valorSalarioLiquido = valorSalarioLiquido - valorInss;
                    salarioInicial = valorSalarioLiquido;

                }

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
