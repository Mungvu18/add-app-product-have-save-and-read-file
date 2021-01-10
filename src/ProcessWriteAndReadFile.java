import java.io.*;

public class ProcessWriteAndReadFile {
    public static void writeFile(Object obj,String namePath){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(namePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                fos.close();
                oos.close();
            }catch (Exception e){}
        }
    }
    public static Object readFile (String namePath){
        Object obj = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(namePath);
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                fis.close();
                ois.close();
            }catch (Exception e){}
        }
        return obj;
    }
}
