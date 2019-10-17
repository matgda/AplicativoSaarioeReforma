package ifsp.matheus.aplicativosaarioereforma.controller;

import ifsp.matheus.aplicativosaarioereforma.model.CalculosSetorPrivado;
import ifsp.matheus.aplicativosaarioereforma.model.CalculosSetorPrivadoReforma;
import ifsp.matheus.aplicativosaarioereforma.model.CalculosSetorPublicoReforma;
import ifsp.matheus.aplicativosaarioereforma.view.SetorPrivado;

public class SetorPrivadoController {
    CalculosSetorPrivado calculosSetorPrivado = new CalculosSetorPrivado();
    CalculosSetorPrivadoReforma calculosSetorPrivadoReforma = new CalculosSetorPrivadoReforma();

    Double entradaDadosView;

    double inss;
    double irpf;
    double salarioLiquido;

    double inssReforma;
    double irpfReforma;
    double salarioLiquidoReforma;

    double diferenca;


    public double getDiferenca() {
        return diferenca;
    }

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

    public void setEntradaDadosView(Double entradaDadosView) {
        this.entradaDadosView = entradaDadosView;
    }

    public void calcular() {

        calculosSetorPrivado.calcularInss(entradaDadosView);
        calculosSetorPrivado.calcularIrpf();

        calculosSetorPrivadoReforma.calcularInss(entradaDadosView);
        calculosSetorPrivadoReforma.calcularIrpf();


        inss = calculosSetorPrivado.getValorInss();
        irpf = calculosSetorPrivado.getValorIrpf();
        salarioLiquido = calculosSetorPrivado.getValorSalarioLiquido();

        inssReforma = calculosSetorPrivadoReforma.getValorInss();
        irpfReforma = calculosSetorPrivadoReforma.getValorIrpf();
        salarioLiquidoReforma = calculosSetorPrivadoReforma.getValorSalarioLiquido();


        diferenca = (calculosSetorPrivado.getValorSalarioLiquido() - calculosSetorPrivadoReforma.getValorSalarioLiquido());
    }


}
