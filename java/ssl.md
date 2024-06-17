### Debug SSL in Java

```
-Djavax.net.debug=ssl,handshake
```

### Import pem file into truststore

```
keytool -import -alias <<name>> -keystore truststore -file <<name.pem>>
```
