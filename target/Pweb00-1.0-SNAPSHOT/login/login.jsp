<%-- 
    Document   : login
    Created on : 9 gen 2022, 16:21:46
    Author     : LucaRaveri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous"
            />
    </head>
    <body>

    <div class="container-sm">
      <form class="border rounded p-5" action="j_security_check" method="post" name="loginForm" style="width:40%; margin:auto; margin-top:90px;">
      <h1 style="text-align:center; margin-bottom:20px;">Login Form</h1>
        <div class="form-group mt-4">
          <label for="user">Username</label>
          <input type="text" class="form-control" id="j_username" placeholder="Enter Username" name="username" size="20">
        </div>
        <div class="form-group mt-4">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="j_password" placeholder="Enter Password" name="password" size="20">
        </div>
        <button style="width:100%" type="submit" value="Login" class="btn btn-primary mt-4 pb-2 pt-2">Login</button>
      </form>
    </div>
        
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
