### Debug SSL in Java

```
-Djavax.net.debug=ssl,handshake
```

### Import pem file into truststore

```
keytool -import -alias <<name>> -keystore truststore -file <<name.pem>>
```

### Import private key in keystore

```
openssl pkcs12 -export -in <<XXXX.pem>> -inkey <<XXXX.key>> -certfile <<XXXX.pem>> -out XXXX.p12 -name xxxx

keytool -importkeystore -v -noprompt -srckeystore  XXXX.p12 -srcstorepass XXXX -destkeystore XXXX -deststorepass XXXX


```
