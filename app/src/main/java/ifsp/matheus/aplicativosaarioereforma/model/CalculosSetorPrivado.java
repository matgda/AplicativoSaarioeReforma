package ifsp.matheus.aplicativosaarioereforma.model;


import java.util.List;


import ifsp.matheus.aplicativosaarioereforma.dao.IrpfDao;

import ifsp.matheus.aplicativosaarioereforma.dao.InssDao;

public class CalculosSetorPrivado {

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
    double aliquota;
    double aliqotairfp;
    double deducaoirpf;
    double salarioinicial;


    double tetoInss = 5839.45;

    public void calcularInss(double x) {
        entradaDados = x;
        InssDao inssDao = new InssDao();
        List<Inss> calcular = inssDao.inssList();

        for (Inss c : calcular) {

            if (entradaDados > tetoInss) {
                valorSalarioLiquido = entradaDados;
                valorInss = tetoInss * c.getAliquota();
                valorSalarioLiquido = valorSalarioLiquido - valorInss;
                aliquota = c.getAliquota();
                salarioinicial = valorSalarioLiquido;
            } else if (entradaDados >= c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax()) {
                valorSalarioLiquido = entradaDados;
                valorInss = entradaDados * c.getAliquota();
                valorSalarioLiquido = valorSalarioLiquido - valorInss;
                aliquota = c.getAliquota();
                salarioinicial = valorSalarioLiquido;
            }

        }

    }


    public void calcularIrpf() {
        IrpfDao irpfDao = new IrpfDao();
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
























































    /*

        public double calcularInssReforma(double y) {

            entradaDadosReforma = y;
            Log.v("teste","Valor de Entrada Reforma: "+entradaDados);

            InssReformaDao inssReformaDao = new InssReformaDao();
            List<Inss> inssList = inssReformaDao.inssList();

            for (Inss c : inssList) {
                if(entradaDados > 5839.45 ){
                    valorInssReforma = (5839.45 * c.getAliquota()) - c.getDeducao();
                    valorSalarioLiquidoReforma += - valorInssReforma;
                }

              else  if(entradaDados  >=c.getSalarioBrutoMin() && entradaDados <= c.getSalarioBrutoMax() ){

                    valorSalarioLiquidoReforma = entradaDados;
                    valorInssReforma = (entradaDados * c.getAliquota()) - c.getDeducao();

                    valorSalarioLiquidoReforma += - valorInssReforma;

            }

        }return valorInssReforma;
        }



       public void  calcularIprfReforma(){

        IrpfReformaDao irpfReformaDao = new IrpfReformaDao();

        List<Irpf> irpfList = irpfReformaDao.irpfList();

        for (Irpf c : irpfList){

                    if(valorSalarioLiquidoReforma >= 5839.45){
                        valorIrpfReforma =( 5839.45 *c.getAliquota()) - c.getDeducao();
                        valorSalarioLiquidoReforma  += -valorIrpfReforma;


                    }
                else if (valorSalarioLiquidoReforma >= c.getSalarioBrutoMin() && getValorSalarioLiquido() <= c.getSalarioBrutoMax()) {
                    valorIrpfReforma = (valorSalarioLiquidoReforma * c.getAliquota()) - c.getDeducao();
                    valorSalarioLiquidoReforma += -valorIrpfReforma;
                        Log.v("teste", "VALor INSS " + valorInssReforma);
                        Log.v("teste", "Salario Liquido: " + getValorSalarioLiquido());
                        Log.v("teste", "Aliquota: " + c.getAliquota());
                        Log.v("teste", "Deducao: " + c.getDeducao());


                }



            }


        }

*/



















