package ifsp.matheus.aplicativosaarioereforma.dao;

import java.util.Arrays;
import java.util.List;


import ifsp.matheus.aplicativosaarioereforma.model.Irpf;

public class IrpfReformaDao {


    public List<Irpf> irpfList() {
        //Irpf será pelo setor privado e publico o mesmo não possui alteracao;
        return Arrays.asList(
                new Irpf(0.1, 1903.98, 0, 0),
                new Irpf(1903.99, 2826.65, 0.075, 142.80),
                new Irpf(2826.66, 3751.05, 0.15, 354.80),
                new Irpf(3751.06, 4664.68, 0.225, 636.13),
                new Irpf(4664.68, Double.MAX_VALUE, 0.275, 869.36)


        );


    }


}

