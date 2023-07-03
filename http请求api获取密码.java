
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

class zhlhlf{
    public static void main(String[] args) {
        String url = "https://xm.n4o.cn/dp/api_key.php";
        String key = "yklgjfq8zbkw19tojmq04feq5y2pcfb9";
        String data = "key="+key;

        try {
            URL a = new URL(url);
            HttpURLConnection b = (HttpURLConnection) a.openConnection();
            b.setRequestMethod("GET");
            b.setDoOutput(true);
            b.setReadTimeout(300000); 
            b.setRequestProperty("ua", "by zhlhlf"); //设置请求头
            b.getOutputStream().write(data.getBytes());
            b.connect();

            print(b.getResponseCode()); //获取状态码
            
/*             Iterator<Entry<String, List<String>>> r = b.getHeaderFields().entrySet().iterator(); // 使用迭代器输出所有响应头
            while(r.hasNext()){
                Entry<String, List<String>> e = r.next();
                
                print(e.getKey()+":    "+e.getValue().iterator().next());
            } */

/*             Iterator<Entry<String,List<String>>> f = b.getRequestProperties().entrySet().iterator(); //获取请求头
            while(f.hasNext()){
                Entry<String,List<String>> e = f.next();
                print(e.getKey()+":    "+e.getValue().iterator().next());
            } */

            print(new String(b.getInputStream().readAllBytes()));
            b.disconnect();
        } catch (Throwable e) {print("erro");}
    }

    static void print(Object a){
            System.out.println(a);
    }

}
