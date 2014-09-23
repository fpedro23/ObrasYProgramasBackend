import javax.swing.*;
import java.util.*;
import java.io.*;
import modelObrasYProgramas.*;

public class App
{


	public static void main(String args[])
	{
        ObrasAD obrasAD = new ObrasAD();
        Obra obra;
		obra = obrasAD.generarFichaTecnicaObra("CFE01");
        System.out.println(obra.toString());

	}
}