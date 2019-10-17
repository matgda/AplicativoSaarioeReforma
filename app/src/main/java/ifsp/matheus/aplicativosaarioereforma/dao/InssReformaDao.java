package ifsp.matheus.aplicativosaarioereforma.dao;

import java.util.Arrays;
import java.util.List;

import ifsp.matheus.aplicativosaarioereforma.model.Inss;


public class InssReformaDao {

    public List<Inss> inssList() {

        //Sera usada no caso de ser servidor privado e publicos admitidos após 04/02/2013
        return Arrays.asList(
                new Inss(0.1, 998, 0.075, 0),
                new Inss(998.01, 2000, 0.09, 14.97),
                new Inss(2000.01, 3000, 0.12, 74.97),
                new Inss(3000.01, 5839.45, 0.14, 134.97),
                new Inss(5839.46, Double.MAX_VALUE, 0.14, 134.97)
        );
    }

    //No caso dos servidores públicos admitidos antes de 04/02/2013 e não optantes do regime de previdência
    public List<Inss> inssList2() {

        return Arrays.asList(
                new Inss(0.1, 998, 0.075, 0),
                new Inss(998.01, 2000, 0.09, 14.97),
                new Inss(2000.01, 3000, 0.12, 74.97),
                new Inss(3000.01, 5839.45, 0.14, 134.97),
                new Inss(5839.46, 10000, 0.145, 164.17),
                new Inss(10000.01, 20000, 0.165, 364.17),
                new Inss(20000.01, 39000, 0.190, 864.18),
                new Inss(39000.01, Double.MAX_VALUE, 0.22, 2034.18)
        );

    }
}

