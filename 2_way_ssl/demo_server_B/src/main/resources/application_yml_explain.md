The configuration is for a server application that enables SSL/TLS (HTTPS) communication; break down of configuration properties:

- `server.port: 9090`: This sets the server port to 9090. The server will listen for incoming connections on this port.

- `server.ssl.enabled: true`: This enables SSL/TLS support for the server.

- `server.ssl.client-auth: need`: This property specifies that client authentication is required. The server will request a client certificate during the SSL handshake and only allow connections from clients that present a valid certificate.

- `server.ssl.key-store: classpath:keystore/server_B_keystore.p12`: This sets the path to the keystore file that contains the server's private key and corresponding certificate. The keystore file is located in the classpath under the `keystore` directory and named `server_B_keystore.p12`.

- `server.ssl.key-store-password: server_B_keystore`: This sets the password for accessing the keystore file. The password is required to unlock the keystore and access the private key and certificate.

- `server.ssl.key-store-type: PKCS12`: This specifies the type of the keystore file. In this case, it is in the PKCS12 format, which is a commonly used format for keystore files.

- `server.ssl.key-alias: server-b`: This specifies the alias used to identify the server's key entry within the keystore. The alias allows the server to locate the correct private key and certificate within the keystore if there are multiple entries.

- `server.ssl.key-store-provider: SUN`: This sets the provider for the keystore. In this case, it is set to the SUN provider, which is the default provider for the Java Runtime Environment.

- `server.ssl.trust-store: classpath:keystore/server_B_keystore.p12`: This sets the path to the truststore file. The truststore contains trusted certificates, typically certificates of trusted Certificate Authorities (CAs) or self-signed certificates of other parties that the server needs to trust. The truststore file is located in the classpath under the `keystore` directory and named `server_B_keystore.p12`. In this configuration, the same keystore file is used as the truststore.

- `server.ssl.trust-store-password: server_B_keystore`: This sets the password for accessing the truststore file.

- `server.ssl.trust-store-type: PKCS12`: This specifies the type of the truststore file. In this case, it is in the PKCS12 format, similar to the keystore file.

Overall, this configuration ensures that the server uses SSL/TLS for secure communication, requires client authentication, and specifies the keystore and truststore files containing the necessary cryptographic material and trusted certificates.


# [medium document link](https://medium.com/@niral22/2-way-ssl-with-spring-boot-microservices-2c97c974e83#id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjJkOWE1ZWY1YjEyNjIzYzkxNjcxYTcwOTNjYjMyMzMzM2NkMDdkMDkiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJuYmYiOjE2ODUxMDIwODAsImF1ZCI6IjIxNjI5NjAzNTgzNC1rMWs2cWUwNjBzMnRwMmEyamFtNGxqZGNtczAwc3R0Zy5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsInN1YiI6IjEwMzA4MzY0NDE1ODM3NDA4ODY0OCIsImVtYWlsIjoiYWtoaWxhZGlnYTEwQGdtYWlsLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJhenAiOiIyMTYyOTYwMzU4MzQtazFrNnFlMDYwczJ0cDJhMmphbTRsamRjbXMwMHN0dGcuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJuYW1lIjoiQWtoaWwgQWRpZ2EiLCJwaWN0dXJlIjoiaHR0cHM6Ly9saDMuZ29vZ2xldXNlcmNvbnRlbnQuY29tL2EvQUFjSFR0Y3d1T09HNkx6Uk9XMzlWTlJXX3hDZTFSRW5lalFEY2FuQm10MTVQUT1zOTYtYyIsImdpdmVuX25hbWUiOiJBa2hpbCIsImZhbWlseV9uYW1lIjoiQWRpZ2EiLCJpYXQiOjE2ODUxMDIzODAsImV4cCI6MTY4NTEwNTk4MCwianRpIjoiMTU0Zjg5NTNhM2NkNGFmOWRhOGU1OTIxZjA2Mjc5ZGNjZDQ3YmU4ZSJ9.u_Vi67A_5jkBEokXxWCewru0Tg0CrLhjWHu7UW-ds-uOzC29DIwGA0kMY6St8zF8Eey5vV5byWe2uKicdUk8sriyP42v7hBCvWdftFwgl1wt9lha8QLl7R7z_rRcOg3A3ZSKYTrpuHlCqnw3cqLXWhJ7Hm-Vm25R1WCoQk2Gb_Ct_Y_8Q3882bcocqoPLkTQjaVRb8l2GziAHm_k3rJw1k_aFh7V6PYWn4vYwFRmkJb-0TbyNlP1GGfXxLDKNKXLGMDkmanWseyHpHnBMmRFxwGjJ1LoDnMQyxyj810sR6K2sLR5_TKelPLnPYU3p66oL0sWh7FjqRQrmJisPTuSPg)
```cmd
keytool -list -keystore nt-ms.jks
```
