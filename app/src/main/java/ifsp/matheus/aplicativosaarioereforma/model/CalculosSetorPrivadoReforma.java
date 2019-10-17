package ifsp.matheus.aplicativosaarioereforma.model;

import java.util.List;

import ifsp.matheus.aplicativosaarioereforma.dao.InssReformaDao;
import ifsp.matheus.aplicativosaarioereforma.dao.IrpfReformaDao;

public class CalculosSetorPrivadoReforma {

    double entradaDados;

    private double valorSalarioLiquido;
    double valorInss;
    double valorIrpf;

    public double getValorSalarioLiquido() {
        return valorSalarioLiquido;
    }

    public double getValorInss() {
        return valorInss;
    }

    public double getValorIrpf() {
        return valorIrpf;
    }


    //teste

    double aliqotairfp;
    double deducaoirpf;
    double salarioinicial;


    double tetoInss = 5839.45;

    public void calcularInss(double x) {
        entradaDados = x;
        InssReformaDao inssDao = new InssReformaDao();
        List<Inss> calcular = inssDao.inssList();

        for (Inss c : calcular) {

            if (entradaDados > tetoInss) {
                valorSalarioLiquido = entradaDados;
                valorInss = (tetoInss * c.getAliquota() - c.getDeducao());
                valorSalarioLiquido = valorSalarioLiquido - valorInss;

                salarioinicial = valorSalarioLiquido;
            } else if (entradaDados >= c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax()) {
                valorSalarioLiquido = entradaDados;
                valorInss = (entradaDados * c.getAliquota() - c.getDeducao());
                valorSalarioLiquido = valorSalarioLiquido - valorInss;

                salarioinicial = valorSalarioLiquido;
            }

        }

    }


    public void calcularIrpf() {
        IrpfReformaDao irpfDao = new IrpfReformaDao();
        List<Irpf> calcular = irpfDao.irpfList();

        for (Irpf i : calcular) {

            if (salarioinicial >= i.getSalarioBrutoMin() && salarioinicial <= i.getSalarioBrutoMax()) {

                valorIrpf = (salarioinicial * i.getAliquota()) - i.getDeducao();
                aliqotairfp = i.getAliquota();
                deducaoirpf = i.getDeducao();


            }


            valorSalarioLiquido = (salarioinicial - valorIrpf);


        }


    }


}
