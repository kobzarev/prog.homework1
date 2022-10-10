<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
<table>
    <tr>
        <td>
            <fieldset>
                <legend>Sign Up:</legend>
                    <form action="reg" method="post">
                        <table>
                            <tr>
                                <td>First Name:</td>
                                <td><input type="text" name="firstName"/></td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td><input type="text" name="lastName"/></td>
                            </tr>
                            <tr>
                                <td>Age:</td>
                                <td><input type="number" name="age"/></td>
                            </tr>
                            <tr>
                                <td>Login:</td>
                                <td><input type="text" name="login"/></td>
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="password" name="password"/></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Sign Up"/></td>
                            </tr>
                        </table>
                    </form>
            </fieldset>
        </td>
        <td>
            <fieldset>
                <legend>Sign In:</legend>
                <form action="login" method="post">
                    <table>
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="login"/></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Login"/></td>
                        </tr>
                    </table>
                </form>
            </fieldset>
        </td>
    </tr>
</table>


<h1></h1>
<br/>

</body>
</html>