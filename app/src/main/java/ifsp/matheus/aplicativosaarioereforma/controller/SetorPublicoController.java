package ifsp.matheus.aplicativosaarioereforma.controller;

import android.util.Log;

import ifsp.matheus.aplicativosaarioereforma.model.CalculosSetorPublico;
import ifsp.matheus.aplicativosaarioereforma.model.CalculosSetorPublicoReforma;
import ifsp.matheus.aplicativosaarioereforma.view.SetorPublico;

public class SetorPublicoController {
    Double entradaDadosView;
    Boolean checkBoxView;

    private double inss;
    private double irpf;
    private double salarioLiquido;
    private double inssReforma;
    private double irpfReforma;
    private double salarioLiquidoReforma;


    public double getDiferenca() {
        return diferenca;
    }

    private double diferenca;

    public double getInssReforma() {
        return inssReforma;
    }

    public double getIrpfReforma() {
        return irpfReforma;
    }

    public double getSalarioLiquidoReforma() {
        return salarioLiquidoReforma;
    }


    public double getInss() {
        return inss;
    }

    public double getIrpf() {
        return irpf;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setCheckBoxView(Boolean checkBoxView) {
        this.checkBoxView = checkBoxView;
    }

    CalculosSetorPublico csp = new CalculosSetorPublico();
    CalculosSetorPublicoReforma cspr = new CalculosSetorPublicoReforma();


    public void setEntradaDadosView(Double entradaDadosView) {
        this.entradaDadosView = entradaDadosView;
    }

    public void calcular() {
        csp.calcularInss(entradaDadosView, checkBoxView);
        csp.calcularIrpf();

        inss = csp.getValorInss();
        irpf = csp.getValorIrpf();

        salarioLiquido = csp.getValorSalarioLiquido();


        cspr.calcularInss(entradaDadosView, checkBoxView);
        cspr.calcularIrpf();

        inssReforma = cspr.getValorInss();
        irpfReforma = cspr.getValorIrpf();
        salarioLiquidoReforma = cspr.getValorSalarioLiquido();

        diferenca = (salarioLiquido - salarioLiquidoReforma);
        Log.v("teste", "Valor Liquido antes " + csp.getValorSalarioLiquido());
        Log.v("teste", "Valor Liquido depois " + cspr.getValorSalarioLiquido());
    }
}