import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;

class zhlhlf extends Thread{
    public static void main(String[] args) {
        zhlhlf a = new zhlhlf();
        a.start();
        zhl b = new zhl();
        b.start();
    }

    public void run(){
        try {
            Socket a = new Socket("127.0.0.1",100);
            a.setSoTimeout(3000);
            DataInputStream a1 = new DataInputStream(a.getInputStream());
            DataOutputStream a2 =  new DataOutputStream(a.getOutputStream());
            for(int i =0;i<5;i++){
                sleep(2000);
                a2.writeUTF("connect succeed  "+i);
                print(a1.readUTF());
            }

        } catch (Throwable e) {}

    }

    static void print(Object a){
        System.out.println(a);
    }
}

class zhl extends Thread{
    public void run(){
        try {
            ServerSocket b = new ServerSocket(100);
            b.setSoTimeout(3000);
            Socket a = b.accept();
            DataInputStream a1 = new DataInputStream(a.getInputStream());
            DataOutputStream a2 =  new DataOutputStream(a.getOutputStream());
            for(int i =0;i<5;i++){
                sleep(2000);
                a2.writeUTF("Server yes  "+i);
                zhlhlf.print(a1.readUTF());
            }
        } catch (Throwable e) {}
    }
}
