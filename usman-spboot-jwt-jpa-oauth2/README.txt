Help: https://www.pixeltrice.com/spring-boot-security-using-oauth2-with-jwt/

Schema and Table Creation:
-------------------------
CREATE TABLE USERS (ID INT PRIMARY KEY, USERNAME VARCHAR(50), PASSWORD VARCHAR(70));

INSERT INTO USERS (ID, USERNAME,PASSWORD) VALUES (1, 'admin@pixeltrice.com','$2a$08$fL7u5xcvsZl78su29x1ti.dxI.9rYO8t0q5wk2ROJ.1cdR53bmaVG');
INSERT INTO USERS (ID, USERNAME,PASSWORD) VALUES (2, 'jpauser','$2a$10$z2QG9tYQiffuJhNW1YhRu.2VJ6/3E/vS3mltsdYwtTUbokpM4Lmce');

How to run:
Use Curl in postman:
curl --location --request POST 'http://localhost:8090/oauth/token' \
--header 'Authorization: Basic dXNtYW5qcGE6dXNtYW5qcGFAc2VjcmV0IWtleQ==' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=18422766D5648C19E0DD805C2253A4C4' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=jpauser' \
--data-urlencode 'password=password'

OR 
Goto Postman and create a new API POST request:
Use URL: http://localhost:8090/oauth/token

Goto Autorization tab: Choose Basic Auth:
Enter username: usmanjpa    [used in ConfigAuth2 file]
	password: usmanjpa@secret!key [used in ConfigAuth2 file]
	
Go to body tab: Choose x-www-form-urlencoded
Enter the followin:
grant_type: password
username: jpauser [saved in table as username]
password: password [saved in table as password encrypted]

Now hit the Send button: It will generate the access_token with details as;

{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MjI1NjI1MzUsInVzZXJfbmFtZSI6ImpwYXVzZXIiLCJhdXRob3JpdGllcyI6WyJST0xFX1NZU1RFTUFETUlOIl0sImp0aSI6IlRnY0ZfbkR2d3hkaXFhWTFYdUdETXlURG5FWSIsImNsaWVudF9pZCI6InVzbWFuanBhIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl19.JJkzHijyHt2xwlBJQ1BK6mKL4KzZIpBPMyJ6dZ_fp25GnuFrcJw9qUSdcHzOCN2z-ewHarRZB0k5pIkVuUljv8Uu9CmwBEFt81Knvk7VVzlligJgGgQfaZtJBsZtLHBrRqya13famyTt2MIZohlQ0wG7CyC2h1DkqSwEraXhjCNcB6IMX327AbTLwZgaCLCdDEq6S5P2qMlXXVq8hvGAkyie__JEmaYT7dnGSkB-_r1ZaWRsrtY8ge94a_ud3W1kvxRtsDTv69B0CQozbG8-1zXHZ07TO-OFijXAyn4FVu3G0BDRotXdzY3OVgaUjqJI91d8v7wpAIFCxstmOS1mrA",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqcGF1c2VyIiwic2NvcGUiOlsicmVhZCIsIndyaXRlIl0sImF0aSI6IlRnY0ZfbkR2d3hkaXFhWTFYdUdETXlURG5FWSIsImV4cCI6MTYyMjU2MjUzNSwiYXV0aG9yaXRpZXMiOlsiUk9MRV9TWVNURU1BRE1JTiJdLCJqdGkiOiJjcC1rZkhnX3lhYjA3blJfMkQ1cExZYy1UTzgiLCJjbGllbnRfaWQiOiJ1c21hbmpwYSJ9.nr2w8-L5NPIdt9hHBW1BQrA4YblTbHlaKpOAtKrAnK5ABLwwpMTOaX-YwpopqwYQ_ZHXWijRUY5olpHOybmrifU_Mbw3rFk6yo5fJvrGwDpyLnfwvt7ml13BxAF_btSmfBEBdgo5kJpV5ClHwmNKrV2b0rzjuGMvNmvQROZ2dXtlnjH3YXXAdoJa3fhd_5vVZS0nu2QN564M6I5tC7Vm7bcKiAvWg_YaP-DVBvkIFDXmkQ-LdlzOWpslwZ7oZQYP6BApDwtnqAbpTQEUkk4MYC0_AXdFV2ZJKEpw1ORcXro8VLV9P73DyOuUVydI9qDlI-dDbknjvukcbdWD8TjZHA",
    "expires_in": 19999,
    "scope": "read write",
    "jti": "TgcF_nDvwxdiqaY1XuGDMyTDnEY"
}

Now open new request tab : Create a GET request with URL: http://localhost:8090/api/hello
Got Headers tab and enter the:
Authorization: Bearer wrnwkerewr09we0r9iwofjlsjfp0iwufjweo.... (access_token)
Content_type: application/json

Hit the request: You will get the response;




OpenSSL RSA Key for MAC-OS
—————————————-------------

1. Generate Key-pair: $ openssl genrsa -out mafcarrefour.key 2048

2. Extract Public Key: $ openssl rsa -in mafcarrefour.key -pubout -out mafcarrefour_public.key

It will be saved in $ default User directory. [say: /farkalitusman]

Optional commands:

3. Generate CSR file: $ openssl req -new -key mafcarrefour.key -out mafcarrefour.csr
	Enter input values: Country, Email, Organisation name, Common web url etc.
	Password: Optional

	Verify Certificate: $ openssl req -text -in mafcarrefour.csr -noout -verify

4. Generate Self Signed Certificate: $ openssl x509 -in mafcarrefour.csr -out mafcarrefour.crt -req -signkey mafcarrefour.key -days 365


What is OAuth2?
It is an authorization framework that provides some standardized rules for authorization. 
It was first created in 2006 and the first version was OAuth.

The main goal of the OAuth2 framework is to provide a simple flow of authorization that can 
be implemented on the web application, mobile phones, desktop application, and even on the 
devices used in our living rooms.

OAuth2 specify the four roles on server side:
Resource Owner.
Resource Server.
Authentication Server.
Client.

Resource Owner: The person or any entity that can provide access to the protected resources.

Resource Server: It can be your application, which provides an access token to the end-user or 
	client so that they can access the protected resource.

	Note: Here protected resources refer to the API, web pages, etc which you developed or created, 
			more technically we can say protected resources is HTTP Endpoints, the resources which are static.

Authorization Server: It is a centralized server that acts as an intermediate between the 
		Resource owner and client. This server is only responsible for providing access to the client after successful authentication.
 
	Note: It may be possible that the Resource Server and Authorization server can be the same. 
			Single Authorization Server can provide access tokens to more than one resource server.

Client: It is the one who requested the Resource owner or Authorization Server to provide access 
		to the protected resources such as Apis or HTTP Endpoints.


 
Here the client can be UI/UX also or when you search anything on the internet, then the URL 
which you enter on the browser will send some request to the Resource Server.

JWT Token
The full form of JWT is JSON Web Token. It is like an entry pass to the client which Authorization Server 
verify before providing access to protected resources such as API or HTTP Endpoints.


Advantages of using OAuth2 with JWT
It is more popular in case microservices architecture where the single authentication server can be used for multiple resources server.
Since the format of the token is JSON so it can be easily understood and managed on the client-side.
