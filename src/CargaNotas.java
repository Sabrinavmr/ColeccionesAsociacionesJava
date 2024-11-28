import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //variable que permita contener un un conjunto de Alumnos
        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean salirCargaAlumnos = false;




        do {
            Alumno alumno = new Alumno();

            System.out.println("ÏNGRESE DATOS DEL ALUMNO");
            System.out.println("INGRESE NOMBRE COMPLETO: ");
            String nombreCompleto = sc.nextLine();
            alumno.setNombreCompleto(nombreCompleto);

            System.out.println("INGRESE LEGAJO: ");
            long legajo = sc.nextLong();
            sc.nextLine();
            alumno.setLegajo(legajo);

            boolean salirCargaNotas = false;
            //creamos un arraylist para guardar notas
            ArrayList<Nota> notas = new ArrayList<>();

            do {

                Nota nota = new Nota();
                System.out.println("INGRESE NOMBRE CATEDRA: ");
                String nombreCatedra =  sc.nextLine();
                nota.setCatedra(nombreCatedra);

                System.out.println("INGRESE NOTA: ");
                double not = sc.nextDouble();
                sc.nextLine();
                nota.setNotaExamen(not);

                System.out.println("DESEA SALIR DE LA CARGA DE NOTAS? s/n ");
                String opc = sc.nextLine();

                if (opc.equalsIgnoreCase("s")){
                    System.out.println("Saliendo de carga de notas...");
                    salirCargaNotas = true;
                }

                //guardamos nota en la Arraylist notas
                notas.add(nota);
                alumno.setNotas(notas);


            }while (!salirCargaNotas);

            System.out.println("DESEA SALIR DE CARGA DE ALUMNOS? s/n");
            String opc2 = sc.nextLine();


            if (opc2.equalsIgnoreCase("s")){
                System.out.println("Saliendo carga de alumnos...");
                salirCargaAlumnos = true;
            }

            alumnos.add(alumno);

        }while (!salirCargaAlumnos);


        for (Alumno alumno : alumnos){
            System.out.println("Datos Alumno: ");
            System.out.println("Nombre Completo: "+alumno.getNombreCompleto());
            System.out.println("Legajo: "+alumno.getLegajo());


            for (Nota not : alumno.getNotas() ){
                System.out.println("Catedra: "+not.getCatedra());
                System.out.println("Nota: "+not.getNotaExamen());
            }
            System.out.println("El promedio del alumno es :"+calcularPromedio(alumno.getNotas()) );
        }
    }


    public static double calcularPromedio(ArrayList<Nota> notas){

        double suma = 0;

        for (Nota nota: notas){
            suma += nota.getNotaExamen();
        }

        //?0 es como if else pero dentro de una linea
        return notas.isEmpty() ? 0 : suma/notas.size();
    }
}
