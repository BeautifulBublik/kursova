
<html>
<head>
  <title>Login</title>
</head>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f8f8f8;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  .login-container {
    width: 300px;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    text-align: center;
  }
  .login-container h2 {
    margin: 0 0 20px 0;
    font-size: 24px;
    color: #333;
  }
  .login-container label {
    display: block;
    margin-bottom: 15px;
    text-align: left;
  }
  .login-container input[type="text"],
  .login-container input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ddd;
    border-radius: 4px;
    font-size: 16px;
    box-sizing: border-box;
  }
  .login-container button {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  .login-container button:hover {
    background-color: #0056b3;
  }
</style>
<body>
<div class="login-container">
  <h2>Login</h2>
  <form action="j_security_check" method="post">
    <label>
      <input type="text" name="j_username" placeholder="Username" required>
    </label>
    <label>
      <input type="password" name="j_password" placeholder="Password" required>
    </label>
    <button type="submit">Login</button>
  </form>
</div>
</body>
</html>