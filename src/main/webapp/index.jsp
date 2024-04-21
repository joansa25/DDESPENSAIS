
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Logins</title>
  <link rel="stylesheet" href="pages/vista/css/estiloindex.css">

</head>
<body>

  <div class="login-container">
    <h2>DESPENSA IssS</h2>
    <form id="login-Form" class="login-form" action="/MIDESPENSAIS/registro" method="post">
      <label for="username">Usuario</label>
      <input type="text" name="username" id="username" required>
      <label for="password">Contraseña</label>
      <input type="password" name="password" id="password" required>
      <input type="submit" value="ENTRAR">
    </form>
  </div>

</body>
</html>