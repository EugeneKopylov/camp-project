application path: /bootcamp

database login: root, password: 1234

tomcat username: tomcat, password: tomcat

application endpoints:

    * /get-one{id} (get one user by id)
    * /{page} (get ten users by one page sorted by email (first page is 0))
    * /add-user (add user)

example of json to add user:

{
"firstName": "Alex",
"secondName": "Alexandrov",
"surname": "Alexandrovich",
"email": "alex@gmail.com",
"role": "Administrator"
}