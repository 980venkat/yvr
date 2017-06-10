import groovy.json.JsonSlurper 


URL url;
url = new java.net.URL("http://jenkins-us1n.cloud.pw.ge.com/jenkins/job/Chef-Removal/buildWithParameters?token=wNs30vlOYr16eDl3q4TH8ttp5jC6n47G&Instance_id=testyv");
//def authString = "jenkins-stg:jenkins-stg";
String authStringEnc = "amVua2lucy1jaGVmOmNhYjlmNmRmNjczZTY0ZDA0ODAzNmMwZDQ1YzQyMmEx"

//byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
//String authStringEnc = new String(authEncBytes);

URLConnection connection = url.openConnection();
connection.setRequestProperty("Authorization", "Basic " + authStringEnc);
connection.setRequestMethod("POST");

connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
connection.setRequestProperty("Accept", "application/json");

connection.connect();

println(connection.getResponseCode());
println(connection.getResponseMessage());

connection.disconnect();






