package uff.ic.lleme.tcc00328.s20212.exercicio.exercicio1;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class LuizAndre {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream output = new FileOutputStream("saida.txt", true);
        OutputStreamWriter writer = new OutputStreamWriter(output);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("" + 23234523);

        int d = 2;
        
        System.out.printf("%d",d);

    }
}
