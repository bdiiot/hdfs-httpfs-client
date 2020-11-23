package com.bdiiot.httpfs.client.httpclient;

public class TestHttpfsClient {
    public static void main(String[] args) {
        HttpFSClient client = new HttpFSClient();
        client.initCookie();

        // 获取当前用户的目录
        client.get("", "op=gethomedirectory&user.name=hdfs");

        // 上传文件
//       client.put("/tmp/test2", "op=CREATE&user.name=hdfs&buffersize=1000");
//		 client.upload("/tmp/test/pom.xml", "op=CREATE&user.name=hdfs&buffersize=1000&data=true", "pom.xml");
//
//		 // 删除文件
//		 client.delete("/test2/demo.xml", "op=DELETE&user.name=hdfs");
//
//		 // 创建目录
//		 client.put("/test2/test9", "op=MKDIRS&user.name=hdfs");
//
//		 // 读取文件
//		 client.get("/test/data.txt", "op=OPEN&user.name=hdfs&buffersize=10000&data=true",true);

        // 获取文件列表信息
        String result = client.get("/tmp", "op=LISTSTATUS&user.name=hdfs");
        System.out.println(result);
    }
}