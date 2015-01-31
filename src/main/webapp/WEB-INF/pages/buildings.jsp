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
            <h1>Buildings</h1>
            <form:form method="post" modelAttribute= "building" action="addBuilding" class="form-horizontal">
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
                    <input type="submit" value="Add Building" class="btn"/>
                    </form:form>
                </div>
            </div>

            <c:if test="${!empty buildings}">
                <h3>Buildings</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Address</th>
                        <th>Floors</th>
                        <th>Total Square Feet</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${buildings}" var="building">
                        <tr>
                            <td>${building.name}</td>
                            <td>${building.address}</td>
                            <td>
                                <input name="newFloors" type="text"/>
                            </td>
                            <td>${building.area}</td>
                            <td>
                                <form action="update/${building.id}" method="post"><input type="submit" class="btn btn-mini" value="Update"/></form>
                            </td>
                            <td>
                                <form action="delete/${building.id}" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>