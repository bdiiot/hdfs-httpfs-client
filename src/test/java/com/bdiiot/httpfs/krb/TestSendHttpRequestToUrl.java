package com.bdiiot.httpfs.krb;

import com.bdiiot.com.httpfs.krb.utils.RequestKerberosUrlUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;

import java.io.InputStream;
import java.util.Arrays;


public class TestSendHttpRequestToUrl {
    private static Log logger = LogFactory.getLog(TestSendHttpRequestToUrl.class);

    public static void main(String[] args) {
        String user = "yourUser@CDN.NET";
        String keytab = "/home/spark/conf/yourUser.keytab";
        String krb5Location = "/etc/krb5.conf";

        try {
            RequestKerberosUrlUtils restTest = new RequestKerberosUrlUtils(user, keytab, krb5Location, false);

            // refer to https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/WebHDFS.html#Open_and_Read_a_File
            // list dir
            String url_liststatus = "http://activeNamenodeHost:14000/webhdfs/v1/user/cdnportal/data/release?op=liststatus";
            // location
            String url_get_block_locations = "http://activeNamenodeHost:14000/webhdfs/v1/user/cdnportal/data/release/world.txt?op=get_block_locations";

            HttpResponse response = restTest.callRestUrl(url_liststatus, user);
//          HttpResponse response = restTest.callRestUrl(url_get_block_locations,user);

            InputStream is = response.getEntity().getContent();
            System.out.println("Status code " + response.getStatusLine().getStatusCode());
            System.out.println("message is :" + Arrays.deepToString(response.getAllHeaders()));
            System.out.println("string：\n" + new String(IOUtils.toByteArray(is), "UTF-8"));

        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }
}