import config.ConexionOracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        String sql = "{call INSERTAR_REGISTRO(?, ?)}";

        try (Connection conexion = ConexionOracle.conectar();
             CallableStatement procedimiento =
                     conexion.prepareCall(sql)) {

            System.out.println("======================================");
            System.out.println(" JAVA + ORACLE 19C ");
            System.out.println(" INSERTANDO 79 REGISTROS ");
            System.out.println("======================================");
            System.out.println();

            for (int i = 1;i <=79; i++) {

                String nombre = "Registro " + i;
                int edad = 20 + (i % 40);

                procedimiento.setString(1, nombre);
                procedimiento.setInt(2, edad);
                procedimiento.execute();

                System.out.println(
                        "Registro " + i +
                                " insertado correctamente -> " +
                                nombre +
                                " | Edad: " + edad
                );
            }

            System.out.println();

            System.out.println("======================================");
            System.out.println(" PROCESO FINALIZADO");
            System.out.println("======================================");

            consultarRegistros(conexion);

        } catch (Exception e) {

            System.out.println();

            System.out.println(
                    "ERROR AL EJECUTAR EL PROCESO:"
            );

            e.printStackTrace();
        }
    }

    private static void consultarRegistros(Connection conexion) {   
    }
}