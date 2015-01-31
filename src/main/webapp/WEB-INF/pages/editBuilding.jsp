<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Badass Buildings</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="resources/css/bootstrap.min.css" rel="stylesheet" rel="stylesheet" type="text/css" />
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <link href="resources/css/bootstrap-editable.css" rel="stylesheet">
    <script src="resources/js/bootstrap-editable.min.js"></script>

</head>

<body>

<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <h1>Edit One Building</h1>
            <c:if test="${message != null}">
                <div class="alert alert-danger">${message}</div>
            </c:if>
            <form:form method="post" modelAttribute= "building" action="${pageContext.request.contextPath}/saveBuilding" class="form-horizontal">

            <div class="control-group">
                <form:label cssClass="control-label" path="name">Building Id:</form:label>
                <div class="controls">
                    <td class="td"><b>Id:</b></td>
                    <td class="td"><input type="text" name="id" value="${building.id}" readonly/></td>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="name">Building Name:</form:label>
                <div class="controls">
                    <form:input path="name"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="address">Address:</form:label>
                <div class="controls">
                    <form:input path="address"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="floors">Floors:</form:label>
                <div class="controls">
                    <form:input path="floors"/>
                </div>
            </div>
            <div class="control-group">
                <form:label cssClass="control-label" path="area">Total Square Feet:</form:label>
                    <div class="controls">
                        <form:input path="area"/>
                    </div>
            </div>
            <div class="control-group">
                <div class="controls">
                        <td class="td"><input type="submit" value="Save" />
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<form modelAttribute= "${building}" action="${pageContext.request.contextPath}/editBuilding/${building.id}/editFloors" method="post"><input type="submit" class="btn btn-mini" value="Edit Floors"/></form>
</body>
</html>