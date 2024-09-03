
package mongo01;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Principal {

  
    public static void main(String[] args) {
        String database = "campusfp";
        String servername = "localhost";
        int puerto = 27017;
        
        
        
        DB conexion; //importar el driver
        MongoClient mc;
        
        mc = new MongoClient(servername,puerto);
        conexion= mc.getDB(database);
        System.out.println("OK: CONEXION");
        
        System.out.println("LEER TODOS LOS DOCUMENTOS DE UNA COLECCION");
        
        DBCollection alumno = conexion.getCollection("alumno");
        
        //1.OBTENER EL NUMERO DE DOCUMENTO DE LA COLECCION
        int cantidadDocumentos = (int)alumno.getCount();
        System.out.println("Cantidad Documentos: " + cantidadDocumentos);
        
        //2 MOSTRAR LOS DOCUMENTOS DE LA COLECCION
        DBCursor cursor = alumno.find();
        while(cursor.hasNext()){  //RECUPERAR EL DOCUMENTO SI LO TIENE LO RECUPERA
            System.out.println(cursor.next().toString());
        }
    }
}
