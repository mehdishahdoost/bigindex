### Decode certificates in kubeconfig file

```
grep 'client-certificate-data' kubefile | awk '{print $2}' | base64 -d | openssl x509 -text
```
