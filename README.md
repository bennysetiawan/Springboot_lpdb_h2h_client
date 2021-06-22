# Pos Authorization

## Create Database

```terminal
$ mysql -u root -p
mysql> CREATE USER 'jepesoftUser'@'%' IDENTIFIED BY 'jepesoftSol5Wak';
mysql> CREATE DATABASE pos_jepesoft_user CHARACTER SET utf8 COLLATE utf8_unicode_ci;
mysql> GRANT ALL PRIVILEGES ON pos_jepesoft_user.* TO 'jepesoftUser'@'%';
```

## Create Keystore

```terminal
jepesoft@jepesoft:/media/jepesoft/DATA/JEPESOFT/POS/pos-authorization$ keytool -genkey -alias lpdb_h2h -keystore src/main/resources/lpdb_h2h.pfx -storetype pkcs12 -keyalg RSA
Enter keystore password: lpdb_h2h
Re-enter new password: lpdb_h2h
What is your first and last name?
  [Unknown]:  LPDB JAKARTA
What is the name of your organizational unit?
  [Unknown]:  LPDB
What is the name of your organization?
  [Unknown]:  CREDIT
What is the name of your City or Locality?
  [Unknown]:  JAKARTA
What is the name of your State or Province?
  [Unknown]:  JAKARTA
What is the two-letter country code for this unit?
  [Unknown]:  ID
Is CN=LPDB JAKARTA, OU=LPDB, O=CREDIT, L=JAKARTA, ST=JAKARTA, C=ID correct?
  [no]:   yes
```

## Login Auth Code
localhost:8086/oauth/authorize?client_id=lpdb-client&grant_type=authorization_code&response_type=code&redirect_uri=localhost:8087

## References
1. https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/
2. https://www.baeldung.com/jpa-one-to-one
3. https://www.tutorialspoint.com/spring_boot/spring_boot_application_properties.htm

## Cors
1. https://developer.okta.com/blog/2019/05/13/angular-8-spring-boot-2