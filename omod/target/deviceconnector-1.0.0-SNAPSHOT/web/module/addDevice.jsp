<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding a new device</title>
</head>
<body>
<form method="post">
<fieldset>
<table>
    <tr>
        <td><openmrs:message code="general.name"/></td>
        <td>
            <spring:bind path="device.name">
                <input type="text" name="name" value="${status.value}" size="35" />
                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
            </spring:bind>
        </td>
    </tr>
    <tr>
        <td valign="top"><openmrs:message code="general.note"/></td>
        <td valign="top">
            <spring:bind path="device.note">
                <textarea name="note" rows="3" cols="40" onkeypress="return forceMaxLength(this, 1024);" >${status.value}</textarea>
                <c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
            </spring:bind>
        </td>
    </tr>
</table>
<br />
<input type="submit" value="<openmrs:message code="device.save"/>" name="save">
</fieldset>
</form>
</body>
</html>