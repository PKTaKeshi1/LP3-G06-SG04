package sqlite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Actividad {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:ejemplo.db");
            if (con != null) {
                System.out.println("Se creó y/o abrió la base de datos.");
            }
            // Creación de la tabla
            Statement stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS emp (id INTEGER PRIMARY KEY, name TEXT, age INTEGER);");
            // Operaciones CRUD (Create, Read, Update, Delete) y TRANSACCIONES 
            // 1. Inserción (Insert) usando PreparedStatement
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO emp (id, name, age) VALUES (?, ?, ?)");
            insertStmt.setInt(1, 1);
            insertStmt.setString(2, "Carlos");
            insertStmt.setInt(3, 30);
            insertStmt.executeUpdate();
            System.out.println("Registro insertado.");
            // 2. Recuperación (Read)
            PreparedStatement selectStmt = con.prepareStatement("SELECT * FROM emp");
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("Datos actuales en la tabla emp:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
            }
            // 3. Actualización (Update) usando PreparedStatement
            PreparedStatement updateStmt = con.prepareStatement("UPDATE emp SET age = ? WHERE id = ?");
            updateStmt.setInt(1, 35); // Nueva edad
            updateStmt.setInt(2, 1);  // ID del registro a actualizar
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println(rowsUpdated + " registro(s) actualizado(s).");
            // 4. Eliminación (Delete) usando PreparedStatement
            PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM emp WHERE id = ?");
            deleteStmt.setInt(1, 5); // ID del registro a eliminar
            int rowsDeleted = deleteStmt.executeUpdate();
            System.out.println(rowsDeleted + " registro(s) eliminado(s).");
            // Ejemplos adicionales de manejo de transacciones
            try {
                con.setAutoCommit(false); // Iniciar transacción
                // Ejemplo de inserciones dentro de una transacción
            	Statement transactionInsertStmt =con.createStatement();  
                transactionInsertStmt.executeUpdate("insert into emp values(4,'OSCAR',17)"); 
                transactionInsertStmt.executeUpdate("insert into emp values(5,'MARIA',18)");
            	con.rollback(); // NO GUARDAR REGISTRO
                transactionInsertStmt.executeUpdate("insert into emp values(6,'JUAN',27)"); 
                transactionInsertStmt.executeUpdate("insert into emp values(7,'DAYANA',28)");
                con.commit();//  GUARDAR REGISTRO
                System.out.println("Transacción completada y registros guardados.");
            } catch (Exception e) {
                System.out.println("Error en la transacción. Ejecutando rollback...");
                con.rollback(); // Revertir cambios si ocurre un error
            }
            // Recuperar nuevamente para verificar los datos después de la transacción
            ResultSet rsFinal = stmt.executeQuery("SELECT * FROM emp");
            System.out.println("Datos finales en la tabla emp:");
            while (rsFinal.next()) {
                System.out.println(rsFinal.getInt("id") + " " + rsFinal.getString("name") + " " + rsFinal.getInt("age"));
            }
            con.close(); // Cerrar la conexión
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
